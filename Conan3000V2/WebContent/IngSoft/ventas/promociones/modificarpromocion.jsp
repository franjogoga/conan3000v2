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
		if(valor.length<minimo){
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


function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	
	

function verificar_fecha(comparacion,fecha1,fecha2){
	var fec1=fecha1.value.split("/");
	var fec2=fecha2.value.split("/");
	var resultado=true;
	if(fec1.length==fec2.length) {
		var size=fec1.length;
		for(i=size-1;i>=0;i--){
			if(comparacion==0){
				if(fec1[i].indexOf(fec2[i])<0)  resultado= false;
				}
			if(comparacion==1){
				if(parseInt(fec1[i])<parseInt(fec2[i]))  resultado= false;
				}
			if(comparacion==-1){
				if(parseInt(fec1[i])>parseInt(fec2[i]))  resultado= false;
				}
			}
		if(resultado==false){	
				validarxId('FechaFin',"Error al comparar fechas. La fecha Final debe ser como minimo igual a la Fecha Inicial");
				fecha1.value=fecha2.value;	
				return false;
			}else{return true;}
			
		} 
	else{ 
		validarxId('FechaFin',"Error al comparar fechas");
		return false;		
	}			
}

function alfanumerico(e) 
{ 
var key = window.event.keyCode || event.keyCode;
return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
} 	





function MostrarErrorDiv(id){
	document.getElementById(id).style.display='block';	
}
function OcultarErrorDiv(id){
	document.getElementById(id).style.display='none';	
}

function MostrarErrorDivInput(id){
	document.getElementById(id).setAttribute("class", "control-group error");	
}
function MostrarOkDivInput(id){
	document.getElementById("dv"+id).setAttribute("class", "control-group success");
	OcultarErrorDiv("err"+id);
}
function MostrarErrorDivInnerHtml(id,valor){
	document.getElementById(id).innerHTML=valor;	
}
function validarxId(id,mensaje){
	MostrarErrorDivInput("dv"+id);
	MostrarErrorDiv("err"+id);
	MostrarErrorDivInnerHtml("err"+id,mensaje);
}


function esValido(nombre, casilla, id, tipoValidacion, minimo,maximo){
	
	var status;
	switch(tipoValidacion){
		case 1: 
			status=esCorrecto(casilla.value,minimo,maximo);
			mensaje="La casilla "+nombre+" debe tener entre "+minimo+" a "+maximo+" caracteres";
			break;
		case 2:	
			status=esCorrecto(casilla.value,minimo,maximo);
			mensaje="La casilla "+nombre+" no ha sido llenado correctamente";
			break;
		case 3: 
			status=inputRadioLleno(casilla.value);
			mensaje="La casilla "+nombre+" no ha sido seleccionado";
			break;
		
	}
	
	if(!status){
		validarxId(id,mensaje);
		return 0;
	}else{
		MostrarOkDivInput(id);
		return 1;
	}
				
}


function validaForm(){
	/*
	esValido(nombre, casilla, id, tipoValidacion, minimo,maximo)
	nombre: es el nombre de la casilla: ejemplo -> Nombre, Apellido, Fecha de Nacimiento, etc
	casilla: corresponde a la casilla en si, para esto colocamos por ejemplo form.txtNombre, donde form ya fue definido
	id: identificador de los divs para efectuar las validaciones
	tipoValidacion: es un valor numerico el cual permite identificar el tipo de validacion que se efectuara
	1: Validacion con cantidad de caracteres Minimo y maximo
	2: Validación de cantidad de caracteres de fecha
	3: validacion de llenado de radio button
	
	minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado
	maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado
	
	*/
	
	var form=document.frmUpdate;

	var cadena= new Array();
	var i=0;
	var error=false;
	if(!esValido("Nombre",form.txtNombrePromocion,"NombrePromocion",1,1,50)){cadena[i]="Nombre";i++;}
	if(!esValido("Fecha Inicio",form.fFechInicio,"FechaInicio",2,1,10)){cadena[i]="Fecha Inicio";i++;}
	if(!esValido("Fecha Fin",form.fFechFin,"FechaFin",2,1,10)){cadena[i]="Fecha Fin";i++;}
	if(!verificar_fecha(-1,form.fFechInicio,form.fFechFin)){cadena[i]="Fecha Fin";i++;};
	if(!esValido("Descripcion",form.txtDescripcion,"Descripcion",1,1,100)){cadena[i]="Descripcion";i++;}
	
	
	//No tocar
	if(i>0){
	crearAlert(cadena);
	return false;
	}else{
		return true;
		
	}

}


function inicializa(){
	document.getElementById("errNombrePromocion").style.display='none';
	document.getElementById("errFechaInicio").style.display='none';
	document.getElementById("errFechaFin").style.display='none';
	document.getElementById("errDescripcion").style.display='none';
	
}


inicializa();

</script>

		
		
</body>
</html>


