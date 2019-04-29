package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DictionaryTreeResult;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByUuid;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByCodeValue;
import com.xiaowei.sys.platform.core.common.dal.paging.AllDictionaryListPagePage;
import com.xiaowei.sys.platform.core.common.dal.paging.GetChildDictByCodevaluePage;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysDictionaryDataDOMapper;

/**
* The Table SYS_DICTIONARY_DATA.
* SYS_DICTIONARY_DATA
*/
@Repository
public class SysDictionaryDataDAO{

    @Autowired
    private SysDictionaryDataDOMapper sysDictionaryDataDOMapper;

    /**
     * desc:插入表:SYS_DICTIONARY_DATA.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SYS_DICTIONARY_DATA.<br/>
     * @param entity entity
     * @return int
     */
    public int update(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SYS_DICTIONARY_DATA.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysDictionaryDataDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_DICTIONARY_DATA.<br/>
     * @param id id
     * @return SysDictionaryDataDO
     */
    public SysDictionaryDataDO getById(Long id){
        return sysDictionaryDataDOMapper.getById(id);
    }
    /**
     * desc:更新表:sys_dictionary_data.<br/>
     * @param entity entity
     * @return SysDictionaryDataDO
     */
    public SysDictionaryDataDO saveDictionary(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.saveDictionary(entity);
    }
    /**
     * desc:同一层级下，代码名称是否相同.<br/>
     * @param codeName codeName
     * @param parentId parentId
     * @return int
     */
    public int getBycodeNameAndByparentId(String codeName,String parentId){
        return sysDictionaryDataDOMapper.getBycodeNameAndByparentId(codeName, parentId);
    }
    /**
     * desc:树形字典架构.<br/>
     * @return List<DictionaryTreeResult>
     */
    public List<DictionaryTreeResult> dictionaryTree(){
        return sysDictionaryDataDOMapper.dictionaryTree();
    }
    /**
     * desc:根据UUID获取数据:sys_dictionary_data.<br/>
     * @param uuid uuid
     * @return SysDictionaryDataDO
     */
    public SysDictionaryDataDO getByUuid(String uuid){
        return sysDictionaryDataDOMapper.getByUuid(uuid);
    }
    /**
     * desc:查询子级字典.<br/>
     * @param level level
     * @return List<SysDictionaryDataDO>
     */
    public List<SysDictionaryDataDO> getChildDictionaryListByLevel(String level){
        return sysDictionaryDataDOMapper.getChildDictionaryListByLevel(level);
    }
    /**
     * desc:跟新字典信息.<br/>
     * @param entity entity
     * @return int
     */
    public int updateDictionary(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.updateDictionary(entity);
    }
    /**
     * desc:字典更新之后，进行批量子级字典.<br/>
     * @param list list
     * @return int
     */
    public int updatebatchUpdateLevel(List<SysDictionaryDataDO> list){
        return sysDictionaryDataDOMapper.updatebatchUpdateLevel(list);
    }
    /**
     * desc:根据uuid查看字典信息.<br/>
     * @param uuid uuid
     * @return GetDictionaryInfoByUuid
     */
    public GetDictionaryInfoByUuid getDictionaryInfoByUuid(String uuid){
        return sysDictionaryDataDOMapper.getDictionaryInfoByUuid(uuid);
    }
    /**
     * desc:根据codeValue查看字典信息.<br/>
     * @param codeValue codeValue
     * @return GetDictionaryInfoByCodeValue
     */
    public GetDictionaryInfoByCodeValue getDictionaryInfoByCodeValue(String codeValue){
        return sysDictionaryDataDOMapper.getDictionaryInfoByCodeValue(codeValue);
    }
    /**
     * desc:根据parentId查询.<br/>
     * @param parentId parentId
     * @return List<SysDictionaryDataDO>
     */
    public List<SysDictionaryDataDO> getDictionaryInfoByParentId(String parentId){
        return sysDictionaryDataDOMapper.getDictionaryInfoByParentId(parentId);
    }
    /**
     * desc:根据 字典字段值值 全局唯一.<br/>
     * @param entity entity
     * @return Integer
     */
    public Integer getDictionaryCodeValue(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.getDictionaryCodeValue(entity);
    }
    /**
     * desc:根据id列表查询.<br/>
     * @param list list
     * @return List<SysDictionaryDataDO>
     */
    public List<SysDictionaryDataDO> getDictByIds(List<SysDictionaryDataDO> list){
        return sysDictionaryDataDOMapper.getDictByIds(list);
    }
    /**
     * desc:根据 父级id 获取数据:SYS_DICTIONARY.<br/>
     * @param codeValue codeValue
     * @return SysDictionaryDataDO
     */
    public SysDictionaryDataDO getLevelByParentId(String codeValue){
        return sysDictionaryDataDOMapper.getLevelByParentId(codeValue);
    }
    /**
     * desc:模糊分页查询字典列表.<br/>
     * @param allDictionaryListPage allDictionaryListPage
     * @return AllDictionaryListPagePage
     */
    public AllDictionaryListPagePage allDictionaryListPage(AllDictionaryListPagePage allDictionaryListPage){
        int total = sysDictionaryDataDOMapper.allDictionaryListPageCount(allDictionaryListPage);
        if(total>0){
            allDictionaryListPage.setDatas(sysDictionaryDataDOMapper.allDictionaryListPageResult(allDictionaryListPage));
        }
        allDictionaryListPage.setTotal(total);
        return allDictionaryListPage;
    }
    /**
     * desc:根据code_value集合 分批查询孙子 数据字典.<br/>
     * @param entity entity
     * @return List<SysDictionaryDataDO>
     */
    public List<SysDictionaryDataDO> getChildDictByCodevalue(SysDictionaryDataDO entity){
        return sysDictionaryDataDOMapper.getChildDictByCodevalue(entity);
    }
    /**
     * desc:根据code_value集合 分批查询孙子 数据字典.<br/>
     * @param getChildDictByCodevalue getChildDictByCodevalue
     * @return GetChildDictByCodevaluePage
     */
    public GetChildDictByCodevaluePage getChildDictByCodevaluePaging(GetChildDictByCodevaluePage getChildDictByCodevalue){
        int total = sysDictionaryDataDOMapper.getChildDictByCodevaluePagingCount(getChildDictByCodevalue);
        if(total>0){
            getChildDictByCodevalue.setDatas(sysDictionaryDataDOMapper.getChildDictByCodevaluePagingResult(getChildDictByCodevalue));
        }
        getChildDictByCodevalue.setTotal(total);
        return getChildDictByCodevalue;
    }
    /**
     * desc:通过id查询字典.<br/>
     * @param id id
     * @return SysDictionaryDataDO
     */
    public SysDictionaryDataDO getDictById(Long id){
        return sysDictionaryDataDOMapper.getDictById(id);
    }
}
