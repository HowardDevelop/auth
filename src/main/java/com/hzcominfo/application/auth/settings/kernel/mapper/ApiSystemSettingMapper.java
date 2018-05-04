package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiSystemSettingFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface ApiSystemSettingMapper extends BaseMapper {

    public List<ApiSystemSettingFormMap> findSettingByPage(ApiSystemSettingFormMap apiSystemSettingFormMap);
}
