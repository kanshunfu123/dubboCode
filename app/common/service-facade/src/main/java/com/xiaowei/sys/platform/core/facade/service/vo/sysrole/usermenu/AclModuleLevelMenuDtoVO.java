package com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu;

import com.google.common.collect.Lists;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclModuleDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 李杰 on 2018/9/20.
 */
public class AclModuleLevelMenuDtoVO implements Serializable{
    private List<AclModuleLevelMenuDtoVO> aclModuleList = Lists.newArrayList();
    private List<AclMenuDtoVO> aclList = Lists.newArrayList();
    public static AclModuleLevelMenuDtoVO adapt(SysAclModuleDO aclModule) {
        AclModuleLevelMenuDtoVO dto = new AclModuleLevelMenuDtoVO();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }

    private Long id;

    private Long sysAclModuleParentId;


    private String sysAclModuleName;

    private String sysAclModuleUuid;

    private String sysAclModuleLevel;


    private Integer sysAclModuleSeq;

    public List<AclModuleLevelMenuDtoVO> getAclModuleList() {
        return aclModuleList;
    }

    public void setAclModuleList(List<AclModuleLevelMenuDtoVO> aclModuleList) {
        this.aclModuleList = aclModuleList;
    }

    public List<AclMenuDtoVO> getAclList() {
        return aclList;
    }

    public void setAclList(List<AclMenuDtoVO> aclList) {
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
