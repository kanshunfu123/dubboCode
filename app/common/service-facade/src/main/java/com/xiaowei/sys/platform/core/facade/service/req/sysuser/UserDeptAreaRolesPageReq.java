package com.xiaowei.sys.platform.core.facade.service.req.sysuser;


import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/13.
 */
public class UserDeptAreaRolesPageReq extends BaseReq implements Serializable{

    private String sysUserUuid;
    private String sysUserName;//用户姓名
    private String sysDeptName;//部门名称
    private Integer limit=20;//每页显示记录数
    private Integer currPageNo=1;//当前页 页码


    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysDeptName() {
        return sysDeptName;
    }

    public void setSysDeptName(String sysDeptName) {
        this.sysDeptName = sysDeptName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public String getSysUserUuid() {
        return sysUserUuid;
    }

    public void setSysUserUuid(String sysUserUuid) {
        this.sysUserUuid = sysUserUuid;
    }
}
