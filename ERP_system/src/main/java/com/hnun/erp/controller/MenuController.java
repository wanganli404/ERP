package com.hnun.erp.controller;



import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.Menu;
import com.hnun.erp.service.MenuService;
import com.hnun.erp.util.GetLoginUser;



@Controller
@RequestMapping("/menu")
public class MenuController {
	
   @Resource
   MenuService menuService;
	
	
  @ResponseBody
  @PostMapping("/getMenuTree")
  public String getMenuTree(){
	
	  Emp emp = (Emp) GetLoginUser.getLoginUser();
	  if(emp==null) {
		  return null;
	  }
	  Menu menu = menuService.readMenuByEmpuuid(emp.getUuid());
	 
	  return JSON.toJSONString(menu);
  }
  
}
