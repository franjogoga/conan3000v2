package IngSoft.administracion.bean;

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
			if (datos.getVitalicio().equalsIgnoreCase("No")) {
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