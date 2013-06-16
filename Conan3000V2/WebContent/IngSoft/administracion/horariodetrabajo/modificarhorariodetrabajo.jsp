<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.HorariodetrabajoBeanData"%>
<%@page import="IngSoft.administracion.bean.DiasBeanData"%>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Modificar Horario de Trabajo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<!--The beans  -->
	<jsp:useBean id="actividad" scope="request"class="IngSoft.administracion.bean.ActividadBeanData"></jsp:useBean>
	<jsp:useBean id="sedes"           scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="ambientes"       scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tipoactividades"  scope="request"class="java.util.Vector"></jsp:useBean>
	
	
	<jsp:useBean id="departamentos" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="provincias" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="distritos" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="sede" scope="request"class="IngSoft.administracion.bean.SedeBeanData"></jsp:useBean>
	
	
	
	<jsp:useBean id="horasDelDia" scope="request"class="java.util.Vector"></jsp:useBean>	
	<jsp:useBean id="horariodetrabajo" scope="request"class="IngSoft.administracion.bean.HorariodetrabajoBeanData"></jsp:useBean>
	<jsp:useBean id="diassemana" scope="request"class="java.util.Vector"></jsp:useBean>	
	
	
	
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
	
<%!

       boolean verificarExiste(String s, String[] l){

	   for(int i=0; i< l.length; i++){
		   if(l[i].equalsIgnoreCase(s))
		    return true;
	   }
	   return false; 
	   };

       int obtenerInice(String s, String[] l){

	   for(int i=0; i< l.length; i++){
		   if(l[i].equalsIgnoreCase(s))
		    return i;
	   }
	   return -1; 
	   };
         
	   
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
                  <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span> </li>
                  <li> <a href="buscarhorariodetrabajo.jsp">Mantenimiento de Horario de Trabajo</a> <span class="divider">/</span></li>
                  <li>Modificar Horario de Trabajo</li>
                </ul>
              </div>
              <div class="row-fluid sortable">
                <div class="box span12">
                  <div class="box-header well" data-original-title>
                    <h2><i class="icon-edit"></i>MODIFICAR HORARIO DE TRABAJO</h2>
                  </div>
                  <div class="box-content">
                    <form class="form-horizontal" action="<%= response.encodeURL("SMAHorariodetrabajo")%>" name="frmData" method="post">
						<input type="hidden" name="codigo" value="<%=((HorariodetrabajoBeanData)horariodetrabajo).getCodigo()%>  "></input>
						<input type="hidden" name="accion" value="Modificar"></input>
						<input type="hidden" name="tipo" value="2"></input>
						  
						  
                      <fieldset>
                      
                      


                      
                        <div class="control-group" id="dvNombreAmbiente">
                          <label class="control-label" for="typeahead">Nombre (*):</label>
                          <div class="controls">
                            <input type="text" class="span6 typeahead" id="txtNombre"  data-provide="typeahead" name="txtNombre"   value="<%=((HorariodetrabajoBeanData)horariodetrabajo).getNombre()%> "      >
                          	<span class="help-inline" id="errNombreAmbiente">Please correct the error</span>
                         
                        
                        


