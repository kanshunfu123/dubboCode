package com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public class RoleAndAclVO implements Serializable{
    private String sysRoleName;
    private String sysRoleUuid;
    private List<AclModuleLevelDtoVO> acls;

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

    public List<AclModuleLevelDtoVO> getAcls() {
        return acls;
    }

    public void setAcls(List<AclModuleLevelDtoVO> acls) {
        this.acls = acls;
    }
}
