<!DOCTYPE html>
<%@page import="IngSoft.administracion.bean.TipoAmbienteMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.SedeMiniBeanData"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Consultar Ambiente</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tiposAmbiente" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="ambiente" scope="request" class="IngSoft.administracion.bean.AmbienteBeanData"></jsp:useBean>
		
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
	<link rel="shortcut icon" href="img/favicon.ico">

	<%! public boolean  encontrar(String a, String b){		
			if(b.equals(a)) return true;
			return false;
		}
		
		public boolean Estado_Activo (String estado){
			if (estado.equals("Activo"))
				return true;
			else
				return false;
		}
		
		public boolean Estado_Inactivo (String estado){
			if (estado.equals("Inactivo"))
				return true;
			else
				return false;
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
                  <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span> </li>
                  <li> <a href="SMAAmbiente?accion=Buscar&tipo=1">Mantenimiento de Ambientes</a> <span class="divider">/</span></li>
                  <li>Consultar Ambiente</li>
                </ul>
              </div>
              <div class="row-fluid sortable">
                <div class="box span12">
                  <div class="box-header well" data-original-title>
                    <h2>CONSULTAR AMBIENTE</h2>
                  </div>
                  <div class="box-content">
                    <form class="form-horizontal" name="frmDelete" action="<%= response.encodeURL("SMAAmbiente")%>" method="post">
                      <input type="hidden" name="codigo" value="<%=ambiente.getCodigo()%>"></input>
					  <input type="hidden" name="accion" value="Consultar"></input>
					  <input type="hidden" name="tipo" value="2"></input>
			          			
                      <fieldset>
                        <div class="control-group">
                          <label class="control-label" for="disabledInput">Nombre:</label>
                          <div class="controls">
                            <input class="input-xlarge disabled" id="txtNombre" name="txtNombre" value="<%=ambiente.getNombre()%>" type="text" disabled="">
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="selectError">Tipo:</label>
                          <div class="controls">
                            <select name="cmbTipo" id="cmbTipo" data-rel="chosen" disabled>
                              	<%for(int i=0;i<tiposAmbiente.size();i++){ %>
										<option value="<%=((TipoAmbienteMiniBeanData)tiposAmbiente.get(i)).getCodigo()%>" <%=encontrar(((TipoAmbienteMiniBeanData)tiposAmbiente.get(i)).getCodigo(), ambiente.getIdTipoAmbiente())?"selected":""%>><%= ((TipoAmbienteMiniBeanData)tiposAmbiente.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="selectError">Sede:</label>
                          <div class="controls">
                            <select name="cmbSede" id="cmbSede" data-rel="chosen" disabled>
                              	<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%=((SedeMiniBeanData)sedes.get(i)).getCodigo()%>" <%=encontrar(((SedeMiniBeanData)sedes.get(i)).getCodigo(),ambiente.getIdSede())?"selected":""%>><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>
                        <div class="control-group">
                  		  <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
                          <div class="controls">
                            <textarea name="txtDescripcion" rows="3" id="txtDescripcion" disabled="" style="resize:none"><%=ambiente.getDescripcion()%></textarea>
                          
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label" for="textarea2">Caracter&iacute;sticas: </label>
                          <div class="controls">
                            <textarea name="txtCaracteristicas" rows="3" id="txtCaracteristicas" disabled="" style="resize:none"><%=ambiente.getCaracteristicas()%></textarea>
                          </div>
                        </div>
          				<div class="control-group">
								<label class="control-label" for="typeahead3">Estado:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" disabled="disabled" name="optionsRadios" id="optionsRadios1" value="option1" <%=Estado_Activo(ambiente.getEstado())?"checked":""%>>
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" disabled="disabled" name="optionsRadios" id="optionsRadios2" value="option2" <%=Estado_Inactivo(ambiente.getEstado())?"checked":""%>>
									Inactivo
								  </label>
								</div>
							  </div>
                        <div class="form-actions">
                          <button type="button" class="btn" onclick="location.href='buscarambiente.jsp'">Regresar</button>
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
	
		
</body>
</html>
