package binarykim.lifeutils;

import binarykim.lifeutils.workManage.WorkManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifeutilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeutilsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(WorkManager workManager) {
		return args -> {
			workManager.doManage();
		};
	}
}
