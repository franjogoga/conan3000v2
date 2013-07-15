<!DOCTYPE html>
<%@page import="IngSoft.general.bean.Conan3000Constantes"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Configuraci&oacute;n</title>
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

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
	<script src="evento.js"></script>
	<script>
	function alt_submit(){
		var form= document.frmData;
		if(validar()) form.submit();
	}
	
	function validar(){
		var test=true;															
		if($('#txtCostoReservaCancha').val()==null || $('#txtCostoReservaCancha').val().length<=0){
			$('#txtCostoReservaCancha').bind("change",function(){
			var temp= $('#txtCostoReservaCancha');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errCostoReservaCancha').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errCostoReservaCancha').slideDown(1000);
			}
			
			})
			$('#errCostoReservaCancha').slideDown(1000);
			test=false;
			$('#txtCostoReservaCancha').parent().parent().toggleClass("error");
		}
		else $('#txtCostoReservaCancha').parent().parent().addClass("success");
		
		if($('#txtCostoReservaBungalow').val()==null||$('#txtCostoReservaBungalow').val().length<=0||$('#txtCostoReservaBungalow').val().indexOf('none')==0){
			$('#txtCostoReservaBungalow').bind("change",function(){
			var temp= $('#txtCostoReservaBungalow');
			if(temp.val()!=null && temp.val().length>0 && $('#txtCostoReservaBungalow').val().indexOf('none')<0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errCostoReservaBungalow').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errCostoReservaBungalow').slideDown(1000);
			}
			
			})
			$('#errCostoReservaBungalow').slideDown(1000);
			test=false;
			$('#txtCostoReservaBungalow').parent().parent().toggleClass("error");
		}
		else $('#txtCostoReservaBungalow').parent().parent().addClass("success");
		
		if($('#txtMontoInvitados').val()==null || $('#txtMontoInvitados').val().length<=0){
			$('#txtMontoInvitados').bind("change",function(){
			var temp= $('#txtMontoInvitados');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errMontoInvitados').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errMontoInvitados').slideDown(1000);
			}
			
			})
			$('#errMontoInvitados').slideDown(1000);
			test=false;
			$('#txtMontoInvitados').parent().parent().toggleClass("error");
		}
		else $('#txtMontoInvitados').parent().parent().addClass("success");
		if($('#txtMontoInvitadosBungalow').val()==null || $('#txtMontoInvitadosBungalow').val().length<=0){
			$('#txtMontoInvitadosBungalow').bind("change",function(){
			var temp= $('#txtMontoInvitadosBungalow');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errMontoInvitadosBungalow').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errMontoInvitadosBungalow').slideDown(1000);
			}
			
			})
			$('#errMontoInvitadosBungalow').slideDown(1000);
			test=false;
			$('#txtMontoInvitadosBungalow').parent().parent().toggleClass("error");
		}
		else $('#txtMontoInvitadosBungalow').parent().parent().addClass("success");
		if($('#txtMontoMulta').val()==null || $('#txtMontoMulta').val().length<=0){
			$('#txtMontoMulta').bind("change",function(){
			var temp= $('#txtMontoMulta');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errMontoMulta').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errMontoMulta').slideDown(1000);
			}
			
			})
			$('#errMontoMulta').slideDown(1000);
			test=false;
			$('#txtMontoMulta').parent().parent().toggleClass("error");
		}
		else $('#txtMontoMulta').parent().parent().addClass("success");		
		if($('#txtMaxInvitados').val()==null || $('#txtMaxInvitados').val().length<=0){
			$('#txtMaxInvitados').bind("change",function(){
			var temp= $('#txtMaxInvitados');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errMaxInvitados').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errMaxInvitados').slideDown(1000);
			}
			
			})
			$('#errMaxInvitados').slideDown(1000);
			test=false;
			$('#txtMaxInvitados').parent().parent().toggleClass("error");
		}
		else $('#txtMaxInvitados').parent().parent().addClass("success");		
		if($('#txtPrecioMembresia').val()==null || $('#txtPrecioMembresia').val().length<=0){
			$('#txtPrecioMembresia').bind("change",function(){
			var temp= $('#txtPrecioMembresia');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errPrecioMembresia').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errPrecioMembresia').slideDown(1000);
			}
			
			})
			$('#errPrecioMembresia').slideDown(1000);
			test=false;
			$('#txtPrecioMembresia').parent().parent().toggleClass("error");
		}
		else $('#txtPrecioMembresia').parent().parent().addClass("success");
		if($('#txtMontoSalonPrincipal').val()==null || $('#txtMontoSalonPrincipal').val().length<=0){
			$('#txtMontoSalonPrincipal').bind("change",function(){
			var temp= $('#txtMontoSalonPrincipal');
			if(temp.val()!=null && temp.val().length>0) {
			temp.parent().parent().removeClass("error");
			temp.parent().parent().addClass("success");
			$('#errMontoSalonPrincipal').slideUp(1000);
			}
			else {
			temp.parent().parent().removeClass("success");
			temp.parent().parent().addClass("error");
			$('#errMontoSalonPrincipal').slideDown(1000);
			}
			
			})
			$('#errMontoSalonPrincipal').slideDown(1000);
			test=false;
			$('#txtMontoSalonPrincipal').parent().parent().toggleClass("error");
		}
		else $('#txtMontoSalonPrincipal').parent().parent().addClass("success");								
