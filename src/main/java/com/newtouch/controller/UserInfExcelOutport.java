package com.newtouch.controller;

import com.newtouch.service.LoginSevice;
import com.newtouch.util.myannoncation.Export;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/13
 * Time:16:38
 **/
@Controller
@Export
public class UserInfExcelOutport {
    @Autowired
    LoginSevice loginSevice;

    @RequestMapping("/userInfExcelOutport")
    @ResponseBody
    @Export
    public String testMethodExcelOutport(Map map) {
        System.out.println("----------开始" + map.get("date"));
        //try {
            loginSevice.testMethodExcelOutport("张三", "12789");
        /*} catch (Exception e) {
            System.out.println("----------111" + e.getMessage());
        }*/
        System.out.println("----------结束");
        return "成功";
    }
}
