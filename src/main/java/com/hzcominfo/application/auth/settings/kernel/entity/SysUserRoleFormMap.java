package com.hzcominfo.application.auth.settings.kernel.entity;

import com.hzcominfo.application.common.annotation.TableSeg;
import com.hzcominfo.application.database.ibatis.entity.FormMap;

/**
 * 实体表
 */
@TableSeg(tableName = "SYS_USER_ROLE", id = "USER_ID")
public class SysUserRoleFormMap extends FormMap<String, Object> {
    private static final long serialVersionUID = 1L;

}
