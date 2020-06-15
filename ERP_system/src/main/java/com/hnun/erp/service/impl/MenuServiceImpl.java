package com.hnun.erp.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Menu;
import com.hnun.erp.mapper.MenuMapper;
import com.hnun.erp.service.MenuService;


@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements  MenuService{

	
	private MenuMapper menuMapper;
	
	@Autowired
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
		this.baseMapper = menuMapper;
	}
	
	
	
	@Override
	public Menu getMenuTree() {
		return menuMapper.selectByExample(null);
	}

	@Override
	public Menu findCategoriesByParentId(Integer pid) {
		return menuMapper.findCategoriesByParentId(pid);
	}

	public Menu readMenuByEmpuuid(Long uuid) {
		// 获取所有的菜单(原始菜单,做模板)
		Menu rootMenu = menuMapper.findCategoriesByParentId(-1);
		// 获取当前用户的菜单(都是二级菜单)
		List<Menu> empMenu = menuMapper.getMenuByEmpuuid(uuid);
		// 复制原始菜单,进行加工(最大级别菜单栏)
		Menu menu = cloneMenu(rootMenu);
		// 创建一,二级菜单接收器
		Menu _m1 = null;
		Menu _m2 = null;
		// 循环一级菜单
		for (Menu m1 : rootMenu.getMenus()) {
			_m1 = cloneMenu(m1);
			// 循环二级菜单
			for (Menu m2 : m1.getMenus()) {
				//判断用户是否包含了这个二级菜单
				m2.toString();
				
					if (empMenu.contains(m2)) {
						_m2 = cloneMenu(m2);//克隆
						//在一级菜单中加入二级菜单
						_m1.getMenus().add(_m2);
					}
				
			
			}
			//如果有_m1中有_m2,加入到menu中
			if (_m1.getMenus().size()>0) {
				menu.getMenus().add(_m1);
			}
			
		}
        menu.toString();
		return menu;
	}

	/**
	 * 复制菜单
	 * @param src 目标菜单
	 * @return 新菜单
	 */
	private Menu cloneMenu(Menu src) {
		Menu newMenu = new Menu();
		newMenu.setIcon(src.getIcon());
		newMenu.setMenuid(src.getMenuid());
		newMenu.setMenuname(src.getMenuname());
		newMenu.setUrl(src.getUrl());
		// 新建一个菜单列表,这个很关键!
		newMenu.setMenus(new ArrayList<Menu>());
		return newMenu;
	}



	@Override
	public List<Menu> getMenuByEmpuuid(Long uuid) {
		
		return menuMapper.getMenuByEmpuuid(uuid);
	}




	
}
