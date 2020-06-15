package com.hnun.erp.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;



public interface BaseMapper<T> {
	
	public  int save(Object object);
	
	public int insertSelective(T record);
	 
	public T selectByPrimaryKey(Long uuid);
	
	public int updateByPrimaryKeySelective(T record);
  
    public int deleteByPrimaryKey(Long uuid);
 
    public int updateByPrimaryKey(T record);
    
    public List<T> findList();

    public List<T> getListByPage(HashMap<String, Object> hashMap);
    
    public long count(@Param(value = "type")Long type);

}
