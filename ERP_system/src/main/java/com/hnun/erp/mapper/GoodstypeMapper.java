package com.hnun.erp.mapper;

import com.hnun.erp.bean.Goodstype;
import com.hnun.erp.bean.GoodstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper extends BaseMapper<Goodstype> {
    long countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    List<Goodstype> selectByExample(GoodstypeExample example);

    Goodstype selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}