package com.hzcominfo.application.auth.settings.web.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcominfo.application.auth.settings.kernel.entity.LogOperateFormMap;
import com.hzcominfo.application.auth.settings.kernel.mapper.LogOperateMapper;
import com.hzcominfo.application.auth.settings.web.controller.common.ForwardConstants;
import com.hzcominfo.application.auth.settings.web.controller.index.BaseController;
import com.hzcominfo.application.common.plugin.PageView;
import com.hzcominfo.application.common.util.StringUtil;

/**
 * 
 * @author 潘益孟
 */
@Controller
@RequestMapping("/logoperate/")
public class LogOperateController extends BaseController {
    @Inject
    private LogOperateMapper logMapper;

    @RequestMapping("list")
    public String listUI(Model model) throws Exception {
        return ForwardConstants.SYSTEM + ForwardConstants.LOG_OPERATE + ForwardConstants.LIST;
    }

    @ResponseBody
    @RequestMapping("findByPage")
    public PageView findByPage(String pageNow, String pageSize, String column, String sort) throws Exception {
        LogOperateFormMap logOperateFormMap = getFormMap(LogOperateFormMap.class);
        logOperateFormMap.put("column", StringUtil.prop2tablefield(column));
        logOperateFormMap.put("sort", sort);
        logOperateFormMap = toFormMap(logOperateFormMap, pageNow, pageSize, logOperateFormMap.getStr("orderby"));
        pageView.setRecords(logMapper.findByPage(logOperateFormMap));
        return pageView;
    }
}