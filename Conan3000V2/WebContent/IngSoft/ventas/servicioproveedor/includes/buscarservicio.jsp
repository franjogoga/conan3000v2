		    <!-- content starts -->
		    <div>
				<ul class="breadcrumb">
<li> <a href="#">Home / Mantenimiento de Servicios de Proveedores/ </a>Busqueda de Servicio</li>
<li></li>
				</ul>
			</div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR SERVICIO</h2>
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
							    <div class="control-group">
							      <div class="control-group">
							        <label class="control-label" for="typeahead2">Nombre: </label>
							        <div class="controls">
							          <input type="text" class="span6 typeahead" id="typeahead2"  data-provide="typeahead" >
						            </div>
						          </div>
							      <label class="control-label" for="selectError2">Proveedor:</label>
							      <div class="controls">
							       <input type="text" class="span6 typeahead" id="typeahead2"  data-provide="typeahead" >
						          </div>
						        </div>
						      </div>
						    </div>
						    <div class="form-actions">
					       <a  name="btnBuscar" class="btn btn-primary" href="">Buscar</a>  
			               <a  name="btnCancelar" class="btn" href="buscarservicio.jsp">Cancelar</a>  
							
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
		        <div class="box-content">
		          <table width="99%" class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> <a class="btn btn-primary" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/agregarservicio.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th>Nombre</th>
		                <th>Descripci&oacute;n</th>
		                <th>Precio</th>
		                <th>Proveedor</th>
		                <th>Estado</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td width="11%">Limpieza</td>
		                <td width="31%" class="center">Limpieza de piscinas</td>
		                <td width="9%" class="center">400.00</td>
		                <td width="12%" >Liz Gym </td>
		                <td width="10%" class="center"><span class="label label-success">Activo</span></td>
		                <td width="27%" class="center"><a class="btn btn-success" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/verservicio.jsp"> <i class="icon-zoom-in icon-white"></i> Ver</a> <a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/modificarservicio.jsp"> <i class="icon-edit icon-white"></i> Modificar
		                 </a> <a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/eliminarservicio.jsp"> <i class="icon-trash icon-white"></i> Eliminar</a></td>
	                  </tr>
		              <tr>
		                <td>Mantenimiento</td>
		                <td class="center">Mantenimiento de canchas</td>
		                <td class="center">5000.00</td>
		                <td>Jonatan RuQ </td>
		                <td class="center"><span class="label label-success">Activo</span></td>
		                <td class="center"class="center"><a class="btn btn-success" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/verservicio.jsp"> <i class="icon-zoom-in icon-white"></i> Ver</a> <a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/modificarservicio.jsp"> <i class="icon-edit icon-white"></i> Modificar
		                 </a> <a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/servicioproveedor/eliminarservicio.jsp"> <i class="icon-trash icon-white"></i> Eliminar</a></td>
	                  </tr>
		              
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
