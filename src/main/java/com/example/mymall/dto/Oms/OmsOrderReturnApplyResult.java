package com.example.mymall.dto.Oms;

import com.example.mymall.mbg.model.OmsCompanyAddress;
import com.example.mymall.mbg.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: MyMall
 * @description: 申请信息封装类
 * @author: Max Wu
 * @create: 2023-07-04 14:14
 **/
@Data
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
	@ApiModelProperty(value = "公司收获地址")
	private OmsCompanyAddress companyAddress;
}
