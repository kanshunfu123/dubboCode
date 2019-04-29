package com.xiaowei.sys.platform.core.service.manager.sysrole.sysroleedit;

import com.xiaowei.sys.platform.core.facade.service.req.sysrole.SysRolePageReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleListPageVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.RoleAndAclVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public interface SysRoleADDService {
    /**
     * 分页查询 角色列表
     *
     * @param sysRolePageReq
     * @return
     */
//    public Result<RoleListPageVO> roleListPage(SysRolePageReq sysRolePageReq);

    /**
     * 该角色在整个权限的所拥有的权限
     *
     * @param
     * @return
     */
//    public Result<RoleAndAclVO> roleAndAclsTree();

    /**
     * //根据用户id查询对应菜单
     *
     * @param userId
     * @return
     */
//    public List<AclModuleLevelDtoVO> userAclTree(Long userId);

    /**
     * 该角色在整个权限的所拥有的权限
     *
     * @return
     */
    public List<AclModuleLevelDtoVO> roleTree(Long userId,
                                              String userPhone );
}
