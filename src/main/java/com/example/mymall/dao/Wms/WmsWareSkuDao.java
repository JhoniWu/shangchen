package com.example.mymall.dao.Wms;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymall.mbg.model.WmsWareSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:59:40
 */
@Mapper
public interface WmsWareSkuDao extends BaseMapper<WmsWareSku> {

	void addStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("skuNum") Integer skuNum);

}
