 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Vector"%>
<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.venta.bean.VentaBeanData"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script type="text/javascript" src="js/dynamicoptionlist.js"></script>



<!-- Bean-->
<jsp:useBean id="sedes" scope="request"class="java.util.Vector"></jsp:useBean>
<jsp:useBean id="productos" scope="request"class="java.util.Vector"></jsp:useBean>


<script>
function alt_submit(){
		var form= document.frmVentas;
		 if(validaForm())  form.submit();
			
}


function anhadirprod(cod,name){
	var form=document.frmVentas;
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
		url: '/procesar.html', 
		data: 'id='+val, 
		success: function(resp){ 
			$('#cmbProductos').html(resp) 
			} 
	}); 
	}  
 
 


function confFecha(){
	var form= document.frmVentas;
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
			        <form class="form-horizontal"  name="frmVentas" id="frmVentas" method="Post"  action="SMVVentaProductos">
					<input type="hidden" name="accion" value="Registrar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			          
			       		<div class="control-group" id="dvSede">
								<label class="control-label" for="selectError">Sede(*):</label>
								<div class="controls">
																						  
							 	<select  id="cmbSede" data-rel="chosen" name="cmbSede" >
								  
								  <%for(int i=0;i<sedes.size();i++) if( i!=0){     %>
										<option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>" >
										
										<%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%>
										
										
										</option>
									<%} else {   %>			
										<option selected value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>" >
										
										<%= ((SedeMiniBeanData)sedes.get(i)).getNombre()%>
										
										
										</option>
									<%}   %>				
								  </select>
								  <span class="help-inline" id="errSede">Please correct the error</span>
								</div>
							  </div>	            
			            
			            
			            <div class="control-group" id="dvFechaVenta">
			              <label class="control-label" for="typeahead7" name="fFechaInicio">Fecha Venta (*): </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker"  id="txtFechaVenta" name="txtFechaVenta" value="<%=fecAnoIni%>" readonly="readonly">
			              
			              </div>
		                </div>
			           
			              
			             			              
			              <div class="control-group" id="dvProducto">
								<label class="control-label" for="selectError">Producto(*):</label>
								<div class="controls">
																						  
							 	<select  id="cmbProducto" data-rel="chosen" name="cmbProducto">
								  		<%for(int j=0;j<productos.size();j++) if( j!=0){     %>
										<option value="<%= ((VentaBeanData)productos.get(j)).getIdProducto()%>" >
										
										<%= ((VentaBeanData)productos.get(j)).getProducto()%>
										
										
										</option>
									<%} else {   %>			
										<option selected value="<%= ((VentaBeanData)productos.get(j)).getIdProducto()%>" >
										
										<%= ((VentaBeanData)productos.get(j)).getProducto()%>
										
										
										</option>
									<%}   %>	
								  </select>
								  <span class="help-inline" id="errProducto">Please correct the error</span>
								</div>
							  </div>
							<div class="control-group" id="dvPrecioU">
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Precio Unitario (S/.): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge disabled"  id="txtPrecioU" name="txtPrecioU"  data-provide="typeahead" data-items="4" value="" onKeyUp="calcular()" >
		                    <span class="help-inline" id="errPrecioU">Please correct the error</span>
							</div>
		                  </div>
			            </div>
						
						<div class="control-group" id="dvCantidad">
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Cantidad: </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge disabled"  id="txtCantidad" name="txtCantidad"  data-provide="typeahead" data-items="4" value="" onKeyUp="calcular()" >
		                    <span class="help-inline" id="errCantidad">Please correct the error</span>
							</div>
		                  </div>
			            </div>
						
						<div class="control-group" >
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Subtotal (S/.): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge disabled" disabled="" id="txtSubtotal0" name="txtSubtotal0"  data-provide="typeahead" data-items="4" value="" >
		                    </div>
		                  </div>
			            </div>
 

            


</td>
</tr>
</table>

   
							  
						                
			            </div>
			            <div class="form-actions">
			            <input type="hidden" name="idVentaProducto" value=""/></input>
						<input type="hidden" name="txtSubtotal" value=""/></input>
						<button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Registrar Venta</button>
			            
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
			 
<script>
function calcular(){
form=document.frmVentas;
if(form.txtCantidad.value<=0) form.txtCantidad.value=1;
if(form.txtPrecioU.value<0) form.txtPrecioU.value=0;
form.txtSubtotal0.value=form.txtCantidad.value*form.txtPrecioU.value;
form.txtSubtotal.value=form.txtSubtotal0.value;

}
</script>
       
					<!-- content ends -->