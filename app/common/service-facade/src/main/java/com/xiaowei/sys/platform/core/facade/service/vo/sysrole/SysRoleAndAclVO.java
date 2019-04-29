package com.xiaowei.sys.platform.core.facade.service.vo.sysrole;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public class SysRoleAndAclVO implements Serializable {

    private String sysRoleName;//角色名称
    private String sysRoleUuid;//角色uuid
    private List<SysModulAclVO> sysModulAclVO;
    private List<String> acls;//权限拼接好的字符串

    public List<String> getAcls() {
        return acls;
    }

    public void setAcls(List<String> acls) {
        this.acls = acls;
    }

    public String getSysRoleUuid() {
        return sysRoleUuid;
    }

    public void setSysRoleUuid(String sysRoleUuid) {
        this.sysRoleUuid = sysRoleUuid;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public List<SysModulAclVO> getSysModulAclVO() {
        return sysModulAclVO;
    }

    public void setSysModulAclVO(List<SysModulAclVO> sysModulAclVO) {
        this.sysModulAclVO = sysModulAclVO;
    }
}
