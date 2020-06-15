package com.hnun.erp.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.service.ReportService;
import com.hnun.erp.util.BaseActionUtil;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Resource
	ReportService reportService;
	
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	/**
	 * 销售/采购统计报表(以商品种类分组)
	 */
	
	@PostMapping("/ordersPieReport")
	public void ordersPieReport(QueryObject queryObject){
		List<Map<String, Object>> ordersreportData = reportService.orderReport(queryObject);
		BaseActionUtil.write(JSON.toJSONString(ordersreportData),response);
	}	
	
	/**
	 * 销售/采购统计报表(以商品名称分组)
	 */
	public void returnordersPieReport(QueryObject queryObject){
		List<Map<String, Object>> returnordersReportData = reportService.returnordersReport(queryObject);
		BaseActionUtil.write(JSON.toJSONString(returnordersReportData),response);
	}
	
	
	/**
	 * 采购/销售趋势分析
	 */
	
	@PostMapping("/trendReportWithAll")
	public void trendReportWithAll(String year){
		//默认选择2017年
		if (null == year) {
			Date date=new Date();
			long time = date.getTime();
			
			year="2020";
		}
		List<Map<String, Object>> trendReport = reportService.trendReport(year);
		BaseActionUtil.write(JSON.toJSONString(trendReport),response);
	}
	
	
	/**
	 * 仓库库存统计报表
	 */
	@PostMapping("/storedetailReport")
	public void storedetailReport(Long storeuuid){
		//默认选择仓库编号4年
		if (null == storeuuid) {
			storeuuid=1L;
		}
		List<Map<String, Object>> storedetailReport = reportService.storedetailReport(storeuuid);
		BaseActionUtil.write(JSON.toJSONString(storedetailReport),response);
	}
	
	
	
	/**
	 * 商品类型进出库价格总额比例
	 */
	@PostMapping("/stroeoperReport")
	public void stroeoperReport(String year,String month,Long storeuuid){
		//设置初始化数据
		if (null == year) {
			year = "2020";
		}
		if (null==month||"全年".equals(month)) {
			month="0";
		}
		
		List<Map<String, Object>> stroeoperReport = reportService.stroeoperReport(storeuuid, Integer.parseInt(year), Integer.parseInt(month));
		BaseActionUtil.write(JSON.toJSONString(stroeoperReport),response);
	}
	
	
	/**
	 * 盘盈盘亏，图表
	 */
	/*public void getInventoryReport(){
		List list = reportService.InventoryReport(storeuuid, new Integer(year), goodsuuid);
		BaseActionUtil.write(JSON.toJSONString(list));
//		this.write(list);
	}*/
	
}

	

