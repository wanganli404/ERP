package com.hnun.erp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Orderdetail;
import com.hnun.erp.bean.OrderdetailExample;
import com.hnun.erp.bean.Orders;
import com.hnun.erp.bean.Storedetail;
import com.hnun.erp.bean.StoreOper;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.OrderdetailMapper;
import com.hnun.erp.mapper.OrdersMapper;
import com.hnun.erp.mapper.StoreOperMapper;
import com.hnun.erp.mapper.StoredetailMapper;
import com.hnun.erp.service.OrderDetailService;



@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<Orderdetail> implements OrderDetailService{
	
	private OrderdetailMapper orderdetailMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private StoredetailMapper storeDetailMapper;
	
	@Autowired
	private StoreOperMapper storeOperMapper;
	
	@Autowired
	public void setDepMapper(OrderdetailMapper orderdetailMapper) {
		this.orderdetailMapper = orderdetailMapper;
		this.baseMapper = orderdetailMapper;
	}
	public void doInStore(Long uuid, Long storeuuid, Long empUuid) {

		/* =========第一步:更新订单详情========= */
		// 1.从数据库中获取订单详情
		Orderdetail odetail = orderdetailMapper.selectByPrimaryKey(uuid);
		// 2.判断是否是未入库的(未确认的不会显示在这里,静态页面传参已经过滤掉)
		if (!Orderdetail.STATE_NOT_IN.equals(odetail.getState())) {
			throw new ERPException("对不起,不能重复入库!");
		}
		// 判断是否是确认的
		Orders isStartOrders = ordersMapper.selectByPrimaryKey(odetail.getOrdersuuid());
		if (!Orders.STATE_START.equals(isStartOrders.getState())) {
			throw new ERPException("对不起,订单还未确认!");
		}
		// 3.修改订单详情状态
		odetail.setState(Orderdetail.STATE_IN);
		// 4.更改入库时间
		odetail.setEndtime(new Date());
		// 5.更新库管员
		odetail.setEnder(empUuid);
		// 6.设置仓库
		odetail.setStoreuuid(storeuuid);
		
		orderdetailMapper.updateByPrimaryKey(odetail);

		/* =========第二步:更新仓库库存详情========= */
		
		Storedetail queryParam = new Storedetail();
		queryParam.setGoodsuuid(odetail.getGoodsuuid());// 从订单详情中拿到商品id
		queryParam.setStoreuuid(storeuuid);// 仓库编号
		// 查询仓库库存表数据,最后需要得到仓库库存对象,进行操作,所以用geilist
		List<Storedetail> list = storeDetailMapper.getList(queryParam);
		// 得到的是一个list集合,判断是否为空
		if (list.size() > 0) {
			// 有则累加
			long num = 0;
			if (null != list.get(0).getNum()) {
				// 有记录
				num = list.get(0).getNum().longValue();
			}
			list.get(0).setNum(num + odetail.getNum());// 加上原来的
			// 自动保存了
			storeDetailMapper.updateByPrimaryKeySelective(list.get(0));
		} else {
			// 为空--->没有则创建
			queryParam.setNum(odetail.getNum());
			// 保存对象
			storeDetailMapper.insertSelective(queryParam);
		}

		// =========第三步:添加仓库操作记录========= 
		StoreOper newLog = new StoreOper();
		// 加入库管员id
		newLog.setEmpuuid(empUuid);
		// 仓库编号
		newLog.setStoreuuid(storeuuid);
		// 加入操作时间
		newLog.setOpertime(odetail.getEndtime());
		// 记录商品编号
		newLog.setGoodsuuid(odetail.getGoodsuuid());
		// 商品数量
		newLog.setNum(odetail.getNum());
		// 操作行为:入库
		newLog.setType(StoreOper.STORE_IN);
		// 最后保存记录
		storeOperMapper.add(newLog);// 因为没有从数据库查过,所以不会自动更新,要手动更新

		
		
		// =========第四步:是否更新订单状态(完成还是进行中)========= 
		// 1.先判断全部订单明细项是否已经入库(必须是全部入库之后)
	//	Orderdetail queryDetail = new Orderdetail();// 新建一个对象,构建查询条件
		// 得到正在操作的订单对象
		Orders orders = ordersMapper.selectByPrimaryKey(odetail.getOrdersuuid());
		OrderdetailExample orderdetailExample=new OrderdetailExample();
		orderdetailExample.createCriteria().andStateEqualTo(Orderdetail.STATE_NOT_IN).andOrdersuuidEqualTo(orders.getUuid());
		
		
		long count=orderdetailMapper.countByExample(orderdetailExample);
		if (count == 0) {
			// 所有的都已经入库:更新订单状态,关闭订单
			// 设置订单状态
			orders.setState(Orders.STATE_END);
			// 设置完成时间
			orders.setEndtime(odetail.getEndtime());
			// 设置库管员
			orders.setEnder(empUuid); 
			ordersMapper.updateByPrimaryKeySelective(orders);
		}

	}
	@Override
	public void doOutStore(Long uuid, Long storeuuid, Long empUuid) {
		Orderdetail odetail = orderdetailMapper.selectByPrimaryKey(uuid);
		/* =========第一步:判断订单状态========= */
		if (!Orderdetail.STATE_NOT_OUT.equals(odetail.getState())) {
			throw new ERPException("对不起,该订单明细已经出库");
		}
		// 修改订单状态
		odetail.setState(Orderdetail.STATE_OUT);// 出库
		odetail.setEndtime(new Date());// 设置出库日期

		odetail.setEnder(empUuid);// 设置出库员
		odetail.setStoreuuid(storeuuid);// 哪个仓库

		/* =========第二步:更新库存========= */
		// 1,构建查询条件:storeuuid,goodsuuid(查询仓库有是否有)
		Storedetail queryParam = new Storedetail();
		queryParam.setGoodsuuid(odetail.getGoodsuuid());
		queryParam.setStoreuuid(storeuuid);
		// 2,先查询库存中有没有
		List<Storedetail> list = storeDetailMapper.getList(queryParam);
		// 3,判断是否有
		if (list.size() > 0) {
			// 有就取出对象,然后跟销售数量相减,
			Storedetail storedetail = list.get(0);
			Long num = storedetail.getNum() - odetail.getNum();
			if (num < 0) {
				throw new ERPException("该商品库存不足,请先进货");
			}
			// 有库存,再保存
			storedetail.setNum(num);
			orderdetailMapper.updateByPrimaryKey(odetail);
			storeDetailMapper.updateByPrimaryKey(storedetail);
		} else {
			throw new ERPException("仓库中无该商品!");
		}

		/* =========第三步:更新库存变更记录(只有上面两步骤都正确,才会进行)========= */
		StoreOper newLog = new StoreOper();
		newLog.setEmpuuid(empUuid);// 出库员
		newLog.setGoodsuuid(odetail.getGoodsuuid());
		newLog.setNum(odetail.getNum());
		newLog.setOpertime(odetail.getEndtime());
		newLog.setStoreuuid(storeuuid);
		newLog.setType(StoreOper.STORE_OUT);
		// 保存数据
		storeOperMapper.add(newLog);

		/* =========第第四步是否更新销售订单的状态(判断为主,只有订单详情都已经出库)========= */
		// 1,构建查询条件(订单编号,订单详情状态)
		Orders orders = ordersMapper.selectByPrimaryKey(odetail.getOrdersuuid());
		OrderdetailExample orderdetailExample=new OrderdetailExample();
		orderdetailExample.createCriteria().andStateEqualTo(Orderdetail.STATE_NOT_OUT).andOrdersuuidEqualTo(orders.getUuid());
		
		
		long count=orderdetailMapper.countByExample(orderdetailExample);
		
		// 2,查询得到数量
		
		if (count == 0) {
			// 3已经全部出库,修改订状态
			orders.setEnder(empUuid);// 出库员
			orders.setEndtime(odetail.getEndtime());// 结束时间
			orders.setState(Orders.STATE_OUT);
			ordersMapper.updateByPrimaryKey(orders);

			/*//查询订单发送的客户信息
			Supplier supplier = supplierDao.get(orders.getSupplieruuid());
			//在线预约下单,获取订单号,填充信息
			//在全部都出库的情况下,再次构建查询订单详情条件
			Orderdetail qp = new Orderdetail();
			qp.setOrders(orders);
			List<Orderdetail> list2  = orderdetailDao.getList(qp, null, null);
			//设置运单详情缓存
			StringBuilder info = new StringBuilder();
			//遍历添加到info中
			for (Orderdetail orderdetail : list2) {
				//设置运单详情info
				info.append(orderdetail.getGoodsname()+" ");
			}
//			*/
			
		}
	
		
	}
	

}
