package com.xiaowei.sys.platform.core.service.manager.waterstandard;

import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDetailsDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardTypeDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDetailsDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardTypeDO;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import com.xiaowei.sys.platform.core.facade.service.req.waterstandard.SaveStandardReq;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.details.DetailsVO;
import com.xiaowei.sys.platform.core.facade.service.vo.waterstandard.SysStandardTypeVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class WaterStandardServiceImpl implements WaterStandardService {
    private Logger logger = Logger.getLogger(WaterStandardServiceImpl.class);
    @Autowired
    SysStandardDAO sysStandardDAO;
    @Autowired
    SysStandardDetailsDAO sysStandardDetailsDAO;
    @Autowired
    SysStandardTypeDAO sysStandardTypeDAO;

    /**
     * 添加水质标准
     */
    @Override
    public Result<Object> save(SaveStandardReq saveStandardReq) {
        /**根据水质名称查询是否存在*/
        String standardName = saveStandardReq.getStandardName();
        int exitCount  = sysStandardDAO.findSysStandardByName(standardName);
        if (exitCount ==0) {
            /**添加标准===*/
            SysStandardDO sysStandardDO = new SysStandardDO();
            saveStandardReq.setDelFlag("0");
            saveStandardReq.setCreateBy("sys");
            saveStandardReq.setCreateTime(DateUtil.getDateTime());
            saveStandardReq.setUpdateBy("sys");
            saveStandardReq.setUpdateTime(DateUtil.getDateTime());
            saveStandardReq.setStandardUuid(StringUtil.genUUID());
            BeanUtils.copyProperties(saveStandardReq, sysStandardDO);
            int count = sysStandardDAO.insert(sysStandardDO);
            if (count > 0) {
                List<DetailsReq> detailsVOList = saveStandardReq.getDetailsReqList();
                long standardId = sysStandardDO.getId();
                /**x循环添加对应水质详情*/
                for (int i = 0; i < detailsVOList.size(); i++) {
                    SysStandardDetailsDO detailsDO = new SysStandardDetailsDO();
                    detailsDO.setDetailUuid(StringUtil.genUUID());
                    detailsDO.setDetailName(detailsVOList.get(i).getDetailName());
                    detailsDO.setMaxParm(detailsVOList.get(i).getMaxParm());
                    detailsDO.setMinParm(detailsVOList.get(i).getMinParm());
                    detailsDO.setDetailsId(standardId);
                    detailsDO.setDetailUuid(StringUtil.genUUID());
                    detailsDO.setDelFlag("0");
                    sysStandardDetailsDAO.insert(detailsDO);
                }
            }
            return Result.wrapSuccessfulResult("添加水质标准成功");
        } else {
            return Result.wrapErrorResult(ErrorEnum.ERROR_SAVE_WATER_STANDARD_IS_EXIT.getErrorCode(), ErrorEnum.ERROR_SAVE_WATER_STANDARD_IS_EXIT.getErrorMessage());
        }

    }

    @Override
    public Result<List<SysStandardTypeVO>> findAllStandardType(String codeValue) {
        SysStandardTypeDO sysStandardTypeDO = sysStandardTypeDAO.getNameByValue(codeValue);
        if (sysStandardTypeDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_STANDARD_TYPE_SELECT_NULL.getErrorCode(), ErrorEnum.ERROR_STANDARD_TYPE_SELECT_NULL.getErrorMessage());
        }
        List<SysStandardTypeDO> sysStandardTypeDOS = sysStandardTypeDAO.getByValue(codeValue);
        List<SysStandardTypeVO> sysStandardTypeVOS = new ArrayList<SysStandardTypeVO>();
        for (int i = 0; i < sysStandardTypeDOS.size(); i++) {
            SysStandardTypeVO standardTypeVO = new SysStandardTypeVO();
            BeanUtils.copyProperties(sysStandardTypeDOS.get(i), standardTypeVO);
            sysStandardTypeVOS.add(standardTypeVO);
        }
        return Result.wrapSuccessfulResult(sysStandardTypeVOS);
    }

    @Override
    public Result<List<SysStandardTypeVO>> findByParentValue(String parentValue) {
        SysStandardTypeDO sysStandardTypeDO = sysStandardTypeDAO.getNameByValue(parentValue);
        if (sysStandardTypeDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_STANDARD_TYPE_SELECT_NULL.getErrorCode(), ErrorEnum.ERROR_STANDARD_TYPE_SELECT_NULL.getErrorMessage());
        }
        List<SysStandardTypeVO> sysStandardTypeVOS = new ArrayList<SysStandardTypeVO>();
        List<SysStandardTypeDO> sysStandardTypeDOS = sysStandardTypeDAO.getByValue(parentValue);
        for (int i = 0; i < sysStandardTypeDOS.size(); i++) {
            SysStandardTypeVO standardTypeVO = new SysStandardTypeVO();
            BeanUtils.copyProperties(sysStandardTypeDOS.get(i), standardTypeVO);
            sysStandardTypeVOS.add(standardTypeVO);
        }
        System.out.println(sysStandardTypeVOS);
        return Result.wrapSuccessfulResult(sysStandardTypeVOS);
    }
}
