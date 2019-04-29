package com.xiaowei.sys.platform.core.facade.service.vo.sysaclmodule;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MOMO on 2018/9/18.
 */
public class SysAclModuleVO implements Serializable{
    /**
     * id 权限模块id.
     */
    private Long id;
    /**
     * sysAclModuleParentId 上级权限模块id.
     */
    private Long sysAclModuleParentId;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * sysAclModuleCode 权限模块码.
     */
    private String sysAclModuleCode;
    /**
     * sysAclModuleIcon 图标class.
     */
    private String sysAclModuleIcon;
    /**
     * sysAclModuleName 权限模块名称.
     */
    private String sysAclModuleName;
    /**
     * sysAclModuleUuid 唯一，32位字符串，查询用.
     */
    private String sysAclModuleUuid;
    /**
     * sysAclModuleLevel 权限模块层级.
     */
    private String sysAclModuleLevel;
    /**
     * sysAclModuleRemark 备注.
     */
    private String sysAclModuleRemark;
    /**
     * sysAclModuleSeq 权限模块在当前层级下的顺序，由小到大.
     */
    private Integer sysAclModuleSeq;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysAclModuleParentId() {
        return sysAclModuleParentId;
    }

    public void setSysAclModuleParentId(Long sysAclModuleParentId) {
        this.sysAclModuleParentId = sysAclModuleParentId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getSysAclModuleCode() {
        return sysAclModuleCode;
    }

    public void setSysAclModuleCode(String sysAclModuleCode) {
        this.sysAclModuleCode = sysAclModuleCode;
    }

    public String getSysAclModuleIcon() {
        return sysAclModuleIcon;
    }

    public void setSysAclModuleIcon(String sysAclModuleIcon) {
        this.sysAclModuleIcon = sysAclModuleIcon;
    }

    public String getSysAclModuleName() {
        return sysAclModuleName;
    }

    public void setSysAclModuleName(String sysAclModuleName) {
        this.sysAclModuleName = sysAclModuleName;
    }

    public String getSysAclModuleUuid() {
        return sysAclModuleUuid;
    }

    public void setSysAclModuleUuid(String sysAclModuleUuid) {
        this.sysAclModuleUuid = sysAclModuleUuid;
    }

    public String getSysAclModuleLevel() {
        return sysAclModuleLevel;
    }

    public void setSysAclModuleLevel(String sysAclModuleLevel) {
        this.sysAclModuleLevel = sysAclModuleLevel;
    }

    public String getSysAclModuleRemark() {
        return sysAclModuleRemark;
    }

    public void setSysAclModuleRemark(String sysAclModuleRemark) {
        this.sysAclModuleRemark = sysAclModuleRemark;
    }

    public Integer getSysAclModuleSeq() {
        return sysAclModuleSeq;
    }

    public void setSysAclModuleSeq(Integer sysAclModuleSeq) {
        this.sysAclModuleSeq = sysAclModuleSeq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
