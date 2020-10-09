package com.jiuye.sona.design.chain;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/27 18:51
 * @Email: huxinjian@jiuyescm.com
 */
public class AuthInfo {

    private String code;

    private String info ="";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
