package com.spring.vehicletracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring.vehicletracking.services.ReaderTaskScheduler;
import com.spring.vehicletracking.services.WriterServiceScheduler;

@SpringBootApplication
@ComponentScan("com.spring.vehicletracking")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
                
    }    
    
}