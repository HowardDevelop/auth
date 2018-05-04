package com.hzcominfo.application.auth.settings.kernel.entity;

import com.hzcominfo.application.common.annotation.TableSeg;
import com.hzcominfo.application.database.ibatis.entity.FormMap;

/**
 * 菜单实体表
 */
@TableSeg(tableName = "SYS_MENU", id = "MENU_ID")
public class SysMenuFormMap extends FormMap<String, Object> {

    /**
     * @descript
     * @author 潘益孟
     */
    private static final long serialVersionUID = 1L;

}
