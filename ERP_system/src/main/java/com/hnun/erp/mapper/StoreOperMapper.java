package com.hnun.erp.mapper;

import org.apache.ibatis.annotations.Insert;

import com.hnun.erp.bean.StoreOper;

public interface StoreOperMapper extends BaseMapper<StoreOper> {
     
	@Insert("insert into storeoper values(null,#{empuuid},#{opertime},#{storeuuid},#{goodsuuid},#{num},#{type})")
	public void add(StoreOper newLog);

}
