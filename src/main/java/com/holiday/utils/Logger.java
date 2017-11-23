package com.holiday.utils;

public class Logger {

    private static Logger logger = null;

    private Logger() {
    }

    public static synchronized Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void Log(String string) {
        
    }
}
