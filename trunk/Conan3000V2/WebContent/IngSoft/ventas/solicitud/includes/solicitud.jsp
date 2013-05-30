<script>
function cambiar(){
document.frmSolicitud.action=document.frmSolicitud.cmbTiposolicitud.value;
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
			        <form class="form-horizontal" name="frmSolicitud" id="frmSolicitud" method="POST" action="agregarsolicitudproducto.jsp">
			          <fieldset>
			                 <div class="control-group">
			                <label class="control-label" for="selectError">Tipo de Solicitud(*):</label>
			                <div class="controls">
			                  <select name="cmbTiposolicitud" id="selectError" data-rel="chosen" onChange="javascript:cambiar();">
			                    <option value="agregarsolicitudproducto.jsp" selected>Productos</option>
			                    <option value="agregarsolicitudsocio.jsp">Socio</option>
			                     <option value="agregarsolicitudservicio.jsp">Servicio de Proveedores</option>
			                
		                      </select>
		                    </div>
		                  </div>
                      
			                <div class="control-group">
							  <div class="controls">
								<button name="btnAceptar" class="btn btn-primary" type="submit">Aceptar</button>
                                <button name="btnCancelar" class="btn">Cancelar</button>
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
