package com.hnun.erp.config;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.EmpMapper;
import com.hnun.erp.util.BaseActionUtil;
import com.hnun.erp.util.GetLoginUser;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截请求，获取判断租户
 */
@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
	@Resource
	EmpMapper empMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 一般不可能是传参数的，这里只做演示
        // 但可以判断用户登陆的session，或cookies，或二级域名识别是哪个租户
       Object loginUser = GetLoginUser.getLoginUser();
       try {

           if (loginUser!=null) {
           	throw new ERPException("请不要同时在同一浏览器重复登陆或登录多个账号!");
           	 
   		}
	} catch (ERPException e) {
		BaseActionUtil.returnAjax(false,e.getMessage(), response);
		return false;
	}
        String username = request.getParameter("username");
        String tenantId = empMapper.findUserDataNode(username);
        
        try {

            if (tenantId==null) {
            	throw new ERPException("用户名不存在!");
            	 
    		}
 	} catch (ERPException e) {
 		BaseActionUtil.returnAjax(false,e.getMessage(), response);
 		return false;
 	}
       
        if (tenantId != null && tenantId.length() > 0) {
        	
        	 request.getSession().setAttribute("datanode",tenantId);
        	 
                 // MultiTenantHolder.setCurrentNode(tenantId);
             
             log.info("preHandle---->>"+tenantId);
             return true;
        }
     
        return false;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      
        log.info("afterCompletion---->>");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle---->>");
    }
}
