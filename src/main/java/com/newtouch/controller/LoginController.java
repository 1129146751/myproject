package com.newtouch.controller;

import com.newtouch.mapperDao.StudentMapper;
import com.newtouch.mapperDao.TabAdressMapper;
import com.newtouch.mapperDao.UserMapper;
import com.newtouch.model.Student;
import com.newtouch.model.SysUser;
import com.newtouch.model.TabAdress;
import com.newtouch.model.User;
import com.newtouch.service.LoginSevice;
import com.newtouch.service.StudentSevice;
import com.newtouch.service.TabTestSevice;
import com.newtouch.service.UserSevice;
import com.newtouch.serviceImp.TabTestSeviceImp;
import com.newtouch.util.ValidateCode.RandomValidateCode;
import com.newtouch.util.resultjson.ResultJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/25
 * Time:13:22
 **/
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginSevice loginSevice;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentSevice studentSevice;
    @Autowired
    private UserSevice userSevice;
    @Autowired
    private TabTestSevice tabTestSeviceImp;
    @Autowired
    private TabAdressMapper tabAdressMapper;
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String userLogin() {
        return "success";
    }

    @RequestMapping(value = "/userLogin2", method = RequestMethod.GET)
    public String userLogin2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("data", "山东省开发技术可");
        return "success";
    }

    @RequestMapping(value = "/userLogin3", method = RequestMethod.PUT)
    @ResponseBody
    public String userLogin3() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("data", "山东省开发技术可");
        return "success";
    }

    /**
     * 通过c3p0连接池里面去拿连接
     *
     * @return
     */
    @RequestMapping(value = "/userLogin4", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin4() {
        loginSevice.userLogin();
        return "success";
    }

    /**
     * spring 自带的jdbcTemplate 去操作数据库
     * 将datasource
     *
     * @return
     */
    @RequestMapping(value = "/userLogin5", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin5() {
        loginSevice.userLogin5();
        return "success";
    }

    /**
     * 将连接池 交给mybatis管理  使用mapper代理的方式（非通用mapper）
     *
     * @return
     */
    @RequestMapping(value = "/userLogin6", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin6() {
        //loginSevice.userLogin6();
        User user = userMapper.selectByPrimaryKey(Long.parseLong("22"));
        log.info(user.toString());
        return "success";
    }

    /**
     * c
     * 将连接池 交给mybatis管理  使用mapper代理的方式（非通用mapper） 事务
     *
     * @return
     */
    @RequestMapping(value = "/userLogin66", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin66() {
        //loginSevice.userLogin6();
        /*User user=userMapper.selectByPrimaryKey(Long.parseLong("22"));
        log.info(user.toString());
        user.setuId(null);
        user.setuName("java");
        userMapper.insertSelective(user);*/
        try {
            userSevice.add();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return "success";
    }

    /**
     * 将连接池 交给mybatis管理  使用mapper代理的方式（通用mapper）
     *
     * @return
     */
    @RequestMapping(value = "/userLogin7", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin7() {
        //loginSevice.userLogin6();
        Student student = studentMapper.selectByPrimaryKey("1");
        log.info(student.toString());
        return "success";
    }

    /**
     * 将连接池 交给mybatis管理  使用mapper代理的方式（通用mapper）
     *
     * @return
     */
    @RequestMapping(value = "/userLogin8", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin8() {
        //loginSevice.userLogin6();
        studentSevice.method();
        return "success";
    }

    /**
     * 通用mapper的example
     *
     * @return
     */
    @RequestMapping(value = "/userLogin9", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin9() {
        //loginSevice.userLogin6();
        studentSevice.method2();
        return "success";
    }

    /**
     * 通用mapper的example
     *
     * @return
     */
    @RequestMapping(value = "/userLogin10", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson userLogin10() {
        tabTestSeviceImp.method();
        return ResultJson.success("成功");
    }

    /**
     * 通用mapper的example  注解翻译 单表查询
     *
     * @return
     */
    @RequestMapping(value = "/userLogin11", method = RequestMethod.GET)
    @ResponseBody
    public Object userLogin11() {
        List<TabAdress> ts = tabAdressMapper.selectAll();
        log.info(ts.toString());
        return ResultJson.success(ts, "查询数据成功");
    }

    public void method12() {
        Example e = new Example(User.class);
        Example.Criteria c = e.createCriteria();
        //tabAdressMapper.
        log.info("说明springmvc扫包是 将加有@Contorller注解的类交给spring管理。创建对象");
    }




    /*正儿八经的登陆功能的实现*/
    /**
     * 登录页面生成验证码
     */
    @Autowired
    private RandomValidateCode randomValidateCode;

    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        //RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    @RequestMapping(value = "/userShiroLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson userShiroLogin(HttpServletRequest request,
                                     SysUser user, @RequestParam("vaildata") String vaildata) throws Exception {
        InetAddress inet = InetAddress.getLocalHost();
        log.info("主机地址" + inet);
        log.info("前段传过来的验证码：" + vaildata.toLowerCase());
        log.info("正确的session" + request.getSession().getAttribute("RANDOMVALIDATECODEKEY") + "".toLowerCase());
        String correct = request.getSession().getAttribute("RANDOMVALIDATECODEKEY").toString().toLowerCase();
        if (!Objects.equals(vaildata.toLowerCase(), correct)) {
            log.info("验证码不正确");
            return ResultJson.fail("验证码不正确");

        }
        //ModelAndView mv=new ModelAndView();
        //创建Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();
        //判断当前用户是否已登录
        if (currentUser.isAuthenticated() == false) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserLonginName(),
                    user.getUserPassword());
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                e.getMessage();
                e.printStackTrace();
                System.out.println("登录失败");
                return ResultJson.fail();
            }
        }
        request.getSession().setAttribute("username", user.getUserLonginName());
        //mv.setViewName("success");
        return ResultJson.success();

    }

    /* @RequestMapping("/zhuye")
     public ModelAndView enjoinZhuYe(){
         ModelAndView mv=new ModelAndView();
                 mv.setViewName("index");
                 System.out.println("user/zhuyeuser/zhuyeuser/zhuyeuser/zhuyeuser/zhuye");
         return mv;
     }*/
    @PostMapping("/sfsklfs")
    public void method1() {

    }
}
