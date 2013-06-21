  <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script>
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmPago;
		if(validaForm()) form.submit();
			
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
	<jsp:useBean id="ordenPago" scope="request"class="IngSoft.venta.bean.OrdenPagoBeanData"></jsp:useBean>	
<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
			      <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpagootros.jsp">Pago de Otros Servicios</a> <span class="divider">/</span></li>
		        <li> Registrar Pago de Otros Servicios </li>
		        </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>REGISTRAR PAGO DE OTROS SERVICIOS</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal"  name="frmPago" method="Post"  action="SMVPago">
					<input type="hidden" name="codigo" value="<%=ordenPago.getIdOtroIngreso()%>"></input>
			        <input type="hidden" name="accion" value="AgregarOrdenPago"></input>
					<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			           <div class="control-group">
			              <label class="control-label" for="typeahead8">Socio: </label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead disabled" id="typeahead8"  data-provide="typeahead" data-items="4"  value="<%=ordenPago.getSocio()%>" disabled="" >
			              </div>
		                </div>
                        <div class="control-group">
			                <label class="control-label" for="typeahead4">C&oacute;digo de Socio: </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead disabled" id="typeahead4" value="<%=ordenPago.getIdSocio()%>" data-provide="typeahead" data-items="4" disabled="" >
		                    </div>
		                  </div>
                        <div class="control-group">
                            <label class="control-label" for="typeahead2">Fecha de Vencimiento: </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date" value="<%=formatear(new Date(ordenPago.getFechaVencimiento().getTime()))%>" disabled="">
                            </div>
                        </div>
<div class="control-group">
          <label class="control-label" for="typeahead7">Fecha de Emision: </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge datepicker" id="fFechaPago" name="fFechaPago" value="<%=formatear(new Date(ordenPago.getFechaEmision().getTime()))%>"  onpaste="return false;" disabled="" >
		                  </div>
		                </div>
		                
		                <div class="control-group">
          <label class="control-label" for="typeahead7">Fecha de Pago: </label>
			              <div class="controls">
			                <input type="text" class="input-xlarge" id="fFechaPago" name="fFechaPago" value="<%=fecHoy%>"  onpaste="return false;" readOnly="true">
		                  </div>
		                </div>
		                
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Monto (S/.): </label>
			                <div class="controls">
			                  <input type="text" class="input-xlarge disabled" disabled="" id="txtMonto" name="txtMonto"  data-provide="typeahead" data-items="4" value="<%=ordenPago.getMonto()%>" >
		                    </div>
		                  </div>
			            </div>
			           
			           
			            <div class="form-actions">
			            <input type="hidden" name="idOtroIngreso" value="<%=ordenPago.getIdOtroIngreso() %>"/></input>
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Pagar</button>
			              <button type="button" class="btn" onclick="location.href='buscarpago.jsp'">Cancelar</button>
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
			 