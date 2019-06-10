package com.newtouch.mapperDao;


import com.newtouch.model.Employee;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {
    /**
     * 参数类型是string时 返回更新了几行
     * @param list
     * @return
     */
    Integer updateEmpoly(List<String> list);

    Integer updateEmpolyByObject(List<Employee> listw);
    Integer updateEmpolyByObject2(@Param("list") List<Employee> listw);
    Integer inserByperson(Employee e);
    Integer inserBypersonByParam(@Param("e")Employee e);
    Integer inserBypersonByParamByid(@Param("e")Employee e);
    Integer inserBypersonBatch(@Param("list")List<Employee> e);

}