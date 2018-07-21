package com.lovevol.mysite.util.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTask {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedRate = 3000)
    public void printTime(){
        Date now = new Date();
        System.out.print(now);
    }

//    @Scheduled(cron = "30-31 * * * *  *")
    public void printTime2(){
        System.out.println(format.format(new Date()));
    }
}
