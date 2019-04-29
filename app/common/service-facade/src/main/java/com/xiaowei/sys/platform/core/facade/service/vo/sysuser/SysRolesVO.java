package com.xiaowei.sys.platform.core.facade.service.vo.sysuser;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/13.
 */
public class SysRolesVO  implements Serializable {
    private String sysRoleName;
    private String sysRoleUuid;
    private List<SysRolesVO> buttons;
    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public String getSysRoleUuid() {
        return sysRoleUuid;
    }

    public void setSysRoleUuid(String sysRoleUuid) {
        this.sysRoleUuid = sysRoleUuid;
    }

    public List<SysRolesVO> getButtons() {
        return buttons;
    }

    public void setButtons(List<SysRolesVO> buttons) {
        this.buttons = buttons;
    }
}
