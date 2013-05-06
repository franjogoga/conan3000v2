		    <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="#">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarproveedor.jsp">Mantenimiento de Proveedores</a> <span class="divider">/</span></li>
		        <li> Busqueda de Proveedores </li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR PROVEEDOR</h2>
		          <div class="box-icon"> <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a> <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a></div>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">Raz&oacute;n Social</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">RUC</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="date01">Contacto</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="form-actions">
		               <a  name="btnAgregar" class="btn btn-primary" href="">Buscar</a>  
			              
			           
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
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> <a class="btn btn-primary" href="agregarproveedor.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a></div>
		            <thead>
		              <tr>
		                <th>Raz&oacute;n Social</th>
		                <th>RUC</th>
		                <th>Direcci&oacute;n</th>
		                <th>Correo Electr&oacute;nico</th>
		                <th>Contacto</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>PUCP</td>
		                <td class="center">234234455454</td>
		                <td class="center">Av. Universitaria 1800</td>
		                <td class="center">pucp@pucp.pe</td>
		                <td class="center">Juan Perez</td>
		                <td class="center"><a class="btn btn-success" href="verproveedor.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarproveedor.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarproveedor.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>BACKUS</td>
		                <td class="center">234544554545</td>
		                <td class="center">Av Javier Prado 234</td>
		                <td class="center">servicios@backus.com.pe</td>
		                <td class="center">Joel Sanchez</td>
		                <td class="center"><a class="btn btn-success" href="verproveedor.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarproveedor.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarproveedor.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>IBM</td>
		                <td class="center">232434434455</td>
		                <td class="center">Av Javier Prado 2355</td>
		                <td class="center">soporte@ibm.pe</td>
		                <td class="center">Raul Campos</td>
		                <td class="center"><a class="btn btn-success" href="verproveedor.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarproveedor.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarproveedor.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
