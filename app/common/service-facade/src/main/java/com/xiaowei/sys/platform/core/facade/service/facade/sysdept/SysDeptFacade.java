package com.xiaowei.sys.platform.core.facade.service.facade.sysdept;

import com.xiaowei.sys.platform.core.facade.service.req.sysdept.SysDeptReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptTreeVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/10.
 */
public interface SysDeptFacade {


    /**
     * 部门树形列表
     *
     * @return
     */
    Result<List<SysDeptTreeVO>> deptTreeList();

    /**
     * 新增部门
     *
     * @param sysDeptReq
     * @return
     */
    public Result<Object> insertDept(SysDeptReq sysDeptReq);

    /**
     * 编辑部门
     *
     * @return
     */
    public Result<Object> updateDept(SysDeptReq sysDeptReq);

    /**
     * 逻辑删除部门
     *
     * @param sysDeptReq
     * @return
     */
    public Result<Object> delDept(SysDeptReq sysDeptReq);

    /**
     * 根据uuid查看组织架构信息
     *
     * @param deptUuid
     * @return
     */
    public Result<SysDeptVO> getDeptInfoByUuid(String deptUuid);
}
