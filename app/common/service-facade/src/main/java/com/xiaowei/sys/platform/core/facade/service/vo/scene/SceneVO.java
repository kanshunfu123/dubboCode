package com.xiaowei.sys.platform.core.facade.service.vo.scene;

import java.io.Serializable;
import java.util.Date;

public class SceneVO implements Serializable {
    /**
     * id 主键.
     */
    private Long id;
    /**
     * seName 场景类型名称.
     */
    private String seName;
    /**
     * secenUuid 场景类型uuid.
     */
    private String secenUuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName;
    }

    public String getSecenUuid() {
        return secenUuid;
    }

    public void setSecenUuid(String secenUuid) {
        this.secenUuid = secenUuid;
    }
}
