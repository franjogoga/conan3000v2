<script>
function alt_submit(){
	var form= document.frmProducto;
	if(validar(form)) form.submit();
		
}


function esCorrecto(valor,minimo, maximo){
	
	if(valor.length>maximo){ 
		return false;
	}else{
		if(valor.length<=minimo){
			return false;
		}else{
			return true;	
		}

	}

}

function validarEntero(valor){ 
 
 valor = parseInt(valor); 
 	if (isNaN(valor)) { 
       	 return null;
 	}else{ 
       	 return valor; 
 	}
}

function generaMensaje(cadena){
	var i;
	var mensaje="Los siguientes campos no han sido llenados correctamente\n";
	for(i=0;i<cadena.lenght;i++){
		if(i+1<cadena.lenght){
			mensaje+=cadena[i]+', ';
			
		}else{
			mensaje=+cadena[i];
			
		}
		
	}
	return mensaje;
	
}


function crearAlert(cadena){
	mensaje=generaMensaje(cadena);
	$(document).ready(function() {
		apprise(mensaje, {'animate':true}, function(r) {

			if(r) { 
			
			} else { 
		
			}
		});
	});
}

function validar(form){
	if(form.txtNombre.value.length <=0)return false;
	if(form.txtDescripcion.value.length<=0)return false;
	if(form.txtPresentacion.value.lengtht<=0)return false;
	if(form.txtProveedor.value.length<=0)return false;
	//if(form.txtPreciU.value.length<=0)return false;
	//if(form.cmbAmbientes.value.length<=0)return false;
return true;


}
		
function anhadir(cod,name){
	var form=document.frmProducto;
	form.idProveedor.value=cod;
	form.txtProveedor.value=name;
	$.fn.colorbox.close();
}
</script>	
			
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Productos /</a> Agregar Producto</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>AGREGAR PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmProducto"  method="Post"  action="SMVProducto">
						<input type="hidden" name="accion" value="Agregar" ></input>
						<input type="hidden" name="tipo" value="2" ></input>
						  <fieldset>
						    <div class="control-group" id="dvNombre">
						      <label class="control-label" for="typeahead7">Nombre(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombre" name="txtNombre"  data-provide="typeahead" >
						        <span class="help-inline" id="errNombre">Please correct the error 	        
					          </span>
					        </div>
					          </div>
					        
						    <div class="control-group">
							  
							  <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea id="txtDescripcion" name="txtDescripcion" style="resize:none; height: 74px; width: 273px" onKeyUp="limita(this,100);" onKeyDown="limita(this,100);" ></textarea>
								
								<span class="help-inline" id="errDescripcion">Please correct the error 	        
					          </span>		                  
 							</div>
		                  </div>
							  
						      
						       <div class="control-group" id="dv'Presentacion">

							    <label class="control-label" for="typeahead14">Presentaci&oacute;n: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPresentacion" name="txtPresentacion"  data-provide="typeahead" data-items="4" >
						       <span class="help-inline" id="errPresentacion">Please correct the error 	        
					          </span>	
						        </div>
						      </div>
						      
						      
						      
							  <div class="control-group" id="dvPrecioU">
							    <label class="control-label" for="typeahead10">Precio Unitario(S/.) (*): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPrecioU" name="txtPrecioU"  data-provide="typeahead" data-items="4" >
						         <span class="help-inline" id="errPrecioU">Please correct the error 	        
					          </span>	
						        </div>
						      </div>
						 <div class="control-group" id="dvProvedor">
			                <label class="control-label" for="typeahead8">Provedor (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtProveedor"  data-provide="typeahead" name="txtProveedor" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../proveedor/seleccionarproveedor.jsp"> <i class="icon icon-search icon-white"></i> Buscar Proveedor</a> </div>
			                  <span class="help-inline" id="errProveedor">Please correct the error</span>
			                </div>
		                  </div>
						    </div>
                            
						    <div class="form-actions">
			            <input type="hidden" name="idProveedor" value=""/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
			              <button type="button" class="btn" onclick="location.href='buscarproducto.jsp'">Cancelar</button>
		                </div>
						  </fieldset>
					  </form>   
					(*) Datos Obligatorios
				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
