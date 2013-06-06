<!DOCTYPE html>
<%@page import="IngSoft.servicio.bean.AmbienteMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.HorarioEmpleados"%>

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
					<li>
						<a href="#">Inicio</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">Mantenimiento de Empleados</a> <span class="divider">/</span>
					</li>
					<li>
						Agregar Empleado
					</li>
				</ul>
			</div>
			  
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2> AGREGAR EMPLEADO</h2>
		          </div>
				  
			      <div class="box-content">
			        <form class="form-horizontal" action="<%= response.encodeURL("SMSEmpleado")%>" onsubmit="alt_submit(); return false;"name="frmData" method="post">
			          <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="nombres">Nombres (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNombreEmpleado" name="txtNombreEmpleado" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="paterno">Apellido Paterno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoPaterno" name="txtApellidoPaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="materno">Apellido Materno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoMaterno" name="txtApellidoMaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>														
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="fechanacimiento">Fecha de Nac. (*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="txtfechanacimiento" name="txtfechanacimiento" readonly="true" value="">
							  </div>
							</div>
							
							<div class="control-group">
							<label class="control-label" for="dni">Tipo de Documento (*):</label>
							<div class="controls">
							  <label class="radio">
								<input type="text" class="input-xlarge datepicker" id="txtDNI" readonly="true" value="DNI">
								DNI
							  </label>					
							  <div style="clear:both"></div>		  
							  <label class="radio">
								<input type="radio" name="optionsRadios" id="txtcarnet" name="txtcarnet" value="carnet">
								Carnet de extranjería
							  </label>
							  <div style="clear:both"></div>
							  <label class="radio">
								<input type="radio" name="optionsRadios" id="txtpasaporte" name="txtpasaporte" value="pasaporte">
								Pasaporte
							  </label>
							</div>
						  </div>						

							<div class="control-group">
							  <label class="control-label" for="numerodocumento">N&uacute;mero de Documento (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="numerodocumento" data-provide="typeahead" data-items="4" ></input>								
							  </div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="cmbPuesto">Puesto (*):</label>
								<div class="controls">
								  <select name="selectpuesto" id="selectpuesto" data-rel="chosen">
									<option>Puesto 1</option>
									<option>Puesto 2</option>
									<option>Puesto 3</option>
									<option>Puesto 4</option>
									<option>Puesto 4</option>
								  </select>
								</div>
							</div>																			
							
							 <div class="control-group">
								<label class="control-label" for="cmbHorarios">Horario de Trabajo:</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbHorarios" name="cmbHorarios" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errSedes" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>
							
							<div class="control-group">
								<label class="control-label" for="cmbArea">&Aacute;rea (*):</label>
								<div class="controls">
								  <select name="selectarea" id="selectarea" data-rel="chosen">
									<option>GERENCIA</option>
									<option>ADMINISTRACION</option>
									<option>OPERACIONES</option>
									 </select>
								</div>
							</div>						
													
							  <div class="control-group">
								<label class="control-label" for="cmbSedes">Sedes de Trabajo:</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errSedes" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>																									
						
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Agregar</button>
			              <button type="reset" class="btn">Cancelar</button>
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

	</script>
		<script>loadContent()</script> 
</body>
</html>
