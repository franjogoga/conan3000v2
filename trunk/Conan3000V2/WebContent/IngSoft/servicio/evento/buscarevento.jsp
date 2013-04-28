<!DOCTYPE html>
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
	<title>Buscar Evento</title>
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
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						Mantenimiento de Eventos
					</li>
					
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR EVENTO</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="typeahead">Nombre de Evento </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead">
							  </div>
							</div>
							 <div class="control-group">
								<label class="control-label" for="selectError">Tipo de Evento</label>
								<div class="controls">
								  <select id="selectError" data-rel="chosen">
								  	<option selected>Todos</option>
									<option>Interno</option>
									<option>Externo</option>									
								  </select>
								</div>
							  </div>
							<div class="control-group">
							  <label class="control-label" for="date01">Fecha Inicio</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date01" value="14/04/2013">
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="date02">Fecha Fin</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date02" value="14/04/2013">
							  </div>
							</div>
		
							
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">Buscar</button>
							  <button type="reset" class="btn">Cancelar</button>
							</div>
						  </fieldset>
						</form>   

					</div>
					
				</div><!--/span-->

			</div><!--/row-->
	
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i></i> RESULTADOS</h2>
                        
						
					</div>           
					<div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <!-- agregar nuevo boton -->
                            
                            
                            <div align="right">
                            
                                <a class="btn btn-primary" href="agregarevento.jsp">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
                              
                             </div>          
                          <thead>
							  <tr>
								  <th>Tipo Evento</th>
							        <th>Nombre Evento</th>
							        <th>Limite de incio (d&iacutea/mes)</th>
							        <th>Limite de fin (d&iacutea/mes)</th>
							        <th>Sede</th>							        							      							        
							        <th>Acción</th>
							
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>Interno</td>
							        <td class="center">Fiesta de fin de año</td>
							        <td class="center">29/12</td>
							        <td class="center">29/12</td>
							        <td class="center">Ambos</td>					   
							      	<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										
									</a>
									<a class="btn btn-info" href="modificarevento.jsp">
										<i class="icon-edit icon-white"></i>  
                                        
									</a>
									<a class="btn btn-danger" href="eliminarevento.jsp">
										<i class="icon-trash icon-white"></i> 
										
									</a>
								</td>
							</tr>
							<tr>
								<td>Interno</td>
							        <td class="center">Clase de natacion</td>
							        <td class="center">01/01</td>
							        <td class="center">28/02</td>
							        <td class="center">Ambos</td>							   
							      	<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										
									</a>
									<a class="btn btn-info" href="modificarevento.jsp">
										<i class="icon-edit icon-white"></i>  
                                        
									</a>
									<a class="btn btn-danger" href="eliminarevento.jsp">
										<i class="icon-trash icon-white"></i> 
										
									</a>
								</td>
							</tr>
							<tr>
								<td>Interno</td>
							        <td class="center">Clase de equitacion</td>
							        <td class="center">01/05</td>
							        <td class="center">30/09</td>
							        <td class="center">Campo</td>							   
							      	<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										
									</a>
									<a class="btn btn-info" href="modificarevento.jsp">
										<i class="icon-edit icon-white"></i>  
                                        
									</a>
									<a class="btn btn-danger" href="eliminarevento.jsp">
										<i class="icon-trash icon-white"></i> 
										
									</a>
								</td>
							</tr>
                               
							  </tbody>
						 </table>       
					</div>
				</div><!--/span-->
				
				
			</div><!--/row-->
			
    
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
				
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Ã—</button>
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


</body>
</html>
