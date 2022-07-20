package com.busyqa.coop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BusyqaProjectBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusyqaProjectBeApplication.class, args);
	}

}
