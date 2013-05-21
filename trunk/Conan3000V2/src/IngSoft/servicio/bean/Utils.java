package IngSoft.servicio.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	
	public static java.util.Date fechaMas(java.util.Date fch, int dias){ 
	     Calendar cal = new GregorianCalendar(); 
	     cal.setTimeInMillis(fch.getTime()); 
	     cal.add(Calendar.DATE, dias); 
	     return new Date(cal.getTimeInMillis()); 
	   } 

	   public static java.util.Date fechaMenos(java.util.Date fch, int dias){ 
	     Calendar cal = new GregorianCalendar(); 
	     cal.setTimeInMillis(fch.getTime()); 
	     cal.add(Calendar.DATE, - dias); 
	     return new Date(cal.getTimeInMillis()); 
	   }  

}
