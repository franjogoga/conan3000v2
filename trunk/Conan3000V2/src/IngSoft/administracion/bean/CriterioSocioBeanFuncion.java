package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import IngSoft.general.MyBatisSesion;

public class CriterioSocioBeanFuncion {

	public CriterioSocioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){				
		CriterioSocioBeanData criterioSocioData= new CriterioSocioBeanData();		
		criterioSocioData.setNombres("%"+request.getParameter("txtNombres")+"%");
		criterioSocioData.setApellidoMaterno("%"+request.getParameter("txtApellidoMaterno")+"%");
		criterioSocioData.setApellidoPaterno("%"+request.getParameter("txtApellidoPaterno")+"%");
		if (request.getParameter("cmdTipoDocumento")!=null){
			String est;
			est=request.getParameter("cmdTipoDocumento");
			criterioSocioData.setTipoDocumento(est);
		}
		return criterioSocioData;
	}
	
	public Vector<ResultadoSocioBeanData> buscarPlantillaSocio(CriterioSocioBeanData criterioSocioData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSocioBeanData> resultadosV = null;
		try{		
			List<ResultadoSocioBeanData> resultados=sqlsesion.selectList("searchSocios", criterioSocioData);					
			resultadosV= new Vector<>(resultados);
		} finally {
			sqlsesion.close();
		}
		return resultadosV;		
	}
}