package com.xiaowei.sys.platform.core.facade.service.vo.sysuser;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MOMO on 2018/9/11.
 */
public class SysUserVO implements Serializable{
    private String nameTop;
    private String nameBottom;

    /**
     * isThird 是否是第三方 0自己公司，1第三方.
     */
    private Integer isThird;
    /**
     * id 主键.
     */
    private Long id;
    /**
     * areaid 关联区域id(省市区，有区关联区id，无区关联市id，无市，关联省).
     */
    private Long areaid;
    private String X_token;
    /**
     * deptid 关联部门id.
     */
    private Long deptid;
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
     * sysUserPwd 密码.
     */
    private String sysUserPwd;
    /**
     * sysUserName 姓名.
     */
    private String sysUserName;
    /**
     * sysUserUuid 唯一，32位字符串，查询用.
     */
    private String sysUserUuid;
    /**
     * sysUserEmail 邮箱.
     */
    private String sysUserEmail;
    /**
     * sysUserPhone 手机号.
     */
    private String sysUserPhone;
    /**
     * sysUserAuthSalt 撒盐.
     */
    private String sysUserAuthSalt;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 主键.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get id 主键.
     *
     * @return the string
     */
    public Long getId() {
        return id;
    }

    /**
     * Set areaid 关联区域id(省市区，有区关联区id，无区关联市id，无市，关联省).
     */
    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    /**
     * Get areaid 关联区域id(省市区，有区关联区id，无区关联市id，无市，关联省).
     *
     * @return the string
     */
    public Long getAreaid() {
        return areaid;
    }

    public String getX_token() {
        return X_token;
    }

    public void setX_token(String x_token) {
        X_token = x_token;
    }

    /**
     * Set deptid 关联部门id.
     */
    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    /**
     * Get deptid 关联部门id.
     *
     * @return the string
     */
    public Long getDeptid() {
        return deptid;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * Set createBy 创建人.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Get createBy 创建人.
     *
     * @return the string
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Set updateBy 修改人.
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getNameTop() {
        return nameTop;
    }

    public void setNameTop(String nameTop) {
        this.nameTop = nameTop;
    }

    public String getNameBottom() {
        return nameBottom;
    }

    public void setNameBottom(String nameBottom) {
        this.nameBottom = nameBottom;
    }

    /**
     * Get updateBy 修改人.
     *

     * @return the string
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * Set sysUserPwd 密码.
     */
    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    /**
     * Get sysUserPwd 密码.
     *
     * @return the string
     */
    public String getSysUserPwd() {
        return sysUserPwd;
    }

    /**
     * Set sysUserName 姓名.
     */
    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    /**
     * Get sysUserName 姓名.
     *
     * @return the string
     */
    public String getSysUserName() {
        return sysUserName;
    }

    /**
     * Set sysUserUuid 唯一，32位字符串，查询用.
     */
    public void setSysUserUuid(String sysUserUuid) {
        this.sysUserUuid = sysUserUuid;
    }

    /**
     * Get sysUserUuid 唯一，32位字符串，查询用.
     *
     * @return the string
     */
    public String getSysUserUuid() {
        return sysUserUuid;
    }

    /**
     * Set sysUserEmail 邮箱.
     */
    public void setSysUserEmail(String sysUserEmail) {
        this.sysUserEmail = sysUserEmail;
    }

    /**
     * Get sysUserEmail 邮箱.
     *
     * @return the string
     */
    public String getSysUserEmail() {
        return sysUserEmail;
    }

    /**
     * Set sysUserPhone 手机号.
     */
    public void setSysUserPhone(String sysUserPhone) {
        this.sysUserPhone = sysUserPhone;
    }

    /**
     * Get sysUserPhone 手机号.
     *
     * @return the string
     */
    public String getSysUserPhone() {
        return sysUserPhone;
    }

    /**
     * Set sysUserAuthSalt 撒盐.
     */
    public void setSysUserAuthSalt(String sysUserAuthSalt) {
        this.sysUserAuthSalt = sysUserAuthSalt;
    }

    /**
     * Get sysUserAuthSalt 撒盐.
     *
     * @return the string
     */
    public String getSysUserAuthSalt() {
        return sysUserAuthSalt;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Set updateTime 修改时间.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime 修改时间.
     *
     * @return the string
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getIsThird() {
        return isThird;
    }

    public void setIsThird(Integer isThird) {
        this.isThird = isThird;
    }
}
