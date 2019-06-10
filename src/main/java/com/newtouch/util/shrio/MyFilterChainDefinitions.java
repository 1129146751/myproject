package com.newtouch.util.shrio;

import java.util.LinkedHashMap;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/27
 * Time:15:30
 **/
public class MyFilterChainDefinitions {
    public LinkedHashMap<String,String> bulidfilterChainDefinitionMap(){
        LinkedHashMap<String,String> map=new LinkedHashMap<>();
        map.put("/**","authc");
        return  map;
    }
}
