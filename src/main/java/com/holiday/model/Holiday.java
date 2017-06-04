package com.holiday.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Holiday {

    private String status;

    @JsonProperty("holidays")
    private HolidayApiResponse[] holidays;
}
