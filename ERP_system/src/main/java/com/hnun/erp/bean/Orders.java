package com.hnun.erp.bean;

import java.util.Date;
import java.util.List;



public class Orders {
	
	// 定义若干常量
	/** 未审核 */
	public static final String STATE_CREATE = "0";
	/** 已审核 */
	public static final String STATE_CHECK = "1";
	/** 已确认 */
	public static final String STATE_START = "2";
	/** 已入库 */
	public static final String STATE_END = "3";
	/**未出库*/
	public static final String STATE_NOT_OUT="0";
	/**已出库*/
	public static final String STATE_OUT="1";
	
	/** 采购订单 */
	public static final String TYPE_IN = "1";
	/** 销售订单 */
	public static final String TYPE_OUT = "2";

	
	
    private Long uuid;

    private Date createtime;

    private Date checktime;

    private Date starttime;

    private Date endtime;

    private String type;

    private Long creater;

    private Long checker;

    private Long starter;
    
    private String starterName;//采购员姓名
    
	private String checkerName;//审核员姓名
	
	private String createrName;//下单员姓名,,不设置映射

    private Long ender;
    
    private String enderName;//库管员姓名
    
    private String supplierName;//供应商/客户员姓名
    
	private Long supplieruuid;// 供应商或客户

    private Double totalmoney;

    private String state;

    private Long waybillsn;
    
	private List<Orderdetail> orderDetails; 


    public String getStarterName() {
		return starterName;
	}

	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getEnderName() {
		return enderName;
	}

	public void setEnderName(String enderName) {
		this.enderName = enderName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Orderdetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Orderdetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getChecker() {
        return checker;
    }

    public void setChecker(Long checker) {
        this.checker = checker;
    }

    public Long getStarter() {
        return starter;
    }

    public void setStarter(Long starter) {
        this.starter = starter;
    }

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Long supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getWaybillsn() {
        return waybillsn;
    }

    public void setWaybillsn(Long waybillsn) {
        this.waybillsn = waybillsn;
    }
}