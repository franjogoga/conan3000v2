<script>

function alt_submit(){
		var form= document.frmPromocion;
		if(validaForm()) form.submit();
			
}

</script>



<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Agregar Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-plus-sign"></i>AGREGAR PROMOCI&Oacute;N</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmPromocion" method="POST" action="SMVPromocion">
			        <input type="hidden" name="accion" value="Agregar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			        
			          <fieldset>
			             <div class="control-group" id="dvNombrePromocion">
			              <label class="control-label" for="typeahead7">Nombre Promoci&oacute;n(*):</label>
			              <div class="controls">
			                <input type="text" name="txtNombrePromocion" class="span6 typeahead" id="txtNombrePromocion" onpaste="return false;" data-provide="typeahead" onKeyUp="limita(this,50);" onKeyDown="limita(this,50);">
			                <span class="help-inline" id="errNombrePromocion">Please correct the error</span>
		                  </div>
		                </div>
			           <div class="control-group" id="dvFechaInicio">
			              <label class="control-label" for="date01">Fecha de inicio(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechInicio" class="input-xlarge datepicker" id="fFechInicio" value="" readonly="true">
			                  <span class="help-inline" id="errFechaInicio">Please correct the error</span>
		                    </div>
		                  </div>
			              <div class="control-group" id="dvFechaFin">
			                <label class="control-label" for="date02">Fecha de fin(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechFin" class="input-xlarge datepicker" id="fFechFin" value="" readonly="true">
			                  <span class="help-inline" id="errFechaFin">Please correct the error</span>
		                    </div>
		                  </div>
			             		            
			              <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class="" id="txtDescripcion" style="resize:none" onpaste="return false;"  onKeyUp="limita(this,100);" onKeyDown="limita(this,100);" ></textarea>
			                  <span class="help-inline" id="errDescripcion">Please correct the error</span>
		                    </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			                  <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
							  <button type="button" class="btn" onclick="location.href='buscarpromocion.jsp'" >Cancelar</button>
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