package com.hnun.erp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Supplier;
import com.hnun.erp.bean.SupplierExample;
import com.hnun.erp.mapper.SupplierMapper;
import com.hnun.erp.service.SupplierService;



@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService{
	
	private SupplierMapper supplierMapper;
	
	@Autowired
	public void setDepMapper(SupplierMapper supplierMapper) {
		this.supplierMapper = supplierMapper;
		this.baseMapper = supplierMapper;
	}

	

	@Override
	public List<Supplier> findList(String type) {
		// TODO Auto-generated method stub
		SupplierExample supplierExample=new SupplierExample();
		supplierExample.createCriteria().andTypeEqualTo(type);
		return supplierMapper.selectByExample(supplierExample);
	}

	

}
