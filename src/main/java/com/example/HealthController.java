package com.example.myjavaapp;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class HealthController implements HealthIndicator {

    @Override
    public Health health() {
        // 현재 시간 가져오기
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 현재 상태와 시간을 반환
        return Health.up()
                .withDetail("status", "UP")        // Application Status
                .withDetail("application_status", "Application is running") // Custom Application status
                .withDetail("time", currentTime)   // Current Time
                .build();
    }
}

