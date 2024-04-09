package com.huike.order;


import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.huike.order.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.huike.order.entity")
public class RestOrderApplication {
	@SentinelRestTemplate(fallbackClass = ExceptionUtils.class,fallback =
			"handleFallback",
			blockHandler = "handleBlock" ,blockHandlerClass = ExceptionUtils.class
	)

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestOrderApplication.class,args);
	}
}
