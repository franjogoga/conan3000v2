<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="java.util.Date"%>
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
	<title>Modificar Sorteo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<!--The beans  -->
	<jsp:useBean id="sorteo" scope="request"class="IngSoft.servicio.bean.SorteoBeanData"></jsp:useBean>
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	
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
		<script src="sorteo.js"></script>
	
	<script>
	function alfanumerico(e) 
	{ 
		var key = window.event.keyCode || event.keyCode;
		return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
	} 
		function validar(form){
			if(form.txtNombreSorteo.value.length <=0)return false;
			if(form.fFecInicio.value.length<=0)return false;
			if(form.fFecFin.value.lengtht<=0)return false;
			if(form.fFecSorteo.value.lengtht<=0)return false;			
			if(form.cmbSedes.value.length<=0)return false;
	return true;
		
		
		}
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
			}
		
		
		
			//document.fmrData.submit();

	</script>	
	<%! public boolean  encontrar(String a, String b){
		if (a.equals(b)) return true;
		return false;
	}
	public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM/YYYY");
		return DF.format(date);
	}
	
	public String generarCadena(String[] t){
		String a="";
		for(int i=0;i<t.length;i++)
			a= a.concat(t[i]+"/");
			if(a.length()>0) a=a.substring(0, a.length()-1);
		return a;
	}
	%>
		
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
						<a href="/Conan3000V2/IngSoft/servicio/buscarsorteo.jsp">Mantenimiento de Sorteos</a> <span class="divider">/</span>
					</li>
					<li>
						Modificar Sorteo
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-edit"></i>MODIFICAR SORTEO</h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmUpdate" method="post">
						<input type="hidden" name="txtLSede" value="<%=sorteo.getIdSede()%>" ></input>
						<input type="hidden" name="codigo" value="<%=sorteo.getIdSorteo()%>"></input>
						<input type="hidden" name="accion" value="Modificar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre de sorteo: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead"   data-provide="typeahead" id="txtNombreSorteo" name="txtNombreSorteo" value="<%=sorteo.getDescripcion()%>" onkeypress="return alfanumerico(event);" autofocus>
					          </div>
					        </div>
							<div class="control-group">
								<label class="control-label" for="selectError1">Sede </label>
								<div class="controls">
								  <select   data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>" <%=encontrar(((SedeMiniBeanData)sedes.get(i)).getNombre(), sorteo.getIdSede())?"selected":""%>><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																	
								  </select>
								</div>
							  </div>
							
							  
							  <div class="control-group">
							  <label class="control-label" for="date01">Inicio Reserva</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFecInicio" name="fFecInicio" value="<%=formatear(new Date(sorteo.getFechaInicio().getTime())) %>" onchange="verificar_fecha(1,this,'fFecFin');" >
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="date02">Fin Reserva</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFecFin" name="fFecFin"  value="<%=formatear(new Date(sorteo.getFechaFin().getTime())) %>" onchange="verificar_fecha(-1,this,'fFecInicio');"  >
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="date03">Fecha Sorteo</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="fFecSorteo" name="fFecSorteo"  value="<%=formatear(new Date(sorteo.getFechaSorteo().getTime())) %>" onchange="verificar_fecha(-1,this,'fFecFin');"  >
							  </div>
							</div>
						    <div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>
							  <button type="button" class="btn" onclick="location.href='buscarsorteo.jsp'" >Cancelar</button>
							</div>
						  </fieldset>
					  </form>   

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
