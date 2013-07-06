package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
@ApplicationScoped
public class CriterioFamiliarBeanFuncion {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioFamiliarBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioFamiliarBeanData criterioFamiliarData= new CriterioFamiliarBeanData();
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
			criterioFamiliarData.setNombres(request.getParameter("txtNombres")+"%");	
			criterioFamiliarData.setApellidoPaterno(request.getParameter("txtApellidoPaterno")+"%");
			criterioFamiliarData.setApellidoMaterno(request.getParameter("txtApellidoMaterno")+"%");
			
			//if (request.getParameter("rButton")!=null){
			//String est;
			//est=request.getParameter("rButton");
			//criterioMembresiaData.setEstado(est);}
		return criterioFamiliarData;				
	}
	
	public Vector<ResultadoFamiliarBeanData> buscarPlantillaFamiliar(CriterioFamiliarBeanData criterioFamiliarData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoFamiliarBeanData> resultadosV=null;
		try{		
		List<ResultadoFamiliarBeanData> resultados=sqlsesion.selectList("searchPlantillaFamiliar",criterioFamiliarData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
