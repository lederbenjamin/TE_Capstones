package com.techelevator.npgeek.survey;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;



public class JdbcSurveyDaoIntegrationTest extends com.techelevator.DAOIntegrationTest{

	
	private JdbcSurveyDao dao;
	
	@Before
	public void setup() {
		dao = new JdbcSurveyDao(getDataSource());
	}
	
	@Before
	public void cleanDatabase() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM survey_result");
	}
	
	@Test
	public void test() {
		Survey surveyActual1 = createSurvey("GNP","dummy1@gmail.com","Ohio","inactive");
		Survey surveyActual2 = createSurvey("GNP","dummy2@gmail.com","Georgia","inactive");
		dao.saveSurvey(surveyActual1);
		dao.saveSurvey(surveyActual2);
		List<Survey> results = dao.getAllSurveysForTest();
		assertSurveyIsEqual(surveyActual1, results.get(0));
		assertSurveyIsEqual(surveyActual2, results.get(1));


		
	}
	
	private void assertSurveyIsEqual(Survey expected, Survey actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getEmailAddress(), actual.getEmailAddress());
		assertEquals(expected.getStateOfResidence(), actual.getStateOfResidence());
		assertEquals(expected.getActivity(), actual.getActivity());
	}
	
	private Survey createSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		Survey survey = new Survey();
		survey.setParkCode(parkCode);
		survey.setEmailAddress(emailAddress);
		survey.setStateOfResidence(state);;
		survey.setActivity(activityLevel);;
		return survey;
	}

}
