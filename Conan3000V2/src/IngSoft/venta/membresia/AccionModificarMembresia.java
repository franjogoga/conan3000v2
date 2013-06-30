package IngSoft.venta.membresia;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.MembresiaBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;
@SessionScoped
public class AccionModificarMembresia extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		MembresiaBeanFunction MembresiaFunction= MembresiaBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			MembresiaBeanData MembresiaData=MembresiaFunction.crearMembresia(request, response);
			MembresiaData.setIdMembresia(request.getParameter("codigo"));
			MembresiaFunction.modificarMembresia(MembresiaData);
			this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/buscarmembresia.jsp");
		}	
		MembresiaBeanData MembresiaData=MembresiaFunction.consultarMembresiaRenovar(request.getParameter("codigo"));

		request.setAttribute("membresia", MembresiaData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/modificarmembresia.jsp");
	}
}