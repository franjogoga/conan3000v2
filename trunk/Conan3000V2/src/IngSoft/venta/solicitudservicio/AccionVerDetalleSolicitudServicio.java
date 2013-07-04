package IngSoft.venta.solicitudservicio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionVerDetalleSolicitudServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		//CriterioSocioBeanData criterioSocioData =new CriterioSocioBeanFuncion().crearCriterio(request, response);
		
		//Vector<ResultadoLinSolicServBeanData> resultados=new CriterioLinSolicServBeanFuncion().buscarPlantillaSocio();
		
		//request.setAttribute(name, o)
		//request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudservicio.jsp");
		
	}
}
