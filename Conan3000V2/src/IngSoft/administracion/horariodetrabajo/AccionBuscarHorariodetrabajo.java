package IngSoft.administracion.horariodetrabajo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;



import IngSoft.administracion.bean.CriterioHorariodetrabajoBeanData;
import IngSoft.administracion.bean.CriterioHorariodetrabajoBeanFunction;
import IngSoft.administracion.bean.ResultadoHorariodetrabajoBeanData;


public class AccionBuscarHorariodetrabajo extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		

		
		
		if(tipo==1){
			

			
		}
		
		if(tipo==2){
			CriterioHorariodetrabajoBeanData criterioActividadData =new CriterioHorariodetrabajoBeanFunction().crearCriterio(request,response);
			Vector<ResultadoHorariodetrabajoBeanData> resultados=new CriterioHorariodetrabajoBeanFunction().buscarPlantillaHorariodetrabajo(criterioActividadData);


			System.out.print("entro aqui   -----x AccionBuscarHorariodetrabajo x-------1--- ");
			
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp");	
			
		}
		

		
		
	}

}
