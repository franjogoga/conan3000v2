<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.ConcesionarioSedeBeanData"%>
<%@page import="IngSoft.administracion.bean.ConcesionarioBeanData"%>
<%@page import="java.util.Vector"%>
<html lang="en">
<head>
	<jsp:include page="/IngSoft/general/header.jsp" />
	<jsp:useBean id="sedes" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="concesionario" scope="request" class="IngSoft.administracion.bean.ConcesionarioBeanData"></jsp:useBean>
	<jsp:useBean id="concesionarioSede" scope="request" class="IngSoft.administracion.bean.ConcesionarioSedeBeanData"></jsp:useBean>
	
	<link rel="shortcut icon" href="img/conan_logo.png">
	
	<script>
	
	function alt_Cerrar(){
		$.ajax({
			  type: "POST",
			  url: "/Conan3000V2/IngSoft/administracion/concesionario/SMAConcesionario",
			  data: "accion=EliminarSede&tipo=2&codigo=<%=concesionario.getCodigo()%>&codigoSede=<%=concesionarioSede.getCodigo()%>",
			  dataType: "text",
			  success: function(){
			  	parent.actualizar();    				  								
			  },
			  error: function(){ }
			});
	}
	
	<%! public boolean  encontrar(String a, String b){		
			if(b.equals(a)) return true;
			return false;
		}
		public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM/yyyy");
		return DF.format(date);
	}
	%>
	</script>
	
	
</head>

<body>
		<div class="container-fluid">
		<div class="row-fluid">
				
			
            <div id="content" class="span10">
              <!-- content starts -->
              <div class="row-fluid sortable">
                <div class="box span12">
                  <div class="box-header well" data-original-title>
                    <h2>ELIMINAR</h2>
                  </div>
                  <div class="box-content">
                    <form class="form-horizontal" action="<%=response.encodeURL("SMAConcesionario")%>" name="frmData" method="post" >
                    <input type="hidden" name="codigo" value="<%=concesionario.getCodigo()%>"></input>
                    <input type="hidden" name="codigoSede" value="<%=concesionarioSede.getCodigo()%>"></input>        
                    <input type="hidden" name="accion" value="EliminarSede"></input>
					<input type="hidden" name="tipo" value="2"></input>
                      <fieldset>
                        <div class="control-group">
                          <label class="control-label" for="selectError">Sede:</label>
                          <div class="controls">
                            <select id="cmbSede" data-rel="chosen" name="cmbSede" disabled>
								<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"<%=encontrar(((SedeMiniBeanData)sedes.get(i)).getCodigo(),concesionarioSede.getCodigo())?"selected":""%>><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>
			           <div class="control-group">
			              <label class="control-label" for="date01" >Fecha Inicial:</label>
			                <div class="controls">
			                  <input type="text" name="fechaInicio" class="disabled" id="fechaInicio" value="<%=formatear(new Date(concesionarioSede.getFechaInicio().getTime()))%>" readonly width=44px>
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha Final:</label>
			                <div class="controls">
			                  <input type="text" name="fechaFin" class="disabled" id="fechaFin" value="<%=formatear(new Date(concesionarioSede.getFechaFin().getTime()))%>" readonly width=44px>
		                    </div>
		                  </div>
                        <div class="form-actions">
                          <button type="button" class="btn btn-primary" onclick="javascript:alt_Cerrar()">Eliminar</button>
                        </div>
                      </fieldset>
                    </form>
                  </div>
                </div>
                <!--/span-->
              </div>
 
            </div>
          <!--/#content.span10-->
				</div><!--/fluid-row-->
				
		
		 		
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
