package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }

        return resultMap;
    }

    public Double calculateAvgTemperature() {
        Double sum = 0.0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        if (temperatures.getTemperatures().size() == 0) {
            return 0.0;
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        double median = 0.0;
        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(temperatureList);
        int size = temperatureList.size();
        if (size % 2 == 0) {
            median = (temperatureList.get(size / 2) + temperatureList.get(size / 2 - 1)) / 2;
        } else {
            median = temperatureList.get(size / 2);
        }
        return median;
    }
}
