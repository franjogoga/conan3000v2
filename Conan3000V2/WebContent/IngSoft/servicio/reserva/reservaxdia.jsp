<%@page import="IngSoft.servicio.bean.ReservaBungalowMiniBeanData"%>
<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="fI" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="reservas" scope="session"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="pendientes" scope="session"class="java.lang.String"></jsp:useBean>

<%Date fecIni=fI; %>

<form name="frmAlternativo" id="frmAlternativo">
<input type="hidden" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(fecIni)%>" name="fecIni" id="fecIni">
<input type="hidden" value="<%=(String)pendientes%>" name="pendientes" id="pendientes">
</form>
<br/>
<table class="table table-striped table-bordered bootstrap-datatable datatable">
<%! 	
	String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
   SimpleDateFormat DF=new SimpleDateFormat("dd/MM/yyyy");
   SimpleDateFormat inv=new SimpleDateFormat("yyyy/MM/dd");   
 %>	
						  <thead>
							  <tr>
							  <th>Horas</th>
							  <% 
							  for(int i=0;i<dias.length;i++){%>								  
								  <th><%=dias[i]+" "+DF.format(Utils.fechaMas(fecIni, i)).substring(0, 5) %></th>
                                  <%}%>
							  </tr>
						  </thead>   
						  <tbody>
							
							<% 				
							String Bungalow=null;
							boolean esnull=false;
							int k=0;			
							for (int j=0;j<reservas.size();j++){ 
								String codActual= ((ReservaBungalowMiniBeanData)reservas.get(j)).getCodigoBungalow();
								if(Bungalow==null || !Bungalow.equals(codActual)){
								Bungalow=codActual;
								esnull=false;
								k=0;%>						
							<tr>
								<td>Bungalow <%=((ReservaBungalowMiniBeanData)reservas.get(j)).getNombreBungalow()%></td>
								<%}
								 if(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha()==null && !esnull){
								 esnull=true;
								 for(int i=0;i<dias.length;i++) {%>
								<td class="center">
									<a id="<%=codActual%><%=DF.format(Utils.fechaMas(fecIni, i))%>" 
									name="<%=codActual%><%=DF.format(Utils.fechaMas(fecIni, k))%>"
									class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                      
								</a>										
								</td>
								<%}}
								else if(!esnull){
									String temp= inv.format(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha());
									boolean test=false;
									for(int i=0;i<dias.length;i++)
								 	//while(inv.format(Utils.fechaMas(fecIni, k)).compareTo(temp)<=0)
								 	{					
								 	test=inv.format(Utils.fechaMas(fecIni, k)).compareTo(temp)==0;			 	
								 	%>
								 	<td class="center">
									<a id="<%=codActual%><%=DF.format(Utils.fechaMas(fecIni, k))%>" 
									name="<%=codActual%><%=DF.format(Utils.fechaMas(fecIni, k))%>"
									class="btn <%=test?"btn-danger":"btn-success"%>" onclick="javascript:cambiarClase(this)">
										<i class="icon-<%=test?"remove":"ok"%> icon-white"></i>
										<%=test?"Reservado":"Reservar&nbsp;&nbsp;&nbsp;&nbsp;"%>  										                                      
									</a>										
									</td>
								 	<%k++;
								 	if(test){
										test=false;
										j++;										
										if(j>=reservas.size() || !((ReservaBungalowMiniBeanData)reservas.get(j)).getCodigoBungalow().equals(codActual)) j--;
										else temp= inv.format(((ReservaBungalowMiniBeanData)reservas.get(j)).getFecha()); 	
								 	}
								 	}	
									
								}
								%>
								
							</tr>
							<%} %>			
						  </tbody>				  					
					  </table> 
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