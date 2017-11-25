package com.holiday.utils;

public class Logger {

    private static Logger logger;

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void Log(String string) {
        System.out.println(string);
    }

    public void Log(Long number) {
        System.out.println(number);
    }
}
