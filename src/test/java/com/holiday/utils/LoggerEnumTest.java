package com.holiday.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggerEnumTest {

    private LoggerEnum loggerEnum = LoggerEnum.INSTANCE;

    @Test
    public void shouldReturnTheSameValue() {
        // given
        LoggerEnum secondLoggerEnum = LoggerEnum.INSTANCE;

        // when
        loggerEnum.suffix = "GREAT SUFFIX";

        // then
        assertThat(loggerEnum.suffix).isEqualTo(secondLoggerEnum.suffix);
    }
}