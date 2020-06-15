package com.hnun.erp.bean;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class EmpDto extends Emp {
	
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startbirthday;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endbirthday;
	
	
	public Date getStartbirthday() {
		return startbirthday;
	}

	public void setStartbirthday(Date startbirthday) {
		this.startbirthday = startbirthday;
	}

	public Date getEndbirthday() {
		return endbirthday;
	}

	public void setEndbirthday(Date endbirthday) {
		this.endbirthday = endbirthday;
	}

	

}
