package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.timer.SchedulerTasks;
import binarykim.lifeutils.workManage.timer.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {
    @Autowired PageModuler pageModuler;
    @Autowired WorkDay workDay;
    @Autowired SchedulerTasks schedulerTasks;

    static int testCount = 0;

    @Scheduled(cron = "0 50 8 * * ?")
    public void doManage() {
        if(workDay.getWorkDayList().isEmpty()) workDay.startInit();

        testCount++;
        if(testCount == 1) return;
        if(workDay.getWorkDayList().contains(schedulerTasks.getNow())) {
            try {
                int sleepT = schedulerTasks.occurRandTime();
                System.out.println("Wating ....   " + sleepT + " Seconds");
                Thread.sleep(sleepT*1000);

                schedulerTasks.getTestTime();
                pageModuler.loginPRC(); //Login
                pageModuler.isSKIP();   //popup Skip
                pageModuler.prcManage();//workIn

                pageModuler.quitDriver(); //종료

                System.out.println(testCount + "] 작업 진행 됨."); //TODO EMAIL
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            schedulerTasks.getTestTime();
            System.out.println(testCount + "] 공휴일 및 휴일 Tasks..");
        }
    }
}
