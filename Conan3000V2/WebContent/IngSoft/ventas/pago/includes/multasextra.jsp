<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.venta.bean.ResultadoSocioBeanData"%>
<%@page import="java.util.Vector"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
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

	
	</script>	
<%

SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecHoy=dfActual.format(new java.util.Date());

 %>
<!--The beans  -->
<jsp:useBean id="cantidad" scope="request" class="java.lang.String"></jsp:useBean>
	
			<!-- content starts -->

			<div class="row-fluid sortable">
				
			<!-- content starts -->
			

			
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-search"></i> FORMULARIO DE MULTAS POR CUOTA EXTRAORDINARIA			  </h2>
                        <div class="box-icon">
							
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
						</div>
                        
                        
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmMulta" id="frmMulta"  method="POST" action="<%= response.encodeURL("SMVPago")%>">
						   <input type="hidden" name="accion" value="AplicarMultaExtra"/></input>
						  <input type="hidden" name="tipo" value="2"></input>
						  <fieldset>
						    <div class="control-group">
						    
						     <div class="control-group">
							    <label class="control-label" for="typeahead6">Cant. de Cuotas: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" disabled="" id="txtCantidad" name="txtCantidad" data-provide="typeahead" data-items="4" value="<%=cantidad%>" >
						        </div>
						      </div>
						<div class="control-group" id="dvFechaActual">
                            <label class="control-label" for="typeahead2">Fecha:(*) </label>
                            <div class="controls">
                              <input type="text" class="input-xlarge datepicker disabled" id="date2" name="fFechaActual" value="<%=fecHoy%>" readonly="true">
                            
							</div>
                        </div>
							  <div class="control-group">
							    <label class="control-label" for="typeahead6">% Multa: </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtMulta" name="txtMulta" onKeyUp="entero(this);"  data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
							  
							 
                              

						    </div>
						    <div class="form-actions">
						    <button type="submit" class="btn btn-primary">Aplicar Multas</button>
						    
							</div>
						  </fieldset>
					  </form>   

				  </div>
				</div><!--/span-->

			</div><!--/row-->

    
					<!-- content ends -->
			</div><!--/span-->
			
			
			  

                
        
					<!-- content ends -->
			</div>
                
                
         