package com.holiday.utils;

import com.holiday.model.BarMapper;
import com.holiday.model.FooMapper;
import com.holiday.model.HolidayMapper;
import com.holiday.shared.CommonMapper;

public class MapperFactory {

    public CommonMapper getMapper(String type) {
        switch (type) {
            case "holidayApi":
                return new HolidayMapper();
            case "foo":
                return new FooMapper();
            case "bar":
                return new BarMapper();
        }
        return null;
    }
}
