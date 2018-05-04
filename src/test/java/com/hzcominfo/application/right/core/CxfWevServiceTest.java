package com.hzcominfo.application.right.core;

import com.hzcominfo.application.auth.core.service.AuthService;
import com.hzcominfo.application.common.server.CXFClientUtil;

public class CxfWevServiceTest {

    public static void main(String[] args) throws Exception {
        // 方式一
        AuthService hw = CXFClientUtil.getInterfaceService("http://localhost:8001/services/AuthService?wsdl", AuthService.class);
        String aa = hw.getAccessToken();
        System.out.println("*****" + aa.toString());
        
        // 方式二
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
//        Object[] objects = CXFClientUtil.getServiceResult("http://localhost:8001/services/RightService?wsdl", "getAccessToken","admin", "123456");
//        //输出调用结果
//        System.out.println("*****" + objects[0].toString());
    }

}
