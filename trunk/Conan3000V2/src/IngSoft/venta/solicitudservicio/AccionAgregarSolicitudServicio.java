package IngSoft.venta.solicitudservicio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.LineaServicioBeanData;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ServicioBeanData;
import IngSoft.venta.bean.ServicioBeanFuncion;

public class AccionAgregarSolicitudServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				String codServicio=(request.getParameter("idServicio"));
				
				//busco el servicio y saco su costo
				ServicioBeanFuncion servicioFuncion=ServicioBeanFuncion.getInstanceS();
				ServicioBeanData servicioData=servicioFuncion.consultarServicio(codServicio);
				
				//Busco maxima codigo de solicitud de servicio
				
				String codSolicitudS=servicioFuncion.consultarSolicitudServicio();
				
				//creo instancia de linea de servicio
				LineaServicioBeanData lineaData=new LineaServicioBeanData();
				lineaData.setCodServicioP(codServicio);
				lineaData.setCodSolicitudS(codSolicitudS);
				
				//inserto la linea, aca llamo funcion y dentro de ella busco la ultima linea de servicio, luego hago operacion con monto por mes
				//seteo el monto y inserto
				String codLineaS=servicioFuncion.consultarLineaServicio();
				
				if(codLineaS!=null){
					int codLinea= Integer.parseInt(codLineaS.substring(3))+1;
					String defecto= "000000";
					String temp= defecto.substring(0, defecto.length()-String.valueOf(codLinea).length()).concat(String.valueOf(codLinea));
				
				lineaData.setCodLineaServicio(codLineaS.substring(0,3).concat(temp));}
				else lineaData.setCodLineaServicio("LIS000001");
				
				Double precio=servicioData.getPrecio();//dice que saca null
				int periodo=Integer.parseInt(request.getParameter("txtperiodo"));
				
				Double monto=(double)precio*periodo;
				lineaData.setMonto(monto);
				
				boolean bool=servicioFuncion.agregarLinea(lineaData);
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudservicio.jsp");
	
	}
}
