package com.newtouch.serviceImp;

import com.newtouch.mapperDao.DicMapper;
import com.newtouch.service.DicSevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/28
 * Time:11:30
 **/
@Service
public class DicSeviceImp implements DicSevice {
    @Resource
    DicMapper dicMapper;

    public String getName(String tableName, String dataType, String dataTypeValue, String needColumn, String vaule, String param) {
        return dicMapper.getNname(tableName, dataType, dataTypeValue, needColumn, vaule, param);
    }
}
