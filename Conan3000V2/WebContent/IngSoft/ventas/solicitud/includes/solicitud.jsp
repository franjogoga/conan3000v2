


<script>
function alt_submit(){
		var form= document.frmSolicitud;
		if(1) form.submit();		
}
</script>


<!-- content starts -->
			 	  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li>Solicitud </li>
		       
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-plus-sign"></i> SOLICITUDES </h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmSolicitud" method="Post"  action="SMVSolicitud">
			        <input type="hidden" name="accion" value="Agregar"></input>
			        
			          <fieldset>
			              <div class="control-group">
			                <label class="control-label" for="selectError">Tipo de Solicitud(*):</label>
			                <div class="controls">
			                  <select name="cmbTiposolicitud" id="cmbTiposolicitud" data-rel="chosen">
			                    <option selected>Productos</option>
			                    <option>Socio</option>
			                     <option>Servicio de proveedores</option>
		                      </select>
		                    </div>
		                  </div>
                      
			                <div class="control-group">
							  <div class="controls">
								<button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Aceptar</button>
                                <button type="button" class="btn">Cancelar</button>
							  </div>
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
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
<!-- content ends -->
