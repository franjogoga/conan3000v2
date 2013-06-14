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
	<jsp:useBean id="egreso" scope="request"class="IngSoft.venta.bean.EgresoBeanData"></jsp:useBean>	
 <!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			     <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscaregreso.jsp">Egresos</a> <span class="divider">/</span></li>
		        <li> Ver Egreso </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>VER EGRESO</h2>
		          </div>
			      <div class="box-content">
			         <form class="form-horizontal"  name="frmDelete" method="Post"  action="SMVPago">
					<input type="hidden" name="codigo" value="<%=egreso.getIdEgreso()%>"></input>
			        <input type="hidden" name="accion" value="Eliminar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			          
			          <div class="control-group">
			              <label class="control-label" for="typeahead8">Descripci&oacute;n: </label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead disabled" disabled="" id="typeahead8" name="txtDescripcion" id="txtDescripcion" data-provide="typeahead" data-items="4" value="<%=egreso.getDescripcion()%>">
			              </div>
		                </div>
                        <div class="control-group">
                            <label class="control-label" for="typeahead2">Fecha: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" disabled="" id="date" value="<%=formatear(new Date(egreso.getFechaPago().getTime()))%>">
                              
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="typeahead2">Monto: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge disabled" disabled="" id="txtMonto" name="txtMonto" value="<%=egreso.getMontoTotal()%>" >
                            </div>
                        </div>
			          
			          
			            <div class="form-actions">
			              <button type="reset" class="btn" onClick="javascript:history.back();">Regresar</button>
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