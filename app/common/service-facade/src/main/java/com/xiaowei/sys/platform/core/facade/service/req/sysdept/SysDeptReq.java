package com.xiaowei.sys.platform.core.facade.service.req.sysdept;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MOMO on 2018/9/11.
 */
public class SysDeptReq extends BaseReq implements Serializable{
    /**
     * id 部门id.
     */
    private Long id;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    private String fatherUuid;//父级id
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * sysDeptName 部门名称.
     */
    private String sysDeptName;
    /**
     * sysDeptCodeName 部门参数值.
     */
    private Long sysDeptCodeName;
    /**
     * sysDeptUuid 唯一，32位字符串，查询用.
     */
    private String sysDeptUuid;
    /**
     * sysDeptLevel 部门层级.
     */
    private String sysDeptLevel;
    /**
     * sysDeptRemark 备注.
     */
    private String sysDeptRemark;
    /**
     * sysDeptSeq 部门在当前层级下的顺序，由小到大.
     */
    private Integer sysDeptSeq;
    /**
     * sysDeptParentId 上级部门id.
     */
    private Long sysDeptParentId;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 部门id.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 部门id.
     *
     * @return the string
     */
    public Long getId(){
        return id;
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
     * Set sysDeptName 部门名称.
     */
    public void setSysDeptName(String sysDeptName){
        this.sysDeptName = sysDeptName;
    }

    /**
     * Get sysDeptName 部门名称.
     *
     * @return the string
     */
    public String getSysDeptName(){
        return sysDeptName;
    }

    /**
     * Set sysDeptUuid 唯一，32位字符串，查询用.
     */
    public void setSysDeptUuid(String sysDeptUuid){
        this.sysDeptUuid = sysDeptUuid;
    }

    /**
     * Get sysDeptUuid 唯一，32位字符串，查询用.
     *
     * @return the string
     */
    public String getSysDeptUuid(){
        return sysDeptUuid;
    }

    /**
     * Set sysDeptLevel 部门层级.
     */
    public void setSysDeptLevel(String sysDeptLevel){
        this.sysDeptLevel = sysDeptLevel;
    }

    /**
     * Get sysDeptLevel 部门层级.
     *
     * @return the string
     */
    public String getSysDeptLevel(){
        return sysDeptLevel;
    }

    /**
     * Set sysDeptRemark 备注.
     */
    public void setSysDeptRemark(String sysDeptRemark){
        this.sysDeptRemark = sysDeptRemark;
    }

    /**
     * Get sysDeptRemark 备注.
     *
     * @return the string
     */
    public String getSysDeptRemark(){
        return sysDeptRemark;
    }

    /**
     * Set sysDeptSeq 部门在当前层级下的顺序，由小到大.
     */
    public void setSysDeptSeq(Integer sysDeptSeq){
        this.sysDeptSeq = sysDeptSeq;
    }

    /**
     * Get sysDeptSeq 部门在当前层级下的顺序，由小到大.
     *
     * @return the string
     */
    public Integer getSysDeptSeq(){
        return sysDeptSeq;
    }

    public Long getSysDeptParentId() {
        return sysDeptParentId;
    }

    public void setSysDeptParentId(Long sysDeptParentId) {
        this.sysDeptParentId = sysDeptParentId;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Long getSysDeptCodeName() {
        return sysDeptCodeName;
    }

    public void setSysDeptCodeName(Long sysDeptCodeName) {
        this.sysDeptCodeName = sysDeptCodeName;
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

    public String getFatherUuid() {
        return fatherUuid;
    }

    public void setFatherUuid(String fatherUuid) {
        this.fatherUuid = fatherUuid;
    }
}
