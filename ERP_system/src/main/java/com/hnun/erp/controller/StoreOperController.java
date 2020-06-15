package com.hnun.erp.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hnun.erp.bean.StoreOper;
import com.hnun.erp.service.StoreOperService;


@Controller
@RequestMapping("/storeoper")
public class StoreOperController extends BaseController<StoreOper>{

	
	StoreOperService storeOperService;
	@Autowired
	public void setDepMapper(StoreOperService storeOperService) {
		this.storeOperService = storeOperService;
		this.baseService = storeOperService;
	}
		
	
	
	
}
