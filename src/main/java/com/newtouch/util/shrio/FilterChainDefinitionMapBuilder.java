package com.newtouch.util.shrio;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/28
 * Time:10:05
 **/
import com.newtouch.mapperDao.ShiroConfigeMapper;
import com.newtouch.model.ShiroConfige;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;

public class FilterChainDefinitionMapBuilder {
    @Autowired
    private ShiroConfigeMapper shiroConfigeMapper;
    private Logger log= LoggerFactory.getLogger(FilterChainDefinitionMapBuilder.class);
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
       List<ShiroConfige> list= shiroConfigeMapper.selectAll();
        /*map.put("/login.jsp", "anon");
        map.put("/shiro/login", "anon");
        map.put("/shiro/logout", "logout");
        map.put("/user.jsp", "authc,roles[user]");
        map.put("/admin.jsp", "authc,roles[admin]");
        map.put("/list.jsp", "user");*/
        list.forEach(f->{
            map.put(f.getUrl(),f.getRoles());
        });
        map.put("/static/*/**","anon");
        //map.put("/user/getVerify","anon");
        map.put("/user/userShiroLogin","anon");
        map.put("/user/userAdmin","roles[admin]");
        map.put("/shiro/logout", "logout");
        //map.put("test","roles[admin]");
        map.put("/**", "authc");
        return map;
    }

}

