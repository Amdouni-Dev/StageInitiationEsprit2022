package com.server.server.Cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;


@Component
public class TestCron {
    @Scheduled(cron = "*/2 * * * * *")
    public void run() {
        System.out.println("Current time is :: " + Calendar.getInstance().getTime());
    }
}
