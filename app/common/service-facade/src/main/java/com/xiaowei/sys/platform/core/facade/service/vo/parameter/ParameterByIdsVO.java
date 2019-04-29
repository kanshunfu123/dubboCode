package com.xiaowei.sys.platform.core.facade.service.vo.parameter;

import java.io.Serializable;

/**
 * @author ZiBao
 * @date 2018/10/17
 */
public class ParameterByIdsVO implements Serializable {
    /**
     * 参数uuid
     */
    private String uuid;
    /**
     * 参数名称
     */
    private String parameterName;
    /**
     * 参数值
     */
    private String parameterValue;
    /**
     * 数据字典字段值
     */
    private String fieldValue;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
