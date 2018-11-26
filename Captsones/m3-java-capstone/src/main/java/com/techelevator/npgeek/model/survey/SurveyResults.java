package com.techelevator.npgeek.model.survey;

public class SurveyResults {
	
	private String parkCode;
	private Long totalSurveys;
	private String parkName;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
		setParkCodeToParkName(parkCode);
	}
	public Long getTotalSurveys() {
		return totalSurveys;
	}
	public void setTotalSurveys(Long totalSurveys) {
		this.totalSurveys = totalSurveys;
	}
	
	public String getParkName() {
		return parkName;
	}

    private void setParkCodeToParkName(String parkCode) {
    	this.parkName = null;
    	if (parkCode.equals("CVNP"))
    		parkName = "Cuyahoga Valley National Park";
    	else if (parkCode.equals("ENP"))
    		parkName = "Everglades National Park";
    	else if (parkCode.equals("GNP"))
    		parkName = "Glacier National Park";
    	else if (parkCode.equals("GCNP"))
    		parkName = "Grand Canyon National Park";
    	else if (parkCode.equals("GTNP"))
    		parkName = "Grand Teton National Park";
    	else if (parkCode.equals("GSMNP"))
    		parkName = "Great Smoky Mountains National Park";
    	else if (parkCode.equals("MRNP"))
    		parkName = "Mount Rainier National Park";
    	else if (parkCode.equals("RMNP"))
    		parkName = "Rocky Mountain National Park";
    	else if (parkCode.equals("YNP"))
    		parkName = "Yellowstone National Park";
    	else 
    		parkName = "Yosemite National Park";
    }
	

}
