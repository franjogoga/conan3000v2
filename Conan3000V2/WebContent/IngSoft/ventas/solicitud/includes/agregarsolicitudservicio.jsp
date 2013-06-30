<%@page import="java.util.Vector"%>			 
<%@page import="java.text.SimpleDateFormat"%>
<script>	
function alt_submit(){
		var form= document.frmServicio;
		if(validaForm()) form.submit();
			
}

function alt_submit2(){
		var form= document.frmServicio;
		if(1) form.submit();
			
}
		 
function anhadir(cod,name){
	var form=document.frmServicio;
	form.idServicio.value=cod;
	form.txtServicio.value=name;
	$.fn.colorbox.close();
}
</script>			 
		
		<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>	 
			  <!-- content starts -->
			    <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		       <li>Agregar Solicitud de Servicio</li>
	          </ul>
		      </div>  
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>SOLICITUD DE SERVICIO</h2>
		          </div>
			      <div class="box-content">
			      
			      <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVProducto")%>">
						  <input type="hidden" name="accion" value="Ver Detalle"/></input>
			      </form>
			      
			      
			      
			      
			        <form class="form-horizontal" name="frmServicio"  method="Post"  action="SMVSolicitudServicio">
			        <input type="hidden" name="accion" value="Agregar"></input>
			            
			 		<input type="hidden" name="codigo" value=""></input>
			 		<input type="hidden" name="tipo" value="1"></input>
			        
			        
			          <fieldset>
			          
			           <div class="control-group" id="dvServicio">
			                <label class="control-label" for="typeahead9">Servicio(*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtServicio"  name="txtServicio" data-provide="typeahead" data-items="4" >
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../servicioproveedor/seleccionarservicio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Servicio</a> </div>
		                        <span class="help-inline" id="errServicio">Please correct the error</span>
		                    </div>
		                  </div>
			         			         
						<div class="control-group" id="dvPeriodo">
			                <label class="control-label" for="typeahead4">Periodo(*):</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtPeriodo"  name="txtPeriodo" data-provide="typeahead" data-items="4" >
		                        <span class="help-inline" id="errPeriodo">Please correct the error</span>
		                    </div>
		                  </div>
		                  
		                          			          
			            <div class="form-actions">
			              <input type="hidden" name="idServicio" value=""/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
			             <button type="button" class="btn" onclick="location.href='agregarsolicitudservicio.jsp'">Cancelar</button>
			             <button type="button" class="btn btn-primary">Ver Detalle</button>
		                </div>
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
		      <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVProveedor")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
		      
		      
			  <div class="row-fluid sortable">
			    <!--/span-->
			    
                <%-- <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>DETALLE</h2>
		          </div>
		          
			      <div class="box-content">
			      <table class="table table-striped table-bordered bootstrap-datatable datatable" >
					    <!-- agregar nuevo boton -->
					    <div  align="right">
					     <a class="btn btn-primary" href="javascript:alt_generar()"> <i class="icon icon-add icon-white"></i> Generar </a> 
					     </div>
					     
					    <thead>
					      <tr>
					        <th>Servicio</th>
					        <th>Precio</th>
					        
					        <th>Periodo</th>
					         <th>Subtotal</th>

				          </tr>
				          
				        </thead>
				        
				        <element>
					    <tbody id="resultadobusqueda">
					    
					    <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
                         
					      <tr>
					        
					        <td class="center">
                          				<%=
                          					
                          				%>
                          </td>
                          
                          
					        
					       <td class="center">
                          				<%=
                          					
                          				%>
                          </td>
                          
                          
                          
                      <td class="center">
                          				<%=
                          					
                          				%>
                          </td>
                            <td class="center">
                          				<%=
                          					
                          				%>
                          </td>

                          
                          	</tr>
                          	
					        <%}%>
					       </tbody>
					       </element>
					       </table>     
                  </div>
				</div><!--/span--> --%>
				
				
			</div><!--/row-->
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 

		  
       
					<!-- content ends -->
