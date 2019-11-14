package com.liuyabo.appnew;

import com.liuyabo.appnew.repository.BossRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.Assert;

import java.sql.Date;
import java.util.List;

import com.liuyabo.appnew.entity.*;

@Slf4j
@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
public class FreshFruitApplication implements ApplicationRunner {

	@Autowired
	private BossRepository bossRepository;
	public static void main(String[] args) {
		SpringApplication.run(FreshFruitApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Boss> result0 = bossRepository.findAll();
		Boss boss = new Boss();

		boss.setAddress("");
		boss.setBossName("liuyabo");
		boss.setCreatedTime(new Date(System.currentTimeMillis()));
		boss.setLastModifiedBy("liuyabo");
		boss.setLastModifiedTime(new Date(System.currentTimeMillis()));
		boss.setPhone("xxxxxxxxxxxx");
		boss.setStatus("Active");
		Boss result = bossRepository.save(boss);
		Assert.isTrue(result != null);
	}
}
