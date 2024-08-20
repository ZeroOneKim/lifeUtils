package binarykim.lifeutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LifeutilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeutilsApplication.class, args);
	}
}
