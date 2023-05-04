package com.example.mymall.dao;

import com.example.mymall.mbg.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 优选和商品关系自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 17:06
 **/
public interface CmsPrefrenceAreaProductRelationDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelations);
}
