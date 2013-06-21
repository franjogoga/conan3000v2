 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoProductoBeanData"%>
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
		        <li><a href="../producto/buscarproducto.jsp">Mantenimiento de Productos</a> </li>
		        <li>/ Busqueda de Producto</li>
	          </ul>

			</div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR PRODUCTO</h2>
                   
                    </div>
					<div class="box-content" >
						
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVProducto")%>">
						  <input type="hidden" name="accion" value="Buscar"/></input>
						  <fieldset>
						  
							  
							      <div class="control-group">
							        <label class="control-label" for="typeahead2">Nombre: </label>
							        <div class="controls">
							          <input type="text" class="span6 typeahead" id="txtNombre" name="txtNombre"  data-provide="typeahead" >
						            </div>
						          </div>
						            <div class="control-group">
							      <label class="control-label" for="selectError2">Descripcion:</label>
							      <div class="controls">
							       <input type="text" class="span6 typeahead" id="txtDescripcion" name="txtDescripcion"  data-provide="typeahead" >
						          </div>
						          
						   
						          
						          
						          
						        </div>
						        
						               <div class="control-group">
								<label class="control-label" for="typeahead3">Estado</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="Activo" checked="checked">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Eliminado">
									Inactivo
								  </label>
								</div>
							  </div>
						        
						    
						    <div class="form-actions">
							 
			                <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="button" class="btn" onclick="location.href='../producto/buscarproducto.jsp'">Cancelar</a></button>
			           
			           
							
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div>
		      <!--/span-->
	        </div>
	         <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVProducto")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
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
		             <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th>Nombre</th>
		                <th>Descripcion</th>
		                <th>Precio Unitario</th>
		                <th>Presentacion</th>
		                 <th>Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody id="resultadobusqueda">
		             <%           
		             
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
                          <tr>
                          <td class="center">
		                <%=
		                ((ResultadoProductoBeanData)resultados.get(i)).getNombre()
                         %>
						</td>
						  <td class="center">
		                <%=
                         ((ResultadoProductoBeanData)resultados.get(i)).getDescripcion()
                        %></td>
                         <td class="center">
		                <%=
                         ((ResultadoProductoBeanData)resultados.get(i)).getPrecioU()
                        %></td>
                        
                         <td class="center">
		                <%=
                         ((ResultadoProductoBeanData)resultados.get(i)).getPresentacion()
                        %></td>
		                <td class="center">
		                <a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoProductoBeanData)resultados.get(i)).getIdProdProveedor()%>')">
                          					 <i class="icon-zoom-in icon-white"></i> Ver </a> 
		                <a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoProductoBeanData)resultados.get(i)).getIdProdProveedor()%>')">
                          					<i class="icon-edit icon-white"></i> Modificar </a>
                        <a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoProductoBeanData)resultados.get(i)).getIdProdProveedor()%>')">
                          					 <i class="icon-trash icon-white"></i> Eliminar </a>
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
