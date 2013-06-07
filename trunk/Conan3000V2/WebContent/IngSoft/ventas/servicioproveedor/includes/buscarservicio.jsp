<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoServicioBeanData"%>
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
	</script>	



<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>		    
		    
		    <!-- content starts -->
		    <div>
				<ul class="breadcrumb">
				<li> <a href="#">Home / Mantenimiento de Servicios de Proveedores/ </a>Busqueda de Servicio</li>
				<li></li>
				</ul>
			</div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> BUSCAR SERVICIO</h2>
                    <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>

						</div>
                    
                        
                        
                    </div>
					<div class="box-content">
					
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVServicio")%>">
						  <input type="hidden" name="accion" value="Buscar"/></input>
						  <fieldset>
						  
	
							    
							    
							      <div class="control-group">
							        <label class="control-label" for="typeahead2">Nombre: </label>
							        <div class="controls">
							          <input type="text" class="span6 typeahead" id="txtNombre" name="txtNombre"  data-provide="typeahead" >
						            </div>
						          </div>
						          
						          <div class="control-group">
							      <label class="control-label" for="selectError2">Proveedor:</label>
							      <div class="controls">
							       <input type="text" class="span6 typeahead" id="txtProveedor" name="txtProveedor"  data-provide="typeahead" >
						          </div>
						        </div>

						    
						    <div class="form-actions">
					       <button  type="submit" class="btn btn-primary" href="">Buscar</button>  
			               <button type="submit" class="btn" href="buscarservicio.jsp">Cancelar</button>  
							
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    
		    <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVServicio")%>">
			 <input type="hidden" name="accion" value="Agregar"></input>
			 <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			 </form>
		    
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
		        <div class="box-content">
		          <table width="99%" class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> 
		            <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a> 
		            </div>
		            
		            <thead>
		              <tr>
		                <th>Nombre Servicio</th>   
		                <th>Precio</th>
		                <th>Estado</th>
		                <th>Nombre Proveedor</th>
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
                          					((ResultadoServicioBeanData)resultados.get(i)).getNombreServicio()
                          				%>
                     </td>
                     
                      <td class="center">
                          				<%=
                          					((ResultadoServicioBeanData)resultados.get(i)).getPrecio()
                          				%>
                     </td>
		              
		              <td class="center">
                          				<%=
                          					((ResultadoServicioBeanData)resultados.get(i)).getEstado()
                          				%>
                     </td>
		               
                     <td class="center">
                          				<%=
                          					((ResultadoServicioBeanData)resultados.get(i)).getNombreProveedor()
                          				%>
                     </td>
                     
                     <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoServicioBeanData)resultados.get(i)).getCodServicio()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoServicioBeanData)resultados.get(i)).getCodServicio()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoServicioBeanData)resultados.get(i)).getCodServicio()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
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
