package IngSoft.venta.servicio;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioServicioBeanData;
import IngSoft.venta.bean.CriterioServicioBeanFunction;
import IngSoft.venta.bean.ResultadoServicioBeanData;
@SessionScoped
public class AccionBuscarServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioServicioBeanData criterioServicioData =new CriterioServicioBeanFunction().crearCriterio(request,response);
		Vector<ResultadoServicioBeanData> resultados=new CriterioServicioBeanFunction().buscarPlantillaServicio(criterioServicioData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/buscarservicio.jsp");
		
	}
	
}
