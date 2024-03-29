<%@page import="IngSoft.servicio.bean.SedeMiniBeanData"%>
<%@page import="IngSoft.administracion.bean.EmpleadoBeanData"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

	<meta charset="utf-8">
	<title>Agregar Solicitud Producto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<jsp:useBean id="sedes" scope="request" class="java.util.Vector"></jsp:useBean>
	
	<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
	
		
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>

<link rel="stylesheet" href="css/apprise.css" type="text/css" />	</style>
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>
		
			<script>	
   function anhadirprod(cod, name){
	var form= document.frmSolicitud;
	form.txtProducto.value=name;
	form.idProductoProv.value=cod;
	$.fn.colorbox.close();
	
} 
   
   
   function alt_submit(){
		var form= document.frmSolicitud;
		if(validaForm()) form.submit();
			
}
   
  
</script>	
					 
		 <%! 	
   public String getFechaActual(){
   	SimpleDateFormat DF= new SimpleDateFormat("dd/MM/YYYY");
   	Date fecha= new Date();
   return (DF.format(fecha));
   }	
   %>	  <!-- content starts -->
			 
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="solicitud.jsp">Solicitudes </a> <span class="divider">/</span></li>
		        <li>Agregar Producto</li>
	          </ul>
		      </div>  
		      
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2><i class="icon-search"></i>SOLICITUD DE PRODUCTO</h2>
		          </div>
			      <div class="box-content">
			         <form class="form-horizontal" name="frmSolicitud" id="frmSolicitud"method="POST" action="SMVSolicitudProducto" onsubmit="alt_submit();return false;">
			          <input type="hidden" name="accion" value="Agregar"></input>
			          <input type="hidden" name="tipo" value="2"></input>
			             <input type="hidden" name="fFecha" value=<%=getFechaActual()%>></input>
			          
			          <fieldset>
												    
			         <div class="control-group" id="dvProducto">
			                <label class="control-label" for="typeahead8">Producto (*): </label>
			                <div class="controls">
			                  <input type="text" class="span6 typeahead" id="txtProducto"  data-provide="typeahead" name="txtProducto" data-items="4" readonly="readonly">
			                  <br>
			                  <div  align="left"> <a class="btn btn-primary iframe" href="../producto/seleccionarproducto.jsp"> <i class="icon icon-search icon-white"></i> Buscar Producto</a> </div>
			                  <span class="help-inline" id="errProducto">Please correct the error</span>
			                </div>
		                  </div>
		                 	 <input type="hidden" name="idProductoProv" value=""/></input>					
			         </form>
			        		        			        
			             
	         			         
			            <div class="control-group">
			                <label class="control-label" for="typeahead4">Cantidad(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtCantidad" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>


		                   <div class="control-group">
                          <label class="control-label" for="selectError">Sede (*):</label>
                          <div class="controls">
                            <select id="cmbSede" data-rel="chosen" name="cmbSede">
                          		<%for(int i=0;i<sedes.size();i++){ %>
								 <option value="<%= ((SedeMiniBeanData)sedes.get(i)).getCodigo()%>" <%=i==0?"selected":""%>><%=((SedeMiniBeanData)sedes.get(i)).getNombre()%></option>
								<%} %>
                            </select>
                          </div>
                        </div>

  					  <div class="control-group">
			                <label class="control-label" for="typeahead4">Precio Unitario(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtPrecio" class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
  					
		               		              			          
			            <div class="form-actions">
			          
			          
			           <button type="submit" class="btn btn-primary" onclick="javascript:alt_submit()" >Agregar</button>
			              <button type="button" class="btn" onclick="location.href='../solicitud/buscarsolicitudproducto.jsp'">Cancelar</button>
		                </div>
		              </fieldset>
		                
		               (*) Campos Obligatorios
		                </form>

		          </div>
		        </div>
			    <!--/span-->
		      </div>
			  <!--/row-->

			    <!--/span-->
               
		    
			  <!--/row-->
			  <div class="row-fluid sortable">
			    <!--/span-->
		      </div>
			  <!--/row-->
			 
	  
       
					<!-- content ends -->
