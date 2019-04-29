package com.xiaowei.sys.platform.core.facade.service.req.standard;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/29.
 */
public class StandByNamePagingReq implements Serializable{
    //水质标准名称
    private String standardName;
    private Integer limit=20;//每页显示记录数
    private Integer currPageNo=1;//当前页 页码

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
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
