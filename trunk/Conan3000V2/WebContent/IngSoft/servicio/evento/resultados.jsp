<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.servicio.bean.ResultadoEventoBeanData"%>
<%@page import="java.util.Vector"%>

<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

<table id="mytable" class="table table-striped table-bordered bootstrap-datatable datatable">
                            <!-- agregar nuevo boton -->
                            
                            
                            <div align="right">
                            
                                <a class="btn btn-primary" href="javascript:alt_agregar()">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
                              
                             </div>          
                          <thead>
							  <tr>
								  <th>Tipo Evento</th>
							        <th>Nombre Evento</th>
							        <th>Limite de incio (d&iacutea/mes)</th>
							        <th>Limite de fin (d&iacutea/mes)</th>
												        							      							        
							        <th>Acción</th>
							
							  </tr>
						  </thead>
                          <element>
                          	<tbody >
<% SimpleDateFormat df= new SimpleDateFormat("dd/MM"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                          		%>
                          		<tr>
                          			<td>
                          				<%=
                          					((ResultadoEventoBeanData)resultados.get(i)).getTipo()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((ResultadoEventoBeanData)resultados.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((ResultadoEventoBeanData)resultados.get(i)).getLimInicio())
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((ResultadoEventoBeanData)resultados.get(i)).getLimFin())                  
                          				%>
                          			</td>

                          			<td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoEventoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoEventoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoEventoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          		</tr>


                          		<%}%>
                          		 	</tbody>
                          </element>
                        </table> 
                      
                        