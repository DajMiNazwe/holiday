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
        initializeThreads();

        // then

    }

    private void initializeThreads() {
        for (int i = 0; i < 1000; i++) {
            new ThreadSingletonLoader().start();
        }
    }

    public static class ThreadSingletonLoader extends Thread {

        @Override
        public void run() {
            Logger newLogger = Logger.getLogger();
            newLogger.Log(ThreadSingletonLoader.currentThread().getId());
            assertThat(newLogger).isSameAs(LoggerTest.logger);
        }
    }
}