<!DOCTYPE html>
<%@page import="IngSoft.servicio.bean.TipoEventoMiniBeanData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.administracion.bean.*"%>
<%@page import="IngSoft.servicio.bean.*"%>
<%@page import="java.util.Vector"%>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>CONAN 3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Dos virgenes">
	
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tiposEvento" scope="request"class="java.util.Vector"></jsp:useBean>

	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
    
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
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

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">

<script>
			
			function alfanumerico(e) 
			{ 
				var key = window.event.keyCode || event.keyCode;
				return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
			} 	
			function alt_fecha(obj){
			obj.value=obj.value.slice(0,10);
			
			}
			
	
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_eliminar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Eliminar";
		form.codigo.value=cod;
		form.submit();
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		form.submit();
		
			
			}
		
	</script>			


		
</head>

<body>
		
		<jsp:include page="/IngSoft/general/superior.jsp" />
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<jsp:include page="/IngSoft/general/leftmenu.jsp" />
						<!-- left menu ends -->       
			
		<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
		</noscript>
			
		  <div id="content" class="span10">
		    <!-- content starts -->
		   <div>
				<ul class="breadcrumb">
					<li>
						<a href="/Conan3000V2/IngSoft/general/index.jsp">Home</a> <span class="divider">/</span>
					</li>
					<li>
						Mantenimiento de Empleados 
					</li>
					
				</ul>
			</div>
			
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR EMPLEADO</h2>
		          </div>
		        <div class="box-content">
		         <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  action="<%= response.encodeURL("SMSEmpleado")%>" method="post" >
		             <input type="hidden" name="accion" value="Buscar"></input>
		            <fieldset>		              			 
		            
		           						
						<div class="control-group">
							  <label class="control-label" for="nombres">Nombres (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNombreEmpleado" name="txtNombreEmpleado" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="paterno">Apellido Paterno (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtApellidoPaterno" name="txtApellidoPaterno" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>								
							  </div>
							</div>
							
							
							<div class="control-group">
							  <label class="control-label" for="txtNumeroDocumento">Numero de Documento (*):</label>							  
							  <div class="controls">
								<input type="text" class="span6 typeahead" data-provide="typeahead"  id="txtNumeroDocumento" name="txtNumeroDocumento" onkeypress="return alfanumerico(event);" autofocus maxlength="50"/>														
							  </div>
							</div>						
						
					<div class="control-group">
								<label class="control-label" for="cmbArea">&Aacute;rea (*):</label>
								<div class="controls">
								  <select name="cmbArea" id="cmbArea" data-rel="chosen">
									<option>GERENCIA</option>
									<option>ADMINISTRACION</option>
									<option>OPERACIONES</option>
								  </select>
								</div>
							</div>		
											
					  
		              <div class="form-actions">
		                 <button type="submit" class="btn btn-primary">Buscar</button>
							  <button type="reset" class="btn">Cancelar</button>              
	                  </div>
					  
	                </fieldset>
	              </form>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		
		    <form id="frmAlternativo" name="frmAlternativo" method="post" action="<%= response.encodeURL("SMSEmpleado")%>">
			<input type="hidden" name="accion" value="Agregar"></input>
			<input type="hidden" name="codigo" value=""></input>
			<input type="hidden" name="tipo" value="1"></input>
			</form>
					
					
						
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
      <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> 
		            
		           <a class="btn btn-primary" href="javascript:alt_agregar()">
                                    <i class="icon icon-add icon-white"></i>
                                    Agregar
                                </a>
		            
		            <thead>
		              <tr>
		                <th>Codigo</th>
		                <th>Nombre</th>
		                <th>Apellido</th>
		                <th>Area</th>
		                <th>Acci&oacuten</th>
	                  </tr>
	                </thead>
		           
		            <tbody id="resultadoBusqueda">
		              <%
		              	SimpleDateFormat df= new SimpleDateFormat("dd/MM"); 
		                                       for(int i=0; 
		                                        i<resultados.size(); i++)
		                                       {
		              %>

							                		<tr>
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()
                          				%>
                          			</td>
                          			
                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getNombre()
                          				%>
                          			</td>
                          			<td class="center">
                          			<%=
                          				((ResultadoEmpleadoBeanData)resultados.get(i)).getApellidoPaterno()
                          				%>
                          			</td>
                          				                          			
                          			<td class="center">
                          				<%=
                          					((ResultadoEmpleadoBeanData)resultados.get(i)).getArea()
                          				%>
                          			
                          				
                          			</td>

                          			<td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoEmpleadoBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          		</tr>


									<%
										}
									%>
	                </tbody>
	              </table>
	            </div>
				</div><!--/span-->
	          </div>
		      <!--/span-->
	        </div>
	        
	        
	        
		    <!--/row-->
		    <!-- content ends -->
	      </div>
		  <!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">�</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
		  <p class="pull-left"><a href="http://usman.it/free-responsive-admin-template">Conan 3000</a> &copy;  2013</p>
          <p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Dos V&iacute;rgenes</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
</body>
</html>
