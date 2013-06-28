<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoFamiliarBeanData"%>
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
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li><a href="../familia/buscarfamiliar.jsp">Mantenimiento de Familiares</a> </li>
		        <li>/ Busqueda familiares</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>BUSCAR FAMILIAR</h2>
			      </div>
			      <div class="box-content">
			      
			        <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVFamiliar")%>">
			          <input type="hidden" name="accion" value="Buscar"/></input>
			          
			          <fieldset>
			          
		                <!-- <div class="control-group">
			                <label class="control-label" for="typeahead9">Socio:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead9"  data-provide="typeahead" data-items="4" >
	                      </div>
	                    </div> -->
		              
			              <div class="control-group">
			                <label class="control-label" for="typeahead6">Nombres:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres"  data-provide="typeahead" data-items="4" >
		                    </div>
	                    </div>
	                    
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Apellido Paterno:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Apellido Materno:</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                 
							  
			                <div class="form-actions">
			               <button type="submit" class="btn btn-primary" >Buscar</button>
			               <button type="button"  class="btn" onclick="location.href='../familia/buscarfamiliar.jsp'">Cancelar</button>  
			           
		                </div>
		              
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			  
			  <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVFamiliar")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
		      
			  
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-th-list"></i>RESULTADOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					    <!-- agregar nuevo boton -->
					    <div align="right"> <a class="btn btn-primary" href="agregarfamiliar.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
					    <thead>
					      <tr>
					        
					        <th>Nombres</th>
					        <th>Apellido Paterno</th>
					        <th>Apellido Materno</th>
					        <th>Parentesco</th>
					        <th>Numero de documento</th>
                            <th>Acción</th>
                            
                         
				          </tr>
				        </thead>
				           <element>
					    <tbody id="resultadobusqueda">
					    <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
				        
				        
					    <tbody>
					      <tr>
					        <td class="center">
                          				<%=
                          					((ResultadoFamiliarBeanData)resultados.get(i)).getNombres()
                          				%>
                          </td>
                     
                     	  <td class="center">
                          				<%=
                          					((ResultadoFamiliarBeanData)resultados.get(i)).getApellidoPaterno()
                          				%>
                          </td>
                          
                          <td class="center">
                          				<%=
                          					((ResultadoFamiliarBeanData)resultados.get(i)).getApellidoMaterno()
                          				%>
                          </td>
                          
                        <td class="center">
                          				<%=
                          					((ResultadoFamiliarBeanData)resultados.get(i)).getParentesco()
                          				%>
                          </td>
                          
                          <td class="center">
                          				<%=
                          					((ResultadoFamiliarBeanData)resultados.get(i)).getDni()
                          				%>
                          </td>
				          
				          <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoFamiliarBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoFamiliarBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoFamiliarBeanData)resultados.get(i)).getCodigo()%>')">
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
		        </div>
		      </div>
              
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
		
			<!-- content ends -->