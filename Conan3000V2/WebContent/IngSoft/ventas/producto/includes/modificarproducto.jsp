<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
</style>
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>
<script>
function alt_submit(){
	var form= document.frmProducto;
	if (validaForm()) form.submit();
		
}

function anhadir(cod, name){
	var form= document.frmProducto;
	form.txtProveedor.value=name;
	form.idProveedor.value=cod;
	$.fn.colorbox.close();
	
} 

</script>



<!--The beans  -->
	<jsp:useBean id="producto" scope="request"class="IngSoft.venta.bean.ProductoBeanData"></jsp:useBean>	


			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					     <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarproducto.jsp">Mantenimiento de Productos</a> <span class="divider">/</span></li>
		        <li> Modificar  Producto</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>MODIFICAR  PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						   <form class="form-horizontal"  name="frmProducto" method="Post"  action="SMVProducto">
					<input type="hidden" name="codigo" value="<%=producto.getIdProdProveedor()%>" ></input>
			        <input type="hidden" name="accion" value="Modificar"></input>
					<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group" id="dvNombre">
						      <label class="control-label" for="typeahead7">Nombre(*): </label>
						      <div class="controls">
						        <input type="text" value="<%=producto.getNombre() %>"  onpaste="return false;" class="span6 typeahead" name="txtNombre" id="txtNombre"  data-provide="typeahead" >
					          <span class="help-inline" id="errNombre">Please correct the error</span>
					          </div>
					        </div>
						    
							 
							  
							  <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class=""  id="txtDescripcion"   onpaste="return false;"><%=producto.getDescripcion() %></textarea>
			                   <span class="help-inline" id="errDescripcion">Please correct the error</span>
		                    </div>
		                  </div>
						      
						      <div class="control-group" id="dvPresentacion">

							    <label class="control-label" for="typeahead14">Presentaci&oacute;n: </label>
							    <div class="controls">
							      <input type="text" name="txtPresentacion" id="txtPresentacion" class="span6 typeahead" value="<%=producto.getPresentacion() %>"   onpaste="return false;" id="typeahead14" data-provide="typeahead" data-items="4"/>
						        <span class="help-inline" id="errPresentacion">Please correct the error</span>
						        </div>
						        
						      </div>
						      
							  <div class="control-group" id="dvPrecioU">
							    <label class="control-label" for="typeahead10">Precio Unitario (S/.) (*): </label>
							    <div class="controls">
							      <input type="text" value="<%=producto.getPrecioU() %>"  onpaste="return false;" class="span6 typeahead" name="txtPrecioU" id="txtPrecioU"  data-provide="typeahead" data-items="4" >
						         <span class="help-inline" id="errPrecioU">Please correct the error</span>
						        </div>
						      </div>
							 <div class="control-group" id="dvProveedor">
			                <label class="control-label" for="typeahead8">Provedor (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtProveedor"  data-provide="typeahead" name="txtProveedor" data-items="4" readonly="readonly"  value="<%=producto.getIdProveedor() %>">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../proveedor/seleccionarproveedor.jsp"> <i class="icon icon-search icon-white"></i> Buscar Proveedor</a> </div>
			                  <span class="help-inline" id="errProveedor">Please correct the error</span>
			                </div>
		                  </div>  
							
							<div class="control-group" id="dvEstado">
	                <label class="control-label" for="selectError">Estado (*):</label>
			                <div class="controls">
			                 <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="Activo" <% if(producto.getEstado().toUpperCase().equals("ACTIVO")){ %> checked <%}%>class="">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Eliminado" class="" <% if(producto.getEstado().toUpperCase().equals("ELIMINADO")){ %> checked <%}%>>
									Inactivo
								  </label><br>
		                      <span class="help-inline" id="errEstado">Please correct the error</span>
			                </div>
		                  </div>
							
							
						    <div class="form-actions">
						<input type="hidden" name="idProveedor" value="<%=producto.getIdProveedor() %>"/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Modificar</button>
			              <button type="button" class="btn" onclick="location.href='buscarproducto.jsp'">Cancelar</button>
			           
							</div>
						  </fieldset>
					  </form>
                      (*) Datos Obligatorios 
				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
