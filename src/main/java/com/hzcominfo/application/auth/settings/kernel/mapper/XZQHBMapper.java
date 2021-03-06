package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.XZQHBFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface XZQHBMapper extends BaseMapper {
    public List<XZQHBFormMap> findCityByProvince(String provinceId);
    public List<XZQHBFormMap> findDistrictByCity(String CityId);
}
