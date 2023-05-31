package com.example.mymall.nosql.mongodb.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: MyMall
 * @description: 会员浏览商品记录
 * @author: Max Wu
 * @create: 2023-05-08 15:47
 **/
@Getter
@Setter
@ToString
@Document
public class MemberReadHistory {
	@Id
	private String id;
	@Indexed
	private Long memberId;
	private String memberNickName;
	private String memberIcon;
	@Indexed
	private Long productId;
	private String productName;
	private String productPic;
	private String productSubTitle;
	private String productPrice;
	private Date createTime;
}
