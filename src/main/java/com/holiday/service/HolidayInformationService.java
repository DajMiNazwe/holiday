package com.holiday.service;

import com.holiday.HolidaySettings;
import com.holiday.model.Holiday;
import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

@Service
public class HolidayInformationService {

    private HolidaySettings holidaySettings;

    @Autowired
    public HolidayInformationService(HolidaySettings holidaySettings) {
        this.holidaySettings = holidaySettings;
    }

    public HolidayServiceResponse findHolidays(HolidayApiRequest holidayApiRequest) throws IOException, URISyntaxException {
        LocalDate startingDate = LocalDate.parse(holidayApiRequest.getDate());
        String firstCountryCode = holidayApiRequest.getFirstCountryCode();
        String secondCountryCode = holidayApiRequest.getSecondCountryCode();

        while ((getHoliday(firstCountryCode, startingDate.toString()).getHolidays().length == 0) ||
                (getHoliday(secondCountryCode, startingDate.toString()).getHolidays().length == 0)) {
            startingDate = startingDate.plusDays(1);
            holidayApiRequest.setDate(startingDate.toString());
        }

        Holiday firstCountryHoliday = getHoliday(holidayApiRequest.getFirstCountryCode(), startingDate.toString());
        Holiday secondCountryHoliday = getHoliday(holidayApiRequest.getSecondCountryCode(), startingDate.toString());

        HolidayServiceResponse holidayServiceResponse = new HolidayServiceResponse();
        holidayServiceResponse.setDate(startingDate.toString());
        holidayServiceResponse.setFirstHoliday(firstCountryHoliday.getHolidays()[0].getName());
        holidayServiceResponse.setSecondHoliday(secondCountryHoliday.getHolidays()[0].getName());

        return holidayServiceResponse;
    }

    private Holiday getHoliday(String countryCode, String date) {
        RestTemplate restTemplate = new RestTemplate();
        LocalDate localDate = LocalDate.parse(date);
        UriComponents uri = UriComponentsBuilder.fromUriString(holidaySettings.getEndpoint())
                .queryParam("key", holidaySettings.getKey())
                .queryParam("country", countryCode)
                .queryParam("year", localDate.getYear())
                .queryParam("month", localDate.getMonthValue())
                .queryParam("day", localDate.getDayOfMonth())
                .build();
        System.out.println(uri);
        return restTemplate.getForEntity(uri.toUri(), Holiday.class).getBody();
    }
}
