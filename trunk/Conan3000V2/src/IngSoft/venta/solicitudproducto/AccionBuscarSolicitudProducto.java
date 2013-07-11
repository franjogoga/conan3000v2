package IngSoft.venta.solicitudproducto;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioFamiliarBeanFuncion;
import IngSoft.venta.bean.CriterioSolicitudProductoBeanData;
import IngSoft.venta.bean.CriterioSolicitudProductoBeanFunction;
import IngSoft.venta.bean.ResultadoSolicitudProductoBeanData;

@SessionScoped
public class AccionBuscarSolicitudProducto extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioSolicitudProductoBeanData criterioSolicitudSocioData =new CriterioSolicitudProductoBeanFunction().crearCriterio(request, response);
		Vector<ResultadoSolicitudProductoBeanData> resultados=new CriterioSolicitudProductoBeanFunction().buscarPlantillaSolicitudProducto(criterioSolicitudSocioData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudproducto.jsp");
		
	}

}
