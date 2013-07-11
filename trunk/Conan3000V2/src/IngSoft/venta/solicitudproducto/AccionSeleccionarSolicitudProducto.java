package IngSoft.venta.solicitudproducto;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioSolicitudProductoBeanData;
import IngSoft.venta.bean.CriterioSolicitudProductoBeanFuncion;
import IngSoft.venta.bean.ResultadoSolicitudProductoBeanData;

@SessionScoped

public class AccionSeleccionarSolicitudProducto extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
	
		
		CriterioSolicitudProductoBeanData criterioSolicitudData =new CriterioSolicitudProductoBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoSolicitudProductoBeanData> resultados=new CriterioSolicitudProductoBeanFuncion().buscarPlantillaSolicitudAceptada(criterioSolicitudData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/seleccionarsolicitudsocio.jsp");
		
	}
	
}
