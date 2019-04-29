package com.xiaowei.sys.platform.core.facade.service.req.sysrole;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/17.
 */
public class SysRolePageReq extends BaseReq implements Serializable{
    private String delFlag;//
    private Integer limit=20;//每页显示记录数
    private Integer currPageNo=1;//当前页 页码

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
}
