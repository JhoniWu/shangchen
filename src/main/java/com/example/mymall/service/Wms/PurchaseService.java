package com.example.mymall.service.Wms;


import com.example.mymall.dto.MergeVo;
import com.example.mymall.dto.PurchaseDoneVo;
import com.example.mymall.mbg.model.WmsPurchase;

import java.util.List;

public interface PurchaseService {

    //全部订单
    List<WmsPurchase> queryPage(WmsPurchase purchase, Integer pageSize, Integer pageNum);

    //没有收货的订单
    List<WmsPurchase> queryPageUnreceivePurchase(WmsPurchase purchase, Integer pageSize, Integer pageNum);


    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);

}

