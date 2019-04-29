package com.xiaowei.sys.platform.core.facade.service.req.sysrole;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AddSysRoleReq extends BaseReq implements Serializable {
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
    /**角色权限*/
    private List<String> aclList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public String getSysRoleType() {
        return sysRoleType;
    }

    public void setSysRoleType(String sysRoleType) {
        this.sysRoleType = sysRoleType;
    }

    public String getSysRoleUuid() {
        return sysRoleUuid;
    }

    public void setSysRoleUuid(String sysRoleUuid) {
        this.sysRoleUuid = sysRoleUuid;
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

    public List<String> getAclList() {
        return aclList;
    }

    public void setAclList(List<String> aclList) {
        this.aclList = aclList;
    }
}