return test;	
	}
	</script>
</head>
<%Conan3000Constantes constantes=Conan3000Constantes.getInstance(); %>
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
                  <li> <a href="<%=request.getContextPath()%>/general/index.jsp">Home</a> <span class="divider">/</span> </li>                  
                  <li>Configuracion</li>
                </ul>
              </div>
              <div class="row-fluid sortable">
                <div class="box span12">
                  <div class="box-header well" data-original-title>
                    <h2>CONFIGURACION</h2>
                  </div>
                  <div class="box-content">
                    <form class="form-horizontal" action="<%=response.encodeURL("SMAConfiguracion")%>" name="frmData" method="post">
                    <input type="hidden" name="accion" value="Modificar"></input>
					<input type="hidden" name="tipo" value="2"></input>
                      <fieldset>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Costo de reserva de cancha(por hora):</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtCostoReservaCancha" 
                            name="txtCostoReservaCancha" data-provide="typeahead" value="<%=constantes.getCostoReservaCancha()%>">
                          	<span class="help-inline" style="display:none;" id="errCostoReservaCancha">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group" >
                          <label class="control-label" for="typeahead">Costo de reserva de bungalow(por m2):</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtCostoReservaBungalow" 
                            name="txtCostoReservaBungalow" data-provide="typeahead" value="<%=constantes.getCostoXm2Bungalow()%>">
                          	<span class="help-inline" style="display:none;" id="errCostoReservaBungalow">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group" >
                          <label class="control-label" for="typeahead">Monto a cobrar por invitados extra:</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtMontoInvitados" 
                            name="txtMontoInvitados" data-provide="typeahead" value="<%=constantes.getMontoInvitado()%>">
                          	<span class="help-inline" style="display:none;" id="errMontoInvitados">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Monto a cobrar por invitados a Bungalow:</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtMontoInvitadosBungalow" 
                            name="txtMontoInvitadosBungalow" data-provide="typeahead" value="<%=constantes.getMontoInvitadoBungalow()%>">
                          	<span class="help-inline" style="display:none;" id="errMontoInvitadosBungalow">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Monto a cobrar por Multa:</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtMontoMulta" 
                            name="txtMontoMulta" data-provide="typeahead" value="<%=constantes.getMontoMultaFalta()%>">
                          	<span class="help-inline" style="display:none;" id="errMontoMulta">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Numero maximo de invitados sin cobro:</label>
                          <div class="controls">
                            <input type="text"  class="span2 typeahead" id="txtMaxInvitados" 
                            name="txtMaxInvitados" data-provide="typeahead" value="<%=constantes.getNumMaxInvitados()%>">
                          	<span class="help-inline" style="display:none;" id="errMaxInvitados">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Precio por defecto de la Membresia:</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtPrecioMembresia" 
                            name="txtPrecioMembresia" data-provide="typeahead" value="<%=constantes.getPrecioMembresia()%>">
                          	<span class="help-inline" style="display:none;" id="errPrecioMembresia">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="typeahead">Monto a cobrar por reserva de un Salon Principal:</label>
                          <div class="controls">
                            <input type="text" onchange="vDinero($(this))"  class="span2 typeahead" id="txtMontoSalonPrincipal" 
                            name="txtMontoSalonPrincipal" data-provide="typeahead" value="<%=constantes.getPrecioSalonPrincipal()%>">
                          	<span class="help-inline" style="display:none;" id="errMontoSalonPrincipal">Este campo no puede estar vacio</span>
                          </div>
                        </div>
                        <div class="form-actions">
                          <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar Modificaciones</button>
                          <button type="button" class="btn" onclick="location.href='SMAConfiguracion?accion=Consultar'">Cancelar</button>
                        </div>
                      </fieldset>
                    </form>
					<span style="font-size:70%">(*)Campos Obligatorios</span>
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
	<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
	<link rel="stylesheet" href="css/apprise.css" type="text/css" />
	<script>
$('#txtCostoReservaCancha').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtCostoReservaCancha'),10)}, 0);})
$('#txtCostoReservaBungalow').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtCostoReservaBungalow'),10)}, 0);})
$('#txtMontoInvitados').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtMontoInvitados'),10)}, 0);})
$('#txtMontoInvitadosBungalow').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtMontoInvitadosBungalow'),10)}, 0);})
$('#txtMontoMulta').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtMontoMulta'),10)}, 0);})
$('#txtMaxInvitados').bind('change',function(){setTimeout(function(){filtrar('1234567890',$('#txtMaxInvitados'),5)}, 0);})
$('#txtPrecioMembresia').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtPrecioMembresia'),10)}, 0);})
$('#txtMontoSalonPrincipal').bind('paste',function(){setTimeout(function(){filtrar('1234567890.',$('#txtMontoSalonPrincipal'),10)}, 0);})
	</script>
	
</body>
</html>
