package com.example.mymall.service.Wms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymall.common.utils.guigu.utils.PageUtils;
import com.example.mymall.mbg.model.WmsPurchaseDetail;

import java.util.List;
import java.util.Map;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-02 16:42
 **/
public interface PurchaseDetailService extends IService<WmsPurchaseDetail> {
	PageUtils queryPage(Map<String, Object> params);

	List<WmsPurchaseDetail> listDetailByPurchaseId(Long id);
}
