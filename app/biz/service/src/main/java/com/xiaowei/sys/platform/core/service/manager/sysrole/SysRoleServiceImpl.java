package com.xiaowei.sys.platform.core.service.manager.sysrole;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.xiaowei.sys.platform.core.common.dal.dao.*;
import com.xiaowei.sys.platform.core.common.dal.dataobject.*;
import com.xiaowei.sys.platform.core.common.dal.paging.RoleListPage;
import com.xiaowei.sys.platform.core.facade.service.req.sysrole.*;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleListPageVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysAllRoleVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysModulAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysRoleAndAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.RoleAndAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.SysRolesVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.SysUserRoleMenuVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysaclmodule.SysAclModuleTreeService;
import com.yeecli.component.common.model.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by MOMO on 2018/9/17.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDAO sysRoleDAO;
    @Autowired
    private SysAclDAO sysAclDAO;
    @Autowired
    private SysAclModuleDAO sysAclModuleDAO;
    @Autowired
    private SysCoreService sysCoreService;
    @Autowired
    private SysAclModuleTreeService sysAclModuleTreeService;
    @Autowired
    private SysRoleUserDAO sysRoleUserDAO;
    @Autowired
    private SysRoleAclDAO sysRoleAclDAO;

    @Override
    public Result<RoleListPageVO> roleListPage(SysRolePageReq sysRolePageReq) {

        //最终结果
        RoleListPageVO roleListPageVO = new RoleListPageVO();
        List<SysRoleAndAclVO> aaaa = Lists.newArrayList();
        RoleListPage roleList = new RoleListPage();
        sysRolePageReq.setDelFlag("0");
        BeanUtils.copyProperties(sysRolePageReq, roleList);
        RoleListPage roleListPage = sysRoleDAO.roleListPage(roleList);
        //获得角色列表
        List<SysRoleDO> sysRoleDOS = roleListPage.getDatas();
        if (!CollectionUtils.isEmpty(sysRoleDOS)) {
            sysRoleDOS.forEach(sysRoleDO -> {
                SysRoleAndAclVO sysRoleAndAclVO = new SysRoleAndAclVO();
                //设置角色名称
                sysRoleAndAclVO.setSysRoleName(sysRoleDO.getSysRoleName());
                sysRoleAndAclVO.setSysRoleUuid(sysRoleDO.getSysRoleUuid());
                //权限模块，权限列表
                List<SysModulAclVO> sysModulAclVOList = new ArrayList<>();
                //根据角色id查询权限列表
                List<SysAclDO> sysAclDOS = sysAclDAO.getRoleListByAcls(sysRoleDO.getId());
                //权限模块id为key ，权限名称 为 val
                Multimap<Long, String> longSysAclDOMultimap = ArrayListMultimap.create();
                if (!CollectionUtils.isEmpty(sysAclDOS)) {
                    sysAclDOS.forEach(sysAclDO -> {
                        longSysAclDOMultimap.put(sysAclDO.getSysAclModuleId(), sysAclDO.getSysAclName());
                    });
                }
                //得到所有权限模块
                List<SysAclModuleDO> sysAclModuleDOS = sysAclModuleDAO.getAllAclModel(null);
                if (!CollectionUtils.isEmpty(sysAclModuleDOS)) {
                    List<String> acl = Lists.newArrayList();
                    StringBuffer sb = new StringBuffer();
                    sysAclModuleDOS.forEach(sysAclModuleDO -> {
                        //权限模块列表
                        SysModulAclVO sysModulAclVO = new SysModulAclVO();
                        List<String> dos = (List<String>) longSysAclDOMultimap.get(sysAclModuleDO.getId());
                        if (!CollectionUtils.isEmpty(dos)) {
                            sb.append(sysAclModuleDO.getSysAclModuleName() + ":");
                            dos.forEach(s -> {
                                sb.append(s + "、");
                            });
                            String roleAndAclsOld = sb.toString();
                            String roleAndAclsNew = roleAndAclsOld.substring(0, roleAndAclsOld.length() - 1);
                            acl.add(roleAndAclsNew);
                            sysRoleAndAclVO.setAcls(acl);
                            sb.setLength(0);
                            /*sysModulAclVO.setSysAclModule(sysAclModuleDO.getSysAclModuleName());
                            sysModulAclVO.setAcl(dos);
                            //模块名称
                            sysModulAclVOList.add(sysModulAclVO);
                            //权限点
                            sysRoleAndAclVO.setSysModulAclVO(sysModulAclVOList);*/
                        }
                    });
                }
                aaaa.add(sysRoleAndAclVO);
            });
        }
        roleListPageVO.setDatas(aaaa);
        roleListPageVO.setLimit(sysRolePageReq.getLimit());
        roleListPageVO.setCurrPageNo(sysRolePageReq.getCurrPageNo());
        roleListPageVO.setTotal(roleListPage.getTotal());
        return Result.wrapSuccessfulResult(roleListPageVO);
    }


    @Override
    public Result<RoleAndAclVO> roleAndAclsTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG) {
        SysRoleDO sysRoleDO = sysRoleDAO.getByUuid(sysRoleUuid);
        if (null == sysRoleDO) {
            Result.wrapSuccessfulResult(ErrorEnum.ERROR_ROLE_NOT_EXIST_FAIL.getErrorMessage(), ErrorEnum.ERROR_ROLE_NOT_EXIST_FAIL.getErrorMessage());
        }
        RoleAndAclVO roleAndAclVO = new RoleAndAclVO();
        roleAndAclVO.setSysRoleName(sysRoleDO.getSysRoleName());
        roleAndAclVO.setSysRoleUuid(sysRoleDO.getSysRoleUuid());
        //TODO  当前用户的id
        roleAndAclVO.setAcls(roleTree(sysRoleDO.getId(), roleMmmpGG.getUserId(), roleMmmpGG.getUserPhone()));
        return Result.wrapSuccessfulResult(roleAndAclVO);
    }

    @Override
    public Result<SysUserRoleMenuVO> userRoleMenu(Long userId, RoleMmmpGG roleMmmpGG) {
        SysUserRoleMenuVO sysUserRoleMenuVO = new SysUserRoleMenuVO();

        List<SysRoleDO> sysRoleDOS = sysRoleDAO.getRoleByUserId(userId);
        if (CollectionUtils.isEmpty(sysRoleDOS)) {
            sysUserRoleMenuVO.setRoles(Lists.newArrayList());
        }
        List<SysRolesVO> roles = Lists.newArrayList();
        List<Long> longs = Lists.newArrayList();
        sysRoleDOS.forEach(sysRoleDO -> {
            SysRolesVO sysRolesVO = new SysRolesVO();
            BeanUtils.copyProperties(sysRoleDO, sysRolesVO);
            roles.add(sysRolesVO);
            longs.add(sysRoleDO.getId());
        });
        List<AclModuleLevelDtoVO> aclModuleLevelDtoVOS = roleTreeMMP(userId, longs, userId, roleMmmpGG.getUserPhone());
        sysUserRoleMenuVO.setRoles(roles);
        sysUserRoleMenuVO.setAcls(aclModuleLevelDtoVOS);
        return Result.wrapSuccessfulResult(sysUserRoleMenuVO);
    }

    @Override
    public List<AclModuleLevelDtoVO> userAclTree(Long userId, RoleMmmpGG roleMmmpGG) {
        List<SysAclVO> userAclList = sysCoreService.getUserAclList(userId, roleMmmpGG.getUserPhone());
        List<AclDtoVO> aclDtoList = Lists.newArrayList();
        for (SysAclVO acl : userAclList) {
            AclDtoVO dto = new AclDtoVO();
            BeanUtils.copyProperties(acl, dto);
            dto.setHasAcl(true);
            dto.setChecked(true);
            aclDtoList.add(dto);
        }
        List<AclModuleLevelDtoVO> aclModuleLevelDtoVOS = aclListToTree(aclDtoList);
        return aclModuleLevelDtoVOS;
    }

    public List<AclModuleLevelDtoVO> roleTree(Long roleId, Long userId, String userPhone) {
        //1、当前用户已分配的权限点
        List<SysAclVO> userAclList = sysCoreService.getCurrentUserAclList(userId, userPhone);
        //2、当前角色已分配的权限点
        List<SysAclVO> roleAclList = sysCoreService.getRoleAclList(roleId);
        // 3、当前系统所有权限点
        List<AclDtoVO> aclDtoList = Lists.newArrayList();

        // 用户已分配的权限点的id列表
        List<Long> userAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : userAclList) {
            userAclList1.add(sysAcl.getId());
        }
        Set<Long> userAclIdSet = new HashSet<Long>(userAclList1);
        //  角色已分配的权限的id的集合
        List<Long> roleAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : roleAclList) {
            roleAclList1.add(sysAcl.getId());
        }
        Set<Long> roleAclIdSet = new HashSet<Long>(roleAclList1);
        List<SysAclDO> allAclList = sysAclDAO.getAll(null);
        for (SysAclDO acl : allAclList) {
            AclDtoVO dto = AclDtoVO.adapt(acl);
            if (userAclIdSet.contains(acl.getId())) {
                dto.setHasAcl(true);
            }
            if (roleAclIdSet.contains(acl.getId())) {
                dto.setChecked(true);
            }
            aclDtoList.add(dto);
        }
        List<AclModuleLevelDtoVO> aclModuleLevelDtoVOS = aclListToTree(aclDtoList);
        return aclModuleLevelDtoVOS;
    }

    public List<AclModuleLevelDtoVO> roleTreeMMP(Long roleId, List<Long> roleIds, Long userId, String userPhone) {
        //1、当前用户已分配的权限点
        List<SysAclVO> userAclList = sysCoreService.getCurrentUserAclList(userId, userPhone);
        List<SysAclVO> roleAclList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roleIds)) {
            roleIds.forEach(aLong -> {
                //2、当前角色已分配的权限点
                roleAclList.addAll(sysCoreService.getRoleAclList(aLong));
            });
        }

        // 3、当前系统所有权限点
        List<AclDtoVO> aclDtoList = Lists.newArrayList();

        // 用户已分配的权限点的id列表
        List<Long> userAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : userAclList) {
            userAclList1.add(sysAcl.getId());
        }
        Set<Long> userAclIdSet = new HashSet<Long>(userAclList1);
        //  角色已分配的权限的id的集合
        List<Long> roleAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : roleAclList) {
            roleAclList1.add(sysAcl.getId());
        }
        Set<Long> roleAclIdSet = new HashSet<Long>(roleAclList1);
        List<SysAclDO> allAclList = sysAclDAO.getAll(null);
        for (SysAclDO acl : allAclList) {
            AclDtoVO dto = AclDtoVO.adapt(acl);
            if (userAclIdSet.contains(acl.getId())) {
                dto.setHasAcl(true);
            }
            if (roleAclIdSet.contains(acl.getId())) {
                dto.setChecked(true);
            }
            aclDtoList.add(dto);
        }
        List<AclModuleLevelDtoVO> aclModuleLevelDtoVOS = aclListToTree(aclDtoList);
        return aclModuleLevelDtoVOS;
    }

    private List<AclModuleLevelDtoVO> aclListToTree(List<AclDtoVO> aclDtoList) {
        if (CollectionUtils.isEmpty(aclDtoList)) {
            return Lists.newArrayList();
        }
        List<AclModuleLevelDtoVO> aclModuleLevelList = sysAclModuleTreeService.aclModuleTree(null);
        //key  权限模块id value 权限点的AclDto
        //每一个模块下面对应的权限点列表
        Multimap<Long, AclDtoVO> moduleIdAclMap = ArrayListMultimap.create();
        for (AclDtoVO acl : aclDtoList) {
            moduleIdAclMap.put(acl.getSysAclModuleId(), acl);
        }
        bindAclsWithOrder(aclModuleLevelList, moduleIdAclMap);
        return aclModuleLevelList;
    }

    //将权限点绑定到权限模块树上
    private void bindAclsWithOrder(List<AclModuleLevelDtoVO> aclModuleLevelList, Multimap<Long, AclDtoVO> moduleIdAclMap) {
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return;
        }
        for (AclModuleLevelDtoVO dto : aclModuleLevelList) {
            //当前模块下的所有权限点
            List<AclDtoVO> aclDtoList = (List<AclDtoVO>) moduleIdAclMap.get(dto.getId());
            if (!CollectionUtils.isEmpty(aclDtoList)) {
                Collections.sort(aclDtoList, aclSeqComparator);
                dto.setAclList(aclDtoList);
            }
            bindAclsWithOrder(dto.getAclModuleList(), moduleIdAclMap);
        }

    }

    private Comparator<AclDtoVO> aclSeqComparator = new Comparator<AclDtoVO>() {
        public int compare(AclDtoVO o1, AclDtoVO o2) {
            return o1.getSysAclSeq() - o2.getSysAclSeq();
        }
    };

    @Override
    public Result<List<SysAllRoleVO>> getAllRoleListByNoParam() {
        List<SysRoleDO> sysRoleDOS = sysRoleDAO.getAllRoleListByNoParam();
        List<SysAllRoleVO> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(sysRoleDOS)) {
            return Result.wrapSuccessfulResult(Lists.newArrayList());
        }
        sysRoleDOS.forEach(sysRoleDO -> {
            SysAllRoleVO sysAllRoleVO = new SysAllRoleVO();
            BeanUtils.copyProperties(sysRoleDO, sysAllRoleVO);
            list.add(sysAllRoleVO);
        });
        return Result.wrapSuccessfulResult(list);
    }

    public static void main(String[] args) {
        Set<Integer> aclModules = Sets.newHashSet();
        for (int i = 0; i < 4; i++) {
            aclModules.add(i);
            aclModules.add(1);
            aclModules.add(2);
        }
        for (int i = 0; i < 4; i++) {
            aclModules.add(i);
            aclModules.add(1);
            aclModules.add(2);
        }
        aclModules.forEach(integer -> {
            System.out.println(integer);
        });
    }

    /**
     * 删除角色信息
     */
    @Override
    public Result<Object> delByUuid(SysRoleReq sysRoleReq) {

        SysRoleDO sysRoleDO = sysRoleDAO.getByUuid(sysRoleReq.getSysRoleUuid());
        if (null == sysRoleDO) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DEPT_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DEPT_NO_EXIST_FAIL.getErrorMessage());
        }
        long roleId = sysRoleDO.getId();
        List<SysRoleUserDO> sysRoleUserDOList = sysRoleUserDAO.findRoleUserByRoleId(roleId);
        if (sysRoleUserDOList.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_USER_ROLE_HAS_EXITS_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_USER_ROLE_HAS_EXITS_FAIL.getErrorMessage());
        }
        List<SysRoleAclDO> sysRoleAclDOList = sysRoleAclDAO.findRoleAclByRoleId(roleId);
        if (sysRoleAclDOList.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_ROLE_ACL_HAS_EXITS_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_ROLE_ACL_HAS_EXITS_FAIL.getErrorMessage());
        }
        SysRoleDO after = new SysRoleDO();
        after.setSysRoleUuid(sysRoleReq.getSysRoleUuid());
        //TODO
        after.setDelFlag("1");
        after.setUpdateBy(sysRoleReq.getUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        sysRoleDAO.updateRole(after);
        return Result.wrapSuccessfulResult("删除角色成功");
    }

    /**
     * 添加角色信息
     */
    @Override
    public Result<Object> addSysRole(AddSysRoleReq addSysRoleReq) {
        SysRoleDO isExit = sysRoleDAO.findSysRoleByName(addSysRoleReq.getSysRoleName());
        if (isExit == null) {
            SysRoleDO sysRoleDO = new SysRoleDO();
            List<String> acliList = addSysRoleReq.getAclList();
            addSysRoleReq.setCreateBy("sys");
            addSysRoleReq.setCreateTime(DateUtil.getDateTime());
            addSysRoleReq.setUpdateTime(DateUtil.getDateTime());
            addSysRoleReq.setSysRoleUuid(StringUtil.genUUID());
            addSysRoleReq.setSysRoleType("2");
            addSysRoleReq.setDelFlag("0");
            addSysRoleReq.setUpdateBy("sys");
            BeanUtils.copyProperties(addSysRoleReq, sysRoleDO);
            int count = sysRoleDAO.insert(sysRoleDO);
            if (count > 0) {
                long roleId = sysRoleDO.getId();
                /**添加用户权限表*/
                for (int i = 0; i < acliList.size(); i++) {
                    SysRoleAclDO sysRoleAclDO = sysRoleAclDAO.findRoleAclByUuidAndRoleId(roleId, acliList.get(i));
                    if (sysRoleAclDO == null) {
                        /**查询该权限是否存在*/
                        SysAclDO sysAclDO = sysAclDAO.findSysAclByUuid(acliList.get(i));
                        if (sysAclDO == null) {
                            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_ROLE_PASS_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_ROLE_PASS_FAIL.getErrorMessage());
                        }
                        SysRoleAclDO sysRoleAclDO1 = new SysRoleAclDO();
                        sysRoleAclDO1.setSysRoleAclUuid(acliList.get(i));
                        sysRoleAclDO1.setSysRoleId(roleId);
                        sysRoleAclDO1.setSysAclId(sysAclDO.getId());
                        sysRoleAclDO1.setCreateBy(addSysRoleReq.getUserName());
                        sysRoleAclDO1.setCreateTime(DateUtil.getDateTime());
                        sysRoleAclDO1.setUpdateTime(DateUtil.getDateTime());
                        sysRoleAclDO1.setDelFlag("0");
                        sysRoleAclDO1.setUpdateBy(addSysRoleReq.getUserName());
                        sysRoleAclDAO.insert(sysRoleAclDO1);
                    }
                }
            }
            return Result.wrapSuccessfulResult("添加角色成功");
        } else {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_ROLE_IS_EXIT.getErrorCode(), ErrorEnum.ERROR_ADD_ROLE_IS_EXIT.getErrorMessage());
        }
    }

    /**
     * 修改角色权限
     */
    @Override
    public Result<Object> editSysRole(EditSysRoleReq editSysRoleReq) {
        SysRoleDO isExit = sysRoleDAO.findSysRoleByNameAndUuid(editSysRoleReq.getSysRoleName(), editSysRoleReq.getSysRoleUuid());
        if (isExit == null) {
            /**根据角色uuid获取roleId*/
            String roleUuid = editSysRoleReq.getSysRoleUuid();
            SysRoleDO sysRoleDO = sysRoleDAO.getByUuid(roleUuid);
            long roleId = sysRoleDO.getId();
            List<String> aclList = editSysRoleReq.getAclList();
            List<String> aclExitList = sysRoleAclDAO.finddUuidByRoleId(roleId);
            /**修改角色信息(名称)*/
            SysRoleDO sysRoleDO1 = new SysRoleDO();
            BeanUtils.copyProperties(editSysRoleReq, sysRoleDO);
            sysRoleDAO.updateRole(sysRoleDO);
            /**循环赋值*/
            List<String> addList = new ArrayList<String>();
            List<String> delList = new ArrayList<String>();
            for (int i = 0; i < aclList.size(); i++) {
                addList.add(aclList.get(i));
            }
            for (int i = 0; i < aclExitList.size(); i++) {
                delList.add(aclExitList.get(i));
            }
            /**判断查出需要添加的权限*/
            for (String num : aclExitList) {
                if (addList.contains(num)) {
                    addList.remove(num);
                }
            }
            /**判断查找出需要删除的权限*/
            for (String num : aclList) {
                if (delList.contains(num)) {
                    delList.remove(num);
                }
            }
            /**添加角色权限*/
            for (int i = 0; i < addList.size(); i++) {
                SysAclDO sysAclDO = new SysAclDO();
                sysAclDO = sysAclDAO.findSysAclByUuid(addList.get(i));
                if (sysAclDO != null) {
                    SysRoleAclDO sysRoleAclDO = new SysRoleAclDO();
                    sysRoleAclDO.setSysRoleAclUuid(addList.get(i));
                    sysRoleAclDO.setSysRoleId(roleId);
                    sysRoleAclDO.setSysAclId(sysAclDO.getId());
                    sysRoleAclDO.setCreateBy(editSysRoleReq.getUserName());
                    sysRoleAclDO.setCreateTime(DateUtil.getDateTime());
                    sysRoleAclDO.setUpdateTime(DateUtil.getDateTime());
                    sysRoleAclDO.setDelFlag("0");
                    sysRoleAclDO.setUpdateBy(editSysRoleReq.getUserName());
                    sysRoleAclDAO.insert(sysRoleAclDO);
                }
            }
            /**删除角色权限*/
            for (int i = 0; i < delList.size(); i++) {
                sysRoleAclDAO.deleteRoleAclByUuidAndRoleId(roleId, delList.get(i));
            }
            return Result.wrapSuccessfulResult("修改角色成功");
        } else {
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_ROLE_IS_EXIT.getErrorCode(), ErrorEnum.ERROR_EDIT_ROLE_IS_EXIT.getErrorMessage());
        }

    }
}
