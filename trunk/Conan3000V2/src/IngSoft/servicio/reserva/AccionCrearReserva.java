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

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ReservaBeanFuncion;
import IngSoft.servicio.bean.ReservaBungalowMiniBeanData;
import IngSoft.servicio.bean.ResultadoEventoBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.Utils;

public class AccionCrearReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			HttpSession sesion= request.getSession(true);
			Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
			listareservas=listareservas==null?new Vector<String>():listareservas;
			String codSocio=request.getParameter("txtIdSocio");
			if(listareservas.size()>0){
				ReservaBeanFuncion reservaFuncion=ReservaBeanFuncion.getInstance();
				reservaFuncion.agregarReservaBungalow(listareservas,codSocio);
				
				
			}
		}
	}

}
