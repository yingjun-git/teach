package com.yingjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName GatewayServerApplication
 * @Description
 * @Author 陈英俊
 * @Date 2023/4/2 18:10
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
}
