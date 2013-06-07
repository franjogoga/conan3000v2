	 <script>
	function alt_submit(){
		var form= document.frmVer;
		
			}	

	 </script>

			<!-- content starts -->
			
	<jsp:useBean id="producto" scope="request"class="IngSoft.venta.bean.ProductoBeanData"></jsp:useBean>	
			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home /<a href="buscarproducto.jsp"> Mantenimiento de Productos /</a> Ver Producto</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>VER PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal"  name="frmVer " action="<%= response.encodeURL("SMVProducto")%>" method="post">
					
					<input type="hidden" name="codigo" value="<%=producto.getIdProdProveedor()%>"></input>
			        <input type="hidden" name="accion" value="Consultar"></input>
					<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre: </label>
						      <div class="controls">
						        <input type="text" value="<%=producto.getNombre()%>" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" disabled="" > 
					          </div>
					        </div>
						    
							   <div class="control-group">
							  
							  <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="textarea" disabled class="" id="textarea" ><%=producto.getDescripcion()%></textarea>
		                    </div>
		                  </div>
						      
						      <div class="control-group">

							    <label class="control-label" for="typeahead14">Presentación: </label>
							    <div class="controls">
							      <input type="text" disabled class="span6 typeahead" value="<%=producto.getPresentacion()%>"id="typeahead14" data-provide="typeahead" data-items="4"/>
						        </div>
						      </div>
						      
							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Precio Unitario(S/.): </label>
							    <div class="controls">
							      <input type="text" value="<%=producto.getPrecioU()%>" disabled class="span6 typeahead" id="typeahead10"  data-provide="typeahead" data-items="4" disabled="">
						        </div>
						      </div>
							  <div class="control-group">
							    <div class="control-group">
							      <label class="control-label" for="selectError2">Proveedor:</label>
							      <div class="controls">
							       <input type="text" value="<%=producto.getIdProveedor()%>" disabled class="span6 typeahead" id="typeahead10"  data-provide="typeahead" data-items="4" disabled="">
						          </div>
						        </div>
							    <div class="controls"></div>
						      </div>
						    </div>
						    <div class="form-actions">
							 
			               <a  name="btnCancelar" class="btn btn-primary" href="buscarproducto.jsp">Regresar</a>  
			           
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->