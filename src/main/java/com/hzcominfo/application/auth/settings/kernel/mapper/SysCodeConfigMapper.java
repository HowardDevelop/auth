package com.hzcominfo.application.auth.settings.kernel.mapper;

import java.util.List;

import com.hzcominfo.application.auth.settings.kernel.entity.SysCodeConfigFormMap;
import com.hzcominfo.application.database.ibatis.mapper.BaseMapper;

/**
 * 类说明：参数设置DAO接口
 *
 * @author lixl
 *
 */
public interface SysCodeConfigMapper extends BaseMapper {

    public List<SysCodeConfigFormMap> findSysCodeConfig(SysCodeConfigFormMap sysCodeConfigFormMap);

    public List<SysCodeConfigFormMap> findChildsByParent(SysCodeConfigFormMap sysCodeConfigFormMap);

    public SysCodeConfigFormMap findByNameCode(SysCodeConfigFormMap sysCodeConfigFormMap);

    public void insertSysCodeConfig(SysCodeConfigFormMap sysCodeConfigFormMap);

    public List<SysCodeConfigFormMap> findByDetailDis(SysCodeConfigFormMap sysCodeConfigFormMap);

    public List<SysCodeConfigFormMap> findByParentName(SysCodeConfigFormMap sysCodeConfigFormMap);

    public List<SysCodeConfigFormMap> findConfigName(SysCodeConfigFormMap sysCodeConfigFormMap);

    public void editByAttribute(SysCodeConfigFormMap autoConfigFormMap) throws Exception;

    public void updateSortOrder(List<SysCodeConfigFormMap> listSysCodeConfigFormMap);

    public SysCodeConfigFormMap transByConfigCodeAndValue(SysCodeConfigFormMap autoConfigFormMap);

    public List<SysCodeConfigFormMap> transByConfigCodeAndMultiValue(SysCodeConfigFormMap autoConfigFormMap);

    public Object findByConfigName(Object obj);

    public List<SysCodeConfigFormMap> getIncrementDS();

    public List<SysCodeConfigFormMap> findIncrementDataSourceByAppID(SysCodeConfigFormMap sysCodeConfigFormMap);

    public SysCodeConfigFormMap findByAppId(SysCodeConfigFormMap sysCodeConfigFormMap);
    
    public List<SysCodeConfigFormMap> findAllConfig();
}
