package com.psd3.ge1;

import java.lang.reflect.Field;

public class TeachingSession {
	private String title;
	private String startDate;
	private String startTime;
	private double duration;
	private String repeatFrequency;
	private String lecturer;
	private int maxAttendance;
	private boolean compulsory;
	private String venue;

	public TeachingSession(String title, String startDate, String startTime,
			double duration, String repeatFrequency, String lecturer,
			int maxAttendance, boolean compulsory, String venue) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
		this.repeatFrequency = repeatFrequency;
		this.lecturer = lecturer;
		this.maxAttendance = maxAttendance;
		this.compulsory = compulsory;
		this.venue = venue;
	}
	
	public TeachingSession()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getRepeatFrequency() {
		return repeatFrequency;
	}

	public void setRepeatFrequency(String repeatFrequency) {
		this.repeatFrequency = repeatFrequency;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getMaxAttendance() {
		return maxAttendance;
	}

	public void setMaxAttendance(int maxAttendance) {
		this.maxAttendance = maxAttendance;
	}

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		result.append( this.getClass().getName() );
		result.append( " Object {" );
		result.append(newLine);
		//determine fields declared in this class only (no fields of superclass)
		Field[] fields = this.getClass().getDeclaredFields();
		//print field names paired with their values
		for ( Field field : fields ) {
			result.append(" ");
			try {
				result.append( field.getName() );
				result.append(": ");
				//requires access to private field:
				result.append( field.get(this) );
			} catch ( IllegalAccessException ex ) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");
		return result.toString();
	}

}
