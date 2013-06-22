package Club.servicio.sorteo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.BungalowxSorteData;
import IngSoft.servicio.bean.BungalowxSorteo;
import IngSoft.servicio.bean.SocioBeanData;
import IngSoft.servicio.bean.SocioInscritoBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;
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
		OrdenPagoBeanFunction orden=new OrdenPagoBeanFunction();
		
		java.util.Date valor = new java.util.Date();
		orden.agregarOrdenPago("BUNGALOWXSORTEO", bungalowSorteo.getIdBungalow(), bungalowSorteo.getIdSorteo(), idSocio, bungalowSorteo.getMontoBungalow() , new Date(valor.getTime()), new Date(valor.getTime()));		
		
		
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/pagoRealizado.jsp");
		
	}

}
