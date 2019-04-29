package com.xiaowei.sys.platform.core.facade.service.req.parameter;

import java.io.Serializable;

public class ParameterPageList implements Serializable {
    private String parameterName;
    private String parameterValue;
    private Integer serialNumber;
    private Integer limit = 20;//每页显示记录数
    private Integer currPageNo = 1;//当前页 页码

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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }


}
