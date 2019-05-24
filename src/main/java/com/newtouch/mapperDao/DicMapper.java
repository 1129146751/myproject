package com.newtouch.mapperDao;

import com.newtouch.model.Dic;
import com.newtouch.model.DicExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DicMapper extends Mapper<Dic> {
    String getNname(@Param("tableName") String tableName, @Param("dataType") String dataType,
                    @Param("dataTypeValue") String dataTypeValue, @Param("needColumn") String needColumn, @Param("vaule") String vaule,
                    @Param("param") String param);
}