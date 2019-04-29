package com.xiaowei.sys.platform.core.facade.service.req.sysuser;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/14.
 */
public class SysUserUpdateReq extends BaseReq implements Serializable {


    private long id;
    private String sysAreaUuid;
    private String sysDeptUuid;
    private String delFlag;
    private String sysUserPwd;
    private boolean changePwd;//是否修改了密码
    /**
     * sysUserName 姓名.
     */
    private String sysUserName;

    /**
     * sysUserEmail 邮箱.
     */
    private String sysUserEmail;
    /**
     * sysUserPhone 手机号.
     */
    private String sysUserPhone;
    private String sysUserUuid;
    private List<String> roles;
    private List<String> areaUuidList;//区域列表

    public boolean isChangePwd() {
        return changePwd;
    }

    public void setChangePwd(boolean changePwd) {
        this.changePwd = changePwd;
    }

    public String getSysUserUuid() {
        return sysUserUuid;
    }

    public void setSysUserUuid(String sysUserUuid) {
        this.sysUserUuid = sysUserUuid;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getSysAreaUuid() {
        return sysAreaUuid;
    }

    public void setSysAreaUuid(String sysAreaUuid) {
        this.sysAreaUuid = sysAreaUuid;
    }

    public String getSysDeptUuid() {
        return sysDeptUuid;
    }

    public void setSysDeptUuid(String sysDeptUuid) {
        this.sysDeptUuid = sysDeptUuid;
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserEmail() {
        return sysUserEmail;
    }

    public void setSysUserEmail(String sysUserEmail) {
        this.sysUserEmail = sysUserEmail;
    }

    public String getSysUserPhone() {
        return sysUserPhone;
    }

    public void setSysUserPhone(String sysUserPhone) {
        this.sysUserPhone = sysUserPhone;
    }

    public long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getAreaUuidList() {
        return areaUuidList;
    }

    public void setAreaUuidList(List<String> areaUuidList) {
        this.areaUuidList = areaUuidList;
    }
}
