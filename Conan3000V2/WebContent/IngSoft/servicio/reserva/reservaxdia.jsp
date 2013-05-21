<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<table class="table table-striped table-bordered bootstrap-datatable datatable">
<%!String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
   SimpleDateFormat DF=new SimpleDateFormat("dd/MM");
   java.util.Date fecIni=Utils.fechaMenos(new java.util.Date(),Integer.valueOf( new SimpleDateFormat("uu").format(new  java.util.Date())).intValue()-1);	
 %>	
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
							
							for (int j=0;j<8;j++){ %>						
							<tr>
								<td>Bungalow <%=j+1%></td>
								<%for(int i=0;i<7;i++) {%>
								<td class="center">
									<a id="<%=DF.format(Utils.fechaMas(fecIni, i))%>" class="btn btn-success" onclick="javascript:cambiarClase(this)">
										<i class="icon-ok icon-white"></i>  
										Reservar&nbsp;&nbsp;&nbsp;&nbsp;                                      
								</a>										
								</td>
								<%}%>
								
							</tr>
							<%} %>			
						  </tbody>
					  </table> 