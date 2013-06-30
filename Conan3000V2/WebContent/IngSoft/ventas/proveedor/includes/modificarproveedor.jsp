<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script>
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		if(validaForm()) form.submit();
			
			}
		
</script>	

	<%! public boolean  encontrar(String a, String[] b){
		for(int i=0;i<b.length;i++){			
			if(b[i].equals(a)) return true;	
		}
	return false;
	}
	public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM/YYYY");
		return DF.format(date);
	}
	
	public String generarCadena(String[] t){
		String a="";
		for(int i=0;i<t.length;i++)
			a= a.concat(t[i]+"/");
			if(a.length()>0) a=a.substring(0, a.length()-1);
		return a;
	}
	%>

	
<!--The beans  -->
	<jsp:useBean id="proveedor" scope="request"class="IngSoft.venta.bean.ProveedorBeanData"></jsp:useBean>	
		   
		   
		    <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="#">Home</a> / <a href="buscarproveedor.jsp">Mantenimiento de Proveedores</a> / Modificar Proveedor</li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2>MODIFICAR PROVEEDOR</h2>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmUpdate" method="Post">
		          <input type="hidden" name="codigo" value="<%=proveedor.getIdProveedor()%>"></input>
			        <input type="hidden" name="accion" value="Modificar"></input>
					<input type="hidden" name="tipo" value="2"></input>
		          
		            <fieldset>
		            
		              <div class="control-group" id="dvRazonSocial">
		                <label class="control-label" for="typeahead7">Raz&oacute;n Social: </label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtRazonSocial"  name="txtRazonSocial" data-provide="typeahead" value=<%=proveedor.getRazonSocial() %> maxlength="100" onpaste="return false;"    >
						  <span class="help-inline" id="errRazonSocial">Please correct the error</span>
		                </div>
	                  </div>
	                  
		                <div class="control-group" id="dvRuc">
		                  <label class="control-label" for="typeahead6">RUC: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtRuc" name="txtRuc"  data-provide="typeahead" data-items="4" value=<%=proveedor.getRuc() %> maxlength="11" onpaste="return false;">
							<span class="help-inline" id="errRuc">Please correct the error</span>
		                  </div>
		                 </div>
		                  
		                <div class="control-group" id="dvDireccion">
		                  <label class="control-label" for="typeahead4">Direcci&oacute;n: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtDireccion" name="txtDireccion"  data-provide="typeahead" data-items="4"  value="<%=proveedor.getDireccion() %>" maxlength="100" onpaste="return false;">
							<span class="help-inline" id="errDireccion">Please correct the error</span>
	                      </div>
	                    </div>
	                    
		                <div class="control-group" id="dvTelefono">
		                  <label class="control-label" for="typeahead8">Tel&eacute;fono : </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtTelefono" name="txtTelefono" data-provide="typeahead" data-items="4" value=<%=proveedor.getTelefono() %> maxlength="8" onpaste="return false;">
							<span class="help-inline" id="errTelefono">Please correct the error</span>
	                      </div>
	                    </div>
	                    
		                <div class="control-group" id="dvCorreoE">
		                  <label class="control-label" for="typeahead9">Correo electr&oacute;nico: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtCorreo" name="txtCorreo"  data-provide="typeahead" data-items="4" value=<%=proveedor.getCorreo() %> maxlength="50" onpaste="return false;">
							<span class="help-inline" id="errCorreoE">Please correct the error</span>
	                      </div>
	                    </div>
	                    
		                <div class="control-group" id="dvNombre">
		                  <label class="control-label" for="typeahead10">Nombre Contacto: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNombre"  name="txtNombre" data-provide="typeahead" data-items="4" value=<%=proveedor.getNomContacto() %> maxlength="50" onpaste="return false;">
							<span class="help-inline" id="errNombre">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                      <div class="control-group" id="dvApellidoP">
		                  <label class="control-label" for="typeahead11">Apellido Paterno: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApPaterno"  name="txtApPaterno" data-provide="typeahead" data-items="4" value=<%=proveedor.getApPaterno() %> maxlength="50" onpaste="return false;">
							<span class="help-inline" id="errApellidoP">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                      <div class="control-group" id="dvApellidoM">
		                  <label class="control-label" for="typeahead12">Apellido Materno: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtApMaterno" name="txtApMaterno"  data-provide="typeahead" data-items="4" value=<%=proveedor.getApMaterno() %> maxlength="50" onpaste="return false;">
							<span class="help-inline" id="errApellidoM">Please correct the error</span>
		                  </div>
	                    </div>
	                    
	                    <div class="control-group" id="dvTipo">
								<label class="control-label" for="typeahead13">Tipo de Documento:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="DNI" <% if(proveedor.getTipoDoc().toUpperCase().equals("DNI")){ %> checked <%}%> >
									DNI
								  </label>
								  <div style="clear:both">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Carnet de Extranjeria" <% if(proveedor.getTipoDoc().toUpperCase().equals("CARNET DE EXTRANJERIA")){ %> checked <%}%>>
									Carnet de Extranjeria
								  </label>
								  <span class="help-inline" id="errTipo">Please correct the error</span>
								  </div>
								</div>
							  </div>
	                    
	                    
		                <div class="control-group" id="dvNumDoc">
		                  <label class="control-label" for="typeahead14">Numero Documento: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNumDoc" name="txtNumDoc" data-provide="typeahead" data-items="4" value=<%=proveedor.getNumDoc() %> maxlength="9" onpaste="return false;">
							<span class="help-inline" id="errNumDoc">Please correct the error</span>
	                      </div>
	                    </div>
	                  </div>
	                  
		              <div class="form-actions">
		                 <button  type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>   
			                      		   <button  type="button"  class="btn" onclick="location.href='buscarproveedor.jsp'">Cancelar</button>  
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
