 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoEgresoBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.GregorianCalendar"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AgregarEgreso";
		form.submit();
	}
	
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="ConsultarEgreso";
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
		        <li> Busqueda de Egresos </li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR EGRESOS</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVPago")%>">
		            <input type="hidden" name="accion" value="BuscarEgreso"/></input>
		            <fieldset>
		              
		              <div class="control-group">
		                <label class="control-label" for="selectError">Descripci&oacute;n:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtDescripcion" name="txtDescripcion">
	                    </div>
	                  </div>
		              
	                  <div class="control-group" id="fechaPago">
		                <label class="control-label" for="typeahead2">Fecha de Pago: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge datepicker"  id="fFechaPagoIni" name="fFechaPagoIni" value="<%=fecHoy%>"  onpaste="return false;" >
		                   - <input type="text" class="input-xlarge datepicker"  id="fFechaPagoFin" name="fFechaPagoFin" value="<%=fecHoy%>" onpaste="return false;" >
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
		          <h2><i class="icon-th-list"></i> RESULTADOS DE BUSQUEDA DE EGRESO</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		           <div align="right"><a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a></div> 
		            <thead>
		              <tr>
		                <th>C&oacute;digo</th>
		                <th>Descripcion</th>
		                <th>Fecha</th>
		                 <th>Monto</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		              
		              <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY");
		             
		             
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
		              <tr>
		                <td><%=((ResultadoEgresoBeanData)resultados.get(i)).getIdEgreso()%></td>
		                <td class="center"><%=((ResultadoEgresoBeanData)resultados.get(i)).getDescripcion()%></td>
		                <td class="center"><%=
                         df.format(((ResultadoEgresoBeanData)resultados.get(i)).getFechaPago())
                          %></td>
		               
		                <td class="center"><%=((ResultadoEgresoBeanData)resultados.get(i)).getMontoTotal()%></td>
		                
		                
                        
                         <td class="center">
		                
		                <a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoEgresoBeanData)resultados.get(i)).getIdEgreso()%>')">
                          					 <i class="icon-zoom-in icon-white"></i> Ver </a> 
                        
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