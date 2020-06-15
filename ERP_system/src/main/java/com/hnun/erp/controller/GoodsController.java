package com.hnun.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.Goods;

import com.hnun.erp.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController<Goods> {

	private GoodsService goodsService;
	
	@Autowired
	public void setDepMapper(GoodsService goodsService) {
		this.goodsService = goodsService;
		this.baseService =goodsService;
	}
	
	
}
