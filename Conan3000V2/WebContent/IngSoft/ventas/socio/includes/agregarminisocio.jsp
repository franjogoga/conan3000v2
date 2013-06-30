<%@page import="IngSoft.venta.bean.DistritoMiniBeanData"%>
<script>


function alt_submit(){
		var form= document.frmSocio;
		if(validaForm()) form.submit();
			
}

function anhadir(cod,name,apellidop,apellidom,direccion,fecha){
	var form= document.frmSocio;
	
	form.txtSolicitud.value=cod;
	form.txtNombres.value=name;
	form.txtApellidoPaterno.value=apellidop;
	form.txtApellidoMaterno.value=apellidom;
	form.txtDireccion.value=direccion;
	form.fFechaNacimiento.value=fecha;

	$.fn.colorbox.close();
	
} 



</script>	

<jsp:useBean id="tiposDistrito" scope="request"class="java.util.Vector"></jsp:useBean>
	
			  <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      		           
			              <li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home / </a><a href="/Conan3000V2/IngSoft/ventas/socio/buscarsocio.jsp">Mantenimiento de Socios / </a>Agregar Socio
			           
			              </li>
			              
			           </ul>
			 </div>
		              <div class="row-fluid sortable">
			            <div class="box span12">
			              <div class="box-header well" data-original-title>
			                <h2>AGREGAR SOCIO </h2>
		                  </div>
			              <div class="box-content">
                          
			                <form class="form-horizontal" id="frmSocio" name="frmSocio" method="POST" action="SMVSocio">
			                 <input type="hidden" name="accion" value="AgregarMini"></input>
							<input type="hidden" name="tipo" value="2"></input>
			                
			                  <fieldset>
			                  
			                  <div class="control-group" id="dvSolicitud">
			                      <label class="control-label" for="typeahead1">Codigo Solicitud(*): </label>
			                      <div class="controls">
			                        <input type="text" class="span6 typeahead" id="txtSolicitud" name="txtSolicitud" maxlength="9" onpaste="return false;">
			                        <div  align="left"> <a class="btn btn-primary iframe" href="../solicitud/seleccionarsolicitudsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Solicitud</a> </div>
		                          	<span class="help-inline" id="errSolicitud">Please correct the error</span>
		                          	
		                          </div>
		                        </div>
			                  
			                    <div class="control-group" id="dvNombres">
			                      <label class="control-label" for="typeahead1">Nombres(*): </label>
			                      <div class="controls">
			                        <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres" maxlength="50" onpaste="return false;" >
			                         <span class="help-inline" id="errNombres">Please correct the error</span>
		                          </div>
		                        </div>
			                   
			                      <div class="control-group" id="dvApellidoP">
			                        <label class="control-label" for="typeahead2">Apellido Paterno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno" maxlength="50" onpaste="return false;">
			                           <span class="help-inline" id="errApellidoP">Please correct the error</span>
		                            </div>
		                          </div>
		                          
			                      <div class="control-group" id="dvApellidoM">
			                        <label class="control-label" for="typeahead3">Apellido Materno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno"  data-provide="typeahead" maxlength="50" onpaste="return false;">
			                           <span class="help-inline" id="errApellidoM">Please correct the error</span>
		                            </div>
		                          </div>
                                  
                                 <div class="control-group" id="dvDireccion">
			                          <label class="control-label" for="typeahead8">Direcci&oacute;n(*): </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtDireccion" name="txtDireccion"  data-provide="typeahead" data-items="4" maxlength="100" onpaste="return false;">
		                                <span class="help-inline" id="errDireccion">Please correct the error</span>
		                              </div>
		                            </div>
                                
                                  <div class="control-group" id="dvFecha">
			              		<label class="control-label" for="typeahead4">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaNacimiento" name="fFechaNacimiento" maxlength="10" readonly="readonly">
			             		  <span class="help-inline" id="errFecha">Please correct the error</span>
			             		</div>
		                		</div>
                         
			                    <div class="control-group" id="dvDistrito">
								<label class="control-label" for="selectdistrito">Distrito (*):</label>
								<div class="controls">
								  <select name="cmdDistrito" id="cmdDistrito" data-rel="chosen">
									<%for(int i=0;i<tiposDistrito.size();i++){ %>
										<option value="<%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getIdDistrito()%>" <%=i==0?"selected":""%>><%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getNombreDistrito()%></option>
									<%} %>	
								  </select>
								  <span class="help-inline" id="errDistrito">Please correct the error</span>
								</div>
							</div>		
			               
                            <!-- <div class="control-group" id="dvTipo">
								<label class="control-label" for="rButton">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton" id="rButton" value="DNI" >
									DNI
								  </label>
								  <div style="clear:both">
								  <label class="radio">
									<input type="radio" name="rButton" id="rButton" value="Carnet de Extranjeria">
									Carnet de Extranjeria
								  </label>
								   <span class="help-inline" id="errTipo">Please correct the error</span>
								  </div>
								</div>
							  </div> -->
							  <div class="control-group" id="dvTipoDocumento">
								<label class="control-label" for="cmbTipoDocumento">Tipo de Documento (*):</label>
								<div class="controls">
								  <select name="cmbTipoDocumento" id="cmbTipoDocumento" name="cmbTipoDocumento"  data-rel="chosen">
									<option>DNI</option>
									<option>Carnet de extranjeria</option>
									</select>
								</div>
							</div>
							  
						   
		                          <div class="control-group" id="dvNumeroDocumento">
			                          <label class="control-label" for="typeahead6">N&uacute;mero de Documento(*): </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtNumeroDocumento" name="txtNumeroDocumento" data-provide="typeahead" onpaste="return false;" >
		                                <span class="help-inline" id="errNumeroDocumento">Please correct the error</span>
		                              </div>
		                      	</div>
		                     
			                        <div class="control-group" id="dvCorreoE">
			                          <label class="control-label" for="typeahead7">Correo Electr&oacute;nico(*): </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtCorreoElectronico" name="txtCorreoElectronico"  data-provide="typeahead" maxlength="50" onpaste="return false;">
		                                 <span class="help-inline" id="errCorreoE">Please correct the error</span>
		                              </div>
		                            </div>
		                            
			                       
		                            
		                             <div class="control-group" id="dvTelefonoFijo">
			                        <label class="control-label" for="typeahead9">Tel&eacute;fono Fijo(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoFijo"  name="txtTelefonoFijo" data-provide="txtTelefonoFijo" data-items="4" maxlength="7" onpaste="return false;" >
		                            <span class="help-inline" id="errTelefonoFijo">Please correct the error</span>
									</div>
		                            </div>
		                            
		                            <div class="control-group" id="dvCelular">
		                             <label class="control-label" for="typeahead10">Tel&eacute;fono Celular(*): </label>
			                        
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoCelular" name="txtTelefonoCelular" data-provide="txtTelefonoCelular" data-items="4" maxlength="9" onpaste="return false;">
		                            <span class="help-inline" id="errCelular">Please correct the error</span>
									</div>
		                            </div>
		                            
		                          
		                        <div class="form-actions">
		                        <input type="hidden" name="idSolicitud" value=""/></input>
			                      <button  type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>      
			               		   <button  type="button"  class="btn" onclick="location.href='../socio/buscarsocio.jsp'">Cancelar</button>  
		                        </div>
		                      </fieldset>
		                    </form>
                            (*) Campos Obligatorios
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
