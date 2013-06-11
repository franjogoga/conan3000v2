package IngSoft.servicio.bean;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class InscripcionBeanFuncion {
	static private InscripcionBeanFuncion SorteoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	public static InscripcionBeanFuncion getInstance(){
		if(SorteoFuncion==null) SorteoFuncion= new InscripcionBeanFuncion();
		return SorteoFuncion;
		}
	public InscripcionBeanData crearSorteo(HttpServletRequest request, HttpServletResponse response){
		InscripcionBeanData sorteoData= new InscripcionBeanData();
		try{
			sorteoData.setNombre(request.getParameter("txtNombreSorteo"));
			sorteoData.setIdSede(request.getParameter("cmbSedes"));
			sorteoData.setFechaInicio(new Date(DF.parse(request.getParameter("fFecIncio")).getTime()));
			sorteoData.setFechaFin(new Date(DF.parse(request.getParameter("fFecFin")).getTime()));
			sorteoData.setFechaSorteo(new Date(DF.parse(request.getParameter("fFecSorteo")).getTime()));

			}catch(Exception e){
				e.printStackTrace();		
			}
			return sorteoData;		
		} 
		
		public boolean agregarSorteo(InscripcionBeanData sorteoData) throws CoException {
			boolean resultado=false;		
			l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				String codigo= (String)sqlsesion.selectOne("Data.servicio.sorteo.getNextCodigo");
				if(codigo!=null){
				int cod= Integer.parseInt(codigo.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
				
				sorteoData.setIdSorteo(codigo.substring(0,3).concat(temp));}
				else sorteoData.setIdSorteo("PSO000001");
				sqlsesion.insert("insertPlantillaSorteo",sorteoData);
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: Nombre de sorteo repetido", "SMSSorteo?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();
				l.unlock();					
			}
				
			return resultado;
		}
		
		public boolean eliminarSorteo(String codigo) throws CoException {
			boolean resultado=false;		
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
			
				sqlsesion.update("update2PLantillaSorteo",codigo);
				
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMSSorteo?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return resultado;
		}
		
		public SorteoBeanData consultarSorteo(String codigo){
			SorteoBeanData sorteoData=null;
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				sorteoData= sqlsesion.selectOne("Data.servicio.sorteo.getPLantillaSorteo",codigo);
			}
			finally{
				sqlsesion.close();
			}
			return sorteoData;
		}
		/*
		public Vector<SocioInscritoBeanData> getInscritos(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SocioInscritoBeanData> resultados=sqlsesion.selectList("Data.servicio.sorteo.searchInscritos",idSorteo);
			sqlsesion.close();
			Vector<SocioInscritoBeanData> prueba = new Vector<>();
			for (int i=0; i<resultados.size();i++){
				prueba.add(resultados.get(i));
			}
			prueba.trimToSize();
			return new Vector<>(prueba);
		}
		*/
		public int getCantidad(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			int cant= Integer.parseInt((String)sqlsesion.selectOne("Data.servicio.sorteo.cantidadGanadores",idSorteo));
			return cant;
		}
		private Random generator = new Random();
		/*
		public Vector<String> getGanadores(Vector<SocioInscritoBeanData> listaInscritos,int n, String idSorteo){			
			Vector<String> Ramdomsocios = new Vector<>();
			int indiceRandom;
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<BungalowxSorteData> lista = sqlsesion.selectList("Data.servicio.sorteo.searchListaSorteo",idSorteo);
			for (int i=0; i<n; i++){				
				indiceRandom=generator.nextInt(listaInscritos.size());
				listaInscritos.get(indiceRandom).setIdBungalow(lista.get(i).getIdBungalow());
				String nombre = sqlsesion.selectOne("Data.servicio.sorteo.selectGanador",listaInscritos.get(indiceRandom).getIdSocio());
				Ramdomsocios.add(nombre);
				sqlsesion.update("Data.servicio.sorteo.updateGanadores", listaInscritos.get(indiceRandom));
				listaInscritos.remove(indiceRandom);
			}
			Ramdomsocios.trimToSize();
			sqlsesion.close();
			return new Vector<>(Ramdomsocios);
		}
		
		
		public Vector<String> consultaGanadores(String idSorteo, int n){			
			Vector<String> Ramdomsocios = new Vector<>();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<BungalowxSorteData> lista = sqlsesion.selectList("Data.servicio.sorteo.searchListaSorteo",idSorteo);
			for (int i=0; i<n; i++){
				String nombre = sqlsesion.selectOne("Data.servicio.sorteo.selectGanador",lista.get(i).getIdSocio());
				Ramdomsocios.add(nombre);
			}
			Ramdomsocios.trimToSize();
			sqlsesion.close();
			return new Vector<>(Ramdomsocios);
		}
		
		public Vector<SocioBeanData> getNombGanadores(Vector<SocioInscritoBeanData> listaGanadores){			
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			Vector<SocioBeanData> resultados=new Vector<SocioBeanData>();
			SocioBeanData socio=new SocioBeanData();
			for (int i=0; i <listaGanadores.size();i++){
				socio=sqlsesion.selectOne("Data.servicio.sorteo.searchSocio",listaGanadores.get(i).getIdSocio());
				resultados.add(socio);
			}
			sqlsesion.close();
			resultados.trimToSize();
			return new Vector<>(resultados);
		}
		*/
		public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
		/*
		public boolean haySorteo(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<BungalowxSorteData> lista=sqlsesion.selectList("Data.servicio.sorteo.searchListaSorteo",idSorteo);
			sqlsesion.close();
			for (int i=0;i<lista.size();i++){
				if (lista.get(i).getIdSocio()==null) return true;
			}
			if (lista.size()==0) return false;
			return false;
		}
		*/
		
		

}