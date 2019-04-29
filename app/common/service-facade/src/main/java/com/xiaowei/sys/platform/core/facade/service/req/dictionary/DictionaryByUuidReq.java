package com.xiaowei.sys.platform.core.facade.service.req.dictionary;

import java.io.Serializable;

public class DictionaryByUuidReq implements Serializable {
    private  String uuid;
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
