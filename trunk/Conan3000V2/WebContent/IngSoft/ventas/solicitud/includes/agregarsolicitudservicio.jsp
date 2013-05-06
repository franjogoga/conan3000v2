			  <!-- content starts -->
			    <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		       <li>Agregar Servicio</li>
	          </ul>
		      </div>  
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>SOLICITUD DE SERVICIO</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal">
			          <fieldset>
			          
			           <div class="control-group">
			                <label class="control-label" for="typeahead9">Nombre(*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead9"  data-provide="typeahead" data-items="4" >
			                  <p class="help-block">Escriba sobre la casilla un nombre de servicio para ser autocompletado</p>
		                    </div>
		                  </div>
			         			         
						<div class="control-group">
			                <label class="control-label" for="typeahead4">Precio(*):</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
		                          			          
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary">Agregar</button>
			             <a href="solicitud.jsp"> <button type="reset" class="btn">Cancelar</button></a>
		                </div>
		              </fieldset>
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
			        <h2>SERVICIOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					   
					    <thead>
					      <tr>
					        <th>Nombre</th>
					        <th>Fecha</th>
					        <th>Precio</th>
					         <th>Acci&oacute;n</th>
					        
				          </tr>
				        </thead>
					    <tbody>
					      <tr>
					        <td>         </td>
					          <th class="center">Total:</th>
					           
					          <th class="center">3000.00</th>
					        
					        <td class="center" >   </td>
					        
				      		</tr>
				       </tbody>
				            <tbody>
					      <tr>
					        <td class="center">Limpieza</td>
					        <td class="center">16/06/13</td>
					          <td class="center">1000.00</td>
					            <td class="center" > <a class="btn btn-info" href="modificarsolicitudservicio.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudservicio.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
	  
				          </tr>
                               
				       </tbody>	
				       
					    <tbody>
					      <tr>
					        <td>Seguridad</td>
					        <td class="center">16/06/13</td>
					          <td class="center">2000.00</td>
					          
					     	  
					        <td class="center" > <a class="btn btn-info" href="modificarsolicitudservicio.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudservicio.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
				          </tr>
				        </tbody>
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
