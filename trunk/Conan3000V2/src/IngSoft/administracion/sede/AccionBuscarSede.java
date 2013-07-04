package IngSoft.administracion.sede;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.DepartamentoBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;

public class AccionBuscarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		if(tipo==2){
			CriterioSedeBeanData criterioSedeData =new CriterioSedeBeanFunction().crearCriterio(request,response);
			Vector<ResultadoSedeBeanData> resultados=new CriterioSedeBeanFunction().buscarPlantillaSede(criterioSedeData);
			Vector<DepartamentoBeanData> departamentos =SedeBeanFuncion.getInstance().getDepartamentos();			
			request.setAttribute("departamentos", departamentos);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		}
		if(tipo==1){
			Vector<DepartamentoBeanData> departamentos =SedeBeanFuncion.getInstance().getDepartamentos();
			Vector<ProvinciaBeanData> provincias =SedeBeanFuncion.getInstance().getProvincias(departamentos.get(0).getCodigo());
			Vector<DistritoBeanData> distritos =SedeBeanFuncion.getInstance().getDistritos(provincias.get(0).getCodigo());			
			request.setAttribute("distritos", distritos);
			request.setAttribute("provincias", provincias);
			request.setAttribute("departamentos", departamentos);
			this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		}
		if(tipo==3){
			Vector<ProvinciaBeanData> provincias =SedeBeanFuncion.getInstance().getProvincias(request.getParameter("cmbDepartamento")==null?"%":request.getParameter("cmbDepartamento").toString());			
			request.setAttribute("objeto", provincias);
			this.direccionar(sc, request, response, "/IngSoft/administracion/sede/cmbLista.jsp");

		}		
		if(tipo==4){
			Vector<DistritoBeanData> distritos =SedeBeanFuncion.getInstance().getDistritos(request.getParameter("cmbProvincia")==null?"%":request.getParameter("cmbProvincia").toString());			
			request.setAttribute("objeto", distritos);
			this.direccionar(sc, request, response, "/IngSoft/administracion/sede/cmbLista.jsp");

		}	
		
		
	}

}
