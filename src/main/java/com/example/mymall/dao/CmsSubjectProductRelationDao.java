package com.example.mymall.dao;

import com.example.mymall.mbg.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品和专题关系自定义Dao
 */
public interface CmsSubjectProductRelationDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelations);
}
