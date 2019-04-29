package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table Parameter
 */
public class Parameter  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id .
     */
    private long id;
    /**
     * parameterName .
     */
    private String parameterName;
    /**
     * parameterValue .
     */
    private long parameterValue;
    /**
     * serialNumber .
     */
    private long serialNumber;




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
    public void setParameterValue(long parameterValue){
        this.parameterValue = parameterValue;
    }

    /**
     * Get parameterValue .
     *
     * @return the string
     */
    public long getParameterValue(){
        return parameterValue;
    }

    /**
     * Set serialNumber .
     */
    public void setSerialNumber(long serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Get serialNumber .
     *
     * @return the string
     */
    public long getSerialNumber(){
        return serialNumber;
    }



}
