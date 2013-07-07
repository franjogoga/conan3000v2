package IngSoft.servicio.sorteo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import IngSoft.servicio.bean.Utils;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.general.bean.Conan3000Constantes;
import IngSoft.servicio.bean.BungalowBeanData;
import IngSoft.servicio.bean.BungalowSorteoData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.venta.bean.OrdenPagoBeanFunction;

@SessionScoped
public class AccionBungalowSorteo extends CoAccion{
	private Lock l = new ReentrantLock();
	SimpleDateFormat DF= new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		String idSede = request.getParameter("idSede");
		String idSorteo = request.getParameter("idSorteo");
		String FI = request.getParameter("fInicio");
		String FF = request.getParameter("fFin");
		String FS = request.getParameter("fSorteo");
		Date fInicio=null;
		Date fFin=null;
		Date fSorteo=null;
		try {
			fInicio = DF.parse(request.getParameter("fInicio"));
			fFin = DF.parse(request.getParameter("fFin"));
			fSorteo = DF.parse(request.getParameter("fSorteo"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nombSorteo = request.getParameter("nombSorteo");
		SorteoBeanData sorteoData = new SorteoBeanData();
		sorteoData.setIdSede(idSede);
		sorteoData.setIdSorteo(idSorteo);
		sorteoData.setFechaInicio(fInicio);
		sorteoData.setFechaFin(fFin);
		sorteoData.setFechaSorteo(fSorteo);
		sorteoData.setDescripcion(nombSorteo);
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		long diferencia = fFin.getTime() - fInicio.getTime();
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		dias++;
		BungalowBeanData BS = new BungalowBeanData();
        String nextcodigo;
		l.lock();
		SqlSession sqlsesion = MyBatisSesion.metodo().openSession();
		try {
			String[] valores = request.getParameterValues("checkAcciones");
			if (valores==null) this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/errorAgregar.jsp");
			sorteoFuncion.agregarSorteo(sorteoData);
			String codigoCaso;
			Vector<String> idBungalows=new Vector<>();						
			for (int i=0; i<valores.length; i++) {
				codigoCaso = valores[i].substring(0, 9);											
				idBungalows.add(valores[i]);
			}
			BS.setIdSorteo(idSorteo);
			BS.setBungalows(idBungalows);
			for (int i=0; i<BS.getBungalows().size();i++){
				BungalowSorteoData data= new BungalowSorteoData();
				data.setIdBungalow(BS.getBungalows().get(i));
				data.setIdSorteo(idSorteo);
				sqlsesion.insert("Data.servicio.sorteo.agregarBungalowsSorteo", data);
				for(int j=0; j<(int)dias ; j++){					
					nextcodigo=sqlsesion.selectOne("Data.servicio.reserva.getNextCodigoB");
					nextcodigo=nextcodigo==null?"RSB000000":nextcodigo;
					nextcodigo=Utils.generaSiguienteCodigo(nextcodigo);
					SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
					   OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
					   HashMap<String, Object> map=new HashMap<String, Object>();
					   Conan3000Constantes constantes=Conan3000Constantes.getInstance();
					   map.put("idsocio",null);
					   IngSoft.administracion.bean.BungalowBeanData bung = new IngSoft.administracion.bean.BungalowBeanData();
					   BungalowBeanFunction BF = BungalowBeanFunction.getInstance();
					   bung = BF.consultarBungalow(BS.getBungalows().get(i));
					   double area=0;
						   map.put("idbungalow", BS.getBungalows().get(i)); 
						   map.put("idreservasbungalow", nextcodigo);
						   area=(bung.getAreaBungalow());
						   map.put("monto",constantes.getCostoXm2Bungalow()*area);
						   map.put("fecha",Utils.fechaMas(fInicio, j));
						   sqlsesion.insert("Data.servicio.reserva.insertBungalowReserva",map);
						   sqlsesion.insert("Data.servicio.reserva.insertBungalowReservaFecha",map);
					   sqlsesion.commit();
				}
			}
			   
		} catch (Exception e4){
			sqlsesion.rollback();
			e4.printStackTrace();						
			throw CoException.set("Error: Hubo un problema", "SMSSorteo?accion=Agregar&tipo=1");
		} finally {
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();
		}		
		
		SorteoBeanFuncion sorteoFunction= SorteoBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFunction.getSedes();
		request.setAttribute("sedes",sedeMiniData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/agregarsorteo.jsp");
	}

}
