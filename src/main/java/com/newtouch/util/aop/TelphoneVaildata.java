package com.newtouch.util.aop;

import com.newtouch.util.reflect.SpringReflectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.parallel.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/13
 * Time:16:05
 **/
@Aspect
public class TelphoneVaildata {
    private Logger log = LoggerFactory.getLogger(TelphoneVaildata.class);

    @Pointcut("execution( * com..*.testMethodExcelOutport1( ..))")
    public void cutPoint() {

    }

    @Around("cutPoint()")
    public void beforeMethod(ProceedingJoinPoint joinPoint) throws Exception {
        Object obj = SpringReflectUtil.getObject("userInfExcelOutport");
        //得到对象实例化
        Class<?> o = obj.getClass();
        Object stance = o.newInstance();
        //得到方法
        Method me = o.getMethod("testMethodExcelOutport1", new Class[]{String.class});
        Object dddd = me.invoke(stance, new Object[]{"11111111111"});
        String c = "com.newtouch.controller.UserInfExcelOutport";
        Class classTpye = Class.forName(c);
        log.info("classTpye：" + classTpye);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //request.getSession().getAttribute("username");
       /* HttpServletRequest request = SysContent.getRequest();
        HttpServletResponse response = SysContent.getResponse();
        HttpSession session = SysContent.getSession();*/
        System.out.println("before-----" + request.getSession().getAttribute("username") + "---------");
        log.info("===============请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        Integer begin = request.getMethod().indexOf(" ");
        Integer end = request.getMethod().lastIndexOf(".");

        //log.info("------------java："+request.getMethod().substring(begin,end));
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        Object[] args = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        String methodName = joinPoint.getSignature().getName(); // 获取方法名称
        // 获取参数名称和值
           /* StringBuffer sb = LogAopUtil.getNameAndArgs(this.getClass(), clazzName, methodName, args);
            log.info("请求类方法参数名称和值：" + sb);
            log.info("===============请求内容===============");*/
        throw new RuntimeException("验证码不正确");
    }
}
