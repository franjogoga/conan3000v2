
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
  


	<script>
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
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
	%>	



<!-- content starts -->
<jsp:useBean id="promocion" scope="request"class="IngSoft.venta.bean.PromocionBeanData"></jsp:useBean>
			  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Ver Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2>VER PROMOCI&Oacute;N</h2>
		          </div>
			      <div class="box-content">
			       
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
			                  <input type="text" disabled class="input-xlarge datepicker" id="fFechInicio" name="fFechInicio" readonly="true" value="<%=formatear(new Date(promocion.getFechaInicio().getTime())) %>" onchange="alt_fecha(this)" disabled>
		                    </div>
		                  </div>
			              <div class="control-group">
			                <label class="control-label" for="date02">Fecha de fin:</label>
			                <div class="controls">
			                  <input type="text" disabled class="input-xlarge datepicker"  id="fFechFin" name="fFechFin" readonly="true" value="<%=formatear(new Date(promocion.getFechaFin().getTime())) %>" onchange="alt_fecha(this)" disabled>
		                    </div>
		                  </div>

			              <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="textarea" rows="3" disabled class="" id="txtDescripcion" style="resize:none"><%=promocion.getDescripcion()%></textarea>
		                    </div>
		                  </div>
			            </div>
			            <div class="form-actions">
			              <button type="reset" class="btn" onClick="javascript:history.back();">Regresar</button>
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