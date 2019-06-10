package com.newtouch.util.reflect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/6/6
 * Time:14:24
 **/
public class SpringReflectUtil implements   ApplicationContextAware{
    public static ApplicationContext ct;
    //spring中获得bean
    public static Object getObject(String beanId){
        return ct.getBean(beanId);
    }
    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        SpringReflectUtil.ct = arg0;
    }


}
