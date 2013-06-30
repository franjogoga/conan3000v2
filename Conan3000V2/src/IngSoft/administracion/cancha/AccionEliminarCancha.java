package IngSoft.administracion.cancha;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CanchaBeanFunction;
import IngSoft.administracion.bean.CanchaBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.TipoCanchaMiniBeanData;

@SessionScoped
public class AccionEliminarCancha extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException{
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			canchaFunction.eliminarCancha(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
		}

		if(Integer.valueOf(request.getParameter("tipo"))==1){
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			CanchaBeanData canchaData=canchaFunction.consultarCancha(request.getParameter("codigo"));
			Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
			SedeMiniBeanData sede = canchaFunction.consultarCodigoSede(request.getParameter("codigo"));
			Vector<SedeMiniBeanData> sedes =canchaFunction.getSedes();
			Vector<AmbienteMiniBeanData> ambienteMiniData=canchaFunction.getAmbientes(sede.getCodigo());
			request.setAttribute("sedes",sedes);
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("tiposCancha",tipoCanchaMiniData);
			request.setAttribute("cancha",canchaData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/eliminarcancha.jsp");
	}
	this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
	}
}