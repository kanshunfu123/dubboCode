package com.xiaowei.sys.platform.core.facade.service.enums;

/**
 * @author: jxl
 * @create: 2018-03-08 09:51
 **/
public enum StandardFetchEnum {

    /**
     * 否
     */
    NO("0"),
    /**
     * 是
     */
    YES("1");

    private String isFetch;

    StandardFetchEnum(String isFetch) {
        this.isFetch = isFetch;
    }

    public String getIsFetch() {
        return isFetch;
    }
}

