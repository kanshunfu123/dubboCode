package com.xiaowei.sys.platform.core.common.dal.dataobject;

import java.util.Date;

/**
 * The table 水质标准类型
 */
public class SysStandardTypeDO{

    /**
     * id 主键自动递增.
     */
    private Long id;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * codeName 类型名称.
     */
    private String codeName;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * codeValue 代码值.
     */
    private String codeValue;
    /**
     * parentValue 父级codeValue（根据每一层级的codeVlaue作父子关联）.
     */
    private String parentValue;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 主键自动递增.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 主键自动递增.
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
     * Set codeName 类型名称.
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    /**
     * Get codeName 类型名称.
     *
     * @return the string
     */
    public String getCodeName(){
        return codeName;
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
     * Set codeValue 代码值.
     */
    public void setCodeValue(String codeValue){
        this.codeValue = codeValue;
    }

    /**
     * Get codeValue 代码值.
     *
     * @return the string
     */
    public String getCodeValue(){
        return codeValue;
    }

    /**
     * Set parentValue 父级codeValue（根据每一层级的codeVlaue作父子关联）.
     */
    public void setParentValue(String parentValue){
        this.parentValue = parentValue;
    }

    /**
     * Get parentValue 父级codeValue（根据每一层级的codeVlaue作父子关联）.
     *
     * @return the string
     */
    public String getParentValue(){
        return parentValue;
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
