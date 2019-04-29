package com.xiaowei.sys.platform.core.service.manager.sysdept;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.sys.platform.core.common.dal.dao.SysDeptDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysUserDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDeptDO;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DeptTreeResult;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDeptInfoByUuid;
import com.xiaowei.sys.platform.core.facade.service.req.sysdept.SysDeptReq;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptTreeVO;
import com.xiaowei.sys.platform.core.facade.service.util.LevelUtil;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.yeecli.component.common.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by MOMO on 2018/9/11.
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class SysDeptServiceImpl implements SysDeptService {

    private final static Logger logger = Logger.getLogger(SysDeptServiceImpl.class);
    @Autowired
    private SysDeptDAO sysDeptDAO;
    @Autowired
    private SysUserDAO sysUserDAO;

    @Override
    public Result<List<SysDeptTreeVO>> deptTreeList() {

        //递归树最终结果集
        //将deptList拷贝到dtoList
        List<SysDeptTreeVO> sysDeptTreeRes = new ArrayList<>(0);
        //得到所有部门
        List<DeptTreeResult> deptVos = sysDeptDAO.deptTree();
        if (deptVos != null && deptVos.size() != 0) {
            deptVos.forEach(deptEntity -> {
                //去除被删除的部门
                if (deptEntity.getDelFlag().equals("0")) {
                    SysDeptTreeVO treeRes = new SysDeptTreeVO();
                    BeanUtils.copyProperties(deptEntity, treeRes);
                    sysDeptTreeRes.add(treeRes);
                }
            });
        }
        /*List<SysDeptTreeVO> dtos = Lists.newArrayList();
        SysDeptTreeVO dto = new SysDeptTreeVO();
        dto.setLabel("组织架构");
        dto.setSysDeptParentId(0L);
        dto.setSysDeptUuid("0");
        dto.setChildren(deptMenuToTree(sysDeptTreeRes));
        dtos.add(dto);*/
        return Result.wrapSuccessfulResult(deptMenuToTree(sysDeptTreeRes));

    }

    @Override
    public Result<Object> insertDept(SysDeptReq sysDeptReq) {


        SysDeptDO sysDeptDO = new SysDeptDO();
        sysDeptDO.setSysDeptCodeName(sysDeptReq.getSysDeptCodeName());
        //判断 部门参数值 全局唯一
        int count = sysDeptDAO.getDeptCodeName(sysDeptDO);
        if (count > 0) {
            Long max = sysDeptDAO.getMAXdeptCodeName();
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_DEPT_CODE_NAME_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_DEPT_CODE_NAME_FAIL.getErrorMessage()+(max+1));
        }
        if (sysDeptDO.getSysDeptParentId() == null) {
            sysDeptDO.setSysDeptParentId(0L);
        }else{
            SysDeptDO sysDeptDOaa = new SysDeptDO();
            sysDeptDOaa.setSysDeptCodeName(sysDeptDO.getSysDeptParentId());
            int countaa = sysDeptDAO.getDeptCodeName(sysDeptDOaa);
            if (countaa<=0){
                return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
            }
        }
        if (checkExist(null, sysDeptReq.getSysDeptName(), null)) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_NAME_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_NAME_EXIST_FAIL.getErrorMessage());
        }

        //根据uuid计算  level层级
        String level = getLevel(sysDeptReq.getSysDeptParentId());
        String newLevel = LevelUtil.calculateLevel(level, sysDeptReq.getSysDeptParentId());
        sysDeptDO.setSysDeptLevel(newLevel);
        sysDeptDO.setDelFlag("0");
        sysDeptDO.setCreateBy(sysDeptReq.getUserName());
        sysDeptDO.setSysDeptUuid(StringUtil.genUUID());
        sysDeptDO.setCreateTime(DateUtil.getDateTime());
        sysDeptDO.setUpdateBy(sysDeptReq.getUserName());
        sysDeptDO.setUpdateTime(DateUtil.getDateTime());
        sysDeptDO.setSysDeptName(sysDeptReq.getSysDeptName());
        sysDeptDO.setSysDeptSeq(sysDeptReq.getSysDeptSeq());
        sysDeptDAO.insertDept(sysDeptDO);
        return Result.wrapSuccessfulResult("新增部门成功");

    }

    @Override
    public Result<Object> updateDept(SysDeptReq sysDeptReq) {

        SysDeptDO before = sysDeptDAO.getByUuid(sysDeptReq.getSysDeptUuid());
        if (before == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_UPDATE_DEPT_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_UPDATE_DEPT_NO_EXIST_FAIL.getErrorMessage());
        }
        if (!before.getSysDeptCodeName().equals(sysDeptReq.getSysDeptCodeName())){
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_MODIFY_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_MODIFY_FAIL.getErrorMessage());
        }
        if (checkExist(null, sysDeptReq.getSysDeptName(), sysDeptReq.getSysDeptUuid())) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_NAME_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_NAME_EXIST_FAIL.getErrorMessage());
        }

        SysDeptDO after = new SysDeptDO();
        BeanUtils.copyProperties(sysDeptReq, after);
        //得到父级level
        String level = null;
        SysDeptDO sysDept = sysDeptDAO.getLevelByParentId(sysDeptReq.getSysDeptParentId());
        Long fatherId = 0L;
        if (sysDept != null) {
            level = sysDept.getSysDeptLevel();
            fatherId = sysDept.getSysDeptCodeName();
        }else{
            SysDeptDO sysDeptDOaa = new SysDeptDO();
            sysDeptDOaa.setSysDeptCodeName(sysDeptReq.getSysDeptParentId());
            sysDeptDOaa.setSysDeptUuid(sysDeptReq.getSysDeptUuid());
            int countaa = sysDeptDAO.getDeptCodeName(sysDeptDOaa);
            if (countaa<=0){
                return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
            }
        }
        String newLevel = LevelUtil.calculateLevel(level, fatherId);
        after.setSysDeptLevel(newLevel);
        //是否需要更新子部门
        updateWithChild(before, after, fatherId, sysDeptReq);
        return Result.wrapSuccessfulResult("更新部门成功");

    }

    @Override
    public Result<Object> delDept(SysDeptReq sysDeptReq) {
        SysDeptDO sysDeptDO = sysDeptDAO.getByUuid(sysDeptReq.getSysDeptUuid());
        if (null == sysDeptDO) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DEPT_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DEPT_NO_EXIST_FAIL.getErrorMessage());
        }
        if (checkExist(sysDeptDO.getSysDeptCodeName(), null, null)) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DEPT_EXIST_CHILD_DEPT_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DEPT_EXIST_CHILD_DEPT_FAIL.getErrorMessage());
        }
        int count = sysUserDAO.userCountByDeptId(sysDeptDO.getId());
        if (count > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_DEPT_EXIST_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_DEPT_EXIST_USER_FAIL.getErrorMessage());
        }
        SysDeptDO after = new SysDeptDO();
        after.setSysDeptUuid(sysDeptReq.getSysDeptUuid());
        after.setDelFlag("1");
        after.setUpdateBy(sysDeptReq.getUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        sysDeptDAO.updateDept(after);
        return Result.wrapSuccessfulResult("删除部门成功");

    }

    public List<SysDeptTreeVO> deptMenuToTree(List<SysDeptTreeVO> resList) {
        //集合为空直接返回
        if (CollectionUtils.isEmpty(resList)) {
            return Lists.newArrayList();
        }
        //可以放相同的key，比普通的map高级
        //把当前的tree以level为key 相同level的部门作为value，放到map里
        // level->[dept1,dept2,....]
        Multimap<String, SysDeptTreeVO> levelDeptMap = ArrayListMultimap.create();
        //用来保存第一层级的树,同时也是最终的部门树
        List<SysDeptTreeVO> rootList = Lists.newArrayList();
        for (SysDeptTreeVO treeRes : resList) {
            levelDeptMap.put(treeRes.getSysDeptLevel(), treeRes);
            if (LevelUtil.ROOT.equals(treeRes.getSysDeptLevel())) {
                rootList.add(treeRes);
            }
        }
        //按照 seq 从小到大 对部门树进行排序
        Collections.sort(rootList, new Comparator<SysDeptTreeVO>() {
            @Override
            public int compare(SysDeptTreeVO o1, SysDeptTreeVO o2) {
                return o1.getSysDeptSeq() - o2.getSysDeptSeq();
            }
        });
        //递归生成树
        transformDeptTree(rootList, LevelUtil.ROOT, levelDeptMap);
        return rootList;
    }

    private void transformDeptTree(List<SysDeptTreeVO> deptLevelList, String level, Multimap<String, SysDeptTreeVO> levelDeptMap) {
        int size = deptLevelList.size();
        for (int i = 0; i < size; i++) {
            //遍历该层的每个元素
            SysDeptTreeVO depetMenuDto = deptLevelList.get(i);
            //处理当前层级的数据
            String nexeLevel = LevelUtil.calculateLevel(level, depetMenuDto.getSysDeptCodeName());
            depetMenuDto.setId(null);
            //处理下一层
            List<SysDeptTreeVO> tempDeptList = (List<SysDeptTreeVO>) levelDeptMap.get(nexeLevel);
            if (!CollectionUtils.isEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList, deptSeqComparator);
                //设置下一层部门
                depetMenuDto.setChildren(tempDeptList);
                //进入到下一层处理
                transformDeptTree(tempDeptList, nexeLevel, levelDeptMap);
            }
        }
    }

    public Comparator<SysDeptTreeVO> deptSeqComparator = new Comparator<SysDeptTreeVO>() {
        @Override
        public int compare(SysDeptTreeVO o1, SysDeptTreeVO o2) {
            return o1.getSysDeptSeq() - o2.getSysDeptSeq();
        }
    };

    private String getLevel(Long parentId) {
        if (parentId == null) {
            return null;
        }
        SysDeptDO sysDept = sysDeptDAO.getLevelByParentId(parentId);
        if (sysDept == null) {
            return null;
        } else {
            return sysDept.getSysDeptLevel();
        }
    }

    private boolean checkExist(Long deptParentId, String deptName, String sysDeptUuid) {

        return sysDeptDAO.countByNameAndParentId(deptParentId, deptName, sysDeptUuid) > 0;
    }

    private void updateWithChild(SysDeptDO before, SysDeptDO after, long fatherId, SysDeptReq sysDeptReq) {
        //更新过后的部门level
        String newLevelPrefix = after.getSysDeptLevel();
        //更新之前的部门level
        String oldLevelPrefix = before.getSysDeptLevel();
        String newLevel = LevelUtil.calculateLevel(oldLevelPrefix, before.getSysDeptCodeName());
        if (!newLevelPrefix.equals(oldLevelPrefix)) {
            //查询子子孙孙 进行更新
            List<SysDeptDO> deptList = sysDeptDAO.getChildDeptListByLevel(newLevel);
            if (!CollectionUtils.isEmpty(deptList)) {
                for (SysDeptDO dept : deptList) {
                    String level = dept.getSysDeptLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setSysDeptLevel(level);
                        dept.setSysDeptParentId(fatherId);
                        dept.setCreateTime(DateUtil.getDateTime());
                        dept.setCreateBy(sysDeptReq.getUserName());
                        dept.setUpdateTime(DateUtil.getDateTime());
                        dept.setUpdateBy(sysDeptReq.getUserName());
                    }
                }
                sysDeptDAO.batchUpdateLevel(deptList);
            }
        }
        after.setSysDeptParentId(fatherId);
        sysDeptDAO.updateDept(after);
    }

    @Override
    public Result<SysDeptVO> getDeptInfoByUuid(String deptUuid) {
        SysDeptVO sysDeptVO = new SysDeptVO();
        GetDeptInfoByUuid sysDeptDO = sysDeptDAO.getDeptInfoByUuid(deptUuid);
        if (sysDeptDO == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_LOOK_DEPT_NOT_EXIST_INFO_FAIL.getErrorCode(), ErrorEnum.ERROR_LOOK_DEPT_NOT_EXIST_INFO_FAIL.getErrorMessage());
        }
        BeanUtils.copyProperties(sysDeptDO, sysDeptVO);
        return Result.wrapSuccessfulResult(sysDeptVO);
    }
}
