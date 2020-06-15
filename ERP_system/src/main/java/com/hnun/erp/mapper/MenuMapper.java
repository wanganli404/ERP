package com.hnun.erp.mapper;

import com.hnun.erp.bean.Menu;
import com.hnun.erp.bean.MenuExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends BaseMapper<Menu> {
  

    Menu selectByPrimaryKey(String menuid);

    Menu findCategoriesByParentId(Object pid);

	Menu selectByExample(Object object);
	
	List<Menu> selectMenuByRoleId(Long roleid);

	List<Menu> getMenuByEmpuuid(Long empuuid);
}