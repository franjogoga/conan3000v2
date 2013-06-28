 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoOrdenPagoBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.GregorianCalendar"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AgregarCuotaExtraordinaria";
		form.submit();
	}
	
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="ConsultarOrdenPago";
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
	function alt_Pagar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AgregarOrdenPago";
		form.codigo.value=cod;
		form.submit();
	}
	
	function ocultar(id){
		document.getElementById(id).style.display='none';
		
	}
	function mostrar(id){
		document.getElementById(id).style.display='block';
		
	}
	
	function verificar(){
		
		var total,valor;
		total=document.getElementsByName('rButton').length;
		 
		for (var i=0;i<total;i++){
		valor=document.getElementsByName('rButton').item(i).checked;
		 
		if (valor){
			nom=document.getElementsByName('rButton').item(i).value;
			if(nom=='Cancelado'){
				ocultar("fechaEmision");
				mostrar("fechaPago");
				
			}else{
				ocultar("fechaPago");
				mostrar("fechaEmision");
				
			}
		}
		 
		 
		}
		
	}
	
	
	
	function igualarIni(tipo){
		if(tipo==2)
		document.frmCriteriosBusqueda.fFechaPagoIni.value=document.frmCriteriosBusqueda.fFechaEmisionIni.value;
		else
		document.frmCriteriosBusqueda.fFechaEmisionIni.value=document.frmCriteriosBusqueda.fFechaPagoIni.value;
	}
	
	function igualarFin(tipo){
		if(tipo==2)
		document.frmCriteriosBusqueda.fFechaPagoFin.value=document.frmCriteriosBusqueda.fFechaEmisionFin.value;
		else
		document.frmCriteriosBusqueda.fFechaEmisionFin.value=document.frmCriteriosBusqueda.fFechaPagoFin.value;
	}
	
	
	
	
	
	</script>	
<%

SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecHoy=dfActual.format(new java.util.Date());

 %>
<!--The beans  -->

<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

