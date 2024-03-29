<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/IngSoft/general/header.jsp" />
</head>
<body>
		<jsp:include page="/IngSoft/general/superior.jsp" />
		<div class="container-fluid">
			<div class="row-fluid">
				<jsp:include page="/IngSoft/general/leftmenu.jsp" />
				<jsp:include page="/IngSoft/general/noscript.jsp" />
				<div id="content" class="span10">
				    <!-- content starts -->
				   <jsp:include page="includes/registrarcuotaextra.jsp" />
				    <!-- content ends -->
				</div>
			 </div>
		<hr>
			<jsp:include page="includes/modal.jsp" />
			<jsp:include page="/IngSoft/general/footer.jsp" />
		</div>
		<jsp:include page="/IngSoft/general/jsexternal.jsp" />
		<script>
			$(document).ready(function(){
				//Examples of how to assign the Colorbox event to elements
				
				$(".iframe").colorbox({iframe:true, width:"60%", height:"80%"});
				
				//Example of preserving a JavaScript event for inline calls.
				$("#click").click(function(){ 
					$('#click').css({"background-color":"#f00", "color":"#fff", "cursor":"inherit"}).text("Open this window again and this message will still be here.");
					return false;
				});
			});
		</script>
		
		<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script type="text/javascript" src="js/script.js"></script>
		<script>


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
	4: Validacion de alfanumerico
	5: validacion de valores Float
	6: Validacion de enteros
	minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	
	El valor que va en cadena[i] es el nombre del campo
	
	#############################ADICIONAL#########################
	Para validar una fecha Inicial y fecha Final usar la siguiente funcion
	validarFechas(nombre[Fecha Final], casilla[Fecha Final], id[Fecha Final],nombre[Fecha Inicial],casilla[Fecha Inicial])
	OJO: no va como parametro el id de la fecha Inicial
	###############################################################
	
	*/
	
	
	var form=document.frmPago;

	var cadena= new Array();
	var i=0;
	var error=false;
	if(form.chkAplicar.checked){
		if(!esValido("Periodo",form.cmbPeriodo,"Periodo",1,1,50)){cadena[i]="Periodo";i++;}
		if(!esValido("Socio",form.txtSocio,"Socio",1,1,50)){cadena[i]="Socio";i++;}
	}
	if(!esValido("Monto",form.txtMonto,"Monto",1,1,50)){
		cadena[i]="Monto";i++;
	}else{
		//valida si es float o entero
		if(!esValido("Monto",form.txtMonto,"Monto",5,1,1)){cadena[i]="Monto";i++;}
	}
	if(!esValido("Fecha Emision",form.fFechaEmision,"FechaEmision",2,1,10)){cadena[i]="Fecha Emision";i++;}
	
	if(form.chkAplicar.checked){
		if(!esValido("Fecha Vencimiento",form.fFechaVencimiento,"FechaVencimiento",2,1,10)){cadena[i]="Fecha Vencimiento";i++;}
		if(!validarFechas("Fecha Vencimiento",form.fFechaVencimiento,"FechaVencimiento","Fecha Emision",form.fFechaEmision)){cadena[i]="Fecha Vencimiento";i++;};
		
	}
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
/*Esto se debe llenar siempre deacuerdo a las etiuquetas <span> del formulario, esto sirve para ocultar inicialmente los avisos
Solo poner el id de los <span> segun corresponda
*/
	document.getElementById("errPeriodo").style.display='none';
	document.getElementById("errSocio").style.display='none';
	document.getElementById("errMonto").style.display='none';
	document.getElementById("errFechaEmision").style.display='none';
	document.getElementById("errFechaVencimiento").style.display='none';
	document.getElementById("errDescripcion").style.display='none';
	document.getElementById("errCuota").style.display='none';
	document.getElementById("errMontoCuota").style.display='none';
	
}


inicializa();

</script>
</body>
</html>

