package com.xiaowei.sys.platform.core.facade.service.req.parameter;

import java.io.Serializable;

/**
 * @author ZiBao
 * @date 2018/10/17
 */
public class ParameterByUuidReq implements Serializable {
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
