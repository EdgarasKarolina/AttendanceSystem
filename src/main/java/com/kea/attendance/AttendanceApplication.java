package com.kea.attendance;

import com.kea.attendance.Utilities.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.jms.annotation.EnableJms;

import javax.swing.*;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJms
@EnableScheduling
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}
}
