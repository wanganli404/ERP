package com.hnun.erp.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.DepExample;
import com.hnun.erp.bean.Orderdetail;
import com.hnun.erp.bean.OrderdetailDto;
import com.hnun.erp.bean.Orders;
import com.hnun.erp.bean.OrdersDto;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.DepMapper;
import com.hnun.erp.mapper.EmpMapper;
import com.hnun.erp.mapper.OrderdetailMapper;
import com.hnun.erp.mapper.OrdersMapper;
import com.hnun.erp.mapper.SupplierMapper;
import com.hnun.erp.service.DepService;
import com.hnun.erp.service.OrderDetailService;
import com.hnun.erp.service.OrdersService;
import com.hnun.erp.util.GetNameOrSaveUtil;
import com.hnun.erp.util.Pagination;





@Service
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService{
	
	
	private OrdersMapper ordersMapper;
	
	@Autowired
	public void setDepMapper(OrdersMapper ordersMapper) {
		this.ordersMapper = ordersMapper;
		this.baseMapper = ordersMapper;
	}
	
	@Resource
	EmpMapper empMapper;
	
	@Resource
	SupplierMapper supplierMapper;
	
	@Resource
	OrderdetailMapper orderdetailMapper;

	@Override
	public int insertSelective(Orders orders) {
		int success=0;
		// 设置订单的状态:未审核
		orders.setState(Orders.STATE_CREATE);
		// 设置订单时间
		orders.setCreatetime(new Date());
		// 计算总金额
		double totalMoney = 0;
		for (Orderdetail orderdetail : orders.getOrderDetails()) {
			totalMoney += orderdetail.getMoney();
			orderdetail.setState(Orderdetail.STATE_NOT_IN);
		}
		// 设置总金额
		orders.setTotalmoney(totalMoney);
		// 保存订单(同时也会保存了订单详情)
		baseMapper.insertSelective(orders);
		
		for (Orderdetail orderdetail : orders.getOrderDetails()) {
			orderdetail.setOrdersuuid(orders.getUuid());
			 success = orderdetailMapper.insertSelective(orderdetail);
		}
		return   success;
	}
	
	
	@Override
	public List<Orders> getListByPage(Pagination page,Orders orders,QueryObject queryObject) {
		HashMap<String,Object> hashMap=new HashMap<>();
		hashMap.put("page",page);
		hashMap.put("t",orders);
		List<Orders> ordersList = super.getListByPage(page,orders,queryObject);
		
		Map<Long, String> empNameMap = new HashMap<Long, String>();
		// 缓存supplierName集合
		Map<Long, String> supplierNameMap = new HashMap<Long, String>();
		// 编辑加工
		for (Orders o : ordersList) {
			// 调用GetNameOrSaveUtil工具类
			// emp
			o.setCreaterName(GetNameOrSaveUtil.getEmpName(o.getCreater(), empNameMap,empMapper));
			o.setCheckerName(GetNameOrSaveUtil.getEmpName(o.getChecker(), empNameMap, empMapper));
			o.setStarterName(GetNameOrSaveUtil.getEmpName(o.getStarter(), empNameMap,empMapper));
			o.setEnderName(GetNameOrSaveUtil.getEmpName(o.getEnder(), empNameMap, empMapper));
			// supplier
			o.setSupplierName(GetNameOrSaveUtil.getSupplierName(o.getSupplieruuid(), supplierNameMap, supplierMapper));
		}
		
		return ordersList;
	}

	@RequiresPermissions("采购订单审核")
	@Override
	public void doCheck(Long id, Long empuuid) {
		// TODO Auto-generated method stub
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		// 已审查(不等于未审查的都视为'已审查')
		if (!Orders.STATE_CREATE.equals(orders.getState())) {
			throw new ERPException("对不起,订单已经审查过了,请选择未审查的");
		}
		// 更新审查员
		orders.setChecker(empuuid);
		// 更新审查时间
		orders.setChecktime(new Date());
		// 更新流程状态
		orders.setState(Orders.STATE_CHECK);
	    //保存
		ordersMapper.updateByPrimaryKey(orders);
	}


	@Override
	public void doStart(Long id, Long empuuid) {
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		if (!Orders.STATE_CHECK.equals(orders.getState())) {
			// 已确认过
			throw new ERPException("对不起,订单已经确认过了,请选择为确认的");
		}
		
		orders.setStarter(empuuid);
		// 更新确认时间
		orders.setStarttime(new Date());
		// 更新流程状态
		orders.setState(Orders.STATE_START);
		// 之后会自动保存(事务提交)
		ordersMapper.updateByPrimaryKey(orders);
	}
	
	
	
	
	
	
	
	
	
	
}
