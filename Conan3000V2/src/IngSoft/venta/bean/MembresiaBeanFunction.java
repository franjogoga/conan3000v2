package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class MembresiaBeanFunction {
	static private MembresiaBeanFunction MembresiaFuncion=null;
	private Lock l= new ReentrantLock();     
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	private Lock l5= new ReentrantLock();
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static MembresiaBeanFunction getInstance(){
	       if(MembresiaFuncion==null) MembresiaFuncion= new MembresiaBeanFunction();
	       
	       return MembresiaFuncion;
	   }
	   
	   private MembresiaBeanFunction() {}
	   
	   public MembresiaBeanData obtenerPrecio() throws CoException{
		   MembresiaBeanData membresiaData= new MembresiaBeanData();
		   l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			
			try{
				membresiaData= sqlsesion.selectOne("Data.venta.membresia.getPrecio");
			
			}
			
			finally{
				sqlsesion.close();
				l.unlock();
			}
			
		 
		   return membresiaData;
		   
	   }
	
	   
	   public MembresiaBeanData crearMembresiaRenovar(HttpServletRequest request, HttpServletResponse response){
			MembresiaBeanData membresiaData= new MembresiaBeanData();
			try{		
		
			membresiaData.setCodigoSocio(request.getParameter("idSocio"));
			membresiaData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechaInicio2")).getTime()));
			membresiaData.setFechaFin(new Date(DF.parse(request.getParameter("fFechaFin2")).getTime()));
			membresiaData.setCosto(Double.parseDouble(request.getParameter("total")));
			membresiaData.setPeriodo(request.getParameter("cmbPeriodo"));
			membresiaData.setEstado("Activo");
			//Double descuento=Double.parseDouble(request.getParameter("txtDescuento"))/100;
			
			if(membresiaData.getPeriodo().equals("Mensual")){
			membresiaData.setCantCuota(12);
			}else{
				if(membresiaData.getPeriodo().equals("Semestral")){
					membresiaData.setCantCuota(2);
					//membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto"))*6*(1-descuento));
					}else{
						if(membresiaData.getPeriodo().equals("Anual")){
							membresiaData.setCantCuota(1);
							//membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto"))*12*(1-descuento));
							}
						
						
					}
				
			}
			
			
			if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			membresiaData.setEstado(est);}
			
			//if(request.getParameter("rButton").equals("option1")) {
			//membresiaData.setEstado(request.getParameter("option1"));}
	          // else if (request.getParameter("rButton").equals("option2"))
	            //	membresiaData.setEstado(request.getParameter("option2"));
	         	
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			return membresiaData;		
		} 
		
	   
	   
	   
	public MembresiaBeanData crearMembresia(HttpServletRequest request, HttpServletResponse response){
		MembresiaBeanData membresiaData= new MembresiaBeanData();
		try{		
	
		membresiaData.setCodigoSocio(request.getParameter("idSocio"));
		membresiaData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechaInicio")).getTime()));
		membresiaData.setFechaFin(new Date(DF.parse(request.getParameter("fFechaFin")).getTime()));
		membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
		membresiaData.setPeriodo(request.getParameter("cmbPeriodo"));
		membresiaData.setEstado("Activo");
		Double descuento=Double.parseDouble(request.getParameter("txtDescuento"))/100;
		
		if(membresiaData.getPeriodo().equals("Mensual")){
		membresiaData.setCantCuota(12);
		}else{
			if(membresiaData.getPeriodo().equals("Semestral")){
				membresiaData.setCantCuota(2);
				membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto"))*6*(1-descuento));
				}else{
					if(membresiaData.getPeriodo().equals("Anual")){
						membresiaData.setCantCuota(1);
						membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto"))*12*(1-descuento));
						}
					
					
				}
			
		}
		
		
		if (request.getParameter("rButton")!=null){
		String est;
		est=request.getParameter("rButton");
		membresiaData.setEstado(est);}
		
		//if(request.getParameter("rButton").equals("option1")) {
		//membresiaData.setEstado(request.getParameter("option1"));}
          // else if (request.getParameter("rButton").equals("option2"))
            //	membresiaData.setEstado(request.getParameter("option2"));
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return membresiaData;		
	} 
	
	public synchronized  boolean agregarMembresia(MembresiaBeanData membresiaData) throws CoException {
		
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			membresiaData.setCodigo(codigo.substring(0,3).concat(temp));}
			else membresiaData.setCodigo("MEM000001");
			
			
			
			System.out.println("Fecha inicio: "+membresiaData.getFechaInicio());
			
			//insertMembresia esta en membresia mapper
			sqlsesion.insert("insertMembresia",membresiaData);
			
			//Ingreso para detalle de cuota
			String codigoDetalle= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigoDetalle");
			if(codigoDetalle!=null){
			int codDet= Integer.parseInt(codigoDetalle.substring(3))+1;
			String defectoDetalle= "000000";
			String tempDetalle= defectoDetalle.substring(0, defectoDetalle.length()-String.valueOf(codDet).length()).concat(String.valueOf(codDet));
			
			membresiaData.setIdDetalleCuota(codigoDetalle.substring(0,3).concat(tempDetalle));}
			else membresiaData.setIdDetalleCuota("DTC000001");
			
			java.util.Date fechaActual = new java.util.Date();
			membresiaData.setFechaCreacion(fechaActual);
			membresiaData.setEstadoDetalle("Activo");
			membresiaData.setIdMembresia(membresiaData.getCodigo());
			
			
			
			
			
			
			sqlsesion.insert("insertDetalleCuota",membresiaData);
			
			
			//Ingreso por cuota
			//calculo de cuota hasta fin de anho
			//monto igual a costo
			
			
			
			
			final Calendar c = Calendar.getInstance();
			final Calendar c2 = Calendar.getInstance();
			
			String fechaEmision=DF.format(fechaActual);
			
			
			
			int codCuota=0;
			int estadoPA=0;
			for(int i=0;i<membresiaData.getCantCuota();i++){
				String codigoCuota= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigoCuota");
				if(codigoCuota!=null){
				if(codCuota==0)	
				codCuota= Integer.parseInt(codigoCuota.substring(3))+1;
				else
					codCuota++;
				String defectoCuota= "000000";
				String tempCuota= defectoCuota.substring(0, defectoCuota.length()-String.valueOf(codCuota).length()).concat(String.valueOf(codCuota));
				
				membresiaData.setIdCuota(codigoCuota.substring(0,3).concat(tempCuota));}
				else membresiaData.setIdCuota("CUO000001");
				
				Integer mes=c.get(Calendar.MONTH);
				if(mes.equals(12)) membresiaData.setEstadoCuota("No Facturado"); 
				else
				membresiaData.setEstadoCuota("No Cancelado");
				
				
					if(membresiaData.getCantCuota()>0 && estadoPA==0){
					c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,7);
					estadoPA=1;
					}else{
						if(membresiaData.getCantCuota()==12)
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,7);
						if(membresiaData.getCantCuota()==2)
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+6,7);
						
					}
					
					
					
				
			membresiaData.setNumCuota(i+1);
			membresiaData.setFechaEmision(new Date(DF.parse(fechaEmision).getTime()));
			String fechaVencimiento=DF.format(c.getTime());
			membresiaData.setCantidad(1);
			membresiaData.setMonto(membresiaData.getCosto());
			
			membresiaData.setFechaVencimiento(new Date(DF.parse(fechaVencimiento).getTime()));
			sqlsesion.insert("insertCuota",membresiaData);
			}
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Ha ocurrido un error al guardar los datos", "SMVMembresia?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
								
		}
		return resultado;
	}
	
	public boolean eliminarMembresia(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			MembresiaBeanData membresia= new MembresiaBeanData();
			java.util.Date fechaActual = new java.util.Date();
			membresia.setFechaActual(fechaActual);
			sqlsesion.update("Data.venta.membresia.darBajaCuota",membresia);
			
			sqlsesion.update("Data.venta.membresia.deleteMembresia",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la membresia, intente de nuevo", "SMVMembresia?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public synchronized  MembresiaBeanData consultarMembresia(String codigo){
		
		MembresiaBeanData membresiaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			membresiaData= sqlsesion.selectOne("Data.venta.membresia.getPlantillaMembresia",codigo);
			
			final Calendar c = Calendar.getInstance();
			c.setTime(membresiaData.getFechaInicio());
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,1);
		
			final Calendar c2 = Calendar.getInstance();
			c2.setTime(membresiaData.getFechaInicio());
			c2.set(c.get(Calendar.YEAR)+1, c.get(Calendar.MONTH)+1,1);
			
			
			membresiaData.setFechaInicio(c.getTime());
			membresiaData.setFechaFin(c2.getTime());
			
			
			
			
		}
		finally{
			sqlsesion.close();
			
		}
		return membresiaData;
	}
	
	
	public MembresiaBeanData consultarMembresiaRenovar(String codigo){
		l2.lock();
		MembresiaBeanData membresiaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			membresiaData= sqlsesion.selectOne("Data.venta.membresia.getPlantillaMembresia",codigo);
			
			final Calendar c = Calendar.getInstance();
			c.setTime(membresiaData.getFechaFin());
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),1);
			
			final Calendar c2 = Calendar.getInstance();
			c2.setTime(membresiaData.getFechaFin());
			c2.set(c.get(Calendar.YEAR)+1, c.get(Calendar.MONTH),1);
			
			membresiaData.setFechaInicio(c.getTime());
			membresiaData.setFechaFin(c2.getTime());
			
		}
		finally{
			sqlsesion.close();
			l2.unlock();
		}
		return membresiaData;
	}
	
