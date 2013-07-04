package IngSoft.administracion.actividad;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.administracion.bean.PersonaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class AccionSeleccionarFamiliar extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		System.out.print("AccionBuscarEmpleado ----->");
		

		
		PersonaBeanData personaData= new PersonaBeanData();
		personaData.setNombre("%"+request.getParameter("txtNombre")+"%");
		
		System.out.print("--> nombre --> "+ request.getParameter("txtNombre") );
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<PersonaBeanData> resultados=null;
		try{
			
		List<PersonaBeanData> resultadosEmp=sqlsesion.selectList("searchPlantillaFamiliaMatricula",personaData);
	
		resultados= new Vector<>(resultadosEmp);
		
		
		}
		finally{
		sqlsesion.close();}
		
		
		request.setAttribute("resultados", resultados);
		
		
		System.out.print("resultados ----->"+ resultados.size());
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/seleccionarfamiliar.jsp");	
		
		
		
		
		
		
		
		
	}
}
