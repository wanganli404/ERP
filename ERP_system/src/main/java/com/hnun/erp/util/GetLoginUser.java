package com.hnun.erp.util;


import org.apache.shiro.SecurityUtils;

public class GetLoginUser {

	/**
	 * 获取session中的对象
	 * 需要强转对象
	 * @return
	 */
	public static Object getLoginUser(){
		/*HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();*/
		/*return ActionContext.getContext().getSession().get(login);*/
		
		return SecurityUtils.getSubject().getPrincipal();
	}
}
