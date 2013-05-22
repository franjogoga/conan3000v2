<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!int step=30;
  String horaIni="07:00";
  String horaFin="15:00";
  
 public String addHora(String hora){
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
 	return horaFin;} 
 }  
  %>
  
<%!String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
   SimpleDateFormat DF=new SimpleDateFormat("dd/MM");
   java.util.Date fecIni=Utils.fechaMenos(new java.util.Date(),Integer.valueOf( new SimpleDateFormat("uu").format(new  java.util.Date())).intValue()-1);	
 %>	
<table class="table table-striped table-bordered bootstrap-datatable datatable">
						 <thead>
							  <tr>
							  <th>Horas</th>
							  <%for(int i=0;i<dias.length;i++){%>								  
								  <th><%=dias[i]+" "+DF.format(Utils.fechaMas(fecIni, i)) %></th>
                                  <%}%>
							  </tr>
						  </thead>     
						  <tbody>
							<%
							String hora=horaIni;
							while(true){
								if(hora.compareTo(horaFin)>=0)break;
								
							%>
							<tr>
								<td><%=hora%>-<%=addHora(hora)%></td>
								
							
								<td class="center">
									<a id="btn1" class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                      
						</a>	

									
								</td>
								<td class="center" align="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
									</a>
								</td>
								<td class="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
								</a>	
								</td>
                                </td>
								<td class="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
									</a>
								</td>
								<td class="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
									</a>
						
								</td>
                                </td>
								<td class="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
									
								</td>
                                
                                </td>
								
								<td class="center">
									<a class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                             
									
								</td>
							</tr>
							<%hora=addHora(hora);} %>
							
							
							
							
						  </tbody>
					  </table> 