package com.hnun.erp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hnun.erp.bean.Goodstype;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.mapper.GoodstypeMapper;
import com.hnun.erp.mapper.ReportMapper;
import com.hnun.erp.service.ReportService;

import net.sf.jxls.report.ReportManager;

@Service
public class ReportServiceImpl implements ReportService {

	@Resource
	ReportMapper reportMapper;
	
	@Resource
	GoodstypeMapper goodstypeMapper;
	
	@Override
	public List<Map<String, Object>> orderReport(QueryObject queryObject) {
		// TODO Auto-generated method stub
		return reportMapper.orderReport(queryObject);
	}

	@Override
	public List<Map<String, Object>> returnordersReport(QueryObject queryObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> trendReport(String year) {
		// 要求:[{"name":4,"y":50135,"h":2229},{"name":5,"y":20000,"h":23429}]
		// 采购 type =1
		// [{"name":1,"y":50135},{"name":2,"y":20000}]
		List<Map<String, Object>> pList = complementData(Integer.parseInt(year), "1", "y");
		// 销售type =2
		// [{"name":1,"h":50135},{"name":2,"h":20000}]
		List<Map<String, Object>> sList = complementData(Integer.parseInt(year), "2", "h");

		// 加工
		List<Map<String, Object>> resultList = new ArrayList<>();//返回的数组
		
		Map<String, Object> yhData = null;//接收的新集合
		//循环遍历12个月,也就是原来数组的长度,从0开始
		for (int i = 0; i < 12; i++) {
			yhData=new HashMap<>();
			yhData.put("name", pList.get(i).get("name"));//添加月份
			yhData.put("y", pList.get(i).get("y"));//y的数据-->采购
			yhData.put("h", sList.get(i).get("h"));//h的数据-->销售
			resultList.add(yhData);
		}
		return resultList;
		
	}

	@Override
	public List<Map<String, Object>> storedetailReport(Long storeuuid) {
		// 对数据进行补充(有商品种类)[{"name":"数码家电","y":2000},{"name":"美食特产","y":20000}]
				List<Map<String, Object>> list = reportMapper.storedetailReport(storeuuid);
				// 返回的数据reData
				List<Map<String, Object>> reData = new ArrayList<Map<String, Object>>();
				// 从list中提取的Map集合key =month value={"name":"数码家电","y":2000}
				Map<String, Map<String, Object>> typeData = new HashMap<String, Map<String, Object>>();
				// 把list集合的数据放到yearData集合,然后进行判断
				for (Map<String, Object> type : list) {
					typeData.put(type.get("name") + "", type);
				}
				//获取全部的商品类型
				List<Goodstype> allType = goodstypeMapper.findList();
				// 补充缺少的月份(monthData即将会添加到reData中返回)
				Map<String, Object> allTypeData = null;
				for (Goodstype gt:allType) {
					// 获取value={"name":"数码家电","y":2000}
					allTypeData = typeData.get(gt.getName());
					// 判断是否有值
					if (null == allTypeData) {
						// 没有值,补充一个
						allTypeData = new HashMap<String, Object>();
						allTypeData.put("name", gt.getName());
						allTypeData.put("y", "null");
					} else {
						allTypeData.put("name", gt.getName());// key重复时候,会替换
					}
					reData.add(allTypeData);
				}
				return reData;
	}

	@Override
	public List<Map<String, Object>> stroeoperReport(Long storeuuid, Integer year, int month) {
		// 要求:[{"name":4,"y":50135,"h":2229},{"name":5,"y":20000,"h":23429}]
				// 采购 type =1
				// {"name":"数码家电","y":2000}
				List<Map<String, Object>> pList = manageData("1", storeuuid, year, month,"y");
				// 销售type =2
				// {"name":"数码家电","h":2000}
				List<Map<String, Object>> sList = manageData("2",storeuuid, year, month,"h");

				// 加工
				List<Map<String, Object>> resultList = new ArrayList<>();//返回的数组
				
				Map<String, Object> yhData = null;//接收的新集合
				
				//循环遍历其中一个(因为类型的循序都一样)
				for (int i = 0; i < pList.size(); i++) {
					yhData=new HashMap<>();
					yhData.put("name", pList.get(i).get("name"));//种类名称
					yhData.put("y", pList.get(i).get("y"));//y的数据-->采购
					yhData.put("h", sList.get(i).get("h"));//h的数据-->销售
					resultList.add(yhData);
				}
				return resultList;
	}
	/*
	 * 获取初步数据(x轴为月份)
	 * @param year
	 * @param type
	 * @param symbol
	 * @return
	*/
	private List<Map<String, Object>> complementData(int year, String type, String symbol) {
		// 对数据进行补充(有月份会缺少)[{"name":4,"y":50135},{"name":5,"y":20000}]
		List<Map<String, Object>> list = reportMapper.getSumMoney(year, type,symbol);
		// 返回的数据reData
		List<Map<String, Object>> reData = new ArrayList<Map<String, Object>>();
		// 从list中提取的Map集合key =month value={"name":4,"y":50135}
		Map<String, Map<String, Object>> yearData = new HashMap<String, Map<String, Object>>();
		// 把list集合的数据放到yearData集合,然后进行判断
		for (Map<String, Object> month : list) {
			yearData.put(month.get("name") + "", month);
		}
		// 补充缺少的月份(monthData即将会添加到reData中返回)
		Map<String, Object> monthData = null;
		for (int i = 1; i <= 12; i++) {
			// 获取value={"name":4,"y":50135}
			monthData = yearData.get(i + "");
			// 判断是否有值
			if (null == monthData) {
				// 没有值,补充一个
				monthData = new HashMap<String, Object>();
				monthData.put("name", i + "月");
				monthData.put(symbol, 0);
			} else {
				monthData.put("name", i + "月");// key重复时候,会替换
			}
			reData.add(monthData);
		}
		return reData;
	}
	
	private List<Map<String, Object>> manageData(String type, Long uuid,  Integer year ,Integer month,String symbol){
		// 对数据进行补充(有商品种类)[{"name":"数码家电","y":2000},{"name":"美食特产","y":20000}]
		List<Map<String, Object>> list = reportMapper.stroeOperReport(type, uuid, year, month,symbol);
		// 返回的数据reData
		List<Map<String, Object>> reData = new ArrayList<Map<String, Object>>();
		// 从list中提取的Map集合key =month value={"name":"数码家电","y":2000}
		Map<String, Map<String, Object>> typeData = new HashMap<String, Map<String, Object>>();
		// 把list集合的数据放到yearData集合,然后进行判断
		for (Map<String, Object> t : list) {
			typeData.put(t.get("name") + "", t);
		}
		//获取全部的商品类型
		List<Goodstype> allType = goodstypeMapper.findList();
		// 补充缺少的月份(monthData即将会添加到reData中返回)
		Map<String, Object> allTypeData = null;
		for (Goodstype gt:allType) {
			// 获取value={"name":"数码家电","y":2000}
			allTypeData = typeData.get(gt.getName());
			// 判断是否有值
			if (null == allTypeData) {
				// 没有值,补充一个
				allTypeData = new HashMap<String, Object>();
				allTypeData.put("name", gt.getName());
				allTypeData.put(symbol, 0);
			} else {
				allTypeData.put("name", gt.getName());// key重复时候,会替换
			}
			reData.add(allTypeData);
		}
		return reData;
	}
	
	
	


	
	
	

	
	
	
}
