package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiLogUserLoginFormMap;
import com.hzcominfo.application.auth.settings.kernel.entity.LogUserLoginFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface ApiLogUserLoginMapper extends BaseMapper {
    public List<LogUserLoginFormMap> findByPage(LogUserLoginFormMap logUserLoginFormMap);

    public List<ApiLogUserLoginFormMap> getData(ApiLogUserLoginFormMap apiLogUserLoginFormMap);

    public List<ApiLogUserLoginFormMap> getNum(ApiLogUserLoginFormMap apiLogUserLoginFormMap);
}
