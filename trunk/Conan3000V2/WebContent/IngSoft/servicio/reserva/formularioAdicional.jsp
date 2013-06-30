<%@page import="IngSoft.servicio.bean.ServicioAdicionalBeanData"%>	
<jsp:useBean id="adicionales" scope="request" class="java.util.Vector"></jsp:useBean>			

							<%if(adicionales.size()<=0){ %>
No hay servicios adicionales DISPONIBLES
<%} else{ %>

<table id="mytable" class="table table-striped table-bordered bootstrap-datatable datatable" width="100%">                                                        
                          <thead>
							  <tr>
								  <th>Nombre</th>
							        <th>Descripcion</th>
							        <th>Monto</th>							               							      							        
							        <th>Acción</th>
							
							  </tr>
						  </thead>
                          <element>
                          	<tbody >
<% 
                          			for(int i=0;
                          			i<adicionales.size();i++){
                          		%>
                          		<tr>                          		
                          			<td class="center">
                          				<%=
                          					((ServicioAdicionalBeanData)adicionales.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((ServicioAdicionalBeanData)adicionales.get(i)).getDescripcion()                  
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((ServicioAdicionalBeanData)adicionales.get(i)).getMonto()                  
                          				%>
                          			</td>

                          			<td class="center">
                          			<%if(((ServicioAdicionalBeanData)adicionales.get(i)).getRegistrado().equals("NO")){ %>
                          				<button class="btn btn-success" id="<%=((ServicioAdicionalBeanData)adicionales.get(i)).getCodigo()%><%=((ServicioAdicionalBeanData)adicionales.get(i)).getMonto()%>"
                          					onclick="javascript:CambiarEstadoAdicional($(this))">
                          					<i class="icon-zoom-in icon-white">
                          					</i>Agregar
                          				</button>   
                          				<%}else if(((ServicioAdicionalBeanData)adicionales.get(i)).getRegistrado().equals("SI")){ %>
                          				<button class="btn btn-danger">
                          					<i class="icon-zoom-in icon-white">
                          					</i>Agregado
                          				</button> 
                          				<%} %>                       				
                          			</td>
                          		</tr>


                          		<%}%>
                          		 	</tbody>
                          </element>
                        </table> 
                        <%}%>
							  	