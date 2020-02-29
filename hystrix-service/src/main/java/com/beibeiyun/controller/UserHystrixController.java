package com.beibeiyun.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.beibeiyun.domain.CommonResult;
import com.beibeiyun.domain.User;
import com.beibeiyun.service.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/user")
public class UserHystrixController {
    @Autowired
    private UserService userService;
/*
* 测试服务降级
* */
    @GetMapping("/testFallback/{id}")
    public CommonResult testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }
/*
* 设置命令、分组及线程池名称
* */
    @GetMapping("/testCommand/{id}")
    public CommonResult testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }
/*
* ignoreExceptions忽略某些异常降级
* */
    @GetMapping("/testException/{id}")
    public CommonResult testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

/*
* 使用缓存的测试接口
* */
    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
       //初始化HystrixRequestContext，在Hystrix中带缓存的command是必须在request中调用的。
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
     //   context.shutdown();
        return new CommonResult("操作成功", 200);
    }


    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.removeCache(id);
        userService.getUserCache(id);
        return new CommonResult("操作成功", 200);
    }

/*
* 合并请求，从而达到减少通信消耗及线程数量的效果。
* */
    @GetMapping("/testCollapser")
    public CommonResult testCollapser() throws ExecutionException, InterruptedException {
        Future<User> future1 = userService.getUserFuture(1L);
        Future<User> future2 = userService.getUserFuture(2L);
        future1.get();
        future2.get();
        ThreadUtil.safeSleep(200);
        Future<User> future3 = userService.getUserFuture(3L);
        future3.get();
        return new CommonResult("操作成功", 200);
    }



}
