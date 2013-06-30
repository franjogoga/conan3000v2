<!DOCTYPE html>
<%@page import="IngSoft.administracion.bean.TipoCanchaMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<html lang="en">
<head>
	<!--
	Formulario para la generación de las reservas de las actividades.
	-->
	<meta charset="utf-8">
	<title>Conan3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<script language="javascript" src=""></script>	
	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tiposCancha" scope="request"class="java.util.Vector"></jsp:useBean>
	
	<script src="js/ajaxsbmt.js"></script>
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
	
	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>	
	<script> 
var pendientes="";
var cancelados="";
var lock1=1;
var lock2=1;
var lock3=1;
var lock4=1;
var lock5=1;
var ctipo=2;
var atipo=3;

</script>
<script src="reservas.js"></script>	
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
						MANTENIMIENTO DE RESERVAS
					</li>
				</ul>
			</div>
			<div class="row-fluid">
				<a data-rel="tooltip" title="Buscar Reservas" class="well span3 top-block" href="javascript:cambiaModo(3)">
					<span class="icon32 icon-blue icon-search"></span>
					<div>Buscar Reservas</div>
				</a>
				<a data-rel="tooltip" title="Agregar Reservas" class="well span3 top-block" href="javascript:cambiaModo(1)">
					<span class="icon32 icon-green icon-plus"></span>
					<div>Agregar Reservas</div>
				</a>
				<a data-rel="tooltip" title="Eliminar Reservas" class="well span3 top-block" href="javascript:cambiaModo(2)">
					<span class="icon32 icon-red icon-minus"></span>
					<div>Eliminar Reservas</div>
				</a>
				<a data-rel="tooltip" title="Eliminar Reservas" class="well span3 top-block" href="javascript:cambiaModo(4)">
					<span class="icon32 icon-blue icon-plus"></span>
					<div>Adicionales a Reservas</div>
				</a>			
			</div>
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2 id="titulo"><i class="icon-book"></i> BUSCAR RESERVAS</h2>						
					</div>
					
					<div class="box-content">
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda" method="post" onsubmit="return ajax_search()">
						<input type="hidden" name="accion" value="Buscar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						<input type="hidden" name="reservas" value=""></input>
						
						  <fieldset>
					<div class="control-group" id="alt_socioDoc">
						      <label class="control-label" for="typeahead7">Documento de socio(*): </label>
						      <div class="controls">
						        <input type="text" class="span3 typeahead"  data-provide="typeahead"  id="txtDocSocio" name="txtDocSocio" onblur="javascript:ajax_confirmaSocio($(this),$('#txtNomSocio'),$('#imagenCargaTxt'),$('#txtIdSocioAlt'));" autofocus maxlength="50"/>
								<span class="help-inline" id="errDocumentoSocio" style="display:none;">Este campo no puede estar vacio</span>
								<img src="img/ajax-loaders/ajax-loader-3.gif" style="display: none" id="imagenCargaTxt"></img>
																						        													      
					          </div>
					        </div>
					 <div class="control-group" id="alt_socioNom">
						      <label class="control-label" for="typeahead7">Nombre de socio(*): </label>
						      <div class="controls">
						        <input type="text" class="span3 typeahead"  data-provide="typeahead"  id="txtNomSocio" name="txtNomSocio"  autofocus maxlength="50" readonly="readonly"/>
								<span class="help-inline" id="errNombreSocio" style="display:none;">Este campo no puede estar vacio</span>						        													       
					          </div>
					 </div>						 	
					<div class="control-group">
								<label class="control-label" for="cmbSedes">Sedes relacionadas(*):</label>
								<div class="controls">
								  <select  data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																
								  </select>
								</div>
							  </div>
						<div class="control-group">						
								<label class="control-label" for="cmbServicios">Seleccionar servicios</label>
								<div class="controls">								
								  <select id="cmbServicios" data-rel="chosen" name="cmbServicios" onchange="activarTipoCancha($(this))">
								  <option value="bungalow"> Bungalows</option>								
                                    <option value="cancha"> Cancha</option>																
								  </select>
								</div>
						    </div>
						 <div class="control-group" id="TipoCancha" style="display: none;">						
								<label class="control-label" for="cmbTipoCancha">Seleccionar tipo de cancha</label>
								<div class="controls">								
								  <select id="cmbTipoCancha" data-rel="chosen" name="cmbTipoCancha">								
                                    <%for(int i=0;i<tiposCancha.size();i++){ %>
										<option value="<%= ((TipoCanchaMiniBeanData)tiposCancha.get(i)).getCodigo()%>"><%= ((TipoCanchaMiniBeanData)tiposCancha.get(i)).getNombre()%></option>
									<%} %>								
								  </select>
								</div>
						  </div>
						  <div class="control-group">
							  <label class="control-label" for="date01">Semana</label>
							  <div class="controls">
								<input type="text" class="datepickerB" id="fFechaIni" name="fFechaIni" readonly="readonly"  onchange="actFecha($(this))">&nbsp;a&nbsp;
								<input type="text" id="fFechaFin" name="fFechaFin" readonly="readonly">
							  </div>
							</div>
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">Buscar</button>
							 <!--<button type="reset" class="btn">Limpiar</button>-->
			
							</div>
						  </fieldset>
						</form>   
					</div>
				</div><!--/span-->

			</div><!--/row-->
