package com.hnun.erp.mapper;

import com.hnun.erp.bean.Orderdetail;
import com.hnun.erp.bean.OrderdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailMapper extends BaseMapper<Orderdetail> {
    long countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}