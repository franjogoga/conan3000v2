			 
<script>	
function alt_submit(){
		var form= document.frmFamiliar;
		if(1) form.submit();
			
}
		 
function anhadir(cod,name){
	var form=document.frmServicio;
	form.idServicio.value=cod;
	form.txtServicio.value=name;
	$.fn.colorbox.close();
}
</script>			 
			 
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
			        <form class="form-horizontal" name="frmServicio"  method="Post"  action="SMVProducto">
			        <input type="hidden" name="accion" value="Agregar"></input>
			 		<input type="hidden" name="codigo" value=""></input>
			 		<input type="hidden" name="tipo" value="1"></input>
			        
			        
			          <fieldset>
			          
			           <div class="control-group">
			                <label class="control-label" for="typeahead9">Servicio(*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtServicio"  name="txtServicio" data-provide="typeahead" data-items="4" >
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../servicioproveedor/seleccionarservicio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Servicio</a> </div>
		                    </div>
		                  </div>
			         			         
						<div class="control-group">
			                <label class="control-label" for="typeahead4">Precio(*):</label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
		                          			          
			            <div class="form-actions">
			              <input type="hidden" name="idServicio" value=""/></input>
			              <button type="submit" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
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
