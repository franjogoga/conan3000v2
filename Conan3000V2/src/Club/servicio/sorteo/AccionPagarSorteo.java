package Club.servicio.sorteo;

import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.BungalowxSorteo;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.Utils;
import IngSoft.venta.bean.OrdenPagoBeanFunction;
@SessionScoped
public class AccionPagarSorteo extends CoAccion {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		BungalowxSorteo bungalowSorteo = new BungalowxSorteo();
		String idSocio = (String)request.getSession().getAttribute("idSocio");
		String codSorteo = request.getParameter("codSorteo");
		
		bungalowSorteo.setIdSocio(idSocio);
		bungalowSorteo.setIdSorteo(codSorteo);
		bungalowSorteo = sorteoFuncion.getBungalowSorteo(bungalowSorteo);
		if (bungalowSorteo.getIdBungalow().equals("NO")) {this.direccionar(sc, request, response, "/Club/servicio/sorteo/inscripcionFallida.jsp");}
		else if (bungalowSorteo.getIdBungalow().equals("SI")) {this.direccionar(sc, request, response, "/Club/servicio/sorteo/pagoRepetido.jsp");}
		OrdenPagoBeanFunction orden=new OrdenPagoBeanFunction();
		SorteoBeanData sorteoData= sorteoFuncion.getSorteo(codSorteo);  
		long diferencia = sorteoData.getFechaFin().getTime() - sorteoData.getFechaInicio().getTime();
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		dias++;
		java.util.Date valor = new java.util.Date();
		for (int i=0;i<(int)dias; i++ ){
			orden.agregarOrdenPago("BUNGALOWXSORTEO", bungalowSorteo.getIdBungalow(), bungalowSorteo.getIdSorteo(), idSocio, (double) bungalowSorteo.getMontoBungalow() , new Date(valor.getTime()), new Date(valor.getTime()));
			sorteoFuncion.agregaFechaReserva(bungalowSorteo.getIdBungalow(),idSocio,Utils.fechaMas(sorteoData.getFechaInicio(),i));
		}		
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/pagoRealizado.jsp");
		
	}

}
