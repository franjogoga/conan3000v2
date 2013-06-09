<meta charset="utf-8">
	<title>Agregar Producto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>

<link rel="stylesheet" href="css/apprise.css" type="text/css" />	</style>
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
	if (validaForm())  alt_submit2();
	else alert("Uno o mas campos estan vacios");			
		}
function alt_submit2(){
	
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/ventas/producto/SMVProducto",
		  data: "&accion=" + $(accion).val() + "&tipo=" + $(tipo).val() + "&txtNombre=" + $(txtNombre).val() + "&txtDescripcion=" + $(txtDescripcion).val()+ "&txtPresentacion=" + $(txtPresentacion).val()+ "&txtPrecioU=" + $(txtPrecioUo).val() + "&txtProveedor=" + $(txtProveedor).val(),
		  dataType: "text",
		  success: function(msg){
			  var url="<%=request.getContextPath()%>"+msg;
			  $("#linkAceptar").css("display","inline");
			  $("#linkCerrar").css("display","none");
			  $("#modalTitulo").html("EXITO");				  
			  $("#modalContenido").html("El producto ha sido agregado exitosamente");
			  $("#linkAceptar").bind("click",function(){
				  location.href=url;					  
			  });
			  $("#bModal").trigger("click");
			  				  								
		  },
		  error: function(objeto, quepaso, otroobj){
			$("#linkAceptar").css("display","inline");
			$("#linkCerrar").css("display","none");
			$("#modalTitulo").html("ERROR");
			$("#modalContenido").html("No se pudo agregar el producto, intentelo mas tarde");
			$("#bModal").trigger("click");
			alert("ERROR!!");			
		  }
	
		});		
}
	
	
	
function anhadir(cod,name){
	var form=document.frmProducto;
	form.idProveedor.value=cod;
	form.txtProveedor.value=name;
	$.fn.colorbox.close();
}
</script>	
			
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
				<li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarproducto.jsp">Mantenimiento de Productos</a> <span class="divider">/</span></li>
		        <li>Agregar Producto</li>
				
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>AGREGAR PRODUCTO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmProducto"  method="Post"  action="SMVProducto" onsubmit="alt_submit();return false;" >
						<input type="hidden" name="accion" id="accion" value="Agregar" ></input>
						<input type="hidden" name="tipo" id="tipo" value="2" ></input>
						  <fieldset>
						    <div class="control-group" id="dvNombre">
						      <label class="control-label" for="typeahead7">Nombre (*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombre" name="txtNombre" onKeyUp="limita(this,50);" onKeyDown="limita(this,50);" onpaste="return false;" data-provide="typeahead" >
						        <span class="help-inline" id="errNombre">Please correct the error 	        
					          </span>
					        </div>
					          </div>
					        
						    <div class="control-group">
							  
							  <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea id="txtDescripcion" name="txtDescripcion"  onpaste="return false;" style="resize:none; height: 74px; width: 273px" onKeyUp="limita(this,100);" onKeyDown="limita(this,100);" ></textarea>
								
								<span class="help-inline" id="errDescripcion">Please correct the error 	        
					          </span>		                  
 							</div>
		                  </div>
							  
						      
						       <div class="control-group" id="dvPresentacion">

							    <label class="control-label" for="typeahead14">Presentaci&oacute;n: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead"  onpaste="return false;" id="txtPresentacion" name="txtPresentacion" onKeyUp="limita(this,50);" onKeyDown="limita(this,50);" data-provide="typeahead" data-items="4" >
						       <span class="help-inline" id="errPresentacion">Please correct the error 	        
					          </span>	
						        </div>
						      </div>
						      
						      
						      
							  <div class="control-group" id="dvPrecioU">
							    <label class="control-label" for="typeahead10">Precio Unitario (S/.) (*): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead"   onpaste="return false;"id="txtPrecioU" name="txtPrecioU" onKeyUp="limita(this,50);" onKeyDown="limita(this,50);" data-provide="typeahead" data-items="4" >
						         <span class="help-inline" id="errPrecioU">Please correct the error 	        
					          </span>	
						        </div>
						      </div>
						 <div class="control-group" id="dvProveedor">
			                <label class="control-label" for="typeahead8">Proveedor (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtProveedor"  data-provide="typeahead" name="txtProveedor" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../proveedor/seleccionarproveedor.jsp"> <i class="icon icon-search icon-white"></i> Buscar Proveedor</a> </div>
			                  <span class="help-inline" id="errProveedor">Please correct the error</span>
			                </div>
		                  </div>
						    </div>
                            
						    <div class="form-actions">
			            <input type="hidden" name="idProveedor" value=""/></input>
			           <button type="submit" class="btn btn-primary" >Agregar</button>
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
					
					
					<hr>
		<but>
		<div style="display: none;">
			<button class="btn btn-primary btn-setting" id="bModal"/>
		</div>
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h3 id="modalTitulo">EXITO</h3>
			</div>
			<div class="modal-body">
				<p id="modalContenido">El producto ha sido agregado exitosamente</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn" id="linkAceptar" style="display: none">Aceptar</a>
				<a href="#" class="btn" id="linkCerrar"  data-dismiss="modal" style="display: none">Cerrar</a>
								
			</div>
		</div>
