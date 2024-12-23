package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    private static Map<String, Double> TEMPERATURES_MAP;

    @BeforeAll
    public static void beforeAll() {
        TEMPERATURES_MAP = createTestData();
    }

    private static Map<String, Double> createTestData() {
        Map<String, Double> temperatures = new HashMap<>();
        temperatures.put("Rzeszow", 25.0);
        temperatures.put("Krakow", 26.0);
        temperatures.put("Wroclaw", 27.0);
        temperatures.put("Warszawa", 27.0);
        temperatures.put("Gdansk", 28.0);
        return temperatures;
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(TEMPERATURES_MAP);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAvgTemperatureWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(TEMPERATURES_MAP);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double avgTemperature = weatherForecast.calculateAvgTemperature();

        //Then
        assertEquals(26.6, avgTemperature);
    }

    @Test
    void testCalculateMedianTemperatureWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(TEMPERATURES_MAP);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        assertEquals(27.0, medianTemperature);
    }
}
