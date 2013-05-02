<!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpagootros.jsp">Solicitud PMOE</a> <span class="divider">/</span></li>
		        <li> Busqueda de Solicitudes PMOE</li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR SOLICTUD DE PMOE</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">C&oacute;digo de Cajero:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Cajero:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="typeahead2">Fecha de Solicitud: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker" id="date" value="02/16/2012">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="typeahead2">Estado de la Solicitud: </label>
		                <div class="controls">
		                 <select id="selectError" data-rel="chosen">
									<option>Modificado Aprobado</option>
									<option>Modificado sin Aprobar</option>
									<option>Modificado Rechazado</option>
									<option>Eliminado Aprobado</option>
									<option>Eliminado sin Aprobar</option>
									<option>Eliminado Rechazado</option>
									<option>No Atendido</option>
									<option>Todos</option>
								  </select>
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
		          <h2><i class="icon-th-list"></i> RESULTADOS DE BUSQUEDA DE SOLICITUD PMOE</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <thead>
		              <tr>
		                <th>C&oacute;digo de Cajero</th>
		                <th>Cajero</th>
		                <th>Fecha de Solicitud</th>
		                <th>Concepto</th>
		                <th>Estado</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>000012</td>
		                <td class="center">C001</td>
		                <td class="center">Samuel Sanchez</td>
		                <td class="center">Bungalows</td>
		                <td class="center">Eliminado sin Aprobar</td>
		                <td class="center">
		                <a class="btn btn-success" href="versolicitud.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-info" href="modificarsolicitud.jsp"> <i class="icon-edit icon-white"></i> Responder</a></td>
	                  </tr>
		              <tr>
		                <td>00034</td>
		                <td class="center">C002</td>
		                <td class="center">Jose Sanchez</td>
		                <td class="center">Evento</td>
		                <td class="center">Modificado sin Aprobar</td>
		                <td class="center">
		                 <a class="btn btn-success" href="versolicitud.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-info" href="modificarsolicitud.jsp"> <i class="icon-edit icon-white"></i> Responder</a></td>
	                  </tr>
		              <tr>
		                <td>00035</td>
		                <td class="center">C002</td>
		                <td class="center">Jose Sanchez</td>
		                <td class="center">Bungalows</td>
		                <td class="center">Modificado aprobado</td>
		                <td class="center">
		                 <a class="btn btn-success" href="versolicitud.jsp"><i class="icon-zoom-in icon-white"></i>Ver</a>
		                <a class="btn btn-info" href="modificarsolicitud.jsp"> <i class="icon-edit icon-white"></i> Responder</a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->