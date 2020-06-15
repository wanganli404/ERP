package com.hnun.erp.mapper;

import com.hnun.erp.bean.Store;
import com.hnun.erp.bean.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper extends BaseMapper<Store> {
    long countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}