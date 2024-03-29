package IngSoft.venta.solicitudsocio;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioSolicitudSocioBeanData;
import IngSoft.venta.bean.CriterioSolicitudSocioBeanFuncion;
import IngSoft.venta.bean.ResultadoSolicitudSocioBeanData;
@SessionScoped

public class AccionSeleccionarSolicitudSocio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		//String codigo=request.getParameter("codigo");
		
		//SolicitudSocioBeanFuncion solicitudFuncion=SolicitudSocioBeanFuncion.getInstanceS();
		//SolicitudsocioBeanData solicitud=solicitudFuncion.consultarSolicitud(codigo);
		
		//if(solicitud.getEstado().equalsIgnoreCase("Aceptada")){
			//solicitud.setEstado("Registrada");
			//solicitudFuncion.modificarSolicitud(solicitud);
		//}
		
		CriterioSolicitudSocioBeanData criterioSolicitudData =new CriterioSolicitudSocioBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoSolicitudSocioBeanData> resultados=new CriterioSolicitudSocioBeanFuncion().buscarPlantillaSolicitudAceptada(criterioSolicitudData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/seleccionarsolicitudsocio.jsp");
		
	}
	
}
