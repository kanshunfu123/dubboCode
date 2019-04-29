package com.xiaowei.sys.platform.core.service.manager.dictionary;

import com.xiaowei.sys.platform.core.facade.service.req.dictionary.*;


import com.xiaowei.sys.platform.core.facade.service.vo.dictionary.*;
import com.yeecli.component.common.model.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by kanshunfu on 2018/9/11
 */
public interface DictionaryService {
    /**
     * 新增数据字典
     */
    public Result<Object> saveDictionary(DictionaryAddReq dictionaryAddReq);

    /**
     * 字典树形图
     */
    public Result<List<DictionaryTreeVo>> dictionaryTreeList();


    /**
     * 编辑字典
     */
    public Result<Object> updateDictionary(DictionaryReq dictionaryReq);

    /**
     * 删除字典
     *
     * @param dictionaryReq
     * @return
     */
    public Result<Object> delDictionary(DictionaryReq dictionaryReq);

    /**
     * 根据uuid查看字典架构
     *
     * @param uuid
     * @return
     */
    public Result<DictionaryVO> getDictionaryInfoByUuid(String uuid);

    /**
     * 根据代码值查询字典
     *
     * @param codeValue
     * @return
     */
    public Result<List<DictionaryVO>> getDictionaryInfoByCodeValue(String codeValue);


    /**
     * 根据parentId查询字典
     *
     * @param parentId
     * @return
     */
    public Result<List<WaterStandardVo>> getDictionaryInfoByParentId(String parentId);

    /**
     * 根据codeName模糊分页查询
     */
    public Result<DictionaryByCodeNamePingVo> dictionaryByCodeNamePaing(DictionaryByCodeNamePingReq dictionaryByCodeNamePingReq);

    /**
     * 根据code_value集合 分批查询孙子 数据字典
     *
     * @param codeValue
     * @return
     */
    public Result<Map<String, List<DictFatherVlueVO>>> getChildDictByCodevalue(List<String> codeValue);

    /**
     * 根据 codeValue 分页查询字典 以及字典所对应的属性
     *
     * @param dictAttrListReq
     * @return
     */
    public Result<DictAttrListPagingVO> dictAttrListPagingVO(DictAttrListReq dictAttrListReq);

    /**
     * 根据 ids 批量查询字典
     *
     * @param getDictByIdsReqs
     * @return
     */
    public Result<List<GetDictByIdsVO>> getDictByIds(List<GetDictByIdsReq> getDictByIdsReqs);

    /**
     * 根据 codeValue 查字典
     *
     * @param getDictByIdsReq
     * @return
     */
    public Result<GetDictByIdsVO> getLevelByParentId(GetDictByIdsReq getDictByIdsReq);

    /**
     * 根据id查询字典
     */
    public Result<GetDicByIdVO> getDictById(Long id);
}
