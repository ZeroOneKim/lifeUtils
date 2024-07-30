package binarykim.lifeutils.workManage.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;

@Component
public class SchedulerTasks {

    @Scheduled(cron = "0 53 8 * * ?")
    public void test() {

    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        SchedulerTasks M = new SchedulerTasks();
        M.getNow();
    }

    public String getNow() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        String month = ((today.getMonthValue()+"").length() == 1) ? "0"+today.getMonthValue() : today.getMonthValue()+"";
        int day = today.getDayOfMonth();

        return year+month+day;
    }

}
