package com.hzcominfo.application.auth.settings.kernel.mapper;


import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiSystemInfoFormMap;
import com.hzcominfo.application.auth.settings.kernel.entity.ApiUserFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;


public interface ApiSystemInfoMapper extends BaseMapper {

    List<ApiSystemInfoFormMap> findSystemInfoPage(ApiSystemInfoFormMap apiSystemInfoFormMap);

    List<ApiUserFormMap> findDetailSystem(ApiSystemInfoFormMap apiSystemInfoFormMap);

    String getCount(ApiSystemInfoFormMap apiSystemInfoFormMap);
}
