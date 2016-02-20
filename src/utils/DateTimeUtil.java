package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	
	private static DateTimeUtil instance=null;
	
	public static DateTimeUtil getInstance(){
		if(instance == null) {
			return new DateTimeUtil();
		} else {
			return instance;
		}
	}
	
	public Date getDate(String dateString) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
