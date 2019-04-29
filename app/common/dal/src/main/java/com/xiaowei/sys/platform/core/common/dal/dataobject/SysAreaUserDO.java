package com.xiaowei.sys.platform.core.common.dal.dataobject;

import java.util.Date;

/**
 * The table SYS_AREA_USER
 */
public class SysAreaUserDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * sysAreaId 区域id.
     */
    private Long sysAreaId;
    /**
     * sysUserId 用户id.
     */
    private Long sysUserId;
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
     * sysUserAreaUuid SYS_USER_AREA_UUID.
     */
    private String sysUserAreaUuid;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set sysAreaId 区域id.
     */
    public void setSysAreaId(Long sysAreaId){
        this.sysAreaId = sysAreaId;
    }

    /**
     * Get sysAreaId 区域id.
     *
     * @return the string
     */
    public Long getSysAreaId(){
        return sysAreaId;
    }

    /**
     * Set sysUserId 用户id.
     */
    public void setSysUserId(Long sysUserId){
        this.sysUserId = sysUserId;
    }

    /**
     * Get sysUserId 用户id.
     *
     * @return the string
     */
    public Long getSysUserId(){
        return sysUserId;
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
     * Set updateBy 修改人.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy 修改人.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set sysUserAreaUuid SYS_USER_AREA_UUID.
     */
    public void setSysUserAreaUuid(String sysUserAreaUuid){
        this.sysUserAreaUuid = sysUserAreaUuid;
    }

    /**
     * Get sysUserAreaUuid SYS_USER_AREA_UUID.
     *
     * @return the string
     */
    public String getSysUserAreaUuid(){
        return sysUserAreaUuid;
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
