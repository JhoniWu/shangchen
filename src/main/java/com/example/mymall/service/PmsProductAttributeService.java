package com.example.mymall.service;

import com.example.mymall.mbg.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductAttributeService {
	List<PmsProductAttribute> listAllAttribute();

	@Transactional
	int createAttribute(PmsProductAttribute pmsProductAttributes);

	int updateAttribute(Long id, PmsProductAttribute pmsProductAttribute);

	int deleteAttribute(Long id);

	int deleteIds(List<Long> ids);

	List<PmsProductAttribute> listAttribute(int pageNum, int pageSize);

	PmsProductAttribute getAttribute(Long id);
}
