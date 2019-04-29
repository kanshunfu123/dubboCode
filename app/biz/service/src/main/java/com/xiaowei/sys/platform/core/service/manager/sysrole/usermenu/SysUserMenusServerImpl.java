package com.xiaowei.sys.platform.core.service.manager.sysrole.usermenu;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleUserDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleAclDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleUserDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleMenuVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclModuleLevelMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import com.xiaowei.sys.platform.core.service.manager.sysaclmodule.SysAclModuleTreeService;
import com.yeecli.component.common.model.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 李杰 on 2018/9/20.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysUserMenusServerImpl implements SysUserMenusServer {

    @Autowired
    private SysCoreMenuService sysCoreMenuService;
    @Autowired
    private SysAclModuleTreeService sysAclModuleTreeService;
    @Autowired
    private SysRoleUserDAO sysRoleUserDAO;
    @Autowired
    private SysRoleDAO sysRoleDAO;
    @Autowired
    private SysRoleAclDAO sysRoleAclDAO;
    @Autowired
    private SysAclDAO sysAclDAO;

    @Override
    public Result<List<String>> finalDynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        List<String> stringList = Lists.newArrayList();
        //超级管理员
        if (sysCoreMenuService.isSuperAdmin(userIsSuperMainInfoVO.getUserPhone())) {
            SysAclDO sysAclDO = new SysAclDO();
            sysAclDO.setSysAclPermissionType(userIsSuperMainInfoVO.getSysAclModuleType());
            List<SysAclDO> sysAclDOS = sysAclDAO.getAll(sysAclDO);
            stringList.addAll(aclDOToString(sysAclDOS));
            return Result.wrapSuccessfulResult(stringList);
        }
        //根据用户id得到角色id列表
        List<SysRoleUserDO> sysRoleUserDOS = sysRoleUserDAO.getRoleAndUserListByUserid(userIsSuperMainInfoVO.getUserId());
        if (CollectionUtils.isEmpty(sysRoleUserDOS)) {
            return Result.wrapSuccessfulResult(Lists.newArrayList());
        }
        List<SysRoleAclDO> sysRoleAclDOS = Lists.newArrayList();
        sysRoleUserDOS.forEach(sysRoleUserDO -> {
            SysRoleAclDO sysRoleAclDO = new SysRoleAclDO();
            sysRoleAclDO.setSysRoleId(sysRoleUserDO.getRoleId());
            sysRoleAclDOS.add(sysRoleAclDO);
        });

        //根据角色id列表 得到权限id列表
        List<SysRoleAclDO> aclIdList = sysRoleAclDAO.getAclIdListByRoleIdList(sysRoleAclDOS);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Result.wrapSuccessfulResult(Lists.newArrayList());
        }
        Set<SysRoleAclDO> userAclIdSet = new HashSet<SysRoleAclDO>(aclIdList);
        List<SysAclDO> list = Lists.newArrayList();
        userAclIdSet.forEach(sysRoleAclDO -> {
            SysAclDO sysAclDO = new SysAclDO();
            sysAclDO.setId(sysRoleAclDO.getSysAclId());
            list.add(sysAclDO);
        });
        List<SysAclDO> sysAclDOS = sysAclDAO.getByIdList(list);
        //userIsSuperMainInfoVO.getSysAclModuleType()
        List<SysAclDO> mmblist = Lists.newArrayList();
        sysAclDOS.forEach(sysAclDO -> {
            if (sysAclDO.getSysAclPermissionType().equals(userIsSuperMainInfoVO.getSysAclModuleType())) {
                SysAclDO sysAclDO1 = new SysAclDO();
                BeanUtils.copyProperties(sysAclDO, sysAclDO1);
                mmblist.add(sysAclDO1);
            }
        });
        stringList.addAll(aclDOToString(mmblist));
        return Result.wrapSuccessfulResult(stringList);
    }

    private List<String> aclDOToString(List<SysAclDO> sysAclDOS) {
        if (CollectionUtils.isEmpty(sysAclDOS)) {
            return Lists.newArrayList();
        }
        List<String> list = Lists.newArrayList();
        sysAclDOS.forEach(sysAclDO -> {
            list.add(sysAclDO.getSysAclCode());
        });
        return list;
    }

    @Override
    public Result<List<RoleMenuVO>> getRoleListByRoleUUID(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        List<RoleMenuVO> roleMenuVOS = Lists.newArrayList();
        //所有角色
        List<SysRoleDO> sysRoleDOS = sysRoleDAO.getAllRoleListByNoParam();
        //超级管理员
        if (sysCoreMenuService.isSuperAdmin(userIsSuperMainInfoVO.getUserPhone())) {
            if (!CollectionUtils.isEmpty(sysRoleDOS)) {
                sysRoleDOS.forEach(sysRoleDO -> {
                    RoleMenuVO roleMenuVO = new RoleMenuVO();
                    BeanUtils.copyProperties(sysRoleDO, roleMenuVO);
                    roleMenuVOS.add(roleMenuVO);
                });
            }
            RoleMenuVO menuRes = new RoleMenuVO();
            menuRes.setSysRoleName("admin");
            roleMenuVOS.add(menuRes);
            return Result.wrapSuccessfulResult(roleMenuVOS);
        }
        List<SysRoleUserDO> sysRoleUserDOS = sysRoleUserDAO.getRoleAndUserListByUserid(userIsSuperMainInfoVO.getUserId());
        if (!CollectionUtils.isEmpty(sysRoleUserDOS)) {
            sysRoleUserDOS.forEach(sysRoleUserDO -> {
                sysRoleDOS.forEach(sysRoleDO -> {
                    if (sysRoleDO.getId().equals(sysRoleUserDO.getRoleId())) {
                        RoleMenuVO roleMenuVO = new RoleMenuVO();
                        BeanUtils.copyProperties(sysRoleDO, roleMenuVO);
                        roleMenuVOS.add(roleMenuVO);
                    }
                });
            });
        }
        return Result.wrapSuccessfulResult(roleMenuVOS);
    }

    @Override
    public Result<List<AclModuleLevelMenuDtoVO>> dynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        List<AclMenuDtoVO> userAclList = sysCoreMenuService.getUserAclList(userIsSuperMainInfoVO);
        List<AclMenuDtoVO> list = Lists.newArrayList();
        for (AclMenuDtoVO acl : userAclList) {
            AclMenuDtoVO dto = new AclMenuDtoVO();
            BeanUtils.copyProperties(acl, dto);
            dto.setHasAcl(true);
            dto.setChecked(true);
            list.add(dto);
        }
        List<AclModuleLevelMenuDtoVO> aclModuleLevelDtoVOS = aclListToTree(list, userIsSuperMainInfoVO.getSysAclModuleType());
        return Result.wrapSuccessfulResult(aclModuleLevelDtoVOS);
    }

    private List<AclModuleLevelMenuDtoVO> aclListToTree(List<AclMenuDtoVO> aclDtoList, Integer sysAclModuleType) {
        if (CollectionUtils.isEmpty(aclDtoList)) {
            return Lists.newArrayList();
        }

        List<AclModuleLevelDtoVO> aclModuleLevelList = sysAclModuleTreeService.aclModuleTree(sysAclModuleType);
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return Lists.newArrayList();
        }
