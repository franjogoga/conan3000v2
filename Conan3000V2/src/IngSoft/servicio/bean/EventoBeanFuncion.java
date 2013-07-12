package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.venta.bean.OrdenPagoBeanFunction;

public class EventoBeanFuncion {	
	
	static private EventoBeanFuncion EventoFuncion=null;
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	private Lock l5= new ReentrantLock();
	private Lock l6= new ReentrantLock();
	private Lock l7= new ReentrantLock();
	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static EventoBeanFuncion getInstance(){
	       if(EventoFuncion==null) EventoFuncion= new EventoBeanFuncion();
	       
	       return EventoFuncion;
	   }
	   
	   private EventoBeanFuncion() {}
	
	   
	   public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
	   
	   public Vector<ConcesionarioMiniBeanData> consultarConcesionariosxSede(String idSede, java.util.Date fecha){
		   Vector<ConcesionarioMiniBeanData> resultados= null;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{			   
				   HashMap<String, Object> hashMap = new HashMap<String, Object>(); 
				   hashMap.put("idsede",idSede); 
				   hashMap.put("fecha", fecha);				   				   
				   List<ConcesionarioMiniBeanData> temp= sqlsesion.selectList("Data.servicio.evento.getConcecionarioxSede",hashMap);
				   resultados= new Vector<ConcesionarioMiniBeanData>(temp); 
		   }
		   catch(Exception e){
			   e.printStackTrace();			   
		   }
		   finally{
			   sqlsesion.close();			   
		   }
		   return resultados;
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
		}
		public EventoBeanData crearEvento(HttpServletRequest request, HttpServletResponse response){
			EventoBeanData eventoData= new EventoBeanData();
			String temp=null;
			try{					
			eventoData.setIdSede(request.getParameter("cmbSedes"));			
			eventoData.setNombre(request.getParameter("txtNombreEvento").trim());			
			eventoData.setFecha(new java.sql.Date(DF.parse(request.getParameter("fFecha")).getTime()));			
			temp=request.getParameter("txtNumEntradas");
			temp=(temp==null||temp.isEmpty())?"0":temp;
			eventoData.setLimiteEntradas(Integer.parseInt(temp));			
			temp= request.getParameter("precioentrada");
			temp=(temp==null||temp.isEmpty())?"0.00":temp;
			temp= temp.contains(".")?temp:temp+".00";
			eventoData.setPrecioEntrada(Double.parseDouble(temp));
			temp= request.getParameter("precioentradaI");
			temp=(temp==null||temp.isEmpty())?"0.00":temp;
			temp= temp.contains(".")?temp:temp+".00";
			eventoData.setPrecioEntradaI(Double.parseDouble(temp));
			eventoData.setIdConcesionario(request.getParameter("concesionario"));
			temp=request.getParameter("costo");
			temp=(temp==null||temp.isEmpty())?"0":temp;
			eventoData.setMonto(Double.parseDouble(temp));			
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return eventoData;		
		} 
		
	   
	
	
	public boolean agregarEventoSede(EventoBeanData eventoData) throws CoException {
		boolean resultado=false;		
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.servicio.evento.getNextCodigoSdE");
			codigo=codigo==null?"ESD000000":codigo;
			codigo=Utils.generaSiguienteCodigo(codigo);
			eventoData.setCodigo(codigo);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("codigo", eventoData.getCodigo());
			map.put("nombre", eventoData.getNombre());
			map.put("limiteE", eventoData.getLimiteEntradas());
			map.put("precio", eventoData.getPrecioEntrada());
			map.put("precioI", eventoData.getPrecioEntradaI());
			map.put("sede", eventoData.getIdSede());
			map.put("fecha", eventoData.getFecha());
			map.put("concesionario", eventoData.getIdConcesionario());
			sqlsesion.insert("Data.servicio.evento.insertEventoxSede",map);
			sqlsesion.commit();
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");			
		}		
		finally{			
			sqlsesion.close();
			l1.unlock();					
		}
			
		return resultado;
	}
	
