package com.holiday.utils;

import com.holiday.model.BarMapper;
import com.holiday.model.FooMapper;
import com.holiday.model.HolidayMapper;
import com.holiday.shared.CommonMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperFactoryTest {

    private MapperFactory mapperFactory = new MapperFactory();

    @Test
    public void shouldReturnHolidayMapper() {
        // given
        String type = "holidayApi";

        // when
        CommonMapper mapper = mapperFactory.getMapper(type);

        // then
        assertThat(mapper).isExactlyInstanceOf(HolidayMapper.class);
    }

    @Test
    public void shouldReturnFooMapper() {
        // given
        String type = "foo";

        // when
        CommonMapper mapper = mapperFactory.getMapper(type);

        // then
        assertThat(mapper).isExactlyInstanceOf(FooMapper.class);
    }

    @Test
    public void shouldReturnBarMapper() {
        // given
        String type = "bar";

        // when
        CommonMapper mapper = mapperFactory.getMapper(type);

        // then
        assertThat(mapper).isExactlyInstanceOf(BarMapper.class);
    }
}