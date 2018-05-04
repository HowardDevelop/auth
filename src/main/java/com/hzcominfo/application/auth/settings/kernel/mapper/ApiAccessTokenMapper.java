package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiAccessTokenFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;



public interface ApiAccessTokenMapper extends BaseMapper {
    public List<ApiAccessTokenFormMap> seletUserRole(ApiAccessTokenFormMap ApiAccessTokenFormMap);

    
}
