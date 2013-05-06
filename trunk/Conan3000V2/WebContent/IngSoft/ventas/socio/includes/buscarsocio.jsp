
			<!-- content starts -->

			<div class="row-fluid sortable">
				
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					
					<li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home / </a><a href="/Conan3000V2/IngSoft/ventas/socio/buscarsocio.jsp">Mantenimiento de Socios / </a>Busqueda Socio
			           
			              </li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i>  BUSCAR SOCIO				  </h2>
                        <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
                        
                        
				  </div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
						    <div class="control-group">
							  <div class="control-group">
							    <label class="control-label" for="typeahead6">Apellido Paterno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="typeahead6"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Apellido Materno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="typeahead10"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  <div class="control-group">
								<label class="control-label" for="selectError">Tipo de Documento:</label>
								<div class="controls">
								  <select id="selectError" data-rel="chosen" >
									<option>DNI</option>
									<option>Carnet de Extranjeria</option>
								
								  </select>
								</div>
							  </div>
                              
                              
                              <div class="control-group">
			                          <label class="control-label" for="typeahead2">Nro. de Documento: </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="typeahead2" value="04583232"  data-provide="typeahead" data-items="4" >
		                              </div>
                              </div>
						    </div>
						    <div class="form-actions">
							  <a  name="btnBuscar" class="btn btn-primary" href="">Buscar</a>  
			               <a  name="btnCancelar" class="btn" href="buscarfamiliar.jsp">Cancelar</a>  
			           
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
			</div><!--/span-->
                
               
			<!-- content starts -->

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2> <i class="icon-th-list"> </i>  RESULTADOS</h2>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
                        
                        
                        <div  align="right">
                                <a class="btn btn-primary" href="/Conan3000V2/IngSoft/ventas/socio/agregarsocio.jsp">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
                           </div>
                           
						  <thead>
							  <tr>
								  <th>Nombres</th>
								  <th>Apellido Paterno</th>
								  <th>Apellido Materno</th>
								  <th>Tipo de Documento</th>
                                  <th>Correo Electronico</th>
                                  <th>Telefono</th>
                                  <th>Estado</th>
								  <th>Accion</th>
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>Daniel</td>
								<td class="center">Bernal</td>
								<td class="center">Lovera</td>
								
								
                                <td>45836314
                                
                                </td>
                                
                                
                                <td>daniel.bernal@pucp.pe
                                
                                </td>
                                
                                <td>993283212
                                
                                </td>
                                <td class="center">
									 <span class="label label-success">Activo</span>
								</td>
                                
                                <td class="center">
									<a class="btn btn-success" href="/Conan3000V2/IngSoft/ventas/socio/versocio.jsp">
										<i class="icon-zoom-in icon-white"></i>  
										Ver                                            
									</a>
									<a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/socio/modificarsocio.jsp">
										<i class="icon-edit icon-white"></i>  
										Modificar</a>
									<a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/socio/eliminarsocio.jsp">
										<i class="icon-trash icon-white"></i> 
										Eliminar
									</a>
								</td>
                                
                                
							</tr>
							<tr>
								<td>Carlos</td>
								<td class="center">Attiti</td>
								<td class="center">Bustamente</td>
								
							
                                
                                
                                <td>03213433
                                </td>
                                
                                
                                <td>carlos.attiti@pucp.pe
                                
                                </td>
                                
                                
                                <td>943013453
                                
                                </td>
                              <td class="center">
									<span class="label">Inactivo</span>
							  </td>
                                
                           	  <td class="center">
									<a class="btn btn-success" href="/Conan3000V2/IngSoft/ventas/socio/versocio.jsp">
										<i class="icon-zoom-in icon-white"></i>  
										Ver                                            
									</a>
									<a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/socio/modificarsocio.jsp">
										<i class="icon-edit icon-white"></i>  
										Modificar                                            
									</a>
									<a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/socio/eliminarsocio.jsp">
										<i class="icon-trash icon-white"></i> 
										Eliminar
									</a>
							  </td>
							</tr>
							<tr>
								<td>David</td>
								<td class="center">Vigio</td>
								<td class="center">Luks</td>
							
								
                                
                                
                                <td>43541331
                                
                                </td>
                                
                                <td>david.vigio@pucp.pe
                                
                                </td>
                                
                                <td>964324244
                                
                                </td>
                                
                                	<td class="center">
									 <span class="label label-success">Activo</span>
								</td>
                              <td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										Ver                                            
									</a>
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										Modificar                                            
									</a>
									<a class="btn btn-danger" href="#">
										<i class="icon-trash icon-white"></i> 
										Eliminar
									</a>
							  </td>
							</tr>
						  </tbody>
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
                
                
         