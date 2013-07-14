<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.servicio.bean.Utils"%>
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
	<!--The beans  -->
	<jsp:useBean id="modo" scope="request"class="java.lang.String"></jsp:useBean>
	<jsp:useBean id="resultado" scope="request"class="IngSoft.servicio.bean.ServAdicionalBeanData"></jsp:useBean>
	
	<meta charset="utf-8">
	<title>Consultar Adicional</title>
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
	
	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<%if(modo.equals("M")){%>
	<script>
	var cont=-1;
	var codSedeActual="none";
	var fechaActual="<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>";
	var boton='#btnConcecionarios';
	var concesionario='';
		function validar(){
			var test=true;												
			if($('#txtNombreAdicional').val()==null || $('#txtNombreAdicional').val().length<=0){
				$('#txtNombreAdicional').bind("change",function(){
				var temp= $('#txtNombreAdicional');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errNombreAdicional').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errNombreAdicional').slideDown(1000);
				}
				
				})
				$('#errNombreAdicional').slideDown(1000);
				test=false;
				$('#txtNombreAdicional').parent().parent().toggleClass("error");
			}
			else $('#txtNombreAdicional').parent().parent().addClass("success");
			
			if($('#cmbTipo').val()==null||$('#cmbTipo').val().length<=0||$('#cmbTipo').val().indexOf('none')==0){
				$('#cmbTipo').bind("change",function(){
				var temp= $('#cmbTipo');
				if(temp.val()!=null && temp.val().length>0 && $('#cmbTipo').val().indexOf('none')<0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errTipo').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errTipo').slideDown(1000);
				}
				
				})
				$('#errTipo').slideDown(1000);
				test=false;
				$('#cmbTipo').parent().parent().toggleClass("error");
			}
			else $('#cmbTipo').parent().parent().addClass("success");					
			if($('#txtPrecio').val()==null || $('#txtPrecio').val().length<=0){
				$('#txtPrecio').bind("change",function(){
				var temp= $('#txtPrecio');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errPrecio').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errPrecio').slideDown(1000);
				}
				
				})
				$('#errPrecio').slideDown(1000);
				test=false;
				$('#txtPrecio').parent().parent().toggleClass("error");
			}
			else $('#txtPrecio').parent().parent().addClass("success");
			if($('#txtDesc').val()==null || $('#txtDesc').val().length<=0){
				$('#txtDesc').bind("change",function(){
				var temp= $('#txtDesc');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errDesc').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errDesc').slideDown(1000);
				}
				
				})
				$('#errDesc').slideDown(1000);
				test=false;
				$('#txtDesc').parent().parent().toggleClass("error");
			}
			else $('#txtDesc').parent().parent().addClass("success");
	return test;
		
		
		}
	
	
	function alt_submit(){
		var form= document.frmData;
		if(validar()) alt_submit2();
		else alert("Uno o mas campos estan vacios");			
			}
	function alt_submit2(){

		$.ajax({
			  type: "POST",
			  url: "/Conan3000V2/IngSoft/servicio/servadicional/SMSServAdcional",
			  data: "accion=" + $(accion).val() + "&tipo=" + $(tipo).val() + "&txtNombre=" + $(txtNombreAdicional).val() + "&txtDesc=" + $(txtDesc).val()  
			  +  "&cmbTipo=" + $(cmbTipo).val() +"&txtPrecio="+$(txtPrecio).val()+"&txtCodigo=<%=resultado.getCodigo()%>",
			  dataType: "text",
			  success: function(msg){
				  var url="<%=request.getContextPath()%>"+msg;
				  $("#linkAceptar").css("display","inline");
				  $("#linkCerrar").css("display","none");
				  $("#modalTitulo").html("EXITO");	
				  $("#MensajeExito").css("display","inline");
				  $("#listaConcecionarios").css("display","none");			  
				  $("#modalContenido").html("La plantilla de evento ha sido <%=modo.equals("M")?"modificada":""%><%=modo.equals("E")?"eliminada":""%> exitosamente");
				  $("#linkAceptar").bind("click",function(){
					  location.href=url;					  
				  });
				  $("#bModal").trigger("click");
				  				  								
			  },
			  error: function(objeto, quepaso, otroobj){
				$("#linkAceptar").css("display","inline");
				$("#linkCerrar").css("display","none");
				$("#modalTitulo").html("ERROR");
				$("#modalContenido").html("No se pudo agregar su plantilla de evento, intentelo mas tarde");
				$("#bModal").trigger("click");
				alert("ERROR!!");			
			  }
		
			});		
	}
	
	
	</script>	
	<%}%>
