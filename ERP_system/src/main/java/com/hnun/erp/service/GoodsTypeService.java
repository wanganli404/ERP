package com.hnun.erp.service;

import java.util.List;


import com.hnun.erp.bean.Goodstype;
import com.hnun.erp.bean.GoodstypeExample;

public interface GoodsTypeService extends BaseService<Goodstype> {

	List<Goodstype> selectByExample(GoodstypeExample example);  
	
	
}
