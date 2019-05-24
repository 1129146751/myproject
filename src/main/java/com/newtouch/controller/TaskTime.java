package com.newtouch.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/8
 * Time:15:06
 **/
@Component
public class TaskTime {
    @Scheduled(cron = "0 */1 * * * ?")
    public void Scheduled() throws Exception {
        System.out.println("每五分钟，开始调用第三方接口查询流水任务咯");

    }
}
