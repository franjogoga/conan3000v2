 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmMembresia;
		if(validaForm()) form.submit();
			
}

function anhadir(cod, name){
	var form= document.frmMembresia;
	form.txtSocio.value=name;
	form.idSocio.value=cod;
	$.fn.colorbox.close();
	
} 

function confFecha(){
	var form= document.frmMembresia;
	if(form.cmbPeriodo.value=="Anual"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[2]=parseInt(fechaI[2])+1;
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Semestral"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[1]=parseInt(fechaI[1])+6;
		if(fechaI[1]>12){
			fechaI[2]=parseInt(fechaI[2])+1;
			fechaI[1]=parseInt(fechaI[1])-12;
		}
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Indefinido"){
	document.getElementById("dvFechaFin").style.display='block';
	}
	
}
</script>

<%
Calendar c1 = GregorianCalendar.getInstance();
c1.add(Calendar.YEAR, 1);
SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecAnoIni=dfActual.format(new java.util.Date());

String fecAnoFin=dfActual.format(c1.getTime()); %>
<!-- content starts -->
			  <div>
			   <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarmembresia.jsp">Mantenimiento de Membres&iacute;a</a> <span class="divider">/</span></li>
		        <li> Agregar  Membres&iacute;a</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>AGREGAR MEMBRESIA</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmMembresia" method="Post"  action="SMVMembresia">
					<input type="hidden" name="accion" value="Agregar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			          <div class="control-group" id="dvPeriodo">
                            <label class="control-label" for="selectError">Periodo (*):</label>
                            <div class="controls">
                              <select  id="cmbPeriodo" data-rel="chosen" name="cmbPeriodo" class='' onChange="javascript:confFecha();">
								<option value="Indeterminado">Indeterminado</option>
								<option value="Anual">Anual</option>
                                <option value="Semestral">Semestral</option>
                              </select>
                              <span class="help-inline" id="errPeriodo">Please correct the error</span>
                            </div>
                          </div>
			            <div class="control-group" id="dvFechaInicio">
			              <label class="control-label" for="typeahead7" name="fFechaInicio">Fecha Inicio (*): </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker"  id="fFechaInicio" name="fFechaInicio" value="<%=fecAnoIni%>" readonly="readonly">
			                <span class="help-inline" id="errFechaInicio">Please correct the error</span>
			              </div>
		                </div>
			            <div class="control-group" id="dvFechaFin">
			              <label class="control-label" for="typeahead6">Fecha Fin (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="fFechaFin" name="fFechaFin" value="<%=fecAnoFin%>" readonly="readonly">
			                  <span class="help-inline" id="errFechaFin">Please correct the error</span>
			                </div>
		                  </div>
			              <div class="control-group" id="dvCosto">
			                <label class="control-label" for="typeahead4">Costo (S/.) (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="txtCosto" name="txtCosto"  data-provide="typeahead" data-items="4" >
			                  <span class="help-inline" id="errCosto">Please correct the error</span>
			                </div>
		                  </div>
			              <div class="control-group" id="dvSocio">
			                <label class="control-label" for="typeahead8">Socio (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" name="txtSocio" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../socio/seleccionarsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Socio</a> </div>
			                  <span class="help-inline" id="errSocio">Please correct the error</span>
			                </div>
		                  </div>
                          
						<div class="control-group" id="dvEstado">
	                <label class="control-label" for="selectError">Estado (*):</label>
			                <div class="controls">
			                 <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="activo" checked="checked" class=''>
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Inactivo" class=''>
									Inactivo
								  </label><br>
		                      <span class="help-inline" id="errEstado">Please correct the error</span>
			                </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			            <input type="hidden" name="idSocio" value=""/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
			              <button type="button" class="btn" onclick="location.href='buscarmembresia.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		            </form>
		          (*) Datos Obligatorios</div>
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