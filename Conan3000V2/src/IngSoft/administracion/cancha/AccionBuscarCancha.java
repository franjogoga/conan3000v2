package IngSoft.administracion.cancha;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
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
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.TipoCanchaMiniBeanData;

@SessionScoped
public class AccionBuscarCancha extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioCanchaBeanData criterioCanchaData = new CriterioCanchaBeanFunction().crearCriterio(request,response);
			Vector<ResultadoCanchaBeanData> resultados = new CriterioCanchaBeanFunction().buscarCancha(criterioCanchaData);
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=canchaFunction.getSedes();
			Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
			request.setAttribute("sedes",sedes);
			request.setAttribute("tiposCancha",tipoCanchaMiniData);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
		}
		if(tipo==1){
			CanchaBeanFunction canchaFunction= CanchaBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=canchaFunction.getSedes();
			Vector<AmbienteMiniBeanData> ambienteMiniData=canchaFunction.getAmbientes(sedes.get(0).getCodigo());
			Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData=canchaFunction.getTipoCancha();
			request.setAttribute("sedes",sedes);
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("tiposCancha",tipoCanchaMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/buscarcancha.jsp");
		}

		if(tipo==3){
			Vector<AmbienteMiniBeanData> ambientes =CanchaBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede")==null?"%":request.getParameter("cmbSede").toString());
			request.setAttribute("objeto", ambientes);
			this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/cmbLista.jsp");
		}
		if(tipo==4){
			if("0".equals(request.getParameter("cmbSede"))){
				Vector<AmbienteMiniBeanData> ambientes = new Vector<AmbienteMiniBeanData>();
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/cmbLista2.jsp");
			}
			else{
				Vector<AmbienteMiniBeanData> ambientes =CanchaBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede").toString());
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/cancha/cmbLista2.jsp");
			}
		}
	}
}