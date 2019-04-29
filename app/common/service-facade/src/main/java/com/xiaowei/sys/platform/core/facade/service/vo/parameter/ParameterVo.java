package com.xiaowei.sys.platform.core.facade.service.vo.parameter;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.Date;

public class ParameterVo extends BaseReq implements Serializable {

    /**
     * id 参数id.
     */
    private Long id;
    /**
     * uuid 参数uuid.
     */
    private String uuid;
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
     * parameterName 参数名称.
     */
    private String parameterName;
    /**
     * fieldValue 字段值.
     */
    private String fieldValue;
    /**
     * serialNumber 排列序号.
     */
    private Integer serialNumber;
    /**
     * parameterValue 参数值.
     */
    private String parameterValue;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 参数id.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 参数id.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set uuid 参数uuid.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid 参数uuid.
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
     * Set parameterName 参数名称.
     */
    public void setParameterName(String parameterName){
        this.parameterName = parameterName;
    }

    /**
     * Get parameterName 参数名称.
     *
     * @return the string
     */
    public String getParameterName(){
        return parameterName;
    }

    /**
     * Set fieldValue 字段值.
     */
    public void setFieldValue(String fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * Get fieldValue 字段值.
     *
     * @return the string
     */
    public String getFieldValue(){
        return fieldValue;
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
     * Set parameterValue 参数值.
     */
    public void setParameterValue(String parameterValue){
        this.parameterValue = parameterValue;
    }

    /**
     * Get parameterValue 参数值.
     *
     * @return the string
     */
    public String getParameterValue(){
        return parameterValue;
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
