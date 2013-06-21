<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.venta.bean.EmpleadoMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.EmpleadoBeanData"%>

	<meta charset="utf-8">
	<title>Agregar Solicitud Producto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<jsp:useBean id="sedes" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="empleados" scope="request" class="IngSoft.administracion.bean.EmpleadoBeanData"></jsp:useBean>
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
		
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
   function anhadirprod(cod, name){
	var form= document.frmProducto;
	form.txtProducto.value=name;
	form.idProductoProv.value=cod;
	$.fn.colorbox.close();
	
} 
   
   function anhadiremp(cod, name){
		var form= document.frmEmpleado;
		form.txtEmpleado.value=name;
		form.codigo.value=cod;
		$.fn.colorbox.close();
		
	} 
</script>	
					 
			  <!-- content starts -->
			 
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		        <li>Agregar Producto</li>
	          </ul>
		      </div>  
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>SOLICITUD DE PRODUCTO</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmProducto"  method="Post"  action="SMVProducto" onsubmit="alt_submit();return false;" >
						<input type="hidden" name="accion" id="accion" value="Agregar" ></input>
						<input type="hidden" name="tipo" id="tipo" value="2" ></input>
						
						    
			         <div class="control-group" id="dvProducto">
			                <label class="control-label" for="typeahead8">Producto (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtProducto"  data-provide="typeahead" name="txtProducto" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../producto/seleccionarproducto.jsp"> <i class="icon icon-search icon-white"></i> Buscar Producto</a> </div>
			                  <span class="help-inline" id="errProducto">Please correct the error</span>
			                </div>
		                  </div>
		                  
						
			          </form>
			         <div class="box-content">
			         <form  id="frmEmpleado" name="frmEmpleado" method="POST" action="SMSEmpleado" onsubmit="alt_submit();return false;"  >
			        	    <input type="hidden" name="accion" value="Agregar"></input>
   		 				<input type="hidden" name="tipo" value="2"></input>
   		 				
   		 				 	 
		                 <div class="control-group" id="dvEmpleado">
			                <label class="control-label" for="typeahead8">Empleado (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtEmpleado"  data-provide="typeahead" name="txtEmpleado" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="/Conan3000V2/IngSoft/administracion/empleados/seleccionarempleado.jsp"> <i class="icon icon-search icon-white"></i> Buscar Empleado</a> </div>
			                  <span class="help-inline" id="errEmpleado">Please correct the error</span>
			                </div>
		                  </div>	 
			         </form>
			        
			                <form class="form-horizontal" name="frmSolicitud" id="frmSolicitud"method="POST" action="SMVSolicitudProducto" onsubmit="alt_submit();return false;">
			          <input type="hidden" name="accion" value="Agregar"></input>
			          <input type="hidden" name="tipo" value="2"></input>
			             <input type="hidden" name="fFecha" value="20/05/2014"></input>
			          
			          <fieldset>
			          
			          
			      
		                  			         			         
			            <div class="control-group">
			                <label class="control-label" for="typeahead4">Cantidad(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtCantidad" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
		                  
		                   <div class="control-group">
                          <label class="control-label" for="selectError">Sede (*):</label>
                          <div class="controls">
                            <select id="cmbSede" data-rel="chosen" name="cmbSede">
								<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>
		               		      
		               	      
		                    
		               		      
		               		              			          
			            <div class="form-actions">
			          <input type="hidden" name="idProductoProv" value=""/></input>
			           <input type="hidden" name="codigo" value=""/></input>
			           <button type="submit" class="btn btn-primary" >Agregar</button>
			              <button type="button" class="btn" onclick="location.href='agregarsolicitudproducto.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		                 </form>
		               (*) Campos Obligatorios</div>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>PRODUCTOS</h2>
		          </div>
			      <div class="box-content">
                  <table class="table table-striped table-bordered bootstrap-datatable datatable">
					   
					    <thead>
					      <tr>
					        <th>Nombre</th>
					        <th>Precio Unitario</th>
					        <th>Cantidad</th>
					        <th>Fecha</th>
					        <th>Monto</th>
					         <th>Acci&oacute;n</th>
					        
				          </tr>
				        </thead>
				        
				            <tbody>
					      <tr>
					        <td></td>
					          <td ></td>
					            <td ></td>
					          <td class="center"><b>Total</b></td>
					        <td class="center"><b>600.00</b></td>
					     
					   
                        					
                        
					        <td > </td>
				          </tr>
                               
				       </tbody>	 
				        
					    <tbody>
					      <tr>
					        <td>Gaseosa Coca-Cola</td>
					          <td class="center">2.00</td>
					            <td class="center">100</td>
					          <td class="center">16/06/13</td>
					        <td class="center">200.00</td>
					   
                        					
                        
					        <td class="center"> <a class="btn btn-info" href="modificarsolicitudproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>
				         
				       </tbody>
				       
					          
		               <tbody>
					      <tr>
					         <td>Galleta</td>
					          <td class="center">2.00</td>
					            <td class="center">100</td>
					          <td class="center">16/06/13</td>
					        <td class="center">400.00</td> 
					     		 <td class="center"> <a class="btn btn-info" href="modificarsolicitudproducto.jsp"> <i class="icon-edit icon-white"></i> Modificar </a> <a class="btn btn-danger" href="eliminarsolicitudproducto.jsp"> <i class="icon-trash icon-white"></i> Eliminar </a></td>			       
				          </tr>
                         
				        </tbody>
		                
				      </table>
				      
				        </tbody>
				        
				      
				         
                 
                  <div class="form-actions">
                 
			              <button  name="btnFinalizar" type="submit" class="btn btn-primary">Finalizar</button>
			            
		                </div>
			           
		        </div>
		      </div>
              
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 
	  
       
					<!-- content ends -->
