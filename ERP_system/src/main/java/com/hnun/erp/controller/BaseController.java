package com.hnun.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.BaseService;
import com.hnun.erp.util.BaseActionUtil;
import com.hnun.erp.util.Pagination;


public class BaseController<T> {
    
	
	BaseService<T> baseService;
	
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	@GetMapping("/{uuid}")
	@ResponseBody
	public String getByPrimaryKey(@PathVariable Long uuid) {
		   T t = baseService.selectByPrimaryKey(uuid);
		   String jsonString = JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd");
		
			return jsonString;
	  }	
	
	  @ResponseBody
	  @PostMapping("/getListByPage") 
	  public Map<String, Object> getListByPage(Pagination page,T t,QueryObject queryObject) {
		//  long total;
		 List<T> list = baseService.getListByPage(page,t,queryObject);
		
		
			long total = baseService.count(queryObject.getType());  
		 
		 Map<String, Object> map = new HashMap<String, Object>();
			map.put("total",total);
			map.put("rows", list);
			return map;
	  }
	
	  @ResponseBody
	  @RequestMapping(value="/{uuid}",method=RequestMethod.DELETE)
	  public HashMap<String,Object> deleteByPrimaryKey(@PathVariable Long uuid) {
		 baseService.deleteByPrimaryKey(uuid);
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("success",true);
			rtn.put("message","删除成功");
			return rtn;
	  }
	
	  @ResponseBody
	  @PutMapping("/")
	  public HashMap<String,Object> updateByPrimaryKey(T t) {
		  baseService.updateByPrimaryKeySelective(t);
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("success",true);
			rtn.put("message","修改成功");
			return rtn;
	  }
	
	  @ResponseBody
	  @RequestMapping(value="/",method=RequestMethod.POST)
	  public HashMap<String,Object> add(T t) {
		  baseService.insertSelective(t);
		  HashMap<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("success",true);
			rtn.put("message","新增成功");
			return rtn;
	  }
	
	    @ResponseBody
		@PostMapping("/list")
		public List<T> list() {
			List<T> list = baseService.findList();
			
			return list;
		}
		
	    @PostMapping("/export")
		public void export(T t,QueryObject queryObject){
			
			Emp login = (Emp) SecurityUtils.getSubject().getPrincipal();
			String loginUser = login.getName();
			
			try {
				
				this.response.setHeader("Content-Disposition",  "attachment;filename=" + new String((t.getClass().getSimpleName()+".xls").getBytes(),"ISO-8859-1"));		
				 baseService.doExport(response.getOutputStream(),t,loginUser,queryObject);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	  
	    @PostMapping("/doImport")
		public void doImport(MultipartFile file) throws ParseException{
			//判断文件类型
			
			if (!"application/vnd.ms-excel".equals(file.getContentType())) {
				//文件类型不对
				BaseActionUtil.returnAjax(false, "导入的文件必须是excel文件!",response);
				return;
			}
			try {
			//	depService.doImport(new FileInputStream(file.));
				baseService.doImport(file.getInputStream());
				BaseActionUtil.returnAjax(true, "导入数据成功!",response);
			} catch (ERPException e) {
				BaseActionUtil.returnAjax(false, e.getMessage(),response);
				e.printStackTrace();
			} catch (IOException e) {
				BaseActionUtil.returnAjax(false, "导入数据失败!",response);
				e.printStackTrace();
			}
		}
	  
	  
}
