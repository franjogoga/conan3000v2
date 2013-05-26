

<%@page import="IngSoft.administracion.bean.DistritoBeanData"%>
<%@page import="IngSoft.administracion.bean.ProvinciaBeanData"%>

<jsp:useBean id="objeto" scope="request"class="java.util.Vector"></jsp:useBean>
		
		<%if(objeto.size()>0){
		 
		 if(objeto.get(0) instanceof ProvinciaBeanData){ %>
		  <%for(int i=0;i<objeto.size();i++){ %>
			<option value="<%= ((ProvinciaBeanData)objeto.get(i)).getCodigo()%>" <%=i==0?"selected":""%>><%= ((ProvinciaBeanData)objeto.get(i)).getNombre()%></option>
		<%} } 
		else if(objeto.get(0) instanceof DistritoBeanData) {%>
		  <%for(int i=0;i<objeto.size();i++){ %>
			<option value="<%= ((DistritoBeanData)objeto.get(i)).getCodigo()%>" <%=i==0?"selected":""%>><%= ((DistritoBeanData)objeto.get(i)).getNombre()%></option>
		<%} }}%>
