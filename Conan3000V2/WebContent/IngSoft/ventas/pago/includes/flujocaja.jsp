 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoFlujoCajaBeanData"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.GregorianCalendar"%>

<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
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
	function alt_Pagar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Pagar";
		form.codigo.value=cod;
		form.submit();
	}
	function alt_Multas(cod){
	
	
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AplicarMultas";
		form.codigo.value=cod;
		form.submit();
	}
	
	function ocultar(id){
		document.getElementById(id).style.display='none';
		
	}
	function mostrar(id){
		document.getElementById(id).style.display='block';
		
	}
	
	function verificar(){
		
		var total,valor;
		total=document.getElementsByName('rButton').length;
		 
		for (var i=0;i<total;i++){
		valor=document.getElementsByName('rButton').item(i).checked;
		 
		if (valor){
			nom=document.getElementsByName('rButton').item(i).value;
			if(nom=='Cancelado'){
				ocultar("fechaEmision");
				mostrar("fechaPago");
				
			}else{
				ocultar("fechaPago");
				mostrar("fechaEmision");
				
			}
		}
		 
		 
		}
		
	}
	
	
	
	function igualarIni(tipo){
		if(tipo==2)
		document.frmCriteriosBusqueda.fFechaPagoIni.value=document.frmCriteriosBusqueda.fFechaVencimientoIni.value;
		else
		document.frmCriteriosBusqueda.fFechaVencimientoIni.value=document.frmCriteriosBusqueda.fFechaPagoIni.value;
	}
	
	function igualarFin(tipo){
		if(tipo==2)
		document.frmCriteriosBusqueda.fFechaPagoFin.value=document.frmCriteriosBusqueda.fFechaVencimientoFin.value;
		else
		document.frmCriteriosBusqueda.fFechaVencimientoFin.value=document.frmCriteriosBusqueda.fFechaPagoFin.value;
	}
	
	</script>	
<%

SimpleDateFormat dfActual= new SimpleDateFormat("dd/MM/YYYY");
String fecHoy=dfActual.format(new java.util.Date());

 %>
<!--The beans  -->

