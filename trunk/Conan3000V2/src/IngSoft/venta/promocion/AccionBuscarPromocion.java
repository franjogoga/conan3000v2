package IngSoft.venta.promocion;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ResultadoEventoBeanData;
import IngSoft.venta.bean.CriterioPromocionBeanData;
import IngSoft.venta.bean.CriterioPromocionBeanFunction;
import IngSoft.venta.bean.ResultadoPromocionBeanData;

public class AccionBuscarPromocion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioPromocionBeanData criterioPromocionData =new CriterioPromocionBeanFunction().crearCriterio(request,response);
		Vector<ResultadoPromocionBeanData> resultados=new CriterioPromocionBeanFunction().buscarPlantillaPromocion(criterioPromocionData);
		
		
		//que es "resultados"
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
		
	}

}
