package com.xiaowei.sys.platform.core.service.manager.sysrole.hasurlacl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysCoreService;
import com.yeecli.component.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by MOMO on 2018/10/8.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class HasUrlAclServiceImpl implements HasUrlAclService{
    @Autowired
    private SysAclDAO sysAclDAO;
    @Autowired
    private SysCoreService sysCoreService;
    @Value("${super.man}")
    private String superMan;

    @Override
    public Result<Boolean> hasUrlAcl(String url, Long userId, String userPhone) {
        if (isSuperAdmin(userPhone)) {
            return Result.wrapSuccessfulResult(true);
        }
        List<SysAclDO> aclList = sysAclDAO.getByUrl(url);
        if (CollectionUtils.isEmpty(aclList)) {
            return Result.wrapSuccessfulResult(false);
        }

        //TODO  带加入redis缓存
        List<SysAclVO> userAclList = sysCoreService.getCurrentUserAclList(userId, userPhone);
//        List<SysAcl> userAclList = getCurrentUserAclListFromCache();
        Set<Long> userAclIdSet = userAclList.stream().map(acl -> acl.getId()).collect(Collectors.toSet());

        boolean hasValidAcl = false;
        // 规则：只要有一个权限点有权限，那么我们就认为有访问权限
        for (SysAclDO acl : aclList) {
            // 判断一个用户是否具有某个权限点的访问权限
            if (acl == null) { // 权限点无效
                continue;
            }
            hasValidAcl = true;
            if (userAclIdSet.contains(acl.getId())) {
                return Result.wrapSuccessfulResult(true);
            }
        }
        if (!hasValidAcl) {
            return Result.wrapSuccessfulResult(true);
        }
        return Result.wrapSuccessfulResult(false);
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
