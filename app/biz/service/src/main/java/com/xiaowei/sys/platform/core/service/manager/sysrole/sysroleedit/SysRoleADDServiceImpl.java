package com.xiaowei.sys.platform.core.service.manager.sysrole.sysroleedit;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclModuleDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.service.manager.sysaclmodule.SysAclModuleTreeService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by MOMO on 2018/9/18.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysRoleADDServiceImpl implements SysRoleADDService {
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

    /*@Override
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
                List<SysAclModuleDO> sysAclModuleDOS = sysAclModuleDAO.getAllAclModel();
                if (!CollectionUtils.isEmpty(sysAclModuleDOS)) {
                    sysAclModuleDOS.forEach(sysAclModuleDO -> {
                        //权限模块列表
                        SysModulAclVO sysModulAclVO = new SysModulAclVO();
                        List<String> dos = (List<String>) longSysAclDOMultimap.get(sysAclModuleDO.getId());
                        if (!CollectionUtils.isEmpty(dos)) {
                            sysModulAclVO.setSysAclModule(sysAclModuleDO.getSysAclModuleName());
                            sysModulAclVO.setAcl(dos);
                            sysModulAclVOList.add(sysModulAclVO);
                            sysRoleAndAclVO.setSysModulAclVO(sysModulAclVOList);
                        }
                    });
                }
                aaaa.add(sysRoleAndAclVO);
            });
        }
        roleListPageVO.setDatas(aaaa);
        return Result.wrapSuccessfulResult(roleListPageVO);
    }*/

    /*@Override
    public Result<RoleAndAclVO> roleAndAclsTree(String sysRoleUuid) {
        SysRoleDO sysRoleDO = sysRoleDAO.getByUuid(sysRoleUuid);
        if (null == sysRoleDO) {
            Result.wrapSuccessfulResult(ErrorEnum.ERROR_ROLE_NOT_EXIST_FAIL.getErrorMessage(), ErrorEnum.ERROR_ROLE_NOT_EXIST_FAIL.getErrorMessage());
        }
        RoleAndAclVO roleAndAclVO = new RoleAndAclVO();
        roleAndAclVO.setSysRoleName(sysRoleDO.getSysRoleName());
        roleAndAclVO.setSysRoleUuid(sysRoleDO.getSysRoleUuid());
        roleAndAclVO.setAcls(roleTree());
        return Result.wrapSuccessfulResult(roleAndAclVO);
    }*/

    /*public List<AclModuleLevelDtoVO> userAclTree(Long userId) {
        List<SysAclVO> userAclList = sysCoreService.getUserAclList(userId);
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
    }*/

    @Override
    public List<AclModuleLevelDtoVO> roleTree(Long userId,
                                              String userPhone) {
        //1、当前用户已分配的权限点
        List<SysAclVO> userAclList = sysCoreService.getCurrentUserAclList(userId, userPhone);
        //2、当前角色已分配的权限点
        //List<SysAclVO> roleAclList = sysCoreService.getRoleAclList(roleId);
        // 3、当前系统所有权限点
        List<AclDtoVO> aclDtoList = Lists.newArrayList();

        // 用户已分配的权限点的id列表
        List<Long> userAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : userAclList) {
            userAclList1.add(sysAcl.getId());
        }
        Set<Long> userAclIdSet = new HashSet<Long>(userAclList1);
        //  角色已分配的权限的id的集合
       /* List<Long> roleAclList1 = Lists.newArrayList();
        for (SysAclVO sysAcl : roleAclList) {
            roleAclList1.add(sysAcl.getId());
        }*/
        // Set<Long> roleAclIdSet = new HashSet<Long>(roleAclList1);
        List<SysAclDO> allAclList = sysAclDAO.getAll(null);
        for (SysAclDO acl : allAclList) {
            AclDtoVO dto = AclDtoVO.adapt(acl);
            if (userAclIdSet.contains(acl.getId())) {
                dto.setHasAcl(true);
            }
            dto.setChecked(false);
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
}
