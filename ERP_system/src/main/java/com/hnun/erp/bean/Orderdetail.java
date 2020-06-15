package com.hnun.erp.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Orderdetail {
	
	/**未入库 */
	public static final String STATE_NOT_IN = "0";
	/**已入库*/
	public static final String STATE_IN = "1";
	
	/**未出库 */
	public static final String STATE_NOT_OUT= "0";
	/**已出库*/
	public static final String STATE_OUT = "1";
	
    private Long uuid;

    private Long goodsuuid;

    private String goodsname;

    private Double price;

    private Long num;

    private Double money;
   
    private Date endtime;

    private Long ender;

    private Long storeuuid;

    private String state;

    private Long ordersuuid;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Long goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(Long ordersuuid) {
        this.ordersuuid = ordersuuid;
    }
}