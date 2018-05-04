package com.hzcominfo.application.auth.settings.kernel.entity;

import com.hzcominfo.application.common.annotation.TableSeg;
import com.hzcominfo.application.database.ibatis.entity.FormMap;

/**
 * 实体表
 */
@TableSeg(tableName = "API_ROLE", id = "ROLE_ID")
public class ApiRoleFormMap extends FormMap<String, Object> {
	private static final long serialVersionUID = 1L;

}
