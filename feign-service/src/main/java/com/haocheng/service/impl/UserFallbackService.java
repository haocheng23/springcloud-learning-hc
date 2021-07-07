package com.haocheng.service.impl;

import com.haocheng.entity.CommonResult;
import com.haocheng.entity.User;
import com.haocheng.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @Description:    Feign中的服务降级
 * @Remark:         只需要为Feign客户端定义的接口添加一个服务降级处理的实现类即可
 * @Author:         haocheng
 * @Date:           2021-07-07 16:25:39
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级",500);
    }
}

