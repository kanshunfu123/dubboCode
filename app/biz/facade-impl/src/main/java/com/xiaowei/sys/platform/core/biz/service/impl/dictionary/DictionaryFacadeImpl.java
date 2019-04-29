package com.xiaowei.sys.platform.core.biz.service.impl.dictionary;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.dictionary.DictionaryFacade;
import com.xiaowei.sys.platform.core.facade.service.req.dictionary.*;
import com.xiaowei.sys.platform.core.facade.service.vo.dictionary.*;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.dictionary.DictionaryService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by kanshunfu on2018/9/11
 */
@Service(version = "1.0.0")
public class DictionaryFacadeImpl implements DictionaryFacade {
    @Autowired
    private DictionaryService dictionaryService;
    private final static Logger logger = Logger.getLogger(DictionaryFacadeImpl.class);


    @Override
    public Result<Object> saveDictionary(DictionaryAddReq dictionaryAddReq) {
        try {
            return dictionaryService.saveDictionary(dictionaryAddReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_DICTIONARY_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_DICTIONARY_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<List<DictionaryTreeVo>> dictionaryTreeList() {
        try {
            return dictionaryService.dictionaryTreeList();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);


            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<Object> updateDictionary(DictionaryReq dictionaryReq) {
        try {
            return dictionaryService.updateDictionary(dictionaryReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_DICTIONARY_FAIL.getErrorCode(), ErrorEnum.ERROR_EDIT_DICTIONARY_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<Object> delDictionary(DictionaryReq dictionaryReq) {
        try {
            return dictionaryService.delDictionary(dictionaryReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DELL_DICTIONARY_FAIL.getErrorCode(), ErrorEnum.ERROR_DELL_DICTIONARY_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<DictionaryVO> getDictionaryInfoByUuid(String uuid) {
        try {
            return dictionaryService.getDictionaryInfoByUuid(uuid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<DictionaryVO>> getDictionaryInfoByCodeValue(String codeValue) {
        try {
            Result<List<DictionaryVO>> result=dictionaryService.getDictionaryInfoByCodeValue(codeValue);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_FIND_DICTIONARY_FAIL.getErrorCode(), ErrorEnum.ERROR_FIND_DICTIONARY_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<WaterStandardVo>> getDictionaryInfoByParentId(String parentId) {
        try {
            return dictionaryService.getDictionaryInfoByParentId(parentId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_FIND_DICTIONARY_FAIL.getErrorCode(), ErrorEnum.ERROR_FIND_DICTIONARY_FAIL.getErrorMessage());
        }
    }

//<<<<<<<<< Temporary merge branch 1
////    @Override
////    public Result<DictionaryByCodeNamePingVo> dictionaryByCodeNamePaing(DictionaryByCodeNamePingReq dictionaryByCodeNamePingReq) {
////        try {
////        return dictionaryService.dictionaryByCodeNamePaing(dictionaryByCodeNamePingReq);
////        }catch (Exception e){
////            logger.error(e.getMessage(),e);
////            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_PAGE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_PAGE_FAIL.getErrorMessage());
////
////        }
////
////    }
//=========
    @Override
    public Result<DictionaryByCodeNamePingVo> dictionaryByCodeNamePaing(DictionaryByCodeNamePingReq dictionaryByCodeNamePingReq) {
        try {
        return dictionaryService.dictionaryByCodeNamePaing(dictionaryByCodeNamePingReq);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_PAGE_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_PAGE_FAIL.getErrorMessage());

        }

    }

    @Override
    public Result<Map<String, List<DictFatherVlueVO>>> getChildDictByCodevalue(List<String> codeValue) {
        try {
            return dictionaryService.getChildDictByCodevalue(codeValue);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_CHILD_DICT_ERROR.getErrorCode(), ErrorEnum.ERROR_CHILD_DICT_ERROR.getErrorMessage());
        }
    }

    @Override
    public Result<DictAttrListPagingVO> dictAttrListPagingVO(DictAttrListReq dictAttrListReq) {
        try {
            return dictionaryService.dictAttrListPagingVO(dictAttrListReq);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICT_ATTR_ERROR.getErrorCode(), ErrorEnum.ERROR_DICT_ATTR_ERROR.getErrorMessage());
        }
    }

    @Override
    public Result<List<GetDictByIdsVO>> getDictByIds(List<GetDictByIdsReq> getDictByIdsReqs) {
        try {
            return dictionaryService.getDictByIds(getDictByIdsReqs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICT_ATTR_IDS_ERROR.getErrorCode(), ErrorEnum.ERROR_DICT_ATTR_IDS_ERROR.getErrorMessage());
        }
    }

    @Override
    public Result<GetDictByIdsVO> getLevelByParentId(GetDictByIdsReq getDictByIdsReq) {
        try {
            return dictionaryService.getLevelByParentId(getDictByIdsReq);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICT_ATTR_CODE_VALUE_ERROR.getErrorCode(), ErrorEnum.ERROR_DICT_ATTR_CODE_VALUE_ERROR.getErrorMessage());
        }
    }

    @Override
    public Result<GetDicByIdVO> getDictById(Long id) {
        try{
            return dictionaryService.getDictById(id);
        }
        catch (Exception e)
        {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DICTIONARY_INFO_BY_ID_FAIL.getErrorCode(), ErrorEnum.ERROR_DICTIONARY_INFO_BY_ID_FAIL.getErrorMessage());
        }
    }
}

