package com.hnun.erp.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.Supplier;
import com.hnun.erp.mapper.DepMapper;
import com.hnun.erp.service.DepService;
import com.hnun.erp.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseController<Supplier>{

	
	SupplierService supplierService;
	@Autowired
	public void setDepMapper(SupplierService supplierService) {
		this.supplierService = supplierService;
		this.baseService = supplierService;
	}
	
	@ResponseBody
	@PostMapping("/list/{type}")
	public List<Supplier> list(@PathVariable String type) {
		List<Supplier> list = supplierService.findList(type);
		
		return list;
	}
	
	

}
