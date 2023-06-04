package com.example.mymall.dao.Wms;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymall.mbg.model.WmsPurchase;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-11-17 13:50:10
 */
@Mapper
public interface WmsPurchaseDao extends BaseMapper<WmsPurchase> {

}
