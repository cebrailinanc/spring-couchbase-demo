package com.cbrl.couchbase.demo.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cbrl.couchbase.demo")
public class InfraApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraApplication.class, args);
    }

}
