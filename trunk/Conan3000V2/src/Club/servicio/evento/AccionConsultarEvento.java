package Club.servicio.evento;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.ConcesionarioMiniBeanData;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionConsultarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		int tipo=Integer.parseInt(request.getParameter("tipo"));		
		EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
		if(tipo==1){
			
			EventoBeanData eventoData=null;
			String codigo=request.getParameter("codigo");
			eventoData=eventoFuncion.consultarEventoSocio(codigo);			
			Vector<SedeMiniBeanData> sedeMiniData=eventoFuncion.getSedes();		
			Vector<ConcesionarioMiniBeanData> resultado=eventoFuncion.consultarConcesionariosxSede(eventoData.getIdSede(), eventoData.getFecha());
			for(int i=0;i<resultado.size();i++){
				if(resultado.get(i).getCodigo().equals(eventoData.getIdConcesionario())){
					request.setAttribute("concesionario", resultado.get(i));
					break;
				}
				
			}
			request.setAttribute("sedes",sedeMiniData );
			request.setAttribute("evento", eventoData);
			this.direccionar(sc, request, response, "/Club/servicio/evento/consultarevento.jsp");
			}
		if(tipo==3){
			String codigo=request.getParameter("codigo");
			if(codigo!=null && !codigo.isEmpty()){
				 eventoFuncion.anularEventoSocio(codigo);
				
			}
			 try {
					response.getWriter().write( "/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=1");
				} catch (IOException e) {				
					e.printStackTrace();
				}
			
		}
	}

}
