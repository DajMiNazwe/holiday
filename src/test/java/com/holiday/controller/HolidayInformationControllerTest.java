package com.holiday.controller;

import com.holiday.model.HolidayApiRequest;
import com.holiday.service.HolidayInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HolidayInformationControllerTest {

    @InjectMocks
    private HolidayInformationController sut;

    @Mock
    private HolidayInformationService holidayInformationService;

    @Test
    public void getHolidaysShouldCallService() throws Exception {
        // given
        HolidayApiRequest holidayApiRequest = new HolidayApiRequest();

        // when
        sut.getHolidays(holidayApiRequest);

        // then
        Mockito.verify(holidayInformationService).findHolidays(holidayApiRequest);
    }
}