package com.hnun.erp.service;





import com.hnun.erp.bean.Orderdetail;



public interface OrderDetailService extends BaseService<Orderdetail> {

	public void doInStore(Long uuid, Long storeuuid, Long empUuid) ;

	public void doOutStore(Long uuid, Long storeuuid, Long empUuid);
	
	
}
