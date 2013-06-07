 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar esta membresia?");
		if(r==true){form.submit();}
			}	


function anhadir(cod, name){
	var form= document.frmMembresia;
	form.txtSocio.value=name;
	form.idSocio.value=cod;
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
 <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			     <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpagootros.jsp">Pago de Otros Servicios</a> <span class="divider">/</span></li>
		        <li> Eliminar Pago de Membres&iacute;a </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>ELIMINAR PAGO DE MEMBRESIA</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmDelete" method="Post"  action="SMVPago">
					<input type="hidden" name="codigo" value="<%=pago.getIdCuota()%>"></input>
			        <input type="hidden" name="accion" value="Eliminar"></input>
					<input type="hidden" name="tipo" value="2"></input>
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
			                <input type="text" class="input-xlarge datepicker" id="fFechaPago" name="fFechaPago" value="<%=fecHoy%>"  onpaste="return false;" disabled="" >
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
			              <button type="submit" class="btn btn-primary" onclick="javascript:alt_submit()">Eliminar</button>
			              <button type="reset" class="btn" onclick="location.href='buscarpago.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		            </form>
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