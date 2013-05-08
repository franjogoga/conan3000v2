<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoPromocionBeanData"%>
<%@page import="java.util.Vector"%>

<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>


<!-- content starts -->

			  <div>		       
		        <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Buscar Promoci&oacute;n</li>
	          </ul>
		      </div>
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>BUSCAR PROMOCION</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVPromocion")%>">
			         <input type="hidden" name="accion" value="Buscar"/></input>
			          <fieldset>
			          
			            <div class="control-group">
			              <div class="control-group">
			                <div class="control-group">
			                  <label class="control-label" for="typeahead2">Nombre Promoci&oacute;n:</label>
			                  <div class="controls">
			                    <input type="text" class="span6 typeahead" id="txtNombrePromocion"  name="txtNombrePromocion" data-provide="typeahead" >
		                      </div>
		                    </div>
		                     
			                <label class="control-label" for="date01">Fecha de inicio:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="fFechInicio" name="fFechInicio" value="16/02">
			                  
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin:</label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge datepicker" id="fFechFin" name="fFechFin" value="16/04" >
		                    </div>
		                  </div>
			          
			              
								<div class="control-group">
								<label class="control-label" for="typeahead3">Estado</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Inactivo
								  </label>
								</div>
							  </div>
			            </div>
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="submit" class="btn"><a href="buscarpromocion.jsp">Cancelar</a></button>
		                </div>
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		     
		      <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVPromocion")%>">
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
					        <th>Nombre</th>
					        <th>Fecha de incio</th>
					        <th>Fecha de fin</th>
					        <th>Estado</th>
					        <th>Acci&oacute;n</th>
				          </tr>
				          
				        </thead>
				        
				        <element>
					    <tbody id="resultadobusqueda">
					    
					    <%SimpleDateFormat df= new SimpleDateFormat("dd/MM"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
                         
					      <tr>
					        
					        <td class="center">
                          				<%=
                          					((ResultadoPromocionBeanData)resultados.get(i)).getNombre()
                          				%>
                          </td>
                          
                          
					        
					       <td class="center">
                          				<%=
                          					df.format(((ResultadoPromocionBeanData)resultados.get(i)).getLimInicio())
                          				%>
                          </td>
                          
                           <td class="center">
                          				<%=
                          					df.format(((ResultadoPromocionBeanData)resultados.get(i)).getLimFin())
                          				%>
                          </td>
                          
                          <td class="center">
                          				<%=
                          					((ResultadoPromocionBeanData)resultados.get(i)).getEstado()
                          				%>
                          </td>
                          
                          <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
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
		
			 <!-- jQuery -->
    <script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
	
	<script src="js/ajaxsbmt.js"></script>

		  
<!-- content ends -->