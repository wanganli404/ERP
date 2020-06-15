package com.hnun.erp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.DepExample;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.EmpExample;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.mapper.DepMapper;
import com.hnun.erp.mapper.EmpMapper;
import com.hnun.erp.mapper.RoleMapper;
import com.hnun.erp.bean.Role;
import com.hnun.erp.bean.Tree;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.EmpService;
import com.hnun.erp.util.Md5Util;
import net.sf.jxls.transformer.XLSTransformer;







@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements EmpService {
	
	private EmpMapper empMappper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private DepMapper depMapper;

	@Autowired
	public void setEmpMapper(EmpMapper empMapper) {
		this.empMappper = empMapper;
		this.baseMapper = empMapper;
	}

	@Override
	public List<Emp> checkUser(Emp emp) {
		String username = emp.getUsername();
		String pwd = emp.getPwd();
		EmpExample empExample = new EmpExample();
		empExample.createCriteria().andUsernameEqualTo(username).andPwdEqualTo(pwd);
		return empMappper.selectByExample(empExample);
	}



	@Override
	public String selectByExampleWithRoles(Long uuid) {
		StringBuilder sb = new StringBuilder();
		/*EmpExample empExample = new EmpExample();
		empExample.createCriteria().andUuidEqualTo(uuid);*/
		Emp emp = empMappper.selectByExampleWithRoles(uuid);
		List<Role> roles = emp.getRoles();
		List<Role> allroles = roleMapper.selectByExample(null);
		for (Role role : roles) {
			for (Role role2 : allroles) {
				if (role.getName().equals(role2.getName())) {
					sb.append(role.getName());
					sb.append("  ");
				}
			}
		}
		return sb.toString().trim();
	}



	private static Date format(String str) throws ParseException  {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	 
	    Date result = sdf.parse(str);
	    return result;
	    
	}
	
	
	@Override
	public List<Emp> selectByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return empMappper.selectByExample(example);
	}

	@Override
	public void updatePwd(Long uuid, String oldPwd, String newPwd) {
		Emp emp = empMappper.selectByPrimaryKey(uuid);
		String pwd = emp.getPwd();
		/*if (!pwd.equals(oldPwd)) {
			throw new ERPException("原密码不正确");
		}*/
		if (!Md5Util.encryptByMd5(oldPwd, emp.getUsername()).equals(pwd)) {
			// 不匹配
			throw new ERPException("原密码不正确");
		}
		emp.setPwd(Md5Util.encryptByMd5(newPwd, emp.getUsername()));
	
		empMappper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void resetPwd(Long uuid, String newPwd) {

		  Emp emp = empMappper.selectByPrimaryKey(uuid);
		  emp.setPwd(Md5Util.encryptByMd5(newPwd, emp.getUsername()));
		  empMappper.updateByPrimaryKey(emp);
		
	}

	@Override
	public List<Tree> readEmpRoles(Long uuid) {
		List<Tree> treeList = new ArrayList<Tree>();
		// 获取用户信息
		Emp emp = empMappper.selectByExampleWithRoles(uuid);
		// 得到对应的角色list
		List<Role> empRoles = emp.getRoles();
		// 获取所有的角色
		List<Role> allRoles = roleMapper.selectByExample(null);
		// 创建单个Tree用来接收用户下的每个角色
		Tree t1 = null;
		for (Role r : allRoles) {
			t1 = new Tree();
			t1.setId(String.valueOf(r.getUuid()));//加入角色id
			t1.setText(r.getName());//加入角色名称
			//根据查询出来的用户角色判断是否有对应的,让其选择
			if (empRoles.contains(r)) {
				t1.setChecked(true);
			}
			//挂到角色大树上
			treeList.add(t1);
		}
		return treeList;
	}

	@Override
	public void updateEmpRoles(Long uuid, String checkedStr) {
		//获取用户信息
				Emp emp = empMappper.selectByPrimaryKey(uuid);
				//清空用户下原有的角色
				emp.setRoles(new ArrayList<Role>());
				//对checked进行去","处理
				String[] ids = checkedStr.split(",");
				//创建新的Role对象
				Role newRoles = null;
				for (String id : ids) {
					newRoles = roleMapper.selectByPrimaryKey(Long.valueOf(id));
					//设置用户的角色
					emp.getRoles().add(newRoles);
				}
				empMappper.updateEmpRoles(emp);
			/*	try {
					//更改用户角色后清除jedis中的缓存,让其重新加载最新的
					jedis.del("menuList_" + uuid);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
		
	}

	@Override
	public Emp findByUsernameAndPwd(String username, String pwd) {
		String encryptByMd5 = Md5Util.encryptByMd5(pwd, username);
		EmpExample empExample = new EmpExample();
		empExample.createCriteria().andUsernameEqualTo(username).andPwdEqualTo(encryptByMd5);
		return empMappper.selectByExample(empExample).get(0);
	}
	
	@Override
	public void doExport(OutputStream os,Emp t1,String userName,QueryObject queryObject){
		
		 List<Emp> empList =super.getListByPage(null, t1, null);
		//显示性别名称
		Map<Long,String> genderNameMap = new HashMap<Long,String>();
		genderNameMap.put((long) 1, "男");
		genderNameMap.put((long) 2, "女");
		//显示部门名称
		Map<Long,String> depNameMap = new HashMap<Long,String>();
		for (Emp emp : empList) {
			depNameMap.put(emp.getUuid(), emp.getDep().getName());
		}
		//显示数据
		Map<String,Object> dataMap = new HashMap<String,Object>();
		//日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		//导出当前时间和导出人
		Date date = new Date();
		String dateNow = sdf.format(date);
		dataMap.put("date", dateNow);
		dataMap.put("userName", userName);
		dataMap.put("emp", empList);
		dataMap.put("depName",depNameMap);
		dataMap.put("sdf", sdf);
		dataMap.put("gender", genderNameMap);
		 HSSFWorkbook wk = null;
		 
	        try {
	            wk = new HSSFWorkbook(new ClassPathResource("export_emp.xls").getInputStream());
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
	public void doImport(InputStream is) throws IOException, ParseException{
		HSSFWorkbook wb =null;
		//将字符串性别,转换成gender
		Map<String,Long> genderMap = new HashMap<String,Long>();
		genderMap.put("男", (long) 1);
		genderMap.put("女", (long) 2);
		try {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			//读取数据
			//读取最后一行行号
			int lastRow = sheet.getLastRowNum();
			System.out.println(lastRow);
			Emp emp = null;
			for (int i = 4; i <= lastRow-3; i++) {
				
				
				emp = new Emp();
				//通过员工姓名来判断员工是否存在
			//	emp.setName(sheet.getRow(i).getCell(2).getStringCellValue());	
				String name = sheet.getRow(i).getCell(2).getStringCellValue();
				
				EmpExample empExample=new EmpExample();
				empExample.createCriteria().andNameEqualTo(name);
				
				List<Emp> list = empMappper.selectByExample(empExample);
		//		List<Emp> list = empDao.getList(null,emp,null);
				if (list.size()>0) {
					emp = list.get(0);
				}
				//sheet.getRow(i).getCell(1).set
				sheet.getRow(i).getCell(1).setCellType(CellType.STRING);
				emp.setUsername(sheet.getRow(i).getCell(1).getStringCellValue());
				sheet.getRow(i).getCell(2).setCellType(CellType.STRING);
				emp.setName(sheet.getRow(i).getCell(2).getStringCellValue());
				sheet.getRow(i).getCell(3).setCellType(CellType.STRING);
				emp.setGender(genderMap.get(sheet.getRow(i).getCell(3).getStringCellValue()));
				sheet.getRow(i).getCell(4).setCellType(CellType.STRING);
				emp.setEmail(sheet.getRow(i).getCell(4).getStringCellValue());
				//根据格式选择不同方法
				try {
					emp.setTele(sheet.getRow(i).getCell(5).getStringCellValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					emp.setTele(Math.round(sheet.getRow(i).getCell(5).getNumericCellValue())+"");
					
				}
				sheet.getRow(i).getCell(6).setCellType(CellType.STRING);
				emp.setAddress(sheet.getRow(i).getCell(6).getStringCellValue());
				
				//判断不同日期格式,不同添加方法
				try {
					emp.setBirthday(sheet.getRow(i).getCell(7).getDateCellValue());
				} catch (Exception e) {
					sheet.getRow(i).getCell(7).setCellType(CellType.STRING);
					emp.setBirthday(format(sheet.getRow(i).getCell(7).getStringCellValue()));
				}
				//通过部门名称获取部门
				
				String depName =sheet.getRow(i).getCell(8).getStringCellValue();
				if (depName != null || depName.trim().length() > 0) {
					Dep dep = new Dep();
					sheet.getRow(i).getCell(8).setCellType(CellType.STRING);
					dep.setName(sheet.getRow(i).getCell(8).getStringCellValue());
					DepExample depExample=new DepExample();
					depExample.createCriteria().andNameEqualTo(depName);
					List<Dep> result = depMapper.selectByExample(depExample);
				
					if (result.size() > 0) {
						emp.setDepuuid((result.get(0).getUuid()));
					}else{
						emp.setDep(null);
					}					
				}
				//如果用户不存在则添加
				if (list.size() == 0) {
					empMappper.insertSelective(emp);
				}else {
					empMappper.updateByPrimaryKeySelective(emp);
				}
			}		
		}finally{
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
