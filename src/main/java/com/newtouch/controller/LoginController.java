package com.newtouch.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newtouch.mapperDao.*;
import com.newtouch.model.*;
import com.newtouch.service.LoginSevice;
import com.newtouch.service.StudentSevice;
import com.newtouch.service.TabTestSevice;
import com.newtouch.service.UserSevice;
import com.newtouch.serviceImp.TabTestSeviceImp;
import com.newtouch.util.ValidateCode.RandomValidateCode;
//import com.newtouch.util.excel.easypoi.FileUtil;
import com.newtouch.util.reflect.SpringReflectUtil;
import com.newtouch.util.resultjson.ResultJson;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Autowired
    private UpdownloadLogMapper updownloadLog;
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

    @Autowired
    private EmployeeMapper employeeMapper;

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

    @Autowired
    private UpdownloadLogMapper downloadLog;

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

    @RequestMapping(value = "/userLogin3")
    @ResponseBody
    public String userLogin3() throws Exception {
        Object obj = SpringReflectUtil.getObject("userInfExcelOutport");
        //得到对象实例化
        Class<?> o = obj.getClass();
        UserInfExcelOutport U = (UserInfExcelOutport) SpringReflectUtil.getObject("userInfExcelOutport");
        //U.testMethodExcelOutport();
        Object stance = o.newInstance();
        //得到方法
        Method me = o.getMethod("testMethodExcelOutport", new Class[]{Map.class});
        Map map = new HashMap();
        map.put("date", "hhhhhhhhhhhhhhh");
        Object dddd = me.invoke(SpringReflectUtil.getObject("userInfExcelOutport"), new Object[]{map});
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("data", "山东省开发技术可");
        return "success";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/userShiroLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson userShiroLogin(HttpServletRequest request,HttpServletResponse response,
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
            LoginLog loginLog = new LoginLog();
            InetAddress i = InetAddress.getLocalHost();
            loginLog.setUserName(user.getUserLonginName());
            loginLog.setUserIp("" + i);
            loginLog.setTiime(new Date());
            loginLogMapper.insertSelective(loginLog);
            //当前人数加1
            ServletContext sc=request.getSession().getServletContext();
            Object obj=sc.getAttribute("counts");
            if(obj==null){
                sc.setAttribute("counts",1);
            }else{
                sc.setAttribute("counts",(int)sc.getAttribute("counts")+1);
            }
            System.out.println("登陆数s" + sc.getAttribute("counts"));
        }
        if(Objects.equals("1",request.getParameter("rememberMe"))) {
            String loginInfo = user.getUserLonginName() + "!" + user.getUserPassword();
            Cookie userCookie = new Cookie("loginInfo", loginInfo);
            userCookie.setMaxAge(1 * 24 * 60 * 60);
            // 存活期为一天 1*24*60*60
            userCookie.setPath("/");
            response.addCookie(userCookie);
        }
        SecurityUtils.getSubject().getSession().setTimeout(600000);
        request.getSession().setAttribute("username", user.getUserLonginName());



        //mv.setViewName("success");
        return ResultJson.success();

    }

    @RequestMapping("/browserAndPage")
    @ResponseBody
    public String browserAndPage() {
        System.out.println("-------browserAndPage");
        return "browserAndPage";
    }

    @RequestMapping("/userAdmin")
    //@RequiresRoles("admin")
    public ModelAndView userAdmin() {
        ModelAndView mv = new ModelAndView();
        //loginSevice.userAdmin();
        System.out.println("通过注解");
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping("/courseManger")
    public ModelAndView CourseManger() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courseManger");
        return mv;
    }

    @RequestMapping("/teacherManger")
    public ModelAndView TeacherManger() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacherManger");
        return mv;
    }

    @PostMapping("/employeeMapper")
    @ResponseBody
    public ResultJson employeeMapper(@RequestParam Map<String, Object> map) {
        PageHelper.startPage(1, 5);
        Example example = new Example(Employee.class);
        Example.Criteria c = example.createCriteria();
        if (!StringUtils.isEmpty(map.get("username"))) {
            c.andLike("empName", "%" + map.get("username") + "%");
        }
        if (!StringUtils.isEmpty(map.get("sex"))) {
            c.andEqualTo("gender", map.get("sex"));
        }
        if (!StringUtils.isEmpty(map.get("ids"))) {
            String[] idst = map.get("ids").toString().split(",");
            List<String> idlist = Arrays.asList(idst);
            c.andIn("empId", idlist);
        }
        c.andEqualTo("state", 1);

        List<Employee> list = employeeMapper.selectByExample(example);
        PageInfo page = new PageInfo(list, 100);
        return ResultJson.success(page, "employee");

    }

    /**
     * 批量删除或单个删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultJson delete(@RequestParam("ids") String ids) {
        Employee eee = new Employee();
        eee.setEmpId(1);
        eee.setState(11111111);
        employeeMapper.updateByPrimaryKeySelective(eee);
        String[] id = ids.split("-");
        Employee insert = new Employee();
        insert.setEmpName("self");
        Employee insert2 = new Employee();
        insert2.setEmpName("gg");
        List<Employee> insertList = new ArrayList<>();
        insertList.add(insert);
        insertList.add(insert2);
        employeeMapper.inserBypersonBatch(insertList);
        //employeeMapper.inserBypersonByParamByid(insert);
        List<String> idList = Arrays.asList(id);

        //使用mybatis动态sql foreach
       /* Integer i=employeeMapper.updateEmpoly(idList);
        log.info(""+i);*/
        //使用对象作为原始 返回 更新数据的id
        List<Employee> lists = new ArrayList<>();
        idList.forEach(f -> {
            Employee e = new Employee(Integer.parseInt(f));
            lists.add(e);
        });
        Integer ii = employeeMapper.updateEmpolyByObject2(lists);
        log.info("" + ii);
        return ResultJson.success();

    }

    /**
     * excel下载
     *
     * @param ids
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/exportDate")
    @ResponseBody
    public ResultJson exportDate(@RequestParam("ids") String ids, HttpServletRequest request, HttpServletResponse response) {
        String[] idss = ids.split(",");
        List<String> id = Arrays.asList(idss);
        Example example = new Example(Employee.class);
        Example.Criteria c = example.createCriteria();
        c.andIn("empId", id);
        List<Employee> list = employeeMapper.selectByExample(example);
        List<EmployeeVO> listV0 = new ArrayList<>();
        list.forEach(f -> {
            EmployeeVO vo = new EmployeeVO(f.getEmpName(), f.getEmail());
            listV0.add(vo);
        });
        //模板导出
        Workbook workbook = null;
        OutputStream outstream = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String newsNo = df.format(new Date());
            String fileName = "测试_" + newsNo;
            String filePro = 1233 + fileName + ".xls";
            //dowlandUrl为配置文件中下载到电脑的路径
            // excel文件流输出到浏览器，选择下载路径
            File f = new File(request.getSession().getServletContext().getRealPath("/") + fileName);
            //为实体赋值
            workbook = ExcelExportUtil.exportExcel(new ExportParams(), Employee.class, list);

            outstream = response.getOutputStream();

            /**这段代码可以实现Excel以文件流的形式到浏览器中,浏览器左下角出现Excel的下载提示，
             *new String(fileName.getBytes(),"iso-8859-1")可是实现文件名为中文，不是乱码  */
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "iso-8859-1") + ".xls");
            response.setContentType("application/x-download");
            workbook.write(outstream);
            outstream.close();
        } catch (Exception e) {// 发生不可预知异常，在此截获异常信息，并返回客户操作不成功

            return ResultJson.success("失败");
        }
        return ResultJson.success("成功");


    }

    /**
     * 文件下载（非excel）
     *
     * @return
     */
    @GetMapping("/dowloadFile")
    @ResponseBody
    public ResponseEntity<byte[]> dowloadFile() throws Exception {
        //InputStream in=LoginController.class.getResourceAsStream("20190605094808.xls");
        URL U = LoginController.class.getClassLoader().getResource("file/20190605094808.xls");
        String f = "" + LoginController.class.getClassLoader().getResource("file/20190605094808.xls");
        File file = new File("D:\\IdeaWorkSpace\\myproject\\src\\main\\resources\\file\\hhh.xls");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "hhh.xls");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

    }

    @RequestMapping("importExcel")
    @ResponseBody
    public ResultJson importExcel(MultipartFile file) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\hhh.xls";
        //解析excel，
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        //List<EmployeeVO> personList = ExcelImportUtil.importExcel(file.getInputStream(),EmployeeVO.class,params);
        //List<Employee> personList = ExcelImportUtil.importExcel(new File(filePath),Employee.class,params);
        List<Employee> personList = ExcelImportUtil.importExcel(file.getInputStream(), Employee.class, params);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + personList.size() + "】行");
        personList.forEach(f -> {
            f.setState(1);
            employeeMapper.insert(f);
        });
        return  ResultJson.success();
        //TODO 保存数据库
    }

    @RequestMapping("/exportExcelPoi")
    @ResponseBody
    public ResultJson exportExcelPoi(Map map, HttpServletResponse response) throws Exception {
        /*String[] idss=ids.split(",");
        List<String> id= Arrays.asList(idss);*/
        List<String> id = new ArrayList<>();
        id.add("1");
        Example example = new Example(Employee.class);
        Example.Criteria c = example.createCriteria();
        c.andIn("empId", id);
        List<Employee> list = employeeMapper.selectByExample(example);
        List<EmployeeVO> listV0 = new ArrayList<>();
        list.forEach(f -> {
            EmployeeVO vo = new EmployeeVO(f.getEmpName(), f.getEmail());
            listV0.add(vo);
        });
        //模板导出
        Workbook workbook = null;
        OutputStream outstream = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String newsNo = df.format(new Date());
            String fileName = "测试_" + newsNo;
            String filePro = 1233 + fileName + ".xls";
            //dowlandUrl为配置文件中下载到电脑的路径
            // excel文件流输出到浏览器，选择下载路径
            //File f = new File(request.getSession().getServletContext().getRealPath("/") + fileName);
            //为实体赋值
            workbook = ExcelExportUtil.exportExcel(new ExportParams(), Employee.class, list);

            outstream = response.getOutputStream();

            /**这段代码可以实现Excel以文件流的形式到浏览器中,浏览器左下角出现Excel的下载提示，
             *new String(fileName.getBytes(),"iso-8859-1")可是实现文件名为中文，不是乱码  */
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "iso-8859-1") + ".xls");
            response.setContentType("application/x-download");
            workbook.write(outstream);
            outstream.close();
        } catch (Exception e) {// 发生不可预知异常，在此截获异常信息，并返回客户操作不成功

            return ResultJson.success("失败");
        }
        return ResultJson.success("成功");

        //TODO 保存数据库
    }

    //通用下载
    @RequestMapping("/commonExportExcelPoi")
    @ResponseBody
    public ResultJson commonExportExcelPoi(@RequestParam Map<String, Object> map, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //String javaDate=request.getParameter("javaDate");
        String[] javaDate = request.getParameter("javaDate").split("!");
        List<String> javaDateList = Arrays.asList(javaDate);
        String javaName = javaDateList.get(0);
        String javaMethod = javaDateList.get(1);
        Object obj = SpringReflectUtil.getObject(javaName);
        //得到对象实例化
        Class<?> o = obj.getClass();
        //得到方法
        Method me = o.getMethod(javaMethod, new Class[]{Map.class});
        ResultJson objectList = (ResultJson) me.invoke(SpringReflectUtil.getObject(javaName), new Object[]{map});
        log.info("objectList:" + objectList.getResultData());


        //模板导出
        Workbook workbook = null;
        OutputStream outstream = null;
        //try {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String newsNo = df.format(new Date());
        String fileName = "测试_" + newsNo;
        String filePro = 1233 + fileName + ".xls";
        //dowlandUrl为配置文件中下载到电脑的路径
        // excel文件流输出到浏览器，选择下载路径
        //File f = new File(request.getSession().getServletContext().getRealPath("/") + fileName);
        //为实体赋值
        PageInfo p = (PageInfo) objectList.getResultData();
        workbook = ExcelExportUtil.exportExcel(new ExportParams(), SpringReflectUtil.getObject(objectList.getMsg()).getClass(), p.getList());

        outstream = response.getOutputStream();

        /**这段代码可以实现Excel以文件流的形式到浏览器中,浏览器左下角出现Excel的下载提示，
         *new String(fileName.getBytes(),"iso-8859-1")可是实现文件名为中文，不是乱码  */
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "iso-8859-1") + ".xls");
        response.setContentType("application/x-download");
        workbook.write(outstream);
        outstream.close();
   /* } catch (Exception e) {// 发生不可预知异常，在此截获异常信息，并返回客户操作不成功

        return ResultJson.success("失败");
    }*/
        UpdownloadLog d = new UpdownloadLog();
        InetAddress ip = InetAddress.getLocalHost();
  /* d.setFileType("1");
   d.setIp(""+ip);
   d.setJavaMethod();
   d.set
   d.setOperater();
    downloadLog.insert()*/
        return ResultJson.success("成功");

        //TODO 保存数据库
    }


}
