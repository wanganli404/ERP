package com.hnun.erp.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.EmpExample;
import com.hnun.erp.bean.Tree;

public interface EmpService extends BaseService<Emp> {

	List<Emp> checkUser(Emp emp);

	String selectByExampleWithRoles(Long uuid);

/*	List<Emp> selectByExampleWithDept(EmpDto empDto);*/

	List<Emp> selectByExample(EmpExample example);

	void updatePwd(Long uuid, String oldPwd, String newPwd);

	void resetPwd(Long uuid, String newPwd);

	List<Tree> readEmpRoles(Long uuid);

	void updateEmpRoles(Long uuid, String checkedStr);

	Emp findByUsernameAndPwd(String username, String pwd);

	
	
	
}
