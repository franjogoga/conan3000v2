<script>
function validaCorreo(valor)
{
	var reg=/(^[a-zA-Z0-9._-]{1,30})@([a-zA-Z0-9.-]{1,30}$)/;
	if(reg.test(valor)) return true;
	else return false;
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

function validaForm(){
	var form=document.frmSocio;
	var cadena= new Array();
	var i=0;
	if(!esCorrecto(form.txtNombrePromocion.value,1,100)){
		cadena[i]="nombre";
		i++; 
	}
	
	if(!esCorrecto(form.fFechInicio.value,1,10)){
		cadena[i]="Fecha Inicio";
		i++;
	}
	if(!esCorrecto(form.fFechaFin.value,1,10)){
		cadena[i]="Fecha Fin";
		i++;
	}
	if(!esCorrecto(form.txtDescripcion.value,1,100)){
		cadena[i]="Descripcion";
		i++;
	}
	
	crearAlert(cadena);
	
}

		function validar(form){
			if(form.txtNombres.value.length <=0)return false;
			if(form.txtApellidoPaterno.value.length<=0)return false;
			if(form.txtApellidoMaterno.value.lengtht<=0)return false;
			if(form.fFechaNacimiento.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
	return true;
		
		
		}

function alt_submit(){
		var form= document.frmSocio;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
}



</script>	
	
			  <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      		           
			              <li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home / </a><a href="/Conan3000V2/IngSoft/ventas/socio/buscarsocio.jsp">Mantenimiento de Socios / </a>Agregar Socio
			           
			              </li>
			              
			           </ul>
			 </div>
		              <div class="row-fluid sortable">
			            <div class="box span12">
			              <div class="box-header well" data-original-title>
			                <h2>AGREGAR SOCIO </h2>
		                  </div>
			              <div class="box-content">
                          
			                <form class="form-horizontal" id="frmSocio" name="frmSocio" method="POST" action="<%= response.encodeURL("SMVSocio")%>">
			                 <input type="hidden" name="accion" value="Agregar"></input>
							<input type="hidden" name="tipo" value="2"></input>
			                
			                  <fieldset>
			                  
			                    <div class="control-group">
			                      <label class="control-label" for="typeahead1">Nombres(*): </label>
			                      <div class="controls">
			                        <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres"  >
		                          </div>
		                        </div>
			                   
			                      <div class="control-group">
			                        <label class="control-label" for="typeahead2">Apellido Paterno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno"   >
		                            </div>
		                          </div>
		                          
			                      <div class="control-group">
			                        <label class="control-label" for="typeahead3">Apellido Materno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno"  data-provide="typeahead"  >
		                            </div>
		                          </div>
                                  
                                
                                  <div class="control-group">
			              		<label class="control-label" for="typeahead4">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaNacimiento" name="fFechaNacimiento" value="">
			             		</div>
		                		</div>
                         
			                    <div class="control-group">
								<label class="control-label" for="selectdistrito">Distrito (*):</label>
								<div class="controls">
								  <select name="cmdDistrito" id="cmdDistrito" data-rel="chosen">
									<option>Distrito 1</option>
									<option>Distrito 2</option>
									<option>Distrito 3</option>
									<option>Distrito 4</option>
									<option>Distrito 5</option>
								  </select>
								</div>
							</div>		
			               
                            <div class="control-group">
								<label class="control-label" for="typeahead5">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" >
									DNI
								  </label>
								  <div style="clear:both">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Carnet de Extranjeria
								  </label>
								  </div>
								</div>
							  </div>
						   
		                          <div class="control-group">
			                          <label class="control-label" for="typeahead6">N&uacute;mero de Documento(*): </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtNumeroDocumento" name="txtNumeroDocumento" data-provide="typeahead" >
		                              </div>
		                      	</div>
		                     
			                        <div class="control-group">
			                          <label class="control-label" for="typeahead7">Correo Electr&oacute;nico: </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtCorreoElectronico" name="txtCorreoElectronico"  data-provide="typeahead">
		                              </div>
		                            </div>
		                            
			                        <div class="control-group">
			                          <label class="control-label" for="typeahead8">Direcci&oacute;n: </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtDireccion" name="txtDireccion"  data-provide="typeahead" data-items="4">
		                              </div>
		                            </div>
		                            
		                             <div class="control-group">
			                        <label class="control-label" for="typeahead9">Tel&eacute;fono Fijo: </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoFijo"  name="txtTelefonoFijo" data-provide="txtTelefonoFijo" data-items="4" >
		                            </div>
		                            </div>
		                            
		                            <div class="control-group">
		                             <label class="control-label" for="typeahead10">Tel&eacute;fono Celular: </label>
			                        
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoCelular" name="txtTelefonoCelular" data-provide="txtTelefonoCelular" data-items="4" >
		                            </div>
		                            </div>
		                            
		                          
		                        <div class="form-actions">
			                      <button  type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>      
			               		   <button  type="button"  class="btn" onclick="location.href='../promociones/trasladomembresia.jsp'">Cancelar</button>  
		                        </div>
		                      </fieldset>
		                    </form>
                            (*) Datos Obligatorios
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
