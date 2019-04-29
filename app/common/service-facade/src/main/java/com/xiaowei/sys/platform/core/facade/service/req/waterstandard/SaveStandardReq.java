package com.xiaowei.sys.platform.core.facade.service.req.waterstandard;

import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SaveStandardReq implements Serializable {
    /**
     * id ID.
     */
    private Long id;
    /**
     * standardTypeid 标准类型 ID关联scentype场景类型ID.
     */
    private String standardTypeid;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * standardName 标准名称.
     */
    private String standardName;
    /**
     * standardUuid uuid.
     */
    private String standardUuid;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    private List<DetailsReq> detailsReqList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStandardTypeid() {
        return standardTypeid;
    }

    public void setStandardTypeid(String standardTypeid) {
        this.standardTypeid = standardTypeid;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardUuid() {
        return standardUuid;
    }

    public void setStandardUuid(String standardUuid) {
        this.standardUuid = standardUuid;
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

    public List<DetailsReq> getDetailsReqList() {
        return detailsReqList;
    }

    public void setDetailsReqList(List<DetailsReq> detailsReqList) {
        this.detailsReqList = detailsReqList;
    }
}
