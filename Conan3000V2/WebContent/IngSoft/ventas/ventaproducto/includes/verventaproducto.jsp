	 <script>
	function alt_submit(){
		var form= document.frmVer;
		
			}	

	 </script>

			<!-- content starts -->
			
	<jsp:useBean id="producto" scope="request"class="IngSoft.venta.bean.VentaBeanData"></jsp:useBean>	
			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home /<a href="buscarproducto.jsp"> Mantenimiento de Venta Productos /</a> Ver Producto</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>VER PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal"  name="frmVer " action="<%= response.encodeURL("SMVVentaProductos")%>" method="post">
					
					<input type="hidden" name="codigo" value="<%=producto.getIdVenta()%>"></input>
			        <input type="hidden" name="accion" value="Consultar"></input>
					<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Codigo Vendedor: </label>
						      <div class="controls">
						        <input type="text" value="<%=producto.getIdEmpleado()%>" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" disabled="" > 
					          </div>
					        </div>
						    
							   <div class="control-group">
							  
							  <div class="control-group">
			                <label class="control-label" for="textarea2">Estado:</label>
			                <div class="controls">
			                  <textarea name="textarea" disabled class="" id="textarea" style="resize:none"><%=producto.getEstado()%></textarea>
		                    </div>
		                  </div>
						      
						      <div class="control-group">

							    <label class="control-label" for="typeahead14">Socio: </label>
							    <div class="controls">
							      <input type="text" disabled class="span6 typeahead" value="<%=producto.getIdSocio()%>"id="typeahead14" data-provide="typeahead" data-items="4"/>
						        </div>
						      </div>
						      
							
						    </div>
						    <div class="form-actions">
							 
			               <a  name="btnCancelar" class="btn btn-primary" href="buscarventaproducto.jsp">Regresar</a>  
			           
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