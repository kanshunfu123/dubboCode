package com.xiaowei.sys.platform.core.facade.service.req.standard;


import java.io.Serializable;

public class StandardInfo  implements Serializable {
    private String requestId;
    private Integer limit = 20;//每页显示记录数
    private Integer currPageNo = 1;//当前页 页码

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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
