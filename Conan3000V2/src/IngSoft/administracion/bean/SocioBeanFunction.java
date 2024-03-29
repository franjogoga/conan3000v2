package IngSoft.administracion.bean;

import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
			String strfechaInicio = datos.getFechaInicio().toString();											
			strfechaInicio = strfechaInicio.replace("-", "");
			int fechaInicio = Integer.parseInt(strfechaInicio);			
			
			Calendar c = Calendar.getInstance();									
			c.add(Calendar.YEAR, -30);
			int dia = c.get(Calendar.DATE);		
			int mes = 1+ c.get(Calendar.MONTH);
			int annio = c.get(Calendar.YEAR);
			int fechaActualmenos30 = annio*10000 + mes*100 + dia;													
						
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
	
	public SocioBeanData consultarSocio (String codigo) throws CoException{
		SocioBeanData datos = null;
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			datos = sesion.selectOne("Data.administracion.socio.getSocio", codigo);			
		} finally {
			sesion.close();
		}				
		return datos;
	}
	
	public boolean suspenderSocio(String codigo, String descripcion) throws CoException{	
		l.lock();
		boolean resultado = false;		
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		SocioBeanData datos = null;
		try {
			datos = sesion.selectOne("Data.administracion.socio.getSocio", codigo);			
			if (datos.getEstado().equalsIgnoreCase("Activo")) {
				SuspensionBeanData datosSuspension = new SuspensionBeanData();			
				String codigoSuspension = (String)sesion.selectOne("Data.administracion.socio.getNextCodigoSuspension");			
				if (codigoSuspension != null) {
					int cod = Integer.parseInt(codigoSuspension.substring(3)) + 1;
					String defecto = "000000";				
					String temp = defecto.substring(0, defecto.length() - String.valueOf(cod).length()).concat(String.valueOf(cod));
					datosSuspension.setIdSuspensionPago(codigoSuspension.substring(0,3).concat(temp));
				}
				else datosSuspension.setIdSuspensionPago("SUS000001");	
				datosSuspension.setDescripcion(descripcion);
				datosSuspension.setIdMembresia(datos.getCodigo().toString());
				Calendar c = Calendar.getInstance();												
				int dia = c.get(Calendar.DATE);		
				int mes = 1+ c.get(Calendar.MONTH);
				int annio = c.get(Calendar.YEAR);
				String fechaRegistro = Integer.toString(annio) + "-" + Integer.toString(mes) + "-"+ Integer.toString(dia);			
				datosSuspension.setFechaRegistro(fechaRegistro);
				sesion.insert("Data.administracion.socio.insertSuspension", datosSuspension);	
				sesion.update("Data.administracion.socio.updateSuspendidoSocio", codigo);
				sesion.update("Data.administracion.socio.updateSuspendidoSocioEnUsuario", codigo);
			}
		} catch (Exception e3){
			sesion.rollback();
			e3.printStackTrace();
			throw CoException.set("Error: No se pudo suspender el socio, ya esta suspendido", "SMASocio?accion=Buscar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();
			l.unlock();
		}		
		return resultado;
	}

	public boolean activarSocio(String codigo) throws CoException {	
		l.lock();
		boolean resultado = false;
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			sesion.update("Data.administracion.socio.updateSuspendidoSocioActivar", codigo);
			sesion.update("Data.administracion.socio.updateSuspendidoSocioActivarEnUsuario", codigo);
			resultado = true;
		} catch (Exception e4) {
			sesion.rollback();
			e4.printStackTrace();
			throw CoException.set("Error: No se pudo activar al socio, ya esta activo", "SMASocio?accion=Buscar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();
			l.unlock();
		}				
		return resultado;
	}
	
}