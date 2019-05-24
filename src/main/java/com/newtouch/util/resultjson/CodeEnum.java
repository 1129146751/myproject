package com.newtouch.util.resultjson;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/28
 * Time:10:59
 **/
public enum CodeEnum {

    SUCCESS("200", "操作成功"),
    FAIL("500", "操作失败");
    private String code;
    private String msg;

    private CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