<!---------------  -->
							
								<!--  	<div class="row-fluid sortable"> -->
									
								<div class="control-group">	
								
											<div class="box span6">
												<div class="box-header well" data-original-title>
													<h2>Horario</h2>
													<div class="box-icon">
													    <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
														
													</div>
												</div>
												<div class="box-content">
													<table class="table">
														  <thead>
															  <tr>
																  <th>Dias</th>
																  <th>Hora Inicio</th>
																  <th>Hora FIn</th>                                         
															  </tr>
														  </thead>   
														 

														  <tbody>
														  
														   <% 
														   
														   String[] codigoDia = ((HorariodetrabajoBeanData)horariodetrabajo).getCodDiasemana().split(",");
														   String[] nombreDia = ((HorariodetrabajoBeanData)horariodetrabajo).getDiaSemana().split(",");
														   
														   String[] iniHora = ((HorariodetrabajoBeanData)horariodetrabajo).getHoraInicio().split(",");
														   
														    
														   
														   
														   
														   String[] finHora = ((HorariodetrabajoBeanData)horariodetrabajo).getHoraFin().split(",");
														   
														    String[] estDias = ((HorariodetrabajoBeanData)horariodetrabajo).getEstadosDias().split(",");
														   
														   
														   
														   
														   int x;
														   
														   for(int i=0; i<diassemana.size(); i++) { %>
														   
															<tr>
																<td>
							
															  <label class="checkbox inline">
																<input type="checkbox"  id="inlineCheckbox<%=i%>" name="checkDia<%=i%>"  value="<%= ((DiasBeanData)diassemana.get(i)).getCodigo() %>"  <%=  verificarExiste(  ((DiasBeanData)diassemana.get(i)).getCodigo() ,  codigoDia) ?"checked":""%>       > 
																<%=  ((DiasBeanData)diassemana.get(i)).getNombre()  %>  
															  </label>
															  
																</td>
															<!-- hora inicio -->	
																<% 
																
																if( verificarExiste(  ((DiasBeanData)diassemana.get(i)).getCodigo() ,  codigoDia)  ){ 
																	
																	x = obtenerInice(   ((DiasBeanData)diassemana.get(i)).getCodigo() ,  codigoDia   );
													            				//out.print(" indice ---> "+   x    +" hora inicio "+ iniHora[x]);
													            				
													          
													            %>
																<td class="center">
							 																																													
														 		<select  style="width: 70px;"  data-rel="chosen" id="cmbHoraInicio<%=i%>"  name="cmbHoraInicio<%=i%>" >
															        <%for(int k=0;k<horasDelDia.size();k++){     %>
													<option value="<%=    ((String)horasDelDia.get(k))   %>"    <%= ((String)horasDelDia.get(k)).equalsIgnoreCase(   iniHora[x]     )?"selected":"" %> >  <%=       ((String)horasDelDia.get(k))    %>    </option>
																    <%} %>						
															    </select>
							
																</td>
																<%}else{ %>
																
																
																<td class="center">
							 																																													
														 		<select  style="width: 70px;"  data-rel="chosen" id="cmbHoraInicio<%=i%>"  name="cmbHoraInicio<%=i%>" >
															        <%for(int k=0;k<horasDelDia.size();k++){     %>
													<option value="<%=    ((String)horasDelDia.get(k))   %>"    <%= k==0?"selected":"" %>  > <%=    ((String)horasDelDia.get(k))    %>    </option>
																    <%} %>						
															    </select>
							
																</td>
																
																<%} %>
																
																<!-- fin hora inicio -->
																
																
																
																
	                                                            <% 	
																if( verificarExiste(  ((DiasBeanData)diassemana.get(i)).getCodigo() ,  codigoDia)  ){ 
																	
																	x = obtenerInice(   ((DiasBeanData)diassemana.get(i)).getCodigo() ,  codigoDia   );
													            				//out.print(" indice ---> "+   x    +" hora inicio "+ iniHora[x]);
													            				
													          
													            %>
																<td class="center">
							 																																													
														 		<select  style="width: 70px;"  data-rel="chosen" id="cmbHoraFin<%=i%>"  name="cmbHoraFin<%=i%>" >
															        <%for(int k=0;k<horasDelDia.size();k++){     %>
													<option value="<%=    ((String)horasDelDia.get(k))   %>"    <%= ((String)horasDelDia.get(k)).equalsIgnoreCase(   finHora[x]     )?"selected":"" %> >  <%=       ((String)horasDelDia.get(k))    %>    </option>
																    <%} %>						
															    </select>
							
																</td>
																<%}else{ %>
																
																
																<td class="center">
							 																																													
														 		<select  style="width: 70px;"  data-rel="chosen" id="cmbHoraFin<%=i%>"  name="cmbHoraFin<%=i%>" >
															        <%for(int k=0;k<horasDelDia.size();k++){     %>
													<option value="<%=    ((String)horasDelDia.get(k))   %>"    <%= k==0?"selected":"" %>  > <%=    ((String)horasDelDia.get(k))    %>    </option>
																    <%} %>						
															    </select>
							
																</td>
																
																<%} %>
																
																<!-- fin hora fin -->
																
																
																
																
																
																
																
																
							                                      
															</tr>
															
								      						<%}%>
								      						
														  </tbody>
																					 
													 </table>  
							    
												</div>
											</div><!--/span-->
											
							
								</div><!--/row-->       
