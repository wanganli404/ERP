package com.hnun.erp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Goodstype;
import com.hnun.erp.bean.GoodstypeExample;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.GoodstypeMapper;
import com.hnun.erp.service.GoodsTypeService;

import net.sf.jxls.transformer.XLSTransformer;

@Service
public class GoodsTypeServiceImpl extends BaseServiceImpl<Goodstype> implements GoodsTypeService{

	private GoodstypeMapper goodstypeMapper;
	
	@Autowired
	public void setDepMapper(GoodstypeMapper goodstypeMapper) {
		this.goodstypeMapper = goodstypeMapper;
		this.baseMapper = goodstypeMapper;
	}

	@Override
	public List<Goodstype> selectByExample(GoodstypeExample example) {
		// TODO Auto-generated method stub
		return goodstypeMapper.selectByExample(example);
	}
	    
	/**
	 * 导出文件
	 */
	@Override
	public void doExport(OutputStream os, Goodstype goodstype,String userName,QueryObject queryObject) {
		//创建map集合存储数据
		Map<String, Object> dataMap = new HashMap<String,Object>();
		//获得所有的商品类型
		List<Goodstype> goodstypeList= super.getListByPage(null, goodstype, queryObject);
		//创建日期格式化器
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
		Date date = new Date();
		dataMap.put("userName", userName);
		dataMap.put("sdf", sdf);
		dataMap.put("date", date);
		dataMap.put("goodstypeList", goodstypeList);
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(new ClassPathResource("export_goodstype.xls").getInputStream());
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

	
	/**
	 * 导入文件
	 */
	@Override
	public void doImport(InputStream is) throws IOException {
		//创建工作薄
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(is);
			//获得工作表
			HSSFSheet sheet = wb.getSheetAt(0);
			if (!"Sheet1".equals(sheet.getSheetName())) {
				throw new ERPException("工作表名称不正确");
			}
			//读取数据 获得excel表的最后一行
			int lastRowNum = sheet.getLastRowNum();
			Goodstype goodstype = null;
			for (int i = 2; i <= lastRowNum; i++) {
				//构建查询条件
				goodstype = new Goodstype();
				goodstype.setName(sheet.getRow(i).getCell(1).getStringCellValue());//名称
				List<Goodstype>list= super.getListByPage(null, goodstype,null);
				if (list.size() > 0) {
					goodstype = list.get(0);
				}
				//更新
				goodstype.setName(sheet.getRow(i).getCell(1).getStringCellValue());//名称
				//添加
				if (list.size() == 0) {
					goodstype.setUuid(null);
					goodstypeMapper.insert(goodstype);
				}
			} 
		} finally {
			if (null != wb) {
				try {
					wb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
}

	

