package com.hnun.erp.service;

import java.util.List;
import java.util.Map;

import com.hnun.erp.bean.QueryObject;

public interface ReportService {

	List<Map<String, Object>> orderReport(QueryObject queryObject);

	List<Map<String, Object>> returnordersReport(QueryObject queryObject);

	List<Map<String, Object>> trendReport(String year);

	List<Map<String, Object>> storedetailReport(Long storeuuid);

	

	List<Map<String, Object>> stroeoperReport(Long storeuuid, Integer year, int month);



}
