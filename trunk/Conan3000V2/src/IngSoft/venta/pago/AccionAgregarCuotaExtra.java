package IngSoft.venta.pago;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.OrdenPagoBeanData;
import IngSoft.venta.bean.OrdenPagoBeanFunction;
@SessionScoped
public class AccionAgregarCuotaExtra extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				OrdenPagoBeanFunction OrdenPagoFunction= OrdenPagoBeanFunction.getInstance();
				if(tipo==2){
					
					OrdenPagoBeanData ordenPagoData=OrdenPagoFunction.crearCuotaExtra(request, response);
					System.out.println("valor de aplicar: "+ordenPagoData.getAplicar());
					if(ordenPagoData.getAplicar()==1){
						OrdenPagoFunction.agregarCuotaExtra(ordenPagoData);
					}else{
						OrdenPagoFunction.agregarCuotaExtra2(ordenPagoData);
					}	
					this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpagootros.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/pago/registrarcuotaextra.jsp");
					
				//EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
				//Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				//request.setAttribute("tiposEvento",tipoEventoMiniData);
				//this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarevento.jsp");			
	}

}

