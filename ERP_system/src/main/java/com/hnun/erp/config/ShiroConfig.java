package com.hnun.erp.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.apache.shiro.mgt.SecurityManager;

import com.hnun.erp.filter.ErpAuthorizationFilter;
import com.hnun.erp.realm.ErpRealm;

@Configuration
public class ShiroConfig {
    
    @Bean  
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.  
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>(); 
        //配置退出过滤器,其中的具体的退出代码Shiro已经实现了  
        filterChainDefinitionMap.put("logout", "logout");
        filterChainDefinitionMap.put("sys/**", "anon");
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/orders/doCheck", "perms[\"采购订单审核\"]");
       // filterChainDefinitionMap.put("/emp/**", "perms[\"员工\"]");
        filterChainDefinitionMap.put("/**/.html", "authc");     
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面          
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.html");//未授权跳转
        //登录成功跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/main.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
       
        Map<String, Filter> filters=new HashMap<>();
        filters.put("perms",new ErpAuthorizationFilter());
		shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }
    
    /**  
     * 凭证匹配器  
     * 由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了  
     * @return  
     */  
    @Bean  
    public HashedCredentialsMatcher hashedCredentialsMatcher() {  
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();  
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;  
        hashedCredentialsMatcher.setHashIterations(1);//散列的次数，比如散列两次，相当于 md5(md5(""));  
        return hashedCredentialsMatcher;  
    }  
    
    
    @Bean  
    public ErpRealm myShiroRealm() {  
        ErpRealm myShiroRealm = new ErpRealm(); 
        //使用加密
    //   myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;  
    }  
    
    @Bean  
    public SecurityManager securityManager() {  
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();  
        securityManager.setRealm(myShiroRealm());  
        return securityManager;  
    }
    
    
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    
    /** 
     * 注册全局异常处理 
     * @return 
     */  
 /*   @Bean(name = "exceptionHandler")  
    public HandlerExceptionResolver handlerExceptionResolver() {  
        return new HandlerExceptionResolver();  
    }
    */
    @Bean
    public ErpAuthorizationFilter erpAuthorizationFilter(){
    	
    	
    	
        return new ErpAuthorizationFilter();
    }
    
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
    	AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    	advisor.setSecurityManager(securityManager());
    	
        return advisor;
    }
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
   public  DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    	DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
    	defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    	return defaultAdvisorAutoProxyCreator;
    	
    }
    
    
}