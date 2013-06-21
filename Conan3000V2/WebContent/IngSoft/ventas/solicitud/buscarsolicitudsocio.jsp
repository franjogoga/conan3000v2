<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.venta.bean.ResultadoSolicitudSocioBeanData"%>
<%@page import="java.util.Vector"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Conan 3000</title>
	<!--The beans  -->
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

	<link rel="shortcut icon" href="img/conan_logo.png">
	
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
	
	<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	
	function alt_aceptar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Aceptar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_denegar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Denegar";
		form.codigo.value=cod;
		form.submit();
	}
	</script>	
		


</head>
<body>

		<jsp:include page="/IngSoft/general/superior.jsp" />
		<div class="container-fluid">
			<div class="row-fluid">
				<jsp:include page="/IngSoft/general/leftmenu.jsp" />
				<jsp:include page="/IngSoft/general/noscript.jsp" />

			<!-- content starts -->

			<div id="content" class="span10">

			<div>
				<ul class="breadcrumb">
					
					<li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home / </a><a href="/Conan3000V2/IngSoft/ventas/socio/buscarsocio.jsp">Mantenimiento de Solicitud Socio / </a>Busqueda Solicitud Socio
			           
			              </li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i>  BUSCAR SOLICITUD SOCIO				  </h2>
                        <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
						</div>
                        
                        
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVSolicitudSocio")%>">
						   <input type="hidden" name="accion" value="Buscar"/></input>
						  
						  <fieldset>
						    <div class="control-group">
						    
						     <div class="control-group">
							    <label class="control-label" for="typeahead6">Nombres: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombres" data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
						    
							  <div class="control-group">
							    <label class="control-label" for="typeahead6">Apellido Paterno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtApellidoP" name="txtApellidoP"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  <div class="control-group">
							    <label class="control-label" for="typeahead10">Apellido Materno: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtApellidoM" name="txtApellidoM"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
						      
						      <!-- <div class="control-group">
			              		<label class="control-label" for="typeahead21">Fecha Registro: </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaR" name="fFechaR" value="01/06/2013" readonly="readonly">
			             		</div>
		                		</div> -->
                              
						    </div>
						    <div class="form-actions">
						    <button type="submit" class="btn btn-primary">Buscar</button>
			              <button type="button" class="btn" onclick="location.href='../solicitud/buscarsolicitudsocio.jsp'">Cancelar</button>
						    
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->


			
			
			<form id="frmAlternativo" name="frmAlternativo" method="POST" action="SMVSolicitudSocio">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			   </form>
			  
			  

			<div class="row-fluid sortable">
				<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>RESULTADOS</h2>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
                        
                        
                        <div  align="right">
                               <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a> 
                           </div>
                           
						  <thead>
							  <tr>
								  <th>Nombres</th>
								  <th>Apellido Paterno</th>
								  <th>Apellido Materno</th>
								  <th>Fecha Registro</th>
								  <th>Estado</th>
								  <th>Accion</th>
							  </tr>
						  </thead>  
						  
						  <element>
					      <tbody id="resultadobusqueda"> 


						  <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                             %>
                             	
							 <tr>
					       
					        
					        
					        <td class="center">
                          				<%=
                          					((ResultadoSolicitudSocioBeanData)resultados.get(i)).getNombres()

                          				%>
                          	</td>
                          	
                          	 <td class="center">
                          				<%=
                          					((ResultadoSolicitudSocioBeanData)resultados.get(i)).getApellidoPaterno()

                          				%>
                          	</td>
                          	
                            <td class="center">
                          			<%=
                          					((ResultadoSolicitudSocioBeanData)resultados.get(i)).getApellidoMaterno()

                          				%>
                          	</td>
                          	
                          	<td class="center">
		                	<%=
                         		df.format(((ResultadoSolicitudSocioBeanData)resultados.get(i)).getFechaRegistro())
                        	%>
		                	</td>
		                	
		                	<td class="center"><span class="label label-success">
                          			<%=
                          					((ResultadoSolicitudSocioBeanData)resultados.get(i)).getEstado()

                          				%>
                          	</span></td>
                       
                               <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_aceptar('<%=((ResultadoSolicitudSocioBeanData)resultados.get(i)).getCodSolicitudSocio()%>')">
                          					<i
                          						class="icon-ok icon-white">
                          					</i>
Aceptar
                          				</a>

                          				<a class="btn btn-danger"
                          					href="javascript:alt_denegar('<%=((ResultadoSolicitudSocioBeanData)resultados.get(i)).getCodSolicitudSocio()%>')">
                          					<i class="icon-remove icon-white">
                          					</i>
		Denegar
                          				</a>
                          			</td>
                          	</tr>
                          	
					        <%}%>
					       </tbody>
					       </element>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
          </div>
          
          	<div class="row-fluid sortable"><!--/span--><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span--><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->
			</div><!--/row-->
      </div> 
      
      </div>  
                
                
                


    		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Ã—</button>
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
		<jsp:include page="/IngSoft/general/inferior.jsp" />
		
		
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
	
	<script src="js/ajaxsbmt.js"></script>


</body>             
</html>           
         