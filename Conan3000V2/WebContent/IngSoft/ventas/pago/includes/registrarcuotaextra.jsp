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

function actualizarHidden(){
var form= document.frmPago;
form.fFechaEmision0.value=form.fFechaEmision.value;
form.fFechaVencimiento0.value=form.fFechaVencimiento.value;
}

function comprueba(obj){ 
if (isNaN(obj.value)){ 
obj.value=1; 
} else{
if(obj.value==0) obj.value=1;
}

}

function entero(obj){

var patron = /^\d*$/;                    
var numero = 10;                                    
if ( !patron .test(obj.value)) {         

obj.value=1;
}else {



}
}

function redondeo2decimales(numero) {
var original = parseFloat(numero);
var result = Math.round(original * 100) / 100;
return result;
}

function actualizarMonto(){
var form= document.frmPago;
form.txtTotalxCuota0.value=redondeo2decimales(form.txtMonto.value/form.txtCuota.value);
form.txtMontoxCuota.value=form.txtTotalxCuota0.value;
}


      function compare_dates(fecha, fecha2)
      {
        var xMonth=fecha.substring(3, 5);
        var xDay=fecha.substring(0, 2);
        var xYear=fecha.substring(6,10);
        var yMonth=fecha2.substring(3, 5);
        var yDay=fecha2.substring(0, 2);
        var yYear=fecha2.substring(6,10);
        if (xYear> yYear)
        {
            return(true)
        }
        else
        {
          if (xYear == yYear)
          { 
            if (xMonth> yMonth)
            {
                return(true)
            }
            else
            { 
              if (xMonth == yMonth)
              {
                if (xDay> yDay)
                  return(true);
                else
                  return(false);
              }
              else
                return(false);
            }
          }
          else
            return(false);
        }
    }

function verificarFecha2(fechaInicio,fechaFin){

if (compare_dates(fechaInicio.value, fechaFin.value)){
  fechaFin.value=fechaInicio.value;
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
			          <div class="control-group" id="dvPeriodo">
                            <label class="control-label" for="selectError">Periodo Pago (*):</label>
                            <div class="controls">
                              <select  id="cmbPeriodo" data-rel="chosen" name="cmbPeriodo" class=''>
								<option value="Mensual">Mensual</option>
								<option value="Bimestral">Bimestral</option>
								<option value="Trimestral">Trimestral</option>
								<option value="Semestral">Semestral</option>
                                <option value="Anual">Anual</option>
                              </select>
                              <span class="help-inline" id="errPeriodo">Please correct the error</span>
                            </div>
                          </div>
						  
			          <div class="control-group" id="dvSocio">
			                <label class="control-label" for="typeahead8">Socio (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="typeahead8"  data-provide="typeahead" name="txtSocio" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="seleccionarsocio.jsp"> <i class="icon icon-search icon-white"></i> Buscar Socio</a> </div>
			                  <span class="help-inline" id="errSocio">Please correct the error</span>
			                </div>
		                  </div>
			          <div class="control-group" id="dvMonto">
                            <label class="control-label" for="typeahead2">Monto Total: (*)</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge" id="txtMonto" name="txtMonto" value="" onKeyUp="comprueba(this);actualizarMonto();" onChange="actualizarMonto()">
                            <span class="help-inline" id="errMonto">Please correct the error</span>
                            </div>
                        </div>
						<div class="control-group" id="dvFechaEmision">
                            <label class="control-label" for="typeahead2">Fecha de Emisi&oacute;n: (*)</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date" name="fFechaEmision" value="<%=fecHoy%>" disabled="" onChange="verificarFecha2(this,document.frmPago.fFechaVencimiento);actualizarHidden();">
                            <span class="help-inline" id="errFechaEmision">Please correct the error</span>
							</div>
                        </div>
						<div class="control-group" id="dvFechaVencimiento">
                            <label class="control-label" for="typeahead2">F. de Venc. (1ra cuota): (*) </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date2" name="fFechaVencimiento" value="<%=fecHoy%>" readonly="true" onChange="verificarFecha2(document.frmPago.fFechaEmision,this);actualizarHidden();">
                            <span class="help-inline" id="errFechaVencimiento">Please correct the error</span>
							</div>
                        </div>
			            <div class="control-group"  id="dvDescripcion">
			              <label class="control-label" for="typeahead8">Descripci&oacute;n: (*)</label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead disabled" id="typeahead8" name="txtDescripcion" id="txtDescripcion" data-provide="typeahead" data-items="4" onkeypress="return alfanumerico(event);" autofocus maxlength="100">
			                <span class="help-inline" id="errDescripcion">Please correct the error</span>
			              </div>
		                </div>
						<div class="control-group" id="dvCuota">
                            <label class="control-label" for="typeahead2">Cant. de Cuotas: (*)</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge" id="txtCuota" name="txtCuota" value="1" onKeyUp="entero(this); actualizarMonto();"  onKeyPress="entero(this);" onChange="actualizarMonto()">
                            <span class="help-inline" id="errCuota">Please correct the error</span>
                            </div>
                        </div>
						
                        <div class="control-group" id="dvMontoCuota" >
                            <label class="control-label" for="typeahead2">Monto por Cuota: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="txtMontoxCuota" value="" disabled="">
                             <span class="help-inline" id="errMontoCuota">Please correct the error</span>
                            </div>
                        </div>
                        
                        
			            <div class="form-actions">
			            <input type="hidden" name="idSocio" value="">
						<input type="hidden" name="fFechaEmision0" value="<%=fecHoy%>">
						<input type="hidden" name="fFechaVencimiento0" value="<%=fecHoy%>">
						<input type="hidden" name="txtTotalxCuota0" value="">
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Agregar Cuota</button>
			              <button type="button" class="btn" onclick="location.href='buscarpagootros.jsp'">Cancelar</button>
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
			 