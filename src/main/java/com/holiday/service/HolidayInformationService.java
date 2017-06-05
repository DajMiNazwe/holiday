package com.holiday.service;

import com.holiday.HolidaySettings;
import com.holiday.model.Holiday;
import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayServiceResponse;
import com.holiday.shared.RestTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@Service
public class HolidayInformationService {

    final private HolidaySettings holidaySettings;

    final private RestTemplateFactory restTemplateFactory;

    @Autowired
    public HolidayInformationService(HolidaySettings holidaySettings, RestTemplateFactory restTemplateFactory) {
        this.holidaySettings = holidaySettings;
        this.restTemplateFactory = restTemplateFactory;
    }

    public HolidayServiceResponse findHolidays(HolidayApiRequest holidayApiRequest) {
        LocalDate startingDate = LocalDate.parse(holidayApiRequest.getDate());
        String firstCountryCode = holidayApiRequest.getFirstCountryCode();
        String secondCountryCode = holidayApiRequest.getSecondCountryCode();

        while ((getHoliday(firstCountryCode, startingDate.toString()).getHolidays().length == 0)
                || (getHoliday(secondCountryCode, startingDate.toString()).getHolidays().length == 0)) {
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
        URI uri = buildUri(countryCode, date);
        return (Holiday) restTemplateFactory.getForEntity(uri, Holiday.class).getBody();
    }

    private URI buildUri(String countryCode, String date) {
        LocalDate localDate = LocalDate.parse(date);
        UriComponents uri = UriComponentsBuilder.fromUriString(holidaySettings.getEndpoint())
                .queryParam("key", holidaySettings.getKey())
                .queryParam("country", countryCode)
                .queryParam("year", localDate.getYear())
                .queryParam("month", localDate.getMonthValue())
                .queryParam("day", localDate.getDayOfMonth())
                .build();
        System.out.println(uri);
        return uri.toUri();
    }
}
