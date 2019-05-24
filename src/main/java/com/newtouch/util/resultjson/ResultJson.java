package com.newtouch.util.resultjson;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/28
 * Time:10:53
 **/
public class ResultJson {
    private String msg;
    private String code;
    private Object resultData;


    public static ResultJson fail() {
        return new ResultJson(CodeEnum.FAIL);
    }

    public static ResultJson success() {
        return new ResultJson(CodeEnum.SUCCESS);
    }

    public static ResultJson fail(String msg) {
        return new ResultJson(CodeEnum.FAIL, msg);
    }

    public static ResultJson success(String msg) {
        return new ResultJson(CodeEnum.SUCCESS, msg);
    }

    public static ResultJson success(Object data) {
        return new ResultJson(CodeEnum.SUCCESS, data);
    }

    public static ResultJson success(Object data, String msg) {
        return new ResultJson(CodeEnum.FAIL, data, msg);
    }

    public ResultJson(CodeEnum codeEnum, Object data, String msg) {
        this.code = codeEnum.getCode();
        this.resultData = data;
        this.msg = msg;
    }

    public ResultJson(CodeEnum codeEnum, Object data) {
        this.msg = codeEnum.getMsg();
        this.code = codeEnum.getCode();
        this.resultData = data;

    }


    public ResultJson(CodeEnum codeEnum, String msg) {
        this.code = codeEnum.getCode();
        this.resultData = "";
        this.msg = msg;
    }

    public ResultJson(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.resultData = "";
        this.msg = codeEnum.getMsg();
    }


    public ResultJson() {
    }

    public ResultJson(String code, Object resultData, String msg) {
        this.code = code;
        this.resultData = resultData;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
