<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.ResultadoJornadaBeanData"%>
<%@page import="java.util.Vector"%>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Marcar Jornada</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<!--The beans  -->
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

	
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
	
	
	
	<script>
	
	
	function anhadir(cod, name,puesto){
		var form= document.frmData;
		form.cmbEncargado.value=name;
		form.cmbEncargadoCodigo.value=cod;
		form.txtPuesto.value=puesto;
		$.fn.colorbox.close();
		
	} 
	
	function alt_fecha(obj){
		obj.value=obj.value.slice(0,5);
		
		}

	function verificar_fecha(comparacion,fecha1,fecha2){
		var fec1=fecha1.value.split("/");
		var fec2=document.getElementById(fecha2).value.split("/");
		var resultado=true;
		if(fec1.length==fec2.length) {
			var size=fec1.length;
			for(i=size-1;i>=0;i--){
				if(comparacion==0){
					if(fec1[i].indexOf(fec2[i])<0)  resultado= false;
					}
				if(comparacion==1){
					if(parseInt(fec1[i])<parseInt(fec2[i]))  resultado= false;
					}
				if(comparacion==-1){
					if(parseInt(fec1[i])>parseInt(fec2[i]))  resultado= false;
					}
				}
			if(resultado==false){			
					fecha1.value=document.getElementById(fecha2).value;			
				}
				
			} 
		else{
			alert("Error al comparar fechas");
		}			
	}

	function alfanumerico(e) 
	{ 
	var key = window.event.keyCode || event.keyCode;
	return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
	} 	

	
		


	
	function mueveFecha(){
	   fechaActual = new Date()
	 
		dia = fechaActual.getDate()
		mes = fechaActual.getMonth() +1
		anno = fechaActual.getFullYear()
	   
	 
		if (dia <10) dia = "0" + dia
		if (mes <10) mes = "0" + mes 
	 
		fechaHoy = dia + "/" + mes + "/" + anno;
		return fechaHoy
	}
		
		
		
	function mueveReloj(){
		momentoActual = new Date()
		
		hora = momentoActual.getHours()
		minuto = momentoActual.getMinutes()
		segundo = momentoActual.getSeconds()
		
		if (hora <10) hora = "0" + hora
		if (minuto <10) minuto = "0" + minuto
		if (segundo <10) segundo = "0" + segundo 
		
		horaImprimible = hora + ":" + minuto + ":" + segundo
		
		
		document.frmData.fFechaJornada.value = mueveFecha()
		document.frmData.reloj.value = horaImprimible 
		
		setTimeout("mueveReloj()",1000)
	}

	function alt_submit(){
		var form= document.frmData;
		
		document.frmData.fFechaJornada.value=mueveFecha();
		document.frmData.reloj.value=horaImprimible;
		
		if(validaForm()){
		form.submit();
		}
	}
	
	function alt_submit2(){               
		
		$.ajax({
			  type: "POST",
			  url: "/Conan3000V2/IngSoft/administracion/jornada/SMAJornada",
			  data: "accion=" + $(accion).val() + "&tipo=" + $(tipo).val() + "&txtNombreJornada=" + $(txtNombreJornada).val() + "&reloj=" + $(reloj).val()  
			  + "&fFechaJornada=" + $(fFechaJornada).val(),
			  dataType: "text",
			  success: function(msg){
				  var url="<%=request.getContextPath()%>"+msg;
				  $("#linkAceptar").css("display","inline");
				  $("#linkCerrar").css("display","none");
				  $("#modalTitulo").html("EXITO");				  
				  $("#modalContenido").html("La plantilla de evento ha sido agregada exitosamente");
				  $("#linkAceptar").bind("click",function(){
					  location.href=url;					  
				  });
				  $("#bModal").trigger("click");
				  				  								
			  },
			  error: function(objeto, quepaso, otroobj){
				$("#linkAceptar").css("display","inline");
				$("#linkCerrar").css("display","none");
				$("#modalTitulo").html("ERROR");
				$("#modalContenido").html("No se pudo agregar su plantilla de evento, intentelo mas tarde");
				$("#bModal").trigger("click");
				alert("ERROR!!");			
			  }
		
			});		
	}
	
	
	
	</script>		
</head>

