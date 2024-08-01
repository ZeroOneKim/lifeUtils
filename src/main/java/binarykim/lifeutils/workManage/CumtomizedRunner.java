package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.WorkManager;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CumtomizedRunner implements ApplicationRunner {
    private final WorkManager workManager;

    public CumtomizedRunner(WorkManager workManager) {
        this.workManager = workManager;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        workManager.doManage();
    }
}
