package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Scheduled( initialDelay = 1000L, fixedDelay = 5000L)
//	public void startDelay(){
//		System.out.println("New delay = "+new Date());
//	}
////
//	@Scheduled(fixedRate =  1000L)
//	public void startRate(){
//		System.out.println("New rate = "+new Date());
//	}
//
//	@Scheduled(cron =  "0 8 0 * * *")
//	public void startCron(){
//		System.out.println("New croN = "+new Date());
//	}


}
