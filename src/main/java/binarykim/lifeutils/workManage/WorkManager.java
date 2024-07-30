package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.timer.SchedulerTasks;
import binarykim.lifeutils.workManage.timer.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {
    @Autowired private PageModuler pageModuler;
    @Autowired WorkDay workDay;
    @Autowired SchedulerTasks schedulerTasks;

    public void doManage() {
        if(workDay.getWorkDayList().isEmpty()) workDay.startInit();
        Thread thread = new Thread();
        workDay.getWorkDayList().contains(schedulerTasks.getNow()); //TODO it is Valid Logic..

        try {
//            pageModuler.loginPRC(); //Login
//            thread.sleep(5000);
//            pageModuler.isSKIP();   //popup Skip
//            thread.sleep(500);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
