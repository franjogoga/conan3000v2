		    <!-- content starts -->
		    <div>
				<ul class="breadcrumb">
<li> <a href="#">Home / Mantenimiento de Productos / </a>Busqueda de Producto</li>
<li></li>
				</ul>
			</div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR PRODUCTO</h2>
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
						        
						               <div class="control-group">
								<label class="control-label" for="typeahead3">Estado</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Inactivo
								  </label>
								</div>
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
		            <div  align="right"> <a class="btn btn-primary" href="/Conan3000V2/IngSoft/ventas/producto/agregarproducto.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th>Nombre</th>
		                <th>Descripcion</th>
		                <th>Precio Unitario</th>
		                <th>Proveedor</th>
		                <th>Estado</th>
		                <th>Accion</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td width="11%">Gorro CAP</td>
		                <td width="31%" class="center">Gorro de color verde o rojo</td>
		                <td width="9%" class="center">25.00</td>
		                <td width="12%" >Liz Gym </td>
		                <td width="10%" class="center"><span class="label label-success">Activo</span></td>
		                <td width="27%" class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver</a> <a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/producto/modificarproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar
		                 </a> <a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/producto/eliminarproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar</a></td>
	                  </tr>
		              <tr>
		                <td>Mochila JRP</td>
		                <td class="center">Mochila de distintos colores,tamaño grande</td>
		                <td class="center">60.00</td>
		                <td>Jonatan RuQ </td>
		                <td class="center"><span class="label label-success">Activo</span></td>
		                <td class="center"class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver</a> <a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/producto/modificarproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar
		                 </a> <a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/producto/eliminarproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar</a></td>
	                  </tr>
		              <tr>
		                <td>Polo ARQ</td>
		                <td class="center">Polo de distintos colores,todas las tallas</td>
		                <td class="center">50.00</td>
		                <td>Heli PrO </td>
		                <td class="center"><span class="label label-success">Activo</span></td>
		                <td class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver</a> <a class="btn btn-info" href="/Conan3000V2/IngSoft/ventas/producto/modificarproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="/Conan3000V2/IngSoft/ventas/producto/eliminarproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
