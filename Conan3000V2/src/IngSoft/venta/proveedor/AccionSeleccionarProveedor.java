package IngSoft.venta.proveedor;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioProveedorBeanData;
import IngSoft.venta.bean.CriterioProveedorBeanFunction;
import IngSoft.venta.bean.ResultadoProveedorBeanData;
@SessionScoped

public class AccionSeleccionarProveedor extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioProveedorBeanData criterioProveedorData =new CriterioProveedorBeanFunction().crearCriterio(request, response);
		Vector<ResultadoProveedorBeanData> resultados=new CriterioProveedorBeanFunction().buscarPlantillaProveedor(criterioProveedorData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/seleccionarproveedor.jsp");
		
	}
	
}
