package IngSoft.venta.membresia;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.MembresiaBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;

public class AccionEliminarMembresia extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			MembresiaBeanFunction membresiaFuncion= MembresiaBeanFunction.getInstance();
			membresiaFuncion.eliminarMembresia(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/membresiaes/buscarmembresia.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		MembresiaBeanFunction membresiaFuncion= MembresiaBeanFunction.getInstance();
		MembresiaBeanData membresiaData=membresiaFuncion.consultarMembresia(request.getParameter("codigo"));
		
		request.setAttribute("membresia", membresiaData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/membresiaes/eliminarmembresia.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/membresiaes/buscarmembresia.jsp");
					
				
	}

}
