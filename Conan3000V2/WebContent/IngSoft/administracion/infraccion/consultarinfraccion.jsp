<!DOCTYPE html>
<%@page import="IngSoft.administracion.bean.InfraccionSocioBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.lang.String"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Consultar Infracci&oacute;n por Socio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Dos Virgenes">
	<meta name="author" content="Dos Virgenes">

	<!--The beans  -->
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="nombre" scope="request"class="java.lang.String"></jsp:useBean>
	
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
					<h4 class="alert-heading">Advertencia!</h4>
					<p>Necesitas tener <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> habilitado para usar este sitio.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->			

			<div>
				<ul class="breadcrumb">
                  <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span> </li>
                  <li>Consultar Infracci&oacute;n por socio</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">						                            

                <div class="row-fluid sortable">
                  <div class="row-fluid sortable">
                    <div class="box span12">                                        	                    	                    	
                      <div class="box-header well" data-original-title>
                        <h2><i class="icon-th-list"></i> INFRACCION POR SOCIO</h2>
                      </div>                                            
                      
                      <div class="box-content"> 
                      
	                    <form class="form-horizontal">
							<fieldset>	                      
	                      		<div class="control-group">
									<label class="control-label"><b>Nombre de Socio</b></label>
									<div class="controls">
									  <span class="input-xlarge uneditable-input"><%=nombre%></span>
									</div>
								</div>
	                      	</fieldset>
	                    </form>
	                                                                 	                      
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">                         
                          <thead>
                            <tr>                                                            
                              <th>Monto de Multa</th>
                              <th>Descripcion</th>
                              <th>Fecha de Inicio</th>
                              <th>Fecha de Fin</th>                                                                                         
                              <th>Estado</th>
                            </tr>
                          </thead>
                          
                          <tbody id="resultadoBusqueda">
                          	<% for(int i=0; i<resultados.size(); i++) { %>
                            <tr>                                     
                              <td class="center"> <%=((InfraccionSocioBeanData)resultados.get(i)).getMontomulta()%> </td>
                              <td class="center"> <%=((InfraccionSocioBeanData)resultados.get(i)).getDescripcion()%> </td>
                              <td class="center"> <%=((InfraccionSocioBeanData)resultados.get(i)).getFechainicio()%> </td>
                              <td class="center"> <%=((InfraccionSocioBeanData)resultados.get(i)).getFechafin()%> </td>                   
                              <td class="center"> <%=((InfraccionSocioBeanData)resultados.get(i)).getEstado()%> </td>
							</tr>
                            <%}%>
                          </tbody>
                        </table>
                      </div>
                    </div>
                    <!--/span-->
                  </div>
                  <!--/span-->
                </div>
                <!--/span-->
			
			</div><!--/row-->              

			<div class="row-fluid sortable"><!--/span--><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span--><!--/span-->
			
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
	
</body>
</html>
