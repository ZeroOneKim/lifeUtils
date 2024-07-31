package binarykim.lifeutils;

import binarykim.lifeutils.workManage.WorkManager;
import binarykim.lifeutils.workManage.security.CumtomizedRunner;
import binarykim.lifeutils.workManage.timer.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LifeutilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeutilsApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(WorkManager workManager) {
		return new CumtomizedRunner(workManager);
	}
}
