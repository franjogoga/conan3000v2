package IngSoft.venta.proveedor;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.DistritoMiniBeanData;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ProveedorBeanFuncion;

@SessionScoped

public class AccionAgregarProveedor extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					//TrasladoBeanFuncion trasladoFuncion= TrasladoBeanFuncion.getInstance();
					//TrasladoBeanData trasladoData=trasladoFuncion.crearTraslado(request, response);

					ProveedorBeanFuncion proveedorFuncion= ProveedorBeanFuncion.getInstanceS();
					ProveedorBeanData proveedorData=proveedorFuncion.crearProveedor(request, response);
					//socioData.setIdMembresia("MEM000032");
					proveedorFuncion.agregarProveedor(proveedorData);
					
					
					request.setAttribute("proveedor", proveedorData);

					this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/buscarproveedor.jsp");
					//request.setAttribute("typeahead7",codigo);
				
				}
				ProveedorBeanFuncion proveedorFunction= ProveedorBeanFuncion.getInstanceS();
				Vector<DistritoMiniBeanData> distritoMiniData=proveedorFunction.getDistritos();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				
				
				request.setAttribute("tiposDistrito",distritoMiniData);
				
				this.direccionar(sc, request, response,"/IngSoft/ventas/proveedor/agregarproveedor.jsp");
				}
}
