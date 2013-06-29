<%@page import="IngSoft.servicio.bean.EventoBeanData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
								  <th>Tipo Solicitud</th>
							        <th>Nombre Evento</th>
							        <th>Fecha</th>
							        <th>Sede</th>
							        <th>Estado</th>												        							      							       
							        <th>Acción</th>
							
							  </tr>
						  </thead>
                          <element>
                          	<tbody >
<% SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                          		%>
                          		<tr>
                          			<td>
                          			<%String codmin =((EventoBeanData)resultados.get(i)).getCodigo().substring(0, 3);%>
                          				<%=
                          					(codmin.equals("ESD")?"Evento Sede":"")+(codmin.equals("ESC")?"Evento Socio":"")+(codmin.equals("ECP")?"Evento Corporativo":"")
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((EventoBeanData)resultados.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((EventoBeanData)resultados.get(i)).getFecha())
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((EventoBeanData)resultados.get(i)).getIdSede() //guarda nombre de sede                 
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((EventoBeanData)resultados.get(i)).getEstado()                  
                          				%>
                          			</td>

                          			<td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((EventoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
											<%=((EventoBeanData)resultados.get(i)).getEstado().equals("REGISTRADO")?"Revisar":"Ver" %>
                          				</a>
                          				
                          				<%if(((EventoBeanData)resultados.get(i)).getEstado().equals("REGISTRADO") && !(codmin.equals("ESD"))){ %>
                          				<!--  <a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((EventoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 											Modificar
                          				</a>-->
                          				<%}
                          				else if (codmin.equals("ESD")){ %>
                          				    <a class="btn btn-info"
                          					href="javascript:alt_registrar('<%=((EventoBeanData)resultados.get(i)).getCodigo()%>',$(this))">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 										Registrar
                          				</a>
                          				<%} %>
                          			</td>
                          		</tr>


                          		<%}%>
                          		 	</tbody>
                          </element>
                        </table> 
                      
                        