package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.PmsProduct;
import com.example.mymall.mbg.model.PmsProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PmsProductMapper {
    int countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    int insertSelective(PmsProduct record);

    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProduct record);

    int updateByPrimaryKeyWithBLOBs(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);
}