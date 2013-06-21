<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmPago;
		if(validaForm()) 
			form.submit();
			
}

function anhadir(cod, name){
	var form= document.frmPago;
	form.txtSocio.value=name;
	form.idSocio.value=cod;
	$.fn.colorbox.close();
	
} 

function confFecha(){
	var form= document.frmPago;
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

<%! public boolean  encontrar(String a, String[] b){
		for(int i=0;i<b.length;i++){			
			if(b[i].equals(a)) return true;	
		}
	return false;
	}
	public String formatear(java.util.Date date){
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM/YYYY");
		return DF.format(date);
	}
	
	public String generarCadena(String[] t){
		String a="";
		for(int i=0;i<t.length;i++)
			a= a.concat(t[i]+"/");
			if(a.length()>0) a=a.substring(0, a.length()-1);
		return a;
	}
	%>

<%

SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecHoy=dfActual.format(new java.util.Date());

 %>
<script src="../servicio/evento/evento.js"></script>
	
 <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> Registrar Cuota Extraordinaria </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR CUOTA EXTRAORDINARIA</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmPago" method="Post"  action="SMVPago">
			        <input type="hidden" name="accion" value="AgregarCuotaExtraordinaria"></input>
			        <input type="hidden" name="fFechaPago" value="<%=fecHoy%>"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			          
			          <div class="control-group" id="dvSocio">
			                <label class="control-label" for="typeahead8">Socio (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" name="txtSocio" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../socio/seleccionarsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Socio</a> </div>
			                  <span class="help-inline" id="errSocio">Please correct the error</span>
			                </div>
		                  </div>
			          
			            <div class="control-group"  id="dvDescripcion">
			              <label class="control-label" for="typeahead8">Descripci&oacute;n: (*)</label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead disabled" id="typeahead8" name="txtDescripcion" id="txtDescripcion" data-provide="typeahead" data-items="4" onkeypress="return alfanumerico(event);" autofocus maxlength="100">
			                <span class="help-inline" id="errDescripcion">Please correct the error</span>
			              </div>
		                </div>
                        <div class="control-group" >
                            <label class="control-label" for="typeahead2">Fecha: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date" value="<%=fecHoy%>" disabled="">
                             
                            </div>
                        </div>
                        <div class="control-group" id="dvMonto">
                            <label class="control-label" for="typeahead2">Monto: (*)</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge" id="txtMonto" name="txtMonto" value="" >
                            <span class="help-inline" id="errMonto">Please correct the error</span>
                            </div>
                        </div>
                        
			            <div class="form-actions">
			            <input type="hidden" name="idSocio" value=""/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar Cuota</button>
			              <button type="button" class="btn" onclick="location.href='buscaregreso.jsp'">Cancelar</button>
		                </div>
		                </div>
		              </fieldset>
		            </form>(*) Datos Obligatorios
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
			 