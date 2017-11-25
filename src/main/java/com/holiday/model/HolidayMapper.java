package com.holiday.model;

import com.holiday.shared.CommonMapper;

public class HolidayMapper extends CommonMapper<HolidayApiRequest, HolidayServiceResponse> {

    public HolidayApiRequest map(HolidayServiceResponse response) {
        HolidayApiRequest api = new HolidayApiRequest();
        api.setDate(response.getDate());
        api.setFirstCountryCode(response.getFirstHoliday());
        api.setSecondCountryCode(response.getSecondHoliday());
        return api;
    }
}
