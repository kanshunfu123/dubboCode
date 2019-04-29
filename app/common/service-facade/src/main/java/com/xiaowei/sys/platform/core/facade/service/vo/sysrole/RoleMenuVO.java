package com.xiaowei.sys.platform.core.facade.service.vo.sysrole;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MOMO on 2018/9/25.
 */
public class RoleMenuVO implements Serializable{
    /**
     * sysRoleName 角色名称.
     */
    private String sysRoleName;
    /**
     * sysRoleType 角色的类型，1：管理员角色，2：其他.
     */
    private String sysRoleType;
    /**
     * sysRoleUuid 唯一，32位字符串，查询用.
     */
    private String sysRoleUuid;

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public String getSysRoleType() {
        return sysRoleType;
    }

    public void setSysRoleType(String sysRoleType) {
        this.sysRoleType = sysRoleType;
    }

    public String getSysRoleUuid() {
        return sysRoleUuid;
    }

    public void setSysRoleUuid(String sysRoleUuid) {
        this.sysRoleUuid = sysRoleUuid;
    }
}
