 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />


<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/dynamic-select.js"></script>

<script>
function alt_submit(){
		var form= document.dynsel;
		if(validaForm()) form.submit();
			
}


function anhadirprod(cod,name){
	var form=document.dynsel;
	var cadena = "";
	var cod1 = "("; 
	var cod2 = ")";
	var cod3=cadena.concat(cod1,cod)
	var cod4 = cadena.concat(cod3,cod2);
	//form.txtProducto.value=name;
	//alert(name);
	
	form.title.value= cadena.concat(name,cod4);
	$.fn.colorbox.close();
}

 
 
 
function recargaproductos(val){   
	//esperando la carga... 
	$('#cmbProductos').html('<option value="">Cargando...aguarde</option>'); 
	//realizo la call via jquery ajax 
	$.ajax({ 
		url: '/procesar.php', 
		data: 'id='+val, 
		success: function(resp){ 
			$('#cmbProductos').html(resp) 
			} 
	}); 
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
			        <form class="form-horizontal"  name="dynsel" id="dynsel" method="Post"  action="SMVVentaProductos">
					<input type="hidden" name="accion" value="RegistrarVenta"></input>
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
			                  <input  type="text" class="span6 typeahead"   data-provide="typeahead"    name="title"  value   id="title"  readonly="readonly"  />
								 <br>
								<input type="button" name="clear"  value="X"  onclick='document.dynsel.title.value="";'  />
								<input type="button" name="add"  style="width:140px" value="Add to select" onclick="addoption()"  />
			                  
			                 <br> <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../producto/seleccionarproductoventa.jsp"> <i class="icon icon-search icon-white"></i> </a> </div>
			            
			                </div>
		                  </div>
            
 
							 <div class="control-group" id="dvProductos" >
								<label class="control-label" for="cmbProductos">Carrito:</label>
								<div class="controls">
								  <select name="select1" id="select1" style="width:180px" multiple onchange="selectoption();">
																																
								  </select>
								  </div>
							  </div>
 
<input type="button" name="del"  style="width:120px" value="Delete" onclick="deloption()"  />
<span  style="margin-left:16px" >Remove the selected option </span>

<br />
<br />

<input type="button" name="del2"  style="width:120px" value="Move up" onclick="moveup()"  />
<span  style="margin-left:16px" >Move up in the list the option  </span>
            


</td>
</tr>
</table>

   
							  
						                
			            </div>
			            <div class="form-actions">
			            <input type="hidden" name="idVentaProducto" value=""/></input>
			              <button type="submit" class="btn btn-primary" >Registrar Venta</button>
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