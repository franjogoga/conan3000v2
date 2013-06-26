<!DOCTYPE html>
<%@page import="IngSoft.general.bean.Conan3000Constantes"%>
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
	<meta charset="utf-8">
	<title>Agregar Solicitud de Evento</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	
	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-spacelab.css" rel="stylesheet">
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
	<script>
	var cont=-1;
	var codSedeActual="none";
	var fechaActual="<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>";
	var boton='#btnConcecionarios';
	var concesionario='';
		function validar(){
			var test=true;			
			$('#fFecha').parent().parent().addClass("success");
			$('#listaServicios').parent().addClass("success");										
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
			}
			else $('#txtNombreEvento').parent().parent().addClass("success");
			
			if($('#cmbSedes').val()==null||$('#cmbSedes').val().length<=0||$('#cmbSedes').val().indexOf('none')==0){
				$('#cmbSedes').bind("change",function(){
				var temp= $('#cmbSedes');
				if(temp.val()!=null && temp.val().length>0 && $('#cmbSedes').val().indexOf('none')<0) {
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
			}
			else $('#cmbSedes').parent().parent().addClass("success");						
			if($('#txtCosto').val()==null || $('#txtCosto').val().length<=0){
				$('#txtCosto').bind("change",function(){
				var temp= $('#txtCosto');
				if(temp.val()!=null && temp.val().length>0) {
				temp.parent().parent().removeClass("error");
				temp.parent().parent().addClass("success");
				$('#errCosto').slideUp(1000);
				}
				else {
				temp.parent().parent().removeClass("success");
				temp.parent().parent().addClass("error");
				$('#errCosto').slideDown(1000);
				}
				
				})
				$('#errCosto').slideDown(1000);
				test=false;
				$('#txtCosto').parent().parent().toggleClass("error");
			}
			else $('#txtCosto').parent().parent().addClass("success");
	return test;
		
		
		}
	
	
	function alt_submit(){
		var form= document.frmData;
		if(validar()) alt_submit2();
		else alert("Uno o mas campos estan vacios");			
			}
	function alt_submit2(){
		var listaconcecionarios=$(".btn-success [disabled='disabled']");
		
		for(i=0;i<listaconcecionarios.length;i++){
			concesionario=concesionario+listaconcecionario[i].attr('id')+'@';		
		}
		$.ajax({
			  type: "POST",
			  url: "<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento",
			  data: "accion=" + $(accion).val() + "&tipo=" + $(tipo).val() + "&txtNombreEvento=" + $(txtNombreEvento).val()   
			  +"&cmbSedes="+ $(cmbSedes).val() + "&fFecha=" + $(fFecha).val()+"&concesionario="+concesionario+"&costo="+$(txtCosto).val(),
			  dataType: "text",
			  success: function(msg){
				  var url="<%=request.getContextPath()%>"+msg;
				  $("#linkAceptar").css("display","inline");
				  $("#linkCerrar").css("display","none");
				  $("#modalTitulo").html("EXITO");	
				  $("#MensajeExito").css("display","inline");
				  $("#listaConcecionarios").css("display","none");			  
				  $("#modalContenido").html("La plantilla de evento ha sido agregada exitosamente");
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
	
	function resetConcesionarios(){	 
	 $('#listaServicios').html("<div class='input-append'><input id='appendedInputButton' size='16' type='text' readonly='true' value='Salon Principal'><button class='btn' disabled='disabled' type='button'>X</button></div><br/>");
	 concesionario='';
	}
	function getConcecionarios(){
	$(this).attr('disabled','disabled');
		$.ajax({
			  type: "POST",
			  url: "<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento",
			  data: "accion=" + $(accion).val() + "&tipo=3" + "&cmbSedes=" + $(cmbSedes).val() + "&fFecha=" + $(fFecha).val() ,
			  dataType: "html",
			  success: function(msg){				  
				  $("#concesionarioResultados").html(msg);
				  updatetable();				
				  $('#mytable_length').css("display","none");  
				  $("#bModal").trigger("click");
				  $(this).removeAttr('disabled','');
				  $(boton).unbind('click');
				  $(boton).bind('click', function(){$("#bModal").trigger("click");});				  				  								
			  },
			  error: function(objeto, quepaso, otroobj){
				$("#linkAceptar").css("display","inline");
				$("#linkCerrar").css("display","none");
				$("#modalTitulo").html("ERROR");
				$("#modalContenido").html("Hubo un error, no se pudo conseguir la lista de concesionarios");
				$("#bModal").trigger("click");
				$(this).removeAttr('disabled','');
				
			  }
		
			});		
		
	}
	
	
	function confirmarcambio(elem){
		var contenido=elem.val();
		$('.btn-success').removeAttr('disabled')
		resetConcesionarios();
		//if(temp.length>0) temp.removeAtrr('disabled');
		if($('#cmbSedes').val().indexOf('0')==0){
			$(boton).attr('disabled','disabled');
		}
		else $(boton).removeAttr('disabled');
		if(elem.attr('id').indexOf("fFecha")>=0){
			$(boton).unbind('click');
			if((contenido.indexOf(fechaActual)>=0)) $(boton).bind('click', function(){$("#bModal").trigger("click");});
			else $(boton).bind('click',function(){getConcecionarios();})
		}
		else{
			$(boton).unbind('click');
			if((contenido.indexOf(codSedeActual)>=0)) $(boton).bind('click', function(){$("#bModal").trigger("click");});
			else $(boton).bind('click',function(){getConcecionarios();})		
		}
	}
			
	</script>	
</head>

<body>
		<jsp:include page="/Club/generalClub/superior.jsp" />
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<jsp:include page="/Club/generalClub/leftmenu.jsp" />
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
						Agregar Solicitud de Eventos Internos
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-plus-sign"></i>AGREGAR EVENTO</h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" action="<%= response.encodeURL("SMCEvento")%>" onsubmit="alt_submit(); return false;"name="frmData" method="post">
						<input type="hidden" name="accion" id="accion" value="Agregar"></input>
						<input type="hidden" name="tipo" id="tipo" value="2"></input>
						<input type="hidden" name="fFechaActual" id="fFechaActual" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>"></input>
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre de evento(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreEvento"  data-provide="typeahead"  id="txtNombreEvento" name="txtNombreEvento" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>
								<span class="help-inline" id="errNombreEvento" style="display:none;">Este campo no puede estar vacio</span>						        													       
					          </div>
					        </div>					        
					        <div class="control-group">
						      <label class="control-label" for="txtCosto">Costo Reserva Salon Principal: </label>
						      <div class="controls">

									<input  id="txtCosto" class="span4" name="txtCosto" value="<%=Conan3000Constantes.getInstance().getPrecioSalonPrincipal()%>" readonly onchange="vDinero($(this))"  type="text" onkeypress="return dinero(event);"  maxlength="12">
									<br/>
								  <span class="help-inline" id="errCosto" name="errCosto" style="display:none;">Este campo no puede estar vacio</span>
					        </div>
					        </div>					   
							  <div class="control-group">
								<label class="control-label" for="cmbSedes">Sede relacionada(*):</label>
								<div class="controls">
								  <select  data-rel="chosen" id="cmbSedes" name="cmbSedes" onchange="confirmarcambio($(this))">
								  	<option value="none" selected>--Seleccione una Sede--</option>
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select><br/>
								  <span class="help-inline" id="errSedes" style="display:none;">Debe seleccionar una sede</span>
								</div>
							  </div>							   
							  <div class="control-group">
							  <label class="control-label" for="fFecha">Fecha(*):</label>
							  <div class="controls">
								<input type="text" class="input datepickerB" id="fFecha" readonly="true" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(Utils.fechaMas( new Date(), 5))%>"  name="fFecha" onchange="confirmarcambio($(this))">
							  </div>
							</div>
							 <div class="control-group">
							  <label class="control-label" for="fFecha">Servicios Seleccionados:</label>
							  <div class="controls" id="listaServicios">
								<div class="input-append">
									<input id="appendedInputButton" size="16" type="text" readonly="true" value="Salon Principal"><button class="btn" disabled="disabled" type="button">X</button>
								  </div><br/></div>
							</div>
							<div class="form-actions">
							  <button type="button" id="btnConcecionarios" class="btn btn-primary" disabled="disabled" >Concesionarios</button>							 
							</div>														
						    <div class="form-actions">
							  <button type="submit" id="btnAgregar" class="btn btn-primary" >Agregar</button>
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
				<p id="modalContenido">La plantilla de evento ha sido agregada exitosamente</p>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn" id="linkAceptar" style="display: none">Aceptar</a>
				<a href="#" class="btn" id="linkCerrar"  data-dismiss="modal" style="display: none">Cerrar</a>
								
			</div>
			</div>
			<div id="listaConcecionarios">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h3 id="modalTitulo">Lista de concesionarios</h3>
			</div>
			<div class="box-content" id="concesionarioResultados"  >
			
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
		$('#txtNombreEvento').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombreEvento'),50)}, 0);
		})
		$('#txtNumEntradas').bind('paste',function(){		
			setTimeout(function(){filtrar('1234567890',$('#txtNumEntradas'),50)}, 0);
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
