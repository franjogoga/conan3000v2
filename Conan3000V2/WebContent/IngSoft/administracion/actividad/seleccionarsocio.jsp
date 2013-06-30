<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/IngSoft/general/header.jsp" />

<link rel="shortcut icon" href="img/conan_logo.png">
</head>
<body>


<div class="container-fluid">
<div class="row-fluid">
<div id="content" class="span10">
    <!-- content starts -->
 
   
<!-- -------------------------------------------------------------------------- -->


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="IngSoft.administracion.bean.PersonaBeanData"%>
<%@page import="java.util.Vector"%>

<script>
function alt_fecha(obj){
obj.value=obj.value.slice(0,5);
}
function alt_consultar(cod){
var form=document.getElementById("frmAlternativo");
form.accion.value="Consultar";
form.codigo.value=cod;
form.submit();
}
function alt_Insertar(cod,name,puesto){
parent.anhadirSocio(cod,name,puesto);
}
</script>
<!--The beans  -->
<jsp:useBean id="resultados" scope="request"class="java.util.Vector"></jsp:useBean>
<!-- content starts -->

<div class="row-fluid sortable">
<!-- content starts -->

<div class="row-fluid sortable">
<div class="box span12">
<div class="box-header well" data-original-title>
<h2><i class="icon-search"></i>  BUSCAR SOCIO	   </h2>
                        <div class="box-icon">
<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
</div>
                        
                        
  </div>
<div class="box-content">
<form class="form-horizontal" name="frmCriteriosBusqueda" id="frmCriteriosBusqueda"  method="POST" action="<%= response.encodeURL("SMAActividad")%>">
  <input type="hidden" name="accion" value="SeleccionarSocio"/></input>
 
  <fieldset>
    <div class="control-group">
   
    <div class="control-group">
    <label class="control-label" for="typeahead6">Nombre Socio: </label>
    <div class="controls">
      <input type="text" class="span6 typeahead" id="txtNombres" name="txtNombre" data-provide="typeahead" data-items="4" >
        </div>
      </div>
   

 
 
                              

    </div>
    <div class="form-actions">
    <button type="submit" class="btn btn-primary">Buscar</button>
             
   
</div>
  </fieldset>
  </form>   

  </div>
</div><!--/span-->

</div><!--/row-->

    
<!-- content ends -->
</div><!--/span-->
 
 

<div class="row-fluid sortable">
<div class="box span12">
<div class="box-header well" data-original-title>
<h2>RESULTADOS</h2>
</div>
<div class="box-content">
<table class="table table-striped table-bordered bootstrap-datatable datatable">
                        
                     
                           
  <thead>
  <tr>
  <th>Nombres Socio</th>

  <th>/</th>
  <th>Nombres Familiar</th>

 
  <th>Accion Socio</th>

  <th>Accion Familiar</th>
      
  </tr>
  </thead>  
 
  <element>
      <tbody id="resultadobusqueda"> 


  <%SimpleDateFormat df= new SimpleDateFormat("dd/MM/YYYY"); 
                          for(int i=0;
                          i<resultados.size();i++){
                             %>
                             
<tr>
       
       
       
        <td class="center">
                          <%=
                  ((PersonaBeanData)resultados.get(i)).getNombre() +' '+((PersonaBeanData)resultados.get(i)).getApaterno()+' '+((PersonaBeanData)resultados.get(i)).getAmaterno()

                          %>
                          </td>

                          <td>/</td>
        <td class="center">
                          <%
                          if (  ((PersonaBeanData)resultados.get(i)).getCodigofam()!=null  ) 
                          
                          out.print(	((PersonaBeanData)resultados.get(i)).getNombrefam()+' '+((PersonaBeanData)resultados.get(i)).getApaternofam()+' '+((PersonaBeanData)resultados.get(i)).getAmaternofam() );

                          %>
                          </td>




                       
                               <td class="center">
                          <a class="btn btn-success btn-small"
                          href="javascript:alt_Insertar('<%=((PersonaBeanData)resultados.get(i)).getCodigo()%>','<%= ((PersonaBeanData)resultados.get(i)).getNombre()+' '+((PersonaBeanData)resultados.get(i)).getApaterno()+' '+ ((PersonaBeanData)resultados.get(i)).getAmaterno()    %>','<%= ((PersonaBeanData)resultados.get(i)).getAmaterno()  %>')">
                          <i
                          class="icon-zoom-in icon-white">
                          </i>
Seleccionar Socio
                          </a>
                          
                          </td>
                          
                
                
           
                               
                
                
                          
                               <td class="center">
                          <a class="<%= ((PersonaBeanData)resultados.get(i)).getCodigofam()!= null?"btn btn-success btn-small":"btn btn-small"%>" 
                          href="javascript:<%= ((PersonaBeanData)resultados.get(i)).getCodigofam()!= null?"alt_Insertar":"" %>('<%=((PersonaBeanData)resultados.get(i)).getCodigofam()%>','<%= ((PersonaBeanData)resultados.get(i)).getNombrefam()+' '+((PersonaBeanData)resultados.get(i)).getApaternofam()+' '+ ((PersonaBeanData)resultados.get(i)).getAmaternofam()      %>','<%= ((PersonaBeanData)resultados.get(i)).getAmaterno()%>')">
                          <i
                          class="icon-zoom-in icon-white">
                          </i>
Seleccionar Familiar
                          </a>
                          
                          </td>
                          </tr>
                          
        <%}%>
      </tbody>
      </element>
  </table>            
</div>
</div><!--/span-->
</div><!--/row-->
                
                
                
                
                

<div class="row-fluid sortable"><!--/span--><!--/span-->
</div><!--/row-->
<div class="row-fluid sortable"><!--/span--><!--/span-->
</div><!--/row-->
<div class="row-fluid sortable"><!--/span-->
</div><!--/row-->
    
<!-- content ends -->
</div>
                
         
















<!-- --------------------------------------------------------------------------- -->





   
    <!-- content ends -->
</div>
</div>
<hr>
</div>
<jsp:include page="/IngSoft/general/jsexternal.jsp" />
</body>
</html>
