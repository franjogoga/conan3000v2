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

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class SorteoBeanFuncion {
	static private SorteoBeanFuncion SorteoFuncion=null;
	private Lock l= new ReentrantLock();    
	private Lock lAB= new ReentrantLock();
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	public static SorteoBeanFuncion getInstance(){
		if(SorteoFuncion==null) SorteoFuncion= new SorteoBeanFuncion();
		return SorteoFuncion;
		}
	public SorteoBeanData crearSorteo(HttpServletRequest request, HttpServletResponse response){
		SorteoBeanData sorteoData= new SorteoBeanData();
		try{
			sorteoData.setIdSede(request.getParameter("cmbSedes"));
			sorteoData.setFechaInicio(new Date(DF.parse(request.getParameter("fFecInicio")).getTime()));
			sorteoData.setFechaFin(new Date(DF.parse(request.getParameter("fFecFin")).getTime()));
			sorteoData.setFechaSorteo(new Date(DF.parse(request.getParameter("fFecSorteo")).getTime()));
			sorteoData.setDescripcion(request.getParameter("txtNombre"));
			sorteoData.setEstado(request.getParameter("txtCodigoSorteo"));
			}catch(Exception e){
				e.printStackTrace();		
			}
			return sorteoData;		
		} 
	
	
	public Vector<String> getBungalowsSorteo(Date fSorteo){
		Vector<String>  bungalows= new Vector<>();
		try{
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			
			java.sql.Date fecha = new java.sql.Date(fSorteo.getTime());
			List<String> bunga =sqlsesion.selectList("Data.servicio.sorteo.getBungalows",fecha);
			bungalows = new Vector<>(bunga);
			}catch(Exception e){
				e.printStackTrace();		
			}
			bungalows.trimToSize();
			return bungalows;		
		}
	public double getCostoM2(){
		return 15;
	}
	
	public String getNombSocio(String idSocio){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		String nombSocio= sqlsesion.selectOne("Data.servicio.sorteo.selectGanador",idSocio);
		return nombSocio;
	}
	
	
	public void ingresaCostoBungalow(BungalowxSorteo bungalowSorteo){
		try {
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			sqlsesion.update("Data.club.inscripcionSorteo.updateCostoBungalow",bungalowSorteo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	public BungalowxSorteo getBungalowSorteo(BungalowxSorteo bungalowSorteo){
		BungalowxSorteo BS = new BungalowxSorteo();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<BungalowxSorteo> BS2 = sqlsesion.selectList("Data.club.inscripcionSorteo.getBungalowxSorteo2");
		int flag=0;
		int pagoRealizado=0;
		int i;
		int limite=0;
		while (BS2.get(limite).getIdSocio()!=null) {limite++;}
		for (i=0;i<limite;i++){
			
			if (BS2.get(i).getIdSocio().equals(bungalowSorteo.getIdSocio())) {
				flag++;
				BS.setIdBungalow("SI");
				
				if (BS2.get(i).getMontoBungalow()>0){pagoRealizado++;}
				break;
			} 
			else {BS.setIdBungalow("NO"); flag++;}
		}
		if (BS.getIdBungalow().equals("NO")) return BS;
		if (pagoRealizado>0) {BS.setIdBungalow("SI"); return BS;}
		BS = sqlsesion.selectOne("Data.club.inscripcionSorteo.getBungalowxSorteo",bungalowSorteo);
		BS.setIdSocio(bungalowSorteo.getIdSocio());
		BS.setIdSorteo(bungalowSorteo.getIdSorteo());
		float costoM2 = (float) getCostoM2(); 
		BS.setAreaBungalow((float)sqlsesion.selectOne("Data.club.inscripcionSorteo.getAreaBungalow",BS.getIdBungalow()));
		BS.setMontoBungalow((float) (costoM2*BS.getAreaBungalow()));
		sqlsesion.update("Data.club.inscripcionSorteo.setCostoBungalow",BS);
		sqlsesion.close();
		return BS;
	}
	
		public boolean agregarSorteo(SorteoBeanData sorteoData) throws CoException {
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
		public int getCantidad(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			int cant= Integer.parseInt((String)sqlsesion.selectOne("Data.servicio.sorteo.cantidadGanadores",idSorteo));
			return cant;
		}
		public int getCantidad2(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			int cant= Integer.parseInt((String)sqlsesion.selectOne("Data.club.inscripcionSorteo.cantidadGanadores2",idSorteo));
			return cant;
		}
		private Random generator = new Random();
		
		public Vector<String> getGanadores(Vector<SocioInscritoBeanData> listaInscritos,int n, String idSorteo){			
			Vector<String> Ramdomsocios = new Vector<>();
			int indiceRandom;
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<BungalowxSorteData> lista = sqlsesion.selectList("Data.servicio.sorteo.searchListaSorteo",idSorteo);
			int flag = n;
			if (n > listaInscritos.size()) flag=listaInscritos.size();
			for (int i=0; i<flag; i++){				
				indiceRandom=generator.nextInt(listaInscritos.size());
				listaInscritos.get(indiceRandom).setIdBungalow(lista.get(i).getIdBungalow());
				String nombre = sqlsesion.selectOne("Data.servicio.sorteo.selectGanador",listaInscritos.get(indiceRandom).getIdSocio());
				Ramdomsocios.add(nombre);
				sqlsesion.update("Data.servicio.sorteo.updateGanadores", listaInscritos.get(indiceRandom));			
				listaInscritos.remove(indiceRandom);
			}
			sqlsesion.update("Data.servicio.sorteo.updateFlagGanadores", idSorteo);
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
				/*socio=sqlsesion.selectOne("Data.servicio.sorteo.searchSocio","SOC000001");*/
				resultados.add(socio);
			}
			sqlsesion.close();
			resultados.trimToSize();
			return new Vector<>(resultados);
		}
		public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
		
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
		public boolean haySorteo2(String idSorteo){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			Integer flag=sqlsesion.selectOne("Data.club.inscripcionSorteo.searchHaySorteo2",idSorteo);
			sqlsesion.close();
			if (flag==1) {return true;}
			else {return false;}
		}
		private Vector<ModificacionesSorteoBeanData> generaListaCambios(String ant , String nue ,String cod){
			Vector<ModificacionesSorteoBeanData> mods=new Vector<ModificacionesSorteoBeanData>();
			Vector<String> antV= new Vector<String>(Arrays.asList(ant));
			Vector<String> nueV= new Vector<String>(Arrays.asList(nue));
			antV.remove("");
			nueV.remove("");
			for(int i=0;i<antV.size();i++){
				if(nueV.remove(antV.get(i))){
				antV.remove(i);
				i--;}
			}
			for(int i=0;i<nueV.size();i++){
				if(antV.remove(nueV.get(i))){
					nueV.remove(i);
					i--;
				}
				
			}
			while(true){
				if(antV.size()==0 && nueV.size()==0) break;
				ModificacionesSorteoBeanData cambio= new ModificacionesSorteoBeanData();
				if(antV.size()==0 || "".equals((String)antV.get(0)) ) {
					cambio.setCambio("I");
					cambio.setNuevo((String)nueV.get(0));
					nueV.remove(nueV.get(0));
					cambio.setIdSorteo(cod);
					mods.add(cambio);
					continue;					
					}
				if(nueV.size()==0 || "".equals((String)nueV.get(0)) ) {
					cambio.setCambio("D");
					cambio.setAntiguo((String)antV.get(0));
					antV.remove(antV.get(0));
					cambio.setIdSorteo(cod);
					mods.add(cambio);
					continue;}					
				else {
				cambio.setCambio("U");
				cambio.setAntiguo((String)antV.get(0));
				cambio.setNuevo((String)nueV.get(0));
				antV.remove(antV.get(0));
				nueV.remove(nueV.get(0));
				cambio.setIdSorteo(cod);
				mods.add(cambio);
				continue;
				}
							
			}
		
		return mods;
	}
		
		public void modificarSorteo(SorteoBeanData sorteo,String antSede) throws CoException {
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				/*Vector<ModificacionesSorteoBeanData> mods;
				mods= this.generaListaCambios(antSede, sorteo.getIdSede(),sorteo.getIdSorteo());
				for(int i=0;i<mods.size();i++){
					if("I".equals(mods.get(i).getCambio())) sqlsesion.insert("Data.servicio.sorteo.insertPlantillaSorteoSedesUpdate",(ModificacionesSorteoBeanData)mods.get(i));
					if("U".equals(mods.get(i).getCambio())) sqlsesion.update("Data.servicio.sorteo.updatePlantillaSorteoSedes",(ModificacionesSorteoBeanData)mods.get(i));	
					if("D".equals(mods.get(i).getCambio())) sqlsesion.delete("Data.servicio.sorteo.deletePlantillaSorteoSede",(ModificacionesSorteoBeanData)mods.get(i));	
				}	*/	

				sqlsesion.update("Data.servicio.sorteo.updatePlantillaSorteo",sorteo);
				
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMSSorteo?accion=Modificar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return ;
		}

}
