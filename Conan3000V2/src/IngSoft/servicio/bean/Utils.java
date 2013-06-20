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
	   
	   public static String addHora(String hora,int step){
		 	try{
		 	//System.out.println(hora);
		 	String arr[]= hora.split(":");
		 	//System.out.println(arr.toString());
		 	int hh= Integer.parseInt(arr[0]);
		 	int mm= Integer.parseInt(arr[1]);
		 	mm=mm+step;
		 	if(mm>=60) hh=hh+mm/60;
		 	mm=mm%60;
		 	String resultado=""; 
		 	String temp=String.valueOf(hh);
		 	temp=temp.length()>1?temp:"0"+temp;
		 	resultado=resultado+temp+":";
		 	temp=String.valueOf(mm);
		 	temp=temp.length()>1?temp:"0"+temp;
		 	resultado=resultado+temp;
		 	return resultado;
		 	}
		 	catch(Exception e){
		 	return null;} 
	   }
	   
	   public static String generaSiguienteCodigo(String actual){
		   String next=null;
		   if(Integer.parseInt(actual.substring(3))>0){
				int cod= Integer.parseInt(actual.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
				
				next= actual.substring(0,3).concat(temp);
				}
				else next=actual.substring(0, 3).concat("000001");
		   return next;		   
	   }
}
