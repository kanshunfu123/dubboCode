package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table 参数详情
 */
public class GetParameterInfoByUuid  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id .
     */
    private Long id;
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
    private Integer parameterValue;




    /**
     * Set id .
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id .
     *
     * @return the string
     */
    public Long getId(){
        return id;
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
    public void setParameterValue(Integer parameterValue){
        this.parameterValue = parameterValue;
    }

    /**
     * Get parameterValue .
     *
     * @return the string
     */
    public Integer getParameterValue(){
        return parameterValue;
    }



}
