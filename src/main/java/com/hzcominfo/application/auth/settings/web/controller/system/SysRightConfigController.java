package com.hzcominfo.application.auth.settings.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcominfo.application.auth.settings.common.TreeUtil;
import com.hzcominfo.application.auth.settings.kernel.entity.SysMenuFormMap;
import com.hzcominfo.application.auth.settings.kernel.entity.SysRightConfigFormMap;
import com.hzcominfo.application.auth.settings.kernel.mapper.SysMenuMapper;
import com.hzcominfo.application.auth.settings.web.controller.common.AttrConstants;
import com.hzcominfo.application.auth.settings.web.controller.common.ForwardConstants;
import com.hzcominfo.application.auth.settings.web.controller.index.BaseController;
import com.hzcominfo.application.auth.settings.web.rdto.util.MenuTreeObject;
import com.hzcominfo.application.auth.settings.web.rdto.util.MenuTreeObjectUtil;
import com.hzcominfo.application.common.annotation.SystemLog;
import com.hzcominfo.application.common.server.SessionUtil;

/**
 * 
 * @author 潘益孟
 */
@Controller
@RequestMapping("/right/")
public class SysRightConfigController extends BaseController {
    @Inject
    private SysMenuMapper sysMenuMapper;

    /**
     * 权限分配页面
     * 
     * @param model
     * @return
     */
    @RequestMapping("menuRight")
    public String permissions(Model model) {
        String roleId = SessionUtil.getPara("roleId");
        SysMenuFormMap sysMenuFormMap = getFormMap(SysMenuFormMap.class);
        sysMenuFormMap.put("where", " where IS_HIDE =0");
        String order = " order by MENU_LEVEL asc";
        sysMenuFormMap.put("orderby", order);
        List<SysMenuFormMap> mps = sysMenuMapper.findByWhere(sysMenuFormMap);
        List<MenuTreeObject> list = new ArrayList<MenuTreeObject>();
        for (SysMenuFormMap map : mps) {
            MenuTreeObject ts = new MenuTreeObject();
            MenuTreeObjectUtil.map2Tree(ts, map, "menuId");
            list.add(ts);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<MenuTreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
        model.addAttribute("permissions", ns);
        model.addAttribute("roleId", roleId);
        return ForwardConstants.SYSTEM + ForwardConstants.MENU + ForwardConstants.MENU_RIGHT;
    }

    @ResponseBody
    @RequestMapping("addMenuRight")
    @Transactional(readOnly=false)//需要事务操作必须加入此注解
    @SystemLog(module="系统管理",methods="用户管理/菜单权限管理-修改权限")//凡需要处理业务逻辑的.都需要记录操作日志
    public String addUserRes() throws Exception {
        String roleId = SessionUtil.getPara("roleId");
        sysMenuMapper.deleteByAttribute("roleId", roleId, SysRightConfigFormMap.class);
        String[] menuIds = SessionUtil.getParaValues("menuId[]");
        if (menuIds != null && menuIds.length != 0 && menuIds[0] != null) {
        List<SysRightConfigFormMap> sysRightConfigFormMaps = new ArrayList<SysRightConfigFormMap>();
        for (String menuId : menuIds) {
            SysRightConfigFormMap sysRightConfigFormMap = new SysRightConfigFormMap();
            sysRightConfigFormMap.put("rightId", menuId);
            sysRightConfigFormMap.put("roleId", roleId);
            sysRightConfigFormMap.put("resourceFlag", '0');
            sysRightConfigFormMaps.add(sysRightConfigFormMap);

        }
        sysMenuMapper.batchSave(sysRightConfigFormMaps);
        }
        return AttrConstants.SUCCESS;
    }

}
