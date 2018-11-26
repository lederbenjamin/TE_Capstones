package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.home.JdbcParkDao;
import com.techelevator.npgeek.model.home.JdbcWeatherDao;
import com.techelevator.npgeek.model.home.Park;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;



@Controller
@SessionAttributes("convert")


public class homeController {

	@Autowired
	private JdbcParkDao parkDao;

	@Autowired
	private JdbcWeatherDao weatherDao;

	@RequestMapping(path="/home", method=RequestMethod.GET) // 
	public String displayHomePage(ModelMap map) {
		map.addAttribute("allParks", parkDao.getAllParks());
		return "home";
	}


	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String displayParkDetails(HttpServletRequest request) {
		String stringid = request.getParameter("parkCode");
		
		for(Park p : parkDao.getAllParks()) {
			if(p.getParkCode().equals(stringid)) {
				request.setAttribute("park", p);
			}
		}
		request.setAttribute("weathers", weatherDao.getForecastByParkCode(stringid));
		return "parkDetails";
	}
	
	@RequestMapping(path="/convertToCelcius", method=RequestMethod.POST)
	public String weatherCelciusConversion(@RequestParam(name="celcius") String convert, ModelMap map, @RequestParam String parkCode) {
	 map.addAttribute("convert", convert);
	    map.addAttribute("parkCode", parkCode);
	    return "redirect:/parkDetails";
	}
	
	@RequestMapping(path="/convertToFahrenheit", method=RequestMethod.POST)
	public String weatherFahrenheitConversion(@RequestParam(name="fahrenheit") String convert, ModelMap map, @RequestParam String parkCode) {
	    
	    map.addAttribute("convert", convert);
	    map.addAttribute("parkCode", parkCode);
	    return "redirect:/parkDetails";
	}
}

