package com.hzcominfo.application.right.core;

import java.util.HashMap;
import java.util.Map;

import com.hzcominfo.application.common.server.CXFClientUtil;

public class Test {
    public static void main(String[] args)  {
//        String right_url = "http://10.118.133.6:8001/services/InterfaceService?wsdl";
        String right_url1 = "http://localhost:8001/services/InterfaceService?wsdl";
        String right_funcname = "authentication";
        Map<String, String> user_map = new HashMap<String, String>();
        user_map.put("name", "HZGAUserName");
        user_map.put("sfzh", "HZGAUserCardId");
        user_map.put("deptment", "HZGAUserDept");
        user_map.put("companyName", "HZGAUserCompanyName");
        user_map.put("companyAddress", "HZGAUserCompanyAddress");
        String user = "{\"name\":\"test\",\"companyName\":\"8976543432456\",\"companyAddress\":\"486754\"}";
        Object[] obj= new  Object[]{"406ce5a7-0ef5-4027-8917-68a610234912", "1111", "接口1", "10.118.159.44",user,"code:1"};
        Object[] objects = null;
        /*JaxWsDynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = dynamicClientFactory.createClient("http://10.118.159.44:8001/services/RightService?wsdl");
        try {
            client.invoke("getAccessToken", "admin", "123456");
        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }*/
//        InterfaceService hw = CXFClientUtil.getInterfaceService(right_url1, InterfaceService.class);
        try {
            objects = CXFClientUtil.getServiceResult(right_url1, right_funcname, obj);
//            flag = hw.authentication("234234", "dgsdgd", "sdgsdg", "dgsdgsdg", user_map, "asfasf");
//            _res = CXFClientUtil.getServiceResult(right_url, right_funcname, "1", "2","333",user_map);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(objects[0].toString());
    }
}
