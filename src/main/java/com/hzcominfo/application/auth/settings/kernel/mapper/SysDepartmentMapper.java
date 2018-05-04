package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.SysDepartmentFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

public interface SysDepartmentMapper extends BaseMapper {

    public List<SysDepartmentFormMap> findParent(SysDepartmentFormMap sysDepartmentFormMap);
    
    public List<SysDepartmentFormMap> findAllData(SysDepartmentFormMap sysDepartmentFormMap);
    
    public SysDepartmentFormMap findDetailDepartment(SysDepartmentFormMap sysDepartmentFormMap);

    public List<SysDepartmentFormMap> findDepartmentByPage(SysDepartmentFormMap sysDepartmentFormMap);

    public String getCount(SysDepartmentFormMap sysDepartmentFormMap);

}
