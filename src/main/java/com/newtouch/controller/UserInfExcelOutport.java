package com.newtouch.controller;

import com.newtouch.service.LoginSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/13
 * Time:16:38
 **/
@Controller
public class UserInfExcelOutport {
    @Autowired
    LoginSevice loginSevice;

    @RequestMapping("/userInfExcelOutport")
    @ResponseBody
    public void testMethodExcelOutport() {
        System.out.println("----------开始");
        try {
            loginSevice.testMethodExcelOutport("张三", "12789");
        } catch (Exception e) {
            System.out.println("----------111" + e.getMessage());
        }
        System.out.println("----------结束");
    }
}
