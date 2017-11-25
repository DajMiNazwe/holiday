package com.holiday.utils;

public enum LoggerEnum {
    INSTANCE;

    String suffix;

    public void Log(String string) {
        System.out.println(string + suffix);
    }

    public void Log(Long number) {
        System.out.println(number);
    }
}
