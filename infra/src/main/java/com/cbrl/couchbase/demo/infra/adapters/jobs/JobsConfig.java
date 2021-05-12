package com.cbrl.couchbase.demo.infra.adapters.jobs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Validated
@Data
@Configuration
@ConfigurationProperties(prefix = "job.scheduled")
public class JobsConfig {
    @NotEmpty
    private String cronValue;
}
