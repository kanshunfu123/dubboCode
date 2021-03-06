package com.xiaowei.sys.platform.core.common.dal.dataobject;

import java.util.Date;

/**
 * The table SYS_STANDARD
 */
public class SysStandardDO{

    /**
     * id ID.
     */
    private Long id;
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
     * standardName 水质标准名称.
     */
    private String standardName;
    /**
     * standardUuid uuid.
     */
    private String standardUuid;
    /**
     * standardTypeid 标准类型 ID关联数据字典的codevlue.
     */
    private String standardTypeid;
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
     * Set standardName 水质标准名称.
     */
    public void setStandardName(String standardName){
        this.standardName = standardName;
    }

    /**
     * Get standardName 水质标准名称.
     *
     * @return the string
     */
    public String getStandardName(){
        return standardName;
    }

    /**
     * Set standardUuid uuid.
     */
    public void setStandardUuid(String standardUuid){
        this.standardUuid = standardUuid;
    }

    /**
     * Get standardUuid uuid.
     *
     * @return the string
     */
    public String getStandardUuid(){
        return standardUuid;
    }

    /**
     * Set standardTypeid 标准类型 ID关联数据字典的codevlue.
     */
    public void setStandardTypeid(String standardTypeid){
        this.standardTypeid = standardTypeid;
    }

    /**
     * Get standardTypeid 标准类型 ID关联数据字典的codevlue.
     *
     * @return the string
     */
    public String getStandardTypeid(){
        return standardTypeid;
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
