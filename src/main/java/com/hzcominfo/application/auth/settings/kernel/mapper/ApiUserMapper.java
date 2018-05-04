package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiUserFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;


public interface ApiUserMapper extends BaseMapper {
	
    public void insertApiUser(ApiUserFormMap apiUserFormMap);
    public void editApiUSer(ApiUserFormMap apiUserFormMap);
    public List<ApiUserFormMap> findUserPage(ApiUserFormMap apiUserFormMap);
    public void updateByIds(Long[] list);
    public List<ApiUserFormMap> findDetailUser(ApiUserFormMap apiUserFormMap);
    public List<ApiUserFormMap> findBM(ApiUserFormMap apiUserFormMap);
    public List<ApiUserFormMap> count(ApiUserFormMap apiUserFormMap);
    public String getCount(ApiUserFormMap apiUserFormMap);
}
