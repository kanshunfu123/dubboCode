package com.xiaowei.sys.platform.core.facade.service.req.sysuser;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/14.
 */
public class SysUserRoleReq extends BaseReq implements Serializable{
    private String sysRoleUuid;

    public String getSysRoleUuid() {
        return sysRoleUuid;
    }

    public void setSysRoleUuid(String sysRoleUuid) {
        this.sysRoleUuid = sysRoleUuid;
    }
}
