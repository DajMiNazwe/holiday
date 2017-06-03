package com.holiday.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HolidayApiResponse {

    private String name;

    private String date;

    private String observed;

    @JsonProperty("public")
    private boolean puubliz;
}
