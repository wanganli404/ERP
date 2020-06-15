package com.hnun.erp.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.EmpService;

import com.hnun.erp.util.BaseActionUtil;



@Controller
@RequestMapping("/login")
public class LoginController {
   @Resource
   private EmpService empService;
   
   @ResponseBody
   @PostMapping("/checkUser")
   public void checkUser(HttpServletResponse response,Emp emp,HttpSession session){
	
		try {
			// 1.创建令牌,身份证明
			UsernamePasswordToken upt = new UsernamePasswordToken(emp.getUsername(), emp.getPwd());
			// 2.获取主题subject:封装当前用户的一些操作
			Subject subject = SecurityUtils.getSubject();
			// 3.执行login
			subject.login(upt);
			// 成功登录
			BaseActionUtil.returnAjax(true, "", response);
		} catch (AuthenticationException a) {
			BaseActionUtil.returnAjax(false, "对不起，用户名与密码不匹配！", response);
			session.removeAttribute("datanode");
		} catch (Exception e) {
			e.printStackTrace();
			BaseActionUtil.returnAjax(false, "登录失败!", response);
		}

}

	@ResponseBody
	@PostMapping("/showName")
	public void showName(HttpServletResponse response) {

		Subject subject = SecurityUtils.getSubject();
		// 获取登录对象
		Emp emp = (Emp) subject.getPrincipal();
		// 判断是否有用户名
		if (null != emp) {
			// 登录成功显示用户名
			BaseActionUtil.returnAjax(true, emp.getName(), response);
		} else {
			// 登录不成功
			BaseActionUtil.returnAjax(false, "", response);
		}

	}
   @ResponseBody
   @GetMapping("/loginOut")
   public void loginOut(HttpSession session) {
	  
	   SecurityUtils.getSubject().logout();
	   
   }
   
   
}
