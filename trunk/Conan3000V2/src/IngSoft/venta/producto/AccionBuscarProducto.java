package IngSoft.venta.producto;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioMembresiaBeanData;
import IngSoft.venta.bean.CriterioMembresiaBeanFunction;
import IngSoft.venta.bean.CriterioProductoBeanData;
import IngSoft.venta.bean.CriterioProductoBeanFunction;
import IngSoft.venta.bean.ResultadoMembresiaBeanData;
import IngSoft.venta.bean.ResultadoProductoBeanData;

public class AccionBuscarProducto extends CoAccion {
	

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioProductoBeanData criterioProductoData =new CriterioProductoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoProductoBeanData> resultados=new CriterioProductoBeanFunction().buscarPlantillaProducto(criterioProductoData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/producto/buscarproducto.jsp");
		
	}


}
