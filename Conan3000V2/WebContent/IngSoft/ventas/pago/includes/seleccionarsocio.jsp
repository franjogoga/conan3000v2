<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.venta.bean.ResultadoSocioBeanData"%>
<%@page import="java.util.Vector"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	
	function alt_Insertar(cod,name){
		
		parent.anhadir(cod,name);
	}
	</script>	
	
<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	
			<!-- content starts -->

			<div class="row-fluid sortable">
				
			<!-- content starts -->
			

			
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i>  BUSCAR SOCIO				  </h2>
                        <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
						</div>
                        
                        
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVPago")%>">
						   <input type="hidden" name="accion" value="SeleccionarMembresia"/></input>
						  
						  <fieldset>
						    <div class="control-group">
						    
						     <div class="control-group">
							    <label class="control-label" for="typeahead6">Nombres: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres" data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
						    
							  <div class="control-group">
							    <label class="control-label" for="typeahead6">Apellido Paterno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Apellido Materno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  <div class="control-group">
								<label class="control-label" for="selectError">Tipo de Documento:</label>
								<div class="controls">
								  <select id="cmdTipoDocumento" name="cmdTipoDocumento" data-rel="chosen" >
								  
									<option value="DNI">DNI</option>
									<option value="Carnet de Extranjeria">Carnet de Extranjeria</option>
								
								  </select>
								</div>
							  </div>
                              

						    </div>
						    <div class="form-actions">
						    <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="submit" class="btn"><a href="seleccionarsocio.jsp">Cancelar</a></button>
						    
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->

    
					<!-- content ends -->
			</div><!--/span-->
			
			
			<form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVSocio")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
			  
			  

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>RESULTADOS</h2>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
                        
                     
                           
						  <thead>
							  <tr>
								  <th>Nombres</th>
								  <th>Apellido Paterno</th>
								  <th>Apellido Materno</th>
								  <th>Tipo Documento</th>
								  <th>Numero Documento</th>
								  <th>Accion</th>
							  </tr>
						  </thead>  
						  
						  <element>
					      <tbody id="resultadobusqueda"> 


						  <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                             %>
                             	
							 <tr>
					       
					        
					        
					        <td class="center">
                          				<%=
                          					((ResultadoSocioBeanData)resultados.get(i)).getNombres()

                          				%>
                          	</td>
                          	
                          	 <td class="center">
                          				<%=
                          					((ResultadoSocioBeanData)resultados.get(i)).getApellidoPaterno()

                          				%>
                          	</td>
                          	
                            <td class="center">
                          			<%=
                          					((ResultadoSocioBeanData)resultados.get(i)).getApellidoMaterno()

                          				%>
                          	</td>
                          	
                          	<td class="center">
                          			<%=
                          					((ResultadoSocioBeanData)resultados.get(i)).getTipoDocumento()

                          				%>
                          	</td>
                          	
                          	<td class="center">
                          			<%=
                          					((ResultadoSocioBeanData)resultados.get(i)).getNumeroDocumento()

                          				%>
                          	</td>
                       
                               <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_Insertar('<%=((ResultadoSocioBeanData)resultados.get(i)).getIdSocio()%>','<%= ((ResultadoSocioBeanData)resultados.get(i)).getNombres()+' '+((ResultadoSocioBeanData)resultados.get(i)).getApellidoPaterno()+' '+((ResultadoSocioBeanData)resultados.get(i)).getApellidoMaterno() %>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Seleccionar
                          				</a>
                          				
                          			</td>
                          	</tr>
                          	
					        <%}%>
					       </tbody>
					       </element>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
                
                
                
                
                

			<div class="row-fluid sortable"><!--/span--><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span--><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->
			</div><!--/row-->
    
					<!-- content ends -->
			</div>
                
                
         