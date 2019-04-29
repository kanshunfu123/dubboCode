package com.xiaowei.sys.platform.core.service.manager.sysaclmodule;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAclModuleDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclModuleDO;
import com.xiaowei.sys.platform.core.facade.service.util.LevelUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by MOMO on 2018/9/18.
 */
@Service
public class SysAclModuleTreeServiceImpl implements SysAclModuleTreeService {
    @Autowired
    private SysAclModuleDAO sysAclModuleDAO;
    @Override
    public List<AclModuleLevelDtoVO> aclModuleTree(Integer sysAclModuleType) {
        SysAclModuleDO entity=new SysAclModuleDO();
        entity.setSysAclModuleType(sysAclModuleType);
        List<SysAclModuleDO> aclModuleList = sysAclModuleDAO.getAllAclModel(entity);
        List<AclModuleLevelDtoVO> dtoList = Lists.newArrayList();
        for (SysAclModuleDO aclModule : aclModuleList) {
            dtoList.add(AclModuleLevelDtoVO.adapt(aclModule));
        }
        return aclModuleListToTree(dtoList);
    }
    private List<AclModuleLevelDtoVO> aclModuleListToTree(List<AclModuleLevelDtoVO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, AclModuleLevelDtoVO> levelAclModuleMap = ArrayListMultimap.create();
        List<AclModuleLevelDtoVO> rootList = Lists.newArrayList();

        for (AclModuleLevelDtoVO dto : dtoList) {
            levelAclModuleMap.put(dto.getSysAclModuleLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getSysAclModuleLevel())) {
                rootList.add(dto);
            }
        }
        Collections.sort(rootList, aclModuleSeqComparator);
        transformAclModuleTree(rootList, LevelUtil.ROOT, levelAclModuleMap);
        return rootList;
    }
    private void transformAclModuleTree(List<AclModuleLevelDtoVO> dtoList, String level, Multimap<String, AclModuleLevelDtoVO> levelAclModuleMap) {
        for (int i = 0; i < dtoList.size(); i++) {
            AclModuleLevelDtoVO dto = dtoList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<AclModuleLevelDtoVO> tempList = (List<AclModuleLevelDtoVO>) levelAclModuleMap.get(nextLevel);
            if (!CollectionUtils.isEmpty(tempList)) {
                Collections.sort(tempList, aclModuleSeqComparator);
                dto.setAclModuleList(tempList);
                transformAclModuleTree(tempList, nextLevel, levelAclModuleMap);
            }
        }
    }
    private Comparator<AclModuleLevelDtoVO> aclModuleSeqComparator = new Comparator<AclModuleLevelDtoVO>() {
        @Override
        public int compare(AclModuleLevelDtoVO o1, AclModuleLevelDtoVO o2) {
            return o1.getSysAclModuleSeq() - o2.getSysAclModuleSeq();
        }
    };
}
