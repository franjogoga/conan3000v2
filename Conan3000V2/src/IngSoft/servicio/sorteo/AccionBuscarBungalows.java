package IngSoft.servicio.sorteo;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.servicio.bean.Utils;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioBungalowSorteoBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;

public class AccionBuscarBungalows extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
			SorteoBeanData sorteoData=sorteoFuncion.crearSorteo(request, response);
			request.setAttribute("sorteoData", sorteoData);
			sorteoData.setFechaReserva(Utils.fechaMas(sorteoData.getFechaSorteo(), 8));
			Vector<String> resultados = sorteoFuncion.getBungalowsSorteo(sorteoData);
			request.setAttribute("resultados", resultados);
			//sorteoFuncion.agregarSorteo(sorteoData);
			this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/buscarBungalows.jsp");
		}
		SorteoBeanFuncion sorteoFunction= SorteoBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFunction.getSedes();
		request.setAttribute("sedes",sedeMiniData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/agregarsorteo.jsp");
	}

}
