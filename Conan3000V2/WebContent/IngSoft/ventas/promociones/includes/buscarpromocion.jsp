<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoPromocionBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Date"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmCriteriosBusqueda;
		if(validaForm()) form.submit();
			
			}
	

	
	function alt_agregar(){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Agregar";
		form.submit();
	}
	
	function alt_consultar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Consultar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_modificar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Modificar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_eliminar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Eliminar";
		form.codigo.value=cod;
		form.submit();
	}
	
	function verificar_fecha(comparacion,fecha1,fecha2){
		var fec1=fecha1.value.split("/");
		var fec2=document.getElementById(fecha2).value.split("/");
		var test=true;
		if(fec1.length==fec2.length) {
			var size=fec1.length;
			var a='';
			var b='';	
			for(i=size-1;i>=0;i--){
				a=a.concat(fec1[i]);
				b=b.concat(fec2[i]);
				}
			if(comparacion==0){
				if(parseInt(a)==parseInt(b))  test=false;
				}
			if(comparacion==1){
				if(parseInt(a)<=parseInt(b))   test=false;
				}
			if(comparacion==-1){
				if(parseInt(a)>=parseInt(b) )  test=false;
				}
			if(test){			
					fecha1.value=document.getElementById(fecha2).value;			
				}
				
			} 
		else{
			alert("Error al comparar fechas");
		}			
	}

	</script>	

<%! 	
public String getFechaActual(){
	SimpleDateFormat DF= new SimpleDateFormat("dd/MM/YYYY");
	Date fecha= new Date();
return (DF.format(fecha));
}	
%>


<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>

	<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
	</noscript>
<!-- content starts -->

			  <div>		       
		        <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Buscar Promoci&oacute;n</li>
	          </ul>
		      </div>
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>BUSCAR PROMOCION</h2>
		          </div>
			      <div class="box-content">
						         
			         	<form class="form-horizontal" name="frmCriteriosBusqueda"  id="frmCriteriosBusqueda"   method="Post"  action="<%= response.encodeURL("SMVPromocion")%>" onsubmit="alt_submit();return false;" >
						<input type="hidden" name="accion" id="accion" value="Buscar" ></input>
						<input type="hidden" name="tipo" id="tipo" value="2" ></input>
			         
			         
			         
			          <fieldset>
			          
			            <div class="control-group">
			              <div class="control-group">
			                <div class="control-group">
			                  <label class="control-label" for="typeahead2">Nombre de Promoci&oacute;n:</label>
			                  <div class="controls">
			                    <input type="text" class="span6 typeahead" id="txtNombrePromocion"  name="txtNombrePromocion" data-provide="typeahead" >
		                      </div>
		                    </div>
		                     
			                  <div class="control-group" id="dvFechaInicio">
			              <label class="control-label" for="date01">Fecha de inicio(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechInicio" class="datepicker" id="fFechInicio" value="<%=getFechaActual()%>"  readonly width=44px  onchange="verificar_fecha(1,this,'fFechFin');">
			                  <span class="help-inline" id="errFechaInicio">Please correct the error</span>
		                    </div>
		                  </div>
			              <div class="control-group" id="dvFechaFin">
			                <label class="control-label" for="date02">Fecha de fin(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechFin" class="datepicker" id="fFechFin" value="<%=getFechaActual()%>"  readonly width=44px  onchange="verificar_fecha(-1,this,'fFechInicio');">
			                  <span class="help-inline" id="errFechaFin">Please correct the error</span>
		                    </div>
		                  </div>
			          
			              
								<div class="control-group">
								<label class="control-label" for="typeahead3">Estado</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="activo" checked="checked">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Inactivo">
									Inactivo
								  </label>
								</div>
							  </div>
			            </div>
			            <div class="form-actions">
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Buscar</button>
			              <button type="button" class="btn"><a href="buscarpromocion.jsp">Cancelar</a></button>
			            
		                </div>
		              </fieldset>
		            </form>
		          </div>
		        </div>
			    <!--/span-->
		     
		      <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVPromocion")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
		      
		      
			  <div class="row-fluid sortable">
			    <!--/span-->
                <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>RESULTADOS</h2>
		          </div>
		          
			      <div class="box-content">
			      <table class="table table-striped table-bordered bootstrap-datatable datatable" >
					    <!-- agregar nuevo boton -->
					    <div  align="right">
					     <a class="btn btn-primary" href="javascript:alt_agregar()"> <i class="icon icon-add icon-white"></i> Agregar </a> 
					     </div>
					     
					    <thead>
					      <tr>
					        <th>Nombre</th>
					        <th>Fecha de incio</th>
					        <th>Fecha de fin</th>
					        <th>Estado</th>
					        <th>Acci&oacute;n</th>
				          </tr>
				          
				        </thead>
				        
				        <element>
					    <tbody id="resultadobusqueda">
					    
					    <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
                         
					      <tr>
					        
					        <td class="center">
                          				<%=
                          					((ResultadoPromocionBeanData)resultados.get(i)).getNombre()
                          				%>
                          </td>
                          
                          
					        
					       <td class="center">
                          				<%=
                          					df.format(((ResultadoPromocionBeanData)resultados.get(i)).getLimInicio())
                          				%>
                          </td>
                          
                           <td class="center">
                          				<%=
                          					df.format(((ResultadoPromocionBeanData)resultados.get(i)).getLimFin())
                          				%>
                          </td>
                          
                          <td class="center">
                          				<%=
                          					((ResultadoPromocionBeanData)resultados.get(i)).getEstado()
                          				%>
                          </td>
                          
                          <td class="center">
                          				<a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-zoom-in icon-white">
                          					</i>
Ver
                          				</a>
                          				<a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i
                          						class="icon-edit icon-white">
                          					</i>
 Modificar
                          				</a>
                          				<a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoPromocionBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-trash icon-white">
                          					</i>
		Eliminar
                          				</a>
                          			</td>
                          	</tr>
                          	
					        <%}%>
					       </tbody>
					       </element>
					       </table>     
                  </div>
				</div><!--/span-->
				
				
			</div><!--/row-->
			
    
					<!-- content ends -->
				</div><!--/fluid-row-->
						
		<hr>
			

		<jsp:include page="/IngSoft/general/inferior.jsp" />
		
			

		  
<!-- content ends -->