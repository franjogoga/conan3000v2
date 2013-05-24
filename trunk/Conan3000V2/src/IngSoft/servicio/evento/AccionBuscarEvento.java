package IngSoft.servicio.evento;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ResultadoEventoBeanData;

public class AccionBuscarEvento extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		HttpSession sesion= request.getSession(true);
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
		CriterioEventoBeanData criterioEventoData =new CriterioEventoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoEventoBeanData> resultados=new CriterioEventoBeanFunction().buscarPlantillaEvento(criterioEventoData);
		
		sesion.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/resultados.jsp");
		}
		if(tipo==1){
			sesion.removeAttribute("resultados");
			this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarevento.jsp");
			} 
		
		
	}

}
