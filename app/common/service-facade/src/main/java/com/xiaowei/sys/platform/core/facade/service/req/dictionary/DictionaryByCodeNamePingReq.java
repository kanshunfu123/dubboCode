package com.xiaowei.sys.platform.core.facade.service.req.dictionary;

import java.io.Serializable;

public class DictionaryByCodeNamePingReq implements Serializable {
    private String codeName;
    private Integer limit=20;//每页显示记录数
    private Integer currPageNo=1;//当前页 页码

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
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
