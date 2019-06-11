package com.newtouch.util.listener; /**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/6/11
 * Time:13:45
 **/

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SessionListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public SessionListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        ServletContext sc=se.getSession().getServletContext();
        Object obj=sc.getAttribute("count");
        if(obj==null){
            sc.setAttribute("count",1);
        }else{
            sc.setAttribute("count",(int)sc.getAttribute("count")+1);
        }
        //System.out.println("登陆数"+sc.getAttribute("count"));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext sc=se.getSession().getServletContext();
        Object obj=sc.getAttribute("counts");
        if(obj==null){
            sc.setAttribute("counts",0);
        }else{
            sc.setAttribute("counts",(int)sc.getAttribute("counts")-1);
        }
        System.out.println("退出后登陆数s"+sc.getAttribute("counts"));
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
