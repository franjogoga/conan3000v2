<!DOCTYPE html>
 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.InvitadoBeanData"%>

<html lang="en">
<head>
	<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
	<meta charset="utf-8">
	<title>Agregar Invitado</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<!--The beans  -->
	<jsp:useBean id="invitado" scope="request"class="IngSoft.administracion.bean.InvitadoBeanData"></jsp:useBean>
	
	
	
	
	
	
	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->











	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
	
	
	
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
		function validar(form){
			if(form.txtNombre.value.length <=0)return false;
			if(form.txtApaterno.value.length<=0)return false;
			if(form.txtAmaterno.value.lengtht<=0)return false;
			if(form.cmbTipodoc.value.length<=0)return false;
			if(form.txtNrodoc.value.length<=0)return false;
			if(form.fFecNacimiento.value.lengtht<=0)return false;
			if(form.fFecRegistro.value.length<=0)return false;
			if(form.txtCorreo.value.length<=0)return false;			
	return true;
		
		
		}
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function verificar_fecha(comparacion,fecha1,fecha2){
		var fec1=fecha1.value.split("/");
		var fec2=document.getElementById(fecha2).value.split("/");
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
					fecha1.value=document.getElementById(fecha2).value;			
				}
				
			} 
		else{
			alert("Error al comparar fechas");
		}			
	}
	
	
	function alfanumerico(e) 
	{ 
	var key = window.event.keyCode || event.keyCode;
	return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
	} 	
	
	
	function alt_submit(){
		var form= document.frmUpdate;
		if(validaForm()) form.submit();
			
			}
		
		
		
			//document.fmrData.submit();

	</script>	
	<%! public boolean  encontrar(String a, String[] b){
		for(int i=0;i<b.length;i++){			
			if(b[i].equals(a)) return true;	
		}
	return false;
	}
	
	public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM");
		return DF.format(date);
	}
	
	public String generarCadena(String[] t){
		String a="";
		for(int i=0;i<t.length;i++){
			a= a.concat(t[i]+"/");
			if(a.length()>0) a=a.substring(0, a.length()-1);}
		return a;
	}
	
	
	%>
	
	
<%
Calendar c1 = GregorianCalendar.getInstance();
c1.add(Calendar.YEAR, 1);
SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecAnoIni=dfActual.format(  c1.getTime() );

    
    
    
String fecAnoFin=dfActual.format(new java.util.Date()); %>
		
</head>

