package IngSoft.servicio.bean;

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

public class CriterioEventoBeanFunction {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public CriterioEventoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioEventoBeanData criterioEventoData= new CriterioEventoBeanData();
		criterioEventoData.setNombre(request.getParameter("txtNombre")+"%");
		criterioEventoData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));

		try {
			criterioEventoData.setLimInicio(new Date(DF.parse(request.getParameter("date01")+"/0000").getTime()));
			criterioEventoData.setLimFin(new Date(DF.parse(request.getParameter("date02")+"/0000").getTime()));
			//System.out.println(criterioEventoData.getLimFin());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return criterioEventoData;				
	}
	
	public Vector<ResultadoEventoBeanData> buscarPlantillaEvento(CriterioEventoBeanData criterioEventoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<ResultadoEventoBeanData> resultados=sqlsesion.selectList("searchPlantillaEvento",criterioEventoData);
		System.out.println(resultados.size());
		Vector<ResultadoEventoBeanData> resultadosV= new Vector<>(resultados);
		System.out.println(resultadosV.size());
		return resultadosV;
		
	}

}
