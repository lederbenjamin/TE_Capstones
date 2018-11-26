package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDao {
	
	public List<SurveyResults> getAllSurveys();
	public List<Survey> getAllSurveysForTest();
	public void saveSurvey(Survey newSurvey);
	
}
