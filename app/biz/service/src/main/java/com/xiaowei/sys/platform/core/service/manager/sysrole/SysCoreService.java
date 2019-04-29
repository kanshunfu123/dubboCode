package com.xiaowei.sys.platform.core.service.manager.sysrole;

import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;

import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public interface SysCoreService {
    //获取当前用户权限点列表
    public List<SysAclVO> getCurrentUserAclList(Long userId,String userPhone);
    //某个角色已分配的权限点列表
    public List<SysAclVO> getRoleAclList(Long roleId);
    //根据用户id查询对应的权限点
    public List<SysAclVO> getUserAclList(Long userId,String userPhone);
}
