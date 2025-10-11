package com.syifa.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    // Basic health check endpoint
    @GetMapping
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("API is running and healthy ✅", HttpStatus.OK);
    }

    // Optional detailed health endpoint (useful for Postman testing)
    @GetMapping("/status")
    public ResponseEntity<Object> getHealthStatus() {
        return new ResponseEntity<>(new HealthStatus("UP", "Backend server is operational"), HttpStatus.OK);
    }

    // Inner class for structured JSON response
    static class HealthStatus {
        private String status;
        private String message;

        public HealthStatus(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
