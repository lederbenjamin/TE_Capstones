package com.techelevator.npgeek.home;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.home.JdbcParkDao;
import com.techelevator.npgeek.model.home.Park;

import junit.framework.Assert;


public class JdbcParkDaoIntegrationTest extends com.techelevator.DAOIntegrationTest{
	
	private JdbcParkDao dao;
	
	@Before
	public void setup() {
		dao = new JdbcParkDao(getDataSource());
	}
	
	@Before
	public void cleanDatabase() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM weather");
		jdbcTemplate.update("DELETE FROM park");
		String sqlInsertPost1 = "INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies) VALUES ('CVNP', 'Test Park One', 'Ohio', 32832, 696, 125, 0, 'Woodland', 2000, 2189849, 'Of all the paths you take in life, make sure a few of them are dirt.', 'John Muir', 'Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal', 0, 390)";
		String sqlInsertPost2 ="INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies) VALUES ('ENP', 'Test Park Two', 'Florida', 1508538, 0, 35, 0, 'Tropical', 1934, 1110901, 'There are no other Everglades in the world. They are, they have always been, one of the unique regions of the earth; remote, never wholly known. Nothing anywhere else is like them.', 'Marjory Stoneman Douglas', 'The Florida Everglades, located in southern Florida, is one of the largest wetlands in the world. Several hundred years ago, this wetlands was a major part of a 5,184,000 acre watershed that covered almost a third of the entire state of Florida. The Everglades consist of a shallow sheet of fresh water that rolls slowly over the lowlands and through billions of blades of sawgrass. As water moves through the Everglades, it causes the sawgrass to ripple like green waves; this is why the Everglades received the nickname River of Grass', 8, 760)";
		jdbcTemplate.update(sqlInsertPost1);
		jdbcTemplate.update(sqlInsertPost2);

		
	}
	
	@Test
	public void test() {
		Park expectedPark1 = createPark("CVNP", "Test Park One", "Ohio", 32832, 696, 125, 0, "Woodland", 2000, 2189849, "Of all the paths you take in life, make sure a few of them are dirt.", "John Muir", "Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal", 0, 390);
		Park expectedPark2 = createPark("ENP", "Test Park Two", "Florida", 1508538, 0, 35, 0, "Tropical", 1934, 1110901, "There are no other Everglades in the world. They are, they have always been, one of the unique regions of the earth; remote, never wholly known. Nothing anywhere else is like them.", "Marjory Stoneman Douglas", "The Florida Everglades, located in southern Florida, is one of the largest wetlands in the world. Several hundred years ago, this wetlands was a major part of a 5,184,000 acre watershed that covered almost a third of the entire state of Florida. The Everglades consist of a shallow sheet of fresh water that rolls slowly over the lowlands and through billions of blades of sawgrass. As water moves through the Everglades, it causes the sawgrass to ripple like green waves; this is why the Everglades received the nickname River of Grass", 8, 760);
		List<Park> actualParks = dao.getAllParks();
		assertParkAreEqual(expectedPark1, actualParks.get(0));
		assertParkAreEqual(expectedPark2, actualParks.get(1));
	}
	
	@SuppressWarnings("deprecation")
	private void assertParkAreEqual(Park expected, Park actual) {
		assertEquals(expected.getParkName(), actual.getParkName());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getAcreage(), actual.getAcreage());
		assertEquals(expected.getElevationInFeet(), actual.getElevationInFeet());
		assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail(), 0.0);
		assertEquals(expected.getNumberOfCampsites(), actual.getNumberOfCampsites());
		assertEquals(expected.getClimate(), actual.getClimate());
		assertEquals(expected.getYearFounded(), actual.getYearFounded());
		assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		assertEquals(expected.getInspirationalQuote(), actual.getInspirationalQuote());
		assertEquals(expected.getInspirationalQuoteSource(), actual.getInspirationalQuoteSource());
		assertEquals(expected.getParkDescription(), actual.getParkDescription());
		assertEquals(expected.getEntryFee(), actual.getEntryFee());
		assertEquals(expected.getNumberOfAnimalSpecies(), actual.getNumberOfAnimalSpecies());
	}
	
	private Park createPark(String parkCode, 
			String parkName, 
			String state, 
			int acreage, 
			int elevationInFeet, 
			float milesOfTrail, 
			int numberOfCampsites, 
			String climate,
			int yearFounded,
			int annualVisitorCount,
			String inspirationalQuote,
			String inspirationalQuoteSource,
			String parkDescription,
			int entryFee,
			int numberOfAnimalSpecies) {
		Park park = new Park();
		park.setParkCode(parkCode);
		park.setParkName(parkName);
		park.setState(state);
		park.setAcreage(acreage);
		park.setElevationInFeet(elevationInFeet);
		park.setMilesOfTrail(milesOfTrail);
		park.setNumberOfCampsites(numberOfCampsites);
		park.setClimate(climate);
		park.setYearFounded(yearFounded);
		park.setAnnualVisitorCount(annualVisitorCount);
		park.setInspirationalQuote(inspirationalQuote);
		park.setInspirationalQuoteSource(inspirationalQuoteSource);
		park.setParkDescription(parkDescription);
		park.setEntryFee(entryFee);
		park.setNumberOfAnimalSpecies(numberOfAnimalSpecies);	
		return park;
	}

}
