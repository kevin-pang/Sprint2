package com.psd3.ge1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//private static TeachingSession ts;
	private List<TeachingSession> sessions = new ArrayList<TeachingSession>();
	private List<Timetable> timetables = new ArrayList<Timetable>();
	Map<String, String> duration;
	Map<String, String> repeatFrequency;
	Map<String, String> lecturer;
	Map<String, String> venue;
	Timetable timetableGlobal;
	boolean flag = false;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		while(!flag)
		{
			populate();
		}


		//return "login";
		return new ModelAndView("login2", "user", new User());
	}

	private void populate() {
		timetables.add(new Timetable("CS Year 1", new ArrayList<TeachingSession>()));
		timetables.add(new Timetable("CS Year 2", new ArrayList<TeachingSession>()));
		timetables.add(new Timetable("CS Year 3", new ArrayList<TeachingSession>()));
		timetables.add(new Timetable("CS Year 4", new ArrayList<TeachingSession>()));

		sessions.add(new TeachingSession("test1", "12/12/2013", "1000", 3.0, "Weekly", "Tan", 10, true, "lab"));
		sessions.add(new TeachingSession("test2", "12/12/2013", "1000", 3.0, "Weekly", "Tan", 10, true, "lab"));
		for (Timetable tt : timetables) {
			for (TeachingSession ts : sessions) {
				tt.addTeachingSession(ts);
			}

		}

		duration = new TreeMap<String, String>();
		duration.put("4", "4 Hours");	
		duration.put("3", "3 Hours");
		duration.put("2", "2 Hours");
		duration.put("1", "1 Hour");

		repeatFrequency = new TreeMap<String, String>();
		repeatFrequency.put("Weekly", "Weekly");	
		repeatFrequency.put("Monthly", "Monthly");

		lecturer = new TreeMap<String, String>();
		lecturer.put("Dr John", "Dr John");	
		lecturer.put("Dr Peter", "Dr Peter");
		lecturer.put("Dr Tom", "Dr Tom");
		lecturer.put("Dr Joe", "Dr Joe");
		lecturer.put("Dr Gary", "Dr Gary");

		venue = new TreeMap<String, String>();
		venue.put("Lab", "Lab");	
		venue.put("Lecture Room", "Lecture Room");
		flag = true;
	}

	/*@RequestMapping("/loginSubmit")
	public String login(
			@RequestParam(value="username", required = true) String username, 
			@RequestParam(value="password", required = true) String password) 
	{
		if(username.toLowerCase().equals("admin")) {
			return "/AdminMenu";
		}
		else if(username.toLowerCase().equals("user")) {
			return "/User";
		}
		else
			return "/home";
	}*/

	@RequestMapping("/login2Submit")
	public String login2(@ModelAttribute User user)
	{
		if(user.getUsername().toLowerCase().equals("admin")) {
			return "/AdminMenu";
		}
		else if(user.getUsername().toLowerCase().equals("user")) {
			return "/User";
		}
		else
			return "/home";
	}
	@RequestMapping(value="/CreateNewTeachingSessionForm")
	public ModelAndView createNewTeachingSession() {
		ModelAndView mav = new ModelAndView("CreateNewTeachingSession", "ts", new TeachingSession());
		/*Map<String, String> duration = new HashMap<String, String>();

		duration.put("3", "3 Hours");
		duration.put("2", "2 Hours");
		duration.put("1", "1 Hour");*/
		mav.addObject("durationMap", duration);
		mav.addObject("repeatFrequencyMap", repeatFrequency);
		mav.addObject("lecturerMap", lecturer);
		mav.addObject("venueMap", venue);
		return mav;
	}

	@RequestMapping(value="/confirmCreate")
	public ModelAndView processNewTS(@ModelAttribute TeachingSession ts) {
		//logger.info(ts.toString());
		sessions.add(ts);
		//logger.info(sessions.get(0).toString());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateNewTeachingSessionConfirm");

		modelAndView.addObject("ts", ts);

		return modelAndView;
	}
	@RequestMapping(value="/AdminMenu")
	public String redirectAdminMenu(Model model)
	{
		return "AdminMenu";
	}
	@RequestMapping(value="/ChooseTimetable")
	public ModelAndView ChooseTimetable() {
		ModelAndView mav = new ModelAndView("ChooseTimetable", "tth", new TimeTableHolder());

		//Map<Timetable, String> timetableMap = new HashMap<Timetable, String>();
		Map<String, String> timetableMap = new TreeMap<String, String>();
		Iterator<Timetable> timetableIterator = timetables.iterator();

		while(timetableIterator.hasNext())
		{
			Timetable timetable = timetableIterator.next();
			//timetableMap.put(timetable, timetable.getTitle());
			timetableMap.put(timetable.getTitle(), timetable.getTitle());
		}

		//logger.info(timetableMap.toString());
		mav.addObject("timetableMap", timetableMap);
		//mav.addObject("timetableMap", lecturer);
		//mav.addObject("venueMap", venue);
		return mav;
	}		
	@RequestMapping(value="/AddSession")
	public ModelAndView AddTeachingSession(@ModelAttribute TimeTableHolder tth) {
		timetableGlobal = null;
		for (Timetable tt : timetables) 
		{
			if(tt.getTitle().equals(tth.getTimetableTitle()))
			{
				timetableGlobal = tt;
				break;
			}
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("TestTimetable");

		mav.addObject("timetable", timetableGlobal);
		return mav;
	}

	@RequestMapping(value="/AddTeachingSession")
	public ModelAndView AddTeachingSession() {
		//logger.info(timetableGlobal.toString());

		ModelAndView mav = new ModelAndView("AddTeachingSession", "tsh", new TeachingSessionHolder());

		Map<String, String> tsMap = new HashMap<String,String>();
		//Map<TeachingSession, String> tsMap = new HashMap<TeachingSession, String>();
		for (TeachingSession ts : sessions) 
		{
			tsMap.put(ts.getTitle(), ts.getTitle()+" "+ ts.getStartDate() + " " + ts.getStartTime());
			//			tsMap.put(ts, ts.getTitle()+" "+ ts.getStartDate() + " " + ts.getStartTime());
		}

		//logger.info(tsMap.toString());
		mav.addObject("tsMap", tsMap);
		//mav.addObject("timetableMap", lecturer);
		//mav.addObject("venueMap", venue);
		return mav;
	}		
	/*@RequestMapping(value="/AddSession2")
	public ModelAndView AddTeachingSession2(@ModelAttribute Timetable tt) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("TestTimetable");

		mav.addObject("timetable", tt);
		return mav;
	}*/
	@RequestMapping(value="/AddSession2")
	public ModelAndView AddTeachingSession2(@ModelAttribute TeachingSessionHolder tsh) {

		TeachingSession tstemp = null;
		for (TeachingSession ts : sessions) 
		{
			if(ts.getTitle().equals(tsh.getTitle()))
			{
				tstemp = ts;
			}

		}
		timetableGlobal.addTeachingSession(tstemp);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("TestTimetable");

		mav.addObject("timetable", timetableGlobal);
		return mav;
	}

	/*@RequestMapping(value="/AddSession")
	public ModelAndView AddTeachingSession(@ModelAttribute TimeTableHolder tth) {


		ModelAndView mav = new ModelAndView();
		mav.setViewName("TestTimetable");

		mav.addObject("timetable", tth.getTimetableTitle());
		return mav;
	}*/

	/*@RequestMapping(value="/CreateSession")
	public String createNewTS(@ModelAttribute TeachingSession ts) {
		logger.info(ts.toString());
		sessions.add(ts);
		logger.info(sessions.get(0).toString());
		return "/AdminMenu";
	}*/

	@RequestMapping("/NewTeachingSession")
	public String NewTeachingSession(Model model)
	{
		return "NewTeachingSession";
	}

	/*@RequestMapping("/NewTeachingSessionSubmit")
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
		return "redirect:/NewTeachingSessionConfirm";
	}*/

	/*@RequestMapping(value = "/NewTeachingSessionConfirm", method = RequestMethod.POST)
	public String list(ModelMap model) {
		logger.info("Listing session");
		TeachingSession ts = new TeachingSession("test1",
												 "12/12/2013", 
												 "1000", 
												 3.0, 
												 3, 
												 "Tan", 
												 10, 
												 true, 
												 "lab");
		logger.info(ts.toString());
		model.put("ts",ts);
		return "NewTeachingSessionConfirm";
	}*/


}
