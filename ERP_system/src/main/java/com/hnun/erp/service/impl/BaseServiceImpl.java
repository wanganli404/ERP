package com.hnun.erp.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import com.hnun.erp.bean.QueryObject;

import com.hnun.erp.mapper.BaseMapper;
import com.hnun.erp.service.BaseService;

import com.hnun.erp.util.Pagination;



public  class BaseServiceImpl<T> implements BaseService<T> {
	
	// 引入泛型初阶类型
	private Class<T> entityClass;

	public BaseServiceImpl() {
		// 获取对象对应的父类类型
		Type baseDaoClass = this.getClass().getGenericSuperclass();
		// 转成带参数,即泛型的类型
		ParameterizedType pt = (ParameterizedType) baseDaoClass;
		// 获取其参数泛型的泛型数组
		Type[] types = pt.getActualTypeArguments();
		// 获取第一个泛型类型
		entityClass = (Class<T>) types[0];
	}

	
	protected BaseMapper<T> baseMapper;

	@Override
	public int deleteByPrimaryKey(Long uuid) {
		return baseMapper.deleteByPrimaryKey(uuid);
	}

	@Override
	public int insert(T record) {
		return 0;
	}

	@Override
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(Long uuid) {
		return baseMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<T> findList() {
		return baseMapper.findList();
	}

	@Override
	public List<T> getListByPage(Pagination page,T t,QueryObject queryObject) {
		HashMap<String,Object> hashMap=new HashMap<>();
		hashMap.put("page",page);
		hashMap.put("t",t);
		hashMap.put("q",queryObject);
		
		return baseMapper.getListByPage(hashMap);
	}

	@Override
	public long count(Long type) {
		return baseMapper.count(type);
	}

	@Override
	public void doExport(OutputStream outputStream, T t, String loginUser, QueryObject queryObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doImport(InputStream inputStream) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	

	
}
