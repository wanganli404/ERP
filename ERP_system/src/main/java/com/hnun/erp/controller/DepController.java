package com.hnun.erp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hnun.erp.bean.Dep;
import com.hnun.erp.bean.Emp;
import com.hnun.erp.bean.QueryObject;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.service.DepService;
import com.hnun.erp.util.BaseActionUtil;


@Controller
@RequestMapping("/dep")
public class DepController extends BaseController<Dep>{

	
	DepService depService;
	@Autowired
	public void setDepMapper(DepService depService) {
		this.depService = depService;
		this.baseService = depService;
	}
		
	
	@ResponseBody
	@PostMapping("/list")
	public List<Dep> list() {
		List<Dep> list = depService.selectByExample(null);
		
		return list;
	}
	
	
	
}
