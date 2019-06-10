package com.newtouch.controller;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/9
 * Time:16:44
 **/

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;

/**
 * @author hui
 * @version 1.0
 * @date 创建时间：2018年5月9日 下午5:26:55 吴清辉新建
 **/
public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        System.out.println("跳转的是html页面" + file.exists());
        return file.exists();// 判断该页面是否存在
    }
}