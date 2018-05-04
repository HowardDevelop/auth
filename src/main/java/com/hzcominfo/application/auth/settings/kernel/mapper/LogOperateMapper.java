package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.LogOperateFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface LogOperateMapper extends BaseMapper{
    public List<LogOperateFormMap> findByPage(LogOperateFormMap logOperateFormMap);
}
