package com.xiaowei.sys.platform.core.facade.service.vo.sysuser;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/13.
 */
public class UserDeptAreaRolesPageVO extends BasePage<SysUserPagingVO>  implements Serializable {

    /**
     * sysDeptName .
     */
    private String sysDeptName;//部门名称
    /**
     * sysUserName 姓名.
     */
    private String sysUserName;//用户名称


    /**
     * Set sysDeptName .
     */
    public void setSysDeptName(String sysDeptName) {
        this.sysDeptName = sysDeptName;
    }

    /**
     * Get sysDeptName .
     *
     * @return the string
     */
    public String getSysDeptName() {
        return sysDeptName;
    }

    /**
     * Set sysUserName 姓名.
     */
    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    /**
     * Get sysUserName 姓名.
     *
     * @return the string
     */
    public String getSysUserName() {
        return sysUserName;
    }

}
