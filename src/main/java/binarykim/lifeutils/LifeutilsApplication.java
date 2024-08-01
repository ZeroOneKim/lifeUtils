package binarykim.lifeutils;

import binarykim.lifeutils.workManage.WorkManager;
import binarykim.lifeutils.workManage.CumtomizedRunner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class LifeutilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeutilsApplication.class, args);
	}
}
