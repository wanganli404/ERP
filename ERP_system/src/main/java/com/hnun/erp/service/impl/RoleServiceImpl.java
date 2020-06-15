package com.hnun.erp.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hnun.erp.bean.Menu;
import com.hnun.erp.bean.Role;
import com.hnun.erp.bean.RoleExample;
import com.hnun.erp.bean.Tree;
import com.hnun.erp.mapper.MenuMapper;
import com.hnun.erp.mapper.RoleMapper;
import com.hnun.erp.service.RoleService;






@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	public void setDepMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
		this.baseMapper = roleMapper;
	}

	
	@Override
	public List<Role> selectByExample(RoleExample roleExample) {
	
		return roleMapper.selectByExample(roleExample);
	}


	@Override
	public List<Tree> readRoleMenu(Long id) {
		List<Tree> treeList = new ArrayList<Tree>();
		// 角色下的权限菜单只有二级菜单
		// 获取角色信息
		
		Role role = roleMapper.selectByPrimaryKey(id);
		// 获取角色下的菜单
		//应该只有二级菜单
		List<Menu> roleMenus = role.getMenus();
		// 获取跟菜单对象,然后相互匹配,
		
		Menu rootMenu = menuMapper.selectByPrimaryKey("0");
		Tree t1 = null;// 一级菜单
		Tree t2 = null;// 二级菜单
		// 开始循环rootMunu
		for (Menu m1 : rootMenu.getMenus()) {
			t1 = new Tree();
			t1.setId(m1.getMenuid());// 设置一级菜单id
			t1.setText(m1.getMenuname());// 设置一级菜单名称
			// 还不知到是否有children菜单
			// 循环二级菜单
			for (Menu m2 : m1.getMenus()) {
				t2 = new Tree();
				t2.setId(m2.getMenuid());// 设置二级菜单id
				t2.setText(m2.getMenuname());// 设置二级菜单名字
				// 判断roleMenus中是否包含对应的m2菜单
				if (roleMenus.contains(m2)) {
					t2.setChecked(true);
				}
				// 一级菜单里添加二级菜单
				t1.getChildren().add(t2);
			}
			treeList.add(t1);
		}
		return treeList;
	}


	@Override
	public void updateRoleMenus(Long roleid, String checkedStr) {
		// 根据选中的uuid获得对应的role
				Role role = roleMapper.selectByPrimaryKey(roleid);
				
				// 清楚role角色下的所有菜单权限(重新赋予)
				role.setMenus(new ArrayList<Menu>());
				//前端已经判断了checkStr不为空
				String[] ids = checkedStr.split(",");
				Menu menu = null;
				//遍历数组进行角色菜单添加
				for (String id : ids) {
					//根据id通过menuDao获取真实的菜单编号 :即字符串--->menu对象
					menu = menuMapper.selectByPrimaryKey(id);
					//保存角色
					role.getMenus().add(menu);
					
				}
				roleMapper.updateRoleAndMenu(role);
				//通过role反查有那些emp用了这个角色,逐个删除
			/*	List<Emp> empList = role.getEmps();
				//防止删除空的,报出异常
				try {
					for (Emp emp : empList) {
						//清除每个用户下的jedis缓存
						//jedis.del("menuList_" + emp.getUuid());
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}*/
		
	}

}
