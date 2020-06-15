package com.hnun.erp.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.Tree;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.EmpService;
import com.hnun.erp.util.BaseActionUtil;
import com.hnun.erp.util.GetLoginUser;






@Controller
@RequestMapping("/emp")
public class EmpController extends BaseController<Emp> {
	
 
  EmpService empService;
  
    @Autowired
	public void setDepMapper(EmpService empService) {
		this. empService =  empService;
		this.baseService =  empService;
	}
  
  @ResponseBody
  @PostMapping("/showRole")
  public HashMap<String,Object> showRole(HttpSession session) {
	  HashMap<String,Object> rtn = new HashMap<String,Object>();
	// 获取主题
	  Subject subject = SecurityUtils.getSubject();
			// 获取登录对象
	  Emp emp = (Emp) subject.getPrincipal();
	  if (emp==null) {
		return null;
	}
	  String empRoleNames = empService.selectByExampleWithRoles(emp.getUuid());
	  if (null != empRoleNames) {
			rtn.put("success",true);
			rtn.put("message",empRoleNames);
			return rtn;
		}
		
		
		return null;
		
  }
  @ResponseBody
  @PostMapping("/updatePwd")
  public void updatePwd(@RequestParam String oldPwd,@RequestParam String newPwd){
		//从session中获取登录的用户对象
		Emp loginUser = (Emp) GetLoginUser.getLoginUser();
		//判断是否存在
		if (null == loginUser) {
			BaseActionUtil.returnAjax(false, "您还没登录，请登录后再操作！",response);
			return;
		}
		try {
			//已经登录，传递修改密码
			empService.updatePwd(loginUser.getUuid(), oldPwd, newPwd);
			BaseActionUtil.returnAjax(true, "密码修改成功！",this.response);
		} catch(ERPException e1){
			//自定义异常
			e1.printStackTrace();
			BaseActionUtil.returnAjax(false, e1.getMessage(),this.response);
		} catch (Exception e2) {
			//系统异常
			e2.printStackTrace();
			BaseActionUtil.returnAjax(false, "修改密码失败！",this.response);
		}
		
	}
	
  @ResponseBody
  @PostMapping("/resetPwd")
  public void resetPwd(HttpServletResponse response,Long uuid,String newPwd) {
	
	  try {
			//getId()从baseAction中调用
			//empBiz.updatePwd_reset(getId(), newPwd);
			empService.resetPwd(uuid,newPwd);
			BaseActionUtil.returnAjax(true, "重置密码成功!",response);
		} catch (Exception e) {
			e.printStackTrace();
			BaseActionUtil.returnAjax(false, "重置密码失败!",response);
		}	
  }
  @PostMapping("/readEmpRoles/{uuid}")
  public void readEmpRoles(HttpServletResponse response,@PathVariable Long uuid) {
		
	  	List<Tree> roles = empService.readEmpRoles(uuid);
		BaseActionUtil.write(JSON.toJSONString(roles),response);
  
}
  
  
  @PostMapping("/updateEmpRoles")
  public void updateEmpRoles(HttpServletResponse response,Long uuid,String checkedStr) {
		
	  try {
		  	empService.updateEmpRoles(uuid, checkedStr);
			BaseActionUtil.returnAjax(true, "更新成功!",response);
		} catch (Exception e) {
			BaseActionUtil.returnAjax(false, "更新失败!",response);
			e.printStackTrace();
		}
  
}
  
 
  
}