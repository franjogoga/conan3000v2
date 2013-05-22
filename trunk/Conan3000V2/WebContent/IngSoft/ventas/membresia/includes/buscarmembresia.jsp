 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="IngSoft.venta.bean.ResultadoMembresiaBeanData"%>
<%@page import="java.util.Vector"%>



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
	function alt_trasladar(cod){
		var form=document.getElementById("frmAlternativo");
		form.accion.value="Trasladar";
		form.codigo.value=cod;
		form.submit();
	}
	
	</script>	
<%!SimpleDateFormat dfActual= new SimpleDateFormat("/YYYY");
String fecAnoIni="01/01"+dfActual.format(new java.util.Date());
String fecAnoFin="31/12"+dfActual.format(new java.util.Date()); %>
<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>


  <!-- content starts -->
		    <div>
		      <ul class="breadcrumb">
		        <li> <a href="index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarmembresia.jsp">Mantenimiento de Membres&iacute;a</a> <span class="divider">/</span></li>
		        <li> Busqueda de Membres&iacute;a </li>
	          </ul>
	        </div>
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-search"></i> BUSCAR MEMBRESIA</h2>
		          <div class="box-icon"><a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>  </div>
	            </div>
		        <div class="box-content">
		          <form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMVMembresia")%>">
		          <input type="hidden" name="accion" value="Buscar"/></input>
		            <fieldset>
		              <div class="control-group">
		                <label class="control-label" for="typeahead">Socio</label>
		                <div class="controls">
		                  <input type="text" class="span6 typeahead" id="txtSocio" name="txtSocio">
		                </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError">Fecha Inicio</label>
		                <div class="controls">
		                <input type="text" class="input-xlarge datepicker" id="fFechaInicio" value="<%=fecAnoIni%>" name="fFechaInicio" readonly="readonly">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="date01">Fecha Fin</label>
		                <div class="controls">
		                 <input type="text" class="input-xlarge datepicker" id="fFechaFin" name="fFechaFin" id="fFechaFin" value="<%=fecAnoFin%>" readonly="readonly">
	                    </div>
	                  </div>
		              <div class="control-group">
		                <label class="control-label" for="selectError2">Estado</label>
		                <div class="controls">
		                  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios1" value="Activo" checked="checked">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" id="optionsRadios2" value="Inactivo">
									Inactivo
							</label>
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
	        
	        
	        <form id="frmAlternativo" name="frmAlternativo" method="POST" action="<%= response.encodeURL("SMVPromocion")%>">
			  <input type="hidden" name="accion" value="Agregar"></input>
			  <input type="hidden" name="codigo" value=""></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
	        
		    <!--/row-->
		    <div class="row-fluid sortable">
		      <div class="box span12">
		        <div class="box-header well" data-original-title>
		          <h2><i class="icon-th-list"></i> RESULTADOS</h2>
	            </div>
		        <div class="box-content">
		          <table class="table table-striped table-bordered bootstrap-datatable datatable">
		            <!-- agregar nuevo boton -->
		            <div  align="right"> <a class="btn btn-primary" href="agregarmembresia.jsp"> <i class="icon icon-add icon-white"></i> Agregar </a> </div>
		            <thead>
		              <tr>
		                <th width="20%">Socio</th>
		                <th width="10%">Fecha Inicio</th>
		                <th width="10%">Fecha Fin</th>
		                <th width="5%">Costo</th>
		                <th width="10%">Estado</th>
		                <th width="45%">Acci&oacute;n</th>
	                  </tr>
	                </thead>
		            <tbody>
		            
		             <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY");
		             
		             
                          			for(int i=0;
                          			i<resultados.size();i++){
                         %>
		              <tr>
		                <td class="center">
		                <%=
		                ((ResultadoMembresiaBeanData)resultados.get(i)).getNombre()
                         %>
						</td>
		                <td class="center">
		                <%=
                         df.format(((ResultadoMembresiaBeanData)resultados.get(i)).getLimInicio())
                          %></td>
		                <td class="center">
		                <%=
                         df.format(((ResultadoMembresiaBeanData)resultados.get(i)).getLimFin())
                        %>
		                </td>
		                <td class="center">600</td>
		                <td class="center"><span class="label label-success">
		                <%=
                         ((ResultadoMembresiaBeanData)resultados.get(i)).getEstado()
                        %></span></td>
		                <td class="center">
		                <a class="btn btn-success"
                          					href="javascript:alt_consultar('<%=((ResultadoMembresiaBeanData)resultados.get(i)).getCodigo()%>')">
                          					 <i class="icon-zoom-in icon-white"></i> Ver </a> 
		                <a class="btn btn-info"
                          					href="javascript:alt_modificar('<%=((ResultadoMembresiaBeanData)resultados.get(i)).getCodigo()%>')">
                          					<i class="icon-edit icon-white"></i> Modificar </a>
                        <a class="btn btn-danger"
                          					href="javascript:alt_eliminar('<%=((ResultadoMembresiaBeanData)resultados.get(i)).getCodigo()%>')">
                          					 <i class="icon-trash icon-white"></i> Eliminar </a>
                        <a class="btn btn-primary"
                          					href="javascript:alt_trasladar('<%=((ResultadoMembresiaBeanData)resultados.get(i)).getCodigo()%>')">
                          					 <i class="icon-share icon-white"></i> Trasladar </a></td>
	                  </tr>
	                   <%}%>
	                  
		              
	                </tbody>
	              </table>
	            </div>
	          </div>
		      <!--/span-->
	        </div>
		    <!--/row-->
		    <!-- content ends -->