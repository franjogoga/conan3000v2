package IngSoft.administracion.configuracion;

import java.util.HashMap;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.bean.Conan3000ConstantesBeanFunction;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioSedeBeanData;

@SessionScoped
public class AccionModificarConfiguracion extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{		
		HashMap<String, Object> map= new HashMap<>();
		map.put("mInvitados", Double.valueOf(request.getParameter("txtMontoInvitados").toString()));
		map.put("costoBungalow", Double.valueOf(request.getParameter("txtCostoReservaBungalow").toString()));
		map.put("costoCancha", Double.valueOf(request.getParameter("txtCostoReservaCancha").toString()));
		map.put("pMembresia", Double.valueOf(request.getParameter("txtPrecioMembresia").toString()));
		map.put("mFalta", Double.valueOf(request.getParameter("txtMontoMulta").toString()));
		map.put("pSalonPrincipal", Double.valueOf(request.getParameter("txtMontoSalonPrincipal").toString()));
		map.put("mInvitadosBungalow", Double.valueOf(request.getParameter("txtMontoInvitadosBungalow").toString()));
		map.put("nMaxInvitados", Double.valueOf(request.getParameter("txtMaxInvitados").toString()));		
		Conan3000ConstantesBeanFunction cFuncion= Conan3000ConstantesBeanFunction.getInstance();
		cFuncion.actualizarConstantes(map);
		this.direccionar(sc, request, response,"/IngSoft/administracion/configuracion/configuracion.jsp");
	}
}