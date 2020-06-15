package com.hnun.erp.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
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
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.DepExample;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.mapper.DepMapper;
import com.hnun.erp.service.DepService;

import net.sf.jxls.transformer.XLSTransformer;



@Service
public class DepServiceImpl extends BaseServiceImpl<Dep> implements DepService{
	
	private DepMapper depMapper;
	
	@Autowired
	public void setDepMapper(DepMapper depMapper) {
		this.depMapper = depMapper;
		this.baseMapper = depMapper;
	}
	
	

	@Override
	public List<Dep> selectByExample(DepExample example) {
		
		return depMapper.selectByExample(example);
	}

	@Override
	public void doExport(OutputStream os, Dep dep, String loginUser,QueryObject queryObject) {
		List<Dep> depList = super.getListByPage(null, dep,queryObject);
		//通过创建部门名称集合减少数据库查询次数
		Map<Long,String> depNameMap = new HashMap<Long,String>();
		for (Dep dep2 : depList) {
			depNameMap.put(dep2.getUuid(), dep2.getName());
		}
		//显示数据
		Map<String,Object> dataMap = new HashMap<String,Object>();
		//日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		//导出当前时间和导出人
		Date date = new Date();
		String dateNow = sdf.format(date);
		dataMap.put("date", dateNow);		
		dataMap.put("userName",loginUser);
		//将查询到的部门添加到数据
		dataMap.put("dep",depList);
		//将部门名称集合添加到数据中
		dataMap.put("depName",depNameMap);
		HSSFWorkbook wk = null;		 
        try {
            wk = new HSSFWorkbook(new ClassPathResource("export_dep.xls").getInputStream());
            XLSTransformer transformer = new XLSTransformer();	           
            transformer.transformWorkbook(wk, dataMap);
            wk.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(null != wk){
                try {
                    wk.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	
		
	}

	@Override
	public void doImport(InputStream is) throws IOException, ParseException  {
		HSSFWorkbook wb =null;
		try {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			//读取数据
			//读取最后一行行号
			int lastRow = sheet.getLastRowNum();
			//System.err.println(lastRow);
			Dep dep = null;
			for (int i = 4; i <= lastRow-3; i++) {			
				dep = new Dep();
				//通过部门名称来判断员工是否存在
				
				dep.setName(sheet.getRow(i).getCell(1).getStringCellValue());				
				List<Dep> list = super.getListByPage(null, dep, null);
				if (list.size()>0) {
					dep = list.get(0);
				}
				dep.setName(sheet.getRow(i).getCell(1).getStringCellValue());
				//根据格式选择不同方法
				try {
					dep.setTele(sheet.getRow(i).getCell(2).getStringCellValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					dep.setTele(Math.round(sheet.getRow(i).getCell(2).getNumericCellValue())+"");
					
				}								
				//如果用户不存在则添加
				if (list.size() == 0) {
					
					depMapper.insertSelective(dep);
				}
			}}	
		finally{
			if(null != wb){
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
