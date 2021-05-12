package com.cbrl.couchbase.demo.infra.adapters.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class Jobs {

    @Scheduled(fixedDelay = 2000)
    public void fixedDelay() {
        log.info("public Fixed delay task - {}", LocalDateTime.now());
    }

    @Scheduled(fixedDelayString  = "${scheduled.fixed-delay}")
    protected void fixedDelay1() {
        log.info("protected delay task - {}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 2200)
    private void fixedDelay2() {
        log.info("private delay task - {}", LocalDateTime.now());
    }

   @Scheduled(cron =  "#{@jobsConfig.getCronValue()}")
    private void cron() {
        log.info("execute cron {}", LocalDateTime.now());
    }

    @Scheduled(cron =  "${job.scheduled.cron-value}")
    private void cron2() {
        log.info("cron-value cron {}", LocalDateTime.now());
    }
}
