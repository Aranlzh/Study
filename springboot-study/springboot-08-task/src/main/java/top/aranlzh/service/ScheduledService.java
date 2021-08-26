package top.aranlzh.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 在一个特定的时间执行这个方法
    // cron表达式
    @Scheduled(cron = "0/10 * * * * ?")
    public void hello() {
        System.out.println("[执行]数据正在处理...");
    }

}
