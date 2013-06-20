 <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarventaproducto.jsp">Mantenimiento de Venta de Productos</a> <span class="divider">/</span></li>
		        <li> Registrar Venta de Producto </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR VENTA DE PRODUCTO</h2>
		          </div>
			      <div class="box-content">
			        
			        
			          <form class="form-horizontal" id="frmVentaProducto" name="frmVentaProducto" method="POST" action="<%= response.encodeURL("SMVVentaProductos")%>">
			                 <input type="hidden" name="accion" value="Registrar"></input>
							<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead8">Vendedor (*): </label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" data-items="4" >
			                
		                  </div>
		                </div>
                        <div class="control-group">
			                <label class="control-label" for="typeahead4">Cliente (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" >
			                </div>
		                  </div>
			           
			           <div class="control-group">
			              		<label class="control-label" for="typeahead4">Fecha Venta(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="txtFechaVenta" name="txtFechaVenta" value="" readonly="readonly">
			             		</div>
		                		</div>
		                
		                </div>
			            <div class="control-group">
			              <label class="control-label" for="typeahead2">Producto (*): </label>
			              <div class="controls">
			               <select id="selectError1" multiple data-rel="chosen">
									
								  </select> &nbsp;&nbsp; <a href="#" class="btn-setting"><i class="icon-search"></i></a>

		                  </div>
		                </div>
                        

          <div class="control-group">
			                <label class="control-label" for="typeahead4">Monto (S/.) (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="typeahead4"  data-provide="typeahead" data-items="4" >
			                </div>
		                  </div>
			        
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Guardar</button>
			              <button type="reset" class="btn">Cancelar</button>
		                </div>
		              </fieldset>
		            </form>
		          (*) Datos Obligatorios</div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 

		  
       
					<!-- content ends -->