package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
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
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	
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
				if(request.getParameter("chkAplicar")==null){
					ordenPagoData.setAplicar(0);
					System.out.println("valor de aplicar en crear cuota: "+ordenPagoData.getAplicar());
				}else{
					System.out.println("valor de aplicar en crear cuota: "+request.getParameter("chkAplicar"));
					ordenPagoData.setAplicar(Integer.parseInt(request.getParameter("chkAplicar")));
					
				}
				if(ordenPagoData.getAplicar()==1){
				ordenPagoData.setIdSocio(request.getParameter("idSocio"));
				ordenPagoData.setPeriodo(request.getParameter("cmbPeriodo"));
				}
				ordenPagoData.setDescripcionCuota(request.getParameter("txtDescripcion"));
				ordenPagoData.setFechaVencimiento(new Date(DF.parse(request.getParameter("fFechaVencimiento0")).getTime()));
				ordenPagoData.setDescripcion("CUOTAEXTRAORDINARIA");
				ordenPagoData.setMonto(Double.parseDouble(request.getParameter("txtTotalxCuota0")));
				
				
				//ordenPagoData.setFechaPago(new Date(DF.parse(request.getParameter("FechaEmision")).getTime()));
				ordenPagoData.setFechaEmision(new Date(DF.parse(request.getParameter("fFechaEmision0")).getTime()));
				
				ordenPagoData.setCuota(Integer.parseInt(request.getParameter("txtCuota")));
				
				
				
				
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
		
		case "MULTAXINFRACCION":
			ordenData.setIdServAdicional(id);
			sqlsesion.insert("insertOrdenPagoMultaxInfraccion",ordenData);
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
	l1.lock();
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
		l1.unlock();					
	}
	return resultado;
}

public boolean agregarCuotaExtra(OrdenPagoBeanData ordenPagoData) throws CoException {
	
	boolean resultado=false;		
	l2.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
		
		String codigoConcepto= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOrden");
		if(codigoConcepto!=null){
		int cod= Integer.parseInt(codigoConcepto.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenPagoData.setIdConcepto(codigoConcepto.substring(0,3).concat(temp));}
		else ordenPagoData.setIdConcepto("OPG000001");
		
		
	
		//insertPago esta en pago mapper
		Integer periodos;
		
		sqlsesion.insert("insertOrdenPagoCuotaExtra",ordenPagoData);
		Integer estadoPA=0;
		
		final Calendar c = Calendar.getInstance();
		System.out.println(ordenPagoData.getFechaVencimiento());
		c.setTime(ordenPagoData.getFechaVencimiento());
		Integer mes=0;
		if(ordenPagoData.getPeriodo().equals("Mensual")) mes=1;
		if(ordenPagoData.getPeriodo().equals("Bimestral")) mes=2;
		if(ordenPagoData.getPeriodo().equals("Trimestral")) mes=3;
		if(ordenPagoData.getPeriodo().equals("Semestral")) mes=6;
		if(ordenPagoData.getPeriodo().equals("Anual")) mes=12;
		String valorDes=ordenPagoData.getDescripcionCuota();
		
		for(int i=0;i<ordenPagoData.getCuota();i++){
			
			String codigoOtros= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOtroIngreso");
			if(codigoOtros!=null){
			int cod2= Integer.parseInt(codigoOtros.substring(3))+1;
			String defecto2= "000000";
			String temp2= defecto2.substring(0, defecto2.length()-String.valueOf(cod2).length()).concat(String.valueOf(cod2));
			
			ordenPagoData.setIdOtroIngreso(codigoOtros.substring(0,3).concat(temp2));}
			else ordenPagoData.setIdOtroIngreso("OIN000001");
			
			if(ordenPagoData.getCuota()>0 && estadoPA==0){
				//c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(2));
				estadoPA=1;
				}else{
					
						//c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+mes,c.get(2));
						c.add(Calendar.MONTH, mes);
				}
			
			ordenPagoData.setFechaVencimiento(c.getTime());
			ordenPagoData.setDescripcionCuota(valorDes+" ( Cuota "+(i+1)+" )");
		sqlsesion.insert("insertOrdenPagoOtrosIngresos",ordenPagoData);
		}
		
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
		l2.unlock();					
	}
	return resultado;
}


public boolean agregarCuotaExtra2(OrdenPagoBeanData ordenPagoData) throws CoException {
	
	boolean resultado=false;		
	l2.lock();
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	Vector<ResultadoPagoBeanData> resultadosV=null;
	try{
		
		String codigoConcepto= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOrden");
		if(codigoConcepto!=null){
		int cod= Integer.parseInt(codigoConcepto.substring(3))+1;
		String defecto= "000000";
		String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
		
		ordenPagoData.setIdConcepto(codigoConcepto.substring(0,3).concat(temp));}
		else ordenPagoData.setIdConcepto("OPG000001");
		
		//insertPago esta en pago mapper
		sqlsesion.insert("insertOrdenPagoCuotaExtra2",ordenPagoData);
		String valorDes=ordenPagoData.getDescripcionCuota();
		
		for(int i=0;i<ordenPagoData.getCuota();i++){
			
			String codigoOtros= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigoOtroIngreso");
			if(codigoOtros!=null){
			int cod2= Integer.parseInt(codigoOtros.substring(3))+1;
			String defecto2= "000000";
			String temp2= defecto2.substring(0, defecto2.length()-String.valueOf(cod2).length()).concat(String.valueOf(cod2));
			
			ordenPagoData.setIdOtroIngreso(codigoOtros.substring(0,3).concat(temp2));}
			else ordenPagoData.setIdOtroIngreso("OIN000001");
			
			ordenPagoData.setDescripcionCuota(valorDes+" ( Cuota "+(i+1)+" )");
			sqlsesion.insert("insertOrdenPagoOtrosIngresos2",ordenPagoData);
		}
		
		
		for(int j=0; j<ordenPagoData.getCuota();j++){
		List<ResultadoPagoBeanData> resultados=sqlsesion.selectList("Data.venta.pago.searchAddCuota",ordenPagoData);
		resultadosV= new Vector<>(resultados);
			for(int k=0;k<resultados.size();k++){
				ResultadoPagoBeanData res=((ResultadoPagoBeanData)resultados.get(k));
				res.setMonto(ordenPagoData.getMonto());
				sqlsesion.update("Data.venta.pago.addCuotaExtraACuota",res);
			}
		}
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
		l2.unlock();					
	}
	return resultado;
}



public OrdenPagoBeanData consultarOrdenPago(String codigo){
	l3.lock();
	OrdenPagoBeanData ordenPagoData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		ordenPagoData= sqlsesion.selectOne("Data.venta.pago.getOrdenPagoIngreso",codigo);
	}
	catch(Exception a)		
	{
	a.printStackTrace();
	}
	finally{
		sqlsesion.close();
		l3.unlock();
	}
	return ordenPagoData;
}








public boolean agregarOrdenPagoPrueba() throws CoException {
	
	boolean resultado=false;
	OrdenPagoBeanData ordenData= new OrdenPagoBeanData();
	
	l4.lock();
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
		l4.unlock();					
	}
	return resultado;
}
	
}


