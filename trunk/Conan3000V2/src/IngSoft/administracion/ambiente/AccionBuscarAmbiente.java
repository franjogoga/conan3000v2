package IngSoft.administracion.ambiente;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.AmbienteBeanFunction;
import IngSoft.administracion.bean.CriterioAmbienteBeanData;
import IngSoft.administracion.bean.CriterioAmbienteBeanFunction;
import IngSoft.administracion.bean.ResultadoAmbienteBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.TipoAmbienteMiniBeanData;

public class AccionBuscarAmbiente extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		
		if(tipo==2){
		CriterioAmbienteBeanData criterioAmbienteData = new CriterioAmbienteBeanFunction().crearCriterio(request,response);
		Vector<ResultadoAmbienteBeanData> resultados = new CriterioAmbienteBeanFunction().buscarAmbiente(criterioAmbienteData);
		AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=ambienteFunction.getSedes();
		Vector<TipoAmbienteMiniBeanData> tipoAmbienteMiniData=ambienteFunction.getTipoAmbiente();
		request.setAttribute("sedes",sedeMiniData);
		request.setAttribute("tiposAmbiente",tipoAmbienteMiniData);
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/buscarambiente.jsp");
		}
		if(tipo==1){
			AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedeMiniData=ambienteFunction.getSedes();
			Vector<TipoAmbienteMiniBeanData> tipoAmbienteMiniData=ambienteFunction.getTipoAmbiente();
			request.setAttribute("sedes",sedeMiniData);
			request.setAttribute("tiposAmbiente",tipoAmbienteMiniData);	
			this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/buscarambiente.jsp");
		}
		 	
	}
}