			  <!-- content starts -->
			 
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		        <li>Agregar Producto</li>
	          </ul>
		      </div>  
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>SOLICITUD DE PRODUCTO</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal">
			          <fieldset>
			          
			           <div class="control-group">
			                <label class="control-label" for="typeahead9">Nombre(*): </label>
			                <div class="controls">
			                  <input type="text" name="txtNombre" class="span6 typeahead" id="typeahead9"  data-provide="typeahead" data-items="4" >
			                  <p class="help-block">Escriba sobre la casilla un nombre de producto para ser autocompletado</p>
		                    </div>
		                  </div>
			         			         
			            <div class="control-group">
			                <label class="control-label" for="typeahead4">Cantidad(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtCantidad" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
		               		              			          
			            <div class="form-actions">
			              <button name="btnAgregar" type="submit" class="btn btn-primary">Agregar</button>
			              <button name="btnCancelar" type="reset" class="btn"><a href="solicitud.jsp">Cancelar</a></button>
		                </div>
		              </fieldset>
		               (*) Campos Obligatorios</div>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>PRODUCTOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					   
					    <thead>
					      <tr>
					        <th>Nombre</th>
					        <th>Precio Unitario</th>
					        <th>Cantidad</th>
					        <th>Fecha</th>
					        <th>Monto</th>
					         <th>Acci&oacute;n</th>
					        
				          </tr>
				        </thead>
				        
				            <tbody>
					      <tr>
					        <td></td>
					          <td ></td>
					            <td ></td>
					          <td class="center"><b>Total</b></td>
					        <td class="center"><b>600.00</b></td>
					     
					   
                        					
                        
					        <td > </td>
				          </tr>
                               
				       </tbody>	 
				        
					    <tbody>
					      <tr>
					        <td>Gaseosa Coca-Cola</td>
					          <td class="center">2.00</td>
					            <td class="center">100</td>
					          <td class="center">16/06/13</td>
					        <td class="center">200.00</td>
					   
                        					
                        
					        <td class="center"> <a class="btn btn-info" href="modificarsolicitudproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
				         
				       </tbody>
				       
					          
		               <tbody>
					      <tr>
					         <td>Galleta</td>
					          <td class="center">2.00</td>
					            <td class="center">100</td>
					          <td class="center">16/06/13</td>
					        <td class="center">400.00</td> 
					     		 <td class="center"> <a class="btn btn-info" href="modificarsolicitudproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>			       
				          </tr>
                         
				        </tbody>
		                
				      </table>
				      
				        </tbody>
				        
				      
				         
                 
                  <div class="form-actions">
                 
			              <button  name="btnFinalizar" type="submit" class="btn btn-primary">Finalizar</button>
			            
		                </div>
			           
		        </div>
		      </div>
              
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 
	  
       
					<!-- content ends -->
