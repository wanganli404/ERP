package com.hnun.erp.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.Orderdetail;
import com.hnun.erp.bean.Orders;
import com.hnun.erp.bean.OrdersDto;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.service.OrdersService;
import com.hnun.erp.util.GetLoginUser;
import com.hnun.erp.util.Pagination;



@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController<Orders>{

	
	OrdersService ordersService;
	@Autowired
	public void setDepMapper(OrdersService ordersService) {
		this.ordersService = ordersService;
		this.baseService = ordersService;
	}
		
	  @ResponseBody
	  @PostMapping("/myListByPage") 
	  public String myListByPage(Pagination page,OrdersDto orders,QueryObject queryObject) {
		  Emp existUser = (Emp) GetLoginUser.getLoginUser();
			if (null == existUser) {
				
				return "";
			}
			orders.setCreater(existUser.getUuid());
		 List<Orders> list = baseService.getListByPage(page,orders,queryObject);
		
			return JSON.toJSONString(list);
	  }
	
	  @ResponseBody
	  @PostMapping("/{type}")
	  public HashMap<String,Object> add(@PathVariable String type,OrdersDto ordersDto,String json) {
	//	  
		  List<Orderdetail> list = JSON.parseArray(json, Orderdetail.class);
		  Emp emp= (Emp) GetLoginUser.getLoginUser();
		  ordersDto.setCreater(emp.getUuid());
		  ordersDto.setOrderDetails(list);
		  baseService.insertSelective(ordersDto);
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("success",true);
			rtn.put("message","新增成功");
			return rtn;
	  }
	  
	  @ResponseBody
	  @PostMapping("/doCheck")
	  public HashMap<String,Object> doCheck(@RequestParam Long id) {
	  
		  Emp checker = (Emp) GetLoginUser.getLoginUser();
		 ordersService.doCheck(id, checker.getUuid());
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
		    rtn.put("success",true);
			rtn.put("message","审核成功");
			return rtn;
	  }
	
	  @ResponseBody
	  @PostMapping("/doStart")
	  public HashMap<String,Object> doStart(@RequestParam Long id) {
	  
		  Emp checker = (Emp) GetLoginUser.getLoginUser();
		 ordersService.doStart(id, checker.getUuid());
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
		    rtn.put("success",true);
			rtn.put("message","确认成功");
			return rtn;
	  }
	  
	
}
