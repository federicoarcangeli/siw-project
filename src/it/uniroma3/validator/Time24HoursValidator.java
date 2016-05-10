package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time24HoursValidator{

	private Pattern pattern;
	private Matcher matcher;
	private  DateFormat formatter;

	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public Time24HoursValidator(){
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		formatter= new SimpleDateFormat("hh:mm");
	}

	/**
	 * Validate time in 24 hours format with regular expression
	 * @param time time address for validation
	 * @return true valid time fromat, false invalid time format
	 */
	public Date validate(String time){
		Date ora=null;

		matcher = pattern.matcher(time);
		if (matcher.matches())
			try {
				ora= formatter.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return ora;
			


	}
}