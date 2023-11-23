package de.zettsystems.weather;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    TemperatureService temperatureService;
    @Mock
    WindService windService;
    @Mock
    RainfallService rainfallService;

    @InjectMocks
    WeatherService testee;

    @Test
    void shouldMeasureGoodWeather() {
        when(temperatureService.measureTemperature()).thenReturn(Status.GOOD);
        when(windService.measureWind()).thenReturn(Status.GOOD);
        when(rainfallService.measureRain()).thenReturn(Status.GOOD);

        final Status result = testee.measureWeather();


        assertThat(result).isEqualTo(Status.GOOD);
    }

    @Test
    void shouldMeasureBadWeather() {
        when(temperatureService.measureTemperature()).thenReturn(Status.BAD);
        when(windService.measureWind()).thenReturn(Status.BAD);
        when(rainfallService.measureRain()).thenReturn(Status.GOOD);

        final Status result = testee.measureWeather();


        assertThat(result).isEqualTo(Status.BAD);
    }

    @Test
    void shouldMeasureOkWeather() {
        when(temperatureService.measureTemperature()).thenReturn(Status.OK);
        when(windService.measureWind()).thenReturn(Status.GOOD);
        when(rainfallService.measureRain()).thenReturn(Status.GOOD);

        final Status result = testee.measureWeather();


        assertThat(result).isEqualTo(Status.OK);
    }

    @Test
    void shouldMeasureOkWeatherEvenWhenBad() {
        when(temperatureService.measureTemperature()).thenReturn(Status.OK);
        when(windService.measureWind()).thenReturn(Status.BAD);
        when(rainfallService.measureRain()).thenReturn(Status.GOOD);

        final Status result = testee.measureWeather();


        assertThat(result).isEqualTo(Status.OK);
    }
}