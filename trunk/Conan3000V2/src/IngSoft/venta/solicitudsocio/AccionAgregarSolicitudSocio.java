package IngSoft.venta.solicitudsocio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.DistritoMiniBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;
import IngSoft.venta.bean.SolicitudSocioBeanFuncion;
import IngSoft.venta.bean.SolicitudsocioBeanData;

public class AccionAgregarSolicitudSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					SolicitudSocioBeanFuncion SolicitudSocioFuncion= SolicitudSocioBeanFuncion.getInstanceS();
					SolicitudsocioBeanData SolicitudSocioData=SolicitudSocioFuncion.crearSolicitudSocio(request, response);

					SolicitudSocioFuncion.agregarSolicitudSocio(SolicitudSocioData);

					request.setAttribute("solicitudSocio", SolicitudSocioData);
					
					this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudsocio.jsp");
				
				}
				if(tipo==1){
					SocioBeanFuncion socioFunction= SocioBeanFuncion.getInstanceS();
					Vector<DistritoMiniBeanData> distritoMiniData=socioFunction.getDistritos();			
					
					request.setAttribute("tiposDistrito",distritoMiniData);	
					
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudsocio.jsp");
				}
	}

}
