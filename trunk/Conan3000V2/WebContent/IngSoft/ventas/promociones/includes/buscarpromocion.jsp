<!-- content starts -->
			  <div>		        
		        <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Buscar Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>BUSCAR PROMOCION</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal">
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">C&oacute;digo:</label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead" id="typeahead7"  data-provide="typeahead" >
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <div class="control-group">
			                  <label class="control-label" for="typeahead2">Nombre Promoci&oacute;n:</label>
			                  <div class="controls">
			                    <input type="text" class="span6 typeahead" id="typeahead2"  data-provide="typeahead" >
		                      </div>
		                    </div>
		                     
			                <label class="control-label" for="date01">Fecha de inicio:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="date01" value="16/02/12">
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="date02" value="16/02/13">
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Descuento:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" data-items="4" >
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
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="reset" class="btn"><a href="buscarpromocion.jsp">Cancelar</a></button>
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
			        <h2>RESULTADOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					    <!-- agregar nuevo boton -->
					    <div  align="right"> <a class="btn btn-primary" href="agregarpromocion.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
					    <thead>
					      <tr>
					        <th>C&oacute;digo</th>
					        <th>Nombre</th>
					        <th>Fecha de incio</th>
					        <th>Fecha de fin</th>
					        <th>Descuento</th>
					        <th>Estado</th>
					        <th>Acci&oacute;n</th>
				          </tr>
				        </thead>
					    <tbody>
					      <tr>
					        <td>PROMO4</td>
					        <td class="center">PromoBungalow</td>
					        <td class="center">16/02/12</td>
					        <td class="center">16/06/13</td>
					        <td class="center">150</td>
					        <td class="center">
                            <span class="label label-success">Active</span>
								
                            </td>
					        <td class="center">
					        <a class="btn btn-success" href="verpromocion.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a>
					        <a class="btn btn-info" href="modificarpromocion.jsp"><i class="icon-edit icon-white"></i> Modificar </a>
					        <a class="btn btn-danger" href="eliminarpromocion.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a>
					        </td>
				          </tr>
                          <tr>
					        <td>PROMO8</td>
					        <td class="center">PromoEquitacion</td>
					        <td class="center">24/02/12</td>
					        <td class="center">16/08/13</td>
					        <td class="center">50</td>
					        <td class="center">
                            <span class="label label-success">Active</span>
								
                            </td>
					        <td class="center">
					        <a class="btn btn-success" href="verpromocion.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a>
					        <a class="btn btn-info" href="modificarpromocion.jsp"><i class="icon-edit icon-white"></i> Modificar </a>
					        <a class="btn btn-danger" href="eliminarpromocion.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a>
					        </td>
				          </tr>
                          <tr>
					        <td>PROMO9</td>
					        <td class="center">PromoEvento</td>
					        <td class="center">12/02/13</td>
					        <td class="center">16/05/13</td>
					        <td class="center">100</td>
					        <td class="center">
                            <span class="label label-success">Active</span>
								
                            </td>
					        <td class="center">
					        <a class="btn btn-success" href="verpromocion.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a>
					        <a class="btn btn-info" href="modificarpromocion.jsp"><i class="icon-edit icon-white"></i> Modificar </a>
					        <a class="btn btn-danger" href="eliminarpromocion.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a>
					        </td>
				          </tr>
                          <tr>
					        <td>PROMO13</td>
					        <td class="center">PromoDsctoMembresia</td>
					        <td class="center">17/04/13</td>
					        <td class="center">16/06/13</td>
					        <td class="center">150</td>
					        <td class="center">
                            <span class="label label-success">Active</span>
								
                            </td>
					        <td class="center">
					        <a class="btn btn-success" href="verpromocion.jsp"> <i class="icon-zoom-in icon-white"></i> Ver </a>
					        <a class="btn btn-info" href="modificarpromocion.jsp"><i class="icon-edit icon-white"></i> Modificar </a>
					        <a class="btn btn-danger" href="eliminarpromocion.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a>
					        </td>
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