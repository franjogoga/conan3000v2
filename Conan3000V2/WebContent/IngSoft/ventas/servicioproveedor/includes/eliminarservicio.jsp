
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
			
	<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar este servicio?");
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
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM");
		return DF.format(date);
	}
	%>
			
			

				



	
			<!-- content starts -->
			
<jsp:useBean id="proveedor" scope="request"class="IngSoft.venta.bean.ProveedorBeanData"></jsp:useBean>		
<jsp:useBean id="servicio" scope="request"class="IngSoft.venta.bean.ServicioBeanData"></jsp:useBean>	

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Servicios de Proveedor  /</a> Eliminar Servicio</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>ELIMINAR SERVICIO				  </h2>
				  </div>
				  
					<div class="box-content">
						<form class="form-horizontal" name="frmDelete"  action="<%= response.encodeURL("SMVServicio")%>" method="post">
					    <input type="hidden" name="codigo" value="<%=servicio.getCodServicio()%>" ></input>
						<input type="hidden" name="accion" value="Eliminar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						  
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre Servicio: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreServ" name="txtNombreServ" data-provide="typeahead" disabled value=<%=servicio.getNombreServicio() %>> 
					          </div>
					        </div>

							  <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="textarea" class="" id="textarea" rows="3" disabled style="resize:none"><%=servicio.getDescripcion() %></textarea>
		                    </div>
		                  </div>

							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Precio (S/.): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPrecio" name="txtPrecio"  data-provide="typeahead" data-items="4" disabled value=<%=servicio.getPrecio() %>>
						        </div>
						      </div>

							    <div class="control-group">
							      <label class="control-label" for="selectError2">Nombre Proveedor:</label>
							      <div class="controls">
							       <input type="text" class="span6 typeahead" id="txtNombreProv" name="txtNombreProv" data-provide="typeahead" data-items="4" disabled value=<%=proveedor.getRazonSocial() %>>
						          </div>
						        </div>

				
						<button  type="submit" class="btn btn-primary"  onclick="javascript:alt_submit()">Eliminar</button>  
			               <button type="button" class="btn" onclick="location.href='../servicioproveedor/buscarservicio.jsp'">Cancelar</button> 
							
						  </fieldset>
					  </form>   
					</div>
				  </div>
				</div><!--/span-->

			<!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
