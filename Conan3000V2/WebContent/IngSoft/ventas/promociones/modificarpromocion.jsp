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
	
	minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado
	maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado
	
	*/
	
	var form=document.frmUpdate;

	var cadena= new Array();
	var i=0;
	var error=false;
	if(!esValido("Nombre",form.txtNombrePromocion,"NombrePromocion",1,1,50)){cadena[i]="Nombre";i++;}
	if(!esValido("Fecha Inicio",form.fFechInicio,"FechaInicio",2,1,10)){cadena[i]="Fecha Inicio";i++;}
	if(!esValido("Fecha Fin",form.fFechFin,"FechaFin",2,1,10)){
		cadena[i]="Fecha Fin";i++;
	}else{
		if(!validarFechas("Fecha Final",form.fFechFin,"FechaFin","Fecha Inicio",form.fFechInicio)){
		cadena[i]="Fecha Fin";i++;
		}
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
	document.getElementById("errNombrePromocion").style.display='none';
	document.getElementById("errFechaInicio").style.display='none';
	document.getElementById("errFechaFin").style.display='none';
	document.getElementById("errDescripcion").style.display='none';
	
}


inicializa();

</script>

		
		
</body>
</html>


