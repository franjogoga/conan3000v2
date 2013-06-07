<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpagootros.jsp">Pago de Otros Servicios</a> <span class="divider">/</span></li>
		        <li> Registrar Pago de Otros Servicios </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR PAGO DE OTROS SERVICIOS</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal">
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead8">Socio (*): </label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead" id="txtSocio" name="txtSocio"  data-provide="typeahead" data-items="4" >
			                <p class="help-block">Escriba sobre la casilla un nombre de socio para ser autocompletado</p>
		                  </div>
		                </div>
                        <div class="control-group">
			                <label class="control-label" for="typeahead4">C&oacute;digo de Socio (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead disabled" id="txtCodigoSocio" name="txtSocio"  data-provide="typeahead" data-items="4" disabled="" >
		                    </div>
		                  </div>
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Concepto: </label>
			              <div class="controls">
								  <select id="cmbConcepto" data-rel="chosen">
									<option>Bungalows</option>
									<option>Canchas</option>
									<option>Eventos</option>
									<option>Actividades</option>
									<option>Otros</option>
								  </select>
								</div>
		                </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead2">Fecha de Pago (*): </label>
                          <div class="controls">
                            <input type="text" class="input-xlarge datepicker" id="fFechaPago" name="fFechaPago" value="">
                          </div>
                        </div>
<div class="control-group">
          <div class="control-group">
			                <label class="control-label" for="typeahead4">Monto (S/.) (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="txtMonto" name="txtMonto"  data-provide="typeahead" data-items="4" >
			                </div>
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
			 