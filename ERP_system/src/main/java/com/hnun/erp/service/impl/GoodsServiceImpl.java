package com.hnun.erp.service.impl;


import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Goods;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.mapper.GoodsMapper;
import com.hnun.erp.service.GoodsService;

import net.sf.jxls.transformer.XLSTransformer;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
  
	 private GoodsMapper goodsMapper;
	 
	 
	@Autowired
	public void setDepMapper( GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
		this.baseMapper= goodsMapper;
	}
	@Override
	public void doExport(OutputStream os,Goods goods,String userName,QueryObject queryObject) {
		//创建map集合存储数据
		Map<String, Object> dataMap = new HashMap<String,Object>();
		//获得所有的商品
		List<Goods> goodsList = super.getListByPage(null, goods, queryObject);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
		//获得当前时间
		Date date = new Date();
		//获得主角,也就是登录用户
		
		dataMap.put("userName", userName);//当前登录用户
		dataMap.put("goodsList", goodsList);//商品集合
		dataMap.put("sdf", sdf);//日期格式化器
		dataMap.put("date", date);//当前时间
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(new ClassPathResource("export_goods.xls").getInputStream());
			XLSTransformer transformer = new XLSTransformer();
			transformer.transformWorkbook(wb, dataMap);
			wb.write(os);
		} catch (Exception e) {
			e.printStackTrace(); 
		}finally {
			if (null != wb) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
}
