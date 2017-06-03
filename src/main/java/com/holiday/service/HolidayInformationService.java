package com.holiday.service;

import com.holiday.model.Holiday;
import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class HolidayInformationService {

    public String findHolidays(HolidayApiResponse holidayApiResponse) throws IOException, URISyntaxException {
        return null;
    }

    private Holiday getHoliday(HolidayApiRequest holidayApiRequest) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.fromUriString("https://holidayapi.com/v1/holidays")
                .queryParam("key", "5034cf6f-fb60-4ace-b114-868f0d088144")
                .queryParam("country", holidayApiRequest.getFirstCountryCode())
                .queryParam("year", holidayApiRequest.getYear())
                .queryParam("month", holidayApiRequest.getMonth())
                .queryParam("day", holidayApiRequest.getDay())
                .build();
        return restTemplate.getForEntity(uri.toUri(), Holiday.class).getBody();
    }
}
