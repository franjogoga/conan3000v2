  <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarmembresia.jsp">Mantenimiento de Membres&iacute;a</a> <span class="divider">/</span></li>
		        <li> Busqueda de Membres&iacute;a </li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR MEMBRESIA</h2>
		          <div class="box-icon"><a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a> <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a> </div>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">Socio</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead">
                          <p class="help-block">Escriba sobre la casilla un nombre de socio para ser autocompletado</p>
		                </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Fecha Inicio</label>
		                <div class="controls">
		                <input type="text" class="input-xlarge datepicker" id="date01" value="02/16/2012">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="date01">Fecha Fin</label>
		                <div class="controls">
		                 <input type="text" class="input-xlarge datepicker" id="date02" value="02/16/2014">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError2">Estado</label>
		                <div class="controls">
		                  <select name="selectError" id="selectError2" data-rel="chosen">
		                    <option>Activo</option>
		                    <option>Desactivo</option>
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
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> <a class="btn btn-primary" href="agregarmembresia.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th width="13%">Socio</th>
		                <th width="12%">Fecha Inicio</th>
		                <th width="17%">Fecha Fin</th>
		                <th width="20%">Costo</th>
		                <th width="11%">Estado</th>
		                <th width="27%">Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>Juan Perez</td>
		                <td class="center">02/16/2012</td>
		                <td class="center">02/16/2014</td>
		                <td class="center">600</td>
		                <td class="center"><span class="label label-success">Activo</span></td>
		                <td class="center"><a class="btn btn-success" href="vermembresia.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarmembresia.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarmembresia.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>Jose Sanchez</td>
		                <td class="center">05/11/2012</td>
		                <td class="center">05/11/2014</td>
		                <td class="center">600</td>
		                <td class="center"><span class="label label-success">Activo</span></td>
		                <td class="center"><a class="btn btn-success" href="vermembresia.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarmembresia.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarmembresia.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>Raul Bermudez</td>
		                <td class="center">07/23/2012</td>
		                <td class="center">07/23/2016</td>
		                <td class="center">1200</td>
		                <td class="center"><span class="label">Inactive</span></td>
		                <td class="center"><a class="btn btn-success" href="vermembresia.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarmembresia.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarmembresia.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->