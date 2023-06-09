package com.example.mymall.dto.Wms;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseDoneVo {

	private Long id;//采购单id

	private List<PurchaseItemDoneVo> items;
}
