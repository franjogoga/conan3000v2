<!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarventaproducto.jsp">Mantenimiento de Venta de Productos</a> <span class="divider">/</span></li>
		        <li> Buscar Venta de Producto </li>
		        </ul>
	         
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR VENTA DE PRODUCTOS</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">C&oacute;digo de Vendedor:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Vendedor:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="typeahead2">Fecha: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker" id="date" value="02/16/2012">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="typeahead2">Producto: </label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="form-actions">
		                <button type="submit" class="btn btn-primary">Buscar</button>
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
		          <h2><i class="icon-th-list"></i> RESULTADOS DE VENTA DE PRODUCTOS</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <thead>
		              <tr>
		                <th>C&oacute;digo de Vendedor</th>
		                <th>Vendedor</th>
		                <th>Fecha</th>
		                <th>Cliente</th>
		                <th>Monto total</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>000012</td>
		                <td class="center">Juan Perez</td>
		                <td class="center">12/04/2013</td>
		                <td class="center">Jose Ruiz</td>
		                <td class="center">S/.300.00</td>
		                <td class="center">
		                <a class="btn btn-success" href="verventaproducto.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                 <a class="btn btn-info" href="modificarventaproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarventaproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>00034</td>
		                <td class="center">Jose Sanchez</td>
		                <td class="center">19/04/2013</td>
		                <td class="center">Carlos Gonzales</td>
		                <td class="center">S/.390.00</td>
		                <td class="center">
		                <a class="btn btn-success" href="verventaproducto.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                 <a class="btn btn-info" href="modificarventaproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarventaproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>00035</td>
		                <td class="center">Pedro Garcia</td>
		                <td class="center">30/04/2013</td>
		                <td class="center">Rocio Vega</td>
		                <td class="center">S/.370.00</td>
		                <td class="center">
		                <a class="btn btn-success" href="verventaproducto.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                 <a class="btn btn-info" href="modificarventaproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarventaproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->