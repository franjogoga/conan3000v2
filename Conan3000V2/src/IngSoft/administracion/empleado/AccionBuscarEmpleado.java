package IngSoft.administracion.empleado;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioEmpleadoBeanData;
import IngSoft.administracion.bean.CriterioEmpleadoBeanFunction;
import IngSoft.administracion.bean.CriterioEmpleadoBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.DepartamentoBeanData;
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;

public class AccionBuscarEmpleado extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		

		
		if(tipo==2){
			System.out.print("AccionBuscarEmpleado ----->");
			
			CriterioEmpleadoBeanData criterioEmpleadoData =new CriterioEmpleadoBeanFunction().crearCriterio(request,response);
			Vector<ResultadoEmpleadoBeanData> resultados=new CriterioEmpleadoBeanFunction().buscarPlantillaEmpleado(criterioEmpleadoData);
			//Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();	

			//request.setAttribute("tipoactividades", tipoactividades);
			
			
			
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleado/buscarempleado.jsp");	
			
		}

		
		
	}

}
