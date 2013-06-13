<%@page import="java.util.Vector"%>
<%@page import="IngSoft.servicio.bean.ReservaCanchaMiniBeanData"%>
<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="fI" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="reservas" scope="session"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="pendientes" scope="session"class="java.lang.String"></jsp:useBean>
<jsp:useBean id="step" scope="request"class="java.lang.Integer"></jsp:useBean>

<%Date fecIni=fI; %>
<div id="tabs">
   
</div>
<form name="frmAlternativo" id="frmAlternativo">
<input type="hidden" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(fecIni)%>" name="fecIni" id="fecIni">
<input type="hidden" value="<%=(String)pendientes%>" name="pendientes" id="pendientes">
</form>
<%int stepI=step.intValue(); %>
<%!//int step=60;
  String horaIni="07:00";
  String horaFin="15:00";
  String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
  SimpleDateFormat DF=new SimpleDateFormat("dd/MM");
  SimpleDateFormat DFT=new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat DFI=new SimpleDateFormat("yyyy/MM/dd");
 public String addHora(String hora,int step){
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
//int a= reservas.size();
String Cancha=null;
boolean esnull=false;
Vector<ReservaCanchaMiniBeanData> reservasV= reservas;
while(j<reservasV.size()){ 
String codActual= ((ReservaCanchaMiniBeanData)reservasV.get(j)).getCodigoCancha();
if(Cancha==null|| !Cancha.equals(codActual)){
Cancha=codActual;
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
						<%if(((ReservaCanchaMiniBeanData)reservasV.get(j)).getFecha()==null && !esnull) 
							esnull=true;
							if(esnull){
								String hora=horaIni;
							while(true){
								if(hora.compareTo(horaFin)>=0)break;
								%>
								<tr>
								<td><%=hora%>-<%=addHora(hora,stepI)%></td>
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
							hora=addHora(hora,stepI);}
							reservasV.remove(j);
							}
							else{
								String hora=horaIni;
							while(true){
								j=indIni;
								if(hora.compareTo(horaFin)>=0)break;
								String temp=null;
								String HRI=null;
								String HRF=null;
								if(!esnull){
								temp= DFI.format(((ReservaCanchaMiniBeanData)reservasV.get(j)).getFecha());								
								HRI=((ReservaCanchaMiniBeanData)reservasV.get(j)).getHoraIni();
								HRF=((ReservaCanchaMiniBeanData)reservasV.get(j)).getHoraFin();
								}
								boolean test=false;								
								%>
								<tr>
								<td><%=hora%>-<%=addHora(hora,stepI)%></td>
								<%for(int l=0;l<dias.length;l++){
									test=(!esnull)&&((DFI.format(Utils.fechaMas(fecIni, l)).compareTo(temp)==0)&&(HRI.compareTo(hora))==0);																											
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
										HRI=addHora(HRI,stepI);
										if(HRI.compareTo(HRF)>=0) {												
												reservasV.remove(j);
												reservasV.trimToSize();
										}	
										else{
											((ReservaCanchaMiniBeanData)reservasV.get(j)).setHoraIni(HRI);											
											j++;											
										}
										if(j>=reservasV.size() || !((ReservaCanchaMiniBeanData)reservasV.get(j)).getCodigoCancha().equals(codActual)){
										if(j==indIni)esnull=true;
										//if(j>0)
										j--;
										
										}
										else{
										 temp= DFI.format(((ReservaCanchaMiniBeanData)reservasV.get(j)).getFecha());
										 HRI=((ReservaCanchaMiniBeanData)reservasV.get(j)).getHoraIni();
										 HRF=((ReservaCanchaMiniBeanData)reservasV.get(j)).getHoraFin();
										 } 	
																				
								 	}						
							}																					
							hora=addHora(hora,stepI);}
								}%>
								
					
						  </tbody>
					  </table> 
</div>
<%if(reservasV.size()>0 &&((ReservaCanchaMiniBeanData)reservasV.get(j)).getCodigoCancha().equals(codActual))j++;
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

<%if(k>0){ %>					  
					  <div align="center">
<!--  <button class="btn">Anterior</button><button class="btn" style="position:absolute;
left: 48%">Hoy</button><button class="btn" style="position: absolute;
right:11px">Siguiente</button>-->

<button class="btn" onclick="ajax_submit('4')"><i class="icon-chevron-left"></i>Anterior</button>
<button class="btn">Actual</button>
<button class="btn" onclick="ajax_submit('3')">Siguiente<i class="icon-chevron-right"></i></button>
</div>
<%}%>