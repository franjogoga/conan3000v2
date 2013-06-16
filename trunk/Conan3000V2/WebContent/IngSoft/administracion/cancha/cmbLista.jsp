

<%@page import="IngSoft.administracion.bean.AmbienteMiniBeanData"%>

<jsp:useBean id="objeto" scope="request"class="java.util.Vector"></jsp:useBean>
		
		<%if(objeto.size()>0){
	 
		 if(objeto.get(0) instanceof AmbienteMiniBeanData){ %>
		  <%for(int i=0;i<objeto.size();i++){ %>
			<option value="<%= ((AmbienteMiniBeanData)objeto.get(i)).getCodigo()%>" <%=i==0?"selected":""%>><%= ((AmbienteMiniBeanData)objeto.get(i)).getNombre()%></option>
		<%} } }%>		