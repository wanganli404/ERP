package com.hnun.erp.service;





import com.hnun.erp.bean.Orders;


public interface OrdersService extends BaseService<Orders> {

	public void doCheck(Long id, Long empuuid);

	public void doStart(Long id, Long empuuid);

	
	
}
