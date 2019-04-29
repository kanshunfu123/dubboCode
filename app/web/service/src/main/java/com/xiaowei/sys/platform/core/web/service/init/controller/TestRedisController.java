package com.xiaowei.sys.platform.core.web.service.init.controller;

import com.xiaowei.sys.platform.core.facade.service.req.sysuser.SysUserReq;
import com.xiaowei.sys.platform.core.facade.service.util.SSORedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOMO on 2018/9/12.
 */
@RestController
public class TestRedisController {
    @Autowired
    private SSORedisUtil ssoRedisUtil;

    @RequestMapping("/testRedis")
    @ResponseBody
    public Object restRedis(){
        List<SysUserReq> list=new ArrayList<>();
        SysUserReq userLoginReq=new SysUserReq();
        userLoginReq.setCode("菜单");
        userLoginReq.setSysUserName("李杰");
        list.add(userLoginReq);
        SysUserReq userLoginReq2=new SysUserReq();
        userLoginReq2.setCode("菜单1");
        userLoginReq2.setSysUserName("李杰1");
        list.add(userLoginReq2);
        List<SysUserReq> list2=new ArrayList<>();
        ssoRedisUtil.setList("list",list);
        ssoRedisUtil.setList("list2",list2);
        ssoRedisUtil.expire("list",60);
        List<SysUserReq> list1=  ssoRedisUtil.getList("list",SysUserReq.class);
        for (SysUserReq loginReq : list1) {
            System.out.println(loginReq.getCode());
        }
        ssoRedisUtil.setString("str","测试string类型是否乱码");
        System.out.println(ssoRedisUtil.get("str"));
        return ssoRedisUtil.get("test");
    }
}
