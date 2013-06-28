<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<script>
		
	
	function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}
	
	function alt_submit(){
		var form= document.frmUpdate;
		if(validaForm()) form.submit();
			
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
	<jsp:useBean id="promocion" scope="request"class="IngSoft.venta.bean.PromocionBeanData"></jsp:useBean>	

<!-- content starts -->
			  <div>
			    <ul class="breadcrumb">
		        <li> <a href="../../general/index.jsp">Home</a> <span class="divider">/</span></li>
		        <li> <a href="buscarpromocion.jsp">Mantenimiento de Promociones</a> <span class="divider">/</span></li>
		        <li>Modificar Promoci&oacute;n</li>
	          </ul>
		      </div>
			  <div class="row-fluid sortable">
			    <div class="box span12">
			      <div class="box-header well" data-original-title>
			        <h2> MODIFICAR PROMOCI&Oacute;N</h2>
		          </div>
		          
			      <div class="box-content">
			        <form class="form-horizontal" name="frmUpdate" method="Post">
			        <input type="hidden" name="codigo" value="<%=promocion.getCodigo()%>"></input>
			        <input type="hidden" name="accion" value="Modificar"></input>
					<input type="hidden" name="tipo" value="2"></input>
					
			          <fieldset>
			         
			            <div class="control-group" id="dvNombrePromocion">
			              <label class="control-label" for="typeahead7">Nombre  de Promoci&oacute;n:</label>
			              <div class="controls">
			                <input type="text" class="span6 typeahead" id="txtNombrePromocion" name="txtNombrePromocion"  onKeyUp="limita(this,50);" onKeyDown="limita(this,50);" value="<%=promocion.getNombre()%>">
		                  <span class="help-inline" id="errNombrePromocion">Please correct the error</span>
		                  </div>
		                </div>
		                
			               <div class="control-group" id="dvFechaInicio">
			              <label class="control-label" for="date01">Fecha de inicio(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechInicio" class="datepicker" id="fFechInicio" value="<%=formatear(promocion.getFechaInicio())%>"  readonly width=44px  onchange="verificar_fecha(1,this,'fFechFin');">
			                  <span class="help-inline" id="errFechaInicio">Please correct the error</span>
		                    </div>
		                  </div>
			              <div class="control-group" id="dvFechaFin">
			                <label class="control-label" for="date02">Fecha de fin(*):</label>
			                <div class="controls">
			                  <input type="text" name="fFechFin" class="datepicker" id="fFechFin" value="<%=formatear(promocion.getFechaFin())%>"  readonly width=44px  onchange="verificar_fecha(-1,this,'fFechInicio');">
			                  <span class="help-inline" id="errFechaFin">Please correct the error</span>
		                    </div>
		                  </div>
			             
			              <div class="control-group" id="dvDescripcion">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" rows="3" class="" id="txtDescripcion" style="resize:none" onpaste="return false;"  onKeyUp="limita(this,100);" onKeyDown="limita(this,100);"><%=promocion.getDescripcion()%></textarea>
			                  <span class="help-inline" id="errDescripcion">Please correct the error</span>
		                    </div>
		                  </div>
			            
			            <div class="form-actions">
			              <button type="button" class="btn btn-primary" onclick="javascript:alt_submit()">Guardar</button>
			             <button type="button" class="btn" onclick="location.href='buscarpromocion.jsp'" >Cancelar</button>
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