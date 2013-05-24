package IngSoft.venta.membresia;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.MembresiaBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;

 public class AccionTrasladarMembresia  extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		
		MembresiaBeanFunction membresiaFuncion= MembresiaBeanFunction.getInstance();
		MembresiaBeanData membresiaData=membresiaFuncion.consultarMembresia(request.getParameter("codigo"));
		
		request.setAttribute("membresia", membresiaData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/trasladomembresia.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/membresiaes/buscarmembresia.jsp");
				
		/*MembresiaBeanFunction MembresiaFuncion= MembresiaBeanFunction.getInstance();
		MembresiaBeanData MembresiaData=MembresiaFuncion.consultarMembresia(request.getParameter("codigo"));

		request.setAttribute("membresia", MembresiaData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/trasladomembresia.jsp");
		*/		
	
}
