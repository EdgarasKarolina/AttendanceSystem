package com.kea.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJms
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}
}
