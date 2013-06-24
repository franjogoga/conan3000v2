<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.servicio.bean.TipoEventoMiniBeanData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.servicio.bean.ResultadoEventoBeanData"%>
<%@page import="java.util.Vector"%>

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
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	function alt_consultar(cod){	
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
	return null;
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_eliminar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Eliminar";
		form.codigo.value=cod;
		form.submit();
	}
		
	function alt_submit(){
		$("#frmCriteriosBusqueda").submit();
		$("#boton").trigger("click");
		
	}
	function alt_submit2(){
		$.ajax({
		  type: "POST",
		  url: "<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento",
		  data: "accion=" + $(accion).val() + "&tipo=" + $(tipo).val() + "&txtNombre=" + $(txtNombre).val() + "&cmbEstados=" + $(cmbEstados).val() + "&date01=" 
		  + $(date01).val()+ "&date02=" + $(date02).val()+"&cmbSedes="+$(cmbSedes).val(),
		  dataType: "html",
		  success: function(msg){
			$("#resultadoBusqueda").html(msg);
			updatetable();
		  },
		  error: function(objeto, quepaso, otroobj){
			alert("ERROR!! Pasó lo siguiente: "+quepaso);
		  }
	
		});
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
						Mantenimiento de Solicitud de Eventos 
					</li>
					
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR EVENTO</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							
						</div>
					</div>
					<div class="box-content">
						<!-- <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="post" onsubmit="xmlhttpPost('<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento?accion=Buscar', 'frmCriteriosBusqueda', 'resultadoBusqueda','<img >');
		 return false;"> -->
		<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="post" >
		 <input type="hidden" id="accion" name="accion" value="Buscar"></input>
		  <input type="hidden" id="tipo" name="tipo" value="2"></input>
						  <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="typeahead">Nombre de Evento </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="txtNombre" name="txtNombre" onkeypress="return alfanumerico(event);" autofocus maxlength="50">
							  </div>
							</div>
							 <div class="control-group">
								<label class="control-label" for="cmbSedes">Sede relacionada:</label>
								<div class="controls">
								  <select  data-rel="chosen" id="cmbSedes" name="cmbSedes" onchange="confirmarcambio($(this))">
								  	<option value="all" selected>Todas</option>
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																									
								  </select><br/>								  
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label" for="cmbEstados">Estado:</label>
								<div class="controls">
								  <select  data-rel="chosen" id="cmbEstados" name="cmbEstados">
								  	<option value="all" selected>Todos</option>
								  	<option value="REGISTRADO" >Registrado</option>
								  	<option value="ANULADO" >Anulado</option>
								  	<option value="CANCELADO" >Cancelado</option>								  																																
								  </select><br/>								  
								</div>
							  </div>	
							<div class="control-group">
							  <label class="control-label" for="date01">Rango de Fecha</label>
							  <div class="controls">
								<input type="text" class="datepickerB" id="date01" name="date01" readonly="readonly" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>" onchange="verificar_fecha(1,this,'date02');">
								&nbsp;a&nbsp;
								<input type="text" class="datepickerB" id="date02" readonly="readonly" name="date02" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>" onchange="verificar_fecha(-1,this,'date01');">
							  </div>
							</div>														
									
							<div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="alt_submit2();">Buscar</button>
							  <button type="reset" id="boton"class="btn">Limpiar</button>
							</div>
						  </fieldset>
						</form>   

					</div>
					
				</div><!--/span-->

			</div><!--/row-->
			<form id="frmAlternativo" name="frmAlternativo" method="post" action="<%= response.encodeURL("SMCEvento")%>">
			<input type="hidden" name="accion" value="Agregar"></input>
			<input type="hidden" name="codigo" value=""></input>
			<input type="hidden" name="tipo" value="1"></input>
			</form>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i></i> RESULTADOS</h2>
                        
						
					</div>           
					<div class="box-content" id="resultadoBusqueda" >
                             
<table id="mytable" class="table table-striped table-bordered bootstrap-datatable datatable">
                            <!-- agregar nuevo boton -->
                            
                            
                            <div align="right">
                            
                                <a class="btn btn-primary" href="javascript:alt_agregar()">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
                              
                             </div>          
                          <thead>
							  <tr>
								<th>Tipo Solicitud</th>
							        <th>Nombre Evento</th>
							        <th>Fecha</th>
							        <th>Sede</th>
							        <th>Estado</th>												        							      							       
							        <th>Acción</th>
							  </tr>
						  </thead>
                          <element>
                          	<tbody >
                          		 	</tbody>
                          </element>
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
	
	<script src="js/ajaxsbmt.js"></script>
	<script>
		$(function() {
    	$( ".datepickerB" ).datepicker({
    		 changeMonth: true,
    	      changeYear: true,
    	      showButtonPanel: true
    });
  });
	</script>
		
	
</body>
</html>
