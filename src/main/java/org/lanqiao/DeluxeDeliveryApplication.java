package org.lanqiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@MapperScan("org.lanqiao.mapper")
public class DeluxeDeliveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeluxeDeliveryApplication.class, args);
	}
}

