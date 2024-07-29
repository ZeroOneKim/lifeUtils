package binarykim.lifeutils.workManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {
    @Autowired private PageModuler pageModuler;

    public void doManage() {
        Thread thread = new Thread();

        try {
            pageModuler.loginPRC(); //Login
            thread.sleep(5000);
            pageModuler.isSKIP();   //popup Skip
            thread.sleep(500);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
