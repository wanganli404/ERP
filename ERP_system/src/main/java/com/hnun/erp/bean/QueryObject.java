package com.hnun.erp.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class QueryObject {

	
	Long type;
	
	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startbirthday;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endbirthday;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date opertime;
	
	private Double startInprice;
	
	private Double endInprice;

	private Double startOutprice;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startOpertime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endOpertime;
	
	
	public Date getStartOpertime() {
		return startOpertime;
	}

	public void setStartOpertime(Date startOpertime) {
		this.startOpertime = startOpertime;
	}

	public Date getEndOpertime() {
		return endOpertime;
	}

	public void setEndOpertime(Date endOpertime) {
		this.endOpertime = endOpertime;
	}

	private Double endOutprice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startcreatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endcreatetime;
	public Date getStartcreatetime() {
		return startcreatetime;
	}

	public void setStartcreatetime(Date startcreatetime) {
		this.startcreatetime = startcreatetime;
	}

	public Date getEndcreatetime() {
		return endcreatetime;
	}

	public void setEndcreatetime(Date endcreatetime) {
		this.endcreatetime = endcreatetime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Double getStartInprice() {
		return startInprice;
	}

	public void setStartInprice(Double startInprice) {
		this.startInprice = startInprice;
	}

	

	public Double getEndInprice() {
		return endInprice;
	}

	public void setEndInprice(Double endInprice) {
		this.endInprice = endInprice;
	}

	public Double getStartOutprice() {
		return startOutprice;
	}

	public void setStartOutprice(Double startOutprice) {
		this.startOutprice = startOutprice;
	}

	public Double getEndOutprice() {
		return endOutprice;
	}

	public void setEndOutprice(Double endOutprice) {
		this.endOutprice = endOutprice;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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