<!-- -------- -->		
								 </div><!-- fin controls -->
							</div> <!--  fin control-group -->
                     
                        
                        
                        <div class="form-actions">
                          <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>
                          <button type="button" class="btn" onclick="location.href='buscarhorariodetrabajo.jsp'" >Cancelar</button>
                        </div>
                        
                        
                        
                      </fieldset>
                    </form>
					<span style="font-size:70%">(*)Campos Obligatorios</span>
                  </div>
                </div>
                <!--/span-->
              </div>
              <!--/row-->
              <div class="row-fluid sortable">
                
                <!--/span-->
              </div>
              <!--/row-->
              <div class="row-fluid sortable">
                
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
	
	
	
	
	
<!--       ------------------------------------------------------------------------------- -->	
	
	
	
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

	
		
	function alt_submit(){
		var form= document.frmData;
		if(validaForm()) form.submit();
	}
	
	
	
	function alt_provincia(){
		$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/administracion/sede/SMASede",
		  data: "accion=Buscar"+ "&tipo=3" + "&cmbDepartamento=" + $(cmbDepartamento).val(),
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#cmbProvincia").html("");
			//chosen - improves select
			$("#cmbProvincia").trigger("liszt:updated");
  		  },
		  success: function(msg){
			$("#cmbProvincia").html(msg);
			//chosen - improves select
			$("#cmbProvincia").trigger("liszt:updated");
		  },
		  error: function(objeto, quepaso, otroobj){
			alert("ERROR!! Pasó lo siguiente: "+quepaso);
		  }
	
		});
	}
	function alt_distrito(){
		$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/administracion/sede/SMASede",
		  data: "accion=Buscar"+ "&tipo=4" + "&cmbProvincia=" + $(cmbProvincia).val(),
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#cmbDistrito").html("");
			//chosen - improves select
			$("#cmbDistrito").trigger("liszt:updated");
  		  },
		  success: function(msg){
			$("#cmbDistrito").html(msg);
			//chosen - improves select
			$("#cmbDistrito").trigger("liszt:updated");
		  },
		  error: function(objeto, quepaso, otroobj){
			alert("ERROR!! Pasó lo siguiente: "+quepaso);
		  }
	
		});
	}		
		
	
	
	
	</script>		
	
	
	
	
	
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
        if(!esValido("Nombre",form.txtNombre,"NombreAmbiente",1,1,50)){cadena[i]="Nombre";i++;}
        //if(!esValido("Descripci&oacute;n",form.txtDescripcion,"Descripcion",1,0,100)){cadena[i]="Descripci&oacute;n";i++;}
        //if(!esValido("Direccion",form.txtDireccion,"Direccion",1,1,50)){cadena[i]="Direccion";i++;}
        //if(!esValido("Telefono",form.txtTelefono,"Telefono",1,6,7)){cadena[i]="Telefono";i++;}
        //if(!esValido("Area_de_Terreno",form.txtAreaterreno,"Areaterreno",1,1,7)){cadena[i]="Area";i++;}
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
        document.getElementById("errNombreAmbiente").style.display='none';
        //document.getElementById("errDescripcion").style.display='none'; 
        //document.getElementById("errTelefono").style.display='none';
        //document.getElementById("errDireccion").style.display='none'; 
        //document.getElementById("errAreaterreno").style.display='none';
        //document.getElementById("errCaracteristica").style.display='none';    
} 
 
inicializa();
 
</script>
</body>
</html>
