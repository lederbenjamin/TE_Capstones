package com.techelevator.npgeek.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("surveys")
public class surveyController {
	
	@Autowired
   private JdbcSurveyDao surveyDao;
    
    
    @RequestMapping(path="/surveyInput", method=RequestMethod.GET) 
    public String displaySurveyInput(Model model) {
    	if (! model.containsAttribute("surveyInput")) {
    		model.addAttribute("surveyInput", new Survey());
    	}
        return "surveyInput";
    }
  
    @RequestMapping(path="/surveyInput", method=RequestMethod.POST) 
    public String redirectToSurveyOuput( @Valid @ModelAttribute("surveyInput") Survey survey,
    		BindingResult result, RedirectAttributes attr) {
    	if(result.hasErrors()) {
        	
            return "/surveyInput"; 
        		}

    	surveyDao.saveSurvey(survey);
    	
    		  return "redirect:/surveyOutput";
    	}
    
    
//    @RequestMapping(path="/surveyInput", method=RequestMethod.POST) //
//    public String redirectToSurveyOuput(HttpServletRequest request) {
//    	Survey survey = new Survey();
//    	
//    	survey.setParkCode(convertParkNameToParkCode(request.getParameter("parkName")));
//    	survey.setEmailAddress(request.getParameter("emailAddress"));
//    	survey.setState(request.getParameter("state"));
//    	survey.setActivityLevel(request.getParameter("activity"));
//    	
//    	surveyDao.saveSurvey(survey);
//        return "redirect:/surveyOutput";
//    }
//    
    @RequestMapping(path="/surveyOutput", method=RequestMethod.GET) 
    public String displaySurveyOutput(ModelMap map) {
    	if (! map.containsAttribute("surveyOutput")) {
        map.addAttribute("surveys", surveyDao.getAllSurveys());
    	}
        return "surveyOutput";
    }
    
    
//	private String convertParkNameToParkCode(String parkName) {
//    	String parkCode = null;
//    	if (parkName.equals("Cuyahoga Valley National Park"))
//    		parkCode = "CVNP";
//    	else if (parkName.equals("Everglades National Park"))
//    		parkCode = "ENP";
//    	else if (parkName.equals("Glacier National Park"))
//    		parkCode = "GNP";
//    	else if (parkName.equals("Grand Canyon National Park"))
//    		parkCode = "GCNP";
//    	else if (parkName.equals("Grand Teton National Park"))
//    		parkCode = "GTNP";
//    	else if (parkName.equals("Great Smoky Mountains National Park"))
//    		parkCode = "GSMNP";
//    	else if (parkName.equals("Mount Rainier National Park"))
//    		parkCode = "MRNP";
//    	else if (parkName.equals("Rocky Mountain National Park"))
//    		parkCode = "RMNP";
//    	else if (parkName.equals("Yellowstone National Park"))
//    		parkCode = "YNP";
//    	else 
//    		parkCode = "YNP2";
//    	return parkCode;
//    }
    

}

