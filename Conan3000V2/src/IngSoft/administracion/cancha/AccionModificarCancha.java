package IngSoft.administracion.cancha;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CanchaBeanFunction;
import IngSoft.administracion.bean.CanchaBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.TipoCanchaMiniBeanData;

public class AccionModificarCancha extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			CanchaBeanData canchaData = canchaFunction.crearCanchaModificado(request, response);
			canchaData.setCodigo(request.getParameter("codigo"));
			canchaFunction.modificarCancha(canchaData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/cancha/buscarcancha.jsp");
		}	
		CanchaBeanData canchaData = canchaFunction.consultarCancha(request.getParameter("codigo"));
		Vector<AmbienteMiniBeanData> ambienteMiniData=canchaFunction.getAmbientes();
		Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
		request.setAttribute("ambientes",ambienteMiniData);
		request.setAttribute("tiposCancha",tipoCanchaMiniData);
		request.setAttribute("cancha",canchaData);
		this.direccionar(sc, request, response,"/IngSoft/administracion/cancha/modificarcancha.jsp");
	}
}