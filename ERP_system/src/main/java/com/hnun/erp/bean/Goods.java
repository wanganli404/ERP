package com.hnun.erp.bean;

public class Goods {
    private Long uuid;

    private String name;

    private String origin;

    private String producer;

    private String unit;

    private Double inprice;

    private Double outprice;

    private Long goodstypeuuid;
    
    private Goodstype goodstype;

    public Goodstype getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(Goodstype goodstype) {
		this.goodstype = goodstype;
	}

	public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public Long getGoodstypeuuid() {
        return goodstypeuuid;
    }

    public void setGoodstypeuuid(Long goodstypeuuid) {
        this.goodstypeuuid = goodstypeuuid;
    }
}