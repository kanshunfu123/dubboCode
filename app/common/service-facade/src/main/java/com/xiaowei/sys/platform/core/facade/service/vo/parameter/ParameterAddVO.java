package com.xiaowei.sys.platform.core.facade.service.vo.parameter;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

public class ParameterAddVO extends BaseReq implements Serializable {
    /**
     * id 参数id.
     */
    private Long id;
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
    private String  parameterValue;
    /**
     * uuid
     */
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }


}
