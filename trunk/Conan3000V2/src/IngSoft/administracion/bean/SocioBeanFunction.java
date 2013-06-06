package IngSoft.administracion.bean;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class SocioBeanFunction {

	static private SocioBeanFunction FuncionSocio=null;
	private Lock l = new ReentrantLock();
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public static SocioBeanFunction getInstance() {
		if (FuncionSocio==null) FuncionSocio = new SocioBeanFunction();
		return FuncionSocio;
	}
	
	private SocioBeanFunction() {}
	
	public boolean vitalizarSocio(String codigo) throws CoException {
		boolean resultado = false;		
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		SocioBeanData datos = null;
		try {
			datos = sesion.selectOne("Data.administracion.socio.getSocio", codigo);			
			String strfechaInicio = datos.getFechaInicio().toString();											
			strfechaInicio = strfechaInicio.replace("-", "");
			int fechaInicio = Integer.parseInt(strfechaInicio);			
			
			Calendar c = Calendar.getInstance();									
			c.add(Calendar.YEAR, -30);
			int dia = c.get(Calendar.DATE);		
			int mes = 1+ c.get(Calendar.MONTH);
			int annio = c.get(Calendar.YEAR);
			int fechaActualmenos30 = annio*10000 + mes*100 + dia;													
			
			if (datos.getVitalicio().equalsIgnoreCase("No") && fechaInicio <= fechaActualmenos30) {							
				sesion.update("Data.administracion.socio.vitalizarSocio",codigo);
				resultado = true;
			}						
		} catch (Exception e2) {
			sesion.rollback();
			e2.printStackTrace();
			throw CoException.set("Error: No se pudo vitalizar el socio, intente nuevamente", "SMASocio?accion=Buscar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();
		}
		return resultado;
	}
	
	public SocioBeanData consultarSocio (String codigo) {
		SocioBeanData datos = null;
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			datos = sesion.selectOne("Data.administracion.socio.getSocio", codigo);			
		} finally {
			sesion.close();
		}				
		return datos;
	}
	
	
}