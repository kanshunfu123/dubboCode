package com.xiaowei.sys.platform.core.facade.service.req.sysrole;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/19.
 */
public class RoleMmmpGG extends BaseReq implements Serializable{
    //菜单类型 1 系统管理 2资产管理
    private Integer sysAclModuleType;

    public Integer getSysAclModuleType() {
        return sysAclModuleType;
    }

    public void setSysAclModuleType(Integer sysAclModuleType) {
        this.sysAclModuleType = sysAclModuleType;
    }
}
