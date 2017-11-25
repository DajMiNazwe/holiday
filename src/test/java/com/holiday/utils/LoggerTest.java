package com.holiday.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggerTest {

    private static Logger logger = Logger.getLogger();

    @Test
    public void shouldCreateSingleInstance() {
        // given

        // when
        Logger newLogger = Logger.getLogger();

        // then
        assertThat(newLogger).isSameAs(logger);
    }

    @Test
    public void shouldUseSameInstanceAcrossMultipleThreads() {
        // given

        // when

        // then
        initializeAndAssertThreads();
    }

    private void initializeAndAssertThreads() {
        for (int i = 0; i < 1000; i++) {
            new ThreadSingletonLoader().start();
        }
    }

    private static class ThreadSingletonLoader extends Thread {

        @Override
        public void run() {
            Logger newLogger = Logger.getLogger();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newLogger.Log(ThreadSingletonLoader.currentThread().getId());
            assertThat(newLogger).isSameAs(LoggerTest.logger);
        }
    }
}