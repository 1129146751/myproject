package com.newtouch.util.resultjson;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/18
 * Time:18:05
 **/
public class CodeName {

    private String code;
    private String name;

    public CodeName() {
    }

    public CodeName(String code) {
        this.code = code;
    }

    public CodeName(Object code, String name) {
        this.setName(name);
        this.setCode(code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(Object code) {
        this.code = code == null ? null : code.toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
