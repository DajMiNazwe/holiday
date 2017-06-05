package com.holiday.service;

import com.holiday.HolidaySettings;
import com.holiday.model.Holiday;
import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayApiResponse;
import com.holiday.model.HolidayServiceResponse;
import com.holiday.shared.RestTemplateFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HolidayInformationServiceTest {

    @InjectMocks
    private HolidayInformationService sut;

    @Mock
    private HolidaySettings holidaySettings;

    @Mock
    private RestTemplateFactory restTemplateFactory;

    @Test
    public void getHolidaysShouldReturnHoliday() throws Exception {
        // given
        String date = "2010-10-10";
        HolidayApiRequest holidayApiRequest = new HolidayApiRequest();
        holidayApiRequest.setDate(date);
        String endpoint = "https://holidayapi.com/v1/holidays";
        Holiday holiday = new Holiday();
        holiday.setStatus("200");
        List<HolidayApiResponse> holidays = new ArrayList<>();
        holidays.add(new HolidayApiResponse());
        holiday.setHolidays(holidays.toArray(new HolidayApiResponse[]{}));
        Mockito.when(holidaySettings.getEndpoint()).thenReturn(endpoint);
        Mockito.when(holidaySettings.getKey()).thenReturn("key");
        Mockito.when(restTemplateFactory.getForEntity(Matchers.any(URI.class), Matchers.any(Class.class))).thenReturn(new ResponseEntity(holiday, HttpStatus.ACCEPTED));

        // when
        HolidayServiceResponse result = sut.findHolidays(holidayApiRequest);

        // then
        Assertions.assertThat(result.getDate()).isEqualTo(date);
    }
}