	public boolean agregarEventoSocio(EventoBeanData eventoData, HttpServletRequest request) {
		boolean resultado=false;
		l2.lock();
		HttpSession sesion= request.getSession();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		 
		try{
			String codigo= (String)sqlsesion.selectOne("Data.servicio.evento.getNextCodigoScE");
			codigo=codigo==null?"ESC000000":codigo;
			codigo=Utils.generaSiguienteCodigo(codigo);
			eventoData.setCodigo(codigo);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("codigo", eventoData.getCodigo());
			map.put("nombre", eventoData.getNombre());
			map.put("socio", sesion.getAttribute("idSocio").toString());
			map.put("monto", eventoData.getMonto());
			map.put("sede", eventoData.getIdSede());
			map.put("fecha", eventoData.getFecha());
			map.put("concesionario", eventoData.getIdConcesionario());
			sqlsesion.insert("Data.servicio.evento.insertEventoxSocio",map);
			sqlsesion.commit();
			//orden.agregarOrdenPago("EVENTOSOCIO", codigo,"" , sesion.getAttribute("idSocio").toString(), Double.valueOf(eventoData.getMonto()), new java.sql.Date(new java.util.Date().getTime()),  new java.sql.Date(eventoData.getFecha().getTime()));

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");			
		}		
		finally{			
			sqlsesion.close();
			l2.unlock();					
		}
			
		
		return resultado;
		
	}
	
