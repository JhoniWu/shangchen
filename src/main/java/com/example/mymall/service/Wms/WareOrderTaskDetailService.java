package com.example.mymall.service.Wms;


import com.example.mymall.mbg.model.WmsWareOrderTaskDetail;

import java.util.List;

/**
 * 库存工作单
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:59:40
 */
public interface WareOrderTaskDetailService {

    List<WmsWareOrderTaskDetail> queryPage(Integer pageSize, Integer pageNum);
}

