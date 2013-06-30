package IngSoft.administracion.servicio;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.ServicioBeanFunction;
import IngSoft.administracion.bean.CriterioServicioBeanData;
import IngSoft.administracion.bean.CriterioServicioBeanFunction;
import IngSoft.administracion.bean.ResultadoServicioBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

@SessionScoped
public class AccionBuscarServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioServicioBeanData criterioServicioData = new CriterioServicioBeanFunction().crearCriterio(request,response);
			Vector<ResultadoServicioBeanData> resultados = new CriterioServicioBeanFunction().buscarServicio(criterioServicioData);
			ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=servicioFunction.getSedes();
			request.setAttribute("sedes",sedes);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/buscarservicio.jsp");
		}
		if(tipo==1){
			ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
			Vector<SedeMiniBeanData> sedes=servicioFunction.getSedes();
			request.setAttribute("sedes",sedes);
			Vector<AmbienteMiniBeanData> ambienteMiniData=servicioFunction.getAmbientes(sedes.get(0).getCodigo());
			request.setAttribute("ambientes",ambienteMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/buscarservicio.jsp");
		}
		if(tipo==3){
			Vector<AmbienteMiniBeanData> ambientes =ServicioBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede")==null?"%":request.getParameter("cmbSede").toString());
			request.setAttribute("objeto", ambientes);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/cmbLista.jsp");
		}
		if(tipo==4){
			if("0".equals(request.getParameter("cmbSede"))){
				Vector<AmbienteMiniBeanData> ambientes = new Vector<AmbienteMiniBeanData>();
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/cmbLista2.jsp");
			}
			else{
				Vector<AmbienteMiniBeanData> ambientes =ServicioBeanFunction.getInstance().getAmbientes(request.getParameter("cmbSede").toString());
				request.setAttribute("objeto", ambientes);
				this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/cmbLista2.jsp");
			}
		}		
	}
}