package com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by 李杰 on 2018/9/20.
 */
public class UserIsSuperMainInfoVO implements Serializable {
    private Long userId;

    private String userName;//用户姓名
    private String userPhone;//用户手机号
    private String userUuid;//用户uuid
    //菜单类型 1 系统管理 2资产管理
    private Integer sysAclModuleType;

    public Integer getSysAclModuleType() {
        return sysAclModuleType;
    }

    public void setSysAclModuleType(Integer sysAclModuleType) {
        this.sysAclModuleType = sysAclModuleType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
}
