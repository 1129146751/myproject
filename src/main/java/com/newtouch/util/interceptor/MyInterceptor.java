package com.newtouch.util.interceptor;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/27
 * Time:13:04
 **/
public class MyInterceptor implements HandlerInterceptor {
    private Logger log= LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle"+ httpServletRequest.getHeader("Referer") );
       /* if(StringUtils.isEmpty(httpServletRequest.getHeader("Referer"))){
            //

            httpServletResponse.sendRedirect("static/error/404.jsp");
            return false;
        }*/
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        System.out.println("before-----" + request.getSession().getAttribute("username") + "---------" );
        log.info("===============请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        if(request.getRequestURL().toString().indexOf("user/commonExportExcelPoi")!=-1&&StringUtils.isEmpty(httpServletRequest.getHeader("Referer"))){
            log.info("使用的导出方法,使用的直接在浏览器中访问不能下载");
            httpServletResponse.sendRedirect("../static/error/abnormal.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
