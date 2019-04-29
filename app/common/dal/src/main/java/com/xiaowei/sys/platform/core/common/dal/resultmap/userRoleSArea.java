package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table userRoleSArea
 */
public class userRoleSArea  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * uid .
     */
    private long uid;
    /**
     * sysUserName .
     */
    private String sysUserName;
    /**
     * sysUserUuid .
     */
    private String sysUserUuid;
    /**
     * deptId .
     */
    private long deptId;
    /**
     * areaId .
     */
    private long areaId;
    /**
     * sysUserPhone .
     */
    private String sysUserPhone;
    /**
     * sysUserEmail .
     */
    private String sysUserEmail;
    /**
     * sysDeptName .
     */
    private String sysDeptName;
    /**
     * sysDeptUuid .
     */
    private String sysDeptUuid;




    /**
     * Set uid .
     */
    public void setUid(long uid){
        this.uid = uid;
    }

    /**
     * Get uid .
     *
     * @return the string
     */
    public long getUid(){
        return uid;
    }

    /**
     * Set sysUserName .
     */
    public void setSysUserName(String sysUserName){
        this.sysUserName = sysUserName;
    }

    /**
     * Get sysUserName .
     *
     * @return the string
     */
    public String getSysUserName(){
        return sysUserName;
    }

    /**
     * Set sysUserUuid .
     */
    public void setSysUserUuid(String sysUserUuid){
        this.sysUserUuid = sysUserUuid;
    }

    /**
     * Get sysUserUuid .
     *
     * @return the string
     */
    public String getSysUserUuid(){
        return sysUserUuid;
    }

    /**
     * Set deptId .
     */
    public void setDeptId(long deptId){
        this.deptId = deptId;
    }

    /**
     * Get deptId .
     *
     * @return the string
     */
    public long getDeptId(){
        return deptId;
    }

    /**
     * Set areaId .
     */
    public void setAreaId(long areaId){
        this.areaId = areaId;
    }

    /**
     * Get areaId .
     *
     * @return the string
     */
    public long getAreaId(){
        return areaId;
    }

    /**
     * Set sysUserPhone .
     */
    public void setSysUserPhone(String sysUserPhone){
        this.sysUserPhone = sysUserPhone;
    }

    /**
     * Get sysUserPhone .
     *
     * @return the string
     */
    public String getSysUserPhone(){
        return sysUserPhone;
    }

    /**
     * Set sysUserEmail .
     */
    public void setSysUserEmail(String sysUserEmail){
        this.sysUserEmail = sysUserEmail;
    }

    /**
     * Get sysUserEmail .
     *
     * @return the string
     */
    public String getSysUserEmail(){
        return sysUserEmail;
    }

    /**
     * Set sysDeptName .
     */
    public void setSysDeptName(String sysDeptName){
        this.sysDeptName = sysDeptName;
    }

    /**
     * Get sysDeptName .
     *
     * @return the string
     */
    public String getSysDeptName(){
        return sysDeptName;
    }

    /**
     * Set sysDeptUuid .
     */
    public void setSysDeptUuid(String sysDeptUuid){
        this.sysDeptUuid = sysDeptUuid;
    }

    /**
     * Get sysDeptUuid .
     *
     * @return the string
     */
    public String getSysDeptUuid(){
        return sysDeptUuid;
    }



}
