//package com.newtouch.util;
//
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.newtouch.mapperDao.DicMapper;
//import com.newtouch.model.Dic;
//import com.newtouch.serviceImp.DicSeviceImp;
//import com.newtouch.util.resultjson.CodeName;
//import com.newtouch.util.resultjson.ResultJson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created with IDEA
// *基于spring 及以上版本
// * 需要映入fastJson包 用于将对象变成jsonObject(parseObject这个方法),使用jsonObject里面的getJSONObject（name）找到对应的数据
// * @author:fengxu Date:2019/4/17
// * Time:17:13
// **/
//
//@ControllerAdvice
//public class ResponseDataDic implements ResponseBodyAdvice {
//    @Autowired
//    private DicSeviceImp dicSeviceImp;
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        try {
//           /* System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
//                    + methodParameter);
//            System.out.println("返回类型的对象名：" + o.getClass().getName());
//            ResultJson resultJson = (ResultJson) o;
//            Object data = resultJson.getResultData();
//            if (StringUtils.isEmpty(data)) {
//                return o;
//            }
//            Object r = JSON.toJSON(o);
//           *//* JSONObject jsonResult22 = JSON.parseObject(o.toString());
//            System.out.println("jsonResult22"+jsonResult22);*//*
//
//            JSONObject jsonResult = JSON.parseObject(r.toString());
//            System.out.println("jsonObject" + jsonResult);
//            //得到返回结果对象的Class类型的类
//            List<Object> list=resultJson.getResultData();
//            List<Object> resultList=new ArrayList<>();
//            for(Object ob:list){
//                Class clazz = ob.getClass();
//                //通过反射 拿到所有的属性值
//                Field[] fields = clazz.getDeclaredFields();
//                for (Field f : fields) {
//
//                    //判断该属性上面是否加了 指定的注解
//                    Boolean b = f.isAnnotationPresent(DicUtil.class);
//                    if (b) {
//                        f.setAccessible(true);
//                        Annotation a = f.getAnnotation(DicUtil.class);
//                        System.out.println("注解的名字" + ((DicUtil) a).tableName());
//                        f.setAccessible(true);
//                        System.out.println("指段名：" + f.getName());
//                        System.out.println("指段值" + getFieldValueByFieldName(f.getName(), ob));
//                        //得到注解的属性
//                        jsonResult.getJSONObject(f.getName());
//                        //查询数据库翻译成对象 中文名
//                        //String name = departmentService.getName(getFieldValueByFieldName(f.getName(), data), ((Dic) a).name());
//                        String tableName=((DicUtil) a).tableName();
//                        String dataType=((DicUtil) a).dataType();
//                        String dataTypeValue=((DicUtil) a).dataTypeValue();
//                        String   needColumn=((DicUtil) a).needColumn();
//                        String   param=((DicUtil) a).param();
//                        String vaule=getFieldValueByFieldName(f.getName(), ob);
//                        String name=dicSeviceImp.getName(tableName,dataType,dataTypeValue,needColumn,vaule,param);
//                        System.out.println("中文名：" + name);
//                        CodeName codeName = new CodeName(getFieldValueByFieldName(f.getName(), ob), name);
//                        *//*System.out.println(jsonResult.getJSONObject("resultData"));
//                        JSONObject data33 = jsonResult.getJSONObject("resultData");
//                        System.out.println(data33.getString(f.getName()));*//*
//                        *//*if (jsonResult.getJSONObject("resultData").getString(f.getName()) != null) {
//
//                            jsonResult.getJSONObject("data").put(f.getName(), codeName);
//                        }*//*
//                        resultList.add(codeName);
//                    }
//
//                }
//            }
//
//            System.out.println("jsonResult----------------" + jsonResult);
//            resultJson.setResultData(resultList);
//            return jsonResult;*/
//            return o;
//        }catch(Exception e){
//            return o;
//        }
//    }
//
//
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return true;
//    }
//    private String getFieldValueByFieldName(String fieldName, Object object) {
//        try {
//            Field field = object.getClass().getDeclaredField(fieldName);
//            //设置对象的访问权限，保证对private的属性的访问
//            field.setAccessible(true);
//            return (String) field.get(object);
//        } catch (Exception e) {
//            throw new RuntimeException("没有找到属性值");
//        }
//    }
//}