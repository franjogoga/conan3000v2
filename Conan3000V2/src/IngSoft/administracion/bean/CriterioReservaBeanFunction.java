package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioReservaBeanFunction {
	
	public CriterioReservaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioReservaBeanData criterioReservaData = new CriterioReservaBeanData();		
		
		
		criterioReservaData.setCodigoinvitado("%"+request.getParameter("txtCodigoInvitado")+"%");

		return criterioReservaData;
	}
	
	public  Vector<ResultadoReservaBeanData> buscarPlantillaReserva(CriterioReservaBeanData criterioReservaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoReservaBeanData> resultadosV=null;
		try{
			
		List<ResultadoReservaBeanData> resultados=sqlsesion.selectList("searchPlantillaReserva",criterioReservaData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	public Vector<ResultadoReservaBeanData> buscarReserva(CriterioReservaBeanData criterio) {
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		Vector<ResultadoReservaBeanData> resultadosV = null;
		try {
			List<ResultadoReservaBeanData> resultados = sesion.selectList("searchPlantillaReserva", criterio);
			resultadosV = new Vector<>(resultados);
		} finally {
			sesion.close();
		}
		return resultadosV;
	}
}
