<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@page import="IngSoft.servicio.bean.AmbienteMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.HorarioEmpleados"%>
<%@page import="IngSoft.administracion.bean.*"%>

<html lang="en">
<head>

	<meta charset="utf-8">
	<title>CONAN 3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Dos Virgenes">
	<meta name="author" content="Dos Virgenes">
		<!--The beans  -->
	
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="horarios" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="perfiles" scope="request"class="java.util.Vector"></jsp:useBean>

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
		
		

  
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#txtFechaNacimiento" ).datepicker({ minDate: "-100Y", maxDate: "-18Y", changeMonth:true,changeYear:true  });
     
  });
  </script>

		
		<script>
	function alfanumerico(e) 
	{ 
		var key = window.event.keyCode || event.keyCode;
		return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
	} 	
	
	function validar(form){
			if(form.txtRazonSocial.value.length <=0)return false;
			if(form.txtRuc.value.length<=0)return false;
			if(form.txtTelefono.value.lengtht<=0)return false;
			if(form.txtCorreo.value.length<=0)return false;
	return true;
		
		
		}
	
	
	
	function alt_submit(){
		var form= document.frmData;
		if(validaForm()) form.submit();
			
			}
	
	

	</script>
		
		
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
							<li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home</a> / <a href="buscarempleado.jsp">Mantenimiento de
									Empleados</a> / Agregar Empleado</li>
						</ul>
					</div>
			  
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2> AGREGAR EMPLEADO</h2>
		          </div>
				  
			      <div class="box-content">
			        <form class="form-horizontal" action="<%= response.encodeURL("SMSEmpleado")%>" name="frmData" method="post">
						<input type="hidden" name="accion" id="accion" value="Agregar"></input>
						<input type="hidden" name="tipo" id="tipo" value="2"></input>
			          <fieldset>
							
							<div class="control-group" id="dvNombreEmpleado">
							  
							  <label class="control-label" for="nombres">Nombres (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNombreEmpleado" name="txtNombreEmpleado" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  <span class="help-inline" id="errNombreEmpleado">Please correct the error</span>
							  </div>
							</div>
							
							<div class="control-group" id="dvApellidoPaterno" >
							  <label class="control-label" for="paterno">Apellido Paterno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoPaterno" name="txtApellidoPaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  <span class="help-inline" id="errApellidoPaterno">Please correct the error</span>
							  </div>
							</div>
							
							<div class="control-group" id="dvApellidoMaterno">
							  <label class="control-label" for="materno">Apellido Materno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoMaterno" name="txtApellidoMaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>														
							  <span class="help-inline" id="errApellidoMaterno">Please correct the error</span>
							  </div>
							</div>
							
							<div class="control-group" id="dvFechaNacimiento">
							  <label class="control-label" for="fechaNacimiento">Fecha de Nac. (*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="txtFechaNacimiento"  name="txtFechaNacimiento"  maxlength="10" onpaste="return false;">
							  <span class="help-inline" id="errFechaNacimiento">Please correct the error</span>
							  </div>
							</div>
							
							<div class="control-group" id="dvFechaContrato">
							  <label class="control-label" for="fechaContrato">Fecha de Contrato. (*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="txtFechaContrato" name="txtFechaContrato" >
							  <span class="help-inline" id="errFechaContrato">Please correct the error</span>
							  </div>
							</div>
							
							
							<div class="control-group" id="dvTipoDocumento">
								<label class="control-label" for="cmbTipoDocumento">Tipo de Documento (*):</label>
								<div class="controls">
								  <select name="cmbTipoDocumento" id="cmbTipoDocumento" name="cmbTipoDocumento"  data-rel="chosen">
									<option>DNI</option>
									<option>Carnet de extranjeria</option>
									</select>
								</div>
							</div>
							
							<div class="control-group" id="dvNumeroDocumento">
							  <label class="control-label" for="txtNumeroDocumento">Numero de Documento (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNumeroDocumento" name="txtNumeroDocumento" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>														
							  <span class="help-inline" id="errNumeroDocumento">Please correct the error</span>
							  </div>
							</div>
							
																										
							
							 <div class="control-group" id="dvHorarios" >
								<label class="control-label" for="cmbHorarios">Horario de Trabajo(*):</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbHorarios" name="cmbHorarios" >
									<%for(int i=0;i<horarios.size();i++){ %>
										<option value="<%= ((HorarioEmpleados)horarios.get(i)).getCodigo()%>"><%= ((HorarioEmpleados)horarios.get(i)).getDescripcion()%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errHorarios" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>
							
							<div class="control-group" id="dvArea">
								<label class="control-label" for="cmbArea">&Aacute;rea (*):</label>
								<div class="controls">
								  <select name="cmbArea" id="cmbArea" data-rel="chosen">
									<option>GERENCIA</option>
									<option>ADMINISTRACION</option>
									<option>OPERACIONES</option>
								  </select>
								</div>
							</div>						
							<div class="control-group" id="dvPuesto">
								<label class="control-label" for="cmbPuesto">Puesto (*):</label>
								<div class="controls">
								  <select name="cmbPuesto" id="cmbPuesto" data-rel="chosen">
									<option>Gerente</option>
									<option>Administrador</option>
									<option>Operador</option>
									 </select>
								</div>
							</div>							
							  <div class="control-group" id="dvSedes">
								<label class="control-label" for="cmbSedes">Sedes de Trabajo(*):</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errSedes" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>
							  <div class="control-group" id="dvSedes">
								<label class="control-label" for="cmbPerfil">Perfil Asignado:</label>
								<div class="controls">
								  <select   data-rel="chosen" id="cmbPerfil" name="cmbPerfil" >
									<%for(int i=0;i<perfiles.size();i++){ %>
										<option value="<%= ((HashMap<String,Object>)perfiles.get(i)).get("idPerfil")%>"><%= ((HashMap<String,Object>)perfiles.get(i)).get("Nombre")%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errSedes" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>																									
						
			            <div class="form-actions">
							<button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
							<button type="button" class="btn" onclick="location.href='buscarempleado.jsp'" >Cancelar</button>
										</div>
		                
		              </fieldset>
		            </form>
		            (*) Campos Obligatorios
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			 		 		  
       
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
				<a href="#" class="btn" data-dismiss="modal">Cerrar</a>
				<a href="#" class="btn btn-primary">Guardar Cambios</a>
			</div>
		</div>

		<footer>
		  <p class="pull-left"><a href="http://usman.it/free-responsive-admin-template">Conan 3000</a> &copy;  2013</p>
          <p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Dos V&iacute;rgenes</a></p>
		</footer>
		
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
			2: Validación de cantidad de caracteres de fecha
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
			
			
			var form=document.frmData;

			var cadena= new Array();
			var i=0;
			var error=false;	
			var tipoDocumento = frmData.cmbTipoDocumento.value;
			
			
			if(!esValido("Nombres",form.txtNombreEmpleado,"NombreEmpleado",1,1,50)){cadena[i]="Nombres";i++;}
			
			//else{
			
			//if(!esValido("Nombres",form.txtNombreEmpleado,"NombreEmpleado",4,1,50)){cadena[i]="Nombres";i++;}
			
			
			//}
			
			
			if(!esValido("Apellido Paterno",form.txtApellidoPaterno,"ApellidoPaterno",1,1,50)){cadena[i]="Apellido Paterno";i++;}

			if(!esValido("Apellido Materno",form.txtApellidoMaterno,"ApellidoMaterno",1,1,50)){cadena[i]="Apellido Materno";i++;}
			
			
			
 			if  (tipoDocumento == "DNI"){
			
 				//alert(tipoDocumento);
 				
 				if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",1,8,8)){cadena[i]="Numero de Documento";i++;}
			
 					else{
				
 				if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",6,8,8)){cadena[i]="Numero de Documento";i++;}
			
 				}
			
 			}
			
			else if(tipoDocumento == "Carnet de extranjeria"){
				
				//alert("entre");
				
 				if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",1,11,11)){cadena[i]="Numero de Documento";i++;}
				
 				else{
			
 			if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",6,11,11)){cadena[i]="Numero de Documento";i++;}
		
			}
				
			
 			}
			
			
			if(!esValido("Fecha Nacimiento",form.txtFechaNacimiento,"FechaNacimiento",2,1,10)){cadena[i]="Fecha de Nacimiento";i++;}
			
			if(!esValido("Fecha de Contrato",form.txtFechaContrato,"FechaContrato",2,1,10)){cadena[i]="Fecha de Contrato";i++;}
			
			else{
				if(!validarFechas("Fecha de Contrato",form.txtFechaContrato,"FechaContrato","Fecha de Nacimiento",form.txtFechaNacimiento)){
				cadena[i]="Fecha de Contrato";i++;
				}
			}
			
			if(!esValido("Horario de Trabajo",form.cmbHorarios,"Horarios",1,1,50)){cadena[i]="Horario de Trabajo";i++;}
			
			if(!esValido("Sedes de Trabajo",form.cmbSedes,"Sedes",1,1,50)){cadena[i]="Sedes de Trabajo";i++;}
			
			
// 			if(!esValido("Fecha Fin",form.fFecFin,"FechaFin",2,1,10)){
// 				cadena[i]="Fecha Fin";i++;
// 			}else{
// 				if(!validarFechas("Fecha Final",form.fFecFin,"FechaFin","Fecha Inicio",form.fFecInicio)){
// 				cadena[i]="Fecha Fin";i++;
// 				}
// 			}
			
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
			document.getElementById("errNombreEmpleado").style.display='none';
			document.getElementById("errApellidoPaterno").style.display='none';
			document.getElementById("errApellidoMaterno").style.display='none';
			document.getElementById("errNumeroDocumento").style.display='none';
			document.getElementById("errFechaNacimiento").style.display='none';
			document.getElementById("errFechaContrato").style.display='none';
			document.getElementById("errHorarios").style.display='none';
			document.getElementById("errSedes").style.display='none';
		}


		inicializa();

		</script>
				
		</body>
		</html>