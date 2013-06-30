package IngSoft.servicio.juridica;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
@SessionScoped
public class AccionBuscarJuridica extends CoAccion {
	
	
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		//PersonaJuridicaBeanData JuridicaData =new JuridicaBeanFuncion().crearJuridica(request,response);
	
		CriterioJuridicaBeanFunction criterio = new CriterioJuridicaBeanFunction();
		PersonaJuridicaBeanData JuridicaData2 =criterio.crearCriterio(request,response);
		Vector<ResultadoJuridicaBeanData> resultados= criterio.buscarPlantillaJuridica(JuridicaData2);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
	
		
		
	}

}
