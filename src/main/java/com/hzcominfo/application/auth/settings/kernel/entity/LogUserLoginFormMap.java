package com.hzcominfo.application.auth.settings.kernel.entity;

import com.hzcominfo.application.common.annotation.TableSeg;
import com.hzcominfo.application.database.ibatis.entity.FormMap;

/**
 * 实体表
 */
@TableSeg(tableName = "LOG_USER_LOGIN", id = "ID")
public class LogUserLoginFormMap extends FormMap<String, Object> {
    private static final long serialVersionUID = 1L;

}
