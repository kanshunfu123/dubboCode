package com.xiaowei.sys.platform.core.service.manager.sysaclmodule;

import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;

import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public interface SysAclModuleTreeService {
    public List<AclModuleLevelDtoVO> aclModuleTree(Integer sysAclModuleType);
}
