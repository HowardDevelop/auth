package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.SysUserFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface SysUserMapper extends BaseMapper {

    public List<SysUserFormMap> findUserPage(SysUserFormMap sysUserFormMap);

    public List<SysUserFormMap> count(SysUserFormMap sysUserFormMap);

    public List<SysUserFormMap> findDetailUser(SysUserFormMap sysUserFormMap);

}
