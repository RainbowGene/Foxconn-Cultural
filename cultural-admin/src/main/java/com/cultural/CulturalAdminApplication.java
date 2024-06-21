package com.cultural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.cultural"})
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class CulturalAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CulturalAdminApplication.class, args);
    }
}
