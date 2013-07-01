				
		<script>
	
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
	
	public String generarCadena(String[] t){
		String a="";
		for(int i=0;i<t.length;i++)
			a= a.concat(t[i]+"/");
			if(a.length()>0) a=a.substring(0, a.length()-1);
		return a;
	}
	%>
	
	<!--The beans  -->
	<jsp:useBean id="servicio" scope="request" class="IngSoft.venta.bean.ServicioBeanData"></jsp:useBean>	

	<jsp:useBean id="proveedor" scope="request" class="IngSoft.venta.bean.ProveedorBeanData"></jsp:useBean>	

			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Servicios de Proveedor  / </a>Modificar Servicio</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>MODIFICAR  SERVICIO	DE PROVEEDOR			  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmUpdate" method="Post" action="<%= response.encodeURL("SMVServicio")%>">
						<input type="hidden" name="codigo" value="<%=servicio.getCodServicio()%>"></input>
			       		<input type="hidden" name="accion" value="Modificar"></input>
					    <input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						  
						   <div class="control-group" id="dvNombreServ">
						      <label class="control-label" for="typeahead7">Nombre Servicio: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreServ"  data-provide="typeahead"  name="txtNombreServ"  value="<%=servicio.getNombreServicio()%>"  maxlength="50">
					              <span class="help-inline" id="errNombreServ">Please correct the error</span>
					          </div>
					        </div>

						   <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea id="txtDescripcion" name="txtDescripcion" style="resize:none" rows="3"  onpaste="return false;"  maxlength="100"><%=servicio.getDescripcion() %></textarea>
		                      <span class="help-inline" id="errDescripcion">Please correct the error</span>
		                    </div>
		                   </div>
 
							<div class="control-group" >
							    <label class="control-label" for="typeahead3">Precio(S/.): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPrecio" name="txtPrecio" data-provide="typeahead" data-items="4" value=<%=servicio.getPrecio() %>>
						        </div>
						    </div>
						      
							<div class="control-group" id="dvNombreProv">
							  <label class="control-label" for="typeahead4">Nombre Proveedor: </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="txtNombreProv" name="txtNombreProv"  data-provide="typeahead" data-items="4" value=<%=proveedor.getRazonSocial()%>  maxlength="50" onpaste="return false;">
							    <span class="help-inline" id="errNombreProv">Please correct the error</span>
							  </div>
							</div>
							

						    <div class="form-actions">
							   <button type="button"   class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>  
			               <button type="button" class="btn" onclick="location.href='../servicioproveedor/buscarservicio.jsp'">Cancelar</button> 
							</div>
						  </fieldset>
					  </form>
                      (*) Campos Obligatorios 
				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
