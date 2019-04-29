package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

import java.io.Serializable;

public class DictionaryByCodeNamePingVo extends BasePage<BaseDictionaryPage>implements Serializable {
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

    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * codeName 代码名称.
     */
    private String codeName;
}
