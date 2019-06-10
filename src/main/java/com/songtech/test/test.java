package com.songtech.test;

import com.newtouch.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/31
 * Time:17:26
 **/
public class test {

    @Test
    public void method1(){
        System.out.println("sflskflsf");
        List list=new ArrayList<>();
        list.add("1");
        list.add("2");
       /* list.forEach(f->{
            if(Objects.equals("1",f)){
                return;
            }
            System.out.println(f);

        });*/
       /*for(Object o:list){
           System.out.println(o);
           break;
       }
        System.out.println("结束");*/

       List<User> userList=new ArrayList<>();
        User u1=new User();
        u1.setuName("张三");
        User u2=new User();
        u2.setuName("李四");
        userList.add(u1);
        userList.add(u2);
        User u3=u1;
        System.out.println("u1"+u1);
        System.out.println("u2"+u2);
        System.out.println("u3"+u3);

       /* for(User uu1:userList){
            uu1.setuName(uu1.getuName()+"111111");
        }
        System.out.println("增强for"+userList);*/
       /*userList.forEach(f->{

           f.setuName(f.getuName()+"111111");

       });*/
       for(int i=0;i<userList.size();i++){
           userList.get(i).setuName( userList.get(i).getuName()+"111111111");
       }
        System.out.println("增强for"+userList);
       Long l=22L;
       Long ll=22L;
        System.out.println(l==ll);
        BigDecimal iii=null;
        BigDecimal jjj=null;
        try {
           iii= new BigDecimal("11");
           iii=null;
           jjj= new BigDecimal("22");
        }catch (Exception e){

        }
        BigDecimal adddd= iii.add(jjj);
        System.out.println(adddd);

    }
}
