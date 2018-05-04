package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.ApiRoleFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface ApiRoleMapper extends BaseMapper {

    public List<ApiRoleFormMap> findRoleByPage(ApiRoleFormMap apiRoleFormMap);

    public List<ApiRoleFormMap> seletUserRole(ApiRoleFormMap apiRoleFormMap);

    public void setDeleteById(String id);

    public List<ApiRoleFormMap> isRoleExist(ApiRoleFormMap apiRoleFormMap);

    public List<ApiRoleFormMap> isRoleBury(ApiRoleFormMap apiRoleFormMap);

    public List<ApiRoleFormMap> findXT(ApiRoleFormMap apiRoleFormMap);

    public List<ApiRoleFormMap> findDetail(ApiRoleFormMap apiRoleFormMap);

    public List<ApiRoleFormMap> count(ApiRoleFormMap apiRoleFormMap);


}
