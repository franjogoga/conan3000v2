package IngSoft.administracion.bean;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class PerfilBeanFunction {

	static private PerfilBeanFunction FuncionPerfil=null;
	private Lock l = new ReentrantLock();
	
	public static PerfilBeanFunction getInstance() {
		if (FuncionPerfil==null) FuncionPerfil = new PerfilBeanFunction();
		return FuncionPerfil;
	}
	
	private PerfilBeanFunction() {}
	
	public PerfilBeanData crearPerfil(HttpServletRequest request, HttpServletResponse response){
		PerfilBeanData dataPerfil = new PerfilBeanData();
		try {
			dataPerfil.setNombre(request.getParameter("txtNombre"));
			dataPerfil.setDescripcion(request.getParameter("txtDescripcion"));
		} catch (Exception e){
			e.printStackTrace();
		}
		return dataPerfil;
	}
	
	public boolean agregarPerfil(PerfilBeanData dataPerfil) throws CoException {
		boolean resultado = false;
		l.lock();
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			String codigo = (String)sesion.selectOne("Data.administracion.perfiles.getNextCodigo");
			if (codigo != null) {
				int cod = Integer.parseInt(codigo.substring(3)) + 1;
				String defecto = "000000";
				String temp = defecto.substring(0, defecto.length() - String.valueOf(cod).length()).concat(String.valueOf(cod));
				dataPerfil.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else dataPerfil.setCodigo("PER000001");
			
			sesion.insert("Data.administracion.perfiles.insertPerfil", dataPerfil);
			resultado = true;
		} catch (Exception ex) {
			sesion.rollback();
			ex.printStackTrace();
			throw CoException.set("Error: Nombre de Perfil Repetido", "SMAPerfil?accion=Agregar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();
			l.unlock();
		}
		
		return resultado;
	}
	
	public boolean eliminarPerfil(String codigo) throws CoException {
		boolean resultado = false;
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			sesion.update("Data.administracion.perfiles.deletePerfil", codigo);
			resultado = true;
		} catch (Exception e1){
			sesion.rollback();
			e1.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el Perfil de Usuario intente nuevamente", "SMAPerfil?accion=Agregar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();
		}		
		return resultado;
	}
	
	public PerfilBeanData consultarPerfil (String codigo) {
		PerfilBeanData dataPerfil = null;
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			dataPerfil = sesion.selectOne("Data.administracion.perfiles.getPerfil", codigo);			
		} finally {
			sesion.close();
		}				
		return dataPerfil;
	}
	
	public boolean modificarPerfil(PerfilBeanData dataPerfil) throws CoException {
		boolean resultado = false;		
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		try {
			sesion.update("Data.administracion.perfiles.updatePerfil",dataPerfil);
			resultado = true;
		} catch (Exception e2) {
			sesion.rollback();
			e2.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el perfil de usuario, intente nuevamente", "SMAPerfil?accion=Modificar&tipo=1");
		} finally {
			sesion.commit();
			sesion.close();			
		}
		return resultado;
	}
}