public String consultarMembresiaMax() throws CoException {
		
		//boolean resultado=false;		
		//l.lock();
	l3.lock();
	String codigo=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			codigo= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			
			codigo=(codigo.substring(0,3).concat(temp));}
			//else membresiaData.setCodigo("MEM000001");
			//insertMembresia esta en membresia mapper
			//sqlsesion.insert("insertMembresia",membresiaData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			//resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de membresia repetido", "SMVMembresia?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l3.unlock();					
		}
		return codigo;
	}


	public void modificarMembresia(MembresiaBeanData membresia) throws CoException {
		l4.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			
					

			final Calendar c = Calendar.getInstance();
			final Calendar c2 = Calendar.getInstance();
			
			
			System.out.println("Fecha Inicio: "+membresia.getFechaInicio());
			
			c.setTime(membresia.getFechaInicio());
			String fechaEmision=DF.format(membresia.getFechaInicio());
			
			String codigoCuota= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigoCuota");
			String cantCuota= (String)sqlsesion.selectOne("Data.venta.membresia.getCantidadCuota",membresia.getIdMembresia());
			System.out.println("Cantidad Cuotas: "+cantCuota);
			Integer cuotas=Integer.parseInt(cantCuota);
			cuotas+=membresia.getCantCuota();
			
			Integer cuotasCant=membresia.getCantCuota();
			membresia.setCantCuota(cuotas);
			membresia.setNumCuota(cuotas);
			
			sqlsesion.update("Data.venta.membresia.renovarMembresia",membresia);
			sqlsesion.update("Data.venta.membresia.renuevaFechaFinMembresia",membresia);
			String idDetalle= (String)sqlsesion.selectOne("Data.venta.membresia.getCodigoDetalle",membresia);
			membresia.setIdDetalleCuota(idDetalle);
			System.out.println("Detalle cuota: "+membresia.getIdDetalleCuota());
			System.out.println("Idmembresia: "+membresia.getIdMembresia());
			int codCuota=0;
			int estadoPA=0;
			for(int i=Integer.parseInt(cantCuota);i<membresia.getCantCuota();i++){
				
				if(codigoCuota!=null){
				if(codCuota==0)	
				codCuota= Integer.parseInt(codigoCuota.substring(3))+1;
				else
					codCuota++;
				String defectoCuota= "000000";
				String tempCuota= defectoCuota.substring(0, defectoCuota.length()-String.valueOf(codCuota).length()).concat(String.valueOf(codCuota));
				
				membresia.setIdCuota(codigoCuota.substring(0,3).concat(tempCuota));}
				else membresia.setIdCuota("CUO000001");
				
				Integer mes=c.get(Calendar.MONTH);
				if(mes.equals(12)) membresia.setEstadoCuota("No Facturado"); 
				else
				membresia.setEstadoCuota("No Cancelado");
				
				
					if(cuotasCant>0 && estadoPA==0){
					c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),7);
					estadoPA=1;
					}else{
						if(cuotasCant==12)
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,7);
						if(cuotasCant==2)
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+6,7);
						
					}
					
					
					
				
			membresia.setNumCuota(i+1);
			membresia.setFechaEmision(new Date(DF.parse(fechaEmision).getTime()));
			String fechaVencimiento=DF.format(c.getTime());
			membresia.setCantidad(1);
			membresia.setMonto(membresia.getCosto());
			
			membresia.setFechaVencimiento(new Date(DF.parse(fechaVencimiento).getTime()));
			sqlsesion.insert("insertCuota",membresia);
			}
			
			
			
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la membresia, intente de nuevo", "SMVMembresia?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();	
			l4.unlock();
		}			
		return ;
	}
	
	public void modificarSocio(String codigo) throws CoException {
		l5.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.membresia.updateSocio",codigo);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar la membresia, intente de nuevo", "SMVMembresia?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l5.unlock();
		}			
		return ;
	}

}
