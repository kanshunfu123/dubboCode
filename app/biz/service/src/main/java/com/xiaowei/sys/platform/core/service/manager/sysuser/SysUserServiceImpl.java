package com.xiaowei.sys.platform.core.service.manager.sysuser;

import com.google.common.collect.Lists;
import com.xiaowei.sys.platform.core.common.dal.dao.*;
import com.xiaowei.sys.platform.core.common.dal.dataobject.*;
import com.xiaowei.sys.platform.core.common.dal.paging.UserDeptAreaRolesPage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.userRoleSArea;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.*;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.JcMD5Util;
import com.xiaowei.sys.platform.core.facade.service.util.LevelUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaListVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysUserAreaVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.*;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysarea.SysAreaServiceImpl;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysCoreService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysCoreServiceImpl;
import com.yeecli.component.common.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by MOMO on 2018/9/11.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private Logger logger = Logger.getLogger(SysUserServiceImpl.class);
    @Autowired
    private SysUserDAO sysUserDAO;
    @Autowired
    private SysAreaDAO sysAreaDAO;
    @Autowired
    private SysDeptDAO sysDeptDAO;
    @Autowired
    private SysRoleDAO sysRoleDAO;
    @Autowired
    private SysRoleUserDAO sysRoleUserDAO;
    @Autowired
    private SysAreaUserDAO sysAreaUserDAO;
    @Autowired
    private SysAreaServiceImpl sysAreaService;
    @Autowired
    private SysCoreServiceImpl sysCoreServiceImpl;
    @Autowired
    private SysLoginLogDAO sysLoginLogDAO;

    @Override
    public Result insertLoginLog(SysLoginLogDO sysLoginLog) {
        sysLoginLogDAO.insertLoginLog(sysLoginLog);
        return Result.wrapSuccessfulResult("插入日志成功");
    }

    @Override
    public Result<SysUserVO> loginByUsername(SysUserReq sysUserReq) {

        String userName = sysUserReq.getSysUserName();
        boolean flag = userName.contains("@");
        if (flag) {//邮箱登录
            sysUserReq.setSysUserEmail(userName);
        } else {//手机号登录
            sysUserReq.setSysUserPhone(userName);
        }
        String email = sysUserReq.getSysUserEmail();
        String phone = sysUserReq.getSysUserPhone();
        SysUserDO userDO = sysUserDAO.loginByUsername(email, phone);

        if (userDO == null) {//此处用户名不存在，防止恶意盗取密码，统一 用户名或者密码错误
            return Result.wrapErrorResult(ErrorEnum.ERROR_LOGIN_USER_ERROR_FAIL.getErrorCode(), ErrorEnum.ERROR_LOGIN_USER_ERROR_FAIL.getErrorMessage());
        }
        if (userDO.getDelFlag().equals("1")) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_LOGIN_USER_DELETED_FAIL.getErrorCode(), ErrorEnum.ERROR_LOGIN_USER_DELETED_FAIL.getErrorMessage());
        }
        //明文
        String pwd = sysUserReq.getSysUserPwd();
        String authPwd = "";
        try {
            authPwd = JcMD5Util.createMD5(pwd, userDO.getSysUserAuthSalt());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(2, "");
        }
        String saut = userDO.getSysUserAuthSalt();
        if (!userDO.getSysUserPwd().equals(authPwd)) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_LOGIN_USER_ERROR_FAIL.getErrorCode(), ErrorEnum.ERROR_LOGIN_USER_ERROR_FAIL.getErrorMessage());
        }
        SysUserVO sysUserRes = new SysUserVO();
        sysUserRes.setSysUserPhone(userDO.getSysUserPhone());
        sysUserRes.setSysUserEmail(userDO.getSysUserEmail());
        sysUserRes.setSysUserName(userDO.getSysUserName());
        sysUserRes.setSysUserUuid(userDO.getSysUserUuid());
        sysUserRes.setId(userDO.getId());
        sysUserRes.setIsThird(userDO.getIsThird());
        sysUserRes.setNameBottom(userDO.getNameBottom());
        sysUserRes.setNameTop(userDO.getNameTop());
        return Result.wrapSuccessfulResult(sysUserRes);

    }

    @Override
    public Result<UserDeptAreaRolesPageVO> userDeptAreaRolesList(UserDeptAreaRolesPageReq userDeptAreaRolesPageReq) {

        //请求参数
        UserDeptAreaRolesPage userDeptAreaRolesPage = new UserDeptAreaRolesPage();
        userDeptAreaRolesPage.setDeDelFlag("0");
        userDeptAreaRolesPage.setUDelFlag("0");
        BeanUtils.copyProperties(userDeptAreaRolesPageReq, userDeptAreaRolesPage);
        userDeptAreaRolesPage.setCurrPageNo(userDeptAreaRolesPageReq.getCurrPageNo());
        userDeptAreaRolesPage.setLimit(userDeptAreaRolesPageReq.getLimit());
        //查询用户信息
        UserDeptAreaRolesPage areaRolesPage = sysUserDAO.userPaging(userDeptAreaRolesPage);
        List<userRoleSArea> areaslist = areaRolesPage.getDatas();

        //最终封装好的数据
        UserDeptAreaRolesPageVO userDeptAreaRolesPageVO = new UserDeptAreaRolesPageVO();
        BeanUtils.copyProperties(areaRolesPage, userDeptAreaRolesPageVO);

        //最终的datas里的数据
        List<SysUserPagingVO> sysUserPagingVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(areaslist)) {
            areaslist.forEach(users -> {

                long userId = users.getUid();
                SysUserPagingVO sysUserPagingVO = new SysUserPagingVO();
                //根据用户的id查看该用户属于哪个区域
//                SysAreaDO sysAreaDO1 = sysAreaDAO.areaInfo(areaId);
                List<SysAreaListVO> dtoList = new ArrayList<>();
                List<SysAreaDO> sysAreaDOSaa = new ArrayList<>();
                //根据用户id获得区域列表
                List<SysAreaUserDO> sysAreaUserDOS = sysAreaUserDAO.getAreaUserListByUserId(userId);
                if (!CollectionUtils.isEmpty(sysAreaUserDOS)) {
                    List<SysAreaDO> sysAreaDOS = new ArrayList<>();
                    sysAreaUserDOS.forEach(sfjf -> {
                        SysAreaDO sysAreaDO = new SysAreaDO();
                        sysAreaDO.setId(sfjf.getSysAreaId());
                        sysAreaDOS.add(sysAreaDO);
                    });
                    sysAreaDOSaa = sysAreaDAO.areaListByareAIds(sysAreaDOS);
                }
                if (!CollectionUtils.isEmpty(sysAreaDOSaa)) {
                    sysAreaDOSaa.forEach(bbb -> {
                        SysAreaListVO sysAreaListVO1 = new SysAreaListVO();
                        sysAreaListVO1.setId(bbb.getId());
                        sysAreaListVO1.setSysAreaSeq(bbb.getSysAreaSeq());
                        sysAreaListVO1.setSysAreaName(bbb.getSysAreaName());
                        sysAreaListVO1.setLevel(bbb.getSysAreaLevel());
                        sysAreaListVO1.setSysAreaUuid(bbb.getSysAreaUuid());
                        sysAreaListVO1.setSysAreaCodeNum(bbb.getSysAreaCodeNum());
                        dtoList.add(sysAreaListVO1);
                    });
                }
                List<SysAreaListVO> sysAreaListVOS = sysAreaService.deptMenuToTree(dtoList);
                sysUserPagingVO.setAreas(sysAreaListVOS);
                //根据用户id获取角色列表
                List<SysRoleDO> sysRoleDOS = sysRoleDAO.getRoleByUserId(userId);
                List<SysRolesVO> roles = new ArrayList<>();
                if (!CollectionUtils.isEmpty(sysRoleDOS)) {
                    sysRoleDOS.forEach(sysRoleDO -> {
                        SysRolesVO sysRolesVO = new SysRolesVO();
                        BeanUtils.copyProperties(sysRoleDO, sysRolesVO);
                        roles.add(sysRolesVO);
                    });
                }
                sysUserPagingVO.setRoles(roles);
                BeanUtils.copyProperties(users, sysUserPagingVO);
                sysUserPagingVOS.add(sysUserPagingVO);
            });
            userDeptAreaRolesPageVO.setDatas(sysUserPagingVOS);
            return Result.wrapSuccessfulResult(userDeptAreaRolesPageVO);
        }
        return Result.wrapSuccessfulResult(userDeptAreaRolesPageVO);
    }

    @Override
    public Result<GetUserInfiByUuidVO> getUserInfiByUuid(String userUuid) {
        userRoleSArea userRoleSArea = sysUserDAO.getUserInfiByUuid(userUuid);
        if (userRoleSArea == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_INFO_BY_UUID_NOT_EXIST.getErrorCode(), ErrorEnum.ERROR_USER_INFO_BY_UUID_NOT_EXIST.getErrorMessage());
        }
        long areaId = userRoleSArea.getAreaId();
        //根据用户的id查看该用户属于哪个区域
        GetUserInfiByUuidVO getUserInfiByUuid = new GetUserInfiByUuidVO();
        SysAreaDO sysAreaDO1 = sysAreaDAO.areaInfo(areaId);
        getUserInfiByUuid.setAreaUuid(sysAreaDO1.getSysAreaUuid());
        StringBuffer sb = new StringBuffer();
        if (sysAreaDO1.getSysAreaParentId() != 0) {//该区域有上级，根据parentId继续查
            sb.append(sysAreaDO1.getSysAreaName());
            //根据用户的id查看该用户属于哪个区域
            SysAreaDO sysAreaDO2 = sysAreaDAO.areaInfo(sysAreaDO1.getSysAreaParentId());

            if (sysAreaDO2.getSysAreaParentId() != 0) {//该区域有上级，根据parentId继续查
                sb.insert(0, sysAreaDO2.getSysAreaName() + "、");
                //根据用户的id查看该用户属于哪个区域
                SysAreaDO sysAreaDO3 = sysAreaDAO.areaInfo(sysAreaDO2.getSysAreaParentId());
                sb.insert(0, sysAreaDO3.getSysAreaName() + "、");
            } else {
                sb.insert(0, sysAreaDO2.getSysAreaName() + "、");
            }
        } else {
            sb.insert(0, sysAreaDO1.getSysAreaName());
        }
        getUserInfiByUuid.setAreaInfo(sb.toString());
        //根据用户id获取角色列表
        List<SysRoleDO> sysRoleDOS = sysRoleDAO.getRoleByUserId(userRoleSArea.getUid());
        List<SysRolesVO> roles = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sysRoleDOS)) {
            sysRoleDOS.forEach(sysRoleDO -> {
                SysRolesVO sysRolesVO = new SysRolesVO();
                BeanUtils.copyProperties(sysRoleDO, sysRolesVO);
                roles.add(sysRolesVO);
            });
        }
        getUserInfiByUuid.setRoles(roles);
        BeanUtils.copyProperties(userRoleSArea, getUserInfiByUuid);
        return Result.wrapSuccessfulResult(getUserInfiByUuid);
    }

    @Override
    public Result<Object> updateUser(SysUserUpdateReq sysUserUpdateReq) {
        SysUserDO userDOaa = sysUserDAO.getByUuid(sysUserUpdateReq.getSysUserUuid());
        if (userDOaa == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_INFO_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_INFO_NOT_EXIST_FAIL.getErrorMessage());
        }
        Result<Object> objectResult = checkPhoneORemailUniqueness(sysUserUpdateReq.getSysUserEmail(), sysUserUpdateReq.getSysUserPhone(), sysUserUpdateReq.getSysUserUuid());
        if (!objectResult.isSuccess()) {
            return objectResult;
        }

        SysUserDO userDO = new SysUserDO();
        String newPwd = sysUserUpdateReq.getSysUserPwd().trim();
        //进行修改密码操作
        if (sysUserUpdateReq.isChangePwd() && StringUtils.isNotBlank(newPwd)) {
            BeanUtils.copyProperties(sysUserUpdateReq, userDO);
            String saut = StringUtil.genUUIDsubstring();
            String lookPwd = sysUserUpdateReq.getSysUserPwd();
            String pwd = "";
            try {
                pwd = JcMD5Util.createMD5(lookPwd, saut);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return Result.wrapErrorResult(2, "");
            }
            userDO.setSysUserPwd(pwd);
            userDO.setSysUserAuthSalt(saut);
            userDO.setUpdateBy(sysUserUpdateReq.getUserName());
            userDO.setUpdateTime(DateUtil.getDateTime());
            userDO.setCreateBy(sysUserUpdateReq.getUserName());
            userDO.setCreateTime(DateUtil.getDateTime());
        } else {
            BeanUtils.copyProperties(sysUserUpdateReq, userDO);
            userDO.setUpdateBy(sysUserUpdateReq.getUserName());
            userDO.setUpdateTime(DateUtil.getDateTime());
            userDO.setCreateBy(sysUserUpdateReq.getUserName());
            userDO.setCreateTime(DateUtil.getDateTime());
            userDO.setSysUserPwd(null);
        }
        //根据部门uuid获得部门信息
        SysDeptDO sysDeptDO = sysDeptDO(sysUserUpdateReq.getSysDeptUuid());
        if (sysDeptDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_USER_DEPT_NOT_EXIST_EXIST.getErrorCode(), ErrorEnum.ERROR_ADD_USER_DEPT_NOT_EXIST_EXIST.getErrorMessage());
        }
        userDO.setDeptId(sysDeptDO.getId());
        //根据区域uuid获得区域id
       /* SysAreaDO sysAreaDO = sysAreaDO(sysUserUpdateReq.getSysAreaUuid());
        if (sysAreaDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_USER_AREA_NOT_EXIST_EXIST.getErrorCode(), ErrorEnum.ERROR_ADD_USER_AREA_NOT_EXIST_EXIST.getErrorMessage());
        }
        userDO.setAreaId(sysAreaDO.getId());*/
        //根据区域uuid获得区域id
        List<SysAreaDO> sysAreaDOS = sysAreaDO(sysUserUpdateReq.getAreaUuidList());
        //批量更新用户与区域关系  先删除用户与区域的关系
        areaUserUpdatebatch(sysAreaDOS, userDOaa.getId(), "1", sysUserUpdateReq);
        //批量插入用户与区域关系
        areaUserInsertBatch(sysAreaDOS, userDOaa.getId(), "0", sysUserUpdateReq);

        //获得前端给的角色uuid列表
        List<String> roles = sysUserUpdateReq.getRoles();
        List<SysRoleDO> sysRos = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roles)) {
            //根据角色uuid列表，查询角色id
            sysRos = sysRoleDAO.getRoleListByRoleUUID(roles);
        }
        newSetRoleAndUserRelationship(sysRos, userDO.getSysUserUuid(), sysUserUpdateReq);
        sysUserDAO.updateUser(userDO);
        return Result.wrapSuccessfulResult("编辑用户信息成功");
    }

    @Override
    public Result<Object> delUser(SysUserUpdateReq sysUserUpdateReq) {
        SysUserDO userDO = new SysUserDO();
        userDO.setUpdateBy(sysUserUpdateReq.getUserName());
        userDO.setUpdateTime(DateUtil.getDateTime());
        sysUserUpdateReq.setDelFlag("1");
        BeanUtils.copyProperties(sysUserUpdateReq, userDO);
        sysUserDAO.updateUser(userDO);
        return Result.wrapSuccessfulResult("删除用户信息成功");
    }

    @Override
    public Result<Object> insertUser(SysUserUpdateReq sysUserUpdateReq) {
        Result<Object> objectResult = checkPhoneORemailUniqueness(sysUserUpdateReq.getSysUserEmail(), sysUserUpdateReq.getSysUserPhone(), sysUserUpdateReq.getSysUserUuid());
        if (!objectResult.isSuccess()) {
            return objectResult;
        }
        SysUserDO userDO = new SysUserDO();
        BeanUtils.copyProperties(sysUserUpdateReq, userDO);
        String saut = StringUtil.genUUIDsubstring();
        String lookPwd = userDO.getSysUserPwd();
        String pwd = "";
        try {
            pwd = JcMD5Util.createMD5(lookPwd, saut);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(2, "");
        }
        userDO.setSysUserPwd(pwd);
        userDO.setSysUserUuid(StringUtil.genUUID());
        userDO.setUpdateBy(sysUserUpdateReq.getUserName());
        userDO.setSysUserAuthSalt(saut);
        userDO.setUpdateTime(DateUtil.getDateTime());
        userDO.setCreateBy(sysUserUpdateReq.getUserName());
        userDO.setCreateTime(DateUtil.getDateTime());
        //根据部门uuid获得部门信息
        SysDeptDO sysDeptDO = sysDeptDO(sysUserUpdateReq.getSysDeptUuid());
        if (sysDeptDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_USER_DEPT_NOT_EXIST_EXIST.getErrorCode(), ErrorEnum.ERROR_ADD_USER_DEPT_NOT_EXIST_EXIST.getErrorMessage());
        }
        userDO.setDeptId(sysDeptDO.getId());
        //TODO 开始
        //根据区域uuid获得区域id
        /*SysAreaDO sysAreaDO = sysAreaDO(sysUserUpdateReq.getSysAreaUuid());
        if (sysAreaDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_USER_AREA_NOT_EXIST_EXIST.getErrorCode(), ErrorEnum.ERROR_ADD_USER_AREA_NOT_EXIST_EXIST.getErrorMessage());
        }
        userDO.setAreaId(sysAreaDO.getId());*/
        //TODO 结束
        sysUserDAO.insertUser(userDO);
        //获得新增用户主键
        long primaryKey = userDO.getId();
        //根据区域uuid获得区域id
        List<SysAreaDO> sysAreaDOS = sysAreaDO(sysUserUpdateReq.getAreaUuidList());
        //批量更新用户与区域关系  先删除用户与区域的关系
        //areaUserUpdatebatch(sysAreaDOS, primaryKey,"1");
        //批量插入用户与区域关系
        areaUserInsertBatch(sysAreaDOS, primaryKey, "0", sysUserUpdateReq);

        //获得前端给的角色uuid列表
        List<String> roles = sysUserUpdateReq.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            //根据角色uuid列表，查询角色id
            List<SysRoleDO> sysRos = sysRoleDAO.getRoleListByRoleUUID(roles);
            //得到 用户 角色关系 列表
            List<SysRoleUserDO> sysRoleUserDOS = getRoleANDUserList(sysRos, primaryKey, sysUserUpdateReq);
            //批量插入用户 角色关系
            sysRoleUserDAO.insertBatchTwo(sysRoleUserDOS);
        }
        return Result.wrapSuccessfulResult("新增用户成功");
    }

    //得到 用户 角色关系 列表
    private List<SysRoleUserDO> getRoleANDUserList(List<SysRoleDO> sysRos, long primaryKey, SysUserUpdateReq sysUserUpdateReq) {
        List<SysRoleUserDO> sysRoleUserDOS = new ArrayList<>();

        for (int i = 0; i < sysRos.size(); i++) {
            SysRoleUserDO sysRoleUserDO = new SysRoleUserDO();
            sysRoleUserDO.setCreateTime(DateUtil.getDateTime());
            sysRoleUserDO.setCreateBy(sysUserUpdateReq.getUserName());
            sysRoleUserDO.setDelFlag("0");
            sysRoleUserDO.setUpdateBy(sysUserUpdateReq.getUserName());
            sysRoleUserDO.setUpdateTime(DateUtil.getDateTime());
            sysRoleUserDO.setRoleId(sysRos.get(i).getId());
            sysRoleUserDO.setSysRoleUserUuid(StringUtil.genUUID());
            sysRoleUserDO.setUserId(primaryKey);
            sysRoleUserDOS.add(sysRoleUserDO);
        }
        return sysRoleUserDOS;
    }

    //根据部门uuid获得部门信息
    private SysDeptDO sysDeptDO(String deptUuid) {
        return sysDeptDAO.getByUuid(deptUuid);
    }

    //根据区域uuid获得区域id
    private SysAreaDO sysAreaDO(String areaUuid) {
        return sysAreaDAO.getByUuid(areaUuid);
    }

    //根据区域uuid 列表获得区域id
    private List<SysAreaDO> sysAreaDO(List<String> areaUuids) {
        if (CollectionUtils.isEmpty(areaUuids)) {
            return Lists.newArrayList();
        }
        List<SysAreaDO> sysAreaDOS = new ArrayList<>();
        areaUuids.forEach(aa -> {
            SysAreaDO sysAreaDO = new SysAreaDO();
            sysAreaDO.setSysAreaUuid(aa);
            sysAreaDOS.add(sysAreaDO);
        });
        return sysAreaDAO.getByUuidList(sysAreaDOS);
    }

    //批量更新用户与区域关系  先删除用户与区域的关系
    private void areaUserUpdatebatch(List<SysAreaDO> sysAreaDOS, long primaryKey, String delFlag, SysUserUpdateReq sysUserUpdateReq) {
        int size = sysAreaDOS.size();
        List<SysAreaUserDO> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            SysAreaUserDO sysAreaUserDO = new SysAreaUserDO();
            sysAreaUserDO.setUpdateBy(sysUserUpdateReq.getUserName());
            sysAreaUserDO.setUpdateTime(DateUtil.getDateTime());
            sysAreaUserDO.setDelFlag(delFlag);
            sysAreaUserDO.setSysUserId(primaryKey);
            list.add(sysAreaUserDO);
        }
        sysAreaUserDAO.updateBatch(list);
    }

    //批量插入用户与区域关系
    private void areaUserInsertBatch(List<SysAreaDO> sysAreaDOS, long primaryKey, String delFlag, SysUserUpdateReq sysUserUpdateReq) {
        int size = sysAreaDOS.size();
        List<SysAreaUserDO> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            SysAreaUserDO sysAreaUserDO = new SysAreaUserDO();
            sysAreaUserDO.setUpdateBy(sysUserUpdateReq.getUserName());
            sysAreaUserDO.setUpdateTime(DateUtil.getDateTime());
            sysAreaUserDO.setCreateBy(sysUserUpdateReq.getUserName());
            sysAreaUserDO.setCreateTime(DateUtil.getDateTime());
            sysAreaUserDO.setDelFlag(delFlag);
            sysAreaUserDO.setSysUserId(primaryKey);
            sysAreaUserDO.setSysAreaId(sysAreaDOS.get(i).getId());
            sysAreaUserDO.setSysUserAreaUuid(StringUtil.genUUID());
            list.add(sysAreaUserDO);
        }
        sysAreaUserDAO.insertBatchaa(list);
    }

    /**
     * 重新设置用户与角色的关系
     *
     * @param sysRos 新的 角色id列表
     * @param uuid   用户uuid
     */
    private void newSetRoleAndUserRelationship(List<SysRoleDO> sysRos, String uuid, SysUserUpdateReq sysUserUpdateReq) {
        //根据用户uuid查询用户id
        SysUserDO userDO = sysUserDAO.getByUuid(uuid);
        long userId = userDO.getId();
        //根据用户id 查询未被删除的角色id
        List<SysRoleUserDO> sysRoleUserDOS = sysRoleUserDAO.getRoleAndUserListByUserid(userId);
        if (sysRos.size() == sysRoleUserDOS.size()) {
            //旧的角色id
            Set<Long> oldRoleId = sysRoleUserDOS.stream().map(sysRoleDO -> sysRoleDO.getRoleId()).collect(Collectors.toSet());
            //新的角色id
            Set<Long> newRoleId = sysRos.stream().map(sysRoleDO -> sysRoleDO.getId()).collect(Collectors.toSet());
            oldRoleId.removeAll(newRoleId);
            if (CollectionUtils.isEmpty(oldRoleId)) {
                return;
            }
        }
        //批量更新，删除原先用户与角色关系
        updateRoleUsers(userDO.getId(), sysRos, sysUserUpdateReq);
        //批量添加 用户与角色关系
        List<SysRoleUserDO> list = new ArrayList<>();
        sysRos.forEach(bb -> {
            SysRoleUserDO sysRoleUserDO = new SysRoleUserDO();
            sysRoleUserDO.setSysRoleUserUuid(StringUtil.genUUID());
            sysRoleUserDO.setDelFlag("0");
            sysRoleUserDO.setRoleId(bb.getId());
            sysRoleUserDO.setUserId(userId);
            sysRoleUserDO.setUpdateTime(DateUtil.getDateTime());
            sysRoleUserDO.setUpdateBy(sysUserUpdateReq.getUserName());
            sysRoleUserDO.setCreateBy(sysUserUpdateReq.getUserName());
            sysRoleUserDO.setCreateTime(DateUtil.getDateTime());
            list.add(sysRoleUserDO);
        });
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        sysRoleUserDAO.insertBatch(list);
    }

    private void updateRoleUsers(Long userId, List<SysRoleDO> sysRos, SysUserUpdateReq sysUserUpdateReq) {
        if (CollectionUtils.isEmpty(sysRos)) {
            return;
        }
        List<SysRoleUserDO> list = new ArrayList<>();
        sysRos.forEach(aa -> {
            SysRoleUserDO sysRoleUserDO = new SysRoleUserDO();
            sysRoleUserDO.setUpdateTime(DateUtil.getDateTime());
            sysRoleUserDO.setUpdateBy(sysUserUpdateReq.getUserName());
            sysRoleUserDO.setRoleId(aa.getId());
            sysRoleUserDO.setUserId(userId);
            sysRoleUserDO.setDelFlag("1");
            list.add(sysRoleUserDO);
        });
        //批量更新，删除原先用户与角色关系
        sysRoleUserDAO.updateBatch(list);
    }

    public static void main(String[] args) {
        String abc = "发发发";
        StringBuffer sb = new StringBuffer();
        sb.append("sf");
        System.out.println(sb.insert(0, abc).toString());
    }

    /**
     * 新增/编辑 用户名、邮箱唯一
     *
     * @param email
     * @param phone
     * @param uuid
     * @return
     */
    private Result<Object> checkPhoneORemailUniqueness(String email, String phone, String uuid) {
        int count = 0;
        if (!StringUtils.isNotBlank(uuid)) {//新增
            count = sysUserDAO.checkPhoneORemailUniqueness(null, email, null);
            if (count > 0) {//email已存在
                return Result.wrapErrorResult(ErrorEnum.ERROR_USER_EMAIL_EXIST.getErrorCode(), ErrorEnum.ERROR_USER_EMAIL_EXIST.getErrorMessage());
            }
            count = sysUserDAO.checkPhoneORemailUniqueness(null, null, phone);
            if (count > 0) {//phone已存在
                return Result.wrapErrorResult(ErrorEnum.ERROR_USER_PHONE_EXIST.getErrorCode(), ErrorEnum.ERROR_USER_PHONE_EXIST.getErrorMessage());
            }
        } else {//编辑
            count = sysUserDAO.checkPhoneORemailUniqueness(uuid, email, null);
            if (count > 0) {//email已存在
                return Result.wrapErrorResult(ErrorEnum.ERROR_USER_EMAIL_EXIST.getErrorCode(), ErrorEnum.ERROR_USER_EMAIL_EXIST.getErrorMessage());
            }
            count = sysUserDAO.checkPhoneORemailUniqueness(uuid, null, phone);
            if (count > 0) {//phone已存在
                return Result.wrapErrorResult(ErrorEnum.ERROR_USER_PHONE_EXIST.getErrorCode(), ErrorEnum.ERROR_USER_PHONE_EXIST.getErrorMessage());
            }
        }
        return Result.wrapSuccessfulResult("可以新增/删除");
    }

    @Override
    public Result<List<DeptUser>> getChildDeptUserssByUserUuid(DeptUserReq deptUserReq) {
        List<DeptUser> deptUsers = Lists.newArrayList();

        //是否是超级管理员
        if (sysCoreServiceImpl.isSuperAdmin(deptUserReq.getUserPhone())) {
            DeptUser deptUser = new DeptUser();
            deptUser.setSuperAdmin(true);
            deptUsers.add(deptUser);
            return Result.wrapSuccessfulResult(deptUsers);
        }

        SysUserDO userDO = sysUserDAO.getByUuid(deptUserReq.getCurrentUserUuid());
        if (userDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_FAIL.getErrorMessage());
        }
        //根据部门id查看部门信息
        SysDeptDO sysDeptDO = sysDeptDAO.getDeptByUUID(userDO.getDeptId());

        //是否存在子部门
        String level = LevelUtil.calculateLevel(sysDeptDO.getSysDeptLevel(), sysDeptDO.getSysDeptCodeName());
        List<SysDeptDO> deptList = sysDeptDAO.getChildDeptListByLevel(level);

        // 不存在 返回当前查询出的用户信息
        if (CollectionUtils.isEmpty(deptList)) {
            DeptUser deptUser = new DeptUser();
            BeanUtils.copyProperties(userDO, deptUser);
            deptUsers.add(deptUser);
            return Result.wrapSuccessfulResult(deptUsers);
        }
        //存在 根据部门id查看员工列表
        List<SysUserDO> list = Lists.newArrayList();
        deptList.forEach(sysDeptDO1 -> {
            SysUserDO userDO1 = new SysUserDO();
            userDO1.setDeptId(sysDeptDO1.getId());
            list.add(userDO1);
        });
        List<SysUserDO> sysUserDOS = sysUserDAO.getUserListByDeptIds(list);
        sysUserDOS.forEach(sysUserDO -> {
            DeptUser deptUser = new DeptUser();
            BeanUtils.copyProperties(sysUserDO, deptUser);
            deptUsers.add(deptUser);
        });
        //查询自己
        DeptUser deptUser = new DeptUser();
        deptUser.setId(userDO.getId());
        deptUsers.add(deptUser);
        return Result.wrapSuccessfulResult(deptUsers);
    }

}
