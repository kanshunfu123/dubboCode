package com.xiaowei.sys.platform.core.facade.service.req.standard;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 入参详情
 *
 * @author 张宇斌
 */
public class StandardReqAdd extends BaseReq implements Serializable {


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
    private List<DetailsReq> detailsReq;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    public String getStandardTypeid() {
        return standardTypeid;
    }

    public void setStandardTypeid(String standardTypeid) {
        this.standardTypeid = standardTypeid;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set createBy 创建人.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy 创建人.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set updateBy 修改人.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy 修改人.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set standardName 标准名称.
     */
    public void setStandardName(String standardName){
        this.standardName = standardName;
    }

    /**
     * Get standardName 标准名称.
     *
     * @return the string
     */
    public String getStandardName(){
        return standardName;
    }

    /**
     * Set standardUuid uuid.
     */
    public void setStandardUuid(String standardUuid){
        this.standardUuid = standardUuid;
    }

    /**
     * Get standardUuid uuid.
     *
     * @return the string
     */
    public String getStandardUuid(){
        return standardUuid;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set updateTime 修改时间.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime 修改时间.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }

    public List<DetailsReq> getDetailsReq() {
        return detailsReq;
    }

    public void setDetailsReq(List<DetailsReq> detailsReq) {
        this.detailsReq = detailsReq;
    }
}
