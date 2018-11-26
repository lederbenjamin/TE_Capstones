package com.techelevator.npgeek.home;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.home.JdbcWeatherDao;
import com.techelevator.npgeek.model.home.Weather;



public class JdbcWeatherDaoIntegrationTest extends com.techelevator.DAOIntegrationTest{

	
	private JdbcWeatherDao dao;
	
	@Before
	public void setup() {
		dao = new JdbcWeatherDao(getDataSource());
	}
	
	@Before
	public void cleanDatabase() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM weather");
		String sqlInsertPost1 = "INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('GNP',1,27,40,'snow')";
		String sqlInsertPost2 = "INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('GNP',2,31,43,'snow')";
		jdbcTemplate.update(sqlInsertPost1);
		jdbcTemplate.update(sqlInsertPost2);

		
	}
	
	@Test
	public void test() {
		Weather expectedWeather1 = createWeather("GNP",1,27,40,"snow");
		Weather expectedWeather2 = createWeather("GNP",2,31,43,"snow");
		String parkCode = "GNP";
		List<Weather> actualWeather = dao.getForecastByParkCode(parkCode);
		assertWeatherIsEqual(expectedWeather1, actualWeather.get(0));
		assertWeatherIsEqual(expectedWeather2, actualWeather.get(1));
	}
	
	private void assertWeatherIsEqual(Weather expected, Weather actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getFiveDayForecastValue(), actual.getFiveDayForecastValue());
		assertEquals(expected.getLow(), actual.getLow());
		assertEquals(expected.getHigh(), actual.getHigh());
		assertEquals(expected.getForecast(), actual.getForecast());
	}

	
	private Weather createWeather(String parkCode, int fiveDayForecastValue, int low, int high, String forecast) {
		Weather weather = new Weather();
		weather.setParkCode(parkCode);
		weather.setFiveDayForecastValue(fiveDayForecastValue);
		weather.setLow(low);
		weather.setHigh(high);
		weather.setForecast(forecast);
		return weather;
	}

}
