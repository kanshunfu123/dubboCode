package com.xiaowei.sys.platform.core.service.manager.parameter;

import com.xiaowei.sys.platform.core.common.dal.dao.SysDictionaryDataDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysParameterConfigurationDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysParameterConfigurationDO;
import com.xiaowei.sys.platform.core.common.dal.paging.ParameterPage;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByIdsReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterPageList;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtils;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterAddVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdsVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterVo;
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


/**
 * Created by kanshunfu on 2018/9/11
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class ParamterServiceImpl implements ParameterService {
    private final static Logger logger = Logger.getLogger(ParamterServiceImpl.class);
    @Autowired
    SysParameterConfigurationDAO sysParameterConfigurationDAO;
    @Autowired
    SysDictionaryDataDAO sysDictionaryDataDAO;

    /**
     * 新增参数
     *
     * @param parameterAddVO
     * @return
     */
    @Override
    public Result<Object> saveParameter(ParameterAddVO parameterAddVO) {

        SysParameterConfigurationDO sysParameterConfigurationDO = new SysParameterConfigurationDO();
        BeanUtils.copyProperties(parameterAddVO, sysParameterConfigurationDO);
        List<SysParameterConfigurationDO> s = sysParameterConfigurationDAO.getCountsByValue(sysParameterConfigurationDO.getParameterValue());
        if (s.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_PARAMETER_VALUE.getErrorCode(), ErrorEnum.ERROR_ADD_PARAMETER_VALUE.getErrorMessage());
        }
        List<SysParameterConfigurationDO> s1 = sysParameterConfigurationDAO.getCountsByName(sysParameterConfigurationDO.getParameterName());
        if (s1.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_PARAMETER_NAME.getErrorCode(), ErrorEnum.ERROR_ADD_PARAMETER_NAME.getErrorMessage());
        }
        SysDictionaryDataDO sysDictionaryDataDO = new SysDictionaryDataDO();
        sysDictionaryDataDO.setCodeValue(sysParameterConfigurationDO.getFieldValue());
        int count = sysDictionaryDataDAO.getDictionaryCodeValue(sysDictionaryDataDO);
        if (count <= 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
        }


        sysParameterConfigurationDO.setCreateTime(DateUtil.getDateTime());
        sysParameterConfigurationDO.setCreateBy(parameterAddVO.getUserName());
        sysParameterConfigurationDO.setUpdateTime(DateUtil.getDateTime());
        sysParameterConfigurationDO.setUpdateBy(parameterAddVO.getUserName());
        sysParameterConfigurationDO.setUuid(StringUtils.genUUID());
        sysParameterConfigurationDO.setDelFlag("0");
        sysParameterConfigurationDAO.saveParameter(sysParameterConfigurationDO);
        return Result.wrapSuccessfulResult("添加成功");


    }

    /**
     * 编辑参数
     *
     * @param parameterAddVO
     * @return
     */
    @Override
    public Result<Object> updateParameter(ParameterAddVO parameterAddVO) {
        SysParameterConfigurationDO sysParameterConfigurationDO = new SysParameterConfigurationDO();
        BeanUtils.copyProperties(parameterAddVO, sysParameterConfigurationDO);
        SysParameterConfigurationDO before = sysParameterConfigurationDAO.getByUuid(parameterAddVO.getUuid());

        if (before == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_EDIT_PARAMETER_FAIL.getErrorMessage());
        }

        List<SysParameterConfigurationDO> s = sysParameterConfigurationDAO.getEditCountsByValue(before.getId(), sysParameterConfigurationDO.getParameterValue());
        if (s.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_PARAMETER_VALUE.getErrorCode(), ErrorEnum.ERROR_EDIT_PARAMETER_VALUE.getErrorMessage());
        }
        List<SysParameterConfigurationDO> s1 = sysParameterConfigurationDAO.getEditCountsByName(before.getId(), sysParameterConfigurationDO.getParameterName());
        if (s1.size() > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_PARAMETER_NAME.getErrorCode(), ErrorEnum.ERROR_ADD_PARAMETER_NAME.getErrorMessage());
        }
