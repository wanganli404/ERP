package com.hnun.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnun.erp.bean.Goods;
import com.hnun.erp.bean.Goodstype;

import com.hnun.erp.service.GoodsTypeService;

@Controller
@RequestMapping("/goodstype")
public class GoodsTypeController extends BaseController<Goodstype> {

	GoodsTypeService goodsTypeService;
	
	@Autowired
	public void setDepMapper(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
		this.baseService = goodsTypeService;
	}
		
	
	
}
