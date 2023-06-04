package com.example.mymall.service.Wms;


import com.example.mymall.common.utils.guigu.utils.PageUtils;
import com.example.mymall.dto.WmsVo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

public interface PurchaseService {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase();


    void received(List<Long> ids);


    void done(PurchaseDoneVo doneVo);


}

