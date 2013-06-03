<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.servicio.bean.ResultadoSorteoBeanData"%>
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
	<title>Buscar Sorteo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!--The beans  -->
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>


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
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,10);
	
	}
	
	function alt_submit(){
		var form= document.frmData;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
	}
	function alt_submit2(){
		alert("No puedes eliminar un sorteo pasado");			
	}
	
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Generar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
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
						Mantenimiento de Sorteos 
					</li>
					
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR SORTEO</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<!-- <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="post" onsubmit="xmlhttpPost('/Conan3000V2/IngSoft/servicio/evento/SMSEvento?accion=Buscar', 'frmCriteriosBusqueda', 'resultadoBusqueda','<img >');
		 return false;"> -->
		 <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="post" action="<%= response.encodeURL("SMSSorteo")%>">
		 <input type="hidden" name="accion" value="Buscar"></input>
						  <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="typeahead">Nombre de Sorteo </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead" name="txtNombre" onkeypress="return alfanumerico(event);" autofocus>
							  </div>
							</div>

							<div class="control-group">
							  <label class="control-label" for="date01">Fecha Inicio</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date01" name="date01"  >
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="date02">Fecha Fin</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date02" name="date02" onchange="alt_fecha(this);verificar_fecha(1,this,'date01');"  >
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="date03">Fecha Sorteo</label>
							  <div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date03" name="date03"  onchange="alt_fecha(this);verificar_fecha(1,this,'date02');"  >
							  </div>
							</div>
							
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary" >Buscar</button>
							  <button type="reset" class="btn">Cancelar</button>
							</div>
						  </fieldset>
						</form>   

					</div>
					
				</div><!--/span-->

			</div><!--/row-->
			<form id="frmAlternativo" name="frmAlternativo" method="post" action="<%= response.encodeURL("SMSSorteo")%>">
			<input type="hidden" name="accion" value="Agregar"></input>
			<input type="hidden" name="codigo" value=""></input>
			<input type="hidden" name="tipo" value="1"></input>
			</form>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i></i> RESULTADOS</h2>
                        
						
					</div>           
					<div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <!-- agregar nuevo boton -->
                            
                            
                            <div align="right">
                            
                                <a class="btn btn-primary" href="javascript:alt_agregar()">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
                              
                             </div>          
                          <thead>
							  <tr>
								  <th>Codigo</th>
							        <th>Nombre Sorteo</th>
							        <th>Fecha Inicio</th>
							        <th>Fecha Fin</th>
									<th>Fecha Sorteo </th>
												        							      							        
							        <th>Acci�n</th>
							
							  </tr>
						  </thead>
                          <element>
                          	<tbody id="resultadoBusqueda">
                          		<% SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                          		%>
                          		<tr>
                          			<td class="center">
                          				<%=
                          					((ResultadoSorteoBeanData)resultados.get(i)).getCodigo()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					((ResultadoSorteoBeanData)resultados.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((ResultadoSorteoBeanData)resultados.get(i)).getFechaIni())
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((ResultadoSorteoBeanData)resultados.get(i)).getFechaFin())                  
                          				%>
                          			</td>
                          			<td class="center">
                          				<%=
                          					df.format(((ResultadoSorteoBeanData)resultados.get(i)).getFechaSorteo())                  
                          				%>
                          			</td>
                          			<td class="center">
                          				<%if (((ResultadoSorteoBeanData)resultados.get(i)).getFlag()==1){ %>
                          				<a class="btn btn-success" 
                          					href="javascript:alt_consultar('<%=((ResultadoSorteoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-zoom-in icon-white">
                          					</i>Sorteo Generado
                          				</a>
                          				<a type="hidden" class="btn btn-info"
                          					href="javascript:alt_submit2()">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<%}else{ %>
                          				<a class="btn btn-success" 
                          					href="javascript:alt_consultar('<%=((ResultadoSorteoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-zoom-in icon-white">
                          					</i>Generar
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoSorteoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<%} %>
                          				
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoSorteoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          		</tr>


                          		<%}%>

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
	
	<script src="js/ajaxsbmt.js"></script>

</body>
</html>
