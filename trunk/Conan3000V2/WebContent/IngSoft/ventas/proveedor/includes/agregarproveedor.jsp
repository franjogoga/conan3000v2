<%@page import="IngSoft.venta.bean.DistritoMiniBeanData"%>
<script>

function validaCorreo(valor)
{
	var reg=/(^[a-zA-Z0-9._-]{1,30})@([a-zA-Z0-9.-]{1,30}$)/;
	if(reg.test(valor)) return true;
	else return false;
}

function esCorrecto(valor,minimo, maximo){
	
	if(valor.length>maximo){ 
		return false;
	}else{
		if(valor.length<=minimo){
			return false;
		}else{
			return true;	
		}

	}

}

function validarEntero(valor){ 
 
 valor = parseInt(valor); 
 	if (isNaN(valor)) { 
       	 return null;
 	}else{ 
       	 return valor; 
 	}
}

function generaMensaje(cadena){
	var i;
	var mensaje="Los siguientes campos no han sido llenados correctamente\n";
	for(i=0;i<cadena.lenght;i++){
		if(i+1<cadena.lenght){
			mensaje+=cadena[i]+', ';
			
		}else{
			mensaje=+cadena[i];
			
		}
		
	}
	return mensaje;
	
}


function crearAlert(cadena){
	mensaje=generaMensaje(cadena);
	$(document).ready(function() {
		apprise(mensaje, {'animate':true}, function(r) {

			if(r) { 
			
			} else { 
		
			}
		});
	});
}

function alt_submit(){
	var form= document.frmProveedor;
	if(validar(form)) form.submit();
		
}

function validar(form){
			if(form.txtRazonSocial.value.length <=0)return false;
			if(form.txtRuc.value.length<=0)return false;
			if(form.txtDireccion.value.lengtht<=0)return false;
			if(form.txtNombre.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
	return true;
		
		
		}

function validaForm(){
	var form=document.frmProveedor;
	var cadena= new Array();
	var i=0;
	if(!esCorrecto(form.txtRazonSocial.value,1,100)){
		cadena[i]="Razon";
		i++; 
	}
	
	if(!esCorrecto(form.txtNombre.value,1,10)){
		cadena[i]="Nombre";
		i++;
	}
	if(!esCorrecto(form.Telefono.value,1,10)){
		cadena[i]="Telefono";
		i++;
	}
	if(!esCorrecto(form.txtCorreo.value,1,100)){
		cadena[i]="Correo";
		i++;
	}
	
	crearAlert(cadena);
	
	
	
	
	
	

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
		                  <label class="control-label" for="selectError">Distrito:</label>
		                  <div class="controls">
		                    <select  id="cmdDistrito" name="cmdDistrito" data-rel="chosen">
		                     <%for(int i=0;i<tiposDistrito.size();i++){ %>
										<option value="<%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getIdDistrito()%>" <%=i==0?"selected":""%>><%= ((DistritoMiniBeanData)tiposDistrito.get(i)).getNombreDistrito()%></option>
									<%} %>	
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
	                    
	                      <!--REVISAR!!! -->
	                    <div class="control-group">
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
								  </div>
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
			                 