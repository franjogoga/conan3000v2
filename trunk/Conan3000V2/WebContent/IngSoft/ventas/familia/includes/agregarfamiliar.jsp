<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmFamiliar;
		if(validaForm()) form.submit();
			
}

function anhadir(cod, name){
	var form= document.frmFamiliar;
	//form.idSocio.value=name;
	form.txtSocio.value=cod;
	$.fn.colorbox.close();
	
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
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarfamiliar.jsp">Mantenimiento de Familiares </a> <span class="divider">/</span></li>
		        <li>Agregar Familiar</li>
	          </ul>
		      </div>
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-plus-sign"></i>AGREGAR FAMILIAR</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmFamiliar" method="Post"  action="SMVFamiliar">
			        <input type="hidden" name="accion" value="Agregar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			        
			          <fieldset>

			            <div class="control-group" id="dvCodigo">
			              <label class="control-label" for="typeahead7">Socio Asociado:</label>
			              <div class="controls">
			                <input type="text"   class="span6 typeahead" id="txtSocio"  name="txtSocio" data-provide="typeahead">
			                <br>
		                     <div  align="left"> <a class="btn btn-primary iframe" href="../socio/seleccionarsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Socio</a> </div>
		                     <span class="help-inline" id="errCodigo">Please correct the error</span>
		                  </div>
		                </div>
		                
		                 
			               <div class="control-group">
			                  <label class="control-label" for="selectError">Parentesco:</label>
			                  <div class="controls">
			                    <select name="cmbParentesco" id="selectError" data-rel="chosen" >
			                      <option selected>Hija(o)</option>
			                      <option>Padre</option>
			                      <option>Madre</option>
		                        </select>
		                      </div>
		                    </div>
			         
			              <div class="control-group" id="dvNombres">
			                <label class="control-label" for="typeahead6">Nombres(*):</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead"  name="txtNombres" id="txtNombres" data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;" >
		                      <span class="help-inline" id="errNombres">Please correct the error</span>
		                    </div>
		                  </div>
		                  
			              <div class="control-group" id="dvApellidoP">
			                <label class="control-label" for="typeahead4">Apellido Paterno(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtApellidoPaterno" id="txtApellidoPaterno"  data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;" >
		                      <span class="help-inline" id="errApellidoP">Please correct the error</span>
		                    </div>
		                  </div>
			              <div class="control-group" id="dvApellidoM">
			                <label class="control-label" for="typeahead8">Apellido Materno(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtApellidoMaterno" id="txtApellidoMaterno"  data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;" >
		                     <span class="help-inline" id="errApellidoM">Please correct the error</span>
		                    </div>
		                  </div>
		                  
		                   <div class="control-group" id="dvFecha">
			              		<label class="control-label" for="typeahead4">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaNacimiento" name="fFechaNacimiento" maxlength="50" onpaste="return false;">
			             		  <span class="help-inline" id="errFecha">Please correct the error</span>
			             		</div>
		                		</div>
			            
			                		                  		                      
		                       <div class="control-group" id="dvTipo">
								<label class="control-label" for="typeahead3">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton"  value="DNI">
									DNI
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton"  value="Carnet de Extranjeria">
									Carnet de Extranjeria
								  </label>
								   <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton"  value="Pasaporte">
									Pasaporte
								  </label>
								  <span class="help-inline" id="errTipo">Please correct the error</span>
								</div>
							  </div>
							  
							<div class="control-group" id="dvNumDoc">
			                <label class="control-label" for="typeahead8">N&uacute;mero de Doc.(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtNumeroDocumento" class="span6 typeahead" id="txtNumeroDocumento"  data-provide="typeahead" data-items="4" maxlength="9" onpaste="return false;">
		                       <span class="help-inline" id="errNumDoc">Please correct the error</span>
		                    </div>
		                  </div>
		                
			            
			               <div class="control-group" id="dvTelefonoF">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Fijo(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtTelefonoF" id="txtTelefonoF"  data-provide="typeahead" data-items="4" maxlength="7" onpaste="return false;">
		                      <span class="help-inline" id="errTelefonoF">Please correct the error</span>
		                    </div>
		                  </div>
		                  
		                  <div class="control-group" id="dvTelefonoC">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Celular(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtTelefonoC" id="txtTelefonoC"  data-provide="typeahead" data-items="4" maxlength="9" onpaste="return false;">
		                      <span class="help-inline" id="errTelefonoC">Please correct the error</span>
		                    </div>
		                  </div>
		                  
			              <div class="control-group" id="dvCorreo">
			                <label class="control-label" for="typeahead2">Correo electr&oacute;nico(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtCorreo" id="txtCorreo"  data-provide="typeahead" data-items="4" maxlength="100" onpaste="return false;">
		                      <span class="help-inline" id="errCorreo">Please correct the error</span>
		                    </div>
		                  </div>
		                
		                
			            <div class="form-actions">
			            <input type="hidden" name="idSocio" value=""/></input>
			               <button  type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button> 
			               <button  type="button" class="btn" onclick="location.href='buscarfamiliar.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		                (*) Campos Obligatorios
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
