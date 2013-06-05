package IngSoft.servicio.reserva;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Util;

import IngSoft.administracion.bean.CanchaBeanFunction;
import IngSoft.administracion.bean.TipoCanchaMiniBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ReservaBeanFuncion;
import IngSoft.servicio.bean.ReservaBungalowMiniBeanData;
import IngSoft.servicio.bean.ReservaCanchaMiniBeanData;
import IngSoft.servicio.bean.ResultadoEventoBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.Utils;

public class AccionBuscarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		ReservaBeanFuncion reservaFuncion= ReservaBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=reservaFuncion.getSedes();
		Vector<TipoCanchaMiniBeanData> tipoCanchaMiniData= CanchaBeanFunction.getInstance().getTipoCancha();
		HttpSession sesion= request.getSession(true);
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("tiposCancha",tipoCanchaMiniData);
		Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
		listareservas=listareservas==null?new Vector<String>():listareservas;
		Vector<String> pendientes=new Vector<String>();
		Vector<String> cancelados=new Vector<String>();
		if(tipo==1)	{
			this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/buscarreserva.jsp");
			sesion.removeAttribute("reservas");
			sesion.removeAttribute("listareservas");
		}
		if(tipo==2){
			java.util.Date temp= new Date();
			temp=Utils.fechaMenos(temp,Integer.valueOf( Integer.valueOf( new SimpleDateFormat("uu").format(temp)).intValue()-1));
			request.setAttribute("fI", temp);
			sesion.setAttribute("listareservas", null);
			if("bungalow".equals(request.getParameter("cmbServicios"))){			
				Vector<ReservaBungalowMiniBeanData> reservas=reservaFuncion.buscarReservasBungalow(request.getParameter("cmbSedes").toString(),temp);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("listareservas",null);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");}		
			else {
				Vector<ReservaCanchaMiniBeanData> reservas=
						reservaFuncion.buscarReservasCanchas(request.getParameter("cmbSedes").toString(),request.getParameter("cmbTipoCancha").toString(),temp);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("listareservas",null);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			}
			
			
		}
		if(tipo==3){
			try{
			java.util.Date fecIniAnt= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecIni").toString());
			java.util.Date fecIniNue=Utils.fechaMas(fecIniAnt, 7);		
			java.util.Date fecFinNue=Utils.fechaMas(fecIniNue,6);
			request.setAttribute("fI", fecIniNue);
			String temp=request.getParameter("pendientes");
			if(temp.length()>0)pendientes=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
			pendientes.remove("");
			temp=request.getParameter("cancelados");
			if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
			cancelados.remove("");
			if(listareservas.size()==0) listareservas=pendientes;								
			else{
				if(cancelados!=null)listareservas.removeAll(cancelados);
				if(pendientes!=null)listareservas.addAll(pendientes);					
			}
			sesion.setAttribute("listareservas",listareservas);
			String res= Utils.unir(reservaFuncion.filtrarReservaXFechas(listareservas, fecIniNue, fecFinNue), ",","");
			if("bungalow".equals(request.getParameter("cmbServicios"))){				
								
				Vector<ReservaBungalowMiniBeanData> reservas=reservaFuncion.buscarReservasBungalow(request.getParameter("cmbSedes").toString(), fecIniNue);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("pendientes",res);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");}	
			else {
				Vector<ReservaCanchaMiniBeanData> reservas=
						reservaFuncion.buscarReservasCanchas(request.getParameter("cmbSedes").toString(),request.getParameter("cmbTipoCancha").toString(),fecIniNue);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("pendientes",res);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
		if(tipo==4){
			try{
			java.util.Date fecIniAnt= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecIni").toString());
			java.util.Date fecIniNue=Utils.fechaMenos(fecIniAnt, 7);
			request.setAttribute("fI", fecIniNue);
			java.util.Date fecFinNue=Utils.fechaMas(fecIniNue,6);
			request.setAttribute("fI", fecIniNue);
			if("bungalow".equals(request.getParameter("cmbServicios"))){
				String temp=request.getParameter("pendientes");
				if(temp.length()>0)pendientes=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				pendientes.remove("");
				temp=request.getParameter("cancelados");
				if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				cancelados.remove("");
				if(listareservas.size()==0) listareservas=pendientes;								
				else{
					if(cancelados!=null)listareservas.removeAll(cancelados);
					if(pendientes!=null)listareservas.addAll(pendientes);					
				}
				sesion.setAttribute("listareservas",listareservas);
				String res= Utils.unir(reservaFuncion.filtrarReservaXFechas(listareservas, fecIniNue, fecFinNue), ",","");				
				Vector<ReservaBungalowMiniBeanData> reservas=reservaFuncion.buscarReservasBungalow(request.getParameter("cmbSedes").toString(), fecIniNue);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("pendientes",res);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");}	
			else this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
		if(tipo==5){
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8");
		    String temp=reservaFuncion.confirmarSocio(request.getParameter("txtDNISocio")==null?"":request.getParameter("txtDNISocio").toString());
		    try {
				response.getWriter().write(temp);
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			
		}
		if(tipo==6){
			if("bungalow".equals(request.getParameter("cmbServicios"))){
				String temp=request.getParameter("pendientes");
				if(temp.length()>0)pendientes=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				pendientes.remove("");
				temp=request.getParameter("cancelados");
				if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				cancelados.remove("");
				if(listareservas.size()==0) listareservas=pendientes;								
				else{
					if(cancelados!=null)listareservas.removeAll(cancelados);
					if(pendientes!=null)listareservas.addAll(pendientes);					
				}
				sesion.setAttribute("listareservas",listareservas);
				response.setContentType("text/plain");  
			    response.setCharacterEncoding("UTF-8");			    
			    try {
					response.getWriter().write("exito");
				} catch (IOException e) {				
					e.printStackTrace();
				}
			}
			
		}
		if(tipo==7){						
			java.util.Date fecIniNue= new Date();
			fecIniNue=Utils.fechaMenos(fecIniNue,Integer.valueOf( Integer.valueOf( new SimpleDateFormat("uu").format(fecIniNue)).intValue()-1));		
			java.util.Date fecFinNue=Utils.fechaMas(fecIniNue,6);
			request.setAttribute("fI", fecIniNue);
			try{
			if("bungalow".equals(request.getParameter("cmbServicios"))){
				String temp=request.getParameter("pendientes");
				if(temp.length()>0)pendientes=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				pendientes.remove("");
				temp=request.getParameter("cancelados");
				if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				cancelados.remove("");
				if(listareservas.size()==0) listareservas=pendientes;								
				else{
					if(cancelados!=null)listareservas.removeAll(cancelados);
					if(pendientes!=null)listareservas.addAll(pendientes);					
				}
				sesion.setAttribute("listareservas",listareservas);
				String res= Utils.unir(reservaFuncion.filtrarReservaXFechas(listareservas, fecIniNue, fecFinNue), ",","");				
				Vector<ReservaBungalowMiniBeanData> reservas=reservaFuncion.buscarReservasBungalow(request.getParameter("cmbSedes").toString(), fecIniNue);
				sesion.setAttribute("reservas",reservas);
				sesion.setAttribute("pendientes",res);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");}	
			else this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
