package IngSoft.administracion.sede;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.DepartamentoBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;

public class AccionAgregarSede extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		
		
		
		if(tipo==2){
			
			
			
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance();
		SedeBeanData sedeoData=sedeFuncion.crearSede(request, response);
		
		
		System.out.print(" AccionAgregarSede  ---> "+ tipo );
		
		sedeFuncion.agregarSede(sedeoData);
		
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		}
		Vector<DepartamentoBeanData> departamentos =SedeBeanFuncion.getInstance().getDepartamentos();
		Vector<ProvinciaBeanData> provincias =SedeBeanFuncion.getInstance().getProvincias(departamentos.get(0).getCodigo());
		Vector<DistritoBeanData> distritos =SedeBeanFuncion.getInstance().getDistritos(provincias.get(0).getCodigo());			
		request.setAttribute("distritos", distritos);
		request.setAttribute("provincias", provincias);
		request.setAttribute("departamentos", departamentos);		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/agregarsede.jsp");
	}

}
