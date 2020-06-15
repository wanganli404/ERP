package com.hnun.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.Orderdetail;
import com.hnun.erp.bean.OrderdetailDto;
import com.hnun.erp.bean.Orders;
import com.hnun.erp.bean.OrdersDto;
import com.hnun.erp.bean.Storedetail;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.DepMapper;
import com.hnun.erp.service.DepService;
import com.hnun.erp.service.OrderDetailService;
import com.hnun.erp.service.OrdersService;
import com.hnun.erp.util.BaseActionUtil;
import com.hnun.erp.util.GetLoginUser;
import com.hnun.erp.util.Pagination;




@Controller
@RequestMapping("/orderdetail")
public class OrderDetailController extends BaseController<Orderdetail>{

	private OrderDetailService orderDetailService;
	
	@Autowired
	public void setDepMapper(OrderDetailService orderDetailService) {
		this.orderDetailService= orderDetailService;
		this.baseService = orderDetailService;
	}
		
	/*  @ResponseBody
	  @PostMapping("/myListByPage") 
	  public String myListByPage(Pagination page,OrdersDto ordersDto) {
		  Emp existUser = (Emp) GetLoginUser.getLoginUser();
			if (null == existUser) {
				
				return "";
			}
			ordersDto.setCreater(existUser.getUuid());
		 List<OrdersDto> list = baseService.getListByPage(page,ordersDto);
		
			return JSON.toJSONString(list);
	  }
	*/
	  
	  @ResponseBody
	  @PostMapping("/doInStore") 
	  public  HashMap<String,Object> doInStore(Long id,Storedetail storeDetail) {
		  Emp existUser = (Emp) GetLoginUser.getLoginUser();
			if (null == existUser) {
				
			
			}
			orderDetailService.doInStore(id,storeDetail.getStoreuuid(), existUser.getUuid());
			 HashMap<String,Object> rtn = new HashMap<String,Object>();
				rtn.put("success",true);
				rtn.put("message","入库成功");
			return   rtn;
	  }
	  @ResponseBody
	  @PostMapping("/doOutStore") 
	  public HashMap<String,Object> doOutStore(Long id,Storedetail storeDetail) {
			Emp storeManager = (Emp) GetLoginUser.getLoginUser();
			if (null == storeManager) {
			//	BaseActionUtil.returnAjax(false, "对不起,您还没登录,请登录后在操作");
				return null;
			}
			HashMap<String,Object> rtn = new HashMap<String,Object>();
		
				//封装数据,进行biz层业务
			 try {
				orderDetailService.doOutStore(id, storeDetail.getStoreuuid(), storeManager.getUuid());
			 }catch(ERPException e){	
				    rtn.put("success",false);
					rtn.put("message","对不起，库存不足，请先去进货！");
					return rtn;
			 }
				rtn.put("success",true);
				rtn.put("message","出库成功");
				
				
			
			return   rtn;
		}
	  
	  
}
