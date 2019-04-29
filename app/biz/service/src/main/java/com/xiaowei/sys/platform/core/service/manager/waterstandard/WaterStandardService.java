package com.xiaowei.sys.platform.core.service.manager.waterstandard;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardTypeDO;
import com.xiaowei.sys.platform.core.facade.service.req.waterstandard.SaveStandardReq;
import com.xiaowei.sys.platform.core.facade.service.vo.waterstandard.SysStandardTypeVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

public interface WaterStandardService {
    /**
     * 水质标准添加
     */
    public Result<Object> save(SaveStandardReq saveStandardReq);

    /**
     * 查询所有的水质类型
     */
    public Result<List<SysStandardTypeVO>> findAllStandardType(String codeValue);

    /**
     * 根据parentValue查询该水质下的项目
     */
    public Result<List<SysStandardTypeVO>> findByParentValue(String parentValue);

}
