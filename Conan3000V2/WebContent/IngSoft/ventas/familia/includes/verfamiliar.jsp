<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />


<script>
		function procesar(form,indice){
			
		
		
		}
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		
			
			}
		
		
		
			//document.fmrData.submit();

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
	
	<!--The beans  -->
	<jsp:useBean id="familiar" scope="request" class="IngSoft.venta.bean.FamiliarBeanData"></jsp:useBean>
	<jsp:useBean id="persona" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>
	<jsp:useBean id="personaSocio" scope="request" class="IngSoft.venta.bean.PersonaMiniBeanData"></jsp:useBean>
	
			  <!-- content starts -->
			   
		       <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarfamiliar.jsp">Mantenimiento de Familiares </a> <span class="divider">/</span></li>
		        <li>Ver Familiar</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>VER FAMILIAR</h2>
		          </div>
			      <div class="box-content">
			        <form class="form-horizontal" action="<%= response.encodeURL("SMVFamiliar")%>" name="frmData" method="POST">
						<input type="hidden" name="accion" value="Consultar"></input>
						<input type="hidden" name="tipo" value="2"></input>
					
			          <fieldset>
			         
			            <div class="control-group">
			              <label class="control-label" for="typeahead7">Socio Asociado:</label>
			              <div class="controls">
			                <input type="text" disabled class="span6 typeahead" id="typeahead7"  data-provide="typeahead" value=<%=personaSocio.getNombres()%>>
		                  </div>
		                </div>

			              <div class="control-group">
			                <label class="control-label" for="typeahead6">Nombres:</label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead6"  data-provide="typeahead" data-items="4" value=<%=persona.getNombres() %> >
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead4">Apellido Paterno:</label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead4"  data-provide="typeahead" data-items="4" value=<%=persona.getApellidoPaterno() %>>
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead8">Apellido Materno:</label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead8"   data-provide="typeahead" data-items="4" value=<%=persona.getApellidoMaterno() %>>
		                    </div>
		                  </div>
		                  
			         
			               	<div class="control-group">
								<label  class="control-label" for="typeahead3">Tipo de Documento(*):</label>
								<div class="controls">
								  <label class="radio">
									<input disabled type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
									DNI
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input disabled type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									Carnet de Extranjeria
								  </label>
								   <div style="clear:both"></div>
								  <label class="radio">
									<input  disabled type="radio" name="optionsRadios" id="optionsRadios3" value="option3">
									Pasaporte
								  </label>
								</div>
							</div>	
							  
							  
						 <div class="control-group">
			                <label class="control-label" for="typeahead8">N&uacute;mero de Doc.(*):</label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead8"  data-provide="typeahead" data-items="4" value=<%=persona.getNumeroDocumento() %>>
		                    </div>
		                  </div>
			            
			              
			               <!--  <div class="control-group">
			                  <label class="control-label" for="selectError">Parentesco:</label>
			                  <div class="controls">
			                    <select name="selectError" id="selectError" data-rel="chosen" disabled>
			                      <option selected>Hija</option>
			                      <option>Option 2</option>
			                      <option>Option 3</option>
			                      <option>Option 4</option>
			                      <option>Option 5</option>
		                        </select>
		                      </div>
		                      </div> -->
		                   
		                  <div class="control-group">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Fijo: </label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead10"   data-provide="typeahead" data-items="4" value=<%=familiar.getTelefonoFijo() %>>
		                    </div>
		                  </div>
		                  
		                   <div class="control-group">
			                <label class="control-label" for="typeahead10">Tel&eacute;fono Celular: </label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead10"   data-provide="typeahead" data-items="4" value=<%=familiar.getTelefonoCelular() %>>
		                    </div>
		                  </div>
		                  
			              <div class="control-group">
			                <label class="control-label" for="typeahead2">Correo electr&oacute;nico:</label>
			                <div class="controls">
			                  <input type="text" disabled class="span6 typeahead" id="typeahead2" data-provide="typeahead" data-items="4" value=<%=familiar.getCorreo() %>>
		                    </div>
		                  </div>
		                
			            <div class="form-actions">
			               <button type="button"  class="btn" onclick="location.href='../buscarfamiliar.jsp'">Regresar</button>  
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
		