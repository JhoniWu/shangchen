package com.example.mymall.dao;

import com.example.mymall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UmsAdminRoleRelationDao {
	List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
