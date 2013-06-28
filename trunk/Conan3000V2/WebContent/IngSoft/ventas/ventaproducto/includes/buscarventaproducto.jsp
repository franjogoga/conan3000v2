 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="IngSoft.venta.bean.*"%>




<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Registrar";
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
	
	
	
	</script>	

<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

	<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
	</noscript>

		    <!-- content starts -->
		    <div>

		    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li><a href="../ventaproducto/buscarventaproducto.jsp">Mantenimiento de Venta Productos</a> </li>
		        <li>/ Busqueda de Producto</li>
	          </ul>

			</div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR VENTA PRODUCTO</h2>
                   
                    </div>
					<div class="box-content" >
						
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVVentaProductos")%>">
						  <input type="hidden" name="accion" value="Buscar"/></input>
						  <fieldset>
						  
							  
					<div class="control-group" id="dvVenta">
		                <label class="control-label" for="typeahead">C&oacute;digo de Venta:</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead"   id="txtVenta" name="txtVenta" value="" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>
	                    </div>
	                  </div>
						        
						    
						    <div class="form-actions">
							 
			                <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="button" class="btn" onclick="location.href='../ventaproducto/buscarventaproducto.jsp'">Cancelar</a></button>
			           
			           
							
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div>
		      <!--/span-->
	        </div>
	         <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVVentaProductos")%>">
			  <input type="hidden" name="accion" value="Registrar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
	        
		    <!--/row-->
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
		        <div class="box-content">
		          <table width="99%" class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right">
		             <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Registrar </a> </div>
		            <thead>
		              <tr>
		                <th>Codigo de Venta</th>
		                <th>Fecha de Venta</th>
		                <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		           <tbody id="resultadoBusqueda">
		              <%
		              	SimpleDateFormat df= new SimpleDateFormat("dd/MM"); 
		                                       for(int i=0; 
		                                        i<resultados.size(); i++)
		                                       {
		              %>

							                		<tr>
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoVentaBeanData)resultados.get(i)).getIdVenta()
                          				%>
                          			</td>
                          			
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoVentaBeanData)resultados.get(i)).getFechaVenta()
                          				%>
                          			</td>
                          			
                          				                          			
                          			
                          			<td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoVentaBeanData)resultados.get(i)).getIdVenta()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          	
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoVentaBeanData)resultados.get(i)).getIdVenta()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          		</tr>


									<%
										}
									%>
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
