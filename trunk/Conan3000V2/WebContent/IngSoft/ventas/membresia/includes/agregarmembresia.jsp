<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
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
	var mensaje="Los siguientes campos no han sido llenados correctamente<br>";
	for(i=0;i<cadena.length;i++){
		if(i+1<cadena.length){
			mensaje+=cadena[i]+'.<br> ';
			
		}else{
			mensaje+=cadena[i];
			
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


function inputRadioLleno(valor){
	var s=0;
	
		for(var i=0;i<valor.length; i++)
		{
			if(valor[i].checked ){
			return true;
				break;
			}
		}
	
return false;	
}


function inicializa(){
	document.getElementById("errNombrePromocion").style.display='none';
	document.getElementById("errFechaInicio").style.display='none';
	document.getElementById("errFechaFin").style.display='none';
	document.getElementById("errEstado").style.display='none';
	document.getElementById("errDescripcion").style.display='none';
	
}

function MostrarErrorDiv(id){
	document.getElementById(id).style.display='block';	
}
function MostrarErrorDivInput(id){
	document.getElementById(id).setAttribute("class", "control-group error");	
}
function MostrarOkDivInput(id){
	document.getElementById(id).setAttribute("class", "control-group success");	
}
function MostrarErrorDivInnerHtml(id,valor){
	document.getElementById(id).innerHTML=valor;	
}
function validarxId(id){
	MostrarErrorDivInput("dv"+id);
	MostrarErrorDiv("err"+id);
	MostrarErrorDivInnerHtml("err"+id,mensaje);
}

function validaForm(){
	var form=document.frmUpdate;

	var cadena= new Array();
	var i=0;
	var error=true;
	if(!esCorrecto(form.txtNombrePromocion.value,1,100)){
		mensaje="La casilla Nombre debe tener entre 1 a 100 caracteres";
		casilla="Nombre";
		id="NombreMembresia";
		validarxId(id);
		cadena[i]=casilla;
		i++; 
	}else{
		id="NombreMembresia";
		MostrarOkDivInput(id);
	}
	
	if(!esCorrecto(form.fFechInicio.value,1,10)){
		mensaje="La casilla Fecha Inicio no ha sido llenado correctamente";
		casilla="Fecha Inicio";
		id="FechaInicio";
		validarxId(id);
		cadena[i]=casilla;
		i++;
	}else{
		id="FechaInicio";
		MostrarOkDivInput(id);
	}
	
	if(!esCorrecto(form.fFechFin.value,1,10)){
		mensaje="La casilla Fecha Fin no ha sido llenado correctamente";
		casilla="Fecha Fin";
		id="FechaFin";
		validarxId(id);
		cadena[i]=casilla;
		i++;
	}else{
		id="FechaFin";
		MostrarOkDivInput(id);
	}
	
	if(!inputRadioLleno(form.rEstado)){
		mensaje="La casilla Estado no ha sido seleccionado";
		casilla="Estado";
		id="Estado";
		validarxId(id);
		cadena[i]=casilla;
		i++;
	}else{
		id="Estado";
		MostrarOkDivInput(id);
	}
	
	if(!esCorrecto(form.txtDescripcion.value,1,100)){
		mensaje="La casilla Descripcion debe tener entre 1 a 100 caracteres";
		casilla="Descripcion";
		id="Descripcion";
		validarxId(id);
		cadena[i]=casilla;
		i++;
	}else{
		id="Descripcion";
		MostrarOkDivInput(id);
	}
	
	//No tocar
	if(error){
	crearAlert(cadena);
	}

}


inicializa();

</script>


<!-- content starts -->
			  <div>
			   <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarmembresia.jsp">Mantenimiento de Membres&iacute;a</a> <span class="divider">/</span></li>
		        <li> Agregar  Membres&iacute;a</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>AGREGAR MEMBRESIA</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmAdd" method="Post"  action="SMVMembresia">
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead7" name="fFechaInicio">Fecha Inicio (*): </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker" id="date01" value="02/16/2012">
			                <span class="help-inline" id="errFechaInicio">Please correct the error</span>
			              </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="typeahead6">Fecha Fin (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="date02" name="fFechaFin" value="02/16/2014">
			                  <span class="help-inline" id="errFechaFin">Please correct the error</span>
			                </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Costo (S/.) (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="typeahead4" name="txtCosto"  data-provide="typeahead" data-items="4" >
			                  <span class="help-inline" id="errCosto">Please correct the error</span>
			                </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Socio (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" name="txtSocio" data-items="4" >
			                  <p class="help-block">Escriba sobre la casilla un nombre de socio para ser autocompletado</p>
			                  <span class="help-inline" id="errSocio">Please correct the error</span>
			                </div>
		                  </div>
                          <div class="control-group">
                            <label class="control-label" for="selectError">Periodo (*):</label>
                            <div class="controls">
                              <select name="selectError3" id="selectError3" data-rel="chosen" name="cmbPeriodo">
                                <option>Anual</option>
                                <option>Semestral</option>
                              </select>
                              <span class="help-inline" id="errPeriodo">Please correct the error</span>
                            </div>
                          </div>
						<div class="control-group">
	                <label class="control-label" for="selectError">Estado (*):</label>
			                <div class="controls">
			                 <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="activo" checked="checked">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Inactivo">
									Inactivo
								  </label><br>
		                      <span class="help-inline" id="errEstado">Please correct the error</span>
			                </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary" onclick="javascript:validaForm()">Agregar</button>
			              <button type="reset" class="btn" onclick="location.href='buscarmembresia.jsp'">Cancelar</button>
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