		   
		   <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoProveedorBeanData"%>
<%@page import="java.util.Vector"%>

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
	function alt_trasladar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Trasladar";
		form.codigo.value=cod;
		form.submit();
	}
	
	
	</script>	




<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>


		    <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarproveedor.jsp">Mantenimiento de Proveedores</a> <span class="divider">/</span></li>
		        <li> Busqueda de Proveedores </li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		        
		         <h2><i class="icon-search"></i>BUSCAR PROVEEDOR</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVProveedor")%>">
			         <input type="hidden" name="accion" value="Buscar"/></input>
			          <fieldset>
			          
			            <div class="control-group">
			              <div class="control-group">
			                <div class="control-group">
			                  <label class="control-label" for="typeahead2">Raz&oacute;n Social:</label>
			                  <div class="controls">
			                    <input type="text" class="span6 typeahead" id="txtRazon"  name="txtRazon" data-provide="typeahead" >
		                      </div>
		                    </div>
		                     
			              <div class="control-group">
			                  <label class="control-label" for="typeahead2">Ruc:</label>
			                  <div class="controls">
			                    <input type="text" class="span6 typeahead" id="txtRuc"  name="txtRuc" data-provide="typeahead" >
		                      </div>
		                    </div>      
		                  </div>
			            </div>
			            
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="submit" class="btn"><a href="buscarproveedor.jsp">Cancelar</a></button>
		                </div>
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		     
		      <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVProveedor")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
		      
		      
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>RESULTADOS</h2>
		          </div>
		          
			      <div class="box-content">
			      <table class="table table-striped table-bordered bootstrap-datatable datatable" >
					    <!-- agregar nuevo boton -->
					    <div  align="right">
					     <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a> 
					     </div>
					     
					    <thead>
					      <tr>
					        <th>Raz&oacute;n Social</th>
					        <th>Ruc</th>
					        <th>Contacto</th>
					        <th>Direccion</th>
					         <th>Correo</th>
					        <th>Acci&oacute;n</th>
				          </tr>
				          
				        </thead>
				        
				        <element>
					    <tbody id="resultadobusqueda">
					    
					    <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
                         
					      <tr>
					        
					        <td class="center">
                          				<%=
                          					((ResultadoProveedorBeanData)resultados.get(i)).getRazonSocial()
                          				%>
                          </td>
                          
                          
					        
					       <td class="center">
                          				<%=
                          					df.format(((ResultadoProveedorBeanData)resultados.get(i)).getRuc())
                          				%>
                          </td>
                          
                           <td class="center">
                          				<%=
                          					df.format(((ResultadoProveedorBeanData)resultados.get(i)).getContacto())
                          				%>
                          </td>
                          
                      <td class="center">
                          				<%=
                          					df.format(((ResultadoProveedorBeanData)resultados.get(i)).getDireccion())
                          				%>
                          </td>
                            <td class="center">
                          				<%=
                          					df.format(((ResultadoProveedorBeanData)resultados.get(i)).getCorreo())
                          				%>
                          </td>
                          
                          <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoProveedorBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoProveedorBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoProveedorBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          	</tr>
                          	
					        <%}%>
					       </tbody>
					       </element>
					       </table>     
                  </div>
				</div><!--/span-->
				
				
			</div><!--/row-->
			
    
					<!-- content ends -->
				</div><!--/fluid-row-->
						
		<hr>
			

		<jsp:include page="/IngSoft/general/inferior.jsp" />
		
			

		  
<!-- content ends -->
		         