//        Set<Long> aaa = aclDtoList.stream().map(aclMenuDtoVO -> aclMenuDtoVO.getSysAclModuleId()).collect(Collectors.toSet());
        List<AclModuleLevelMenuDtoVO> aclModuleLevelMenuDtoVOS = Lists.newArrayList();
        aclModuleLevelList.forEach(aclModuleLevelDtoVO -> {
//            if (aaa.contains(aclModuleLevelDtoVO.getId())) {
            AclModuleLevelMenuDtoVO aclModuleLevelMenuDtoVO = new AclModuleLevelMenuDtoVO();
            aclModuleLevelMenuDtoVO.setId(aclModuleLevelDtoVO.getId());
            aclModuleLevelMenuDtoVO.setSysAclModuleLevel(aclModuleLevelDtoVO.getSysAclModuleLevel());
            aclModuleLevelMenuDtoVO.setSysAclModuleName(aclModuleLevelDtoVO.getSysAclModuleName());
            aclModuleLevelMenuDtoVO.setSysAclModuleParentId(aclModuleLevelDtoVO.getSysAclModuleParentId());
            aclModuleLevelMenuDtoVO.setSysAclModuleSeq(aclModuleLevelDtoVO.getSysAclModuleSeq());
            aclModuleLevelMenuDtoVO.setSysAclModuleUuid(aclModuleLevelDtoVO.getSysAclModuleUuid());

            List<AclMenuDtoVO> aclListf = Lists.newArrayList();
            List<AclDtoVO> aclList = aclModuleLevelDtoVO.getAclList();
            if (!CollectionUtils.isEmpty(aclList)){
                aclList.forEach(aclDtoVO -> {
                    AclMenuDtoVO aclMenuDtoVO=new AclMenuDtoVO();
                    aclMenuDtoVO.setChecked(aclDtoVO.isChecked());
                    aclMenuDtoVO.setHasAcl(aclDtoVO.isHasAcl());
                    aclMenuDtoVO.setId(aclDtoVO.getId());
                    aclMenuDtoVO.setSysAclModuleId(aclDtoVO.getSysAclModuleId());
                    aclMenuDtoVO.setSysAclAction(aclDtoVO.getSysAclAction());
                    aclMenuDtoVO.setSysAclName(aclDtoVO.getSysAclName());
                    aclMenuDtoVO.setSysAclRouter(aclDtoVO.getSysAclRouter());
                    aclMenuDtoVO.setSysAclCode(aclDtoVO.getSysAclCode());
                    aclListf.add(aclMenuDtoVO);
                });
            }
            aclModuleLevelMenuDtoVO.setAclList(aclListf);
            List<AclModuleLevelMenuDtoVO> aclModuleListf = Lists.newArrayList();
            List<AclModuleLevelDtoVO> aclModuleList = aclModuleLevelDtoVO.getAclModuleList();
            if (!CollectionUtils.isEmpty(aclModuleList)){
                aclModuleList.forEach(aclModule -> {
                    AclModuleLevelMenuDtoVO aclModuleLevelMenuDtoVO1=new AclModuleLevelMenuDtoVO();
                    aclModuleLevelMenuDtoVO1.setId(aclModule.getId());
                    aclModuleLevelMenuDtoVO1.setSysAclModuleUuid(aclModule.getSysAclModuleUuid());
                    aclModuleLevelMenuDtoVO1.setSysAclModuleLevel(aclModule.getSysAclModuleLevel());
                    aclModuleLevelMenuDtoVO1.setSysAclModuleName(aclModule.getSysAclModuleName());
                    aclModuleLevelMenuDtoVO1.setSysAclModuleParentId(aclModule.getSysAclModuleParentId());
                    aclModuleLevelMenuDtoVO1.setSysAclModuleSeq(aclModule.getSysAclModuleSeq());
                    aclModuleListf.add(aclModuleLevelMenuDtoVO1);
                });

            }
            aclModuleLevelMenuDtoVO.setAclModuleList(aclModuleListf);

            aclModuleLevelMenuDtoVOS.add(aclModuleLevelMenuDtoVO);
//             }
        });
        /*List<AclMenuDtoVO> aclMenuDtoVOS=Lists.newArrayList();
        aclDtoList.forEach(aclDtoVO -> {
            AclMenuDtoVO aclMenuDtoVO=new AclMenuDtoVO();
            BeanUtils.copyProperties(aclMenuDtoVO,aclMenuDtoVOS);
            aclMenuDtoVOS.add(aclMenuDtoVO);
        });*/
        //key  权限模块id value 权限点的AclDto
        //每一个模块下面对应的权限点列表
        Multimap<Long, AclMenuDtoVO> moduleIdAclMap = ArrayListMultimap.create();
        for (AclMenuDtoVO acl : aclDtoList) {
            moduleIdAclMap.put(acl.getSysAclModuleId(), acl);
        }


        bindAclsWithOrder(aclModuleLevelMenuDtoVOS, moduleIdAclMap);
        return aclModuleLevelMenuDtoVOS;
    }

    //将权限点绑定到权限模块树上
    private void bindAclsWithOrder(List<AclModuleLevelMenuDtoVO> aclModuleLevelList, Multimap<Long, AclMenuDtoVO> moduleIdAclMap) {
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return;
        }
        for (AclModuleLevelMenuDtoVO dto : aclModuleLevelList) {
            //当前模块下的所有权限点
            List<AclMenuDtoVO> aclDtoList = (List<AclMenuDtoVO>) moduleIdAclMap.get(dto.getId());
            if (!CollectionUtils.isEmpty(aclDtoList)) {
                Collections.sort(aclDtoList, aclSeqComparator);
                dto.setAclList(aclDtoList);
            }
            bindAclsWithOrder(dto.getAclModuleList(), moduleIdAclMap);
        }

    }

    private Comparator<AclMenuDtoVO> aclSeqComparator = new Comparator<AclMenuDtoVO>() {
        @Override
        public int compare(AclMenuDtoVO o1, AclMenuDtoVO o2) {
            return o1.getSysAclSeq() - o2.getSysAclSeq();
        }
    };


}
