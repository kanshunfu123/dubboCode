package com.xiaowei.sys.platform.core.facade.service.req.sysuser;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/11.
 */
public class SysUserReq extends BaseReq implements Serializable{

    private String sysUserName;//接受前台的登录名
    private String sysUserPhone;//手机号
    private String sysUserEmail;//邮箱
    private String sysUserPwd;//密码
    private String code;//验证码

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserPhone() {
        return sysUserPhone;
    }

    public void setSysUserPhone(String sysUserPhone) {
        this.sysUserPhone = sysUserPhone;
    }

    public String getSysUserEmail() {
        return sysUserEmail;
    }

    public void setSysUserEmail(String sysUserEmail) {
        this.sysUserEmail = sysUserEmail;
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
