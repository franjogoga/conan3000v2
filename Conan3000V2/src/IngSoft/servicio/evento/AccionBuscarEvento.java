package IngSoft.servicio.evento;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		CriterioEventoBeanData criterioEventoData =new CriterioEventoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoEventoBeanData> resultados=new CriterioEventoBeanFunction().buscarPlantillaEvento(criterioEventoData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarevento.jsp");
		
	}

}
