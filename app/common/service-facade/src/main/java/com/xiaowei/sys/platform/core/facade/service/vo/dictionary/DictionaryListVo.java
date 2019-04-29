package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;

import java.io.Serializable;

public class DictionaryListVo implements Serializable {
    private String codeName;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * standardName 标准名称.
     */
    private String standardName;
    /**
     * standardUuid uuid.
     */
    private String standardUuid;
}
