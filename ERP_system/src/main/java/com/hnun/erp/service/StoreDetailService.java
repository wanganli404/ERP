package com.hnun.erp.service;




import java.util.List;

import com.hnun.erp.bean.StoreAlert;
import com.hnun.erp.bean.Storedetail;

public interface StoreDetailService extends BaseService<Storedetail> {

	public List<StoreAlert> getStorealertList();

	public void sendStorealertMail(String to, String subject, String text);

	
	
}
