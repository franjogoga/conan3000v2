package IngSoft.administracion.ambiente;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.AmbienteBeanFunction;
import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.TipoAmbienteMiniBeanData;

@SessionScoped
public class AccionModificarAmbiente extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			AmbienteBeanData ambienteData = ambienteFunction.crearAmbienteModificado(request, response);
			ambienteData.setCodigo(request.getParameter("codigo"));
			ambienteFunction.modificarAmbiente(ambienteData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/ambiente/buscarambiente.jsp");
		}	
		AmbienteBeanData ambienteData = ambienteFunction.consultarAmbiente(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=ambienteFunction.getSedes();
		Vector<TipoAmbienteMiniBeanData> tipoAmbienteMiniData=ambienteFunction.getTipoAmbiente();
		request.setAttribute("sedes",sedeMiniData);
		request.setAttribute("tiposAmbiente",tipoAmbienteMiniData);
		request.setAttribute("ambiente", ambienteData);
		this.direccionar(sc, request, response,"/IngSoft/administracion/ambiente/modificarambiente.jsp");
	}
}