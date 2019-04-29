package com.xiaowei.sys.platform.core.service.manager.sysrole;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysRoleUserDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleAclDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysCoreServiceImpl implements SysCoreService {

    @Autowired
    private SysAclDAO sysAclDAO;
    @Autowired
    private SysRoleUserDAO sysRoleUserDAO;
    @Autowired
    private SysRoleAclDAO sysRoleAclDAO;
    @Value("${super.man}")
    private String superMan;
    //根据用户id查询对应的权限点
    /*public List<SysAclVO> getUserAclList(Long userId) {
        if (isSuperAdmin()) {
            List<SysAclDO> sysAclDOS = sysAclDAO.getAll();
            if (CollectionUtils.isEmpty(sysAclDOS)) {
                return Lists.newArrayList();
            }
            List<SysAclVO> vos = new ArrayList<>();
            sysAclDOS.forEach(sysAclDO -> {
                SysAclVO sysAclVO = new SysAclVO();
                BeanUtils.copyProperties(sysAclDO, sysAclVO);
                vos.add(sysAclVO);
            });
            return vos;
        }
        //得到用户已分配的角色id
        List<Long> userRoleIdList = sysRoleUserDAO.getRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<SysRoleAclDO> sysRoleAclDOS = Lists.newArrayList();
        userRoleIdList.forEach(aLong -> {
            SysRoleAclDO sysRoleAclDO = new SysRoleAclDO();
            sysRoleAclDO.setSysRoleId(aLong);
            sysRoleAclDOS.add(sysRoleAclDO);
        });
        //根据角色id列表查询权限点id列表
        List<SysRoleAclDO> aclIdListByRoleIdList = sysRoleAclDAO.getAclIdListByRoleIdList(sysRoleAclDOS);
        if (CollectionUtils.isEmpty(aclIdListByRoleIdList)) {
            return Lists.newArrayList();
        }
        List<SysAclDO> sysAclDOS = Lists.newArrayList();
        aclIdListByRoleIdList.forEach(integer -> {
            SysAclDO sysAclDO = new SysAclDO();
            sysAclDO.setId(integer.getId());
        });
        //根据权限id集合查询权限点对象的集合
        List<SysAclDO> sysAclDOS1 = sysAclDAO.getByIdList(sysAclDOS);
        if(CollectionUtils.isEmpty(sysAclDOS1)){
            return Lists.newArrayList();
        }
        List<SysAclVO> sysAclVOS=new ArrayList<>();
        sysAclDOS1.forEach(sysAclDO -> {
            SysAclVO sysAclVO=new SysAclVO();
            BeanUtils.copyProperties(sysAclDO,sysAclVO);
            sysAclVOS.add(sysAclVO);
        });
        return sysAclVOS;
    }*/

    //获取当前用户权限点列表
    @Override
    public List<SysAclVO> getCurrentUserAclList(Long userId,String userPhone) {

        //TODO  获取当前登录系统的  用户  id
        SysUserVO sysUserVO = new SysUserVO();
        sysUserVO.setId(2L);

        return getUserAclList(userId,userPhone);
    }

    //某个角色已分配的权限点列表
    @Override
    public List<SysAclVO> getRoleAclList(Long roleId) {
        List<SysRoleAclDO> sysRoleAclDOS = Lists.newArrayList();
        SysRoleAclDO sysRoleAclDO = new SysRoleAclDO();
        sysRoleAclDO.setSysRoleId(roleId);
        sysRoleAclDOS.add(sysRoleAclDO);
        //根据角色id列表查询权限点id列表
        List<SysRoleAclDO> aclIdList = sysRoleAclDAO.getAclIdListByRoleIdList(sysRoleAclDOS);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        List<SysAclDO> sysAclDOS = Lists.newArrayList();
        aclIdList.forEach(sysRoleAclDO1 -> {
            SysAclDO sysAclDO = new SysAclDO();
            sysAclDO.setId(sysRoleAclDO1.getSysAclId());
            sysAclDOS.add(sysAclDO);
        });
        List<SysAclDO> dos = sysAclDAO.getByIdList(sysAclDOS);
        if (CollectionUtils.isEmpty(dos)) {
            return Lists.newArrayList();
        }
        List<SysAclVO> sysAclVOS = Lists.newArrayList();
        dos.forEach(sysAclDO -> {
            SysAclVO sysAclVO = new SysAclVO();
            sysAclVO.setId(sysAclDO.getId());
            sysAclVOS.add(sysAclVO);
        });
        return sysAclVOS;
    }

    //根据用户id查询对应的权限点
    @Override
    public List<SysAclVO> getUserAclList(Long userId,String userPhone) {
        if (isSuperAdmin(userPhone)) {
            List<SysAclDO> sysAclDOS = sysAclDAO.getAll(null);
            if (CollectionUtils.isEmpty(sysAclDOS)) {
                return Lists.newArrayList();
            }
            List<SysAclVO> sysAclVOS = Lists.newArrayList();
            sysAclDOS.forEach(sysAclDO -> {
                SysAclVO sysAclVO = new SysAclVO();
                BeanUtils.copyProperties(sysAclDO, sysAclVO);
                sysAclVOS.add(sysAclVO);
            });
            return sysAclVOS;
        }
        //得到用户已分配的角色id
        List<Long> userRoleIdList = sysRoleUserDAO.getRoleIdListByUserId(userId);
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
        List<SysAclVO> sysAclVOS = Lists.newArrayList();
        sysAclDOS1.forEach(sysAclDO -> {
            SysAclVO sysAclVO = new SysAclVO();
            BeanUtils.copyProperties(sysAclDO, sysAclVO);
            sysAclVOS.add(sysAclVO);
        });
        return sysAclVOS;
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
