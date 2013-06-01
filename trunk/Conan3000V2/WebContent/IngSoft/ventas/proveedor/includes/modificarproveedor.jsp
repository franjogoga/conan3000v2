<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script>
		function validar(form){
			if(form.txtNombrePromocion.value.length <=0)return false;
			if(form.fFechInicio.value.length<=0)return false;
			if(form.fFechFin.value.lengtht<=0)return false;
			if(form.txtDescripcion.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
	return true;
		
		
		}
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		if(valida(form)) form.submit();
			
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
		            
		              <div class="control-group">
		                <label class="control-label" for="typeahead7">Raz&oacute;n Social (*): </label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtRazonSocial"  name="txtRazonSocial" data-provide="typeahead" value=<%=proveedor.getRazonSocial() %> >
		                </div>
	                  </div>
	                  
		              <div class="control-group">
		                <div class="control-group">
		                  <label class="control-label" for="typeahead6">RUC (*): </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtRuc" name="txtRuc"  data-provide="typeahead" data-items="4" value=<%=proveedor.getRuc() %> >
		                  </div>
		                 </div>
		                  
		                <div class="control-group">
		                  <label class="control-label" for="typeahead4">Direcci&oacute;n: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtDireccion" name="txtDireccion"  data-provide="typeahead" data-items="4"  value=<%=proveedor.getDireccion() %>>
	                      </div>
	                    </div>
	                    
		                <div class="control-group">
		                  <label class="control-label" for="typeahead8">Tel&eacute;fono / Celular: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtTelefono" name="txtTelefono" data-provide="typeahead" data-items="4" value=<%=proveedor.getTelefono() %> >
	                      </div>
	                    </div>
	                    
		                <div class="control-group">
		                  <label class="control-label" for="typeahead9">Correo electr&oacute;nico: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtCorreo" name="txtCorreo"  data-provide="typeahead" data-items="4" value=<%=proveedor.getCorreo() %> >
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
		                  <label class="control-label" for="typeahead2">Numero Documento: </label>
		                  <div class="controls">
		                    <input type="text" class="span6 typeahead" id="txtNumDoc" name="txtNumDoc" data-provide="typeahead" data-items="4" value=<%=proveedor.getNumDoc() %> >
	                      </div>
	                    </div>
	                  </div>
	                  
		              <div class="form-actions">
		                 <button  type="button" class="btn btn-primary"  onclick="javascript:alt_submit()">Guardar</button>>  
			               <button type="button"   class="btn" href="buscarproveedor.jsp">Cancelar</button>>
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
