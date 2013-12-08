package com.psd3.ge1;

public class TimeTableHolder {
	private Timetable timetable;
	private String timetableTitle;
	public TimeTableHolder()
	{
		timetable = new Timetable();
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	public String getTimetableTitle() {
		return timetableTitle;
	}

	public void setTimetableTitle(String timetableTitle) {
		this.timetableTitle = timetableTitle;
	}

}
