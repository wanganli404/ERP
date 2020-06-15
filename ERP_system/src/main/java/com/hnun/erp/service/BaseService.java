package com.hnun.erp.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.util.Pagination;







public interface BaseService<T> {

	public int deleteByPrimaryKey(Long uuid);

	public int insert(T record);

	public int insertSelective(T record);

	public T selectByPrimaryKey(Long uuid);

	public int updateByPrimaryKeySelective(T record);

	public List<T> findList();

	public List<T> getListByPage(Pagination page,T t,QueryObject queryObject);
	
	public long count(Long type);

	public void doImport(InputStream is) throws IOException,ParseException;

	public void doExport(OutputStream os, T t1, String userName, QueryObject queryObject);
	
}
