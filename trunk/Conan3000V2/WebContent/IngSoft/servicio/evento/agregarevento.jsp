<!DOCTYPE html>
<%@page import="IngSoft.servicio.bean.TipoEventoMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.AmbienteMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
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
	<title>Agregar Plantilla de Evento</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="ambientes" scope="request"class="java.util.Vector"></jsp:useBean>
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

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
	<script src="evento.js"></script>
	<script>
		function validar(){
			var test=true;
			$('#cmbTipo').parent().parent().addClass("success");
			$('#fFecIncio').parent().parent().addClass("success");
			$('#fFecFin').parent().parent().addClass("success");
			if($('#cmbAmbientes').val()==null|| $('#cmbAmbientes').val().length<=0){
				$('#cmbAmbientes').bind("change",function(){
				var temp= $('#cmbAmbientes');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errAmbientes').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errAmbientes').slideDown(1000);
				}
				
				})
				$('#errAmbientes').slideDown(1000);
				test=false;
				$('#errAmbientes').parent().parent().toggleClass("error");
				
			};						
			if($('#cmbSedes').val()==null||$('#cmbSedes').val().length<=0){
				$('#cmbSedes').bind("change",function(){
				var temp= $('#cmbSedes');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errSedes').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errSedes').slideDown(1000);
				}
				
				})
				$('#errSedes').slideDown(1000);
				test=false;
				$('#cmbSedes').parent().parent().toggleClass("error");
			};
			
			if($('#txtNombreEvento').val()==null || $('#txtNombreEvento').val().length<=0){
				$('#txtNombreEvento').bind("change",function(){
				var temp= $('#txtNombreEvento');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errNombreEvento').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errNombreEvento').slideDown(1000);
				}
				
				})
				$('#errNombreEvento').slideDown(1000);
				test=false;
				$('#txtNombreEvento').parent().parent().toggleClass("error");
			};
	return test;
		
		
		}
	
	
	function alt_submit(){
		var form= document.frmData;
		if(validar()) form.submit();
		else alert("Uno o mas campos estan vacios");			
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
						<a href="buscarevento.jsp">Mantenimiento de Eventos</a> <span class="divider">/</span>
					</li>
					<li>
						Agregar Plantilla de Eventos
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-plus-sign"></i>AGREGAR EVENTO</h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" action="<%= response.encodeURL("SMSEvento")%>" name="frmData" method="post">
						<input type="hidden" name="accion" value="Agregar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre de evento(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreEvento"  data-provide="typeahead"  id="txtNombreEvento" name="txtNombreEvento" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>
								<span class="help-inline" id="errNombreEvento" style="display:none;">Este campo no puede estar vacio</span>						        													       
					          </div>
					        </div>
						    
							<div class="control-group">
								<label class="control-label" for="cmbTipo">Tipo de Evento(*):</label>
								<div class="controls">
								  <select data-rel="chosen" id="cmbTipo" name="cmbTipo">
									<%for(int i=0;i<tiposEvento.size();i++){ %>
										<option value="<%= ((TipoEventoMiniBeanData)tiposEvento.get(i)).getCodigo()%>" <%=i==0?"selected":""%>><%= ((TipoEventoMiniBeanData)tiposEvento.get(i)).getNombre()%></option>
									<%} %>										
								  </select>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="cmbSedes">Sedes relacionadas(*):</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select>
								  <span class="help-inline" id="errSedes" style="display:none;">Este campo no puede estar vacio</span>
								</div>
							  </div>
							   <div class="control-group">
								<label class="control-label" for="cmbAmbientes">Ambientes relacionados(*):</label>
								<div class="controls">
								  <select  multiple data-rel="chosen" id="cmbAmbientes" name="cmbAmbientes">
									<%for(int i=0;i<ambientes.size();i++){ %>
										<option value="<%= ((AmbienteMiniBeanData)ambientes.get(i)).getCodigo()%>"><%= ((AmbienteMiniBeanData)ambientes.get(i)).getNombre()%></option>
									<%} %>																			
								  </select>
								  <span class="help-inline" id="errAmbientes" style="display:none;">Este campo no puede estar vacio, por favor haga una seleccion</span>
								</div>
							  </div>
							  <div class="control-group">
							  <label class="control-label" for="date01">Limite Inicio(*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFecIncio" readonly="true" value="01/01"  name="fFecIncio" onchange="alt_fecha(this);verificar_fecha(-1,this,'fFecFin');">
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="date02">Limite Fin(*):</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFecFin" readonly="true" value="31/12"  name="fFecFin" onchange="alt_fecha(this);verificar_fecha(1,this,'fFecIncio');">
							  </div>
							</div>
						    <div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
							  <button type="button" class="btn" onclick="location.href='buscarevento.jsp'" >Cancelar</button>
							</div>
						  </fieldset>
					  </form>   
					<span style="font-size:70%">(*)Campos Obligatorios</span>
				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->		 
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">√ó</button>
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
		<br/>
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
	<script src="js/conan3000.js"></script>
	<script>
		$('#txtNombreEvento').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombreEvento'),50)}, 0);
		})
	</script>
	
		
</body>
</html>
