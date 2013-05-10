<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/IngSoft/general/header.jsp" />
<!-- The fav icon -->
<link rel="shortcut icon" href="img/conan_logo.png">

</head>
<body>
		<jsp:include page="/IngSoft/general/superior.jsp" />
		<div class="container-fluid">
			<div class="row-fluid">
				<jsp:include page="/IngSoft/general/leftmenu.jsp" />
				<jsp:include page="/IngSoft/general/noscript.jsp" />
				<div id="content" class="span10">
				    <!-- content starts -->
				   <jsp:include page="includes/modificarpromocion.jsp" />
				    <!-- content ends -->
				</div>
			 </div>
		<hr>
			<jsp:include page="includes/modal.jsp" />
			<jsp:include page="/IngSoft/general/footer.jsp" />
		</div>
		<jsp:include page="/IngSoft/general/jsexternal.jsp" />
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
		id="NombrePromocion";
		validarxId(id);
		cadena[i]=casilla;
		i++; 
	}else{
		id="NombrePromocion";
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

		
		
</body>
</html>


