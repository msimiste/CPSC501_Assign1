package unitTests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import workingFiles.IOUtility;

public class convertStringToDateTest {
	
	@Test
	public void testConvertToDate(){
		Date date = null;
		Date convertedDate =null;
		Calendar c = Calendar.getInstance();
		
		DateFormat d = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
		d.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		c = d.getCalendar();
		c.set(Calendar.YEAR, 2016);
		c.set(Calendar.MONTH, Calendar.JUNE);
		c.set(Calendar.DAY_OF_MONTH, 04);
		c.set(Calendar.HOUR_OF_DAY, 18);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.ZONE_OFFSET, 0);
		
		date = c.getTime();		
		
		String dateAsString = "Sat, 04 June 2016 18:00:00 GMT";
		
		IOUtility IO = new IOUtility();
		
		convertedDate = IO.convertToDate(dateAsString);
		
		assertEquals(date,convertedDate);
	}
}
