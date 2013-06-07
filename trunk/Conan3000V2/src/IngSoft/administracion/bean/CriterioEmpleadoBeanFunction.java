package IngSoft.administracion.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.ResultadoEventoBeanData;
import IngSoft.administracion.bean.*;

public class CriterioEmpleadoBeanFunction {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public CriterioEmpleadoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioEmpleadoBeanData criterioEmpleadoData= new CriterioEmpleadoBeanData();
		criterioEmpleadoData.setNombre(request.getParameter("txtNombreEmpleado").trim()+"%");
		criterioEmpleadoData.setApellidoPaterno(("%" + request.getParameter("txtApellidoPaterno").trim()+"%").toUpperCase());
		//juridicaData.setRazonSocial(("%" + request.getParameter("txtRazonSocial").trim()+"%").toUpperCase());
		criterioEmpleadoData.setNumeroDocumento(Integer.parseInt(request.getParameter("txtNumeroDocumento")));
		criterioEmpleadoData.setArea(request.getParameter("cmbArea")==null?null:request.getParameter("cmbArea"));

		return criterioEmpleadoData;				
	}
	

	
	
	public Vector<ResultadoEmpleadoBeanData> buscarPlantillaEmpleado(CriterioEmpleadoBeanData criterioEmpleadoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoEmpleadoBeanData> resultadosV=null;
		try{		
		List<ResultadoEmpleadoBeanData> resultados=sqlsesion.selectList("Data.administracion.empleado.searchPlantillaEmpleado",criterioEmpleadoData);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	

}