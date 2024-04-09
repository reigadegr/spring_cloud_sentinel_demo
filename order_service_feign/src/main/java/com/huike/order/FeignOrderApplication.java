package com.huike.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("com.huike.order.entity")
//激活Feign
@EnableFeignClients
public class FeignOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignOrderApplication.class,args);
	}
}
