package com.holiday.controller;

import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayServiceResponse;
import com.holiday.service.HolidayInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class HolidayInformationController {

    private HolidayInformationService holidayInformationService;

    @Autowired
    public HolidayInformationController(HolidayInformationService holidayInformationService) {
        this.holidayInformationService = holidayInformationService;
    }

    @GetMapping("/holiday/{firstCountryCode}/{secondCountryCode}/{date}")
    public HolidayServiceResponse getHolidays(HolidayApiRequest holidayApiRequest) throws IOException, URISyntaxException {
        return holidayInformationService.findHolidays(holidayApiRequest);
    }
}
