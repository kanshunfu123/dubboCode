package com.xiaowei.sys.platform.core.facade.service.req.sysrole;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.Date;

/**
 * The table 角色
 */
public class SysRoleReq extends BaseReq implements Serializable {

    /**
     * id 角色id.
     */
    private Long id;
    /**
     * remark 备注.
     */
    private String remark;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy update_by.
     */
    private String updateBy;
    /**
     * sysRoleName 角色名称.
     */
    private String sysRoleName;
    /**
     * sysRoleType 角色的类型，1：管理员角色，2：其他.
     */
    private String sysRoleType;
    /**
     * sysRoleUuid 唯一，32位字符串，查询用.
     */
    private String sysRoleUuid;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 角色id.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 角色id.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set remark 备注.
     */
    public void setRemark(String remark){
        this.remark = remark;
    }

    /**
     * Get remark 备注.
     *
     * @return the string
     */
    public String getRemark(){
        return remark;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set createBy 创建人.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy 创建人.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set updateBy update_by.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy update_by.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set sysRoleName 角色名称.
     */
    public void setSysRoleName(String sysRoleName){
        this.sysRoleName = sysRoleName;
    }

    /**
     * Get sysRoleName 角色名称.
     *
     * @return the string
     */
    public String getSysRoleName(){
        return sysRoleName;
    }

    /**
     * Set sysRoleType 角色的类型，1：管理员角色，2：其他.
     */
    public void setSysRoleType(String sysRoleType){
        this.sysRoleType = sysRoleType;
    }

    /**
     * Get sysRoleType 角色的类型，1：管理员角色，2：其他.
     *
     * @return the string
     */
    public String getSysRoleType(){
        return sysRoleType;
    }

    /**
     * Set sysRoleUuid 唯一，32位字符串，查询用.
     */
    public void setSysRoleUuid(String sysRoleUuid){
        this.sysRoleUuid = sysRoleUuid;
    }

    /**
     * Get sysRoleUuid 唯一，32位字符串，查询用.
     *
     * @return the string
     */
    public String getSysRoleUuid(){
        return sysRoleUuid;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set updateTime 修改时间.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime 修改时间.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
