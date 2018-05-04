package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.SysMenuFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface SysMenuMapper extends BaseMapper {
    public List<SysMenuFormMap> findChildlists(SysMenuFormMap sysMenuFormMap);

    public List<SysMenuFormMap> findRoleMenu(SysMenuFormMap sysMenuFormMap);

    public void updateSortOrder(List<SysMenuFormMap> sysMenuFormMap);

}
