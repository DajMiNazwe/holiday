package com.holiday.model;

import lombok.Data;

@Data
public class HolidayApiRequest {

    private String firstCountryCode;

    private String secondCountryCode;

    private String date;
}
