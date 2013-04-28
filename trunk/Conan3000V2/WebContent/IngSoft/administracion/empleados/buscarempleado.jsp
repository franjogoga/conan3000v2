<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>CONAN 3000</title>
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

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
		
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
						Buscar Empleado
					</li>
				</ul>
	        </div>
			
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR EMPLEADO</h2>
		          <div class="box-icon"><a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a> <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a> </div>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>		              			 
						
						<div class="control-group">
						  <label class="control-label" for="typeahead">Nombres</label>							  
						  <div class="controls">
							<input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" ></input>								
						  </div>
						</div>
						
						<div class="control-group">
						  <label class="control-label" for="typeahead">Apellido Paterno</label>							  
						  <div class="controls">
							<input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" ></input>								
						  </div>
						</div>
						
						<div class="control-group">
						  <label class="control-label" for="typeahead">Apellido Materno</label>							  
						  <div class="controls">
							<input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" ></input>								
						  </div>
						</div>
									
						<div class="control-group">
						  <label class="control-label" for="typeahead">DNI</label>							  
						  <div class="controls">
							<input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" ></input>								
						  </div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="selectError">Puesto</label>
							<div class="controls">
							  <select name="selectError5" id="selectError5" data-rel="chosen">
								<option>Puesto 1</option>
								<option>Puesto 2</option>
								<option>Puesto 3</option>
								<option>Puesto 4</option>
								<option>Puesto 4</option>
							  </select>
							</div>
						</div>															
						
						<div class="control-group">
							<label class="control-label" for="selectError">Horario de Trabajo</label>
							<div class="controls">
							  <select id="selectError6" data-rel="chosen">
								<option>Horario 1</option>
								<option>Horario 2</option>
								<option>Horario 3</option>
								<option>Horario 4</option>
								<option>Horario 5</option>
							  </select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="selectError">Sede</label>
							<div class="controls">
							  <select id="selectError7" data-rel="chosen">
								<option>Sede 1</option>
								<option>Sede 2</option>
								<option>Sede 3</option>
								<option>Sede 4</option>
								<option>Sede 5</option>
							  </select>
							</div>
						</div>						
					  
		              <div class="form-actions">
		                <button type="submit" class="btn btn-primary">Buscar</button>		                
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
		            <div  align="right"> <a class="btn btn-primary" href="agregarempleado.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th width="17%">Nombre</th>
		                <th width="10%">Fecha Nacimiento</th>
		                <th width="10%">DNI</th>
		                <th width="10%">Puesto</th>
						<th width="10%">Fecha de Contrato</th>
						<th width="10%">Horario</th>
						<th width="10%">Sede</th>		                
		                <th width="29%">Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              <tr>
		                <td>Juan Perez</td>
		                <td class="center">02/16/2012</td>
		                <td class="center">12345678</td>
						<td class="center">Barredor</td>
						<td class="center">02/16/2014</td>
		                <td class="center">L-V 8-10HS</td>
		                <td class="center">Los Olivos</td>
		                <td class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarempleado.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarempleado.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>					  
		              <tr>
		                <td>Jose Sanchez</td>
		                <td class="center">05/11/2012</td>
		                <td class="center">234567890</td>
						<td class="center">Huachim&aacute;n</td>
						<td class="center">05/11/2014</td>
		                <td class="center">L-V 7-15HS</td>
		                <td class="center">Cercado</td>
		                <td class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarempleado.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarempleado.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
		              <tr>
		                <td>Raul Bermudez</td>
		                <td class="center">07/23/2012</td>
		                <td class="center">345678901</td>
						<td class="center">T&eacute;cnico</td>
						<td class="center">05/11/2014</td>
		                <td class="center">L-V 10-15HS</td>
		                <td class="center">Miraflores</td>
		                <td class="center"><a class="btn btn-success" href="#"> <i class="icon-zoom-in icon-white"></i> Ver </a> <a class="btn btn-info" href="modificarempleado.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarempleado.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
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
	function loadContent() 
{ 
   $("#includedContent").load("menu.html"); 
} 


	</script>
		<script>loadContent()</script> 
</body>
</html>
