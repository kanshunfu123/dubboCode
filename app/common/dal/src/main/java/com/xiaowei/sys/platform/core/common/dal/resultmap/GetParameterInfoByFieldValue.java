package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table 参数详情
 */
public class GetParameterInfoByFieldValue  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id .
     */
    private long id;
    /**
     * fieldValue .
     */
    private String fieldValue;
    /**
     * delFlag .
     */
    private String delFlag;
    /**
     * uuid .
     */
    private String uuid;
    /**
     * serialNumber .
     */
    private Integer serialNumber;
    /**
     * parameterName .
     */
    private String parameterName;
    /**
     * parameterValue .
     */
    private String parameterValue;




    /**
     * Set id .
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * Get id .
     *
     * @return the string
     */
    public long getId(){
        return id;
    }

    /**
     * Set fieldValue .
     */
    public void setFieldValue(String fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * Get fieldValue .
     *
     * @return the string
     */
    public String getFieldValue(){
        return fieldValue;
    }

    /**
     * Set delFlag .
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag .
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set uuid .
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid .
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set serialNumber .
     */
    public void setSerialNumber(Integer serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Get serialNumber .
     *
     * @return the string
     */
    public Integer getSerialNumber(){
        return serialNumber;
    }

    /**
     * Set parameterName .
     */
    public void setParameterName(String parameterName){
        this.parameterName = parameterName;
    }

    /**
     * Get parameterName .
     *
     * @return the string
     */
    public String getParameterName(){
        return parameterName;
    }

    /**
     * Set parameterValue .
     */
    public void setParameterValue(String parameterValue){
        this.parameterValue = parameterValue;
    }

    /**
     * Get parameterValue .
     *
     * @return the string
     */
    public String getParameterValue(){
        return parameterValue;
    }



}
