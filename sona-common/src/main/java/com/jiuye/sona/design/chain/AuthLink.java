package com.jiuye.sona.design.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/27 18:53
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class AuthLink {

    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);

    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 级别⼈员ID
     */
    protected String levelUserId;

    /**
     *  级别⼈员姓名
     */
    protected String levelUserName;

    /**
     * 责任链的下一个节点
     */
    private AuthLink next;


    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }


    public AuthLink next(){
       return this.next;
    }

    public AuthLink appendNext(AuthLink authLink){
        this.next = authLink;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
