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
			if(form.txtNombrePromocion.value.length <=0)return false;
			if(form.fFechInicio.value.length<=0)return false;
			if(form.fFechFin.value.lengtht<=0)return false;
			if(form.txtDescripcion.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
	return true;
		
		
		}




function alt_submit(){
		var form= document.frmPromocion;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
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
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Nombre Promoci&oacute;n(*):</label>
			              <div class="controls">
			                <input type="text" name="txtNombrePromocion" class="span6 typeahead" id="txtNombrePromocion"  data-provide="typeahead" >
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="date01">Fecha de inicio(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechInicio" class="input-xlarge datepicker" id="fFechInicio" value="" readonly="true">
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechFin" class="input-xlarge datepicker" id="fFechFin" value="" readonly="true">
		                    </div>
		                  </div>
			             		            
			              <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class="" id="txtDescripcion" style="resize:none"></textarea>
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