package IngSoft.servicio.servadicional;

import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.ServAdicionalBeanData;
import IngSoft.servicio.bean.ServAdicionalBeanFuncion;

public class AccionBuscarServAdicional extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==1){
			this.direccionar(sc, request, response, "/IngSoft/servicio/servadicional/buscaradicional.jsp");
		}
		if(tipo==2){					
			ServAdicionalBeanFuncion servadicionalFuncion=ServAdicionalBeanFuncion.getInstance();
			HashMap<String, Object> map= new HashMap<>();
			//nombre tipo estado
			String temp=request.getParameter("txtNombre");
			if(temp==null||temp.isEmpty()) temp="%";
			else temp="%"+temp+"%"; 
			map.put("nombre", temp);
			temp=request.getParameter("cmbTipo");
			if(temp==null||temp.isEmpty()) temp="%";
			else temp="%"+temp+"%"; 
			map.put("tipo", temp);
			temp=request.getParameter("cmbEstado");
			if(temp==null||temp.isEmpty()||temp.equals("all")) temp="%";
			else temp="%"+temp+"%"; 
			map.put("estado", temp);
			Vector<ServAdicionalBeanData>resultados=servadicionalFuncion.buscarServAdicional(map);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/servicio/servadicional/buscaradicional.jsp");
		}
	}

}
