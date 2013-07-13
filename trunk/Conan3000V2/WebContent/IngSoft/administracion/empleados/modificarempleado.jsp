<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.servicio.bean.*"%>
<%@page import="IngSoft.administracion.bean.*"%>
<%@page import="java.util.Date"%>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>CONAN 3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Dos Virgenes">
	
	<jsp:useBean id="empleado" scope="request" class="IngSoft.administracion.bean.EmpleadoBeanData">></jsp:useBean>

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
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		 //if(validar(form))
	     form.submit();
		 //else alert("Uno o mas campos estan vacios");
			
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
						<a href="buscarempleado.jsp">Mantenimiento de Empleados</a> <span class="divider">/</span>
					</li>
					<li>
						Modificar Empleado
					</li>
				</ul>
			</div>
			  
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2> MODIFICAR EMPLEADO</h2>
		          </div>
				  
			      <div class="box-content">
			        <form class="form-horizontal" name="frmUpdate"  action="<%=response.encodeURL("SMSEmpleado")%>" method="post">
						<input type="hidden" name="codigo"  value="<%=empleado.getCodigo()%>"></input>						
						<input type="hidden" name="accion" value="Modificar"></input>
						<input type="hidden" name="tipo" value="2"></input>
			          
			          
			          <fieldset>

							
							<div class="control-group">
						      <label class="control-label" for="disabledInput"> Codigo: </label>
						      <div class="controls">
						        <input class="input-xlarge disabled" id="disabledInput" type="text"  disabled id="txtCodigo" name="txtCodigo" value="<%= empleado.getCodigo()%>" onkeypress="return alfanumerico(event);" autofocus>
					          </div>
					        </div>
							
							
							<div class="control-group">
						      <label class="control-label" for="disabledInput"> Nombre: </label>
						      <div class="controls">
						        <input class="input-xlarge disabled"  type="text"  id="txtNombreEmpleado" name="txtNombreEmpleado" value="<%= empleado.getNombre()%>" onkeypress="return alfanumerico(event);" autofocus>
					          </div>
					        </div>
							
							<div class="control-group">
						      <label class="control-label" for="disabledInput"> Apellido Paterno: </label>
						      <div class="controls">
						        <input class="input-xlarge disabled"  type="text"  id="txtApellidoPaterno" name="txtApellidoPaterno" value="<%= empleado.getApellidoPaterno()%>" onkeypress="return alfanumerico(event);" autofocus>
					          </div>
					        </div>
							
							
							<div class="control-group">
						      <label class="control-label" for="disabledInput"> Numero de Documento: </label>
						      <div class="controls">
						        <input class="input-xlarge disabled"  type="text" id="txtNumeroDocumento" name="txtNumeroDocumento" value="<%= empleado.getNumeroDocumento()%>"  onkeypress="return alfanumerico(event);" autofocus>
					          </div>
					        </div>
					
						<div class="control-group">
								<label class="control-label" for="cmbArea">&Aacute;rea (*):</label>
								<div class="controls">
								  <select name="cmbArea" id="cmbArea" data-rel="chosen">
									<option>GERENCIA</option>
									<option>ADMINISTRACION</option>
									<option>OPERACIONES</option>
								  </select>
								</div>
							</div>
					
						
			            <div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Modificar</button>
							  <button type="button" class="btn" onclick="javascript:history.back(1)">Cancelar</button>
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
