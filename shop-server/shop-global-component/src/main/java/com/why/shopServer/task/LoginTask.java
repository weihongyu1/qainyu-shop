package com.why.shopServer.task;

import com.why.shopServer.service.impl.GlobalLoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 登录失效定时任务
 *
 * @author why
 * @create 2022-05-28 15:31
 **/
@Component
@Slf4j
public class LoginTask {

    @Autowired
    private GlobalLoginServiceImpl globalLoginService;

    @Scheduled(fixedRate = 60000)
    public void scheduledTask() {
       new Thread(() -> {
           log.info(Thread.currentThread().getName() + "正在执行清理程序");
           globalLoginService.ExpiredLogin();
       }, "ExpiredLoginThread-" + new Date().getTime()).start();
    }
}
