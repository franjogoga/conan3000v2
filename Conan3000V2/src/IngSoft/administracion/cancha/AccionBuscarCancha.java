package IngSoft.administracion.cancha;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CanchaBeanFunction;
import IngSoft.administracion.bean.CriterioCanchaBeanData;
import IngSoft.administracion.bean.CriterioCanchaBeanFunction;
import IngSoft.administracion.bean.ResultadoCanchaBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.TipoCanchaMiniBeanData;

public class AccionBuscarCancha extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioCanchaBeanData criterioCanchaData = new CriterioCanchaBeanFunction().crearCriterio(request,response);
			Vector<ResultadoCanchaBeanData> resultados = new CriterioCanchaBeanFunction().buscarCancha(criterioCanchaData);
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData=canchaFunction.getAmbientes();
			Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("tiposCancha",tipoCanchaMiniData);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
		}
		if(tipo==1){
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData=canchaFunction.getAmbientes();
			Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("tiposCancha",tipoCanchaMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
		}
	}
}