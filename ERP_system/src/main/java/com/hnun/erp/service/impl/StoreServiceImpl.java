package com.hnun.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Store;
import com.hnun.erp.bean.StoreExample;
import com.hnun.erp.mapper.StoreMapper;
import com.hnun.erp.service.StoreService;



@Service
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService{

	
	StoreMapper storeMapper;
	
	@Autowired
	public void setDepMapper(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
		this.baseMapper = storeMapper;
	}
		
	
	@Override
	public List<Store> selectByExample(StoreExample example) {
		return storeMapper.selectByExample(example);
	}
	
	
}