<body   onload="mueveReloj()"    >
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
						Marcar Jornadas de Trabajo
					</li>
					
				</ul>
			</div>
			  
			  
			  
			  
              <div class="row-fluid sortable">
			  
			  
                <div class="box span12">
				
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i>  MARCAR JORNADA	 </h2>
                        <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
						</div>
				    </div>
				  
				  
				  
                  <div class="box-content">
                    <form class="form-horizontal" action="<%= response.encodeURL("SMAJornada")%>" name="frmData" method="post">
                    <input type="hidden" name="accion" value="Marcar"></input>
					<input type="hidden" name="tipo" value="2"></input>
                      <fieldset>
                      
                      
	

                      
                        <div class="control-group" >
								 <label class="control-label" for="typeahead">Codigo Empleado:</label>
								  
								 <div class="controls" id="dvNombreJornada" >
									<input type="text" id="txtNombreJornada"   name="txtNombreJornada"   maxlength="9" >
									<span class="help-inline" id="errNombreJornada">Please correct the error</span>
								 </div>
						  
						  
						        <div class="controls">
						        <input type="text"   name="reloj" size="10"  maxlength="8" >
						        </div>
								 
					            <div class="controls">
								<input type="text"    name="fFechaJornada" size="10" maxlength="10" >
						        </div>
                        </div>
                        




                        
                        
                        <div class="form-actions">
                          <button type="button" class="btn btn-primary"  onclick="javascript:alt_submit()">Agregar</button>
                          
                        </div>
                        
                        
                        
                      </fieldset>
                    </form>
					
                  </div>
                </div>
                <!--/span-->
              </div>
              <!--/row-->
			  
			 <!-- inicio --> 
			<form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMAJornada")%>">
			    <input type="hidden" name="accion" value="Seleccionar"></input>
			    <input type="hidden" name="codigo" value=""></input>
			    <input type="hidden" name="tipo" value="1"></input>
			</form>	
			<!-- fin --> 

			<!-- inicio <div class="row-fluid sortable"> --> 

			
			<div class="row-fluid sortable">	

				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>RESULTADOS</h2>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
                        
                     
                           
						  <thead>
							  <tr>
								  <th>Nombres</th>
								  <th>Apellido Paterno</th>
								  <th>Hora Registro</th>
								  <th>Estado Registro</th>
								  
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
                          					((ResultadoJornadaBeanData)resultados.get(i)).getNombreEmpleado() 

                          				%>
                          	</td>
                          	
                          	 <td class="center">
                          				<%=
                          					((ResultadoJornadaBeanData)resultados.get(i)).getApaterno()

                          				%>
                          	</td>
                          	
                            <td class="center">
                          			<%=
                          					((ResultadoJornadaBeanData)resultados.get(i)).getHoraMarca()

                          				%>
                          	</td>
                          	
                          	
                          	
								<td class="center">
                          			
	                          			
								           <%
									 
												  if( ((ResultadoJornadaBeanData)resultados.get(i)).getFlag()==0 ){    
								 out.print(" <span class='label label-success'> Entrada   </span>       ");
												  }
												  else { 
								 out.print(" <span class='label label-warning'> Salida   </span>       ");
													
												  }
									  
									   
									 
		                          					            
	                          				%>
	                          			
                          			
                          			</td>

                                    <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_Insertar('<%=((ResultadoJornadaBeanData)resultados.get(i)).getIdEmpleado()%>','<%= ((ResultadoJornadaBeanData)resultados.get(i)).getNombreEmpleado()+' '+((ResultadoJornadaBeanData)resultados.get(i)).getApaterno() %>','<%= ((ResultadoJornadaBeanData)resultados.get(i)).getFlag()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
													Seleccionar
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
		
			
			<!-- fin </div>-->  
			  
              <!-- content ends -->
            </div>
			
	
			
			
			
			
			
          <!--/#content.span10-->
		  
		  
		  
		</div><!--/fluid-row-->
				
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
	
	
	
<!--     ---------------------- Sirve para poner un iframe ------------------------------   -->	


<!--     -----------------------------------------------------   -->			
	
		<script>
			$(document).ready(function(){
				//Examples of how to assign the Colorbox event to elements
				
				$(".iframe").colorbox({iframe:true, width:"60%", height:"80%"});
				
				//Example of preserving a JavaScript event for inline calls.
				$("#click").click(function(){ 
					$('#click').css({"background-color":"#f00", "color":"#fff", "cursor":"inherit"}).text("Open this window again and this message will still be here.");
					return false;
				});
			});
		</script>
	
<!--     -----------------------------------------------------   -->	
	
	<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
	<link rel="stylesheet" href="css/apprise.css" type="text/css" />
	<script type="text/javascript" src="js/script.js"></script>
    <script>
 
 
function validaForm(){
                /*
        esValido(nombre, casilla, id, tipoValidacion, minimo,maximo)
        nombre: es el nombre de la casilla: ejemplo -> Nombre, Apellido, Fecha de Nacimiento, etc
        casilla: corresponde a la casilla en si, para esto colocamos por ejemplo form.txtNombre, donde form ya fue definido
        id: identificador de los divs para efectuar las validaciones
        tipoValidacion: es un valor numerico el cual permite identificar el tipo de validacion que se efectuara
        1: Validacion con cantidad de caracteres Minimo y maximo
        2: Validación de cantidad de caracteres de fecha
        3: validacion de llenado de radio button
        4: Validacion de alfanumerico
        5: validacion de valores Float
        6: Validacion de enteros
        7: Validacion de fechas
        minimo: valor numerico que indica la menor cantidad de caracteres que como minimo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
        maximo: valor numerico que indica la maxima cantidad de caracteres que como maximo debe ser llenado (Solo para tipoValidacion 1 y 2, en el resto poner 1)
       
        El valor que va en cadena[i] es el nombre del campo
       
        #############################ADICIONAL#########################
        Para validar una fecha Inicial y fecha Final usar la siguiente funcion
        validarFechas(nombre[Fecha Final], casilla[Fecha Final], id[Fecha Final],nombre[Fecha Inicial],casilla[Fecha Inicial])
        OJO: no va como parametro el id de la fecha Inicial
        ###############################################################
        */
       
        var form=document.frmData;
 
        var cadena= new Array();
        var i=0;
        var error=false;
        if(!esValido("Codigo",form.txtNombreJornada,"NombreJornada",1,9,9)){cadena[i]="codigo";i++;}
        //if(!esValido("Descripci&oacute;n",form.txtDescripcion,"Descripcion",1,0,100)){cadena[i]="Descripci&oacute;n";i++;}
        //if(!esValido("Caracter&iacute;sticas",form.txtCaracteristica,"Caracteristica",1,0,100)){cadena[i]="Caracter&iacute;sticas";i++;}
       
        //No tocar
        if(i>0){
        crearAlert(cadena);
        return false;
        }else{
                return true;      
        }
} 
 
function inicializa(){
        document.getElementById("errNombreJornada").style.display='none';
        //document.getElementById("errDescripcion").style.display='none'; 
        //document.getElementById("errCaracteristica").style.display='none';    
} 
 
inicializa();
 
</script>
</body>
</html>
