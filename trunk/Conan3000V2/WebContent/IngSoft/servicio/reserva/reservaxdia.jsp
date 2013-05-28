<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="fA" scope="request"class="java.util.Date"></jsp:useBean>
<jsp:useBean id="fI" scope="request"class="java.util.Date"></jsp:useBean>
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