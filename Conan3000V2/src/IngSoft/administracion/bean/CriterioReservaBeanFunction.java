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
		
		
		criterioReservaData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioReservaData;
	}
	
	public  Vector<ResultadoReservaBeanData> buscarPlantillaReserva(CriterioReservaBeanData criterioReservaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoReservaBeanData> resultadosV=null;
		try{
			
			System.out.print("searchPlantillaReservaInvitadoxSocio ----> ");
		List<ResultadoReservaBeanData> resultados=sqlsesion.selectList("searchPlantillaReservaInvitadoxSocio",criterioReservaData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
