package com.holiday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HolidayApiResponse {

    private Date date;

    private String firstHoliday;

    private String secondHoliday;
}