<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
<!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpago.jsp">Mantenimiento de Pagos</a> <span class="divider">/</span></li>
		        <li> Busqueda de Pagos </li>
	          </ul>
	          <!-- Solo si necesitas colocar una botonera colocar esto, sino no colocar -->
	          <jsp:include page="botones.jsp" />
	          <!-- fin botones -->
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> FLUJO DE CAJA</h2></div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="SMVPago">
		            <input type="hidden" name="accion" value="BuscarFlujoCaja"/></input>
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">Periodo:</label>
		                <div class="controls">
		                  <select id="cmbAnho" name="cmbAnho" data-rel="chosen">
						  <% for(int year=0;year<30;year++){%>
								  <option value="<%=2013+year%>"><%=2013+year%></option>
						<% } %>
								  </select>
	                    </div>
	                  </div>
		              
		              <div class="form-actions">
		                <button type="submit" class="btn btn-primary">Buscar</button>
	                  </div>
	                </fieldset>
	              </form>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    
		    
		     
		    
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> FLUJO DE CAJA</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered  ">
		            <!-- agregar nuevo boton -->
					
		            <thead>
		              <tr>
		                <th>Concepto</th>
		                <th>Enero</th>
		                <th>Febrero</th>
		                <th>Marzo</th>
		                 <th>Abril</th>
		                 <th>Mayo</th>
		                <th>Junio</th>
						<th>Julio</th>
		                <th>Agosto</th>
		                <th>Septiembre</th>
		                 <th>Octubre</th>
		                 <th>Noviembre</th>
		                <th>Diciembre</th>
	                  </tr>
	                </thead>
		            <tbody>
					<%
					Double enero=0.0,febrero=0.0,marzo=0.0,abril=0.0,mayo=0.0,junio=0.0,julio=0.0,agosto=0.0,setiembre=0.0,octubre=0.0,noviembre=0.0,diciembre=0.0,factor=0.0;
					 Double Tenero=0.0;
					 Double Tfebrero=0.0;
					 Double Tmarzo=0.0;
					 Double Tabril=0.0;
					 Double Tmayo=0.0;
					 Double Tjunio=0.0;
					 Double Tjulio=0.0;
					 Double Tagosto=0.0;
					 Double Tsetiembre=0.0;
					 Double Toctubre=0.0;
					 Double Tnoviembre=0.0;
					 Double Tdiciembre=0.0;
		             String concepto;
					
					
					
					
					
					
					
					
					
					%>
					
		              
		              <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY");
		             
                          	for(int i=0;i<resultados.size();i++){
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getConcepto().equals("EGRESOS")) factor=-1.0; else factor =1.0;		
							concepto=((ResultadoFlujoCajaBeanData)resultados.get(i)).getConcepto();
							
							
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getEnero()==null)
							enero=0.0; else enero=((ResultadoFlujoCajaBeanData)resultados.get(i)).getEnero();						
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getFebrero()==null)
							febrero=0.0; else febrero=((ResultadoFlujoCajaBeanData)resultados.get(i)).getFebrero();

							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getMarzo()==null)
							marzo=0.0; else marzo=((ResultadoFlujoCajaBeanData)resultados.get(i)).getMarzo();	
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getAbril()==null)
							abril=0.0; else abril=((ResultadoFlujoCajaBeanData)resultados.get(i)).getAbril();	
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getMayo()==null)
							mayo=0.0; else mayo=((ResultadoFlujoCajaBeanData)resultados.get(i)).getMayo();	
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getJunio()==null)
							junio=0.0; else junio=((ResultadoFlujoCajaBeanData)resultados.get(i)).getJunio();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getJulio()==null)
							julio=0.0; else julio=((ResultadoFlujoCajaBeanData)resultados.get(i)).getJulio();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getAgosto()==null)
							agosto=0.0; else agosto=((ResultadoFlujoCajaBeanData)resultados.get(i)).getAgosto();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getSetiembre()==null)
							setiembre=0.0; else setiembre=((ResultadoFlujoCajaBeanData)resultados.get(i)).getSetiembre();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getOctubre()==null)
							octubre=0.0; else octubre=((ResultadoFlujoCajaBeanData)resultados.get(i)).getOctubre();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getNoviembre()==null)
							noviembre=0.0; else noviembre=((ResultadoFlujoCajaBeanData)resultados.get(i)).getNoviembre();
							
							if(((ResultadoFlujoCajaBeanData)resultados.get(i)).getDiciembre()==null)
							diciembre=0.0; else diciembre=((ResultadoFlujoCajaBeanData)resultados.get(i)).getDiciembre();
							
							Tenero+=enero*factor;
							Tfebrero+=febrero*factor;
							Tmarzo+=marzo*factor;
							Tabril+=abril*factor;
							Tmayo+=mayo*factor;
							Tjunio+=junio*factor;
							Tjulio+=julio*factor;
							Tagosto+=agosto*factor;
							Tsetiembre+=setiembre*factor;
							Toctubre+=octubre*factor;
							Tnoviembre+=noviembre*factor;
							Tdiciembre+=diciembre*factor;
							
									
                         %>
		              <tr <% if(concepto.equals("EGRESOS")){%>style="color:red"<% } %>>
					  
						<td class="center"><%=concepto%></td>
					    <td class="center"><%=enero%></td>
		                <td class="center"><%=febrero%></td>
		                <td class="center"><%=marzo%></td>
		                <td class="center"><%=abril%></td>		               
		                <td class="center"><%=mayo%></td>
		                <td class="center"><%=junio%></td>
                        <td class="center"><%=julio%></td>
		                <td class="center"><%=agosto%></td>
		                <td class="center"><%=setiembre%></td>
		                <td class="center"><%=octubre%></td>		               
		                <td class="center"><%=noviembre%></td>
		                <td class="center"><%=diciembre%></td>
		                
	                  </tr>
	                  
					  
					  
					  
					  
					  
					  

	                  <% } %>
	                  
	                 <tr>
					  
						<td class="center"><strong>TOTAL MES</strong></td>
					    <td class="center"><strong><%=Tenero%></strong></td>
		                <td class="center"><strong><%=Tfebrero%></strong></td>
		                <td class="center"><strong><%=Tmarzo%></strong></td>
		                <td class="center"><strong><%=Tabril%></strong></td>		               
		                <td class="center"><strong><%=Tmayo%></strong></td>
		                <td class="center"><strong><%=Tjunio%></strong></td>
                        <td class="center"><strong><%=Tjulio%></strong></td>
		                <td class="center"><strong><%=Tagosto%></strong></td>
		                <td class="center"><strong><%=Tsetiembre%></strong></td>
		                <td class="center"><strong><%=Toctubre%></strong></td>		               
		                <td class="center"><strong><%=Tnoviembre%></strong></td>
		                <td class="center"><strong><%=Tdiciembre%></strong></td>
		                
	                  </tr>
	                  
	                  
	                  
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->
		    <script>verificar();</script>