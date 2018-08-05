package com.dky.eureka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@Component
@MapperScan(
		basePackages = {
				"com.dky.eureka.persistence"
		}
)
@ComponentScan(basePackages= { "com.dky.eureka" })
//@EnableResourceServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
