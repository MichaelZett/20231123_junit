package de.zettsystems.weather;

public class WeatherService {
    private TemperatureService temperatureService;
    private WindService windService;
    private RainfallService rainfallService;

    public WeatherService(TemperatureService temperatureService, WindService windService, RainfallService rainfallService) {
        this.temperatureService = temperatureService;
        this.windService = windService;
        this.rainfallService = rainfallService;
    }

    public Status measureWeather() {
        Status temperature = temperatureService.measureTemperature();
        Status wind = windService.measureWind();
        Status rain = rainfallService.measureRain();
        int goods = count(Status.GOOD, temperature, wind, rain);
        int bads = count(Status.BAD, temperature, wind, rain);

        if (goods == 3) {
            return Status.GOOD;
        } else if (bads >= 2) {
            return Status.BAD;
        } else if (bads == 1 && goods == 0) {
            return Status.BAD;
        } else {
            return Status.OK;
        }

    }

    private int count(Status status, Status temperature, Status wind, Status rain) {
        int result = 0;
        if (status == temperature) {
            result++;
        }
        if (status == wind) {
            result++;
        }
        if (status == rain) {
            result++;
        }
        return result;
    }
}
