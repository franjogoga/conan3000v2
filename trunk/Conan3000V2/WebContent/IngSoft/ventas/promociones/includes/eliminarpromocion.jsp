
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.venta.bean.PromocionBeanFuncion"%>
<%@page import="IngSoft.venta.bean.PromocionBeanData"%>
<%@page import="java.util.Date"%>
	<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmDelete;
		var r=confirm("¿Esta seguro que desea borrar este evento?");
		if(r==true){form.submit();}
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



<!-- content starts -->
			  <div>
			  <jsp:useBean id="promocion" scope="request"class="IngSoft.venta.bean.PromocionBeanData"></jsp:useBean>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Eliminar Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>ELIMINAR PROMOCI&Oacute;N</h2>
		          </div>
			      <div class="box-content">
			  			        <form class="form-horizontal" name="frmDelete"  action="<%= response.encodeURL("SMVPromocion")%>" method="post">
						<input type="hidden" name="codigo" value="<%=promocion.getCodigo()%>" ></input>
						
						<input type="hidden" name="accion" value="Eliminar"></input>
						<input type="hidden" name="tipo" value="2"></input>
			          <fieldset>
			           <div class="control-group">
			              <label class="control-label" for="typeahead7">Nombre:</label>
			              <div class="controls">
			                <input type="text" disabled class="span6 typeahead" name="txtNombrePromocion" id="txtNombrePromocion" value="<%=promocion.getNombre()%>"  data-provide="typeahead" >
		                  </div>
		                </div>
			            <div class="control-group">
			              <div class="control-group">
			                <label class="control-label" for="date01">Fecha de inicio:</label>
			                <div class="controls">
			                  <input type="text" disabled class="input-xlarge datepicker" id="fFechInicio" name="fFechaInicio" readonly="true" value="<%=formatear(new Date(promocion.getFechaInicio().getTime())) %>" onchange="alt_fecha(this)" disabled>>
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date01">Fecha de fin:</label>
			                <div class="controls">
			                  <input type="text" disabled class="input-xlarge datepicker"  id="fFechFin" name="fFechaFin" readonly="true" value="<%=formatear(new Date(promocion.getFechaFin().getTime())) %>" onchange="alt_fecha(this)" disabled>
		                    </div>
		                  </div>

			           				<div class="control-group">
								<label class="control-label" for="typeahead3">Estado</label>
								<div class="controls">
								  <label class="radio">
									<input type="radio" disabled="disabled" "optionsRadios" id="optionsRadios1" value="option1" checked="">
									Activo
								  </label>
								  <div style="clear:both"></div>
								  <label class="radio">
									<input type="radio" disabled="disabled" name="optionsRadios" id="optionsRadios2" value="option2">
									Inactivo
								  </label>
								</div>
							  </div>
			              <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="textarea" rows="3" disabled class="" id="txtDescripcion" value="<%=promocion.getDescripcion()%>"  style="resize:none">Descuento si reservas 2 bungalow.</textarea>
		                    </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			              <button type="submit" class="btn btn-primary" onclick="javascript:alt_submit()" >Eliminar</button>
			              <button type="reset" class="btn" onclick="location.href='buscarpromocion.jsp'">Cancelar</a></button>
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