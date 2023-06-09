package com.example.mymall.dto.Wms;

import lombok.Data;

@Data
public class PurchaseItemDoneVo {
	//{itemId:1,status:4,reason:""}
	private Long itemId;
	private Integer status;
	private String reason;
}
