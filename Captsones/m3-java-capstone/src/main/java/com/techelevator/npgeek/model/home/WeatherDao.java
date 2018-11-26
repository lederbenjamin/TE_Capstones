package com.techelevator.npgeek.model.home;

import java.util.List;

public interface WeatherDao {

	List<Weather> getForecastByParkCode(String parkCode);
}
