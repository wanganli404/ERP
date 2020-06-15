package com.hnun.erp.service;



import java.util.List;


import com.hnun.erp.bean.Store;
import com.hnun.erp.bean.StoreExample;

public interface StoreService extends BaseService<Store> {

	List<Store> selectByExample(StoreExample example);
	
}
