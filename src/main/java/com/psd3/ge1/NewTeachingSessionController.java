package com.psd3.ge1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application New Teaching Session page.
 */
@Controller
public class NewTeachingSessionController {
	
	@RequestMapping(value = "/createSession", method = RequestMethod.GET)
	public String session(Model model)
	{
		return "NewTeachingSession";
	}

}
