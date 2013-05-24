package IngSoft.servicio.juridica;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;



public class AccionBuscarJuridica extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		PersonaJuridicaBeanData JuridicaData =new JuridicaBeanFuncion().crearJuridica(request,response);
	
		
		PersonaJuridicaBeanData JuridicaData2 =new CriterioJuridicaBeanFunction().crearCriterio(request,response);
		Vector<ResultadoJuridicaBeanData> resultados= new CriterioJuridicaBeanFunction().buscarPlantillaJuridica(JuridicaData2);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
	
		
		
	}

}
