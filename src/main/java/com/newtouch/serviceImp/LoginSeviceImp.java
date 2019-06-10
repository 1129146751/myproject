package com.newtouch.serviceImp;


import com.alibaba.druid.pool.DruidDataSource;

import com.newtouch.service.LoginSevice;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/25
 * Time:14:19
 **/
@Service
public class LoginSeviceImp implements LoginSevice {
    @Autowired
    private DruidDataSource dataSource;
   /* @Autowired
    private JdbcTemplate jdbcTemplate;*/

    /**
     * 通过链接池里面去拿到连接  去操作数据库
     *
     * @return
     */
    public Object userLogin() {
        try {
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * from user";
            ResultSet r = st.executeQuery(sql);
            System.out.println(r);
            while (r.next()) {
                /*  System.out.println("1-:"+r.getInt("u_id"));*/
                System.out.println("1-:" + r.getString("u_name"));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Object userLogin5() {
       /* String sql="SELECT * from user";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        list.forEach(f->{
            System.out.println(f);
        });*/
        System.out.println("aop只能运用在sevice层");
        return null;
    }

    public Object userLogin6() {
        return null;
    }

    @Override
    public Object testMethodExcelOutport(String name, String vaildateCode) {
        System.out.println("aop只能运用在sevice层");
        return null;
    }


    @RequiresRoles("admin")
    public Object userAdmin() {
        System.out.println("-----userAdmin");
        return null;
    }


}
