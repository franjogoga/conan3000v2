package IngSoft.venta.familiar;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioFamiliarBeanData;
import IngSoft.venta.bean.CriterioFamiliarBeanFuncion;
import IngSoft.venta.bean.ResultadoFamiliarBeanData;
@SessionScoped
public class AccionBuscarFamiliar extends CoAccion {
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioFamiliarBeanData criterioFamiliarData =new CriterioFamiliarBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoFamiliarBeanData> resultados=new CriterioFamiliarBeanFuncion().buscarPlantillaFamiliar(criterioFamiliarData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/familia/buscarfamiliar.jsp");
		
	}

}
