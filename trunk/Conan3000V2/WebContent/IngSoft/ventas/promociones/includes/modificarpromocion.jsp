<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Modificar Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2> MODIFICAR PROMOCI&Oacute;N</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmPromocion" method="Post">
			          <fieldset>
			         
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Nombre Promoci&oacute;n:</label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead" id="typeahead7" name="txtNombrePromocion" data-provide="typeahead" >
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="date01">Fecha de inicio:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="date01" name="fFechaInicio" value="" readonly="true" >
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="date02" name="fFechaFin" value="" readonly="true">
		                    </div>
		                  </div>
			             
								<div class="control-group">
								<label class="control-label" for="typeahead3">Estado:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" id="rEstado" name="rEstado" value="option1" >
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" id="rEstado" name="rEstado" value="option2">
									Inactivo
								  </label>
								</div>
							  </div>


			              <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" rows="3" class="" id="txtDescripcion" style="resize:none"></textarea>
		                    </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			              <button type="button" class="btn btn-primary" onclick="javascript:validaForm();">Modificar</button>
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
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 

		  
       
					<!-- content ends -->