package com.techelevator.npgeek.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	 private Long surveyId;
	 
	 @NotBlank(message="Please select Favorite National Park")
	 private String parkCode;
	 
	 @NotBlank(message="Email is required") @Email(message="Invalid email")
	 private String emailAddress;
	 
	 @NotBlank(message="Please select State Of Residence")
	 private String stateOfResidence;
	 
	 
	 @NotBlank(message="Please select Activity Level")
	 private String activity;
	 
	 
	public Long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getStateOfResidence() {
		return stateOfResidence;
	}
	public void setStateOfResidence(String stateOfResidence) {
		this.stateOfResidence = stateOfResidence;
	}
	
	 
	 
}
