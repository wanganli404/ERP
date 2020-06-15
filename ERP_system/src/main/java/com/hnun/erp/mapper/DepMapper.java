package com.hnun.erp.mapper;


import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.DepExample;
import java.util.List;

public interface DepMapper extends BaseMapper<Dep>{
   /* 
	*/
	List<Dep> selectByExample(DepExample example);
}