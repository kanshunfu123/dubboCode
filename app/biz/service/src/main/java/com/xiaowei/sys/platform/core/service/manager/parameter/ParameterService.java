package com.xiaowei.sys.platform.core.service.manager.parameter;

import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByIdsReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterPageList;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterAddVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdsVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterVo;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by kanshunfu on 2018/9/14
 */
public interface ParameterService {
    /**
     * 新增参数
     *
     * @param parameterAddVO
     * @return
     */
    Result<Object> saveParameter(ParameterAddVO parameterAddVO);

    /**
     * 编辑参数
     *
     * @param ParameterAddVO
     * @return
     */
    Result<Object> updateParameter(ParameterAddVO ParameterAddVO);

    /**
     * 逻辑删除参数
     *
     * @param parameterVo
     * @return
     */
    Result<Object> delParameter(ParameterVo parameterVo);

    /**
     * 分页查询参数列表
     */
    public Result<ParameterVo> parameterList(ParameterPageList parameterPage);

    /**
     * 根据fieldValue查看参数列表详情
     *
     * @param fieldValue
     * @return
     */
    public Result<List<ParameterVo>> getInfoByFieldValue(String fieldValue);

    /**
     * 根据id列表查询参数集合
     *
     * @param parameterByIdsReqs
     * @return
     */
    public Result<List<ParameterByIdsVO>> getParameterByIds(List<ParameterByIdsReq> parameterByIdsReqs);

    /**
     * 根据uuid查看参数列表详情
     *
     * @param parameterByUuidReq
     * @return
     */
    Result<ParameterVo> getInfoByUuid(ParameterByUuidReq parameterByUuidReq);

    /**
     * 根据id查询参数对象
     */
    Result<ParameterByIdVO> getParameterById(Long id);
}