//        List<SysParameterConfigurationDO>s=sysParameterConfigurationDAO.getCountsByAll(before.getId(),sysParameterConfigurationDO.getParameterValue(),sysParameterConfigurationDO.getParameterName());
//        if(s.size()>0){
//            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_PARAMETER_VALUE.getErrorCode(), ErrorEnum.ERROR_EDIT_PARAMETER_VALUE.getErrorMessage());
//        }
        SysDictionaryDataDO sysDictionaryDataDO = new SysDictionaryDataDO();
        sysDictionaryDataDO.setCodeValue(sysParameterConfigurationDO.getFieldValue());
        int count = sysDictionaryDataDAO.getDictionaryCodeValue(sysDictionaryDataDO);
        if (count <= 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
        }
        SysParameterConfigurationDO after = new SysParameterConfigurationDO();
        BeanUtils.copyProperties(parameterAddVO, after);
        after.setDelFlag("0");
        after.setUpdateBy(parameterAddVO.getUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        after.setCreateBy(parameterAddVO.getUserName());
        after.setCreateTime(DateUtil.getDateTime());
        sysParameterConfigurationDAO.updateParameter(after);
        return Result.wrapSuccessfulResult("更新参数成功");
    }

    @Override
    public Result<Object> delParameter(ParameterVo parameterVo) {
        SysParameterConfigurationDO sysParameterConfigurationDO = new SysParameterConfigurationDO();
        BeanUtils.copyProperties(parameterVo, sysParameterConfigurationDO);
        if (null == sysParameterConfigurationDO) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_PARAMETER_FAIL.getErrorMessage());
        }
        SysParameterConfigurationDO sysParameterConfigurationDO1 = new SysParameterConfigurationDO();
        sysParameterConfigurationDO1.setUuid(parameterVo.getUuid());
        sysParameterConfigurationDO1.setDelFlag("1");
        sysParameterConfigurationDO1.setUpdateTime(DateUtil.getDateTime());
        sysParameterConfigurationDO1.setUpdateBy(parameterVo.getUserName());
        sysParameterConfigurationDAO.updateParameter(sysParameterConfigurationDO1);
        return Result.wrapSuccessfulResult("删除参数成功");

    }

 /*   @Override
    public Result<ParameterVo> getInfoByUuid(Long uuid) {
        GetParameterInfoByUuid getParameterInfoByUuid = sysParameterConfigurationDAO.getParameterInfoByFieldValue(uuid);
        if (null == getParameterInfoByUuid) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_SELECT_PARAMETER_FAIL.getErrorCode(),ErrorEnum.ERROR_SELECT_PARAMETER_FAIL.getErrorMessage());
        }
        ParameterVo parameterVo = new ParameterVo();
        BeanUtils.copyProperties(getParameterInfoByUuid, parameterVo);
        return Result.wrapSuccessfulResult(parameterVo);
    }*/

    @Override
    public Result<ParameterVo> parameterList(ParameterPageList parameterPageList) {
        ParameterVo parameterVo = new ParameterVo();
        ParameterPage parameterPage = new ParameterPage();
        parameterPage.setDelFlag("0");
        parameterPage.setCurrPageNo(parameterPageList.getCurrPageNo());
        parameterPage.setLimit(parameterPageList.getLimit());
        BeanUtils.copyProperties(parameterPageList, parameterPage);
        ParameterPage parameterPage1 = sysParameterConfigurationDAO.parameterPaging(parameterPage);
        BeanUtils.copyProperties(parameterPage1, parameterVo);
        return Result.wrapSuccessfulResult(parameterVo);
    }

    @Override
    public Result<List<ParameterVo>> getInfoByFieldValue(String fieldValue) {
        List<SysParameterConfigurationDO> sysParameterConfigurationDOList = sysParameterConfigurationDAO.getParameterInfoByFieldValue(fieldValue);

        List<ParameterVo> parameterVo = new ArrayList<ParameterVo>();
        sysParameterConfigurationDOList.forEach(ss -> {
            ParameterVo parameterVo1 = new ParameterVo();
            BeanUtils.copyProperties(ss, parameterVo1);
            parameterVo.add(parameterVo1);
        });


        return Result.wrapSuccessfulResult(parameterVo);
    }

    @Override
    public Result<List<ParameterByIdsVO>> getParameterByIds(List<ParameterByIdsReq> parameterByIdsReqs) {
        List<ParameterByIdsVO> parameterByIdsVOS = new ArrayList<>();
        List<SysParameterConfigurationDO> list = new ArrayList<>();
        parameterByIdsReqs.forEach(parameterByIdsReq -> {
            SysParameterConfigurationDO sysParameterConfigurationDO = new SysParameterConfigurationDO();
            sysParameterConfigurationDO.setId(parameterByIdsReq.getId());
            list.add(sysParameterConfigurationDO);
        });
        List<SysParameterConfigurationDO> sysParameterConfigurationDOList = sysParameterConfigurationDAO.getParameterByIds(list);
        sysParameterConfigurationDOList.forEach(sysParameterConfigurationDO -> {
            ParameterByIdsVO parameterByIdsVO = new ParameterByIdsVO();
            BeanUtils.copyProperties(sysParameterConfigurationDO, parameterByIdsVO);
            parameterByIdsVOS.add(parameterByIdsVO);
        });
        return Result.wrapSuccessfulResult(parameterByIdsVOS);
    }

    @Override
    public Result<ParameterVo> getInfoByUuid(ParameterByUuidReq parameterByUuidReq) {
        SysParameterConfigurationDO sysParameterConfigurationDO = sysParameterConfigurationDAO.getByUuid(parameterByUuidReq.getUuid());
        ParameterVo parameterVo = new ParameterVo();
        if (sysParameterConfigurationDO != null) {
            BeanUtils.copyProperties(sysParameterConfigurationDO, parameterVo);
        }
        return Result.wrapSuccessfulResult(parameterVo);
    }

    @Override
    public Result<ParameterByIdVO> getParameterById(Long id) {
        ParameterByIdVO parameterByIdVO = new ParameterByIdVO();
        SysParameterConfigurationDO sysParameterConfigurationDO = sysParameterConfigurationDAO.getParameterById(id);
        if (sysParameterConfigurationDO != null) {
            BeanUtils.copyProperties(sysParameterConfigurationDO, parameterByIdVO);
        }
        return Result.wrapSuccessfulResult(parameterByIdVO);
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        for (String str:list
//             ) {
//            System.out.println(str);
//        }
//        String a = "errrrwewewdffghvbhs";
//        String b = "w";
//        int num = 0;
//        for (int i = 0; i < a.length(); i++) {
//            int c = a.indexOf(b.trim());
//            if (c >= 0) {
//               num++;
//            }
//            a=a.substring(c+1,a.length());
//        }
//        System.out.println(num);
        List<String> lst1=new ArrayList<>();
        lst1.add("aa");
        lst1.add("dd");
        lst1.add("ss");
        lst1.add("aa");
        lst1.add("ss");

        //方法 1.
        for (int i = 0; i <lst1.size()-1; i++) {
            for (int j = lst1.size()-1; j >i; j--) {
                if (lst1.get(j).equals(lst1.get(i))) {
                    lst1.remove(j);
                }
            }
        }
        System.out.println(lst1);

    }
}
