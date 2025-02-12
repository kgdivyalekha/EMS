package com.spring.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
		
	}
	@Bean
public ThreadPoolTaskExecutor taskExecutor()
{
	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	executor.setCorePoolSize(6);
	executor.setMaxPoolSize(10);
	executor.setQueueCapacity(15);
	executor.setThreadNamePrefix("employeeupload");
	executor.initialize();
	return executor;
}
}
