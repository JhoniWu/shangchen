package com.example.mymall.service.Wms;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymall.mbg.model.WmsWareSku;

import java.util.List;

/**
 * 商品库存
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:59:40
 */
public interface WareSkuService extends IService<WmsWareSku> {

	List<WmsWareSku> queryPage(Integer pageSize, Integer pageNum);

	void addStock(Long skuId, Long wareId, Integer skuNum);

}

