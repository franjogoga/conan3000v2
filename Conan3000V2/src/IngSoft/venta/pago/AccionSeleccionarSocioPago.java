package IngSoft.venta.pago;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioPagoBeanFunction;
import IngSoft.venta.bean.CriterioSocioBeanData;
import IngSoft.venta.bean.CriterioSocioBeanFuncion;
import IngSoft.venta.bean.ResultadoSocioBeanData;
@SessionScoped
public class AccionSeleccionarSocioPago extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioSocioBeanData criterioSocioData =new CriterioSocioBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoSocioBeanData> resultados=new CriterioPagoBeanFunction().buscarSocioMembresia(criterioSocioData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/seleccionarsocio.jsp");
		
	}
}
