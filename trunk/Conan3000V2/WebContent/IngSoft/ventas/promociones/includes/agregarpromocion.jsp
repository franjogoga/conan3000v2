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
	var form=document.frmPromocion;
	var cadena= new Array();
	var i=0;
	if(!esCorrecto(form.txtNombre.value,1,100)){
		cadena[i]="nombre";
		i++; 
	}
	if(!esCorrecto(form.fFechaInicio.value,1,10)){
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
			        <form class="form-horizontal" method="post" name="frmPromocion">
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Nombre Promoci&oacute;n(*):</label>
			              <div class="controls">
			                <input type="text" name="txtNombre" class="span6 typeahead" id="typeahead7"  data-provide="typeahead" >
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="date01">Fecha de inicio(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechaInicio" class="input-xlarge datepicker" id="date01" value="" readonly="true">
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechaFin" class="input-xlarge datepicker" id="date02" value="" readonly="true">
		                    </div>
		                  </div>
			             		            
			              <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class="" id="textarea2" style="resize:none"></textarea>
		                    </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			              <button type="button" class="btn btn-primary" name="btnAgregar" onClick="javascript:validaForm();">Agregar</button>
			              <button type="reset" class="btn"><a href="buscarpromocion.jsp" name="btnCancelar">Cancelar</a></button>
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