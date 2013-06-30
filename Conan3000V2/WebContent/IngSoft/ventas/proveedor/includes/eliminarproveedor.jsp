		
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>    
		    
	<!-- content starts -->
   <script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar este proveedor?");
		if(r==true){form.submit();}
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
	%>	
	
<!-- content starts -->
<jsp:useBean id="proveedor" scope="request"class="IngSoft.venta.bean.ProveedorBeanData"></jsp:useBean>
		    
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="#">Home</a> / <a href="buscarproveedor.jsp">Mantenimiento de Proveedores</a> / Eliminar Proveedor</li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2>ELIMINAR PROVEEDOR</h2>
	            </div>
	            
		        <div class="box-content">
		          <form class="form-horizontal" name="frmDelete"  action="<%= response.encodeURL("SMVProveedor")%>" method="post">
		          <input type="hidden" name="codigo" value="<%=proveedor.getIdProveedor()%>" ></input>
				  <input type="hidden" name="accion" value="Eliminar"></input>
				  <input type="hidden" name="tipo" value="2"></input>
		            <fieldset>
		            
		              <div class="control-group">
		                <label class="control-label" for="typeahead7">Raz&oacute;n Social: </label>
		                <div class="controls">
		                  <input type="text" class="input-xlarge disabled" id="typeahead7"  data-provide="typeahead" disabled="disabled" value=<%=proveedor.getRazonSocial() %>>
	                    </div>
	                  </div>
		              <div class="control-group">
		                <div class="control-group">
		                  <label class="control-label" for="typeahead6">RUC: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead6"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getRuc() %> >
	                      </div>
	                    </div>
	                    
		                <div class="control-group">
		                  <label class="control-label" for="typeahead4">Direcci&oacute;n: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead4"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getDireccion() %>>
	                      </div>
	                    </div>
	                    
		                <div class="control-group">
		                  <label class="control-label" for="typeahead8">Tel&eacute;fono: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead8"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getTelefono() %> >
	                      </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead9">Correo electr&oacute;nico: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead9"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getCorreo() %> >
	                      </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead10">Contacto: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead10"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getNomContacto() %>>
	                      </div>
	                    </div>
		                <div class="control-group">
		                  <label class="control-label" for="typeahead2">Numero Documento: </label>
		                  <div class="controls">
		                    <input type="text" class="input-xlarge disabled" id="typeahead2"  data-provide="typeahead" data-items="4" disabled="disabled" value=<%=proveedor.getNumDoc() %> >
	                      </div>
	                    </div>
	                  </div>
		              <div class="form-actions">
		                <button  type="submit" class="btn btn-primary" onclick="javascript:alt_submit()">Eliminar</button>  
			               <button type="button" class="btn" onclick="location.href='buscarproveedor.jsp'">Cancelar</button>  
			           
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
