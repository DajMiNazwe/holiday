package com.holiday.utils;

class Logger {

    private static Logger logger = null;

    private Logger() {
    }

    static synchronized Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    void Log(String string) {
        System.out.println(string);
    }

    void Log(Long number) {
        System.out.println(number);
    }
}
