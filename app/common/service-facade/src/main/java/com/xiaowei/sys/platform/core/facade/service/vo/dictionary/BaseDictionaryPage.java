package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;

import java.io.Serializable;

public class BaseDictionaryPage implements Serializable {
    /**
     * 代码名称
     */
    private String codeName;
    /**
     * uuid
     */
    private String uuid;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }


}
