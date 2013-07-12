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
	<jsp:useBean id="resultados" scope="request" class="java.util.Vector"></jsp:useBean>	
	<jsp:useBean id="mensaje" scope="request" class="java.lang.String"></jsp:useBean>

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
	function alt_vitalizar(cod, strfechaInicio){
		var arrFechaInicio = strfechaInicio.split('-'); //arrFechaInicio = ["aaaa","mm","dd"]
		var fechaInicio = parseInt(arrFechaInicio[0])*10000 + parseInt(arrFechaInicio[1])*100 + parseInt(arrFechaInicio[2]);		
		var f = new Date();
		var fechaActualmenos30 = (f.getFullYear()-30)*10000 + (f.getMonth()+1)*100 + f.getDate();				
		
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Vitalizar";
		form.codigo.value=cod;
		
		if( fechaInicio > fechaActualmenos30) {
			if (confirm("Este socio aun no tiene m·s de 30 aÒos, deseas hacerlo vitalicio de todas maneras?")) {
				form.submit();	
			}
		} else {
			form.submit();	
		}					
	}
	function alt_suspender(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Suspender";
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
							<form class="form-horizontal" name="frmCriterioBusqueda" id="frmCriterioBusqueda" method="post" action="<%=response.encodeURL("SMASocio")%>">
								<input type="hidden" name="accion" value="Buscar"></input>
								
								<fieldset>		              			 
						
									<div class="control-group">
							    		<label class="control-label" for="txtNombres">Nombres: </label>
							    		<div class="controls">
							      			<input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres" onkeypress="return alfanumerico(event);" autofocus maxlength="50">
						        		</div>
						      		</div>
						    
							  		<div class="control-group">
							   			<label class="control-label" for="txtApellidoPaterno">Apellido Paterno: </label>
							    		<div class="controls">
							      			<input type="text" class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50">
						        		</div>
						      		</div>
						      		
							  		<div class="control-group">
							    		<label class="control-label" for="txtApellidoMaterno">Apellido Materno: </label>
							    		<div class="controls">
							      			<input type="text" class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50">
						        		</div>						        	
						      		</div>
						      		
							  		<div class="control-group">
										<label class="control-label" for="cmdTipoDocumento">Tipo de Documento:</label>
										<div class="controls">
								  			<select id="cmdTipoDocumento" name="cmdTipoDocumento" data-rel="chosen" >								  
												<option value="DNI">DNI</option>
												<option value="Carnet de Extranjeria">Carnet de Extranjeria</option>								
								  			</select>
										</div>
							  		</div>															
									  
									<div class="form-actions">
										<button type="submit" class="btn btn-primary">Buscar</button>
										<button type="reset" class="btn">Cancelar</button>                
									</div>
					  
								</fieldset>
							</form>
						</div> <!-- box content-->
					</div> <!-- box span12-->		      
				</div> <!-- row-fluid sortable-->		    
						
				<form id="frmAlternativo" name="frmAlternativo" method="post" action="<%= response.encodeURL("SMASocio")%>">
					<input type="hidden" name="accion" value="Vitalizar"></input>
					<input type="hidden" name="codigo" value=""></input>
					<input type="hidden" name="tipo" value="1"></input>
				</form>		
				
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2><i class="icon-th-list"></i> RESULTADOS</h2>
						</div>
						
						<div class="box-content">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">																
								
								<thead>
							  		<tr>
										<th>Nombres</th>
										<th>Apellido Paterno</th>
										<th>Apellido Materno</th>
										<th>Tipo Documento</th>
										<th>Numero Documento</th>
										<th>Fecha de Inicio</th>
										<th>Vitalicio</th>
										<th>Estado</th>
										<th>Acci&oacute;n</th>
							  		</tr>
						  		</thead>
								
								<tbody id="resultadoBusqueda">																			
								
									<% for(int i=0; i<resultados.size(); i++) { %>
									<tr>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getNombres()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getApellidoPaterno()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getApellidoMaterno()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getTipoDocumento()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getNumeroDocumento()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getFechaInicio()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getVitalicio()%></td>
										<td><%=((ResultadoSocioBeanData)resultados.get(i)).getEstado()%></td>										
										<td class="center">
											<a class="btn btn-success" href="javascript:alt_vitalizar('<%=((ResultadoSocioBeanData)resultados.get(i)).getIdSocio()%>', '<%=((ResultadoSocioBeanData)resultados.get(i)).getFechaInicio()%>')">
												<i class="icon-zoom-in icon-white"></i> Vitalizar 
											</a>											
											<a class="btn btn-danger" href="javascript:alt_suspender('<%=((ResultadoSocioBeanData)resultados.get(i)).getIdSocio()%>')">
												<i class="icon-trash icon-white"></i> Suspender
											</a>
										</td>
									</tr>					  
									<%}%>					  
								</tbody>							
							</table>
						</div> <!-- box content-->
					</div> <!-- box span12-->
				</div> <!-- row-fluis soportable -->
		    
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
		$('#txtNombres').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtNombres'),50)}, 0);
		})
	</script>
	<script>
		$('#txtApellidoPaterno').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtApellidoPaterno'),50)}, 0);
		})
	</script>
	<script>
		$('#txtApellidoMaterno').bind('paste',function(){		
			setTimeout(function(){filtrar('abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZÒ—·¡È…ÌÕÛ”˙⁄1234567890',$('#txtApellidoMaterno'),50)}, 0);
		})
	</script>
</body>
</html>