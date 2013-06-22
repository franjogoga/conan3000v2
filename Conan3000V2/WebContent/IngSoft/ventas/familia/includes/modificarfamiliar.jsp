<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>			
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />			
		<script>

		function alt_fecha(obj){
		obj.value=obj.value.slice(0,5);
	
		}
	
		function alt_submit(){
		var form= document.frmUpdate;
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
	
	<!--The beans  -->
	<jsp:useBean id="familiar" scope="request" class="IngSoft.venta.bean.FamiliarBeanData"></jsp:useBean>	
	<jsp:useBean id="persona" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>	
	<jsp:useBean id="socio" scope="request" class="IngSoft.venta.bean.SocioBeanData"></jsp:useBean>	
			  <!-- content starts -->
			   
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarfamiliar.jsp">Mantenimiento de Familiares </a> <span class="divider">/</span></li>
		        <li>Modificar Familiar</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>MODIFICAR FAMILIAR</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" name="frmUpdate" method="Post" action="<%= response.encodeURL("SMVFamiliar")%>">
			        <input type="hidden" name="codigo" value="<%=familiar.getCodigoFamiliar()%>"></input>
			       	<input type="hidden" name="accion" value="Modificar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			        
			          <fieldset>
			         
			            <div class="control-group">
			              <label class="control-label" for="typeahead1">Socio Asociado:</label>
			              <div class="controls">
			                <input type="text" name="txtSocio" disabled class="span6 typeahead" id="txtSocio" value=<%=socio.getCodigo() %>  data-provide="typeahead" maxlength="9" onpaste="return false;">
		                  </div>
		                </div>
		                
		                <div class="control-group">
			                  <label class="control-label" for="selectError">Parentesco:</label>
			                  <div class="controls">
			                    <select name="cmbParentesco" id="cmbParentesco" data-rel="chosen" >
			                      <option selected>Hija(o)</option>
			                      <option>Padre</option>
			                      <option>Madre</option>
		                        </select>
		                      </div>
		                    </div>
			           
			              <div class="control-group" id="dvNombres">
			                <label class="control-label" for="typeahead2">Nombres:</label>
			                <div class="controls">
			                  <input type="text" name="txtNombres" class="span6 typeahead" id="txtNombres"  data-provide="typeahead" data-items="4" value=<%=persona.getNombres() %> maxlength="50" onpaste="return false;">
		                       <span class="help-inline" id="errNombres">Please correct the error</span>
		                    </div>
		                  </div>
		                  
			              <div class="control-group" id="dvApellidoP">
			                <label class="control-label" for="typeahead3">Apellido Paterno:</label>
			                <div class="controls">
			                  <input type="text" name="txtApellidoPaterno" class="span6 typeahead" id="txtApellidoPaterno"  data-provide="typeahead" data-items="4" value=<%=persona.getApellidoPaterno() %> maxlength="50" onpaste="return false;">
		                       <span class="help-inline" id="errApellidoP">Please correct the error</span>
		                    </div>
		                  </div>
		                  
			              <div class="control-group" id="dvApellidoM">
			                <label class="control-label" for="typeahead4">Apellido Materno:</label>
			                <div class="controls">
			                  <input type="text" name="txtApellidoMaterno" class="span6 typeahead" id="txtApellidoMaterno"  data-provide="typeahead" data-items="4" value=<%=persona.getApellidoMaterno() %> maxlength="50" onpaste="return false;">
		                       <span class="help-inline" id="errApellidoM">Please correct the error</span>
		                    </div>
		                  </div>
		                  
		                   <div class="control-group" id="dvFecha">
			              		<label class="control-label" for="typeahead5">Fecha Nacimiento(*): </label>
			              		<div class="controls">
			               		 <input type="text" class="input-xlarge datepicker" id="fFechaNacimiento" name="fFechaNacimiento" value="<%=formatear(new Date(persona.getFechaNacimiento().getTime()))%>" maxlength="10" onpaste="return false;">
                                   <span class="help-inline" id="errFecha">Please correct the error</span>
			             		</div>
		                  </div>
			             
			               	<div class="control-group" id="dvTipo">
								<label class="control-label" for="typeahead6">Tipo de Documento:</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" name="rButton"  value="DNI" <% if(persona.getTipoDocumento().toUpperCase().equals("DNI")){ %> checked <%}%>>
									DNI
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton"  value="Carnet de Extranjeria" <% if(persona.getTipoDocumento().toUpperCase().equals("CARNET DE EXTRANJERIA")){ %> checked <%}%>>
									Carnet de Extranjeria
								  </label>
								   <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" name="rButton" value="Pasaporte" <% if(persona.getTipoDocumento().toUpperCase().equals("PASAPORTE")){ %> checked <%}%>>
									Pasaporte
								  </label>
								   <span class="help-inline" id="errTipo">Please correct the error</span>
								</div>
							</div>
							  
						<div class="control-group" id="dvNumDoc">
			                <label class="control-label" for="typeahead7">N&uacute;mero de Doc.:</label>
			                <div class="controls">
			                  <input type="text" name="txtNumeroDocumento" class="span6 typeahead" id="txNumeroDocumento"  data-provide="typeahead" data-items="4" value=<%=persona.getNumeroDocumento() %> maxlength="9" onpaste="return false;">
		                        <span class="help-inline" id="errNumDoc">Please correct the error</span>
		                    </div>
		                  </div>
		                    

			              
			              <div class="control-group" id="dvTelefonoFijo">
			                <label class="control-label" for="typeahead8">Tel&eacute;fono Fijo(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtTelefonoF" id="txtTelefonoF"  data-provide="typeahead" data-items="4" value=<%=familiar.getTelefonoFijo() %> maxlength="7" onpaste="return false;">
		                        <span class="help-inline" id="errTelefonoFijo">Please correct the error</span>
		                    </div>
		                  </div>
		                  
		                  <div class="control-group" id="dvTelefonoCelular">
			                <label class="control-label" for="typeahead9">Tel&eacute;fono Celular(*):</label>
			                <div class="controls">
			                  <input type="text"  class="span6 typeahead" name="txtTelefonoC" id="txtTelefonoC"  data-provide="typeahead" data-items="4" value=<%=familiar.getTelefonoCelular() %> maxlength="9" onpaste="return false;">
		                       <span class="help-inline" id="errTelefonoCelular">Please correct the error</span>
		                    </div>
		                  </div>
		                  
			              <div class="control-group" id="dvCorreoE">
			                <label class="control-label" for="typeahead10">Correo electr&oacute;nico:</label>
			                <div class="controls">
			                  <input type="text" name="txtCorreo" class="span6 typeahead" id="txtCorreo"  data-provide="typeahead" data-items="4" value=<%=familiar.getCorreo() %> maxlength="100" onpaste="return false;">
		                        <span class="help-inline" id="errCorreoE">Please correct the error</span>
		                    </div>
		                  </div>		                
			            <div class="form-actions">
			                <button  type="button"  class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>  
			               <button type="button"   class="btn" onclick="location.href='buscarfamiliar.jsp'">Cancelar</button>		           
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
		