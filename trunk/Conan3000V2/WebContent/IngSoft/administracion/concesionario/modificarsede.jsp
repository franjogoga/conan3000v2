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
		var form= document.frmData;
		form.submit();
		
		parent.actualizar();
	}
	
	function verificar_fecha(comparacion,fecha1,fecha2){
	var fec1=fecha1.value.split("/");
	var fec2=document.getElementById(fecha2).value.split("/");
	var test=true;
	if(fec1.length==fec2.length) {
		var size=fec1.length;
		var a='';
		var b='';	
		for(i=size-1;i>=0;i--){
			a=a.concat(fec1[i]);
			b=b.concat(fec2[i]);
			}
		if(comparacion==0){
			if(parseInt(a)==parseInt(b))  test=false;
			}
		if(comparacion==1){
			if(parseInt(a)<=parseInt(b))   test=false;
			}
		if(comparacion==-1){
			if(parseInt(a)>=parseInt(b) )  test=false;
			}
		if(test){			
				fecha1.value=document.getElementById(fecha2).value;			
			}
			
		} 
	else{
		alert("Error al comparar fechas");
	}			
}

	<%! public boolean  encontrar(String a, String b){		
			if(b.equals(a)) return true;
			return false;
		}
		public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM/yyyy");
		return DF.format(date);
	}
	
		public boolean Estado_Activo (String estado){
			if (estado.equals("Activo"))
				return true;
			else
				return false;
		}
	
		public boolean Estado_Inactivo(String estado){
			if (estado.equals("Inactivo"))
				return true;
			else
				return false;
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
                    <h2>MODIFICAR</h2>
                  </div>
                  <div class="box-content">
                    <form class="form-horizontal" action="<%=response.encodeURL("SMAConcesionario")%>" name="frmData" method="post" >
                    <input type="hidden" name="codigo" value="<%=concesionario.getCodigo()%>"></input>
                    <input type="hidden" name="codigoSede" value="<%=concesionarioSede.getCodigo()%>"></input>        
                    <input type="hidden" name="accion" value="ModificarSede"></input>
					<input type="hidden" name="tipo" value="2"></input>
                      <fieldset>
                        <div class="control-group">
                          <label class="control-label" for="selectError">Sede (*):</label>
                          <div class="controls">
                            <select id="cmbSede" data-rel="chosen" name="cmbSede">
								<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"<%=encontrar(((SedeMiniBeanData)sedes.get(i)).getCodigo(),concesionarioSede.getCodigo())?"selected":""%>><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>
			           <div class="control-group">
			              <label class="control-label" for="date01" >Fecha Inicial (*):</label>
			                <div class="controls">
			                  <input type="text" name="fechaInicio" class="datepicker" id="fechaInicio" value="<%=formatear(new Date(concesionarioSede.getFechaInicio().getTime()))%>" readonly width=44px onchange="verificar_fecha(1,this,'fechaFin');">
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha Final (*):</label>
			                <div class="controls">
			                  <input type="text" name="fechaFin" class="datepicker" id="fechaFin" value="<%=formatear(new Date(concesionarioSede.getFechaFin().getTime()))%>" readonly width=44px onchange="verificar_fecha(-1,this,'fechaInicio');">
		                    </div>
		                  </div>
                        <div class="control-group">
								<label class="control-label" for="typeahead3">Estado:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="Activo" <%=Estado_Activo(concesionarioSede.getEstado())?"checked":""%>>
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="Inactivo" <%=Estado_Inactivo(concesionarioSede.getEstado())?"checked":""%>>
									Inactivo
								  </label>
								</div>
							  </div>
                        <div class="form-actions">
                          <button type="button" class="btn btn-primary" onclick="javascript:alt_Cerrar()">Guardar</button>
                        </div>
                      </fieldset>
                    </form>
                    <span style="font-size:70%">(*)Campos Obligatorios</span>
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
