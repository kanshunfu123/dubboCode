package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MOMO on 2018/10/16.
 */
public class DictAttrValueListVO implements Serializable{
    /**
     * id 参数id.
     */
    private Long id;
    /**
     * uuid 参数uuid.
     */
    private String uuid;

    /**
     * parameterName 参数名称.
     */
    private String parameterName;
    /**
     * fieldValue 字段值.
     */
    private Long fieldValue;
    /**
     * parameterValue 参数值.
     */
    private Long parameterValue;


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
    public void setFieldValue(Long fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * Get fieldValue 字段值.
     *
     * @return the string
     */
    public Long getFieldValue(){
        return fieldValue;
    }


    /**
     * Set parameterValue 参数值.
     */
    public void setParameterValue(Long parameterValue){
        this.parameterValue = parameterValue;
    }

    /**
     * Get parameterValue 参数值.
     *
     * @return the string
     */
    public Long getParameterValue(){
        return parameterValue;
    }

    /**
     * Set createTime 创建时间.
     */
}
