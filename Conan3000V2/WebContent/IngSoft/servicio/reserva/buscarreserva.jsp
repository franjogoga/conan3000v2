<!DOCTYPE html>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<html lang="en">
<head>
	<!--
	Formulario para la generación de las reservas de las actividades.
	-->
	<meta charset="utf-8">
	<title>Conan3000</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<script language="javascript" src=""></script>	
	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
	
	<script src="js/ajaxsbmt.js"></script>
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
	<link rel="shortcut icon" href="img/favicon.ico">
		
	<script> 
var pendientes="";
var cancelados="";
var lock1=1;
var lock2=1;
var lock3=1;
var lock4=1;
function cambiarClase(elemento){

if (elemento.className == "btn btn-success") {
	elemento.className = "btn btn-inverse";
	elemento.innerHTML=elemento.innerHTML.replace("Reservar&nbsp;&nbsp;&nbsp;","Pendiente");
	var temp=elemento.getAttribute("id")+"@";
	if(cancelados.search(temp)<0)
	pendientes=pendientes.concat(temp);
	else cancelados=cancelados.replace(temp,"");

	}
	else 
	if(elemento.className == "btn btn-inverse") {
	elemento.className = "btn btn-success";
	elemento.innerHTML=elemento.innerHTML.replace("Pendiente","Reservar&nbsp;&nbsp;&nbsp;");
	var temp=elemento.getAttribute("id")+"@";
	if(pendientes.search(temp)<0)
	cancelados=cancelados.concat(temp);
	else pendientes=pendientes.replace(temp,"");
	}
	
}

function ajax_submit(tipo){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock1==1){
	lock1=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()
		  +"&pendientes="+pendientes+"&cancelados="+cancelados,
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#resultadoBusqueda").html("<div align='center'><img src='img/ajax-loaders/ajax-loader-7.gif'></img></div>");
  		  },
		  success: function(msg){
			$("#resultadoBusqueda").html(msg);
			pendientes="";
			cancelados="";			
			actualizar_pendientes();
			lock1=1;
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock1=1;
			alert("ERROR!! Pasó lo siguiente: "+quepaso);
		  }
	
		});
		}
}


function ajax_search(){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock2==1){
	lock2=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=2" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val(),
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#resultadoBusqueda").html("<div align='center'><img src='img/ajax-loaders/ajax-loader-7.gif'></img></div>");
  		  },
		  success: function(msg){
			$("#resultadoBusqueda").html(msg);
			lock2=1;		
			
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock2=1;
			alert("ERROR!! Pasó lo siguiente: "+quepaso);
		  }
	
		});
	}
		return false
		
}

function actualizar_pendientes(){

var ant=($("#pendientes").attr('value').split(','));						  								  		
						  		var temp;
						  		for(i=0;i<ant.length ;i++){						  		
						  			temp=".btn-success[id='"+ant[i]+"']";						  			
						  			if(!$(temp).hasClass("btn-danger")){						  			
						  			$(temp).html("<i class='icon-ok icon-white'></i>Pendiente");
						  			
						  			$(temp).toggleClass("btn-inverse btn-success");}						  			
						  			
						  		}
						  		//else{
						  		//var temp=ant[i]+"@";
						  		//cancelados=cancelados.concat(temp);
						  		//}

}

function ajax_confirmaSocio(){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock3==1){
	lock3=0;
	if($('#txtDNISocio').val().length >0){
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=5" +"&txtDNISocio="+$('#txtDNISocio').val(),
		  dataType: "text",	
		   beforeSend: function ( xhr ) {
   		  $('#txtIdSocio').val("");
			$('#txtNombreSocio').val("");
  		  },	  
		  success: function(msg){
			var temp;
			temp=msg.split('/');
			$('#txtIdSocio').val(temp[0]);
			$('#txtNombreSocio').val(temp[1]);
			lock3=1;						
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock3=1;
			alert("ERROR!! No se pudo completar la operacion intente de nuevo");
		  }
	
		});
		
	}
	}
}

function ajax_crearReserva(){
//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
if(lock4==0){
	lock4=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=6" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()
		  +"&pendientes="+pendientes+"&cancelados="+cancelados,
		  dataType: "text",
		  success: function(msg){
			$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Crear"+"&tipo=2" +"&txtIdSocio="+$('#txtIdSocio').val(),
		  dataType: "text",		  
		  success: function(msg){
		  	lock4=1;
			alert("Operacion realizada sin problemas")},
		  error: function(objeto, quepaso, otroobj){
		  	lock4=1;
		  	alert("ERROR!! No se pudo completar la operacion intente de nuevo");
		  }
	
		});
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock4=1;
			alert("ERROR!! No se pudo completar la operacion intente de nuevo");
			
		  }
	
		});
		}
}
</script>	



<script type="text/javascript">
    
   
    
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
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						MANTENIMIENTO DE RESERVAS
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> MANTENIMIENTO DE RESERVAS</h2>
						
					</div>
					<div class="box-content">
						<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda" method="post" onsubmit="return ajax_search()">
						<input type="hidden" name="accion" value="Buscar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						<input type="hidden" name="reservas" value=""></input>
						
						  <fieldset>
							
					<div class="control-group">
								<label class="control-label" for="cmbSedes">Sedes relacionadas(*):</label>
								<div class="controls">
								  <select  data-rel="chosen" id="cmbSedes" name="cmbSedes" >
									<%for(int i=0;i<sedes.size();i++){ %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>"><%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
									<%} %>																
								  </select>
								</div>
							  </div>
						<div class="control-group">
						
								<label class="control-label" for="selectError">Seleccionar servicios</label>
								<div class="controls">
								
								  <select id="cmbServicios" data-rel="chosen" name="cmbServicios">
									<option value="futbol"> Cancha de futbol</option>
									<option value="tennis">  Cancha de tennis</option>
                                    <option value="fronton"> Cancha de Fronton</option>
									<option value="bungalow"> Bungalows</option>
							
								  </select>
								</div>
						    </div>
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">Buscar</button>
			
							</div>
						  </fieldset>
						</form>   
					</div>
				</div><!--/span-->

			</div><!--/row-->
<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i></i> RESERVAS</h2>
					</div>  	
<div  class="box-content" name="resultadoBusqueda" id="resultadoBusqueda" style="position:relative">
						
					  
					
                      
  </div><!--/span-->
    				
                      <div class="form-actions" id="reserva_boton">
			             <button class="btn btn-primary btn-setting" >Crear Reserva</button>                                                
		                </div>
				</div><!--/span-->

			</div><!--/row-->
					

				
		<hr>
<form id="frmReservas" name="frmReservas">
<input type="hidden" value="" id="txtIdSocio" name="txtIdSocio"></input>
</form>
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h3>Datos de socio</h3>
			</div>
			<div class="modal-body">
				<jsp:include page="/IngSoft/servicio/reserva/formularioreservas.jsp" />
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Cancelar</a>
				<a class="btn btn-primary" onclick="ajax_crearReserva();">Guardar Reservas</a>
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
