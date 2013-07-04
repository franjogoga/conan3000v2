package IngSoft.venta.producto;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioProductoBeanData;
import IngSoft.venta.bean.CriterioProductoBeanFunction;
import IngSoft.venta.bean.ResultadoProductoBeanData;
@SessionScoped
public class AccionSeleccionarProducto  extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioProductoBeanData criterioProductoData =new CriterioProductoBeanFunction().crearCriterio(request, response);
		Vector<ResultadoProductoBeanData> resultados=new CriterioProductoBeanFunction().buscarPlantillaProducto(criterioProductoData);
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/producto/seleccionarproducto.jsp");
	
		}
	}
