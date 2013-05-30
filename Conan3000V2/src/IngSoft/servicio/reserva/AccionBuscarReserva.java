package IngSoft.servicio.reserva;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Util;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ReservaBeanFuncion;
import IngSoft.servicio.bean.ReservaBungalowMiniBeanData;
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
		HttpSession sesion= request.getSession(true);
		request.setAttribute("sedes",sedeMiniData );
		Vector<String> listareservas= new Vector<String>();
		Vector<String> pendientes=null;
		Vector<String> cancelados=null;
		if(tipo==1)	{
			this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/buscarreserva.jsp");
			sesion.removeAttribute("reservas");
		}
		if(tipo==2){
			request.setAttribute("fA", new java.util.Date());
			sesion.setAttribute("listareservas", listareservas);
			if("bungalow".equals(request.getParameter("cmbServicios"))){			
				Vector<ReservaBungalowMiniBeanData> reservas=reservaFuncion.buscarReservasBungalow(request.getParameter("cmbSedes").toString(), new java.util.Date());
				sesion.setAttribute("reservas",reservas);
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");}		
			else this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			
			
		}
		if(tipo==3){
			try{
			java.util.Date fecIniAnt= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecIni").toString());
			java.util.Date fecIniNue=Utils.fechaMas(fecIniAnt, 7);		
			java.util.Date fecFinNue=Utils.fechaMas(fecIniNue,6);
			request.setAttribute("fI", fecIniNue);
			if("bungalow".equals(request.getParameter("cmbServicios"))){
				String temp=request.getParameter("pendientes");
				if(temp.length()>0)pendientes=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				temp=request.getParameter("cancelados");
				if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				if(listareservas.size()==0) listareservas=pendientes;								
				else{
					if(cancelados!=null)listareservas.removeAll(cancelados);
					if(pendientes!=null)listareservas.addAll(pendientes);					
				}
				String res= Utils.unir(reservaFuncion.filtrarReservaXFechas(listareservas, fecIniNue, fecFinNue), ",","\"");				
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
				temp=request.getParameter("cancelados");
				if(temp.length()>0)cancelados=new Vector<String>(Arrays.asList(temp.substring(0, temp.length()-1).split("@")));
				if(listareservas.size()==0) listareservas=pendientes;								
				else{
					if(cancelados!=null)listareservas.removeAll(cancelados);
					if(pendientes!=null)listareservas.addAll(pendientes);					
				}
				String res= Utils.unir(reservaFuncion.filtrarReservaXFechas(listareservas, fecIniNue, fecFinNue), ",","\"");				
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
		else{	
		//request.setAttribute("resultados", resultados);
		
		}
	}

}
