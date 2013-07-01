package Club.servicio.evento;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.ConcesionarioMiniBeanData;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
@SessionScoped
public class AccionAgregarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
		if(tipo==2){
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			EventoBeanData eventoData=eventoFuncion.crearEvento(request, response);
			eventoFuncion.agregarEventoSocio(eventoData, request);
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write( "/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=1");
			} catch (IOException e) {				
				e.printStackTrace();
			}
			//this.direccionar(sc, request, response, "/Club/servicio/evento/SMSEvento?accion=Buscar&tipo=1");
		}
		if(tipo==1){		
		Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
		//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
		//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
		request.setAttribute("sedes",sedeMiniData );
		//request.setAttribute("ambientes",AmbienteMiniData );
		//request.setAttribute("tiposEvento",tipoEventoMiniData);
		this.direccionar(sc, request, response, "/Club/servicio/evento/agregarevento.jsp");
		}
		if(tipo==3){
			String codSede= request.getParameter("cmbSedes");
			codSede="0".equals(codSede)?"%":codSede;
			Date fecha= new Date();
			try {
				fecha= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fFecha"));
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			Vector<ConcesionarioMiniBeanData> resultado=eventoFunction.consultarConcesionariosxSede(codSede, fecha);
			request.setAttribute("resultados", resultado);
			this.direccionar(sc, request, response, "/Club/servicio/evento/concesionariosxsede.jsp");
			
		}
		if(tipo==4){
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			EventoBeanData eventoData=eventoFuncion.crearEvento(request, response);
			eventoFuncion.agregarEventoSocio(eventoData,request);
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write( "/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=1");
			} catch (IOException e) {				
				e.printStackTrace();
			}
			//this.direccionar(sc, request, response, "/Club/servicio/evento/SMSEvento?accion=Buscar&tipo=1");
		}
		if(tipo==5){
			HttpSession sesion= request.getSession();
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			int resultado=eventoFuncion.registarSocioEventoSede(request.getParameter("codigo"),  sesion.getAttribute("idSocio").toString(), Integer.parseInt(request.getParameter("cantidad")));
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write(resultado==0?"EXITO":String.valueOf(resultado));
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
	}

}