<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i></i> RESERVAS</h2>
					</div>  	
<div  class="box-content" name="resultadoBusqueda" id="resultadoBusqueda" style="position:relative">
						
					  
					
                      
  </div><!--/span-->
    				
                      <div class="form-actions" id="reserva_boton">
			             <button class="btn btn-primary btn-setting crear" style="display: none;">Crear Reserva</button>
			             <button class="btn btn-primary btn-setting elim" style="display: none;">Eliminar Reserva</button>
			                                                             
		                </div>
				</div><!--/span-->

			</div><!--/row-->
					

				
		<hr>
<form id="frmReservas" name="frmReservas">
<input type="hidden" value="" id="txtIdSocio" name="txtIdSocio"></input>
<input type="hidden" value="" id="txtIdSocioAlt" name="txtIdSocioAlt"></input>
</form>
<div style="display: none;">
			<button class="btn btn-primary btn-setting" id="bModal"/>
		</div>
		<div class="modal hide fade" id="myModal">
		<div class="modAgregar mod">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h3>Datos de socio</h3>
			</div>
			<div class="modal-body">
				<jsp:include page="/IngSoft/servicio/reserva/formularioreservas.jsp" />
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Cancelar</a>
				<a class="btn btn-primary" onclick="ajax_crearReserva();">Guardar Reservas</a>
			</div>
		</div>
		<div class="modExito mod" style="display: none;">
			<div class="modal-header">		
				<h3>Exito</h3>
			</div>
			<div class="modal-body">
				La reserva se hizo exitosamente
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Aceptar</a>
				
			</div>
		</div>
		<div class="modAdicional mod" style="display: none;">
			<div class="modal-header">		
				<h3>ADICIONAL</h3>
			</div>
			<div class="modal-body" id="resultadoAdicional">
				ADICIONAL
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Cancelar</a>
				<button class="btn btn-primary" onclick="">Guardar Adicionales</button>
				
			</div>
		</div>
		<div class="modEliminar mod" style="display: none;">
			<div class="modal-header">				
				<h3>Confirmaci&oacute;n</h3>
			</div>
			<div class="modal-body">
				¿Desea eliminar las reservas seleccionadas?
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">No</a>
				<a class="btn btn-primary" onclick="ajax_elim()">S&iacute;</a>
			</div>
		</div>	
		</div>
	<jsp:include page="/IngSoft/general/inferior.jsp" />
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	
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
		var now=new Date();
		a=now.getDay();
		if(a==0)a=6;
		else a=a-1;
		now.setDate(now.getDate()-a);
		$('#fFechaIni').val($.datepicker.formatDate("dd/mm/yy",now));
		now.setDate(now.getDate()+6);
		$('#fFechaFin').val($.datepicker.formatDate("dd/mm/yy",now));
		$(function() {
    	$( ".datepickerB" ).datepicker({
      showButtonPanel: true
    });
  });
	</script>
		
</body>
</html>
