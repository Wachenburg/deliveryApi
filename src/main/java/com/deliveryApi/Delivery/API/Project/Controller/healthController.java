package com.deliveryApi.Delivery.API.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class healthController {

    @GetMapping("/health")
    public Map<String, String> health(){
        return Map.of(
                "Status", "UP",
                "timestamp", LocalDateTime.now().toString(),
                "Service", "Delivery API"
        );
    }
}
