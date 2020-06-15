package com.hnun.erp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.StoreOper;
import com.hnun.erp.mapper.StoreOperMapper;
import com.hnun.erp.service.StoreOperService;




@Service
public class StoreOperServiceImpl extends BaseServiceImpl<StoreOper> implements StoreOperService{

	
	StoreOperMapper storeOperMapper;
	
	@Autowired
	public void setDepMapper(StoreOperMapper storeOperMapper) {
		this.storeOperMapper = storeOperMapper;
		this.baseMapper = storeOperMapper;
	}
		
	

	
}
