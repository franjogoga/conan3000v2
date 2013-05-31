package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioInvitadoBeanFunction {
	
	public CriterioInvitadoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioInvitadoBeanData criterioInvitadoData = new CriterioInvitadoBeanData();		
		
		criterioInvitadoData.setCodigo(request.getParameter("txtCodigo")+"%");
		criterioInvitadoData.setNombre(request.getParameter("txtNombre")+"%");
		if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			criterioInvitadoData.setEstado(est);}
		return criterioInvitadoData;
	}
	
	public  Vector<ResultadoInvitadoBeanData> buscarPlantillaInvitado(CriterioInvitadoBeanData criterioInvitadoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoInvitadoBeanData> resultadosV=null;
		try{		
		List<ResultadoInvitadoBeanData> resultados=sqlsesion.selectList("searchPlantillaInvitado",criterioInvitadoData);
	
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
