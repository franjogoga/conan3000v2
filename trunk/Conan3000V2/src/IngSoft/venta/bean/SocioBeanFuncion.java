package IngSoft.venta.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class SocioBeanFuncion {

	static private SocioBeanFuncion SocioFuncion=null;
	private Lock l= new ReentrantLock();     
	//SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static SocioBeanFuncion getInstance(){
	       if(SocioFuncion==null) SocioFuncion= new SocioBeanFuncion();
	       
	       return SocioFuncion;
	   }
	   
	   private SocioBeanFuncion() {}
	
	public SocioBeanData crearSocio(HttpServletRequest request, HttpServletResponse response){
		SocioBeanData socioData= new SocioBeanData();
		try{		
		//socioData.setNombres(request.getParameter("txtNombres"));
		socioData.setDireccion(request.getParameter("txtDireccion"));
		socioData.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
		socioData.setTelefonoFijo(Long.parseLong(request.getParameter("txtTelefonoFijo")));
		socioData.setTelefonoFijo(Long.parseLong(request.getParameter("txtTelefonoCelular")));
		socioData.setIdDistrito((request.getParameter("cmdDistrito")));
		
		//socioData.setLimiteInicio(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
		//socioData.setLimiteFin(new Date(DF.parse(request.getParameter("fFecFin")+"/0000").getTime()));
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return socioData;		
	} 
	
	public boolean agregarSocio(SocioBeanData socioData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigo3");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			socioData.setCodigo(codigo.substring(0,3).concat(temp));}
			else socioData.setCodigo("SOC000001");
			
			sqlsesion.insert("Data.venta.socio.insertSocio",socioData);
			//sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoSedes",eventoData);
			//sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoAmbiente",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
/*	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<AmbienteMiniBeanData> getAmbientes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<TipoEventoMiniBeanData> getTipoEvento(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<TipoEventoMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchTipoEventoMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}*/
}
