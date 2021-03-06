package com.hzcominfo.application.auth.settings.web.controller.index;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hzcominfo.application.auth.settings.common.TreeUtil;
import com.hzcominfo.application.auth.settings.kernel.entity.LogUserLoginFormMap;
import com.hzcominfo.application.auth.settings.kernel.entity.SysMenuFormMap;
import com.hzcominfo.application.auth.settings.kernel.entity.SysUserFormMap;
import com.hzcominfo.application.auth.settings.kernel.mapper.LogUserLoginMapper;
import com.hzcominfo.application.auth.settings.kernel.mapper.SysMenuMapper;
import com.hzcominfo.application.auth.settings.kernel.mapper.SysUserMapper;
import com.hzcominfo.application.auth.settings.web.controller.common.AttrConstants;
import com.hzcominfo.application.auth.settings.web.controller.common.ForwardConstants;
import com.hzcominfo.application.auth.settings.web.rdto.util.MenuTreeObject;
import com.hzcominfo.application.auth.settings.web.rdto.util.MenuTreeObjectUtil;
import com.hzcominfo.application.common.server.SessionUtil;
import com.hzcominfo.application.common.util.StringUtil;
import com.hzcominfo.application.common.util.encrypt.Encrypt;

/**
 * 进行管理后台框架界面的类
 * 
 * @author 潘益孟
 */
@Controller
@RequestMapping("/")
public class BackgroundController extends BaseController {

    @Inject
    private SysMenuMapper sysMenuMapper;

    @Inject
    private LogUserLoginMapper logUserLoginMapper;

    @Inject
    private SysUserMapper sysUserMapper;

    // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hell:Hello Shanhy}")
    private String hello = "";
    // 密码加密
    private Encrypt encrypt = new Encrypt();

    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value = "")
    public String toIndex() {
        return ForwardConstants.REDIRECT + ForwardConstants.LOGIN;
    }

    /**
     * 进入登陆画面
     */
    /**
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String login(HttpServletRequest request) {
        request.removeAttribute("error");
        return ForwardConstants.LOGIN;
    }

    /**
     * 用户登录验证
     * 
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String login(String username, String password, HttpServletRequest request) {
        try {
            if (!request.getMethod().equals("POST")) {
                request.setAttribute(AttrConstants.ERROR, "支持POST方法提交！");
            }
            if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
                request.setAttribute(AttrConstants.ERROR, "用户名或密码不能为空！");
                return ForwardConstants.LOGIN;
            }
            SysUserFormMap sysUserFormMap = new SysUserFormMap();
            sysUserFormMap.put("where", "where user_name='" + username + "' and DELETE_STATUS='0' and locked='0'");
            List<SysUserFormMap> mps = sysUserMapper.findByWhere(sysUserFormMap);
            if (mps != null && mps.size() > 0) {
                SysUserFormMap tempUserFormMap = mps.get(0);
                if (tempUserFormMap.containsKey("password") && tempUserFormMap.getStr("password") != null) {
                    String dbPassword = encrypt.decoder(tempUserFormMap.getStr("password"));
                    if (dbPassword.equals(password)) {
                        SessionUtil.setUserSession(tempUserFormMap);
                        SessionUtil.setUserIdSession(tempUserFormMap.getInt("userId").toString());
                    } else {
                        request.setAttribute(AttrConstants.ERROR, "用户名或密码不正确！");
                        return ForwardConstants.LOGIN;
                    }
                } else {
                    request.setAttribute(AttrConstants.ERROR, "用户名或密码不正确！");
                    return ForwardConstants.LOGIN;
                }
            }
            // 保存登陆记录
            LogUserLoginFormMap logUserLoginFormMap = new LogUserLoginFormMap();
            logUserLoginFormMap.put("userId", SessionUtil.getUserIdSession());
            logUserLoginFormMap.put("userName", username);
            logUserLoginFormMap.put("loginIp", SessionUtil.getIpAddress());
            logUserLoginMapper.addEntity(logUserLoginFormMap);
            request.removeAttribute(AttrConstants.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(AttrConstants.ERROR, "登录异常，请联系管理员！");
            return ForwardConstants.LOGIN;
        }
        return ForwardConstants.REDIRECT + ForwardConstants.INDEX;
    }

    /**
     * 进入主页面
     */
    /**
     * @mod Ekko 2015-09-07
     * @throws Exception
     */
    @RequestMapping("index")
    public String index(Model model) throws Exception {
        // 获取登录的bean
        SysUserFormMap sysUserFormMap = (SysUserFormMap) SessionUtil.getUserSession();
        SysMenuFormMap sysMenuFormMap = new SysMenuFormMap();
        sysMenuFormMap.put("userId", sysUserFormMap.get("userId"));
        List<SysMenuFormMap> mps = sysMenuMapper.findRoleMenu(sysMenuFormMap);
        // List<SysMenuFormMap> mps = sysMenuMapper.findByWhere(new
        // SysMenuFormMap());
        List<MenuTreeObject> list = new ArrayList<MenuTreeObject>();
        for (SysMenuFormMap map : mps) {
            MenuTreeObject ts = new MenuTreeObject();
            MenuTreeObjectUtil.map2Tree(ts, map, "menuId");
            list.add(ts);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<MenuTreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
        model.addAttribute("list", ns);
        // 登陆的信息回传页面
        model.addAttribute("sysUserFormMap", sysUserFormMap);
        return ForwardConstants.INDEX;
    }

    @RequestMapping("download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        java.io.BufferedInputStream bis = null;
        java.io.BufferedOutputStream bos = null;

        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\" + "filezip\\";
        String downLoadPath = ctxPath + fileName;
        System.out.println(downLoadPath);
        try {
            long fileLength = new File(downLoadPath).length();
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    /**
     * 推出系统
     * 
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        // 使用权限管理工具进行用户的退出，注销登录
        SessionUtil.removeUserSession();
        SessionUtil.removeUserIdSession();
        return ForwardConstants.REDIRECT + ForwardConstants.LOGIN;
    }
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("list")
    public String listUI(){
        return ForwardConstants.SYSTEM+"/"+ForwardConstants.INDEX+ ForwardConstants.LIST;
        
    }

    
}