<!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpagootros.jsp">Pago de Otros Servicios</a> <span class="divider">/</span></li>
		        <li> Busqueda de Ordenes de Pago </li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR ORDENES DE PAGO</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVPago")%>">
		            <input type="hidden" name="accion" value="BuscarOrdenPago"/></input>
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">C&oacute;digo de socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtCodigoSocio" name="txtCodigoSocio" >
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="typeahead" id="txtSocio" name="txtSocio">
	                    </div>
	                  </div>
		               <div class="control-group">
			              <label class="control-label" for="typeahead7">Concepto: </label>
			              <div class="controls">
			            	
								  <select id="cmbConcepto" name="cmbConcepto" data-rel="chosen">
								  <option value="ALL">Todos</option>
								  <option value="CUOTAEXTRAORDINARIA">Cuota Extraordinaria</option>
									<option value="SOLICITUDPRODUCTO">Solicitud de Producto</option>
									<option value="SOLICITUDSERVICIO">Solicitud de Servicio</option>
									<option value="EVENTOCORPORATIVO">Evento Corporativo</option>
									<option value="EVENTOCORPORATIVOXSERVICIOADICIONAL">Servicio Adicional (Evento Corporativo)</option>
									<option value="RESERVABUNGALOWXSERVICIOADICIONAL">Servicio Adicional (Reserva de Bungalow)</option>
									<option value="BUNGALOWXSORTEO">Sorteo de Bungalow</option>
									<option value="EVENTOSOCIO">Evento de Socio</option>
									<option value="RESERVACANCHA">Reserva de Cancha</option>
									<option value="RESERVABUNGALOW">Reserva de Bungalow</option>
									<option value="ACTIVIDADSOCIO">Actividad de Socio</option>
									<option value="ACTIVIDADFAMILIAR">Actividad Familiar</option>
									<option value="SUSPENSIONFALTA">Suspension por Infraccion</option>
									<option value="SOCIOXEVENTOSEDE">Socio por Evento Sede</option>
									<option value="INVITADOXSOCIO">Invitado de Socio</option>
									<option value="TRASLADOMEMBRESIA">Traslado de Membresia</option>
									
								  </select>
								</div>
		                </div>
		              <div class="control-group" id="fechaEmision">
		                <label class="control-label" for="typeahead2">Fecha de Emisi&oacute;n: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker" id="fFechaEmisionIni" name="fFechaEmisionIni" value="<%=fecHoy%>" onChange="javascript:igualarIni(2)" onpaste="return false;"  > 
		                  - <input type="text" class="input-xlarge datepicker" id="fFechaEmisionFin" name="fFechaEmisionFin" value="<%=fecHoy%>" onChange="javascript:igualarFin(2)" onpaste="return false;" >
	                    </div>
	                  </div>
	                  
	                  <div class="control-group" id="fechaPago">
		                <label class="control-label" for="typeahead2">Fecha de Pago: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker"  id="fFechaPagoIni" name="fFechaPagoIni" value="<%=fecHoy%>" onChange="javascript:igualarIni(1)" onpaste="return false;" >
		                   - <input type="text" class="input-xlarge datepicker"  id="fFechaPagoFin" name="fFechaPagoFin" value="<%=fecHoy%>" onChange="javascript:igualarFin(1)" onpaste="return false;" >
	                    </div>
	                  </div>
	                  
	                  <div class="control-group">
		                <label class="control-label" for="selectError2">Estado</label>
		                <div class="controls">
		                  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="Cancelado" checked="checked" onChange="verificar()">
									Cancelado
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="No Cancelado" onChange="verificar()">
									No Cancelado
							</label>
	                    </div>
	                  </div>
	                  
		              <div class="form-actions">
		                <button type="submit" class="btn btn-primary">Buscar</button>
	                  </div>
	                </fieldset>
	              </form>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    
		    <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVPago")%>">
			  <input type="hidden" name="accion" value="AgregarCuotaExtraordinaria"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
			  
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS DE BUSQUEDA DE OTROS SERVICIOS</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		           <!-- agregar nuevo boton -->
		           <div align="right"><a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar Cuota Extraordinaria </a></div> 
		           <thead>
		              <tr>
		                <th>C&oacute;digo de Socio</th>
		                <th>Socio</th>
		                <th>Concepto</th>
		                <th>Fecha de Pago</th>
		                <th>Monto</th>
		                <th>Estado</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		            
		               <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY");
		             
		             
                          			for(int i=0;
                          			i<resultados.size();i++){
                          				
                          				String concepto=null;
                          				String dato=((ResultadoOrdenPagoBeanData)resultados.get(i)).getConcepto();
                          				
                          				if(dato.equals("SOLICITUDPRODUCTO")) concepto="Solicitud de Producto";
                          				if(dato.equals("SOLICITUDSERVICIO")) concepto="Solicitud de Servicio";
                          				if(dato.equals("EVENTOCORPORATIVO")) concepto="Evento Corporativo";
                          				if(dato.equals("EVENTOCORPORATIVOXSERVICIOADICIONAL"))  concepto="Servicio Adicional (Evento Corporativo)";
                          				if(dato.equals("RESERVABUNGALOWXSERVICIOADICIONAL")) concepto="Servicio Adicional (Reserva de Bungalow)";
                          				if(dato.equals("BUNGALOWXSORTEO")) concepto="Sorteo de Bungalow";
                          				if(dato.equals("EVENTOSOCIO")) concepto="Evento de Socio";
                          				if(dato.equals("RESERVACANCHA")) concepto="Reserva de Cancha";
                          				if(dato.equals("RESERVABUNGALOW")) concepto="Reserva de Bungalow";
                          				if(dato.equals("ACTIVIDADSOCIO")) concepto="Actividad de Socio";
                          				if(dato.equals("ACTIVIDADFAMILIAR")) concepto="Actividad Familiar";
                          				if(dato.equals("SUSPENSIONFALTA")) concepto="Suspension por Infraccion";
                          				if(dato.equals("SOCIOXEVENTOSEDE")) concepto="Socio por Evento Sede";
                          				if(dato.equals("INVITADOXSOCIO")) concepto="Invitado de Socio";
                          				if(dato.equals("TRASLADOMEMBRESIA")) concepto="Traslado de Membresia";
                          				if(dato.equals("CUOTAEXTRAORDINARIA")) concepto="Cuota Extraordinaria";
                          				
                          				
                          				
                          				
                          				
                          				
                         %>
		              <tr>
		                <td><%=((ResultadoOrdenPagoBeanData)resultados.get(i)).getIdSocio()%></td>
		                <td class="center"><%=((ResultadoOrdenPagoBeanData)resultados.get(i)).getSocio()%></td>
		                <td class="center"><%=concepto%></td>
		                <td class="center"><%=
                         df.format(((ResultadoOrdenPagoBeanData)resultados.get(i)).getFechaEmision())
                          %></td>
		               
		                <td class="center"><%=((ResultadoOrdenPagoBeanData)resultados.get(i)).getMonto()%></td>
		                
		                
		                <td class="center"><span class="label label-success">
		                <%=
                         ((ResultadoOrdenPagoBeanData)resultados.get(i)).getEstado()
                        %></span></td>
		                <td class="center">
		                   
		                <a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoOrdenPagoBeanData)resultados.get(i)).getIdOtroIngreso()%>')">
                          					 <i class="icon-zoom-in icon-white"></i> Ver </a> 
                        <% if(((ResultadoOrdenPagoBeanData)resultados.get(i)).getEstado().equals("Cancelado")){ %>
		                
                        <% }else{ %>
                        <a class="btn btn-primary"
                          					href="javascript:alt_Pagar('<%=((ResultadoOrdenPagoBeanData)resultados.get(i)).getIdOtroIngreso()%>')">
                          					 <i class="icon-share icon-white"></i> Pagar </a>
                        <% } %>
                        
						</td>
	                  </tr>
	                  
	                  <%}%>
		             
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
		    <script>verificar();</script>