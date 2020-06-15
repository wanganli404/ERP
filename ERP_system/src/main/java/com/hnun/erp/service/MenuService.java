package com.hnun.erp.service;





import java.util.List;

import com.hnun.erp.bean.Menu;

public interface MenuService extends BaseService<Menu> {

	public Menu getMenuTree();
	public Menu findCategoriesByParentId(Integer pid);
	public Menu readMenuByEmpuuid(Long uuid);
	public List<Menu> getMenuByEmpuuid(Long uuid);
	
}
