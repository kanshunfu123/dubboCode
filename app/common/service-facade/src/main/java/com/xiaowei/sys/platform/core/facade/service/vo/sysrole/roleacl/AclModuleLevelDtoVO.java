package com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl;

import com.google.common.collect.Lists;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclModuleDO;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
public class AclModuleLevelDtoVO implements Serializable{
    private List<AclModuleLevelDtoVO> aclModuleList = Lists.newArrayList();
    private List<AclDtoVO> aclList = Lists.newArrayList();
    public static AclModuleLevelDtoVO adapt(SysAclModuleDO aclModule) {
        AclModuleLevelDtoVO dto = new AclModuleLevelDtoVO();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }

    private Long id;

    private Long sysAclModuleParentId;


    private String sysAclModuleName;

    private String sysAclModuleUuid;

    private String sysAclModuleLevel;


    private Integer sysAclModuleSeq;
    private Integer sysAclModuleType;

    public Integer getSysAclModuleType() {
        return sysAclModuleType;
    }

    public void setSysAclModuleType(Integer sysAclModuleType) {
        this.sysAclModuleType = sysAclModuleType;
    }

    public List<AclModuleLevelDtoVO> getAclModuleList() {
        return aclModuleList;
    }

    public void setAclModuleList(List<AclModuleLevelDtoVO> aclModuleList) {
        this.aclModuleList = aclModuleList;
    }

    public List<AclDtoVO> getAclList() {
        return aclList;
    }

    public void setAclList(List<AclDtoVO> aclList) {
        this.aclList = aclList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysAclModuleParentId() {
        return sysAclModuleParentId;
    }

    public void setSysAclModuleParentId(Long sysAclModuleParentId) {
        this.sysAclModuleParentId = sysAclModuleParentId;
    }

    public String getSysAclModuleName() {
        return sysAclModuleName;
    }

    public void setSysAclModuleName(String sysAclModuleName) {
        this.sysAclModuleName = sysAclModuleName;
    }

    public String getSysAclModuleUuid() {
        return sysAclModuleUuid;
    }

    public void setSysAclModuleUuid(String sysAclModuleUuid) {
        this.sysAclModuleUuid = sysAclModuleUuid;
    }

    public String getSysAclModuleLevel() {
        return sysAclModuleLevel;
    }

    public void setSysAclModuleLevel(String sysAclModuleLevel) {
        this.sysAclModuleLevel = sysAclModuleLevel;
    }

    public Integer getSysAclModuleSeq() {
        return sysAclModuleSeq;
    }

    public void setSysAclModuleSeq(Integer sysAclModuleSeq) {
        this.sysAclModuleSeq = sysAclModuleSeq;
    }
}
