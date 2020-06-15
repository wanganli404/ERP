package com.hnun.erp.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Role;
import com.hnun.erp.bean.Tree;
import com.hnun.erp.service.RoleService;
import com.hnun.erp.util.BaseActionUtil;



@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role>{

	
	RoleService roleService;
	@Autowired
	public void setDepMapper(RoleService roleService) {
		this.roleService = roleService;
		this.baseService = roleService;
	}
	@PostMapping("readRoleMenu/{id}")
	public void readRoleMenu(@PathVariable Long id,HttpServletResponse response){
		List<Tree> roleMenu = roleService.readRoleMenu(id);
		BaseActionUtil.write(JSON.toJSONString(roleMenu),response);
	}
	@PostMapping("updateRoleMenus")
	public void updateRoleMenus( Long id,String checkedStr,HttpServletResponse response){
		try {
			roleService.updateRoleMenus(id, checkedStr);
			
			BaseActionUtil.returnAjax(true, "保存角色权限菜单成功!",response);
		} catch (Exception e) {
			BaseActionUtil.returnAjax(false, "保存角色权限菜单失败!",response);
			e.printStackTrace();
		}
	}
	
	
}
