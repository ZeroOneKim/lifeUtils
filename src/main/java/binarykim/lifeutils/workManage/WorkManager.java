package binarykim.lifeutils.workManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {
    @Autowired private PageModuler pageModuler;

    public void doTest() {
        Thread thread = new Thread();

        try {
            pageModuler.loginPRC();

            thread.sleep(5000);
            pageModuler.isSKIP();

//            WebElement workIn = driver.findElement(By.id("workIn"));
//            System.out.println(workIn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("CHK");
        }
    }
}
