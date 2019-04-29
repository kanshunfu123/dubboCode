package com.xiaowei.sys.platform.core.facade.service.req.parameter;

import java.io.Serializable;

/**
 * @author ZiBao
 * @date 2018/10/17
 */
public class ParameterByIdsReq implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
