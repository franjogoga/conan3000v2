<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script>

function alt_submit(){
		var form= document.frmSolicitud;
		if(validaForm()) form.submit();
			
}

</script>	

<%
Calendar c1 = GregorianCalendar.getInstance();
Calendar c2 = GregorianCalendar.getInstance();
c1.add(Calendar.YEAR, 1);
c2.add(Calendar.YEAR, -18);
SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecAnoIni=dfActual.format(c2.getTime());

String fecAnoFin=dfActual.format(new java.util.Date()); %>		 
			 
			  <!-- content starts -->
			<%@page import="IngSoft.venta.bean.DistritoMiniBeanData"%>
<jsp:useBean id="tiposDistrito" scope="request"class="java.util.Vector"></jsp:useBean>
			  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		       <li>Agregar Socio</li>
	          </ul>
		      </div>  
			
		              <div class="row-fluid sortable">
			            <div class="box span12">
			              <div class="box-header well" data-original-title>
			                <h2>AGREGAR SOLICITUD DE SOCIO </h2>
		                  </div>
			              <div class="box-content">
                          
			                <form class="form-horizontal" id="frmSolicitud" name="frmSolicitud" method="POST" action="SMVSolicitudSocio">
			                <input type="hidden" name="accion" value="Agregar"></input>
							<input type="hidden" name="tipo" value="2"></input>
							
			                  <fieldset>
			                    <div class="control-group" id="dvNombres">
			                      <label class="control-label" for="typeahead7">Nombres(*): </label>
			                      <div class="controls">
			                        <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres" data-provide="typeahead" onpaste="return false;">
		                             <span class="help-inline" id="errNombres">Please correct the error</span>
		                          </div>
		                        </div>
			                   
			                      <div class="control-group" id="dvApellidoP">
			                        <label class="control-label" for="typeahead6">Apellido Paterno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoP" name="txtApellidoP" data-provide="typeahead" data-items="4" onpaste="return false;" >
		                               <span class="help-inline" id="errApellidoP">Please correct the error</span>
		                            </div>
		                          </div>
		                          
			                      <div class="control-group" id="dvApellidoM">
			                        <label class="control-label" for="typeahead10">Apellido Materno(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtApellidoM" name="txtApellidoM" data-provide="typeahead" data-items="4" onpaste="return false;" >
		                               <span class="help-inline" id="errApellidoM">Please correct the error</span>
		                            </div>
		                          </div>
                                  
                                
                                <div class="control-group" id="dvFechaN">
			              		<label class="control-label" for="typeahead17">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaN" name="fFechaN" value="<%=fecAnoIni%>" readonly="readonly">
			             		  <span class="help-inline" id="errFechaN">Please correct the error</span>
			             		</div>
		                		</div>
		                		
                     		   <div class="control-group" id="dvFechaR">
			              		<label class="control-label" for="typeahead21">Fecha Registro(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaR" name="fFechaR" value="<%=fecAnoFin%>" readonly="readonly">
			             		  <span class="help-inline" id="errFechaR">Please correct the error</span>
			             		</div>
		                		</div>
		                		
		                		<div class="control-group">
								<label class="control-label" for="selectdistrito">Distrito (*):</label>
								<div class="controls">
								  <select name="cmdDistrito" id="cmdDistrito" data-rel="chosen">
									<%for(int i=0;i<tiposDistrito.size();i++){ %>
										<option value="<%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getIdDistrito()%>" <%=i==0?"selected":""%>><%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getNombreDistrito()%></option>
									<%} %>	
								  </select>
								</div>
							</div>
		                		
		                		 <div class="control-group" id="dvDireccion">
			                        <label class="control-label" for="typeahead10">Direccion(*): </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtDireccion" name="txtDireccion" data-provide="typeahead" data-items="4" onpaste="return false;">
		                              <span class="help-inline" id="errDireccion">Please correct the error</span>
		                            </div>
		                          </div>

		                             <div class="control-group" id="dvObservaciones">
			                		<label class="control-label" for="textarea2">Observaciones(*):</label>
			                		<div class="controls">
			                  		<textarea name="txtObservaciones" rows="3" class="" id="txtObservaciones"  style="resize:none" onpaste="return false;"></textarea>
		                    		 <span class="help-inline" id="errObservaciones">Please correct the error</span>
		                    		</div>
		                  			</div>
		                            
		                          
		                        <div class="form-actions">
			                      <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
			                      <button type="button" class="btn" onclick="location.href='../solicitud/buscarsolicitudsocio.jsp'">Cancelar</button>
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
