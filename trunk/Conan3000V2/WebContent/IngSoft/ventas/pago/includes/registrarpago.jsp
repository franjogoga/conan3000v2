<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
function alt_submit(){
		var form= document.frmPago;
		if(validaForm()) form.submit();
			
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

<!--The beans  -->
	<jsp:useBean id="pago" scope="request"class="IngSoft.venta.bean.PagoBeanData"></jsp:useBean>	
 <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> Registrar Pago de Membres&iacute;a </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR PAGO  DE MEMBRESIA</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmPago" method="Post"  action="SMVPago">
			          <fieldset>
			            <div class="control-group">
			              <label class="control-label" for="typeahead8">Socio: </label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead disabled" id="typeahead8"  data-provide="typeahead" data-items="4"  value="<%=pago.getSocio()%>" disabled="" >
			              </div>
		                </div>
                        <div class="control-group">
			                <label class="control-label" for="typeahead4">C&oacute;digo de Socio: </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead disabled" id="typeahead4" value="<%=pago.getIdSocio()%>" data-provide="typeahead" data-items="4" disabled="" >
		                    </div>
		                  </div>
                        <div class="control-group">
                            <label class="control-label" for="typeahead2">Fecha de Vencimiento: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date" value="<%=formatear(new Date(pago.getFechaVencimiento().getTime()))%>" disabled="">
                            </div>
                        </div>
<div class="control-group">
          <label class="control-label" for="typeahead7">Fecha de Pago: </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker" id="fFechaPago" name="fFechaPago" value="<%=fecHoy%>"  onpaste="return false;">
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Monto (S/.): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge disabled" disabled="" id="txtMonto" name="txtMonto"  data-provide="typeahead" data-items="4" value="<%=pago.getMonto()%>" >
		                    </div>
		                  </div>
			            </div>
			            
			            <div class="form-actions">
			              <input type="hidden" name="idCuota" value="<%=pago.getIdCuota() %>"/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Modificar</button>
			              <button type="button" class="btn" onclick="location.href='buscarpago.jsp'">Cancelar</button>
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
			 