<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>Inicio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Dos Virgenes, pagina de administrador">
	<meta name="author" content="Dos Virgenes">
	<!--The beans  -->
	<jsp:useBean id="casosDeUso" scope="request" class="java.util.Vector"></jsp:useBean>
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

	<!-- The conan 3000 icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
		
</head>

<body>
		<jsp:include page="superior.jsp" />
			
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<jsp:include page="leftmenu.jsp" >
				<jsp:param name="casosDeUso" value="<%=casosDeUso %>" />
			</jsp:include>
						<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">¡Advertencia!</h4>
					<p>Necesitas tener <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> activado para usar este sitio.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->			

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a>
					</li>				
				</ul>
			</div>
			<div class="sortable row-fluid">
				<a data-rel="tooltip" title="6 new members." class="well span3 top-block" href="#">
					<span class="icon32 icon-red icon-user"></span>
					<div>Miembros</div>
					<div>27</div>
					<span class="notification">4</span>
				</a>

				<a data-rel="tooltip" title="4 new pro members." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-star-on"></span>
					<div>Socios</div>
					<div>27</div>
					<span class="notification green">4</span>
				</a>

				<a data-rel="tooltip" title="$34 new sales." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-cart"></span>
					<div>Ventas</div>
					<div>S/. 13320</div>
					<span class="notification yellow">S/. 34</span>
				</a>
				
				<a data-rel="tooltip" title="12 new messages." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>Mensajes</div>
					<div>25</div>
					<span class="notification red">12</span>
				</a>
			</div>
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i> Introducci&oacute;n</h2>
						<div class="box-icon">
							<!--  iconos -->
						</div>
					</div>
					<div class="box-content">
						<h1>Conan 3000 <small></small></h1>
						<p>Bienvenido a la p&aacute;gina de administrador.</p>
						<p><b>Comience a gestionar su club de una manera sencilla y r&aacute;pida.</b></p>
												
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
					
			<div class="row-fluid sortable">
				<div class="box span4">
					<div class="box-header well">
						<h2><i class="icon-th"></i> Extras</h2>
						<div class="box-icon">
							
							
						</div>
					</div>
					<div class="box-content">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active"><a href="#info">C&oacute;digo QR</a></li>
							
						</ul>
						 
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="info">
								<h3> <small> Escanee el c&oacute;digo QR con su smartphone </small></h3>
								<p>Usted puede administrar la p&aacute;gina desde su celular </p> <img alt="QR Code" class="charisma_qr center" src="img/qrcode136.png" />
							</div>							
						</div>
					</div>
				</div><!--/span-->
						
				<div class="box span4">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> Actividad de los Miembros</h2>
						<div class="box-icon">
							
						</div>
					</div>
					<div class="box-content">
						<div class="box-content">
							<ul class="dashboard-list">
								<li>
									<a href="http://www.facebook.com/daniel.bernallovera">
										<img class="dashboard-avatar" alt="chato" src="img/chato.png"></a>
										<strong>Nombre:</strong> <a href="#">Daniel Bernal
									</a><br>
									<strong>Desde:</strong> 17/05/2012<br>
									<strong>Estado:</strong> <span class="label label-success">Aprobado</span>                                  
								</li>
								<li>
									<a href="http://www.facebook.com/david.bigio.luks">
										<img class="dashboard-avatar" alt="colorado" src="img/colorado.png"></a>
										<strong>Nombre:</strong> <a href="#">David Bigio
									</a><br>
									<strong>Desde:</strong> 17/05/2012<br>
									<strong>Estado:</strong> <span class="label label-warning">Suspendido</span>                                 
								</li>
								<li>
									<a href="http://www.facebook.com/lizc.diazc">
										<img class="dashboard-avatar" alt="lizita" src="img/liz.png"></a>
										<strong>Nombre:</strong> <a href="#">Liz D&iacute;az
									</a><br>
									<strong>Desde:</strong> 25/05/2012<br>
									<strong>Estado:</strong> <span class="label label-important">Eliminado</span>                                  
								</li>
								<li>
									<a href="http://www.facebook.com/aTiTixD">
										<img class="dashboard-avatar" alt="atiti" src="img/ati.png"></a>
										<strong>Nombre:</strong> <a href="#">Carlos Bustamante
									</a><br>
									<strong>Desde:</strong> 17/05/2012<br>
									<strong>Estado:</strong> <span class="label label-info">Actualizado</span>                                  
								</li>
							</ul>
						</div>
					</div>
				</div><!--/span-->
						
				<div class="box span4">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-list-alt"></i> Tr&aacute;fico de la p&aacute;gina</h2>
						<div class="box-icon">
						
						</div>
					</div>
					<div class="box-content">
						<div id="realtimechart" style="height:190px;"></div>
							<p class="clearfix">Seleccione un valor para mostrar el cuadro de tr&aacute;fico de la p&aacute;gina.</p>
							<p>Tiempo en milisegundos : <input id="updateInterval" type="text" value="" style="text-align: right; width:5em"> </p>
					</div>
				</div><!--/span-->
			</div><!--/row-->  
       
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X—</button>
				<h3>Opciones</h3>
			</div>
			<div class="modal-body">
				<p>Aqu&iacute; las opciones pueden ser configuradas...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
		  <p class="pull-left"><a href="#">Conan 3000</a> &copy;  2013</p>
          <p class="pull-right">Powered by: <a href="#">Dos Virgenes</a></p>
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
	
		
</body>
</html>
