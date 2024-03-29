<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoMembresiaBeanData"%>
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
	<title>Traslado Membresia</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

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
	<link rel="shortcut icon" href="img/favicon.ico">
		
		
	<script>
	function validaFloat(numero)
{
  if (!/^([0-9])*[.]?[0-9]*$/.test(numero.value)){
	  if(!validarEntero(numero.value)){
	   validarxId('Monto',"El Monto debe ser un valor entero o decimal");
		return false;
	   }else{
	   MostrarOkDivInput('Monto');
	   return true;
	   }
   }else{
   MostrarOkDivInput('Monto');
    return true;
   }
}
function validarEntero(valor){ 
 
 valor = parseInt(valor); 
 	if (isNaN(valor)) { 
       	 return true;
 	}else{ 
       	 return false; 
 	}
}
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_agregarMembresia(){
		var form=document.getElementById("frmMembresia");
		form.accion.value="Agregar";
		form.submit();
	}
	
	
	function alt_agregar(){
		var form=document.getElementById("frmSocio");
		form.accion.value="Agregar";
		form.submit();
	}
	
	
	function alt_consultar(cod){
		var form=document.getElementById("frmSocio");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
		var form=document.getElementById("frmSocio");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_eliminar(cod){
		var form=document.getElementById("frmSocio");
		form.accion.value="Eliminar";
		form.codigo.value=cod;
		form.submit();
	}
	
	function validar(form){
			if(form.fFecha.value.length <=0)return false;
			if(form.txtMonto.value.length<=0)return false;
			//if(form.fFechFin.value.lengtht<=0)return false;
			//if(form.txtDescripcion.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
	return true;
		
		
		}




	function alt_submit(){
		var form= document.frmTraslado;
		if(validaForm()) form.submit();
		//else alert("Uno o mas campos estan vacios");
			
}
</script>

<%
Calendar c1 = GregorianCalendar.getInstance();
c1.add(Calendar.YEAR, 1);
SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecAnoIni=dfActual.format(new java.util.Date());
 %>		
</head>

<!--The beans  -->
	<jsp:useBean id="membresia" scope="session"class="IngSoft.venta.bean.MembresiaBeanData"></jsp:useBean>
	<jsp:useBean id="socio" scope="request"class="IngSoft.venta.bean.SocioBeanData"></jsp:useBean>
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	

	
<style type="text/css" media="screen"> 
.izquierda { 
   
    float: left; 
} 
 
.derecha { 
   padding: 9px;
    float: center; 
} 
</style> 
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
			   			      
			        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="../membresia/buscarmembresia.jsp">Mantenimiento de Membres&iacute;a</a> <span class="divider">/</span></li>
		        <li>Traslado de Membres&iacute;a</li>
			      
		        </ul>
		      </div>
		      <%String codigo =membresia.getIdMembresia(); %>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-user"></i>TRASLADO DE MEMBRES&Iacute;�A</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" id="frmSocio" name="frmSocio" method="POST" action="<%= response.encodeURL(request.getContextPath()+"/IngSoft/ventas/socio/SMVSocio")%>">
			        	    <input type="hidden" name="accion" value="Agregar"></input>
			  				<input type="hidden" name="codigo" value=""></input>
			 				<input type="hidden" name="tipo" value="1"></input>
			 				
			 				
			 				  
			         </form>
			         
			         <form  id="frmMembresia" name="frmMembresia" method="POST" action="<%= response.encodeURL(request.getContextPath()+"/IngSoft/ventas/membresia/SMVMembresia")%>">
			        	    <input type="hidden" name="accion" value="Agregar"></input>
			  				<input type="hidden" name="codigo" value=""></input>
			 				<input type="hidden" name="tipo" value="1"></input>
			 				 
			         </form>
			        
		
			         
			         <form class="form-horizontal" name="frmTraslado" id="frmTraslado"method="POST" action="<%= response.encodeURL(request.getContextPath()+"/IngSoft/ventas/membresia/SMVTraslado")%>">
			          <input type="hidden" name="accion" value="Agregar"></input>
			          <input type="hidden" name="tipo" value="2"></input>
			             <input type="hidden" name="fFechaFin" value="26/05/2014"></input>
			         <fieldset>
			        		        
			         
			            <div class="control-group" id="dvIdMembresiaAntiguo">
			              <label class="control-label" for="typeahead1">Membres&iacute;a del socio:</label>
			              <div class="controls">
			               <!--  <input type="text" disabled class="span6 typeahead" value="membresia.getIdMembresia()"  id="txtIdMembresiaAntiguo" name="txtIdMembresiaAntiguo"  >  -->
			                	<input type="text"   id="txtIdMembresiaAntiguo" name="txtIdMembresiaAntiguo"  data-provide="typeahead" data-items="4" value="<%=membresia.getIdMembresia()%>" >
			                	<span class="help-inline" id="errIdMembresiaAntiguo">Please correct the error</span>
			              </div>
		                </div>
		                
                          <div class="control-group" id="dvIdNuevoSocio">
			              <label class="control-label" for="typeahead2">Nuevo socio(*):</label>
		                <div class="controls">
		                
			                  <!-- agregar nuevo boton -->
			                   <input type="text"   id="txtIdNuevoSocio" name="txtIdNuevoSocio"  value=""  data-provide="typeahead" > 
			        			<span class="help-inline" id="errIdNuevoSocio">Please correct the error</span>
			        
						 <a  class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar</a>  
						      
					     </div>
		                </div>
		                
		                   <div class="control-group" id="dvIdMembresiaNuevo">
			              <label class="control-label" for="typeahead3">Membres&iacute;a del nuevo socio(*):</label>
		                <div class="controls">
		                
			                  <!-- agregar nuevo boton -->
			                   <!-- <input type="text"  disabled class="span6 typeahead" id="txtIdMembresiaNuevo" name="txtIdMembresiaNuevo" value="//socio.getIdMembresia()"  > --> 
			        			<input type="text"   id="txtIdMembresiaNuevo"  name="txtIdMembresiaNuevo" data-provide="typeahead" data-items="4" value="" >
			        			<span class="help-inline" id="errIdMembresiaNuevo">Please correct the error</span>
						<!--  <a  class="btn btn-primary" href="javascript:alt_agregarMembresia()" > <i class="icon icon-add icon-white" ></i> Agregar</a>   -->
						      
					     </div>
		                </div>
		                		                
                        <div class="control-group" id="dvFecha">
							  <label class="control-label" for="date01">Fecha Inicio(*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFechaInicio" name="fFechaInicio" value="<%=fecAnoIni%>"" readonly="readonly" >
								<span class="help-inline" id="errFecha">Please correct the error</span>
							  </div>
							</div>
							
							<!-- <div class="control-group" id="dvFechaFin" >
							  <label class="control-label" for="date01">Fecha Fin(*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFechaFin" name="fFechaFin" value="31/01/2013" readonly="readonly" >
								<span class="help-inline" id="errFechaFin">Please correct the error</span>
							  </div>
							</div> -->
                        
                        <div class="control-group" id="dvParentesco">
			                <label class="control-label" for="selectError">Parentesco(*):</label>
			                <div class="controls">
			                  <select  name="cmbParentesco" id="cmbParentesco" data-rel="chosen">
			                    <option selected>Hija(o)</option>
			                    <option>Madre</option>
			                    <option>Padre</option>
		                      </select>
							  <span class="help-inline" id="errParentesco">Please correct the error</span>
		                    </div>
		                  </div>
                      
			              
			              <div class="control-group" id="dvMonto">
			                <label class="control-label" for="typeahead4">Monto(*):</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge typeahead" id="txtMonto" name="txtMonto" data-provide="typeahead" data-items="4" >
			                  <span class="help-inline" id="errMonto">Please correct the error</span>
		                    </div>
		                  </div>
			           
			            <div class="form-actions">
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Aceptar</button>
			               <a  class="btn" href="../membresia/buscarmembresia.jsp">  Cancelar</a>  
			             
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
	function loadContent() 
{ 
   $("#includedContent").load("menu.html"); 
} 


	</script>
		<script>loadContent()</script> 
		
		
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
	minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
	
	El valor que va en cadena[i] es el nombre del campo
	
	#############################ADICIONAL#########################
	Para validar una fecha Inicial y fecha Final usar la siguiente funcion
	validarFechas(nombre[Fecha Final], casilla[Fecha Final], id[Fecha Final],nombre[Fecha Inicial],casilla[Fecha Inicial])
	OJO: no va como parametro el id de la fecha Inicial
	###############################################################
	
	*/
	
	var form=document.frmTraslado;

	var cadena= new Array();
	var i=0;
	var error=false;
	if(!esValido("Membresia socio",form.txtIdMembresiaAntiguo,"IdMembresiaAntiguo",1,1,9)){cadena[i]="Membresia socio";i++;}
	if(!esValido("Codigo nuevo socio",form.txtIdNuevoSocio,"IdNuevoSocio",1,1,9)){cadena[i]="Codigo nuevo socio";i++;}
	if(!esValido("Membresia nueva",form.txtIdMembresiaNuevo,"IdMembresiaNuevo",1,1,9)){cadena[i]="Membresia nueva";i++;}
	if(!esValido("Fecha Inicio",form.fFechaInicio,"Fecha",1,1,10)){cadena[i]="Fecha Inicio";i++;}
	//if(!esValido("Fecha Fin",form.fFechaFin,"FechaFin",1,1,10)){cadena[i]="Fecha Fin";i++;}
	if(!esValido("Parentesco",form.cmbParentesco,"Parentesco",1,1,50)){cadena[i]="Parentesco";i++;}
	if(!esValido("Monto",form.txtMonto,"Monto",1,1,50)){
		cadena[i]="Monto";i++;
	}else{
		//valida si es float o entero
		if(!esValido("Monto",form.txtMonto,"Monto",5,1,1)){cadena[i]="Monto";i++;}
	}
	//if(!esValido("Descripcion",form.txtDescripcion,"Descripcion",1,1,100)){cadena[i]="Descripcion";i++;}
	
	
	//No tocar
	if(i>0){
	crearAlert(cadena);
	return false;
	}else{
		return true;
		
	}

}

inicializa();

function inicializa(){
	document.getElementById("errIdMembresiaAntiguo").style.display='none';
	document.getElementById("errIdNuevoSocio").style.display='none';
	document.getElementById("errIdMembresiaNuevo").style.display='none';
	document.getElementById("errFecha").style.display='none';
	//document.getElementById("errFechaFin").style.display='none';
	document.getElementById("errParentesco").style.display='none';
	document.getElementById("errMonto").style.display='none';
	
}

</script>	
</body>
</html>
