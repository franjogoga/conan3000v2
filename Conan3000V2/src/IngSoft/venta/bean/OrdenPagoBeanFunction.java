package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class OrdenPagoBeanFunction {
	
	static private OrdenPagoBeanFunction ordenPagoFunction=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static OrdenPagoBeanFunction getInstance(){
	       if(ordenPagoFunction==null) ordenPagoFunction= new OrdenPagoBeanFunction();
	       
	       return ordenPagoFunction;
	   }
	   
	   public OrdenPagoBeanFunction() {}
	   
	   
	   public OrdenPagoBeanData crearOrdenPago(HttpServletRequest request, HttpServletResponse response){
		   OrdenPagoBeanData ordenPagoData= new OrdenPagoBeanData();
			try{		
		
				ordenPagoData.setIdSocio(request.getParameter("idSocio"));
				ordenPagoData.setIdOtroIngreso(request.getParameter("idOtroIngreso"));
				//ordenPagoData.setSocio(request.getParameter("txtSocio"));
			//ordenPagoData.setConcepto(request.getParameter("cmbConcepto"));
			ordenPagoData.setFechaPago(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
			
					
			
	         	
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			return ordenPagoData;		
		}
	   
	   
	   
	   public OrdenPagoBeanData crearCuotaExtra(HttpServletRequest request, HttpServletResponse response){
		   OrdenPagoBeanData ordenPagoData= new OrdenPagoBeanData();
			try{		
		
				ordenPagoData.setIdSocio(request.getParameter("idSocio"));
				//ordenPagoData.setDescripcionCuota(request.getParameter("txtDescripcion"));
				ordenPagoData.setDescripcion("CUOTAEXTRAORDINARIA");
				ordenPagoData.setMonto(Double.parseDouble(request.getParameter("txtMonto")));
				ordenPagoData.setFechaPago(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
				ordenPagoData.setFechaEmision(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
				ordenPagoData.setFechaVencimiento(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
				
	         	
				
				
				
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			return ordenPagoData;		
		}

public boolean agregarOrdenPago(String concepto, String id, String id2, String idSocio, Double monto, Date fechaEmision, Date fechaVencimiento) throws CoException {
	
	boolean resultado=false;
	OrdenPagoBeanData ordenData= new OrdenPagoBeanData();
	
	l.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
		String codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOrden");
		if(codigo!=null){
		int cod= Integer.parseInt(codigo.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenData.setIdConcepto(codigo.substring(0,3).concat(temp));}
		else ordenData.setIdConcepto("OPG000001");
		
		
		String codigoOtros= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOtroIngreso");
		if(codigoOtros!=null){
		int cod2= Integer.parseInt(codigoOtros.substring(3))+1;
		String defecto2= "000000";
		String temp2= defecto2.substring(0, defecto2.length()-String.valueOf(cod2).length()).concat(String.valueOf(cod2));
		
		ordenData.setIdOtroIngreso(codigoOtros.substring(0,3).concat(temp2));}
		else ordenData.setIdOtroIngreso("OIN000001");
		
		ordenData.setIdSocio(idSocio);
		ordenData.setFechaEmision(fechaEmision);
		ordenData.setFechaVencimiento(fechaVencimiento);
		ordenData.setMonto(monto);
		ordenData.setDescripcion(concepto);
		
		switch(concepto){
		
		case "SOLICITUDPRODUCTO": 
			ordenData.setIdSolicitudProducto(id);
			sqlsesion.insert("insertOrdenPagoSolicitudProducto",ordenData);
			break;
			
		case "SOLICITUDSERVICIO": 
			ordenData.setIdSolicitudServicio(id);
			sqlsesion.insert("insertOrdenPagoSolicitudServicio",ordenData);
			break;
			
		case "EVENTOCORPORATIVO": 
			ordenData.setIdEventoCorp(id);
			sqlsesion.insert("insertOrdenPagoEventoCorp",ordenData);
			break;
			
		case "EVENTOCORPORATIVOXSERVICIOADICIONAL":
			ordenData.setIdEventoCorp(id);
			ordenData.setIdServAdicional(id2);
			sqlsesion.insert("insertOrdenPagoEventoCorporativoxServicioAdicional",ordenData);
			break;
		
		case "RESERVABUNGALOWXSERVICIOADICIONAL": 
			ordenData.setIdReservaBungalow(id);
			ordenData.setIdServAdicional(id2);
			sqlsesion.insert("insertOrdenPagoReservaBungalowxServicioAdicional",ordenData);
			break;
			
		case "BUNGALOWXSORTEO": 
			ordenData.setIdBungalow(id);
			ordenData.setIdSorteo(id2);
			sqlsesion.insert("insertOrdenPagoBungalowxSorteo",ordenData);
			break;
			
		case "EVENTOSOCIO": 
			ordenData.setIdEventoSocio(id);
			sqlsesion.insert("insertOrdenPagoEventoSocio",ordenData);
			break;
			
		case "RESERVACANCHA": 
			ordenData.setIdReservaCancha(id);
			sqlsesion.insert("insertOrdenPagoReservaCancha",ordenData);
			break;
		
		case "RESERVABUNGALOW": 
			ordenData.setIdReservaBungalow(id);
			sqlsesion.insert("insertOrdenPagoReservaBungalow",ordenData);
			break;
			
		case "ACTIVIDADSOCIO": 
			ordenData.setIdActividad(id);
			sqlsesion.insert("insertOrdenPagoActividadSocio",ordenData);
			break;
		
		case "ACTIVIDADFAMILIAR": 
			ordenData.setIdActividad(id);
			ordenData.setIdFamiliar(id2);
			sqlsesion.insert("insertOrdenPagoActividadFamiliar",ordenData);
			break;
		
		case "SUSPENSIONFALTA": 
			ordenData.setIdSuspensionFalta(id);
			sqlsesion.insert("insertOrdenPagoSuspensionFalta",ordenData);
			break;
		
		case "SOCIOXEVENTOSEDE": 
			ordenData.setIdEventoSede(id);
			sqlsesion.insert("insertOrdenPagoSocioxEventoSede",ordenData);
			break;
			
		case "INVITADOXSOCIO": 
			ordenData.setIdInvitado(id);
			sqlsesion.insert("insertOrdenPagoInvitadoxSocio",ordenData);
			break;
		
		case "TRASLADOMEMBRESIA":
			ordenData.setIdMembresiaAnt(id);
			ordenData.setIdMembresiaNue(id2);
			sqlsesion.insert("insertOrdenPagoTrasladoMembresia",ordenData);
			break;
		
		
		
		}
		
		
		sqlsesion.insert("insertOrdenPagoOtrosIngresos",ordenData);
		
		//insertPago esta en pago mapper
		//sqlsesion.insert("insertOrdenPago",ordenData);
		//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
		l.unlock();					
	}
	return resultado;
}
	

public boolean pagarOrdenPago(OrdenPagoBeanData ordenPagoData) throws CoException {
	
	boolean resultado=false;		
	l.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
			
		
		String codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigo2");
		if(codigo!=null){
		int cod= Integer.parseInt(codigo.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenPagoData.setIdIngreso(codigo.substring(0,3).concat(temp));}
		else ordenPagoData.setIdIngreso("ING000001");
		//insertPago esta en pago mapper
		
		sqlsesion.update("Data.venta.pago.pagarOrdenPago",ordenPagoData);
		sqlsesion.insert("insertOtroIngreso",ordenPagoData);
		//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
		l.unlock();					
	}
	return resultado;
}

public boolean agregarCuotaExtra(OrdenPagoBeanData ordenPagoData) throws CoException {
	
	boolean resultado=false;		
	l.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
		
		String codigoConcepto= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOrden");
		if(codigoConcepto!=null){
		int cod= Integer.parseInt(codigoConcepto.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenPagoData.setIdConcepto(codigoConcepto.substring(0,3).concat(temp));}
		else ordenPagoData.setIdConcepto("OPG000001");
		
		
		String codigoOtros= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOtroIngreso");
		if(codigoOtros!=null){
		int cod2= Integer.parseInt(codigoOtros.substring(3))+1;
		String defecto2= "000000";
		String temp2= defecto2.substring(0, defecto2.length()-String.valueOf(cod2).length()).concat(String.valueOf(cod2));
		
		ordenPagoData.setIdOtroIngreso(codigoOtros.substring(0,3).concat(temp2));}
		else ordenPagoData.setIdOtroIngreso("OIN000001");
		
		String codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigo2");
		if(codigo!=null){
		int cod= Integer.parseInt(codigo.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenPagoData.setIdIngreso(codigo.substring(0,3).concat(temp));}
		else ordenPagoData.setIdIngreso("ING000001");
		//insertPago esta en pago mapper
		
		
		sqlsesion.insert("insertOrdenPagoCuotaExtra",ordenPagoData);
		sqlsesion.insert("insertOrdenPagoOtrosIngresos",ordenPagoData);
		sqlsesion.update("Data.venta.pago.pagarOrdenPago",ordenPagoData);
		sqlsesion.insert("insertOtroIngreso",ordenPagoData);
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
		l.unlock();					
	}
	return resultado;
}





public OrdenPagoBeanData consultarOrdenPago(String codigo){
	OrdenPagoBeanData ordenPagoData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		ordenPagoData= sqlsesion.selectOne("Data.venta.pago.getOrdenPagoIngreso",codigo);
	}
	finally{
		sqlsesion.close();
	}
	return ordenPagoData;
}








public boolean agregarOrdenPagoPrueba() throws CoException {
	
	boolean resultado=false;
	OrdenPagoBeanData ordenData= new OrdenPagoBeanData();
	
	l.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
		
		OrdenPagoBeanFunction orden=new OrdenPagoBeanFunction();
		
		orden.agregarOrdenPago("SOLICITUDPRODUCTO", "SOL000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("SOLICITUDSERVICIO", "SSE000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("EVENTOCORPORATIVO", "EVC000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("EVENTOCORPORATIVOXSERVICIOADICIONAL", "EVS000001", "SEV000001", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("RESERVABUNGALOWXSERVICIOADICIONAL", "RBS000001", "SVA000001", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("BUNGALOWXSORTEO", "BXS000001", "SOR000001", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("EVENTOSOCIO", "EVS000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("RESERVACANCHA", "RSC000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("RESERVABUNGALOW", "RSB000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("ACTIVIDADSOCIO", "ACS000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("ACTIVIDADFAMILIAR", "ACF000001", "FAM000001", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("SUSPENSIONFALTA", "SSF000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("SOCIOXEVENTOSEDE", "SES000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("INVITADOXSOCIO", "IXS000001", "", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		orden.agregarOrdenPago("TRASLADOMEMBRESIA", "TRS000001", "MEM000001", "SOC000001", 500.00, new Date(DF.parse("13/06/2013").getTime()), new Date(DF.parse("13/06/2013").getTime()));
		
		
		
	
		
		
		
		//insertPago esta en pago mapper
		//sqlsesion.insert("insertOrdenPago",ordenData);
		//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
		l.unlock();					
	}
	return resultado;
}
	
}


