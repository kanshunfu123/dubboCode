package com.xiaowei.sys.platform.core.facade.service.req.dictionary;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.Date;

public class DictionaryReq extends BaseReq implements Serializable {


    /**
     * 父级id
     */
    private String fatherUuid;
    /**
     * id 字典id.
     */
    private Long id;
    /**
     * uuid uuid.
     */
    private String uuid;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * codeName 代码名称.
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
     * codeLevel 层级.
     */
    private String codeLevel;
    /**
     * parentId 上级id.
     */
    private String parentId;
    /**
     * codeValue 代码值 关联sys_parameter_configuration表field_value.
     */
    private String codeValue;
    /**
     * serialNumber 排列序号.
     */
    private Integer serialNumber;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 字典id.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 字典id.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set uuid uuid.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid uuid.
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
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
     * Set codeName 代码名称.
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    /**
     * Get codeName 代码名称.
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
     * Set codeLevel 层级.
     */
    public void setCodeLevel(String codeLevel){
        this.codeLevel = codeLevel;
    }

    /**
     * Get codeLevel 层级.
     *
     * @return the string
     */
    public String getCodeLevel(){
        return codeLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * Set serialNumber 排列序号.
     */
    public void setSerialNumber(Integer serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Get serialNumber 排列序号.
     *
     * @return the string
     */
    public Integer getSerialNumber(){
        return serialNumber;
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
    public String getFatherUuid() {
        return fatherUuid;
    }

    public void setFatherUuid(String fatherUuid) {
        this.fatherUuid = fatherUuid;
    }
}
