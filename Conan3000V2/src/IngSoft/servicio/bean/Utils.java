package IngSoft.servicio.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

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
	   public static java.lang.String unir (Vector<java.lang.String> source,String glue,String IO) {
		   int a=source.size();
		   String result="";
		   for(int i=0;i<a;i++){
			   result=result.concat(IO);
			   result=result.concat(source.get(i));
			   result=result.concat(IO);
			   if(i<(a-1)) result=result.concat(glue);
		   }
		   return result;
	   }

}
