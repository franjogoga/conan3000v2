function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar este producto?");
		if(r==true){form.submit();}
			}	

		
		
		
			<!-- content starts -->
				<jsp:useBean id="producto" scope="request"class="IngSoft.venta.bean.ProductoBeanData"></jsp:useBean>	

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Productos /</a> Eliminar Producto</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>ELIMINAR PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal"  name="frmProducto" method="Post"  action="SMVProducto">
					
					<input type="hidden" name="codigo" value="<%=producto.getIdProdProveedor()%>"></input>
			        <input type="hidden" name="accion" value="Eliminar"></input>
					<input type="hidden" name="tipo" value="2"></input>
						
						  <fieldset>
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre: </label>
						      <div class="controls">
						        <input type="text" value="<%=producto.getNombre()%>" name="txtNombre" class="span6 typeahead" id="typeahead7"  data-provide="typeahead" disabled="" > 
					          </div>
					        </div>
						    
							   <div class="control-group">
							  
							  <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="textarea" class="" id="txtDescripcion" name="txtDescripcion" ><%=producto.getDescripcion()%></textarea>
		                    </div>
		                  </div>
						      
						      <div class="control-group">

							    <label class="control-label" for="typeahead14">Presentación: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" value="<%=producto.getPresentacion()%>"  id="txtPresentacion" name="txtPresentacion" data-provide="typeahead" data-items="4"/>
						        </div>
						      </div>
						      
							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Precio Unitario(S/.): </label>
							    <div class="controls">
							      <input type="text" value="4.00" class="span6 typeahead" id="PrecioU" name="PrecioU" value="<%=producto.getPrecioU() %>" data-provide="typeahead" data-items="4" disabled="">
						        </div>
						      </div>
							  <div class="control-group">
							    <div class="control-group">
							      <label class="control-label" for="selectError2">Proveedor:</label>
							      <div class="controls">
							       <input type="text" value="<%=producto.getIdProveedor() %>" class="span6 typeahead" id="typeahead10"  data-provide="typeahead" data-items="4" disabled="">
						          </div>
						        </div>
							    <div class="controls"></div>
						      </div>
						    </div>
						    <div class="form-actions">
							  <button type="submit" class="btn btn-primary" onclick="javascript:alt_submit()">Eliminar</button>
			              <button type="reset" class="btn" onclick="location.href='buscarproducto.jsp'">Cancelar</button>
			           
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
