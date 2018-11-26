package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyResults> getAllSurveys() {
		List<SurveyResults> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "select parkcode, count(surveyid) as total_surveys " + 
				"from survey_result " + 
				"group by parkcode " + 
				"order by total_surveys desc, parkcode asc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) { 
			allSurveys.add(mapRowToSurvey(results));
		}
		return allSurveys;
	}
	
	@Override
	public List<Survey> getAllSurveysForTest() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "select *" + 
				"from survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) { 
			allSurveys.add(mapRowToSurveyTest(results));
		}
		return allSurveys;
	}

	@Override
	public void saveSurvey(Survey newSurvey) {
		 
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) " + 
					"VALUES (?, ?, ?, ?)";
			
			jdbcTemplate.update(sqlInsertSurvey, newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getStateOfResidence(), newSurvey.getActivity());
			
		}	
	
	private SurveyResults mapRowToSurvey(SqlRowSet results) {
		
		SurveyResults surveyResults = new SurveyResults();
		String parkCode = results.getString("parkcode");
		surveyResults.setParkCode(parkCode);
		surveyResults.setTotalSurveys(results.getLong("total_surveys"));
		
		return surveyResults;
	}
	
	private Survey mapRowToSurveyTest(SqlRowSet results) {
		
		Survey survey = new Survey();
		survey.setSurveyId(results.getLong("surveyid"));
		survey.setParkCode(results.getString("parkcode"));
		survey.setEmailAddress(results.getString("emailaddress"));
		survey.setStateOfResidence(results.getString("state"));
		survey.setActivity(results.getString("activitylevel"));
		
		return survey;
	}
	
	private long getNextId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyid')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the survey");
		}
	}

}
