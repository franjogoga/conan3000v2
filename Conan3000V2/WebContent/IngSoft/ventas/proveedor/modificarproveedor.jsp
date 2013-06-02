		    <!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/IngSoft/general/header.jsp" />
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
				   <jsp:include page="includes/modificarproveedor.jsp" />
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
	9: Validacion de email
	minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	
	El valor que va en cadena[i] es el nombre del campo
	
	#############################ADICIONAL#########################
	Para validar una fecha Inicial y fecha Final usar la siguiente funcion
	validarFechas(nombre[Fecha Final], casilla[Fecha Final], id[Fecha Final],nombre[Fecha Inicial],casilla[Fecha Inicial])
	OJO: no va como parametro el id de la fecha Inicial
	###############################################################
	
	*/
	
	
	var form=document.frmUpdate;

	var cadena= new Array();
	var i=0;
	var error=false;

	if(!esValido("Razon Social",form.txtRazonSocial,"RazonSocial",1,1,100)){cadena[i]="Razon Social";i++;}

	if(!esValido("Direccion",form.txtDireccion,"Direccion",1,1,100)){cadena[i]="Direccion";i++;}
	if(!esValido("Nombre Contacto",form.txtNombre,"Nombre",1,1,50)){cadena[i]="Nombre contacto";i++;}
	if(!esValido("Apellido Paterno",form.txtApPaterno,"ApellidoP",1,1,50)){cadena[i]="Apellido Paterno";i++;}
	if(!esValido("Apellido Materno",form.txtApMaterno,"ApellidoM",1,1,50)){cadena[i]="Apellido Materno";i++;}
	if(!esValido("Tipo de Documento",form.rButton,"Tipo",3,1,100)){cadena[i]="Tipo de Documento";i++;}
	if(!esValido("Telefono",form.txtTelefono,"Telefono",1,1,8)){cadena[i]="Telefono";i++;}else{
		if(!esValido("Telefono",form.txtTelefono,"Telefono",6,1,50)){cadena[i]="Telefono";i++;}
	}
	if(!esValido("Ruc",form.txtRuc,"Ruc",1,1,11)){cadena[i]="Ruc";i++;}else{
		if(!esValido("Ruc",form.txtRuc,"Ruc",6,1,50)){cadena[i]="Ruc";i++;}
	}
	if(!esValido("Numero Documento",form.txtNumDoc,"NumDoc",1,1,9)){cadena[i]="Numero Documento";i++;}else{
		if(!esValido("Numero Documento",form.txtNumDoc,"NumDoc",6,1,50)){cadena[i]="Numero Documento";i++;}
	}
	
	if(!esValido("Correo Electronico",form.txtCorreo,"CorreoE",1,1,50)){cadena[i]="Correo Electronico";i++;}else{
		if(!esValido("Correo Electronico",form.txtCorreo,"CorreoE",9,1,100)){cadena[i]="Correo Electronico";i++;}
	}
	
	
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
	document.getElementById("errRazonSocial").style.display='none';
	document.getElementById("errRuc").style.display='none';
	document.getElementById("errDireccion").style.display='none';
	document.getElementById("errNombre").style.display='none';
	document.getElementById("errApellidoP").style.display='none';
	document.getElementById("errApellidoM").style.display='none';
	document.getElementById("errTipo").style.display='none';
	document.getElementById("errTelefono").style.display='none';
	document.getElementById("errNumDoc").style.display='none';
	document.getElementById("errCorreoE").style.display='none';
	
}


inicializa();

</script>
</body>
</html>
		