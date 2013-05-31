			<!-- content starts -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>			
			
		<script>
		function validar(form){
			if(form.txtNombres.value.length <=0)return false;
			if(form.txtApellidoPaterno.value.length<=0)return false;
			//if(form.txtTelefonoFijo.value.lengtht<=0)return false;
			//if(form.txtTelefonoCelular.value.length<=0)return false;
			//if(form.cmbAmbientes.value.length<=0)return false;
		return true;
		
		
		}
	
		function alt_fecha(obj){
		obj.value=obj.value.slice(0,5);
	
		}
	
		function alt_submit(){
		var form= document.frmUpdate;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
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
	
	<!--The beans  -->
	<jsp:useBean id="socio" scope="request" class="IngSoft.venta.bean.SocioBeanData"></jsp:useBean>	
		
	<!--The beans  -->
	<jsp:useBean id="persona" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>	
					

			<div>
				<ul class="breadcrumb">
					<li><a href="/Conan3000V2/IngSoft/general/index.jsp">Home / </a><a href="/Conan3000V2/IngSoft/ventas/socio/buscarsocio.jsp">Mantenimiento de Socios / </a>Modificar Socio
			           
			              </li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>MODIFICAR  SOCIO				  </h2>
				  </div>
					<div class="box-content">
						<form class="form-horizontal" name="frmUpdate" method="Post" action="<%= response.encodeURL("SMVSocio")%>">
						  <input type="hidden" name="codigo" value="<%=socio.getCodigo()%>"></input>
			       		  <input type="hidden" name="accion" value="Modificar"></input>
					      <input type="hidden" name="tipo" value="2"></input>
					
						  
						  <fieldset>
						  
						    <div class="control-group">
						      <label class="control-label" for="typeahead1">Nombres(*): </label>
						      <div class="controls">
						        <input type="text" value=<%=persona.getNombres() %>  class="span6 typeahead" id="txtNombres" name="txtNombres" data-provide="typeahead" >
					          </div>
					        </div>
						    
							  <div class="control-group">
							    <label class="control-label" for="typeahead2">Apellido Paterno(*): </label>
							    <div class="controls">
							      <input type="text" value=<%=persona.getApellidoPaterno() %> class="span6 typeahead" id="txtApellidoPaterno" name="txtApellidoPaterno" data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
						      
							  <div class="control-group">
							    <label class="control-label" for="typeahead3">Apellido Materno(*): </label>
							    <div class="controls">
							      <input type="text" value=<%=persona.getApellidoMaterno() %> class="span6 typeahead" id="txtApellidoMaterno" name="txtApellidoMaterno" data-provide="typeahead" data-items="4" >
						        </div>
						      </div>
						      
						      <div class="control-group">
			              		<label class="control-label" for="typeahead4">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaNacimiento" name="fFechaNacimiento" value="<%=formatear(new Date(persona.getFechaNacimiento().getTime())) %>">
			             		</div>
		                		</div>
						      
						      
                              
							 <div class="control-group">
								<label class="control-label" for="typeahead5">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
									DNI
								  </label>
								  <div style="clear:both">
								  <label class="radio">
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Carnet de Extranjeria
								  </label>
								  </div>
								</div>
								</div>
							  
                              <div class="control-group">
			                          <label class="control-label" for="typeahead6">N&uacute;mero de Documento(*): </label>
			                          <div class="controls">
			                            <input type="text" class="span6 typeahead" id="txtNumeroDocumento" name="txtNumeroDocumento" value=<%=persona.getNumeroDocumento() %>  data-provide="typeahead" data-items="4">
		                              </div>
                              </div>
                              
                              
							 
							    <div class="control-group">
							      <label class="control-label" for="typeahead7">Correo Electr&oacute;nico: </label>
							      <div class="controls">
							        <input type="text" value=<%=socio.getCorreoElectronico() %> class="span6 typeahead" id="txtCorreoElectronico" name="txtCorreoElectronico" data-provide="typeahead" data-items="4" >
						          </div>
						        </div>
						        
							    <div class="control-group">
							      <label class="control-label" for="typeahead8">Direcci&oacute;n: </label>
							      <div class="controls">
							        <input type="text" value="<%=socio.getDireccion() %>" class="span6 typeahead" id="txtDireccion"  name="txtDireccion" data-provide="typeahead" data-items="4" >
						          </div>
						        </div>
						        
						         <div class="control-group">
							     <label class="control-label" for="typeahead9">Tel&eacute;fono Fijo: </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoFijo" name="txtTelefonoFijo" data-provide="typehead" data-items="4" value=<%=socio.getTelefonoFijo() %>>
		                            </div>
		                            </div>
		                            
						         <div class="control-group">
		                             <label class="control-label" for="typeahead10">Tel&eacute;fono Celular: </label>
			                        <div class="controls">
			                          <input type="text" class="span6 typeahead" id="txtTelefonoCelular"  name="txtTelefonoCelular" data-provide="typehead" data-items="4" value=<%=socio.getTelefonoCelular() %> >
		                            </div>
		                            </div>

						    <div class="form-actions">
						        <button  type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>  
			               <button type="button" class="btn" onclick="location.href='buscarsocio.jsp'">Cancelar</button>  
						    							 
							</div>
						  </fieldset>
					  </form>   
					(*) Datos Obligatorios 
				  </div>
				</div><!--/span-->

			</div><!--/row-->


			<div class="row-fluid sortable"><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable"><!--/span-->

			</div><!--/row-->
    
					<!-- content ends -->
