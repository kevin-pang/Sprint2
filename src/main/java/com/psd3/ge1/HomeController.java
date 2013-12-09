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
	List<TeachingSession> lecturerSessionGlobal;
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
		timetables.add(new Timetable("CS Year 1", new ArrayList<TeachingSession>(), new ArrayList<User>()));
		timetables.add(new Timetable("CS Year 2", new ArrayList<TeachingSession>(),new ArrayList<User>()));
		timetables.add(new Timetable("CS Year 3", new ArrayList<TeachingSession>(),new ArrayList<User>()));
		timetables.add(new Timetable("CS Year 4", new ArrayList<TeachingSession>(),new ArrayList<User>()));

		sessions.add(new TeachingSession("PSD1", "12/12/2013", "1000", 3.0, "Weekly", "TanCC", 10, true, "lab"));
		sessions.add(new TeachingSession("PL1", "15/12/2013", "1000", 3.0, "Weekly", "KohKK", 10, true, "lab"));
		int i = 1;
		for (Timetable tt : timetables) {
			for (TeachingSession ts : sessions) {
				tt.addTeachingSession(ts);
			} 
			tt.addStudent(new User("student"+i,"student"+i));
			i++;

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


	@RequestMapping("/login2Submit")
	public String login2(@ModelAttribute User user)
	{		
		timetableGlobal = null;
		lecturerSessionGlobal = new ArrayList<TeachingSession>();

		if(user.getUsername().toLowerCase().equals("admin")) {
			return "/AdminMenu";
		}
		
		for(int x = 0; x < sessions.size(); x++)
		{
			if(sessions.get(x).getLecturer().replaceAll("\\s+","").toLowerCase().equals(user.getUsername().replaceAll("\\s+","").toLowerCase()))
			{
				lecturerSessionGlobal.add(sessions.get(x));
			}
		}
		
		if(lecturerSessionGlobal.size() != 0)
		{
			return "redirect:populateTimetableLecturer";
		}
		
		for(int i = 0; i < timetables.size(); i++)
		{			
			for (User student : timetables.get(i).getStudentsList()) 
			{
				if(student.getUsername().replaceAll("\\s+","").toLowerCase().equals(user.getUsername().replaceAll("\\s+","").toLowerCase()))
				{
					timetableGlobal = timetables.get(i);
					return "redirect:populateTimetable";
				}
			}
		}
		
		return "login2";
	}
	@RequestMapping("populateTimetable")
	public ModelAndView populateTimetable()
	{
		return new ModelAndView("ViewTimetable", "tt", timetableGlobal);
	}
	
	@RequestMapping("populateTimetableLecturer")
	public ModelAndView populateTimetableLecturer()
	{
		return new ModelAndView("LecturerViewTimetable", "teachSessions", lecturerSessionGlobal);
	}
	
	@RequestMapping(value="/CreateNewTeachingSessionForm")
	public ModelAndView createNewTeachingSession() {
		ModelAndView mav = new ModelAndView("CreateNewTeachingSession", "ts", new TeachingSession());
	
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
		
		for (TeachingSession ts : sessions) 
		{
			if(!timetableGlobal.getTeachingSessions().contains(ts))
				tsMap.put(ts.getTitle(), ts.getTitle()+" "+ ts.getStartDate() + " " + ts.getStartTime());
			
		}

		mav.addObject("tsMap", tsMap);
		return mav;
	}		

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
		if(tstemp != null)
			timetableGlobal.addTeachingSession(tstemp);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("TestTimetable");

		mav.addObject("timetable", timetableGlobal);
		return mav;
	}



	@RequestMapping("/NewTeachingSession")
	public String NewTeachingSession(Model model)
	{
		return "NewTeachingSession";
	}	


}
