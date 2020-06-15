package com.hnun.erp.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.Menu;
import com.hnun.erp.service.EmpService;
import com.hnun.erp.service.MenuService;



public class ErpRealm extends AuthorizingRealm {

	// 注入IempService实现用户登录验证
	@Autowired
	private EmpService empService;

	
	// 注入ImenuService进行菜单查询
	@Autowired
	private MenuService menuService;

	
	/**
	 * 授权方法
	 * return AuthorizationInfo的子类或实现类为通过授权
	 * return null 授权不成功
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取授权对象的实现类SimpleAuthorizationInfo
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//通过principals获取当前登录的用户对象
		Emp emp = (Emp) principals.getPrimaryPrincipal();
		//根据emp的uuid获取当前对象的Menu
		List<Menu> menuList = menuService.getMenuByEmpuuid(emp.getUuid());
		//menuList.get(0).getMenus();
		//menuList.size();
		//循环遍历数组取出标题名称
		for(Menu m : menuList){
			//url=prem["菜单名称"]
			info.addStringPermission(m.getMenuname());
		}
		return info;
	}

	/**
	 * 验证方法
	 * @return null:表示验证失败,返回AuthenticationInfo的实现类,表示验证成功
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取到令牌,在loginAction中传入的
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		// 取出用户名
		String username = upt.getUsername();
		// 取出密码
		String pwd = new String(upt.getPassword());
		// 调用empService查询
		Emp emp = empService.findByUsernameAndPwd(username, pwd);
		if (null != emp) {
			// 验证成功
			// 参数1:主角=emp(后续需要获取显示登录用户名称)
			// 参数2:授权码:一般用密码
			// 参数3:当前realm的名称
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(emp, pwd, getName());
			return info;
		}
		return null;

	}
}
