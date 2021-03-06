package com.psd3.ge1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



public class Timetable 
{
	private String title;
	
	
	private List<TeachingSession> teachingSessions;
	
	private List<User> studentsList;
	

	
	public Timetable(String title, List<TeachingSession> teachingSessions,
			List<User> studentsList) {
		super();
		this.title = title;
		this.teachingSessions = teachingSessions;
		this.setStudentsList(studentsList);
	}
	public Timetable()
	{
		teachingSessions = new ArrayList<TeachingSession>();
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
	public void addTeachingSession(TeachingSession ts) {
		this.teachingSessions.add(ts);
	}
	public List<User> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(List<User> studentsList) {
		this.studentsList = studentsList;
	}
	public void addStudent(User student) {
		this.studentsList.add(student);
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
