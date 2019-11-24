package com.liuyabo.appnew;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
public class FreshFruitApplication implements ApplicationRunner {
	public static void main(String[] args) {

		SpringApplication.run(FreshFruitApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	}
}
