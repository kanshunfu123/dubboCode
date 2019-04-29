package com.xiaowei.sys.platform.core.facade.service.vo.sysuser;

import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public class SysUserRoleMenuVO implements Serializable{
    private List<SysRolesVO> roles;
    private List<AclModuleLevelDtoVO> acls;

    public List<SysRolesVO> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRolesVO> roles) {
        this.roles = roles;
    }

    public List<AclModuleLevelDtoVO> getAcls() {
        return acls;
    }

    public void setAcls(List<AclModuleLevelDtoVO> acls) {
        this.acls = acls;
    }
}
