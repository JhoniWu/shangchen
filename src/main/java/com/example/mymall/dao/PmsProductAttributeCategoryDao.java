package com.example.mymall.dao;

import com.example.mymall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

public interface PmsProductAttributeCategoryDao {
	List<PmsProductAttributeCategoryItem> getListWithAttr();
}
