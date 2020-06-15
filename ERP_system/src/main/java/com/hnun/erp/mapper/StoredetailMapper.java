package com.hnun.erp.mapper;

import com.hnun.erp.bean.StoreAlert;
import com.hnun.erp.bean.Storedetail;
import com.hnun.erp.bean.StoredetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StoredetailMapper extends BaseMapper<Storedetail> {
    long countByExample(StoredetailExample example);

    int deleteByExample(StoredetailExample example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    List<Storedetail> selectByExample(StoredetailExample example);

    Storedetail selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

    int updateByExample(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);
    @Select("select * from storedetail where goodsuuid=#{goodsuuid} and storeuuid=#{storeuuid}")
	public List<Storedetail> getList(Storedetail queryParam);
    @Select("select * from view_storealert where outnum>storenum")
    public List<StoreAlert> getStroealertList();

	public List<StoreAlert> selectStorenum();

	public int selectSendnum();
}