<!DOCTYPE html>
<%@page import="IngSoft.servicio.bean.TipoEventoMiniBeanData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.administracion.bean.*"%>
<%@page import="IngSoft.servicio.bean.*"%>
<%@page import="java.util.Vector"%>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>CONAN 3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Dos virgenes">
	
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tiposEvento" scope="request"class="java.util.Vector"></jsp:useBean>

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

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">

<script>
			
			function alfanumerico(e) 
			{ 
				var key = window.event.keyCode || event.keyCode;
				return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
			} 	
			function alt_fecha(obj){
			obj.value=obj.value.slice(0,10);
			
			}
			
	
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_eliminar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Eliminar";
		form.codigo.value=cod;
		form.submit();
	}
	
	function alt_submit(){
		
		var form= document.frmCriteriosBusqueda;
		if(validaForm(form))   
			form.submit();
		 			
			}
	function alt_Insertar(cod,name){
		
		parent.anhadiremp(cod,name);
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
					<li>
						<a href="/Conan3000V2/IngSoft/general/index.jsp">Home</a> <span class="divider">/</span>
					</li>
					<li>
						Mantenimiento de Empleados 
					</li>
					
				</ul>
			</div>
			
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR EMPLEADO</h2>
		          </div>
		        <div class="box-content">
		         <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  action="<%= response.encodeURL("SMSEmpleado")%>" method="post" >
		             <input type="hidden" name="accion" value="Seleccionar"></input>
		            <fieldset>		              			 
		            
		           						
						<div class="control-group" id=dvNombreEmpleado>
							  <label class="control-label" for="nombres">Nombres (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNombreEmpleado" name="txtNombreEmpleado" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							   <span class="help-inline" id="errNombreEmpleado">Please correct the error</span>
							  </div>
							</div>
							
							<div class="control-group" id=dvApellidoPaterno>
							  <label class="control-label" for="paterno">Apellido Paterno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoPaterno" name="txtApellidoPaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  <span class="help-inline" id="errApellidoPaterno">Please correct the error</span>
							  </div>
							</div>
							
							
							<div class="control-group" id=dvNumeroDocumento>
							  <label class="control-label" for="txtNumeroDocumento">Numero de Documento (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNumeroDocumento" name="txtNumeroDocumento" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>														
							  <span class="help-inline" id="errNumeroDocumento">Please correct the error</span>
							  </div>
							</div>						
						
					<div class="control-group">
								<label class="control-label" for="cmbArea">&Aacute;rea (*):</label>
								<div class="controls">
								  <select name="cmbArea" id="cmbArea" data-rel="chosen">
									<option>TODOS</option>
									<option>GERENCIA</option>
									<option>ADMINISTRACION</option>
									<option>OPERACIONES</option>
								  </select>
								</div>
							</div>		
											
					  
		              <div class="form-actions">
		                 <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Buscar</button>
							          
	                  </div>
					  
	                </fieldset>
	              </form>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		
		  	
					
						
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
      <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> 
		            
		           <a class="btn btn-primary" href="javascript:alt_agregar()">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
		            
		            <thead>
		              <tr>
		                <th>Codigo</th>
		                <th>Nombre</th>
		                <th>Apellido</th>
		                <th>Area</th>
		                <th>Acci&oacuten</th>
	                  </tr>
	                </thead>
		           
		            <tbody id="resultadoBusqueda">
		              <%
		              	SimpleDateFormat df= new SimpleDateFormat("dd/MM"); 
		                                       for(int i=0; 
		                                        i<resultados.size(); i++)
		                                       {
		              %>

							                		<tr>
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()
                          				%>
                          			</td>
                          			
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          			<!-- cambio del getApaterno() -->
                          			
                          			<%=
                          				((ResultadoEmpleadoBeanData)resultados.get(i)).getApaterno()
                          				%>
                          			</td>
                          				                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getArea()
                          				%>
                          			
                          				
                          			</td>

                          	
                          				
                          				  <td class="center">
		                <a class="btn btn-success"
                          					href="javascript:alt_Insertar('<%=((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()%>','<%= ((ResultadoEmpleadoBeanData)resultados.get(i)).getNombre() %>')">
                          					 <i class="icon-zoom-in icon-white"></i>Seleccionar </a> 
		    
                     </td>
                          				
                          				
                          			
                          
                          		</tr>


									<%
										}
									%>
	                </tbody>
	              </table>
	            </div>
				</div><!--/span-->
	          </div>
		      <!--/span-->
	        </div>
	        
	        
	        
		    <!--/row-->
		    <!-- content ends -->
	      </div>
		  <!--/#content.span10-->
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

		<footer>
		  <p class="pull-left"><a href="http://usman.it/free-responsive-admin-template">Buscar Empleado</a> &copy;  2013</p>
          <p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Dos V&iacute;rgenes</a></p>
		</footer>
		
	</div>	<!--/.fluid-container-->

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
	
	
	var form=document.frmCriteriosBusqueda;
	
	var cadena= new Array();
	var i=0;
	var error=false;
	
    //var correo = frmData.txtCorreo.value;
    //var telefono = frmData.txtTelefono.value;
    //var correo = "viejo"
    //alert(correo);
	
	

	//if(!esValido("Nombres",form.txtNombreEmpleado,"NombreEmpleado",1,1,50)){cadena[i]="Nombres";i++;}
	
	//if(!esValido("Nombres",form.txtNombreEmpleado,"NombreEmpleado",1,1,50)){cadena[i]="Nombres";i++;}
	
	//else{
    	
	//	if(!esValido("Nombres",form.txtNombreEmpleado,"NombreEmpleado",4,1,50)){cadena[i]="Nombres";i++;}
		
	//}
	
	//if(!esValido("Apellido Paterno",form.txtApellidoPaterno,"ApellidoPaterno",1,1,50)){cadena[i]="Apellido Paterno";i++;}
    
	
	//else{
    	
		//if(!esValido("Apellido Paterno",form.txtApellidoPaterno,"ApellidoPaterno",4,1,50)){cadena[i]="Apellido Paterno";i++;}
		
//	}
	
	
	//if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",1,0,11)){cadena[i]="Numero de Documento";i++;}
	
//	else{
	
	//	if(!esValido("Numero de Documento",form.txtNumeroDocumento,"NumeroDocumento",6,0,11)){cadena[i]="Numero de Documento";i++;}
	
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
	//document.getElementById("errNombreEmpleado").style.display='none';
	//document.getElementById("errNumeroDocumento").style.display='none';
	//document.getElementById("errApellidoPaterno").style.display='none';
	//document.getElementById("errTelefono").style.display='none';
	//document.getElementById("errCorreo").style.display='none';
	//document.getElementById("errFechaInicio").style.display='none';
	//document.getElementById("errFechaFin").style.display='none';
	//document.getElementById("errSocio").style.display='none';
	//document.getElementById("errCosto").style.display='none';
	//document.getElementById("errPeriodo").style.display='none';
	
}


inicializa();

</script>

</body>
</html>
