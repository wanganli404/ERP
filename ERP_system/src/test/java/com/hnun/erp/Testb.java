package com.hnun.erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.EmpDto;
import com.hnun.erp.bean.EmpExample;
import com.hnun.erp.bean.Menu;
import com.hnun.erp.bean.Role;
import com.hnun.erp.bean.Store;
import com.hnun.erp.bean.StoreOper;
import com.hnun.erp.bean.Tree;
import com.hnun.erp.mapper.EmpMapper;
import com.hnun.erp.mapper.MenuMapper;
import com.hnun.erp.mapper.ReportMapper;
import com.hnun.erp.mapper.RoleMapper;
import com.hnun.erp.mapper.StoreMapper;
import com.hnun.erp.mapper.StoreOperMapper;
import com.hnun.erp.realm.ErpRealm;
import com.hnun.erp.service.BaseService;
import com.hnun.erp.service.MenuService;
import com.hnun.erp.service.ReportService;
import com.hnun.erp.service.impl.RoleServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest

public class Testb {
/*	@Autowired
   BaseMapper<Dep> baseMapper;
	
	@Autowired
	BaseDao<Dep> baseDao;
	
	@Autowired
	BaseDao<Emp> baseDaoe;
	
	
	@Test
	public void test01() throws Exception {
		Map<String, Object> columnMap=new HashMap<String, Object>();
		columnMap.put("uuid",1);
		List<Dep> list = baseMapper.selectByMap(columnMap);
		Dep dep = list.get(0);
		String name = dep.getName();
		System.out.println(name);
//		baseMapper.deleteById(8);
		Dep dep = baseDao.find((long) 1);
		System.out.println(dep.getName());
		EmpExample empExample=new EmpExample();
		List<Emp> list = baseDaoe.findList(empExample);
		for (Emp emp : list) {
			System.out.println(emp.getName());
		}
	}*/
	/*@Resource
	BaseService<Emp> baseService;
	
	
	*/
	@Resource
	private StoreMapper storeMapper;
	
	@Resource
	EmpMapper empMapper;
	
	@Resource
	RoleMapper roleMapper;
	
	@Resource
	MenuMapper menuMapper;
	
	@Resource
	MenuService menuService;
	@Resource
	StoreOperMapper storeOperMapper;
    @Resource
    ErpRealm erpRealm;
    
  
    @Resource
    ReportMapper reportMapper;
    @Resource
    RoleServiceImpl roleServiceImpl;
    @Resource
    ReportService reportService;
    
	@Test
	public void test02() throws Exception {
		 
	/*	List<Menu> menu = menuMapper.selectMenuByRoleId((long) 1);
		
		for (Menu menu2 : menu) {
			System.out.println(menu2);
		}*/
		
		/*List<Role> list = roleMapper.findList();
		list.size();*/
	/*	
		Role role1 = roleMapper.selectByPrimaryKey((long) 1);
		
		Role role = roleMapper.selectByPrimaryKey((long) 5);
		role.setMenus(role1.getMenus());
		
		roleMapper.updateRoleAndMenu(role);*/
		
	//	menuMapper.getMenuByEmpuuid((long) 1);
		
	/*	EmpExample example=new EmpExample();
		example.createCriteria().andUuidEqualTo((long) 1);
		List<Emp> emps = empMapper.selectByExampleWithRoles(example);
		Emp emp = emps.get(0);
		// 得到对应的角色list
		List<Role> empRoles = emp.getRoles();
		
		for (Role role : empRoles) {
			System.out.println(role.getName());
		}*/
		
		/*Emp emp = empMapper.selectByExampleWithRoles((long) 1);
		List<Role> roles = emp.getRoles();
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		Menu menu = menuService.readMenuByEmpuuid((long) 21);
		
		menu.getClass();*/
		
		
		//erpRealm.getAuthenticationCache();
		//baseExampleMapper.updateByExample(record, example)
	}
	
	
	@Test
	public void test00() {
		/*List<Map<String,Object>> list = reportMapper.orderReport(null);
		System.out.println(list);
		*/
		
	/*	Menu menu = menuMapper.findCategoriesByParentId(-1);
		List<Menu> menus = menu.getMenus();
		for (Menu menu2 : menus) {
			 List<Menu> menus2 = menu2.getMenus();
			 for (Menu menu3 : menus2) {
				System.out.println(menu3.getMenuname());
			}
		}
		*/
		
		/*Role role = roleMapper.selectByPrimaryKey((long) 2);
		List<Menu> menus = role.getMenus();
		
		for (Menu menu2 : menus) {
			if (Integer.parseInt(menu2.getMenuid())%100!=0) {
				
			}
			
		
			
		}*/
		/*List<Tree> list = roleServiceImpl.readRoleMenu((long) 2);
		for (Tree tree : list) {
			List<Tree> list2 = tree.getChildren();
			for (Tree tree2 : list2) {
				System.out.println(tree2.getText());
			}
		}*/
		/*List<Map<String,Object>> list = reportMapper.getSumMoney(2020,"1");
		for (Map<String, Object> map : list) {
			Set<String> keySet = map.keySet();
			for(String key:keySet) {
				Object object = map.get(key);
				System.out.println(object);
			}
		}*/
		//List<Map<String,Object>> list = reportMapper.storedetailReport((long) 1);
		/*List<Map<String,Object>> list = reportService.trendReport("2020");
		
	  list.getClass();
	*/
	 /* List<Map<String,Object>> sumMoney = reportMapper.getSumMoney(2020,"1","y");
	  for (Map<String, Object> map : sumMoney) {
		  Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		
	}*/
	
		Date date=new Date();
	
	   long time = date.getTime();
	   System.out.println(date.toString());
	
	}
	
	
	
}
