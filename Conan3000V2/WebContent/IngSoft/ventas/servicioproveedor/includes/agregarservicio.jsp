<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" src="js/apprise-1.5.full.js"></script>
<link rel="stylesheet" href="css/apprise.css" type="text/css" />
<script>

	function validar(form){
		if(form.txtNombreProv.value.length <=0)return false;
		if(form.txtDescripcion.value.length<=0)return false;
	return true;

	}

	function alt_submit(){
		var form= document.frmServicio;
		if(validar(form)) form.submit();
		else alert("Uno o mas campos estan vacios");
			
	}

	function anhadir(cod, name){
		var form= document.frmServicio;
		form.txtNombreProv.value=name;
		form.idServicio.value=cod;
		$.fn.colorbox.close();
	
	} 

	function confFecha(){
	var form= document.frmMembresia;
	if(form.cmbPeriodo.value=="Anual"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[2]=parseInt(fechaI[2])+1;
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Semestral"){
	document.getElementById("dvFechaFin").style.display='none';
		fechaI=form.fFechaInicio.value.split("/");
		fechaI[1]=parseInt(fechaI[1])+6;
		if(fechaI[1]>12){
			fechaI[2]=parseInt(fechaI[2])+1;
			fechaI[1]=parseInt(fechaI[1])-12;
		}
		form.fFechaFin.value=fechaI[0]+'/'+fechaI[1]+'/'+fechaI[2];
	}
	if(form.cmbPeriodo.value=="Indefinido"){
	document.getElementById("dvFechaFin").style.display='block';
	}
	
}
</script>		
			
			
			
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
					<a href="#">Home / Mantenimiento de Servicios de Proveedor /</a> Agregar Servicio</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2>AGREGAR SERVICIO</h2>
				  </div>
					<div class="box-content">
					
						<form class="form-horizontal" name="frmServicio" method="Post"  action="SMVServicio">
						<input type="hidden" name="accion" value="Agregar"></input>
					    <input type="hidden" name="tipo" value="2"></input>
					    
						  <fieldset>
						  
						    <div class="control-group">
						      <label class="control-label" for="typeahead1">Nombre Servicio(*): </label>
						      <div class="controls">
						        <input type="text" class="span6 typeahead" id="txtNombreServ" name="txtNombreServ"  data-provide="typeahead" >
					          </div>
					        </div>
					        
						
							  
						   <div class="control-group">
			                <label class="control-label" for="textarea2">Descripci&oacute;n:</label>
			                <div class="controls">
			                  <textarea name="txtDescripcion" class="" id="txtDescripcion" rows="3" style="resize:none"></textarea>
		                    </div>
		                  </div>
							  
							  <div class="control-group">
							    <label class="control-label" for="typeahead2">Precio (S/.) (*): </label>
							    <div class="controls">
							      <input type="text" class="span6 typeahead" id="txtPrecio"  name="txtPrecio" data-provide="txtPrecio" data-items="4" >
						        </div>
						      </div>
						      
							  <div class="control-group">
							  <label class="control-label" for="typeahead3">Nombre Proveedor(*): </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="txtNombreProv" name="txtNombreProv" data-provide="typeahead" data-items="4"><br>
								 <div  align="left"> <a class="btn btn-primary iframe" href="../proveedor/seleccionarproveedor.jsp"> <i class="icon icon-search icon-white"></i> Buscar Proveedor</a> </div>
							  </div>
							</div>
						    
                            
						    <div class="form-actions">
						    <input type="hidden" name="idServicio" value=""/></input>
						    <button type="submit"  class="btn btn-primary" onclick="javascript:alt_submit()">Agregar</button>  
			               <button type="submit"  class="btn" href="buscarservicio.jsp">Cancelar</button> 
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
