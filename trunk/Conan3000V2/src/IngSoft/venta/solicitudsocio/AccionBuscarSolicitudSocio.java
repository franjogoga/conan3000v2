package IngSoft.venta.solicitudsocio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioSolicitudSocioBeanData;
import IngSoft.venta.bean.CriterioSolicitudSocioBeanFuncion;
import IngSoft.venta.bean.ResultadoSolicitudSocioBeanData;

public class AccionBuscarSolicitudSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioSolicitudSocioBeanData criterioSolicitudSocioData =new CriterioSolicitudSocioBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoSolicitudSocioBeanData> resultados=new CriterioSolicitudSocioBeanFuncion().buscarPlantillaSolicitudSocio(criterioSolicitudSocioData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudsocio.jsp");
		
	}

}
