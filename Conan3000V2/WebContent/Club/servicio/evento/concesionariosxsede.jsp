<%@page import="IngSoft.servicio.bean.ConcesionarioMiniBeanData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Vector"%>

<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
<%if(resultados.size()<=0){ %>
Esta sede no posee concecionarios DISPONIBLES en la fecha selecionada
<%} else{ %>

<table id="mytable" class="table table-striped table-bordered bootstrap-datatable datatable" width="100%">                                                        
                          <thead>
							  <tr>
								  <th>Razon Social</th>
							        <th>Descripcion</th>							               							      							        
							        <th>Acción</th>
							
							  </tr>
						  </thead>
                          <element>
                          	<tbody >
<% 
                          			for(int i=0;
                          			i<resultados.size();i++){
                          		%>
                          		<tr>                          		
                          			<td class="center">
                          				<%=
                          					((ConcesionarioMiniBeanData)resultados.get(i)).getRazonSocial()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((ConcesionarioMiniBeanData)resultados.get(i)).getDescripcion()                  
                          				%>
                          			</td>

                          			<td class="center">
                          				<button class="btn btn-success" id="<%=((ConcesionarioMiniBeanData)resultados.get(i)).getCodigo()%>"
                          					onclick="javascript:agregarConcesionario($(this))">
                          					<i class="icon-zoom-in icon-white">
                          					</i>Agregar
                          				</button>                          				
                          			</td>
                          		</tr>


                          		<%}%>
                          		 	</tbody>
                          </element>
                        </table> 
                        <%}%>