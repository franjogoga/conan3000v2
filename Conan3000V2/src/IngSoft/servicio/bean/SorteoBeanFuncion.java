package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
			sorteoData.setDescripcion(request.getParameter("txtNombreSorteo"));
			sorteoData.setEstado(request.getParameter("txtCodigoSorteo"));
			}catch(Exception e){
				e.printStackTrace();		
			}
			return sorteoData;		
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
			
				sqlsesion.delete("deletePLantillaSorteo",codigo);
				
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
		
		public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
			sqlsesion.close();
			return new Vector<>(resultados);
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
