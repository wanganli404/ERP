package com.hnun.erp.mapper;


import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.EmpExample;
import com.hnun.erp.bean.Role;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper extends BaseMapper<Emp>{
   
	List<Emp> selectByExample(EmpExample example);
	
    Emp selectByExampleWithRoles(Long uuid);
    
    List<Emp> selectByExampleWithDept(EmpExample example);
    
    int updateEmpRoles(Emp emp);
    
    @Select("/*!mycat:datanode=dn1*/select databasename from userinfo where username=#{username}")
	String findUserDataNode(String username);
}