package com.shengwang.demo;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


    @Component
    public class Task {
        /*
         * The method will run on 13:40:00 everyday.
         * cron format: sec min hour day mon week
         */
        @Scheduled(cron="0 40 13 * * *")
        public void runTask() {
            System.out.println("Runing at " + new Date());
        }

}
