package com.holiday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HolidayApiRequest {

    private String firstCountryCode;

    private String secondCountryCode;

    private Date date;
}
