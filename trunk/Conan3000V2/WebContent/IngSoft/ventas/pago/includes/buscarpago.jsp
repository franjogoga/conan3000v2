 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoPagoBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.GregorianCalendar"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
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
		form.accion.value="Pagar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_Multas(cod){
	
	
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AplicarMultas";
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
		document.frmCriteriosBusqueda.fFechaPagoIni.value=document.frmCriteriosBusqueda.fFechaVencimientoIni.value;
		else
		document.frmCriteriosBusqueda.fFechaVencimientoIni.value=document.frmCriteriosBusqueda.fFechaPagoIni.value;
	}
	
	function igualarFin(tipo){
		if(tipo==2)
		document.frmCriteriosBusqueda.fFechaPagoFin.value=document.frmCriteriosBusqueda.fFechaVencimientoFin.value;
		else
		document.frmCriteriosBusqueda.fFechaVencimientoFin.value=document.frmCriteriosBusqueda.fFechaPagoFin.value;
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
		        <li> Busqueda de Pagos </li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR PAGOS DE MEMBRESIA</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVPago")%>">
		            <input type="hidden" name="accion" value="Buscar"/></input>
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">C&oacute;digo de socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtCodigoSocio" name="txtCodigoSocio">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Socio:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtSocio" name="txtSocio">
	                    </div>
	                  </div>
		              <div class="control-group" id="fechaEmision">
		                <label class="control-label" for="typeahead2">Fecha de Vencimiento: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker" id="fFechaVencimientoIni" name="fFechaVencimientoIni" value="<%=fecHoy%>" onChange="javascript:igualarIni(2)" onpaste="return false;" > 
		                  - <input type="text" class="input-xlarge datepicker" id="fFechaVencimientoFin" name="fFechaVencimientoFin" value="<%=fecHoy%>" onChange="javascript:igualarFin(2)" onpaste="return false;" >
	                    </div>
	                  </div>
	                  
	                  <div class="control-group" id="fechaPago">
		                <label class="control-label" for="typeahead2">Fecha de Pago: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker"  id="fFechaPagoIni" name="fFechaPagoIni" value="<%=fecHoy%>" onChange="javascript:igualarIni(1)"  onpaste="return false;" >
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
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
		    
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS DE BUSQUEDA DE PAGOS DE MEMBRESIA</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
					<div align="right"><a class="btn btn-primary iframe" href="multas2.jsp"> <i class="icon icon-add icon-white"></i> Aplicar Multas</a></div>
		            <thead>
		              <tr>
		                <th>C&oacute;digo de Socio</th>
		                <th>Socio</th>
		                <th>Num. de Cuota</th>
		                <th>Fecha de Vencimiento</th>
		                 <th>Monto</th>
		                 <th>Estado</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              
		              <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY");
		             
		             
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
		              <tr>
		                <td><%=((ResultadoPagoBeanData)resultados.get(i)).getIdSocio()%></td>
		                <td class="center"><%=((ResultadoPagoBeanData)resultados.get(i)).getSocio()%></td>
		                <td class="center"><%=((ResultadoPagoBeanData)resultados.get(i)).getNumCuota()%></td>
		                <td class="center"><%=
                         df.format(((ResultadoPagoBeanData)resultados.get(i)).getFechaVencimiento())
                          %></td>
		               
		                <td class="center"><%=((ResultadoPagoBeanData)resultados.get(i)).getMonto()%></td>
		                
		                
		                <td class="center"><span class="label label-<% if(((ResultadoPagoBeanData)resultados.get(i)).getEstadoCuota().equals("Cancelado")){ %>success<% }else{ if(((ResultadoPagoBeanData)resultados.get(i)).getEstadoCuota().equals("No Cancelado")){ %>warning<% }else{ %>important <% }} %>">
		                <%=
                         ((ResultadoPagoBeanData)resultados.get(i)).getEstadoCuota()
                        %></span></td>
                        
                         <td class="center">
		                
		                <a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoPagoBeanData)resultados.get(i)).getIdCuota()%>')">
                          					 <i class="icon-zoom-in icon-white"></i> Ver </a> 
                        <% if(((ResultadoPagoBeanData)resultados.get(i)).getEstadoCuota().equals("Cancelado")){ %>
		                
                        <% }else{ %>
                        <a class="btn btn-primary"
                          					href="javascript:alt_Pagar('<%=((ResultadoPagoBeanData)resultados.get(i)).getIdCuota()%>')">
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