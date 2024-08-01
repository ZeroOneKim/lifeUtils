package binarykim.lifeutils.workManage.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Component
public class SchedulerTasks {
    public static void main(String[] args) {
    }

    public String getNow() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        String month = ((today.getMonthValue()+"").length() == 1) ? "0"+today.getMonthValue() : today.getMonthValue()+"";
        String day = (today.getDayOfMonth()+"").length() == 1 ? "0"+today.getDayOfMonth() : today.getDayOfMonth()+"";

        return year+month+day;
    }

    /**
     * 1~250 난수 발생.
     * @return 난수
     */
    public int occurRandTime() {
        Random random = new Random();
        return random.nextInt(250)+1;
    }

    public void getTestTime() { //TODO 제거예정
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        String month = ((today.getMonthValue()+"").length() == 1) ? "0"+today.getMonthValue() : today.getMonthValue()+"";
        String day = (today.getDayOfMonth()+"").length() == 1 ? "0"+today.getDayOfMonth() : today.getDayOfMonth()+"";

        LocalTime lc = LocalTime.now();
        System.out.println(year+month+day + "   " +lc.getHour()+":"+lc.getMinute()+":"+lc.getSecond());
    }
}
