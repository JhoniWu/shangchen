package com.example.mymall.service.Wms;

import com.example.mymall.mbg.model.WmsWareInfo;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-02 16:41
 **/
public interface WareInfoService {
	List<WmsWareInfo> queryPage(Integer pageSize, Integer pageNum);
}
