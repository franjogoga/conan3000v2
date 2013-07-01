
<script>

	function alt_submit(){
		var form= document.frmServicio;
		if (validaForm()) {form.submit();}
			
	}
	
	function anhadir(cod, name){
	var form= document.frmServicio;
	form.txtNombreProv.value=name;
	form.idServicio.value=cod;
	$.fn.colorbox.close();
	
	} 

</script>		
			
			
			
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Servicios de Proveedor /</a> Agregar Servicio</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>AGREGAR SERVICIO DE PROVEEDOR</h2>
				  </div>
					<div class="box-content">
					
						<form class="form-horizontal" name="frmServicio" method="POST"  action="SMVServicio">
						<input type="hidden" name="accion" value="Agregar"></input>
					    <input type="hidden" name="tipo" value="2"></input>
					    
						  <fieldset>
						  
						    <div class="control-group" id="dvNombreServ">
						      <label class="control-label" for="typeahead1">Nombre Servicio(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreServ" name="txtNombreServ"  data-provide="typeahead"  maxlength="50" onpaste="return false;">
					            <span class="help-inline" id="errNombreServ">Please correct the error</span>
					          </div>
					        </div>
					        
						
							  
						   <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n(*):</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class="" id="txtDescripcion" rows="3" style="resize:none"  maxlength="100" onpaste="return false;"></textarea>
		                       <span class="help-inline" id="errDescripcion">Please correct the error</span>
		                    </div>
		                  </div>
							  
							  <div class="control-group" id="dvPrecio">
							    <label class="control-label" for="typeahead2">Precio (S/.) (*): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPrecio"  name="txtPrecio" data-provide="txtPrecio" data-items="4" onpaste="return false;" >
						          <span class="help-inline" id="errPrecio">Please correct the error</span>
						        </div>
						      </div>
						      
							  <div class="control-group" id="dvNombreProv">
							  <label class="control-label" for="typeahead3">Nombre Proveedor(*): </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead"  id="txtNombreProv" name="txtNombreProv" data-provide="typeahead" data-items="4"  maxlength="50" onpaste="return false;"><br>
								 <div  align="left"> <a class="btn btn-primary iframe" href="../proveedor/seleccionarproveedor.jsp"> <i class="icon icon-search icon-white"></i> Buscar Proveedor</a> </div>
							     <span class="help-inline" id="errNombreProv">Please correct the error</span>
							  </div>
							</div>
						    
                            
						    <div class="form-actions">
						    <input type="hidden" name="idServicio" value=""/></input>
						    <button type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>  
			               <button type="button"  class="btn" onclick="location.href='../servicioproveedor/buscarservicio.jsp'">Cancelar</button> 
							</div>
						  </fieldset>
					  </form>   
					(*) Campos Obligatorios
				  
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
