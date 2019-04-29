package com.xiaowei.sys.platform.core.service.manager.standard;

import com.google.common.collect.Lists;
import com.xiaowei.sys.platform.core.common.dal.dao.SysDictionaryDataDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDetailsDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardTypeDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDetailsDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardTypeDO;
import com.xiaowei.sys.platform.core.common.dal.paging.StandByNamePage;
import com.xiaowei.sys.platform.core.common.dal.paging.StandardListPage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByCodeValue;
import com.xiaowei.sys.platform.core.common.dal.resultmap.StandardResult;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import com.xiaowei.sys.platform.core.facade.service.req.dictionary.DictionaryReq;
import com.xiaowei.sys.platform.core.facade.service.req.standard.*;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtils;
import com.xiaowei.sys.platform.core.facade.service.vo.details.DetailsVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.*;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: qianjin
 * @CreateDate: 2018/6/8 17:10
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class StandardServiceImpl implements StandardService {
    private final static Logger logger = Logger.getLogger(StandardServiceImpl.class);
    @Autowired
    private SysStandardDAO sysStandardDAO;
    @Autowired
    private SysStandardDetailsDAO sysStandardDetailsDAO;
    @Autowired
    private SysStandardTypeDAO sysStandardTypeDAO;

    /**
     * 通过uuid查询标准表
     *
     * @param standardInfo
     * @return
     */
    @Override
    public Result<StandardEditVO> getstandardByUuid(StandardInfo standardInfo) {
        StandardEditVO standardEditVO = new StandardEditVO();
        SysStandardDO standardReqDo = sysStandardDAO.getstandardByUuid(standardInfo.getRequestId());
        if (standardReqDo != null) {
            standardEditVO.setId(standardReqDo.getId());
            standardEditVO.setStandardName(standardReqDo.getStandardName());
            standardEditVO.setStandardUuid(standardReqDo.getStandardUuid());
            standardEditVO.setStandardTypeid(standardReqDo.getStandardTypeid());
            SysStandardTypeDO sysStandardTypeDO=sysStandardTypeDAO.getNameByValue(standardReqDo.getStandardTypeid());
            StandardTypeReq standardTypeReq=new StandardTypeReq();
            if (null!=sysStandardTypeDO){
                BeanUtils.copyProperties(sysStandardTypeDO, standardTypeReq);
            }
            standardEditVO.setCodeName(standardTypeReq.getCodeName());
            List<SysStandardDetailsDO> sysStandardDetailsDO = sysStandardDetailsDAO.getByDetailsId(standardReqDo.getId());
            if (sysStandardDetailsDO == null) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_FIND_DATA_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_FIND_DATA_NO_EXIST_FAIL.getErrorMessage());
            } else {
                List<DetailsVO> detailsReqList = new ArrayList<>();
                for (SysStandardDetailsDO list : sysStandardDetailsDO) {
                    DetailsVO detailsVO = new DetailsVO();
                    BeanUtils.copyProperties(list, detailsVO);
                    detailsReqList.add(detailsVO);
                }
                standardEditVO.setDetailsVOList(detailsReqList);
                return Result.wrapSuccessfulResult(standardEditVO);
            }
        } else {
            return Result.wrapErrorResult(ErrorEnum.ERROR_FIND_DATA_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_FIND_DATA_NO_EXIST_FAIL.getErrorMessage());
        }
    }

    /**
     * 删除
     *
     * @param standardInfo
     * @return
     */
    @Override
    public Result<Object> deleteStandardByUuid(StandardInfo standardInfo) {
        SysStandardDO sysStandardDO = sysStandardDAO.getstandardByUuid(standardInfo.getRequestId());
        if (sysStandardDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DETELE_DATA_FALSE.getErrorCode(), ErrorEnum.ERROR_DETELE_DATA_FALSE.getErrorMessage());
        } else {
            List<SysStandardDetailsDO> list = sysStandardDetailsDAO.getByDetailsId(sysStandardDO.getId());
            for (SysStandardDetailsDO detailsDO : list) {
                String delFlag = "1";
                sysStandardDetailsDAO.deleteByUuId(delFlag, detailsDO.getDetailUuid());
            }
            String delFlag = "1";
            sysStandardDAO.deleteByUuid(delFlag, sysStandardDO.getStandardUuid());
            return Result.wrapSuccessfulResult("删除标准成功");
        }
    }

    /**
     * 修改
     *
     * @param addReqs
     * @return
     */
    @Override
    public Result<Object> updateStandard(StandardReqAdd addReqs) {
        int count=sysStandardDAO.findStandardByMyName(addReqs.getId(),addReqs.getStandardName());
        if(count==0) {
            addReqs.getStandardTypeid();
            SysStandardDO sysStandardDO = new SysStandardDO();
            sysStandardDO.setId(addReqs.getId());
            sysStandardDO.setStandardName(addReqs.getStandardName());
            sysStandardDO.setStandardUuid(addReqs.getStandardUuid());
            sysStandardDO.setStandardTypeid(addReqs.getStandardTypeid());
            sysStandardDO.setDelFlag("0");
            sysStandardDO.setCreateBy(addReqs.getUserName());
            Date date = new Date();
            sysStandardDO.setCreateTime(date);
            sysStandardDO.setUpdateBy(addReqs.getUserName());
            sysStandardDO.setUpdateTime(date);
            sysStandardDAO.update(sysStandardDO);
            sysStandardDetailsDAO.deleteByDetailsId(addReqs.getId());
            List<DetailsReq> detailsReqs = addReqs.getDetailsReq();
            if (detailsReqs == null) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_CANSHU_WATER_STANDARD.getErrorCode(), ErrorEnum.ERROR_CANSHU_WATER_STANDARD.getErrorMessage());
            } else {
                for (DetailsReq detailsReq : detailsReqs) {
                    SysStandardDetailsDO sysStandardDetailsDO = new SysStandardDetailsDO();
                    BigDecimal maxIng = new BigDecimal(detailsReq.getMaxParm());
                    double maxIng1 = maxIng.doubleValue();
                    BigDecimal minIng = new BigDecimal(detailsReq.getMinParm());
                    double minIng1 = minIng.doubleValue();
                    if (maxIng1 > minIng1) {
                        sysStandardDetailsDO.setDetailsId(addReqs.getId());
                        sysStandardDetailsDO.setMinParm(detailsReq.getMinParm());
                        sysStandardDetailsDO.setMaxParm(detailsReq.getMaxParm());
                        sysStandardDetailsDO.setDetailName(detailsReq.getDetailName());
                        sysStandardDetailsDO.setDetailsId(detailsReq.getDetailsId());
                        sysStandardDetailsDO.setDetailUuid(StringUtils.genUUID());
                        sysStandardDetailsDO.setDelFlag("0");
                        sysStandardDetailsDAO.insert(sysStandardDetailsDO);
                    } else {
                        return Result.wrapErrorResult(ErrorEnum.ERROR_CANSHU_STANDARD_PARM.getErrorCode(), ErrorEnum.ERROR_CANSHU_STANDARD_PARM.getErrorMessage());
                    }
                }
                return Result.wrapSuccessfulResult("成功");
            }
        }else {
            return Result.wrapErrorResult(ErrorEnum.ERROR_STANDARD_NAME_EXIST.getErrorCode(), ErrorEnum.ERROR_STANDARD_NAME_EXIST.getErrorMessage());

        }
    }

    /**
     * 分页查询
     *
     * @param standardPageReq
     * @return
     */
    @Override
    public StandardPaginVO standardPageList(StandardPageReq standardPageReq) {
        StandardPaginVO standardnVO = new StandardPaginVO();
        List<StandardListVO> standardListVOS = new ArrayList<>();
        StandardListPage standardListPage = new StandardListPage();
        standardListPage.setStandardName(standardPageReq.getStandardName());
        BeanUtils.copyProperties(standardPageReq, standardListPage);
        StandardListPage standardListPage1 = sysStandardDAO.standardPaging(standardListPage);
        List<StandardResult> results = standardListPage1.getDatas();
        for (StandardResult result : results) {
            //list  里的泛型
            StandardListVO standardListVO = new StandardListVO();
            standardListVO.setId(result.getId());
            standardListVO.setStandardUuid(result.getStandardUuid());
            standardListVO.setStandardName(result.getStandardName());
            SysStandardTypeDO sysStandardTypeDO=sysStandardTypeDAO.getNameByValue(result.getStandardTypeid());
            StandardTypeReq standardTypeReq=new StandardTypeReq();
            if (sysStandardTypeDO != null) {
                BeanUtils.copyProperties(sysStandardTypeDO, standardTypeReq);
                standardListVO.setCodeName(standardTypeReq.getCodeName());
            } else {
                standardListVO.setCodeName("不存在");
            }
            standardListVO.setStandardTypeid(result.getStandardTypeid());
            List<SysStandardDetailsDO> list = sysStandardDetailsDAO.getByDetailsId(result.getId());
            List<DetailsVO> detailsVOS = new ArrayList<>();
            for (SysStandardDetailsDO sysStandardDetailsDO : list) {
                DetailsVO detailsVO = new DetailsVO();
                BeanUtils.copyProperties(sysStandardDetailsDO, detailsVO);
                detailsVOS.add(detailsVO);
                standardListVO.setDetailsVOList(detailsVOS);
            }
            standardListVOS.add(standardListVO);
        }
        BeanUtils.copyProperties(standardListPage1, standardnVO);
        standardnVO.setDatas(standardListVOS);
        return standardnVO;
    }

    /**
     * 通过类型id查标准表
     *
     * @param standardTypeid
     * @return
     */
    @Override
    public Result<Object> getStandardByTypeid(String standardTypeid) {
        List<SysStandardDO> standardDO = sysStandardDAO.getstandardByTypeid(standardTypeid);
        if (standardDO != null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_FIND_WATER_STANDARD_IS_EXIT.getErrorCode(), ErrorEnum.ERROR_FIND_WATER_STANDARD_IS_EXIT.getErrorMessage());
        } else {
            return Result.wrapSuccessfulResult("成功");
        }
    }

    @Override
    public Result<standByNamePagingVO> standByNamePaging(StandByNamePagingReq standByNamePagingReq) {
        //最终数据结果
        standByNamePagingVO standByNamePagingVO = new standByNamePagingVO();
        List<BaseStandPPage> baseStandPPages = Lists.newArrayList();

        BeanUtils.copyProperties(standByNamePagingReq, standByNamePagingVO);
        StandByNamePage standByNamePage = new StandByNamePage();
        BeanUtils.copyProperties(standByNamePagingReq, standByNamePage);
        standByNamePage.setDelFlag("0");
        StandByNamePage byNamePage = sysStandardDAO.standByNamePaging(standByNamePage);
        List<SysStandardDO> sysStandardDOS = byNamePage.getDatas();
        if (CollectionUtils.isEmpty(sysStandardDOS)) {
            return Result.wrapSuccessfulResult(standByNamePagingVO);
        }
        sysStandardDOS.forEach(sysStandardDO -> {
           // GetDictionaryInfoByCodeValue getDictionaryInfoByCodeValue = sysDictionaryDataDAO.getDictionaryInfoByCodeValue(sysStandardDO.getStandardTypeid());
            SysStandardTypeDO sysStandardTypeDO=sysStandardTypeDAO.getNameByValue(sysStandardDO.getStandardTypeid());
            BaseStandPPage baseStandPPage = new BaseStandPPage();
            BeanUtils.copyProperties(sysStandardDO, baseStandPPage);
            if (null!=sysStandardTypeDO){
                baseStandPPage.setCodeName(sysStandardTypeDO.getCodeName());
                baseStandPPage.setStandardTypeid(sysStandardTypeDO.getCodeValue());
            }
            List<StandardDetailsvo> detailsVoList = Lists.newArrayList();
            List<SysStandardDetailsDO> sysStandardDetailsDOS = sysStandardDetailsDAO.getByDetailsId(sysStandardDO.getId());
            if (!CollectionUtils.isEmpty(sysStandardDetailsDOS)) {
                sysStandardDetailsDOS.forEach(sysStandardDetailsDO -> {
                    StandardDetailsvo standardDetailsvo = new StandardDetailsvo();
                    BeanUtils.copyProperties(sysStandardDetailsDO, standardDetailsvo);
                    detailsVoList.add(standardDetailsvo);
                });
            }
            baseStandPPage.setDetailsVoList(detailsVoList);
            baseStandPPages.add(baseStandPPage);
        });
        standByNamePagingVO.setDatas(baseStandPPages);
        standByNamePagingVO.setTotal(byNamePage.getTotal());
        standByNamePagingVO.setCurrPageNo(byNamePage.getCurrPageNo());
        return Result.wrapSuccessfulResult(standByNamePagingVO);
    }
}
