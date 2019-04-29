package com.xiaowei.sys.platform.core.facade.service.vo.standard;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/29.
 */
public class StandardDetailsvo implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * detailsId standard外键关联.
     */
    private Long detailsId;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * maxParm 最大范围数.
     */
    private String maxParm;
    /**
     * minParm 最小范围数.
     */
    private String minParm;
    /**
     * detailName 项目.
     */
    private String detailName;
    /**
     * detailUuid 标准明细uuid.
     */
    private String detailUuid;

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

    /**
     * Set detailsId standard外键关联.
     */
    public void setDetailsId(Long detailsId){
        this.detailsId = detailsId;
    }

    /**
     * Get detailsId standard外键关联.
     *
     * @return the string
     */
    public Long getDetailsId(){
        return detailsId;
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
     * Set maxParm 最大范围数.
     */
    public void setMaxParm(String maxParm){
        this.maxParm = maxParm;
    }

    /**
     * Get maxParm 最大范围数.
     *
     * @return the string
     */
    public String getMaxParm(){
        return maxParm;
    }

    /**
     * Set minParm 最小范围数.
     */
    public void setMinParm(String minParm){
        this.minParm = minParm;
    }

    /**
     * Get minParm 最小范围数.
     *
     * @return the string
     */
    public String getMinParm(){
        return minParm;
    }

    /**
     * Set detailName 项目.
     */
    public void setDetailName(String detailName){
        this.detailName = detailName;
    }

    /**
     * Get detailName 项目.
     *
     * @return the string
     */
    public String getDetailName(){
        return detailName;
    }

    /**
     * Set detailUuid 标准明细uuid.
     */
    public void setDetailUuid(String detailUuid){
        this.detailUuid = detailUuid;
    }

    /**
     * Get detailUuid 标准明细uuid.
     *
     * @return the string
     */
    public String getDetailUuid(){
        return detailUuid;
    }
}
