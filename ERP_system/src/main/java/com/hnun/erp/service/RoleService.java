package com.hnun.erp.service;



import java.util.List;


import com.hnun.erp.bean.Role;
import com.hnun.erp.bean.RoleExample;
import com.hnun.erp.bean.Tree;

public interface RoleService extends BaseService<Role> {

	List<Role> selectByExample(RoleExample roleExample);

	List<Tree> readRoleMenu(Long id);

	void updateRoleMenus(Long id, String checkedStr);
	
}
