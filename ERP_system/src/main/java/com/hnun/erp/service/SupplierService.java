package com.hnun.erp.service;




import java.util.List;

import com.hnun.erp.bean.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	public List<Supplier> findList(String type);
	
}
