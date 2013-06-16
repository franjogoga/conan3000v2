

<%@page import="IngSoft.administracion.bean.AmbienteMiniBeanData"%>

<jsp:useBean id="objeto" scope="request"class="java.util.Vector"></jsp:useBean>
		
		<%if(objeto.size()>0){
	 
		 if(objeto.get(0) instanceof AmbienteMiniBeanData){ %>
		  <option selected value="0">Todos</option>
		  <%for(int i=0;i<objeto.size();i++){ %>
			<option value="<%= ((AmbienteMiniBeanData)objeto.get(i)).getCodigo()%>"><%= ((AmbienteMiniBeanData)objeto.get(i)).getNombre()%></option>
		<%} } }%>
		
		<%if(objeto.size()==0){%>
		  <option selected value="0">Todos</option>
		  
		<% } %>		