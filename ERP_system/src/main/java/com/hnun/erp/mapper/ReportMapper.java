package com.hnun.erp.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import com.hnun.erp.bean.QueryObject;

public interface ReportMapper {
	String sql = "select gt.name as name,sum(od.money) as y "
			+ "from Goodstype gt, Goods g, Orders o, Orderdetail od "
			+ "where g.goodstypeuuid=gt.uuid and od.ordersuuid=o.uuid and od.goodsuuid=g.uuid ";

	@ResultType(Map.class)
	@Select({"<script>",
	    sql,
	    "<when test='endDate!=null'>",
	    "AND o.createtime &lt;= #{endDate}",
	    "</when>",
	    "<when test='startDate!=null'>",
	    "AND o.createtime &gt;= #{startDate}",
	    "</when>",
	    "<when test='type!=null'>",
	    "AND o.type= #{type}",
	    "</when>",
	    "group by gt.name",
	    "</script>"})
	public List<Map<String, Object>> orderReport(QueryObject q);
	
	String orderReport="select month(o.createtime) as name, sum(od.money) as #{symbol}"
			+ " from Orderdetail od, Orders o "
			+ " where od.ordersuuid=o.uuid "
			+ " and o.type=#{type} "
			+ " and year(o.createtime)=#{year}"
			+ " group by month(o.createtime)";
	@Select(orderReport)
	public List<Map<String, Object>> getSumMoney(int year, String type,String symbol);
	
	String storedetailReport="select gt.name as name, sum(sd.num) as y"
			+ " from Goods g, Goodstype gt, Storedetail sd "
			+ " where g.goodstypeuuid=gt.uuid "
			+ " and g.uuid = sd.goodsuuid "
			+ " and sd.storeuuid =#{storeuuid}"
			+ " group by gt.name";
	@Select(storedetailReport)
	public List<Map<String, Object>> storedetailReport(Long storeuuid);
	
	String stroeOperReport = "select gt.name as name,sum(so.num*g.inprice) as #{symbol} "
			+ "from Goodstype gt, Goods g, Storeoper so "
			+ "where g.goodstypeuuid=gt.uuid and so.goodsuuid = g.uuid "
			+ "and so.type =#{type} ";
	@Select(stroeOperReport)
	public List<Map<String, Object>> stroeOperReport(String type, Long uuid, Integer year, Integer month,String symbol);
		
	
  
	
	
	
}
