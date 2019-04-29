package com.xiaowei.sys.platform.core.facade.service.vo.standard;

import java.io.Serializable;
import java.util.Date;

public class StandardAddVO implements Serializable {
    /**
     * id ID.
     */
    private Long id;
    /**
     * standardDetailid 标准明细ID.
     */
    private Long standardDetailid;
    /**
     * standardName 标准名称.
     */
    private String standardName;
    /**
     * standardTypeid 标准类型 ID关联scentype场景类型ID.
     */
    private String standardTypeid;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStandardDetailid() {
        return standardDetailid;
    }

    public void setStandardDetailid(Long standardDetailid) {
        this.standardDetailid = standardDetailid;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardTypeid() {
        return standardTypeid;
    }

    public void setStandardTypeid(String standardTypeid) {
        this.standardTypeid = standardTypeid;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
