package com.holiday.service;

import com.holiday.HolidaySettings;
import com.holiday.model.Holiday;
import com.holiday.model.HolidayApiRequest;
import com.holiday.model.HolidayApiResponse;
import com.holiday.model.HolidayServiceResponse;
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
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(MockitoJUnitRunner.class)
public class HolidayInformationServiceTest {

    @InjectMocks
    private HolidayInformationService sut;

    @Mock
    private HolidaySettings holidaySettings;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getHolidaysShouldReturnHoliday() throws Exception {
        // given
        HolidayApiRequest holidayApiRequest = new HolidayApiRequest();
        holidayApiRequest.setDate("2010-10-10");
        String endpoint = "https://holidayapi.com/v1/holidays";
        Holiday holiday = new Holiday();
        holiday.setStatus("200");
        holiday.setHolidays(new HolidayApiResponse[]{});
        Mockito.when(holidaySettings.getEndpoint()).thenReturn(endpoint);
        Mockito.when(holidaySettings.getKey()).thenReturn("key");
        Mockito.when(restTemplate.getForEntity(Mockito.any(URI.class), Matchers.any(Class.class))).thenReturn(new ResponseEntity(HttpStatus.ACCEPTED));

        // when
        HolidayServiceResponse result = sut.findHolidays(holidayApiRequest);

        // then
        Assertions.assertThat(result.getDate()).isEqualTo("lol");
    }
}