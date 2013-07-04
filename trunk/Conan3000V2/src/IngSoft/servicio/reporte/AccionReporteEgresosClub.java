package IngSoft.servicio.reporte;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import net.sf.jasperreports.engine.*;
import IngSoft.general.CoAccion;
import IngSoft.general.MyBatisSesion;

public class AccionReporteEgresosClub extends CoAccion {

	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			String reporte = sc.getRealPath("/reporte/EgresosClub.jasper");
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
