<!DOCTYPE html>
<%@page import="IngSoft.administracion.bean.ResultadoSocioBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.lang.System"%>
<%@page import="java.lang.String"%>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>Buscar Socio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Dos Virgenes, pagina de administrador">
	<meta name="author" content="Dos Virgenes">
	
	<!--The Beans-->
	<jsp:useBean id="codigoSocio" scope="request" class="java.lang.String"></jsp:useBean>		

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

	<!-- The conan3000 icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
	
	<script>	
	function validar(form) {
		var test=true;
		if($('#txtMotivo').val()==null || $('#txtMotivo').val().length<=0){
			$('#txtMotivo').bind("change",function(){
				var temp= $('#txtMotivo');
				if(temp.val()!=null && temp.val().length>0) {
					temp.parent().parent().removeClass("error");
					temp.parent().parent().addClass("success");
					$('#errMotivo').slideUp(1000);
				}
				else {
					temp.parent().parent().removeClass("success");
					temp.parent().parent().addClass("error");
					$('#errMotivo').slideDown(1000);
				}				
			})
			$('#errMotivo').slideDown(1000);
			test=false;
			$('#txtMotivo').parent().parent().toggleClass("error");
		};			
		return test;
	}	
	function alt_suspender(){			
		var form = document.frmDatos;
		if (validar(form)) form.submit();
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
					<h4 class="alert-heading">Advertencia!</h4>
					<p>Necesitas tener <a href="http://es.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> activado para usar este sitio.</p>
				</div>    
			</noscript>
			
			<div id="content" class="span10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li>
							<a href="/Conan3000V2/IngSoft/general/index.jsp">Inicio</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="accionsocio.jsp">Transacciones de Socio</a> <span class="divider">/</span>
						</li>
						<li>
							Buscar Socio
						</li>
					</ul>
				</div>											
								
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-search"></i> BUSCAR SOCIO</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round">
									<i class="icon-chevron-up"></i>
								</a>								
							</div>
						</div>
						
						<div class="box-content">
							<form class="form-horizontal" name="frmDatos" id="frmDatos" method="post" action="<%=response.encodeURL("SMASocio")%>">
								<input type="hidden" name="codigo" value="<%=codigoSocio%>"></input>
								<input type="hidden" name="accion" value="Suspender"></input>
								<input type="hidden" name="tipo" value="2"></input>								
								
								<fieldset>		              			 															
						    
							  		<div class="control-group">
										<label class="control-label" for="txtMotivo">Motivo (*):</label>							  
									  	<div class="controls">
											<input type="text" class="span6 typeahead" id="txtMotivo" name="txtMotivo" onkeypress="return alfanumerico(event);" autofocus maxlength="100"></input>
											<span class="help-inline" id="errMotivo" style="display:none;">Este campo no puede estar vac&iacute;o</span>								
									  	</div>
									</div>							      									  							      									  														
									  
									<div class="form-actions">
										<button type="button" class="btn btn-primary" onclick="javascript:alt_suspender()">Suspender</button>
										<button type="button" class="btn" onclick="javascript:history.back(1)">Regresar</button>                
									</div>
					  
								</fieldset>
							</form>
						</div> <!-- box content-->
					</div> <!-- box span12-->		      
				</div> <!-- row-fluid sortable-->		    																		
		    
			</div> <!-- content  span10 -->		  
		</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">◊</button>
				<h3>Opciones</h3>
			</div>
			<div class="modal-body">
				<p>Aqui las opciones pueden ser configuradas...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Cerrar</a>
				<a href="#" class="btn btn-primary">Guardar Cambios</a>
			</div>
		</div>

		<footer>
			<p class="pull-left"><a href="#">Conan 3000</a> &copy;  2013</p>
			<p class="pull-right">Powered by: <a href="#">Dos V&iacute;rgenes</a></p>
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
	
	<script src="js/conan3000.js"></script>
	<script>
		$('#txtMotivo').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombres'),100)}, 0);
		})
	</script>	
</body>
</html>