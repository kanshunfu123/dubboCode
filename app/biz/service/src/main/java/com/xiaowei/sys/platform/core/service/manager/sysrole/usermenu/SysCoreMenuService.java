package com.xiaowei.sys.platform.core.service.manager.sysrole.usermenu;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleUserDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleAclDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by 李杰 on 2018/9/20.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysCoreMenuService {
    @Autowired
    private SysAclDAO sysAclDAO;
    @Autowired
    private SysRoleUserDAO sysRoleUserDAO;
    @Autowired
    private SysRoleAclDAO sysRoleAclDAO;
    @Value("${super.man}")
    private String superMan;
    //根据用户id查询对应的权限点
    public List<AclMenuDtoVO> getUserAclList(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        if (isSuperAdmin(userIsSuperMainInfoVO.getUserPhone())) {
            SysAclDO entity=new SysAclDO();
            entity.setSysAclPermissionType(userIsSuperMainInfoVO.getSysAclModuleType());
            List<SysAclDO> sysAclDOS = sysAclDAO.getAll(entity);
            if (CollectionUtils.isEmpty(sysAclDOS)) {
                return Lists.newArrayList();
            }
            List<AclMenuDtoVO> sysAclVOS = Lists.newArrayList();
            Multimap<String, AclMenuDtoVO> multimap = ArrayListMultimap.create();
            sysAclDOS.forEach(sysAclDO -> {
                AclMenuDtoVO sysAclVO = new AclMenuDtoVO();
                BeanUtils.copyProperties(sysAclDO, sysAclVO);
                sysAclVOS.add(sysAclVO);
            });
//            List<AclMenuDtoVO> aaa = separateMenuAndButton(sysAclVOS);
            return sysAclVOS;
        }


        //得到用户已分配的角色id
        List<Long> userRoleIdList = sysRoleUserDAO.getRoleIdListByUserId(userIsSuperMainInfoVO.getUserId());
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<SysRoleAclDO> sysRoleAclDOS = Lists.newArrayList();
        userRoleIdList.forEach(integer -> {
            SysRoleAclDO sysRoleAclDO = new SysRoleAclDO();
            sysRoleAclDO.setSysRoleId(integer);
            sysRoleAclDOS.add(sysRoleAclDO);
        });
        //根据角色id列表查询权限点id列表
        List<SysRoleAclDO> userAclIdList = sysRoleAclDAO.getAclIdListByRoleIdList(sysRoleAclDOS);
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        List<SysAclDO> sysAclDOS = Lists.newArrayList();
        userAclIdList.forEach(sysRoleAclDO -> {
            SysAclDO sysAclDO = new SysAclDO();
            sysAclDO.setId(sysRoleAclDO.getSysAclId());
            sysAclDOS.add(sysAclDO);
        });
        //根据权限id集合查询权限点对象的集合
        List<SysAclDO> sysAclDOS1 = sysAclDAO.getByIdList(sysAclDOS);
        if (CollectionUtils.isEmpty(sysAclDOS1)) {
            return Lists.newArrayList();
        }
        List<AclMenuDtoVO> sysAclVOS = Lists.newArrayList();
        sysAclDOS1.forEach(sysAclDO -> {
            if (userIsSuperMainInfoVO.getSysAclModuleType().equals(sysAclDO.getSysAclPermissionType())){
                AclMenuDtoVO sysAclVO = new AclMenuDtoVO();
                BeanUtils.copyProperties(sysAclDO, sysAclVO);
                sysAclVOS.add(sysAclVO);
            }
        });
        /*List<AclMenuDtoVO> aaa = separateMenuAndButton(sysAclVOS);
        return aaa;*/
        return sysAclVOS;
    }

    //将菜单和按钮区分开
    public List<AclMenuDtoVO> separateMenuAndButton(List<AclMenuDtoVO> aclMenuDtoVOS) {
        //每个模块的权限  key 模块id
        Multimap<Long, AclMenuDtoVO> eachModuleAcls = ArrayListMultimap.create();
        Set<Long> moduleId = Sets.newHashSet();
        aclMenuDtoVOS.forEach(aclMenuDtoVO -> {
            eachModuleAcls.put(aclMenuDtoVO.getSysAclModuleId(), aclMenuDtoVO);
            moduleId.add(aclMenuDtoVO.getSysAclModuleId());
        });
        List<AclMenuDtoVO> dtoVOS = Lists.newArrayList();
        moduleId.forEach(aLong -> {
            //得到一组相同模块的list
            List<AclMenuDtoVO> vos = (List<AclMenuDtoVO>) eachModuleAcls.get(aLong);
            if (!CollectionUtils.isEmpty(vos)) {
                AclMenuDtoVO aclMenuO = new AclMenuDtoVO();
                List<AclMenuDtoVO> buttons = Lists.newArrayList();
                //遍历模块集合
                vos.forEach(aclMenuDtoVO -> {
                    //菜单
                    if ("1".equals(aclMenuDtoVO.getSysAclType())) {
                        BeanUtils.copyProperties(aclMenuDtoVO,aclMenuO);
//                        dtoVOS.add(aclMenuDtoVO);
                    } else {
                        buttons.add(aclMenuDtoVO);
                    }
                });
                aclMenuO.setButtons(buttons);
                dtoVOS.add(aclMenuO);
            }
        });
        return dtoVOS;
    }

    //是否是超级管理员
    public boolean isSuperAdmin(String userPhone) {
        // 这里是我自己定义了一个假的超级管理员规则
        // 可以是配置文件获取，可以指定某个用户，也可以指定某个角色
        if (superMan.contains(userPhone.trim())) {
            return true;
        }
        return false;
    }
}
