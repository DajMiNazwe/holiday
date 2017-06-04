package com.holiday;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("holidayapi")
public class HolidaySettings {
    private String endpoint;

    private String key;
}
