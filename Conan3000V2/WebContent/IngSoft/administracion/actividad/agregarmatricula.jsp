<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.ActividadBeanData"%>
<%@page import="IngSoft.administracion.bean.SedeBeanData"%>
<%@page import="IngSoft.administracion.bean.AmbienteBeanData"%>
<%@page import="IngSoft.administracion.bean.TipoActividadMiniBeanData"%>

<%@page import="IngSoft.administracion.bean.ResultadoHorariodeactividadBeanData"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Consultar Horario de Actividad</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!--The beans  -->
<jsp:useBean id="actividad" scope="request"class="IngSoft.administracion.bean.ActividadBeanData"></jsp:useBean>
<jsp:useBean id="sedes"           scope="request"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="ambientes"       scope="request"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="tipoactividades"  scope="request"class="java.util.Vector"></jsp:useBean>

<jsp:useBean id="resultados" scope="request" class="java.util.Vector"></jsp:useBean>



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


function anhadirSocio(cod, name,puesto){
var form= document.frmData;
form.nombresocio.value=name;
form.codigosocio.value=cod;
$.fn.colorbox.close();

}

function anhadirFamiliar(cod, name,puesto){
	var form= document.frmData;
	form.nombrefamiliar.value=name;
	form.codigofamiliar.value=cod;
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
    
// if(validaForm())
	form.submit();
    
    
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
<li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span> </li>
<li> <a href="buscarmatricula.jsp">Matricula de Actividad </a> <span class="divider">/</span></li>
<li>  Consultar de Horario de Actividad </li>
</ul>
</div>
<div class="row-fluid sortable">
<div class="box span12">
<div class="box-header well" data-original-title>
<h2><i class="icon-plus-sign"></i> CONSULTAR HORARIO DE ACTIVIDAD</h2>
</div>
<div class="box-content">
<form class="form-horizontal" action="<%= response.encodeURL("SMAActividad")%>" name="frmData" method="post">
<input type="hidden" name="accion" value="Agregarmatricula"></input>
<input type="hidden" name="tipo" value="2"></input>
<fieldset>

    
    
    
    
    
    
    
    
    
    
    <!--- ------------  -->
    
    
    <div class="control-group">
        <label class="control-label" for="typeahead7">Nombre: </label>
        <div class="controls">
            <input type="text" class="span6 typeahead" id="txtNombre"  data-provide="typeahead"  name="txtNombre" disabled value=" <%=((ResultadoHorariodeactividadBeanData)resultados.get(0)).getNombre()%>">
                <input type="hidden" name="codigoActividad" value="<%=((ResultadoHorariodeactividadBeanData)resultados.get(0)).getCodigo()%>"></input>
                 <input type="hidden" name="monto" value="<%=((ResultadoHorariodeactividadBeanData)resultados.get(0)).getMonto()%>"></input>
                <!--- ------------  -->
                
                <!--  	<div class="row-fluid sortable"> -->
                
                <div class="control-group">
                    
                    <div class="box span6">
                        <div class="box-header well" data-original-title>
                            <h2>Horario </h2>
                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                                
                            </div>
                        </div>
                        <div class="box-content">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th> </th>
                                        <th></th>
                                        
                                    </tr>
                                </thead>
                                
                                
                                <tbody>
                                    
                                    <%
                                        
                                        
                                        for (int i = 0; i < resultados.size(); i++) {
                                            
                                        %>
                                    
                                    <tr>
                                        <td>
                                            
                                            <label class="checkbox inline">
                                                <input type="checkbox"  id="inlineCheckbox<%=i%>" name="checkDia<%=i%>"   value="<%=((ResultadoHorariodeactividadBeanData)resultados.get(i)).getHorario()%>  ">
                                                    
                                                    </label>
                                            
                                        </td>
                                        
                                        
                                        <td >
                                            
                                            <%= ((ResultadoHorariodeactividadBeanData)resultados.get(i)).getDiaSemana() %>
                                            
                                            
                                        </td>
                                        
                                        
                                        
                                    </tr>
                                    
                                    <%
                                        
                                        
                                        }%>
                                    
                                </tbody>
                                
                            </table>
                          
                            
                        </div>
                    </div><!--/span-->
                    
                </div><!--/row-->
                
                
                
                
                
                
                
                
                <!-- --------    codigoActividad  checkDia codigosocio  codigofamiliar  monto   -->
                </div><!-- fin controls -->
        
        
        
        
        <div class="control-group"  id="dvNombresocio">
            <label class="control-label" for="typeahead7">Socio(*): </label>
            <div class="controls">
                <input type="text" class="span6 typeahead" id="nombresocio"  data-provide="typeahead"  name="nombresocio" disabled value="">
                 <input type="hidden" name="codigosocio" value=""> </input>
                    <span class="help-inline" id="errNombresocio">Please correct the error</span>
                 </div>
        </div>
        
        
        
        <div class="control-group" id="dvSocio">
            
            <div class="controls">
                
                <div  align="left"> <a class="btn btn-primary iframe" href="seleccionarsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Socio</a> </div>
                <span class="help-inline" id="errSocio"></span>
            </div>
        </div>
        
        
        <div class="control-group" id="dvNombreFamiliar">
            <label class="control-label" for="typeahead7">Familiar(*): </label>
            <div class="controls">
                <input type="text" class="span6 typeahead" id="nombrefamiliar"  data-provide="typeahead"  name="nombrefamiliar" disabled value="">
                <input type="hidden" name="codigofamiliar" value="">  </input>
                    <span class="help-inline" id="errNombrefamiliar">Please correct the error</span>
                </div>
        </div>
        
        
        
        <div class="control-group" id="dvSocio">
            
            <div class="controls">
                
                <div  align="left"> <a class="btn btn-primary iframe" href="seleccionarfamiliar.jsp"> <i class="icon icon-search icon-white"></i> Buscar Familiar</a> </div>
                <span class="help-inline" id="errSocio"></span>
            </div>
        </div> 
        
        <!-- ---------------------------------------------------- -->
        
    
    
    
    








    
    
    
    








<input type="hidden" name="optionsRadios" value="Disponible"></input>


<div class="form-actions">
<button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
<button type="button" class="btn" onclick="location.href='buscarmatricula.jsp'" >Cancelar</button>
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
<button type="button" class="close" data-dismiss="modal">√ó</button>
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
 2: ValidaciÛn de cantidad de caracteres de fecha
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
//if(!esValido("Nombre Socio",form.nombresocio,"Nombresocio",1,1,50)){cadena[i]="Nombre Socio";i++;}
//if(!esValido("Nombre Familiar",form.txtDescripcion,"Nombrefamiliar",1,0,50)){cadena[i]="Nombre Familiar";i++;}
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
//document.getElementById("errNombresocio").style.display='none';
//document.getElementById("errNombrefamiliar").style.display='none';
//document.getElementById("errCaracteristica").style.display='none';
}

inicializa();

</script>
</body>
</html>
