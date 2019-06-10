package com.newtouch.controller.menu;

import com.newtouch.mapperDao.SysResourceMapper;
import com.newtouch.model.SysResource;
import com.newtouch.util.resultjson.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/31
 * Time:13:43
 **/
@Controller
@RequestMapping("/menu")
public class Resource {
    @Autowired
    private SysResourceMapper sysResourceMapper;
    @RequestMapping("/getMenu")
    @ResponseBody
    public ResultJson getMenu(){
        String username=(String)SecurityUtils.getSubject().getSession().getAttribute("username");
        List<SysResource> list=sysResourceMapper.getMenu2(username);
        TreeSet<SysResource> menuList=new TreeSet<SysResource>();

        // 最后的结果
	// 先找到所有的一级菜单
        list.forEach(f->{
            if(Objects.equals(0,f.getParentId())){
                menuList.add(f);
            }
        });
	 // 为一级菜单设置子菜单，getChild是递归调用的
        menuList.forEach(f->{
            f.setChildDate(getChild(f.getResourceId(),list));
        });


        return ResultJson.success(menuList);
    }

    public  TreeSet<SysResource> getChild(Integer id,List<SysResource> rootMenu){

        // 子菜单
        TreeSet<SysResource> childList = new TreeSet<>();
	   for (SysResource menu : rootMenu) {
	// 遍历所有节点，将父菜单id与传过来的id比较
	         if (menu.getParentId().equals(id)) {
	            childList.add(menu);
             }
	   }
	    // 把子菜单的子菜单再循环一遍
	   for (SysResource menu : childList) {// 没有url子菜单还有子菜单
	     if (StringUtils.isBlank(menu.getResourceUrl())) {
	  // 递归
	  menu.setChildDate(getChild(menu.getResourceId(), rootMenu));
	  }
	    } // 递归退出条件
	 if (childList.size() == 0) {
	 return null;
	  }
	   return childList;

    }
}
