package IngSoft.servicio.reporte;

import java.sql.Date;
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

public class AccionPagoOtrosServicios extends CoAccion {

	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();

			//File reportFile = new File(application.getRealPath("/reporte/ReservaBungalowFecha.jasper"));
			/*String reporte = FacesContext.getCurrentInstance()
			.getExternalContext()
			.getRealPath("/reporte/ReservaBungalowFecha.jasper"); */
			String reporte = sc.getRealPath("/reporte/PagosOtrosServicios.jasper");
			Map<String, Object> parameters = new HashMap<String, Object>();
			try {
				String nombSocio = request.getParameter("txtNombre");
				parameters.put("nombSocio", nombSocio);
				Date finicio = new Date(DF.parse(request.getParameter("fFecInicio")).getTime());
				Date ffin = new Date(DF.parse(request.getParameter("fFecFin")).getTime());
				parameters.put("FECHA_INICIO", finicio);
				parameters.put("FECHA_FIN", ffin);
				System.out.println("Parametro:" + finicio);
				System.out.println("Parametro:" + ffin);
				JasperPrint jPrint = JasperFillManager.fillReport(reporte, parameters, sqlsesion.getConnection());

//			JasperPrint jPrint = JasperFillManager.fillReport(reporte, parameters, sqlsesion.getConnection());
			/*response = (HttpServletResponse)FacesContext.getCurrentInstance()
			.getExternalContext().getResponse();*/
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
