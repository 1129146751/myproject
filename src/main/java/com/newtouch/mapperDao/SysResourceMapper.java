package com.newtouch.mapperDao;

import com.newtouch.model.SysResource;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysResourceMapper extends Mapper<SysResource> {
    public List<Map<String,Object>> getMenu(@Param("username") String userId);
    public List<SysResource> getMenu2(@Param("username") String userId);
}