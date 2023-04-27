package com.example.mymall.service.PmsProduct.Attribute;

import com.example.mymall.mbg.model.PmsProductAttribute;

import java.util.List;

public interface PmsProductAttributeService {
	List<PmsProductAttribute> listAllAttribute();

	int createAttribute(PmsProductAttribute pmsProductAttributes);

	int updateAttribute(Long id, PmsProductAttribute pmsProductAttribute);

	int deleteAttribute(Long id);

	List<PmsProductAttribute> listAttribute(int pageNum, int pageSize);

	PmsProductAttribute getAttribute(Long id);
}
