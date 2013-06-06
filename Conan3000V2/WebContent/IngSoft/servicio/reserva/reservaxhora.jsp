<%@page import="IngSoft.servicio.bean.ReservaCanchaMiniBeanData"%>
<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="fI" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="reservas" scope="session"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="pendientes" scope="session"class="java.lang.String"></jsp:useBean>

<%Date fecIni=fI; %>
<div id="tabs">
   
</div>
<form name="frmAlternativo" id="frmAlternativo">
<input type="hidden" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(fecIni)%>" name="fecIni" id="fecIni">
<input type="hidden" value="<%=(String)pendientes%>" name="pendientes" id="pendientes">
</form>

<%!int step=60;
  String horaIni="07:00";
  String horaFin="15:00";
  String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
  SimpleDateFormat DF=new SimpleDateFormat("dd/MM");
  SimpleDateFormat DFT=new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat DFI=new SimpleDateFormat("yyyy/MM/dd");
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

<%
int j=0;
int k=0;
int indIni=0;
int a= reservas.size();
String Cancha=null;
boolean esnull=false;

while(j<a){ 
String codActual= ((ReservaCanchaMiniBeanData)reservas.get(j)).getCodigoCancha();
if(Cancha==null|| !Cancha.equals(codActual)){
indIni=j;
k++;
esnull=false;
%>
<div id="tabs-<%=k%>" class="tabs" style="display:<%=k>1?"none":"inline"%>;">
<table class="table table-striped table-bordered bootstrap-datatable datatable">
						 <thead>
							  <tr>
							  <th>Horas</th>
							  <%
							  for(int i=0;i<dias.length;i++){%>								  
								  <th><%=dias[i]+" "+DF.format(Utils.fechaMas(fecIni, i)) %></th>
                                  <%}%>
							  </tr>
						  </thead>
						       
						  <tbody>
<%}%>			
						<%if(((ReservaCanchaMiniBeanData)reservas.get(j)).getFecha()==null && !esnull) 
							esnull=true;
							if(esnull){
								String hora=horaIni;
							while(true){
								if(hora.compareTo(horaFin)>=0)break;
								%>
								<tr>
								<td><%=hora%>-<%=addHora(hora)%></td>
								<%for(int l=0;l<dias.length;l++){								
								%>
								<td class="center">
									<a id="<%=codActual%><%=DFT.format(Utils.fechaMas(fecIni, l))%><%=hora%>" 
									class="btn btn-success" 
									onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;                                
									</a>									
								</td>
								<%							
							}
							hora=addHora(hora);}
							}
							else{
								String hora=horaIni;
							while(true){
								j=indIni;
								if(hora.compareTo(horaFin)>=0)break;
								String temp= DFI.format(((ReservaCanchaMiniBeanData)reservas.get(j)).getFecha());								
								String HRI=((ReservaCanchaMiniBeanData)reservas.get(j)).getHoraIni();
								String HRF=((ReservaCanchaMiniBeanData)reservas.get(j)).getHoraFin();
								boolean test=false;								
								%>
								<tr>
								<td><%=hora%>-<%=addHora(hora)%></td>
								<%for(int l=0;l<dias.length;l++){
									test=((DFI.format(Utils.fechaMas(fecIni, l)).compareTo(temp)==0)&&(HRI.compareTo(hora))==0)&&(!esnull);																											
								%>
								<td class="center">
									<a id="<%=codActual%><%=DFT.format(Utils.fechaMas(fecIni, l))%><%=hora%>" 
									<%if(test){%>
									class="btn btn-danger" 
									onclick="javascript:cambiarClase(this)">									
										<i class="icon-remove icon-white"></i>  
										Reservado
									<%}
									else{ %>
									class="btn btn-success" 
									onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;
									<%} %>	                                
									</a>									
								</td>
								<%	
								if(test && !esnull){
										test=false;
										HRI=addHora(HRI);
										if(HRI.compareTo(HRF)>=0) {
												((ReservaCanchaMiniBeanData)reservas.get(j)).setHoraIni(HRI);
												reservas.remove(j);
										}
										else{											
											j++;											
										}
										if(j>=reservas.size() || !((ReservaCanchaMiniBeanData)reservas.get(j)).getCodigoCancha().equals(codActual)){
										if(j==indIni)esnull=true;
										j--;
										
										}
										else{
										 temp= DFI.format(((ReservaCanchaMiniBeanData)reservas.get(j)).getFecha());
										 HRI=((ReservaCanchaMiniBeanData)reservas.get(j)).getHoraIni();
										 HRF=((ReservaCanchaMiniBeanData)reservas.get(j)).getHoraFin();
										 } 	
																				
								 	}						
							}																					
							hora=addHora(hora);}
								}%>
								
					
						  </tbody>
					  </table> 
</div>
<%j++;
}
%>
<div id="temptabs">
<p class="btn-group">
<%if(k==1){%>
 <button class="btn tabsSel" data-tabs="tabs-1" onclick="cambiar($(this))" disabled="disabled">cancha 1</button>
 <%} else
 for(int i=1;i<=k;i++){ %>
  <button class="btn tabsSel" data-tabs="tabs-<%=i%>" onclick="cambiar($(this))" <%=i==1?"disabled='disabled'":""%>>cancha <%=i%></button>  
  <%} %>
  </p>    
</div>
<script>
var htmltemp=$('#temptabs').html();
$('#temptabs').html('');
$('#tabs').html(htmltemp);
</script>

<%if(reservas.size()>0){ %>					  
					  <div align="center">
<!--  <button class="btn">Anterior</button><button class="btn" style="position:absolute;
left: 48%">Hoy</button><button class="btn" style="position: absolute;
right:11px">Siguiente</button>-->

<button class="btn" onclick="ajax_submit('4')"><i class="icon-chevron-left"></i>Anterior</button>
<button class="btn">Actual</button>
<button class="btn" onclick="ajax_submit('3')">Siguiente<i class="icon-chevron-right"></i></button>
</div>
<%}%>