<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="#">Home</a> / <a href="#">Mantenimiento de Familiares</a> / Busqueda de Familiar</li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>BUSCAR FAMILIAR</h2>
			      </div>
			      <div class="box-content">
			        <form class="form-horizontal">
			          <fieldset>
		                <div class="control-group">
			                <label class="control-label" for="typeahead9">Socio:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead9" value="Liz Diaz"  data-provide="typeahead" data-items="4" >
			                  <p class="help-block">Escriba sobre la casilla un nombre de socio para ser autocompletado</p>
	                      </div>
	                    </div>
		                <div class="control-group"></div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead6">Nombres:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead6"  data-provide="typeahead" data-items="4" >
		                    </div>
	                    </div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Apellido Paterno:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Apellido Materno:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
			              <div class="control-group">
			               <div class="control-group">
								<label class="control-label" for="typeahead3">Tipo de Documento:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
									DNI
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Carnet de Extranjeria
								  </label>
								   <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">
									Pasaporte
								  </label>
								</div>
							  </div>
			                <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="reset" class="btn"><a href="buscarfamiliar.jsp">Cancelar</a></button>
		                </div>
		                </div>
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-th-list"></i>RESULTADOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					    <!-- agregar nuevo boton -->
					    <div align="right"> <a class="btn btn-primary" href="agregarfamiliar.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
					    <thead>
					      <tr>
					        <th>Parentesco</th>
					        <th>Nombres</th>
					        <th>Apellido Paterno</th>
					        <th>Apellido Materno</th>
					        <th>DNI</th>
					        <th>Teléfono</th>
					        <th>Correo electrónico</th>
                            <th>Acción</th>
                            
                         
				          </tr>
				        </thead>
					    <tbody>
					      <tr>
					        <td>Padre</td>
					        <td class="center">Jose</td>
					        <td class="center">Diaz</td>
					        <td class="center">Haro</td>
					        <td class="center">45678734</td>
					        <td class="center">&nbsp;</td>
					        <td class="center">jdh@gmail.com</td>
                               
					        <td class="center"><a class="btn btn-success" href="verfamiliar.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarfamiliar.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarfamiliar.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
				          </tr>
                          <tr>
					        <td>Madre</td>
					        <td class="center">Jenny</td>
					        <td class="center">Castillo</td>
					        <td class="center">Mogrovejo</td>
					        <td class="center">45076489</td>
					        <td class="center">5673456</td>
					        <td class="center">&nbsp;</td>
                               
					        <td class="center"><a class="btn btn-success" href="verfamiliar.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarfamiliar.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarfamiliar.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
				          </tr>
                          
				        </tbody>
				      </table>
                  </div>
		        </div>
		      </div>
              
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 

		  
       
					<!-- content ends -->