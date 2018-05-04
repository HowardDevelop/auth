package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.SysRoleFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface SysRoleMapper extends BaseMapper {
    public List<SysRoleFormMap> seletUserRole(SysRoleFormMap sysRoleFormMap);

    public void deleteById(SysRoleFormMap sysRoleFormMap);

    public List<SysRoleFormMap> findRolePage(SysRoleFormMap sysRoleFormMap);

    public List<SysRoleFormMap> count(SysRoleFormMap sysRoleFormMap);
}
