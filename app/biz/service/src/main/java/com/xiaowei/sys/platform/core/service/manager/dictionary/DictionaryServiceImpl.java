package com.xiaowei.sys.platform.core.service.manager.dictionary;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.xiaowei.sys.platform.core.common.dal.dao.SysDictionaryDataDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysParameterConfigurationDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysParameterConfigurationDO;
import com.xiaowei.sys.platform.core.common.dal.paging.GetChildDictByCodevaluePage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DictionaryTreeResult;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByCodeValue;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByUuid;
import com.xiaowei.sys.platform.core.facade.service.req.dictionary.*;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.LevelUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtils;
import com.xiaowei.sys.platform.core.facade.service.vo.dictionary.*;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.*;

/**
 * Created by kanshunfu on 2018/9/11
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class DictionaryServiceImpl implements DictionaryService {
    private final static Logger logger = Logger.getLogger(DictionaryServiceImpl.class);

    /**
     * 查看字典树
     *
     * @return
     */

    @Override
    public Result<List<DictionaryTreeVo>> dictionaryTreeList() {

        //递归树最终结果集
        //将deptList拷贝到dtoList
        List<DictionaryTreeVo> dictionaryTreeVo = new ArrayList<>(0);
        //得到所有字典
        List<DictionaryTreeResult> dicVos = dictionaryDataDAO.dictionaryTree();
        if (dicVos != null && dicVos.size() != 0) {
            dicVos.forEach(dicEntity -> {
                //去除被删除的字典
                if (dicEntity.getDelFlag().equals("0")) {
                    DictionaryTreeVo treeRes = new DictionaryTreeVo();
                    BeanUtils.copyProperties(dicEntity, treeRes);
                    dictionaryTreeVo.add(treeRes);
                }
            });
        }
//        List<DictionaryTreeVo> dtos = Lists.newArrayList();
//        DictionaryTreeVo dto = new DictionaryTreeVo();
//        dto.setLabel("字典架构");
//        dto.setParentId(0L);
//        dto.setChildren(dicMenuToTree(dictionaryTreeVo));
//        dtos.add(dto);
//        System.out.println(dto);
        return Result.wrapSuccessfulResult(dicMenuToTree(dictionaryTreeVo));

    }

    /**
     * 新增字典
     */

    @Autowired
    private SysDictionaryDataDAO dictionaryDataDAO;
    @Autowired
    private SysStandardDAO sysStandardDAO;
    @Autowired
    private SysParameterConfigurationDAO sysParameterConfigurationDAO;

    @Override
    public Result<Object> saveDictionary(DictionaryAddReq dictionaryAddReq) {

        SysDictionaryDataDO sysDictionaryDataDO = new SysDictionaryDataDO();

        BeanUtils.copyProperties(dictionaryAddReq, sysDictionaryDataDO);
        int count = dictionaryDataDAO.getDictionaryCodeValue(sysDictionaryDataDO);
        if (count > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_DICTIONARY_CODE_NAME_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_DICTIONARY_CODE_NAME_FAIL.getErrorMessage());

        }
        if (sysDictionaryDataDO.getParentId() == null) {
            sysDictionaryDataDO.setParentId("00");
        } else {
            SysDictionaryDataDO sysDictionaryDataDO1 = new SysDictionaryDataDO();
            sysDictionaryDataDO1.setCodeValue(sysDictionaryDataDO.getParentId());
            int count1 = dictionaryDataDAO.getDictionaryCodeValue(sysDictionaryDataDO1);
            if (count1 < 0) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
            }
        }

        if (checkExist(dictionaryAddReq.getCodeName(), dictionaryAddReq.getParentId())) {
            // System.out.println(dictionaryAddReq.getParentId() + "===" + dictionaryAddReq.getCodeName());
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_NAME_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_NAME_EXIST_FAIL.getErrorMessage());
        }
        //根据uuid计算  level层级
        String level = getLevel(sysDictionaryDataDO.getParentId());
        String newLevel = LevelUtil.calculateLevelString(level, sysDictionaryDataDO.getParentId());
        sysDictionaryDataDO.setCodeLevel(newLevel);
        sysDictionaryDataDO.setDelFlag("0");
        sysDictionaryDataDO.setCreateTime(DateUtil.getDateTime());
        sysDictionaryDataDO.setCreateBy(dictionaryAddReq.getUserName());
        sysDictionaryDataDO.setUpdateTime(DateUtil.getDateTime());
        sysDictionaryDataDO.setUpdateBy(dictionaryAddReq.getUserName());
        sysDictionaryDataDO.setUuid(StringUtils.genUUID());
        dictionaryDataDAO.saveDictionary(sysDictionaryDataDO);
        return Result.wrapSuccessfulResult("添加成功");


    }


    /**
     * 编辑字典
     *
     * @param dictionaryReq
     * @return
     */
    @Override
    public Result<Object> updateDictionary(DictionaryReq dictionaryReq) {


//        if (checkExist(dictionaryReq.getParentId(), dictionaryReq.getUuid(), dictionaryReq.getCodeName())) {
//            return Result.wrapErrorResult(2, "同一层级下存在相同名称的字典");
//        }
            SysDictionaryDataDO before = dictionaryDataDAO.getByUuid(dictionaryReq.getUuid());
            if (before == null) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_UPDATE_DICTIONARY_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_UPDATE_DICTIONARY_NO_EXIST_FAIL.getErrorMessage());
            }
            if (!before.getCodeValue().equals(dictionaryReq.getCodeValue())) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_CODE_NAME_NOT_MODIFY_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_CODE_NAME_NOT_MODIFY_FAIL.getErrorMessage());

            }
            SysDictionaryDataDO after = new SysDictionaryDataDO();
            BeanUtils.copyProperties(dictionaryReq, after);
            String level = null;
            SysDictionaryDataDO sysDictionaryDataDO = dictionaryDataDAO.getLevelByParentId(dictionaryReq.getParentId());
            String fatherId = "00";
            if (sysDictionaryDataDO != null) {
                level = sysDictionaryDataDO.getCodeLevel();
                fatherId = sysDictionaryDataDO.getCodeValue();
            }

            String newLevel = LevelUtil.calculateLevelString(level, fatherId);
            after.setCodeLevel(newLevel);
    //        after.setCreateBy("www");
    //        after.setUpdateTime(DateUtil.getDateTime());
    //        after.setCreateTime(DateUtil.getDateTime());
    //        after.setUpdateBy("zzz");
            //是否需要更新子级字典
            updateWithChild(before, after, fatherId);
            //  dictionaryDataDAO.updateDictionary(after);
            return Result.wrapSuccessfulResult("更新字典成功");
    }

    /**
     * 删除字典
     *
     * @param dictionaryReq
     * @return
     */
    @Override
    public Result<Object> delDictionary(DictionaryReq dictionaryReq) {
        SysDictionaryDataDO sysDictionaryDataDO = dictionaryDataDAO.getByUuid(dictionaryReq.getUuid());
        //TODO 需要确定  原： int count = sysStandardDAO.getStandard(sysDictionaryDataDO.getId());
        int count = sysStandardDAO.getStandard(sysDictionaryDataDO.getCodeValue());

        if (null == sysDictionaryDataDO) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DICTIONARY_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DICTIONARY_NO_EXIST_FAIL.getErrorMessage());
        } else {
            String filedValue=sysDictionaryDataDO.getCodeValue();
            SysParameterConfigurationDO sdo=new SysParameterConfigurationDO();
            sdo.setFieldValue(filedValue);
            int count2=sysParameterConfigurationDAO.getCountFieldValue(sdo);
            if(count2>0)
            {
                return Result.wrapErrorResult(ErrorEnum.ERROR_DICT_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_DICT_ACL_FAIL.getErrorMessage());
            }
            if (checkExist(null, sysDictionaryDataDO.getCodeValue())) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DICTIONARY_EXIST_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DICTIONARY_EXIST_USER_FAIL.getErrorMessage());
            }

            if (count > 0) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_DELETE_STANDARD_EXIT.getErrorCode(), ErrorEnum.ERROR_DELETE_STANDARD_EXIT.getErrorMessage());
            }
            SysDictionaryDataDO sysDictionaryDataDO1 = new SysDictionaryDataDO();
            sysDictionaryDataDO1.setUuid(dictionaryReq.getUuid());
            sysDictionaryDataDO1.setDelFlag("1");
            sysDictionaryDataDO1.setUpdateTime(DateUtil.getDateTime());
            sysDictionaryDataDO1.setUpdateBy(dictionaryReq.getUserName());
            dictionaryDataDAO.updateDictionary(sysDictionaryDataDO1);
            return Result.wrapSuccessfulResult("删除字典成功");
        }

    }

    @Override
    public Result<DictionaryVO> getDictionaryInfoByUuid(String uuid) {

        GetDictionaryInfoByUuid getDictionaryInfoByUuid = dictionaryDataDAO.getDictionaryInfoByUuid(uuid);
        if (null == getDictionaryInfoByUuid) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorMessage());
        }
        DictionaryVO dictionaryVO = new DictionaryVO();
        BeanUtils.copyProperties(getDictionaryInfoByUuid, dictionaryVO);
        return Result.wrapSuccessfulResult(dictionaryVO);
    }

    @Override
    public Result<List<DictionaryVO>>  getDictionaryInfoByCodeValue(String codeValue) {

        GetDictionaryInfoByCodeValue getDictionaryInfoByCodeName = dictionaryDataDAO.getDictionaryInfoByCodeValue(codeValue);
        if (null == getDictionaryInfoByCodeName) {
            //TODO 信息提示有问题
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorMessage());
        } else {
            List<DictionaryVO> dictionaryVOList = Lists.newArrayList();
            String parentId = getDictionaryInfoByCodeName.getCodeValue();
            List<SysDictionaryDataDO> sysDictionaryDataDOList = dictionaryDataDAO.getDictionaryInfoByParentId(parentId);
            for (int i = 0; i < sysDictionaryDataDOList.size(); i++) {
                DictionaryVO dictionaryVO = new DictionaryVO();
                BeanUtils.copyProperties(sysDictionaryDataDOList.get(i), dictionaryVO);
                dictionaryVOList.add(dictionaryVO);
            }
            return Result.wrapSuccessfulResult(dictionaryVOList);
        }
    }

    public List<DictionaryTreeVo> dicMenuToTree(List<DictionaryTreeVo> resList) {
        //集合为空直接返回
        if (CollectionUtils.isEmpty(resList)) {
            return Lists.newArrayList();
        }
        //可以放相同的key，比普通的map高级
        //把当前的tree以level为key 相同level的字典作为value，放到map里
        // level->[dictionary1,dictionary2,....]
        Multimap<String, DictionaryTreeVo> levelDeptMap = ArrayListMultimap.create();
        //用来保存第一层级的树,同时也是最终的字典树
        List<DictionaryTreeVo> rootList = Lists.newArrayList();
        for (DictionaryTreeVo treeRes : resList) {
            levelDeptMap.put(treeRes.getCodeLevel(), treeRes);
            if (LevelUtil.ROOT.equals(treeRes.getCodeLevel())) {
                rootList.add(treeRes);
            }
        }
        //按照 serial_number 从小到大 对字典树进行排序
        Collections.sort(rootList, new Comparator<DictionaryTreeVo>() {
            @Override
            public int compare(DictionaryTreeVo o1, DictionaryTreeVo o2) {
                return o1.getSerialNumber() - o2.getSerialNumber();
            }
        });
        //递归生成树
        transformDeptTree(rootList, LevelUtil.ROOT, levelDeptMap);
        return rootList;
    }

    private void transformDeptTree(List<DictionaryTreeVo> dicLevelList, String level, Multimap<String, DictionaryTreeVo> levelDeptMap) {
        int size = dicLevelList.size();
        for (int i = 0; i < size; i++) {
            //遍历该层的每个元素
            DictionaryTreeVo dicMenuDto = dicLevelList.get(i);
            //处理当前层级的数据
            String nexeLevel = LevelUtil.calculateLevelString(level, dicMenuDto.getCodeValue());
            //处理下一层
            List<DictionaryTreeVo> tempDeptList = (List<DictionaryTreeVo>) levelDeptMap.get(nexeLevel);
            if (!CollectionUtils.isEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList, dicSerialNumberComparator);
                //设置下一层字典
                dicMenuDto.setChildren(tempDeptList);
                //进入到下一层处理
                transformDeptTree(tempDeptList, nexeLevel, levelDeptMap);
            }
        }
    }

    public Comparator<DictionaryTreeVo> dicSerialNumberComparator = new Comparator<DictionaryTreeVo>() {
        @Override
        public int compare(DictionaryTreeVo o1, DictionaryTreeVo o2) {
            return o1.getSerialNumber() - o2.getSerialNumber();
        }
    };

    private String getLevel(String parentId) {
        if (parentId == null) {
            return null;
        }
        SysDictionaryDataDO sysDictionaryDataDO = dictionaryDataDAO.getLevelByParentId(parentId);
        if (sysDictionaryDataDO == null) {
            return null;
        } else {
            return sysDictionaryDataDO.getCodeLevel();
        }
    }


    private boolean checkExist(String codeName, String parentId) {
        // System.out.println(dictionaryDataDAO.getBycodeNameAndByparentId(parentId, codeName));
        return dictionaryDataDAO.getBycodeNameAndByparentId(codeName, parentId) > 0;
    }

    private void updateWithChild(SysDictionaryDataDO before, SysDictionaryDataDO after, String fatherId) {
        //更新过后的字典level
        String newLevelPrefix = after.getCodeLevel();
        //更新之前的字典level
        String oldLevelPrefix = before.getCodeLevel();
        String newLevel = LevelUtil.calculateLevelString(oldLevelPrefix, before.getCodeValue());
        if (!newLevelPrefix.equals(oldLevelPrefix)) {
            List<SysDictionaryDataDO> dicList = dictionaryDataDAO.getChildDictionaryListByLevel(newLevel);
            if (!CollectionUtils.isEmpty(dicList)) {
                for (SysDictionaryDataDO dict : dicList) {
                    String level = dict.getCodeLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dict.setCodeLevel(level);
                        dict.setParentId(fatherId);
                        //TODO
                        dict.setCreateTime(new Date());
                        dict.setCreateBy("sys");
                        dict.setUpdateTime(new Date());
                        dict.setUpdateBy("sys");
                    }
                }
                dictionaryDataDAO.updatebatchUpdateLevel(dicList);
            }
        }
        dictionaryDataDAO.updateDictionary(after);
    }

    @Override
    public Result<List<WaterStandardVo>> getDictionaryInfoByParentId(String parentId) {
        List<WaterStandardVo> waterStandardVoList = new ArrayList<WaterStandardVo>();
        List<SysDictionaryDataDO> sysDictionaryDataDOList = dictionaryDataDAO.getDictionaryInfoByParentId(parentId);
        for (int i = 0; i < sysDictionaryDataDOList.size(); i++) {
            WaterStandardVo waterStandardVo = new WaterStandardVo();
            waterStandardVo.setDetailName(sysDictionaryDataDOList.get(i).getCodeName());
            waterStandardVoList.add(waterStandardVo);
        }
        return Result.wrapSuccessfulResult(waterStandardVoList);
    }

    @Override
    public Result<DictionaryByCodeNamePingVo> dictionaryByCodeNamePaing(DictionaryByCodeNamePingReq dictionaryByCodeNamePingReq) {
        return null;
    }

    @Override
    public Result<Map<String, List<DictFatherVlueVO>>> getChildDictByCodevalue(List<String> codeValue) {
        //最终数据结果
        Map<String, List<DictFatherVlueVO>> map = Maps.newHashMap();

        if (CollectionUtils.isEmpty(codeValue)) {
            return Result.wrapSuccessfulResult(map);
        }
        codeValue.forEach(s -> {
            //每个 codeValue 对应的字数据字典
            List<DictFatherVlueVO> dictFatherVlueVOS = Lists.newArrayList();
            SysDictionaryDataDO sysDictionaryDataDOa = dictionaryDataDAO.getByUuid(s);
            if (null == sysDictionaryDataDOa) {
                map.put(s, Lists.newArrayList());
            } else {
                SysDictionaryDataDO sysDictionaryDataDO = new SysDictionaryDataDO();
                sysDictionaryDataDO.setParentId(sysDictionaryDataDOa.getCodeValue());
                sysDictionaryDataDO.setDelFlag("0");
                List<SysDictionaryDataDO> sysDictionaryDataDOS = dictionaryDataDAO.getChildDictByCodevalue(sysDictionaryDataDO);
                if (CollectionUtils.isEmpty(sysDictionaryDataDOS)) {
                    map.put(s, Lists.newArrayList());
                } else {
                    sysDictionaryDataDOS.forEach(sysDictionaryDataDO1 -> {
                        DictFatherVlueVO dictFatherVlueVO = new DictFatherVlueVO();
                        BeanUtils.copyProperties(sysDictionaryDataDO1, dictFatherVlueVO);
                        dictFatherVlueVOS.add(dictFatherVlueVO);
                    });
                    map.put(s, dictFatherVlueVOS);
                }
            }

        });
        return Result.wrapSuccessfulResult(map);
    }

    @Override
    public Result<DictAttrListPagingVO> dictAttrListPagingVO(DictAttrListReq dictAttrListReq) {

        SysDictionaryDataDO sysDiction = dictionaryDataDAO.getByUuid(dictAttrListReq.getUuid());
        if (null == sysDiction) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICT_NOT_EXIST_ERROR.getErrorCode(), ErrorEnum.ERROR_DICT_NOT_EXIST_ERROR.getErrorMessage());
        }
        //最终对象
        DictAttrListPagingVO dictAttrListPagingVO = new DictAttrListPagingVO();
        //集合数据
        List<DictAttrListVO> dictAttrListVOS = Lists.newArrayList();

        //数据copy
        GetChildDictByCodevaluePage getChildDictByCodevalue = new GetChildDictByCodevaluePage();
        BeanUtils.copyProperties(dictAttrListReq, getChildDictByCodevalue);
        BeanUtils.copyProperties(dictAttrListReq, dictAttrListPagingVO);
        getChildDictByCodevalue.setDelFlag("0");
        getChildDictByCodevalue.setParentId(sysDiction.getCodeValue());

        //得到查询对象
        GetChildDictByCodevaluePage getChildDictByCodevaluePage = dictionaryDataDAO.getChildDictByCodevaluePaging(getChildDictByCodevalue);
        //得到分页 查询列表
        List<SysDictionaryDataDO> sysDictionaryDataDOS = getChildDictByCodevaluePage.getDatas();
        if (CollectionUtils.isEmpty(sysDictionaryDataDOS)) {
            return Result.wrapSuccessfulResult(dictAttrListPagingVO);
        }
        sysDictionaryDataDOS.forEach(sysDictionaryDataDO -> {
            DictAttrListVO dictAttrListVO = new DictAttrListVO();
            BeanUtils.copyProperties(sysDictionaryDataDO, dictAttrListVO);
            dictAttrListVOS.add(dictAttrListVO);
            //根据字典的 codeValue 查询属性
            SysParameterConfigurationDO entity = new SysParameterConfigurationDO();
            entity.setFieldValue(dictAttrListVO.getCodeValue());
            entity.setDelFlag("0");
            List<SysParameterConfigurationDO> sysParameterConfigurationDOS = sysParameterConfigurationDAO.getDictAttrValueList(entity);
            //属性值
            List<DictAttrValueListVO> attrValue = Lists.newArrayList();
            if (CollectionUtils.isEmpty(sysParameterConfigurationDOS)) {
                dictAttrListVO.setAttrValue(attrValue);
            } else {
                sysParameterConfigurationDOS.forEach(sysParameterConfigurationDO -> {
                    DictAttrValueListVO dictAttrValueListVO = new DictAttrValueListVO();
                    BeanUtils.copyProperties(sysParameterConfigurationDO, dictAttrValueListVO);
                    attrValue.add(dictAttrValueListVO);
                });
            }
            dictAttrListVO.setAttrValue(attrValue);
            dictAttrListPagingVO.setDatas(dictAttrListVOS);
        });
        dictAttrListPagingVO.setTotal(getChildDictByCodevaluePage.getTotal());
        return Result.wrapSuccessfulResult(dictAttrListPagingVO);
    }

    @Override
    public Result<List<GetDictByIdsVO>> getDictByIds(List<GetDictByIdsReq> getDictByIdsReqs) {
        //最终结果
        List<GetDictByIdsVO> getDictByIdsVOS = Lists.newArrayList();
        List<SysDictionaryDataDO> list = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(getDictByIdsReqs)) {
            getDictByIdsReqs.forEach(getDictByIdsReq -> {
                SysDictionaryDataDO sysDictionaryDataDO = new SysDictionaryDataDO();
                BeanUtils.copyProperties(getDictByIdsReq, sysDictionaryDataDO);
                list.add(sysDictionaryDataDO);
            });
            List<SysDictionaryDataDO> sysDictionaryDataDOS = dictionaryDataDAO.getDictByIds(list);
            if (!CollectionUtils.isEmpty(sysDictionaryDataDOS)) {
                sysDictionaryDataDOS.forEach(sysDictionaryDataDO -> {
                    GetDictByIdsVO getDictByIdsVO = new GetDictByIdsVO();
                    BeanUtils.copyProperties(sysDictionaryDataDO, getDictByIdsVO);
                    getDictByIdsVOS.add(getDictByIdsVO);
                });
            }
            return Result.wrapSuccessfulResult(getDictByIdsVOS);
        }
        return Result.wrapSuccessfulResult(getDictByIdsVOS);
    }

    @Override
    public Result<GetDictByIdsVO> getLevelByParentId(GetDictByIdsReq getDictByIdsReq) {
        GetDictByIdsVO getDictByIdsVO = new GetDictByIdsVO();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(getDictByIdsReq.getCodeValue())) {
            SysDictionaryDataDO sysDictionaryDataDO = dictionaryDataDAO.getLevelByParentId(getDictByIdsReq.getCodeValue());
            if (null != sysDictionaryDataDO) {
                BeanUtils.copyProperties(sysDictionaryDataDO, getDictByIdsVO);
                return Result.wrapSuccessfulResult(getDictByIdsVO);
            }
        }
        return Result.wrapSuccessfulResult(getDictByIdsVO);
    }

    @Override
    public Result<GetDicByIdVO> getDictById(Long id) {
        GetDicByIdVO getDicByIdVO = new GetDicByIdVO();
        SysDictionaryDataDO sysDictionaryDataDO = dictionaryDataDAO.getDictById(id);
        if (sysDictionaryDataDO != null) {
            BeanUtils.copyProperties(sysDictionaryDataDO, getDicByIdVO);
        }
        return Result.wrapSuccessfulResult(getDicByIdVO);
    }
}
