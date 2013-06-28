<!DOCTYPE html>

<%@page import="IngSoft.administracion.bean.ResultadoActividadBeanData"%>
<%@page import="IngSoft.administracion.bean.TipoActividadMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.MatriculaBeanData"%>
<%@page import="java.util.Vector"%>



<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Lista Matriculados</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<!--The beans  -->
	<jsp:useBean id="sedes" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tiposAmbiente" scope="request" class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	<jsp:useBean id="tipoactividades"  scope="request"class="java.util.Vector"></jsp:useBean>
        
        
	<jsp:useBean id="resultados2" scope="request"class="java.util.Vector"></jsp:useBean>
        

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
	<link rel="shortcut icon" href="img/favicon.ico">
		
	<script>
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
	function alt_eliminar(cod,cod2,cod3){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultarmatricula";
		form.codigoSoc.value=cod2;
		form.codigoFam.value=cod3;
		form.horario.value=cod;
		form.submit();
	}
	
 // validaciones fechas 
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
	
	
	</script>
        
        
        <%! public int  busarNumeroIncritos(String c, String h ,Vector<ResultadoActividadBeanData> r)
            {
            
            for(int i=0; i< r.size(); i++)
                {
                if(    ((ResultadoActividadBeanData)r.get(i)).getHorario().equals(h)  &&  ((ResultadoActividadBeanData)r.get(i)).getCodigo().equals(c)      )
                return  ((ResultadoActividadBeanData)r.get(i)).getInscritos()  ;
                }
                return 0;
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
                  <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span> </li>
                  <li><a href="buscarmatricula.jsp"> Mantenimiento de Actividad </a>/</span></li>
                    <li>
						Lista de Matriculados 
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">		
				
                
                <form id="frmAlternativo" name="frmAlternativo" method="post" action="<%= response.encodeURL("SMAActividad")%>">
				<input type="hidden" name="accion" value="Consultarmatricula"></input>
				<input type="hidden" name="codigoAct" value="<%=((MatriculaBeanData)resultados.get(0)).getCodigoActividad()%>"></input>
				<input type="hidden" name="codigoSoc" value="">  </input>
                <input type="hidden" name="codigoFam" value="">  </input>
				<input type="hidden" name="horario" value=""></input>
				<input type="hidden" name="tipo" value="2"></input>
				</form>	
				
				
				
				
                <div class="row-fluid sortable">
                  <div class="row-fluid sortable">
                    <div class="box span12">
                      <div class="box-header well" data-original-title>
                        <h2><i class="icon-th-list"></i> Actividad : <%= ((MatriculaBeanData)resultados.get(0)).getNombreAtc() %>
                        / Vacantes: <%= ((MatriculaBeanData)resultados.get(0)).getVacantes() %>
                         / Inscritos : <%= busarNumeroIncritos(    ((MatriculaBeanData)resultados.get(0)).getCodigoActividad() ,
                                             ((MatriculaBeanData)resultados.get(0)).getHorario() ,
                                                               resultados2
                                                               )
                             
                             
                             %>
                        </h2>
                      </div>
                      <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                         
                            
                            
                          <thead>
                            <tr>
                              <th>Nº</th>
                              <th>Nombre</th>
                              <th>Apellido Paterno</th>
                              <th>Apellido Materno</th>
                              <th>Acci&oacute;n</th>
                            </tr>
                          </thead>
                          <tbody id="resultadoBusqueda">
                          	<% for(int i=0; i<resultados.size(); i++) { %>
                            <tr>
                              <td class="center"><%= i+1%></td>
                              <td class="center"><%=((MatriculaBeanData)resultados.get(i)).getNombreSoc()%></td>
                              <td class="center"><%=((MatriculaBeanData)resultados.get(i)).getApaternoSoc()%></td>
                              <td class="center"><%=((MatriculaBeanData)resultados.get(i)).getAmaternoSoc()%></td>

                              
                              
                              
                              <td class="center">
											<a class="btn btn-danger" href="javascript:alt_eliminar('<%=((MatriculaBeanData)resultados.get(i)).getHorario()%>','<%=((MatriculaBeanData)resultados.get(i)).getCodigosocio()%>','<%=((MatriculaBeanData)resultados.get(i)).getCodigofamiliar()%>' )">
												<i class="icon-trash icon-white"></i> Eliminar
											</a>
							  </td>
							</tr>
                            <%}%>
                          </tbody>
                            
                        </table>
                          
                          
                          <div class="form-actions"  >
                              
                               <button type="button" class="btn" onclick="location.href='buscarmatricula.jsp'" >Regresar</button>
                          </div>
                          
                      </div>
                    </div>
                    <!--/span-->
                  </div>
                  <!--/span-->
                </div>
                <!--/span-->
			
			</div><!--/row-->
                
                
                
                
                

			<div class="row-fluid sortable"><!--/span--><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span--><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->
			</div><!--/row-->
    
					<!-- content ends -->
			</div><!--/#content.span10-->
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
	
		
</body>
</html>
