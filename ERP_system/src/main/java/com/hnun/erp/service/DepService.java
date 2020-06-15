package com.hnun.erp.service;




import java.util.List;
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.DepExample;

public interface DepService extends BaseService<Dep> {

	List<Dep> selectByExample(DepExample example);

	
	
}
