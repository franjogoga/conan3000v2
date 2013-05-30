<%@page import="IngSoft.servicio.bean.ReservaBungalowMiniBeanData"%>
<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="fA" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="fI" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="reservas" scope="session"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="pendientes" scope="session"class="java.lang.String"></jsp:useBean>

<%Date fecIni=fI==null?Utils.fechaMenos(fA,Integer.valueOf( Integer.valueOf( new SimpleDateFormat("uu").format(fA)).intValue()-1)):fI; %>
<div align="center">
<!--  <button class="btn">Anterior</button><button class="btn" style="position:absolute;
left: 48%">Hoy</button><button class="btn" style="position: absolute;
right:11px">Siguiente</button>-->
<button class="btn" onclick="ajax_submit('4')"><i class="icon-chevron-left"></i>Anterior</button>
<button class="btn">Actual</button>
<button class="btn" onclick="ajax_submit('3')">Siguiente<i class="icon-chevron-right"></i></button>
</div>
<form name="frmAlternativo" id="frmAlternativo">
<input type="hidden" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(fecIni)%>" name="fecIni" id="fecIni">
</form>
<br/>
<table class="table table-striped table-bordered bootstrap-datatable datatable">
<%! 
	String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
   SimpleDateFormat DF=new SimpleDateFormat("dd/MM");   
 %>	
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
							
							<% 				
							String Bungalow=null;
							boolean esnull=false;
							int k=0;			
							for (int j=0;j<reservas.size();j++){ 
								if(Bungalow==null || Bungalow.equals(((ReservaBungalowMiniBeanData)reservas.get(j)).getCodigoBungalow())){
								esnull=false;
								k=0;%>						
							<tr>
								<td>Bungalow <%=((ReservaBungalowMiniBeanData)reservas.get(j)).getNombreBungalow()%></td>
								<%}
								 if(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha()==null && !esnull){
								 esnull=true;
								 for(int i=0;i<dias.length;i++) {%>
								<td class="center">
									<a id="<%=((ReservaBungalowMiniBeanData)reservas.get(j)).getCodigoBungalow()%><%=DF.format(Utils.fechaMas(fecIni, i))%>" class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                      
								</a>										
								</td>
								<%}}
								else if(!esnull){
									
								 	while(Utils.fechaMas(fecIni, k).equals(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha())||Utils.fechaMas(fecIni, k).before(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha())){								 	
								 	%>
								 	<td class="center">
									<a id="<%=((ReservaBungalowMiniBeanData)reservas.get(j)).getCodigoBungalow()%><%=DF.format(Utils.fechaMas(fecIni, k))%>" class="btn <%=Utils.fechaMas(fecIni, k).equals(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha())?"btn-inverse":"btn-success"%>" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>
										<%=Utils.fechaMas(fecIni, k).equals(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha())?"Pendiente":"Reservar&nbsp;&nbsp;&nbsp;&nbsp;"%>  										                                      
									</a>										
									</td>
								 	<%k++;
								 	}	
									
								}
								%>
								
							</tr>
							<%} %>			
						  </tbody>
					  </table> 