	public Vector<EventoBeanData> buscarSolicitudesEventoSede(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EventoBeanData> resultadosV=null;
		try{
		
		List<EventoBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchEventoSedeMini",map);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	public Vector<EventoBeanData> buscarSolicitudesEventoSedeSocio(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EventoBeanData> resultadosV=null;
		try{		
		List<EventoBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchEventoSedeMiniSocio",map);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
	public Vector<EventoBeanData> buscarSolicitudesEventoSocio(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EventoBeanData> resultadosV=null;
		try{
		
		List<EventoBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchEventoSocioMini",map);
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	public Vector<EventoBeanData> buscarSolicitudesEventoCorp(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EventoBeanData> resultadosV=null;
		try{
		
		List<EventoBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchEventoCorpMini",map);
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	public boolean aprobarEventoSocio(String codigo){
		l4.lock();
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
		try{
			EventoBeanData eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoSocio",codigo);
			sqlsesion.update("Data.servicio.evento.aprobarEventoSocio", codigo);
			HashMap<String,	Object> map= new HashMap<>();
			map.put("fecha",  eventoData.getFecha());
			map.put("sede", eventoData.getIdSede());
			sqlsesion.update("Data.servicio.evento.anularEventoCorpMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSedeMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSocioMasivo", map);
			sqlsesion.update("Data.servicio.evento.aprobarEventoSocio", codigo);
			orden.agregarOrdenPago("EVENTOSOCIO", eventoData.getCodigo(),"" , eventoData.getSocio(), eventoData.getMonto(), new java.sql.Date(new java.util.Date().getTime()),  new java.sql.Date(eventoData.getFecha().getTime()));
			resultado=true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();
			l4.unlock();
		}
		return resultado;
	}
	
	public boolean aprobarEventoSede(String codigo){
		l5.lock();
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try {
			EventoBeanData eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoSede",codigo);
			sqlsesion.update("Data.servicio.evento.aprobarEventoSede", codigo);
			HashMap<String,	Object> map= new HashMap<>();
			map.put("fecha",  eventoData.getFecha());
			map.put("sede", eventoData.getIdSede());
			sqlsesion.update("Data.servicio.evento.anularEventoCorpMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSedeMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSocioMasivo", map);
			sqlsesion.update("Data.servicio.evento.aprobarEventoSede", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			sqlsesion.close();
			l5.unlock();
		}
		return resultado;				
	}
	
	public boolean aprobarEventoCorp(String codigo){
		l4.lock();
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
		try{
			EventoBeanData eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoCorp",codigo);
			sqlsesion.update("Data.servicio.evento.aprobarEventoCorp", codigo);
			HashMap<String,	Object> map= new HashMap<>();
			map.put("fecha",  eventoData.getFecha());
			map.put("sede", eventoData.getIdSede());
			sqlsesion.update("Data.servicio.evento.anularEventoCorpMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSedeMasivo", map);
			sqlsesion.update("Data.servicio.evento.anularEventoSocioMasivo", map);	
			sqlsesion.update("Data.servicio.evento.aprobarEventoCorp", codigo);
			orden.agregarOrdenPago("EVENTOCORPORATIVO", eventoData.getCodigo(), "", eventoData.getJuridica(), eventoData.getMonto(), new Date( new java.util.Date().getTime()), new Date(eventoData.getFecha().getTime()));			
			resultado=true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();
			l4.unlock();
		}
		return resultado;
	}
	
	
	public boolean anularEventoSocio(String codigo){
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
		try{
			sqlsesion.update("Data.servicio.evento.anularEventoSocio", codigo);			
			resultado=true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();
		}
		return resultado;
	}
	public boolean anularEventoSede(String codigo){
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try {
			sqlsesion.update("Data.servicio.evento.anularEventoSede", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			sqlsesion.close();
		}
		return resultado;				
	}
	public boolean anularEventoCorp(String codigo){
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try {
			sqlsesion.update("Data.servicio.evento.anularEventoCorp", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			sqlsesion.close();
		}
		return resultado;				
	}
	public int registarSocioEventoSede(String codigo,String socio,int cantEntradas){
		int resultado=-1;
		l3.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
		try{
			EventoBeanData eventoData= this.consultarEventoSede(codigo);
			int libres=eventoData.getLimiteEntradas()-eventoData.getEntradasTotal();
			if(libres>=cantEntradas){
			sqlsesion.update("Data.servicio.evento.aprobarEventoSocio", codigo);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("codigo", eventoData.getCodigo());
			map.put("cantidad", cantEntradas);
			map.put("socio", socio);
			map.put("monto", cantEntradas*eventoData.getMonto());
			sqlsesion.update("Data.servicio.evento.actEntradasEventoSede", map);
			sqlsesion.insert("Data.servicio.evento.inscribirEventoSede", map);
			orden.agregarOrdenPago("SOCIOXEVENTOSEDE", codigo, "", socio, cantEntradas*eventoData.getMonto(), new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(eventoData.getFecha().getTime()));
			resultado=0;}
			else resultado=libres;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();
			l3.unlock();
		}
		return resultado;
	}
		
	public EventoBeanData consultarEventoSede(String codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoSede",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	}
	public EventoBeanData consultarEventoSocio(String codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoSocio",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	} 
	public EventoBeanData consultarEventoCorp(String codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("Data.servicio.evento.searchEventoCorp",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	} 
	public Vector<InvitadosMiniBeanData> consultarInvitadosEventoCorp(String codigo){
		List<InvitadosMiniBeanData> invitados=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			invitados= sqlsesion.selectList("Data.servicio.evento.getInvitadosEventosCorp",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return new Vector<InvitadosMiniBeanData>(invitados);
	} 

	public HashMap<String, Object> crearCriterio(HttpServletRequest request,
			HttpServletResponse response) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		HashMap<String, Object> map=new HashMap<String, Object>();
		String temp=request.getParameter("cmbEstados").toString();
		map.put("estado",temp.equals("all")?"%":temp);
		map.put("nombre","%"+request.getParameter("txtNombre").toString()+"%");
		try{
		map.put("FI", df.parseObject(request.getParameter("date01")));
		map.put("FF",  df.parseObject(request.getParameter("date02")));
		}
		catch(Exception e){
		map.put("FI", new java.util.Date());
		map.put("FF", new java.util.Date());
			
		}
		temp=request.getParameter("cmbSedes");
		map.put("sede", temp.equals("all")?"%":temp);
		temp=request.getSession().getAttribute("idSocio")==null?null:request.getSession().getAttribute("idSocio").toString();
		temp= temp==null?request.getParameter("idsocio"):temp;
		map.put("socio", temp==null?"%":temp);
		temp=request.getSession().getAttribute("idJuridica")==null?null:request.getSession().getAttribute("idJuridica").toString();
		temp= temp==null?request.getParameter("idJuridica"):temp;
		map.put("corporativo", temp==null?"%":temp);
		return map;
	}
	public void registrarEventoCorporativo(EventoBeanData eventoData,String invitados,String corporativo){
		l6.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.servicio.evento.getNextCodigoSjE");
			codigo=codigo==null?"ECP000000":codigo;
			codigo=Utils.generaSiguienteCodigo(codigo);
			eventoData.setCodigo(codigo);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("codigo", eventoData.getCodigo());
			map.put("nombre", eventoData.getNombre());
			map.put("corporativo", corporativo);
			map.put("monto", eventoData.getMonto());
			map.put("sede", eventoData.getIdSede());
			map.put("fecha", eventoData.getFecha());
			map.put("concesionario", eventoData.getIdConcesionario());
			sqlsesion.insert("Data.servicio.evento.insertEventoCorporativo",map);
			
			String lista[]=invitados.split("@");
			for(int i=0;i<lista.length;i++){
				String datos[]=lista[i].substring(0, lista[i].length()-1).split("_");
				map.put("dni", datos[0]);
				map.put("nombre", datos[1]);
				map.put("apepat", datos[2]);
				map.put("apemat", datos[3]);
				sqlsesion.insert("Data.servicio.evento.insertInvitado",map);
				sqlsesion.insert("Data.servicio.evento.insertInvitadoEvento",map);
			}
			sqlsesion.commit();
			
		}catch(Exception e){
			sqlsesion.rollback();
			
		}
		finally{
			sqlsesion.close();
			l6.unlock();
		}
		
	}
	

	public PersonaJuridicaBeanData consultarJuridica(String codigo){
		PersonaJuridicaBeanData JuridicaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			JuridicaData= sqlsesion.selectOne("Data.servicio.evento.getjuridica",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return JuridicaData;
	}
	
}
