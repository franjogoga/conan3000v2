<!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarvencido.jsp">Membres&iacute;as Vencidas</a> <span class="divider">/</span></li>
		        <li> Busqueda de Membres&iacute;as Vencidas</li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR MEMBRESIAS VENCIDAS</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">C&oacute;digo de socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="typeahead2">F. de Vencimiento: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker" id="date2" value="02/16/2012">
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
		          <h2><i class="icon-th-list"></i> RESULTADOS DE BUSQUEDA DE MEMBRESIAS VENCIDAS</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            
		            <thead>
		              <tr>
		                <th>C&oacute;digo de Socio</th>
		                <th>Socio</th>
		                <th>Concepto</th>
		                <th>Fecha de Vencimiento</th>
		                <th>Monto</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>000012</td>
		                <td class="center">Juan Perez</td>
		                <td class="center">Bungalows</td>
		                <td class="center">12/04/2013</td>
		                <td class="center">S/.300.00</td>
		                <td class="center">
		               <a class="btn btn-success" href="verpago.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-primary" href="registrarpago.jsp"> <i class="icon-shopping-cart icon-white"></i> Pagar </a>
		                 <a class="btn btn-info" href="modificarpago.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarpago.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>00034</td>
		                <td class="center">Jose Sanchez</td>
		                <td class="center">Evento</td>
		                <td class="center">19/04/2013</td>
		                <td class="center">S/.300.00</td>
		                <td class="center">
		                <a class="btn btn-success" href="verpago.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-primary" href="registrarpago.jsp"> <i class="icon-shopping-cart icon-white"></i> Pagar </a>
		                 <a class="btn btn-info" href="modificarpago.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarpago.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>00035</td>
		                <td class="center">232434434455</td>
		                <td class="center">Bungalows</td>
		                <td class="center">29/04/2013</td>
		                <td class="center">S/.300.00</td>
		                <td class="center">
		                <a class="btn btn-success" href="verpago.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-primary" href="registrarpago.jsp"> <i class="icon-shopping-cart icon-white"></i> Pagar </a>
		                 <a class="btn btn-info" href="modificarpago.jsp"> <i class="icon-edit icon-white"></i> Modificar</a>
		                 <a class="btn btn-danger" href="eliminarpago.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->