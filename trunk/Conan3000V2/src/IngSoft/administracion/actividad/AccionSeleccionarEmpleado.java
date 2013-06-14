package IngSoft.administracion.actividad;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioEmpleadoBeanData;
import IngSoft.administracion.bean.CriterioEmpleadoBeanFunction;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.venta.bean.CriterioSocioBeanData;
import IngSoft.venta.bean.CriterioSocioBeanFuncion;
import IngSoft.venta.bean.ResultadoSocioBeanData;

public class AccionSeleccionarEmpleado extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		System.out.print("AccionBuscarEmpleado ----->");
		

		
		CriterioEmpleadoBeanData criterioEmpleadoData= new CriterioEmpleadoBeanData();
		criterioEmpleadoData.setNombre("%"+request.getParameter("txtNombre")+"%");
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoEmpleadoBeanData> resultados=null;
		try{
			
		List<ResultadoEmpleadoBeanData> resultadosEmp=sqlsesion.selectList("searchPlantillaEmpleadoAndres",criterioEmpleadoData);
	
		resultados= new Vector<>(resultadosEmp);
		
		
		}
		finally{
		sqlsesion.close();}
		
		
		request.setAttribute("resultados", resultados);
		
		
		System.out.print("resultados ----->"+ resultados.size());
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/seleccionarempleado.jsp");	
		
		
		
		
		
		
		
		
	}
}
