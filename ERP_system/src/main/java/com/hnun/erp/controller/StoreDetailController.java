package com.hnun.erp.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.StoreAlert;
import com.hnun.erp.bean.Storedetail;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.StoreDetailService;
import com.hnun.erp.util.BaseActionUtil;

@Controller
@RequestMapping("/storedetail")
public class StoreDetailController extends BaseController<Storedetail>{

	
	StoreDetailService storeDetailService;
	@Autowired
	public void setDepMapper(StoreDetailService storeDetailService) {
		this.storeDetailService = storeDetailService;
		this.baseService = storeDetailService;
	}
		
	@PostMapping("/storealertList")
	public void storealertList() {
		List<StoreAlert> storealertList = storeDetailService.getStorealertList();
		
		BaseActionUtil.write(JSON.toJSONString(storealertList),response);
	}

	
	
	@PostMapping("/sendStorealertMail")
	public void sendStorealertMail(String to,String subject,String text) {
		try {
			// 发送预警邮件
			storeDetailService.sendStorealertMail(to, subject, text);
			BaseActionUtil.returnAjax(true, "库存预警邮件发送成功!",response);
		} catch (ERPException e1) {
			BaseActionUtil.returnAjax(false, e1.getMessage(),response);
			e1.printStackTrace();
		} catch (Exception e) {
			BaseActionUtil.returnAjax(false, "库存预警邮件发送失败!",response);
			e.printStackTrace();
		}
	}
}
