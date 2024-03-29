<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.SedeBeanData"%>


<html lang="en">
<head>
	<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
	<meta charset="utf-8">
	<title>Eliminar Sede</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!--The beans  -->
<jsp:useBean id="sede" scope="request"class="IngSoft.administracion.bean.SedeBeanData"></jsp:useBean>

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

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/conan_logo.png">
	
	<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
	<link rel="stylesheet" href="css/apprise.css" type="text/css" />
	<script type="text/javascript" src="js/script.js"></script>
		
	<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("�Esta seguro que desea eliminar esta Sede ?");
		if(r==true){
				if(<%=sede.getFlag()%>==1){
        			crearAlert2("No se puede eliminar la sede. Se est� violando el principio de dependencia.");
        		}else{
					form.submit();    
        		}
			}
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
						<a href="buscarsede.jsp">Mantenimiento de Sede</a> <span class="divider">/</span>
					</li>
					<li>
						Eliminar de Sede
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
					  <h2><i class="icon-trash"></i>ELIMINAR SEDE</h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmDelete"  action="<%= response.encodeURL("SMASede")%>" method="post">
						
						
						<input type="hidden" name="codigo" value="<%=sede.getCodigo()%>"></input>
						<input type="hidden" name="accion" value="Eliminar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						  
						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Nombre: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombresede"  data-provide="typeahead"  name="txtNombresede" disabled value="<%= sede.getNombre()%>">
					          </div>
					        </div>



							 <div class="control-group">
								<label class="control-label" for="selectError">Departamento:</label>
								<div class="controls">
																						   <!-- cmbDepartamento  variable     -->	
							 		<select disabled="" id="selectError11" data-rel="chosen" name="cmbDepartamento">
								  	<option  selected value=""><%=sede.getDepartamento()%></option>							
								  </select>
								</div>
							  </div>
							  
							 <div class="control-group">
								<label class="control-label" for="selectError">Provincia:</label>
								<div class="controls">
																						   <!-- cmbDepartamento  variable     -->	
							 		<select disabled="" id="selectError12" data-rel="chosen" name="cmbDepartamento">
								  	<option  selected value=""><%=sede.getProvincia()%></option>							
								  </select>
								</div>
							  </div>


							 <div class="control-group">
								<label class="control-label" for="selectError">Distrito:</label>
								<div class="controls">
																						   <!-- cmbDepartamento  variable     -->	
							 		<select disabled="" id="selectError13" data-rel="chosen" name="cmbDepartamento">
								  	<option  selected value=""><%=sede.getDistrito()%></option>							
								  </select>
								</div>
							  </div>

	

						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Direccion: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreEvento"  data-provide="typeahead"  name="txtNombreEvento" disabled value="<%=sede.getDireccion()%>">
					          </div>
					        </div>



						    <div class="control-group">
						      <label class="control-label" for="typeahead7">Telefono: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreEvento"  data-provide="typeahead"  name="txtNombreEvento" disabled value="<%=sede.getTelefono()%>">
					          </div>
					        </div>



						    <div class="control-group">
						      <label class="control-label" for="typeahead7">AreaTereno: </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreEvento"  data-provide="typeahead"  name="txtNombreEvento" disabled value="<%=sede.getAreaterreno()%>">
					          </div>
					        </div>
					        
					        
						

							<div class="control-group">
								<label class="control-label">Estado </label>
								<div class="controls">
								  <label class="radio">
								  <%
								 
								  if( sede.getEstado().equalsIgnoreCase("disponible") ){
									  out.print(" <input  disabled type='radio' name='optionsRadios' id='optionsRadios1' value='Disponible' checked=''  >");
								  }
								  else
								  {  out.print(" <input   disabled type='radio' name='optionsRadios' id='optionsRadios1' value='Disponible'  >");
								  }
								  
								   
								  %>
								Disponible
								  </label>
								 
								    <div style="clear:both"></div>   
								 
								 
								  <label class="radio">
								 
								  <%
								  if( sede.getEstado().equalsIgnoreCase("no disponible") ){
									  out.print(" <input  disabled type='radio' name='optionsRadios' id='optionsRadios2' value='No Disponible' checked=''  >");
								  }
								  else
								  {  out.print(" <input  disabled type='radio' name='optionsRadios' id='optionsRadios2' value='No Disponible'  >");
								  }
								  %>
								No disponible
								  </label>
								
								 
								 
								</div>
							</div>
                     
                    
	
	
	
	
							
						    <div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Eliminar</button>
							  <button type="button" class="btn" onclick="location.href='buscarsede.jsp'" >Cancelar</button>
							</div>
							
							
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->		 
					<!-- content ends -->
			</div><!--/#content.span10-->
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
	
		
</body>
</html>
