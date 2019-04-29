package com.xiaowei.sys.platform.core.service.manager.common;

import com.xiaowei.sys.platform.core.common.dal.dao.SysAreaDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaDO;
import com.xiaowei.sys.platform.core.facade.service.req.common.ProvincesReq;
import com.xiaowei.sys.platform.core.facade.service.vo.common.Area;
import com.xiaowei.sys.platform.core.facade.service.vo.common.City;
import com.xiaowei.sys.platform.core.facade.service.vo.common.Province;
import com.xiaowei.sys.platform.core.facade.service.vo.common.ProvincesVO;
import com.yeecli.component.common.model.Result;
import org.eclipse.jdt.core.IField;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MOMO on 2018/10/31.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class ProvincesServiceImpl implements ProvincesService {
    @Autowired
    private SysAreaDAO sysAreaDAO;
    @Override
    public Result<ProvincesVO> provinces(ProvincesReq provincesReq) {
        ProvincesVO provincesVO=new ProvincesVO();
        //省
        SysAreaDO sysAreaDOOne= sysAreaDAO.getByUuid(provincesReq.getProvince());
        if (null!=sysAreaDOOne){
            Province province=new Province();
            BeanUtils.copyProperties(sysAreaDOOne,province);
            provincesVO.setProvince(province);
        }else{
            return Result.wrapSuccessfulResult(provincesVO);
        }
        //市
        SysAreaDO sysAreaDOTwo= sysAreaDAO.getByUuid(provincesReq.getCity());
        if (null!=sysAreaDOTwo){
            City city=new City();
            BeanUtils.copyProperties(sysAreaDOTwo,city);
            provincesVO.setCity(city);
        }else{
            return Result.wrapSuccessfulResult(provincesVO);
        }
        //区
        SysAreaDO sysAreaDOThree= sysAreaDAO.getByUuid(provincesReq.getArea());
        if (null!=sysAreaDOThree){
            Area area=new Area();
            BeanUtils.copyProperties(sysAreaDOThree,area);
            provincesVO.setArea(area);
        }else{
            return Result.wrapSuccessfulResult(provincesVO);
        }
        return Result.wrapSuccessfulResult(provincesVO);
    }
}
