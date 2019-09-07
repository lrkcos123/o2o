package com.lrk.o2o.enums;

public enum Person_infoFlag {
    NONE(0,"没有权限"),
    CUSTOMER(1,"普通用户"),
    SHOPOWNER(1,"店主"),
    ADMIN(1,"超级管理员");


    private int code;
    private String msg;

    Person_infoFlag(){
    }

    Person_infoFlag(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
