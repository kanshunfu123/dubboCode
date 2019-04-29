package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.userRoleSArea;

/**
 * The table SYS_USER 用户
 */
public class UserDeptAreaRolesPage extends BasePage<userRoleSArea>{

    /**
     * deDelFlag .
     */
    private String deDelFlag;
    /**
     * uDelFlag .
     */
    private String uDelFlag;
    /**
     * sysDeptName .
     */
    private String sysDeptName;
    /**
     * sysUserName 姓名.
     */
    private String sysUserName;
    /**
     * sysUserUuid 唯一，32位字符串，查询用.
     */
    private String sysUserUuid;

    /**
     * Set deDelFlag .
     */
    public void setDeDelFlag(String deDelFlag){
        this.deDelFlag = deDelFlag;
    }

    /**
     * Get deDelFlag .
     *
     * @return the string
     */
    public String getDeDelFlag(){
        return deDelFlag;
    }

    /**
     * Set uDelFlag .
     */
    public void setUDelFlag(String uDelFlag){
        this.uDelFlag = uDelFlag;
    }

    /**
     * Get uDelFlag .
     *
     * @return the string
     */
    public String getUDelFlag(){
        return uDelFlag;
    }

    /**
     * Set sysDeptName .
     */
    public void setSysDeptName(String sysDeptName){
        this.sysDeptName = sysDeptName;
    }

    /**
     * Get sysDeptName .
     *
     * @return the string
     */
    public String getSysDeptName(){
        return sysDeptName;
    }

    /**
     * Set sysUserName 姓名.
     */
    public void setSysUserName(String sysUserName){
        this.sysUserName = sysUserName;
    }

    /**
     * Get sysUserName 姓名.
     *
     * @return the string
     */
    public String getSysUserName(){
        return sysUserName;
    }

    /**
     * Set sysUserUuid 唯一，32位字符串，查询用.
     */
    public void setSysUserUuid(String sysUserUuid){
        this.sysUserUuid = sysUserUuid;
    }

    /**
     * Get sysUserUuid 唯一，32位字符串，查询用.
     *
     * @return the string
     */
    public String getSysUserUuid(){
        return sysUserUuid;
    }
}
