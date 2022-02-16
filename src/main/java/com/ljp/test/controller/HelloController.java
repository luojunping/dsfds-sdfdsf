package com.ljp.test.controller;

import com.ljp.util.TraceIdUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequestMapping("/hello/")
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("world")
    public String helloWorld() {
        log.error("hello world !!!");
        String traceId = MDC.get(TraceIdUtils.TRACE_ID);
        new Thread(() -> {
            MDC.put(TraceIdUtils.TRACE_ID, traceId);
            log.error("hello world !!!");
            MDC.remove(TraceIdUtils.TRACE_ID);
        }).start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            MDC.put(TraceIdUtils.TRACE_ID, traceId);
            log.error("hello world !!!");
            MDC.remove(TraceIdUtils.TRACE_ID);
        });
        executorService.shutdown();
        return "hello world !!!";
    }

    @GetMapping("china")
    public String helloChina() {
        log.error("hello china !!!");
        RLock rLock = redisson.getLock("hello-china");
        rLock.lock();
        rLock.unlock();
        return "hello china !!!";
    }

    @GetMapping("{any}")
    public String helloAny(@PathVariable("any") String any) throws InterruptedException {
        log.error("hello " + any + " !!!");
        RLock rLock = redisson.getLock("hello-any");
        rLock.lock(20, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(30);
        if ("any".equals(any)) {
            throw new IllegalArgumentException("参数有误！");
        }
//        rLock.unlock();
        rLock.forceUnlock();
        return "hello " + any + " !!!";
    }

}
