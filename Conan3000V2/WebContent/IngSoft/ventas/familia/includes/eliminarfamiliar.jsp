<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
	
	<!--The beans  -->
	<jsp:useBean id="familiar" scope="request" class="IngSoft.venta.bean.FamiliarBeanData"></jsp:useBean>
	<jsp:useBean id="persona" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>
	<jsp:useBean id="personaSocio" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>
	
	
	<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
	<link rel="stylesheet" href="css/apprise.css" type="text/css" />
	<script type="text/javascript" src="js/script.js"></script>
			
				<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar este familiar?");
		if(r==true){
				if(<%=familiar.getFlag()%>==1){
        			crearAlert2("No se puede eliminar el familiar. Se está violando el principio de dependencia.");
        		}else{
					form.submit();    
        		}
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
		SimpleDateFormat DF= new SimpleDateFormat("dd/MM");
		return DF.format(date);
	}
	%>
	
	
			
		
	<%String nombre=((personaSocio.getNombres()) +" "+ (personaSocio.getApellidoPaterno()) +" "+ (personaSocio.getApellidoMaterno()) ); %>
			  
			  <!-- content starts -->
			  
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarfamiliar.jsp">Mantenimiento de Familiares </a> <span class="divider">/</span></li>
		        <li>Eliminar Familiar</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>ELIMINAR FAMILIAR</h2>
		          </div>
			      <div class="box-content">
			      
			        <form class="form-horizontal" name="frmDelete"  action="<%= response.encodeURL("SMVFamiliar")%>" method="post">
			        <input type="hidden" name="codigo" value="<%=familiar.getCodigoFamiliar()%>" ></input>
					<input type="hidden" name="accion" value="Eliminar"></input>
					<input type="hidden" name="tipo" value="2"></input>
			        
			          <fieldset>
			          
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Nombres Socio Asociado:</label>
			              <div class="controls">
			                <input type="text" name="txtSocioasociado" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" value=<%=personaSocio.getNombres() %>>
		                  </div>
		                </div>
		                
		                  <div class="control-group">
			              <label class="control-label" for="typeahead7">Apellido Paterno Socio Asociado :</label>
			              <div class="controls">
			                <input type="text" name="txtSocioasociado" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" value=<%=personaSocio.getApellidoPaterno()%>>
		                  </div>
		                </div>
		                
		                <div class="control-group">
			              <label class="control-label" for="typeahead7">Apellido Materno Socio Asociado :</label>
			              <div class="controls">
			                <input type="text" name="txtSocioasociado" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" value=<%=personaSocio.getApellidoMaterno()%>>
		                  </div>
		                </div>
		                
		                	 <div class="control-group">
			                  <label class="control-label" for="selectError">Parentesco:</label>
			                  <div class="controls">
			                    <select name="cmbParentesco" id="selectError" data-rel="chosen" disabled>
			                      <option selected><%=familiar.getParentesco() %></option>
		                        </select>
		                      </div>
		                    </div>
			        
			              <div class="control-group">
			                <label class="control-label" for="typeahead6">Nombres:</label>
			                <div class="controls">
			                  <input type="text" name="txtNombres" disabled class="span6 typeahead" id="typeahead6" value=<%=persona.getNombres() %>  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Apellido Paterno:</label>
			                <div class="controls">
			                  <input type="text" name="txtAppaterno" disabled class="span6 typeahead" id="typeahead4" value=<%=persona.getApellidoPaterno() %>  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Apellido Materno:</label>
			                <div class="controls">
			                  <input type="text" name="txtApmaterno" disabled class="span6 typeahead" id="typeahead8" value=<%=persona.getApellidoMaterno() %>  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			               	<div class="control-group">
								<label  class="control-label" for="typeahead3">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input disabled type="radio" name="rDni" id="optionsRadios1" value="option1" checked>
									DNI
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input disabled type="radio" name="rCarnetextranjeria" id="optionsRadios2" value="option2">
									Carnet de Extranjeria
								  </label>
								   <div style="clear:both"></div>
								  <label class="radio">
									<input  disabled type="radio" name="rPasaporte" id="optionsRadios3" value="option3">
									Pasaporte
								  </label>
								</div>
							  </div>
							  
							    <div class="control-group">
			                <label class="control-label" for="typeahead8">N&uacute;mero de Doc.(*):</label>
			                <div class="controls">
			                  <input type="text" name="txtNumdocumento" disabled class="span6 typeahead" id="typeahead8"  data-provide="typeahead" data-items="4" value=<%=persona.getNumeroDocumento() %>>
		                    </div>
		                  </div>
			            
			              
		
		                    
		                    <div class="control-group">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Fijo: </label>
			                <div class="controls">
			                  <input type="text" name="txtTelefono" disabled class="span6 typeahead" id="typeahead10" value=<%=familiar.getTelefonoFijo() %>  data-provide="typeahead" data-items="4">
		                    </div>
		                  </div>
		                    
		                    <div class="control-group">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Celular: </label>
			                <div class="controls">
			                  <input type="text" name="txtTelefono" disabled class="span6 typeahead" id="typeahead10" value=<%=familiar.getTelefonoCelular() %>  data-provide="typeahead" data-items="4">
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead2">Correo electr&oacute;nico:</label>
			                <div class="controls">
			                  <input type="text" name="txtCorreo" disabled class="span6 typeahead" id="typeahead2" value=<%=familiar.getCorreo() %>  data-provide="typeahead" data-items="4" >
		                    </div>
		                  </div>
		                </div>
		                
			            <div class="form-actions">
			                <button  type="submit" class="btn btn-primary" onclick="javascript:alt_submit()">Eliminar</button> 
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