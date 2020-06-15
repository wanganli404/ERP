package com.hnun.erp.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hnun.erp.bean.Store;
import com.hnun.erp.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController extends BaseController<Store>{

	
	StoreService storeService;
	@Autowired
	public void setDepMapper(StoreService storeService) {
		this.storeService = storeService;
		this.baseService = storeService;
	}
		
	
	
	
}
