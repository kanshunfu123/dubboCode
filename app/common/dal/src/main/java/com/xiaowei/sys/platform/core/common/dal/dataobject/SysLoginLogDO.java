package com.xiaowei.sys.platform.core.common.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table 登录日志
 */
public class SysLoginLogDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * userId USER_ID.
     */
    private Long userId;
    /**
     * userIp 用户ip.
     */
    private String userIp;
    /**
     * userLoginName 登录名.
     */
    private String userLoginName;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set userId USER_ID.
     */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /**
     * Get userId USER_ID.
     *
     * @return the string
     */
    public Long getUserId(){
        return userId;
    }

    /**
     * Set userIp 用户ip.
     */
    public void setUserIp(String userIp){
        this.userIp = userIp;
    }

    /**
     * Get userIp 用户ip.
     *
     * @return the string
     */
    public String getUserIp(){
        return userIp;
    }

    /**
     * Set userLoginName 登录名.
     */
    public void setUserLoginName(String userLoginName){
        this.userLoginName = userLoginName;
    }

    /**
     * Get userLoginName 登录名.
     *
     * @return the string
     */
    public String getUserLoginName(){
        return userLoginName;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }
}
