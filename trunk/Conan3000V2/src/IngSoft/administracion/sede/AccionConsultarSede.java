package IngSoft.administracion.sede;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		SedeBeanFuncion s= SedeBeanFuncion.getInstans();
		int codigo=Integer.parseInt( request.getParameter("codigo") );
		SedeBeanData d= s.getSede(1);
		
		System.out.print(" AccionConsulta ----> " + d.getNombre());
		
		request.setAttribute("sede", d);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sedes/eliminarsede.jsp");
		
		
		
		
	}

}
