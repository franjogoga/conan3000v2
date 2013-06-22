 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmMembresia;
		if(validaForm()) form.submit();
			
}


function anhadirprod(cod,name){
	var form=document.frmVentaProductos;
	var cadena = "";
	var cadigo= cod;
	var nombre = name;
	//form.idProducto.value=cod;
	form.txtProducto.value= cadena.concat(name,cod);
	$.fn.colorbox.close();
}

 

function confFecha(){
	var form= document.frmMembresia;
	if(form.cmbPeriodo.value=="Anual"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[2]=parseInt(fechaI[2])+1;
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Semestral"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[1]=parseInt(fechaI[1])+6;
		if(fechaI[1]>12){
			fechaI[2]=parseInt(fechaI[2])+1;
			fechaI[1]=parseInt(fechaI[1])-12;
		}
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Indefinido"){
	document.getElementById("dvFechaFin").style.display='block';
	}
	
}
</script>

<%
Calendar c1 = GregorianCalendar.getInstance();
c1.add(Calendar.YEAR, 1);
SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecAnoIni=dfActual.format(new java.util.Date());

String fecAnoFin=dfActual.format(c1.getTime()); %>
<!-- content starts -->
			  <div>
			   <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarventaproducto.jsp">Mantenimiento de venta de Productos</a> <span class="divider">/</span></li>
		        <li> Registrar Venta de Productos</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR VENTA DE PRODUCTOS </h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmVentaProductos" method="Post"  action="SMVVentaProductos">
					<input type="hidden" name="accion" value="Registrar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			          
			          <div class="control-group" id="dvVendedor">
			                <label class="control-label" for="typeahead4">Vendedor (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="txtVendedor" name="txtVendedor"  data-provide="typeahead">
			                  
			                </div>
		                 </div>
			            
			              <div class="control-group" id="dvCliente">
			                <label class="control-label" for="typeahead4">Cliente (*): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="txtCliente" name="txtCliente"  data-provide="typeahead">
			                  
			                </div>
		                 </div>
			            
			            
			            <div class="control-group" id="dvFechaVenta">
			              <label class="control-label" for="typeahead7" name="fFechaInicio">Fecha Venta (*): </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker"  id="txtFechaVenta" name="txtFechaVenta" value="<%=fecAnoIni%>" readonly="readonly">
			              
			              </div>
		                </div>
			           
			              
			              <div class="control-group" id="dvProducto">
			                <label class="control-label" for="typeahead8">Producto (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead"   data-provide="typeahead" id="txtProducto"  name="txtProducto" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../producto/seleccionarproductoventa.jsp"> <i class="icon icon-search icon-white"></i> </a> </div>
			            
			                </div>
		                  </div>
                          
                          
                                                 
                          
                          
                          <div class="control-group" id="dvMonto">
			                <label class="control-label" for="typeahead4">Monto (S/.): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge" id="txtMonto" name="txtMonto"  data-provide="typeahead" >
			                  
			                </div>
		                  </div>
                 
			            </div>
			            <div class="form-actions">
			            <input type="hidden" name="idVentaProducto" value=""/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>
			              <button type="button" class="btn" onclick="location.href='buscarventaproducto.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		            
		            </form>
		          (*) Datos Obligatorios</div>
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
			 

		<script>confFecha();</script>  
       
					<!-- content ends -->