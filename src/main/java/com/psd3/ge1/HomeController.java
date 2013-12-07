package com.psd3.ge1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static TeachingSession ts;
	private ArrayList<TeachingSession> sessions = new ArrayList<TeachingSession>();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "login";
	}
	
	@RequestMapping("/loginSubmit")
	public String login(
			@RequestParam(value="username", required = true) String username, 
			@RequestParam(value="password", required = true) String password) 
	{
		if(username.toLowerCase().equals("admin")) {
			return "NewTeachingSession";
		}
		else if(username.toLowerCase().equals("user")) {
			return "/User";
		}
		else
			return "/home";
	}
	
	@RequestMapping("/NewTeachingSessionSubmit")
	public String NewTeachingSessionSubmit(
			@RequestParam(value="title", required = true) String title, 
			@RequestParam(value="startDate", required = true) String startDate,
			@RequestParam(value="startTime", required = true) String startTime,
			@RequestParam(value="duration", required = true) String duration,
			@RequestParam(value="repeatfreq", required = true) String repeatFrequency,
			@RequestParam(value="lecturer", required = true) String lecturer,
			@RequestParam(value="maxAttendance", required = true) String maxAttendance,
			@RequestParam(value="compulsory", required = true) String compulsory,
			@RequestParam(value="venue", required = true) String venue)
	{
		ts = new TeachingSession(title, 
												startDate, 
												startTime, 
												Double.parseDouble(duration), 
												Integer.parseInt(repeatFrequency), 
												lecturer, Integer.parseInt(maxAttendance), 
												Boolean.parseBoolean(compulsory),						
												venue);
		
		logger.info(ts.getTitle());
		logger.info(ts.getStartDate());
		logger.info(ts.getStartTime());
		logger.info(String.valueOf(ts.getDuration()));
		logger.info(String.valueOf(ts.getRepeatFrequency()));
		logger.info(ts.getLecturer());
		logger.info(String.valueOf(ts.getMaxAttendance()));
		logger.info(String.valueOf(ts.isCompulsory()));
		logger.info(ts.getVenue());
		logger.info(ts.toString());
		sessions.add(ts);
		return "NewTeachingSessionConfirm";
	}
	
	@RequestMapping(value = "/NewTeachingSessionConfirm", method = RequestMethod.GET)
	public String list(ModelMap model) {
		logger.info("Listing session");
		/*TeachingSession ts = new TeachingSession("test1",
												 "12/12/2013", 
												 "1000", 
												 3.0, 
												 3, 
												 "Tan", 
												 10, 
												 true, 
												 "lab");*/
		model.put("ts",ts);
		return "NewTeachingSessionConfirm";
	}
	
}
