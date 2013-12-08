package com.psd3.ge1;

import java.util.ArrayList;
import java.util.List;



public class Timetable 
{
	private String title;
	
	
	private List<TeachingSession> teachingSessions;
	
	public Timetable()
	{
		teachingSessions = new ArrayList<TeachingSession>();
	}
	public Timetable(String title, List<TeachingSession> teachingSessions) {
		super();
		this.title = title;
		this.teachingSessions = teachingSessions;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<TeachingSession> getTeachingSessions() {
		return teachingSessions;
	}
	public void setTeachingSessions(List<TeachingSession> teachingSessions) {
		this.teachingSessions = teachingSessions;
	}
}
