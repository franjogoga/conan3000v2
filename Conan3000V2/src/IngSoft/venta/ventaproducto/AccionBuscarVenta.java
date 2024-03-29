package IngSoft.venta.ventaproducto;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.venta.bean.*;


public class AccionBuscarVenta extends CoAccion {
	

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
	    CriterioVentaBeanData criterioVentaData =new CriterioVentaBeanFunction().crearCriterio(request,response);
		Vector<ResultadoVentaBeanData> resultados=new CriterioVentaBeanFunction().buscarPlantillaVenta(criterioVentaData);
		EventoBeanFuncion eventoFunction=EventoBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
		
		request.setAttribute("sedes", sedeMiniData);
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/buscarventaproducto2.jsp");
		
	}


}
