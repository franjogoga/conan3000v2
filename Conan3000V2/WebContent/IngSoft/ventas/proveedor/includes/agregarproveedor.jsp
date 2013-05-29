<%@page import="IngSoft.venta.bean.DistritoMiniBeanData"%>
<script>



</script>	

<jsp:useBean id="tiposDistrito" scope="request"class="java.util.Vector"></jsp:useBean>

		               
 <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="#">Home</a> / <a href="bucarproveedor.jsp">Mantenimiento de Proveedores</a> / Agregar Proveedor</li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2>AGREGAR PROVEEDOR</h2>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal">
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead7">Raz&oacute;n Social (*):</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtRazonSocial" name="txtRazonSocial"  data-provide="typeahead" >
		                </div>
	                  </div>
		              <div class="control-group">
		                <div class="control-group">
		                  <label class="control-label" for="typeahead6">RUC (*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtRuc" name="txtRuc"  data-provide="typeahead" data-items="4" >
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead4">Direcci&oacute;n: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtDireccion"  name="txtDireccion" data-provide="typeahead" data-items="4" >
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="selectError">Departamento:</label>
		                  <div class="controls">
		                    <select name="selectError3" id="cmbDepartamento"  name="cmbDepartamento" data-rel="chosen">
		                      <option>Lima</option>
		                      <option>Trujillo</option>
	                        </select>
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="selectError">Provincia:</label>
		                  <div class="controls">
		                    <select name="selectError" id="cmbProvincia" name="cmbProvincia" data-rel="chosen">
		                      <option>Lima</option>
		                      <option>Callao</option>
	                        </select>
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="selectError">Distrito:</label>
		                  <div class="controls">
		                    <select name="selectError2" id="cmbDistrito" name="cmbDistrito" data-rel="chosen">
		                      <option>San Miguel</option>
		                      <option>San Isidro</option>
	                        </select>
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead8">Tel&eacute;fono / Celular: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtTelefono" name="txtTelefono"  data-provide="typeahead" data-items="4" >
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead9">Correo electr&oacute;nico: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtCorreo" name="txtCorreo"  data-provide="typeahead" data-items="4" >
		                  </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead10">Nombre Contacto: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNombre"  name="txtNombre" data-provide="typeahead" data-items="4">
		                  </div>
	                    </div>
	                    
	                      <div class="control-group">
		                  <label class="control-label" for="typeahead10">Apellido Paterno: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApPaterno"  name="txtApPaterno" data-provide="typeahead" data-items="4">
		                  </div>
	                    </div>
	                    
	                      <div class="control-group">
		                  <label class="control-label" for="typeahead10">Apellido Materno: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApMaterno" name="txtApMaterno"  data-provide="typeahead" data-items="4">
		                  </div>
	                    </div>
	                    
	                                   <div class="control-group">
		                  <label class="control-label" for="selectError">Tipo de Documento:</label>
		                  <div class="controls">
		                    <select name="selectError2" id="cmbTipoDoc" name="cmbTipoDoc" data-rel="chosen">
		                      <option>DNI</option>
		                      <option>Carnet de Extranjeria</option>
		                      
	                        </select>
		                  </div>
	                    </div>
	                    
		                <div class="control-group">
		                  <label class="control-label" for="typeahead2">Numero de Documento: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNumDoc"  name="txtNumDoc" data-provide="typeahead" data-items="4" >
	                      </div>
	                    </div>
	                  </div>
		              <div class="form-actions">
		                     <a  name="btnAgregar" class="btn btn-primary" href="">Agregar</a>  
			               <a  name="btnCancelar" class="btn" href="buscarproveedor.jsp">Cancelar</a>
	                  </div>
	                </fieldset>
	              </form>
	            (*) Datos Obligatorios</div>
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
			                 