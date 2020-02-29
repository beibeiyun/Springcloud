package com.beibeiyun.service;

import com.beibeiyun.domain.CommonResult;
import com.beibeiyun.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.Future;

@Service
public interface UserService {
    // 服务降级接口
    CommonResult getUser(Long id);
    //设置命令、分组及线程池名称
    CommonResult getUserCommand(@PathVariable Long id);
    //ignoreExceptions忽略某些异常降级
    CommonResult getUserException(Long id);
    //具有缓存功能的getUserCache方法
    CommonResult getUserCache(Long id);

    CommonResult removeCache(Long id);

    Future<User> getUserFuture(Long id);
}
