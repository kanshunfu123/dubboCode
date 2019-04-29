package com.xiaowei.sys.platform.core.facade.service.req.dictionary;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

import java.io.Serializable;

/**
 * Created by kanshunfu on 2018/09/29
 */
public class DictionaryPageReq extends BasePage implements Serializable {
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * codeName
     */
    private String codeName;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


}