</head>
<!-- nombre tipo monto descripcion -->
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
						<a href="<%=request.getContextPath()%>/IngSoft/general/index.jsp">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="SMSServAdicional?accion=Buscar&tipo=1">Mantenimiento de Servicios Adicionales</a> <span class="divider">/</span>
					</li>
					<li>
						<%=modo.equals("C")?"Consultar":""%><%=modo.equals("M")?"Modificar":""%><%=modo.equals("E")?"Eliminar":""%> Solicitud de Eventos Internos
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-plus-sign"></i><%=modo.equals("C")?"CONSULTAR":""%><%=modo.equals("M")?"MODIFICAR":""%><%=modo.equals("E")?"ELIMINAR":""%> SERVICIO ADICIONAL</h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" action="<%= response.encodeURL("SMSServAdcional")%>"  <%if(modo.equals("M")){%>onsubmit="alt_submit(); return false;"<%}%> name="frmData" method="post">
						<input type="hidden" name="accion" id="accion" value="<%=modo.equals("M")?"Modificar":""%><%=modo.equals("E")?"Eliminar":""%>"></input>
						<input type="hidden" name="tipo" id="tipo" value="2"></input>
						<input type="hidden" name="txtCodigo" id="txtCodigo" value="<%=resultado.getCodigo()%>"></input>							
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre de servicio adicional<%=modo.equals("M")?"(*)":""%>: </label>
						      <div class="controls">
						        <input type="text" <%=modo.equals("M")?"":"disabled"%> class="span6 typeahead" id="txtNombreAdicional"  data-provide="typeahead"  id="txtNombreAdicional" name="txtNombreAdicional" onkeypress="return alfanumerico(event);" value="<%=resultado.getNombre()%>" autofocus maxlength="50"/>
								<span class="help-inline" id="errNombreAdicional" style="display:none;">Este campo no puede estar vacio</span>						        													       
					          </div>
					        </div>
					        <div class="control-group">
								<label class="control-label" for="cmbTipo">Tipo de servicios adicionales<%=modo.equals("M")?"(*)":""%>:</label>
								<div class="controls">
								  <select <%=modo.equals("M")?"":"disabled"%>  data-rel="chosen" id="cmbTipo" name="cmbTipo" onchange="confirmarcambio($(this))">								  	
								  	<option value="Mueble" <%=resultado.getTipo().equals("Mueble")?"selected":""%>>Mueble</option>
								  	<option value="Electrodomestico" <%=resultado.getTipo().equals("Electrodomestico")?"selected":""%>>Electrodomestico</option>								  																																	
								  </select><br/>
								  <span class="help-inline" id="errTipo" style="display:none;">Debe seleccionar una sede</span>
								</div>
							  </div>	
					        <div class="control-group">
						      <label class="control-label" for="txtPrecio">Precio del servicio adicional<%=modo.equals("M")?"(*)":""%>: </label>
						      <div class="controls">
									<input  id="txtPrecio"  <%=modo.equals("M")?"":"disabled"%> class="span4" name="txtPrecio" onchange="vDinero($(this))"  type="text" onkeypress="return dinero(event);"  maxlength="10" value="<%=resultado.getPrecio()%>">
									<br/>
								  <span class="help-inline" id="errPrecio" name="errPrecio" style="display:none;">Este campo no puede estar vacio</span>
					        </div>
					        </div>
					        <div class="control-group">
						      <label class="control-label" for="txtDesc">Descripci&oacute;n<%=modo.equals("M")?"(*)":""%>: </label>
						      <div class="controls">
									<input  id="txtDesc" class="span4" name="txtDesc" <%=modo.equals("M")?"":"disabled"%>  type="text" onkeypress="return alfanumerico(event);"  maxlength="100" value="<%=resultado.getDescripcion()%>">
									<br/>
								  <span class="help-inline" id="errDesc" name="errDesc" style="display:none;">Este campo no puede estar vacio</span>
					        </div>
					        </div>					  							  							   							 
													
						    <div class="form-actions">
						    <%if(modo.equals("C")){ %>
							  <button type="button" class="btn" onclick="location.href='SMSServAdcional?accion=Buscar&tipo=1'" >Regresar</button>
							<%}
							else if(modo.equals("M")){%>
							  <button type="submit" id="btnModificar" class="btn btn-primary" >Guardar</button>
							  <button type="button" class="btn" onclick="location.href='SMSServAdcional?accion=Buscar&tipo=1'" >Cancelar</button>
							  <%} else if(modo.equals("E")){ %>
							  <button type="submit" id="btnEliminar" class="btn btn-primary" >Elminar</button>
							  <button type="button" class="btn" onclick="location.href='SMSServAdcional?accion=Buscar&tipo=1'" >Cancelar</button>
							  <%} %>
							</div>
						  </fieldset>
					  </form>   
					<%if(modo.equals("M")){%> %><span style="font-size:70%">(*)Campos Obligatorios</span><%} %>
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
		
		<div style="display: none;">
			<button class="btn btn-primary btn-setting" id="bModal"/>
		</div>
		<div class="modal hide fade" id="myModal">
		   <div id="MensajeExito" style="display: none;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h3 id="modalTitulo">EXITO</h3>
			</div>
			<div class="modal-body">
				<p id="modalContenido">El servicio adicional ha sido agregada exitosamente</p>
			</div>
			
			<div class="modal-footer">

				<button type="button" class="btn" id="linkAceptar" style="display: none">Aceptar</a>
				<a href="#" class="btn" id="linkCerrar"  data-dismiss="modal" style="display: none">Cerrar</a>
								
			</div>
			</div>			
		</div>
		<br/>
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
	<script src="js/conan3000.js"></script>
	<script>
		$('#txtNombreAdicional').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombreAdicional'),50)}, 0);
		})
		$('#txtDesc').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombreAdicional'),50)}, 0);
		})
		$('#txtPrecio').bind('paste',function(){		
			setTimeout(function(){filtrar('1234567890.',$('#txtPrecio'),50)}, 0);			
		})
		$(function() {
    	$( ".datepickerB" ).datepicker({
    		minDate: +5,
    });
  });
	</script>
	
		
</body>
</html>
