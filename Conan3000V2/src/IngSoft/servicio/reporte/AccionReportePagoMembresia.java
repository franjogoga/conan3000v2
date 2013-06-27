package IngSoft.servicio.reporte;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import net.sf.jasperreports.engine.*;
import java.io.*;
import java.util.*;

import java.sql.Date;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.BungalowxSorteData;
import IngSoft.servicio.bean.SocioBeanData;
import IngSoft.servicio.bean.SocioInscritoBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionReportePagoMembresia extends CoAccion {

	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			String reporte = sc.getRealPath("/reporte/PagosMembresia.jasper");
			Map<String, Object> parameters = new HashMap<String, Object>();
			try {
				String nombSocio = request.getParameter("txtNombre");
				parameters.put("nombSocio", nombSocio);
				
				JasperPrint jPrint = JasperFillManager.fillReport(reporte, parameters, sqlsesion.getConnection());
			response.addHeader("Content-disposition", 
			            "attachment; filename=report.pdf");
			ServletOutputStream servletOutputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jPrint, servletOutputStream);
			this.direccionar(sc, request, response, "/IngSoft/servicio/reporte/generarreportes.jsp");

			} catch (Exception ex) {
				this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/generarreportes.jsp");
			}
	}

}
