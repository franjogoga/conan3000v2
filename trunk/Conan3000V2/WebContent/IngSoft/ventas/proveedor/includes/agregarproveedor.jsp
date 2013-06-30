<%@page import="IngSoft.venta.bean.DistritoMiniBeanData"%>


<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmProveedor;
		if(validaForm()) form.submit();
			
}

function anhadir(cod, name){
	var form= document.frmProveedor;
	form.txtSocio.value=name;
	form.idSocio.value=cod;
	$.fn.colorbox.close();
	
} 

function confFecha(){
	var form= document.frmProveedor;
	if(form.cmbPeriodo.value=="Anual"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[2]=parseInt(fechaI[2])+1;
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Semestral"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[1]=parseInt(fechaI[1])+6;
		if(fechaI[1]>12){
			fechaI[2]=parseInt(fechaI[2])+1;
			fechaI[1]=parseInt(fechaI[1])-12;
		}
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Indefinido"){
	document.getElementById("dvFechaFin").style.display='block';
	}
	
}
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
		         <form class="form-horizontal"  name="frmProveedor" method="POST"  action="<%= response.encodeURL("SMVProveedor")%>">
			                 <input type="hidden" name="accion" value="Agregar"></input>
							<input type="hidden" name="tipo" value="2"></input>
		            <fieldset>
		              <div class="control-group"  id="dvRazonSocial">
		                <label class="control-label" for="typeahead7">Raz&oacute;n Social (*):</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtRazonSocial" name="txtRazonSocial"  data-provide="typeahead" maxlength="100" onpaste="return false;">
		                  <span class="help-inline" id="errRazonSocial">Please correct the error</span>
		                </div>
	                  </div>
		              <div class="control-group" id="dvRuc">
		                <div class="control-group">
		                  <label class="control-label" for="typeahead6">RUC (*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtRuc" name="txtRuc"  data-provide="typeahead" data-items="4" maxlength="11" onpaste="return false;">
		                  	<span class="help-inline" id="errRuc">Please correct the error</span>
		                  </div>
	                    </div>
		                <div class="control-group" id="dvDireccion">
		                  <label class="control-label" for="typeahead4">Direcci&oacute;n(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtDireccion"  name="txtDireccion" data-provide="typeahead" data-items="4" maxlength="100" onpaste="return false;">
		                    <span class="help-inline" id="errDireccion">Please correct the error</span>
		                  </div>
	                    </div>

		                <div class="control-group">
		                  <label class="control-label" for="selectError">Distrito(*):</label>
		                  <div class="controls">
		                    <select  id="cmdDistrito" name="cmdDistrito" data-rel="chosen">
		                     <%for(int i=0;i<tiposDistrito.size();i++){ %>
										<option value="<%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getIdDistrito()%>" <%=i==0?"selected":""%>><%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getNombreDistrito()%></option>
									<%} %>	
	                        </select>
		                  </div>
	                    </div>
		                <div class="control-group" id="dvTelefono">
		                  <label class="control-label" for="typeahead8">Tel&eacute;fono (*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtTelefono" name="txtTelefono"  data-provide="typeahead" data-items="4" maxlength="8" onpaste="return false;">
		                    <span class="help-inline" id="errTelefono">Please correct the error</span>
		                  </div>
	                    </div>
	                    
		                <div class="control-group" id="dvCorreoE">
		                  <label class="control-label" for="typeahead9">Correo electr&oacute;nico(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtCorreo" name="txtCorreo"  data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;">
		                      <span class="help-inline" id="errCorreoE">Please correct the error</span> 
		                  </div>
	                    </div>
	                    
		                <div class="control-group" id="dvNombre">
		                  <label class="control-label" for="typeahead10">Nombre Contacto(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNombre"  name="txtNombre" data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;" >
		                    <span class="help-inline" id="errNombre">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                      <div class="control-group" id="dvApellidoP">
		                  <label class="control-label" for="typeahead11">Apellido Paterno(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApPaterno"  name="txtApPaterno" data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;">
		                    <span class="help-inline" id="errApellidoP">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                      <div class="control-group" id="dvApellidoM">
		                  <label class="control-label" for="typeahead12">Apellido Materno(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApMaterno" name="txtApMaterno"  data-provide="typeahead" data-items="4" maxlength="50" onpaste="return false;">
		                    <span class="help-inline" id="errApellidoM">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                      <!--REVISAR!!! -->
	                    <div class="control-group" id="dvTipo">
								<label class="control-label" for="typeahead5">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="DNI" >
									DNI
								  </label>
								  <div style="clear:both">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Carnet de Extranjeria">
									Carnet de Extranjeria
								  </label>
								   <span class="help-inline" id="errTipo">Please correct the error</span>
								  </div>
								</div>
							  </div>
	                    
		                <div class="control-group" id="dvNumDoc">
		                  <label class="control-label" for="typeahead2">Numero de Documento(*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNumDoc"  name="txtNumDoc" data-provide="typeahead" data-items="4" maxlength="9" onpaste="return false;">
	                         <span class="help-inline" id="errNumDoc">Please correct the error</span>
	                      </div>
	                    </div>
	                  </div>
		              <div class="form-actions">
		                    <button  type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>   
			                      		   <button  type="button"  class="btn" onclick="location.href='buscarproveedor.jsp'">Cancelar</button>  
			              			              
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
			                 