<body>
		<jsp:include page="/IngSoft/general/superior.jsp" />
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<jsp:include page="/IngSoft/general/leftmenu.jsp" />
						<!-- left menu ends -->
			
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
		
			<div id="content" class="span10">
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="../../general/index.jsp">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="buscarinvitado.jsp">Mantenimiento de Invitado</a> <span class="divider">/</span>
					</li>
					
					
					<li>
						Agregar Invitado
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-edit"></i>AGREGAR INVITADO</h2>
				  </div>
					<div class="box-content">
					
					
						<form class="form-horizontal" name="frmUpdate" action="<%= response.encodeURL("SMAInvitado")%>" method="post">
						
						
						<input type="hidden" name="accion" value="Agregar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  
						  
						  
						  <fieldset>
						  
						  


							<div class="control-group" id="dvNombre" >
						      <label class="control-label" for="typeahead7">Nombre (*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" 
						        id="txtNombre" name="txtNombre" 
						        data-provide="typeahead" >
					          	<span class="help-inline" id="errNombre">Please correct the error</span>
					          </div>
					        </div>
					        
					        <div class="control-group" id="dvApaterno" >
						      <label class="control-label" for="typeahead7">Apellido Paterno (*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" 
						        id="txtApaterno" name="txtApaterno" 
						        data-provide="typeahead" >
					          	<span class="help-inline" id="errApaterno">Please correct the error</span>
					          </div>
					        </div>

						    
							<div class="control-group" id="dvAmaterno" >
						      <label class="control-label" for="typeahead7">Apellido Materno (*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" 
						        id="txtAmaterno" name="txtAmaterno" 
						        data-provide="typeahead" >
					          	<span class="help-inline" id="errAmaterno">Please correct the error</span>
					          </div>
					        </div>
					          
						    <div class="control-group">
								<label class="control-label" for="selectError">Tipo de Doc.(*):</label>
								<div class="controls">
								  <select  id="selectError" data-rel="chosen" name="cmbTipodoc">
									<option>DNI</option>
									<option>Carnet de Extranjer&iacutea</option>
									<option>Pasaporte</option>

								
								  </select>
								</div>
							  </div>
							  
							  
						  					   
							
							<div class="control-group" id="dvNrodoc">
						      <label class="control-label" for="typeahead6">Nro. de Doc(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" 
						        id="txtNrodoc" name="txtNrodoc" 
						        data-provide="typeahead" >
					          	<span class="help-inline" id="errNrodoc">Please correct the error</span>
					          </div>
					        </div>



							  <div class="control-group" id="dvFecNacimiento">
							  <label class="control-label" for="typeahead7" name="fFecNacimiento">Fecha Nacimiento(*): </label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker"  id="fFecNacimiento" name="fFecNacimiento" value="01/01/1990" readonly="readonly">
			                	<span class="help-inline" id="errFecNacimiento">Please correct the error</span>
							  </div>
							</div>
							
							 <div class="control-group" id="dvFecRegistro">
			              <label class="control-label" for="typeahead6">Fecha Registro (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="fFecRegistro" name="fFecRegistro" value="<%=fecAnoFin%>" readonly="readonly">
			                  <span class="help-inline" id="errFecRegistro">Please correct the error</span>
			                </div>
		                  </div>
							
									   
					        
					        <div class="control-group" id="dvCorreo" >
						      <label class="control-label" for="typeahead7">Correo (*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" 
						        id="txtCorreo" name="txtCorreo" 
						        data-provide="typeahead" >
					          	<span class="help-inline" id="errCorreo">Please correct the error</span>
					          </div>
					        </div>




						    <div class="control-group" id="dvTelefonofijo">
						      <label class="control-label" for="typeahead9"> Tel&eacutefono Fijo: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtTelefonofijo"  name="txtTelefonofijo" data-provide="txtTelefonofijo" data-items="4" >
					          	<span class="help-inline" id="errTelefonofijo">Please correct the error</span>
					          </div>
					        </div>


						    <div class="control-group" id="dvTelefonocelular">
						      <label class="control-label" for="typeahead10"> Tel&eacutefono Celular: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtTelefonocelular"  name="txtTelefonocelular"  data-provide="txtTelefonocelular" data-items="4" >
					          	<span class="help-inline" id="errTelefonocelular">Please correct the error</span>
					          </div>
					        </div>
        
					        

					   

								<input type="hidden" name="optionsRadios" value="Activo"></input>


							
							
						   		 <div class="form-actions">
							  		<button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>
							  		<button type="button" class="btn" onclick="location.href='buscarinvitado.jsp'" >Cancelar</button>
								</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->		 
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<jsp:include page="/IngSoft/general/inferior.jsp" />
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
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
	2: Validaci�n de cantidad de caracteres de fecha
	3: validacion de llenado de radio button
	4: Validacion de alfanumerico
	5: validacion de valores Float
	6: Validacion de enteros
	7: validacion de fechas con formato dd/mm/YYYY
	8: No vale
	9: Validacion de correos
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
	if(!esValido("Nombre",form.txtNombre,"Nombre",1,1,50)){cadena[i]="Nombre";i++;}
	if(!esValido("Apellido Paterno",form.txtApaterno,"Apaterno",1,1,50)){cadena[i]="Apellido Paterno";i++;}
	if(!esValido("Apellido Materno",form.txtAmaterno,"Amaterno",1,1,50)){cadena[i]="Apellido Materno";i++;}
	if(!esValido("Nro. de Doc",form.txtNrodoc,"Nrodoc",1,8,8)){cadena[i]="Nro. de Doc";i++;}else{
		if(!esValido("Nro. de Doc",form.txtNrodoc,"Nrodoc",6,1,50)){cadena[i]="Nro. de Doc";i++;}
	}
	if(!esValido("Correo",form.txtCorreo,"Correo",9,1,50)){cadena[i]="Correo";i++;}
	if(!esValido("Fecha Nacimiento",form.fFecNacimiento,"FecNacimiento",2,1,10)){cadena[i]="Fecha Nacimiento";i++;}
	if(!esValido("Fecha Registro",form.fFecRegistro,"FecRegistro",2,1,10)){cadena[i]="Fecha Registro";i++;}
	if(!validarFechas("Fecha Registro",form.fFecRegistro,"FecRegistro","Fecha Nacimiento",form.fFecNacimiento)){cadena[i]="Fecha Registro";i++;};
	if(!esValido("Tel&eacutefono Fijo",form.txtTelefonofijo,"Telefonofijo",1,6,7)){cadena[i]="Tel&eacutefono Fijo";i++;}else{
		if(!esValido("Tel&eacutefono Fijo",form.txtTelefonofijo,"Telefonofijo",6,1,50)){cadena[i]="Tel&eacutefono Fijo";i++;}
	}
	if(!esValido("Tel&eacutefono Celular",form.txtTelefonocelular,"Telefonocelular",1,9,9)){cadena[i]="Tel&eacutefono Celular";i++;}else{
		if(!esValido("Tel&eacutefono Celular",form.txtTelefonocelular,"Telefonocelular",6,1,50)){cadena[i]="Tel&eacutefono Celular";i++;}
	}
	
	
	/*if(!esValido("Fecha Inicio",form.fFechInicio,"FechaInicio",2,1,10)){cadena[i]="Fecha Inicio";i++;}
	
	if(!esValido("Fecha Fin",form.fFechFin,"FechaFin",2,1,10)){
		cadena[i]="Fecha Fin";i++;
	}else{
		if(!validarFechas("Fecha Final",form.fFechFin,"FechaFin","Fecha Inicio",form.fFechInicio)){
		cadena[i]="Fecha Fin";i++;
		}
	}
	
	if(!esValido("Fecha Sorteo",form.fFechSorteo,"FechaSorteo",2,1,10)){
		cadena[i]="Fecha Sorteo";i++;
	}else{
		if(!validarFechas("Fecha Sorteo",form.fFechSorteo,"FechaSorteo","Fecha Fin",form.fFechFin)){
		cadena[i]="Fecha Sorteo";i++;
		}
	}*/
	//if(!esValido("RUC",form.txtRuc,"Ruc",2,1,11)){cadena[i]="RUC";i++;}
	//else{
	
	//if(!esValido("RUC",form.txtCosto,"Ruc",6,1,1)){cadena[i]="RUC";i++;}
	
	//}
	//if(!esValido("Fecha Fin",form.fFechaFin,"FechaFin",2,1,10)){cadena[i]="Fecha Fin";i++;}
	//if(!validarFechas("Fecha Final",form.fFechaFin,"FechaFin","Fecha Inicio",form.fFechaInicio)){cadena[i]="Fecha Fin";i++;};
	//if(!esValido("Socio",form.txtSocio,"Socio",1,1,50)){cadena[i]="Socio";i++;}
	//if(!esValido("Periodo",form.cmbPeriodo,"Periodo",1,1,50)){cadena[i]="Periodo";i++;}
	//if(!esValido("Costo",form.txtCosto,"Costo",1,1,50)){
		//cadena[i]="Costo";i++;
	//}else{
		//valida si es float o entero
		//if(!esValido("Costo",form.txtCosto,"Costo",5,1,1)){cadena[i]="Costo";i++;}
	//}
	//if(!esValido("Estado",form.rButton,"Estado",3,1,1)){cadena[i]="Estado";i++;}
	
	
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
	document.getElementById("errNombre").style.display='none';
	document.getElementById("errApaterno").style.display='none';
	document.getElementById("errAmaterno").style.display='none';
	document.getElementById("errNrodoc").style.display='none';
	document.getElementById("errCorreo").style.display='none';
	//document.getElementById("errRuc").style.display='none';
	document.getElementById("errFecNacimiento").style.display='none';
	document.getElementById("errFecRegistro").style.display='none';
	document.getElementById("errTelefonofijo").style.display='none';
	document.getElementById("errTelefonocelular").style.display='none';
	//document.getElementById("errFechaSorteo").style.display='none';
	//document.getElementById("errSocio").style.display='none';
	//document.getElementById("errCosto").style.display='none';
	//document.getElementById("errPeriodo").style.display='none';
	
}


inicializa();

</script>
		
</body>
</html>
