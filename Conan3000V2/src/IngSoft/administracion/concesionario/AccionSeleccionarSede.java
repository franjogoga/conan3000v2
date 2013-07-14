package IngSoft.administracion.concesionario;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.ConcesionarioSedeBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;

@SessionScoped
public class AccionSeleccionarSede extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)  throws CoException{
		ConcesionarioBeanFunction concesionarioFunction= ConcesionarioBeanFunction.getInstance();
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			System.out.println("ENTRO AL ACCION SELECCIONAR SEDE TIPO=2");
			ConcesionarioSedeBeanData concesionarioSede = concesionarioFunction.crearConcesionarioSede(request, response);
			concesionarioSede.setCodigoCon(request.getParameter("codigo"));
			concesionarioFunction.agregarConcesionarioSede(concesionarioSede);
			System.out.println("SALE AL ACCION SELECCIONAR SEDE TIPO=2");
		}
		else {
			System.out.println("ENTRO AL ACCION SELECCIONAR SEDE TIPO=1");
			ConcesionarioBeanData concesionarioData = concesionarioFunction.consultarConcesionario(request.getParameter("codigo"));
			request.setAttribute("concesionario",concesionarioData);
			Vector<SedeMiniBeanData> sedeMiniData=concesionarioFunction.getSedes(request.getParameter("codigo"));
			request.setAttribute("sedes",sedeMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/seleccionarsede.jsp");
			System.out.println("SALE AL ACCION SELECCIONAR SEDE TIPO=1");
		}
	}
}