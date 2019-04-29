package com.xiaowei.sys.platform.core.service.manager.sysrole.hasurlacl;

import com.yeecli.component.common.model.Result;

/**
 * Created by MOMO on 2018/10/8.
 */
public interface HasUrlAclService {
    /**
     * 判断用户是否有权限访问系统资源
     * @param url
     * @param userId
     * @param userPhone
     * @return
     */
    public Result<Boolean> hasUrlAcl(String url, Long userId, String userPhone);
}
