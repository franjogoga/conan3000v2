package IngSoft.administracion.bungalow;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.administracion.bean.CriterioBungalowBeanData;
import IngSoft.administracion.bean.CriterioBungalowBeanFunction;
import IngSoft.administracion.bean.ResultadoBungalowBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;

public class AccionBuscarBungalow extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioBungalowBeanData criterioBungalowData = new CriterioBungalowBeanFunction().crearCriterio(request,response);
			Vector<ResultadoBungalowBeanData> resultados = new CriterioBungalowBeanFunction().buscarBungalow(criterioBungalowData);
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=bungalowFunction.getSedes();
			request.setAttribute("sedes",sedes);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		if(tipo==1){
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=bungalowFunction.getSedes();
			request.setAttribute("sedes",sedes);
			Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes(sedes.get(0).getCodigo());
			request.setAttribute("ambientes",ambienteMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		if(tipo==3){
			Vector<AmbienteMiniBeanData> ambientes =BungalowBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede")==null?"%":request.getParameter("cmbSede").toString());
			request.setAttribute("objeto", ambientes);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/cmbLista.jsp");
		}
		if(tipo==4){
			if("0".equals(request.getParameter("cmbSede"))){
				Vector<AmbienteMiniBeanData> ambientes = new Vector<AmbienteMiniBeanData>();
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/cmbLista2.jsp");
			}
			else{
				Vector<AmbienteMiniBeanData> ambientes =BungalowBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede").toString());
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/cmbLista2.jsp");
			}
		}		 	
	}
}