package Club.servicio.reserva;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.ReservaBeanFuncion;
@SessionScoped
public class AccionEliminarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			HttpSession sesion= request.getSession(true);
			Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
			listareservas=listareservas==null?new Vector<String>():listareservas;
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("idsocio", sesion.getAttribute("idSocio").toString());
			map.put("list", listareservas);
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				List<String> temp=sqlsesion.selectList("Data.servicio.reserva.verificarEliminarReservaBungalow", map);
				listareservas.removeAll(new Vector<String>(temp));
			}
			catch(Exception e){
				e.printStackTrace();				
			}
			finally{
				sqlsesion.close();
			}
			//String codSocio=request.getParameter("txtIdSocio");
			if(listareservas.size()>0){
				ReservaBeanFuncion reservaFuncion=ReservaBeanFuncion.getInstance();
				//reservaFuncion.agregarReservaBungalow(listareservas,codSocio);
				reservaFuncion.eliminarResevaBungalow(listareservas);
				sesion.removeAttribute("reservas");
				sesion.removeAttribute("listareservas");								
			}
		}
		if(tipo==3){
			HttpSession sesion= request.getSession(true);
			Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
			listareservas=listareservas==null?new Vector<String>():listareservas;
			//String codSocio=request.getParameter("txtIdSocio");
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("idsocio", sesion.getAttribute("idSocio").toString());
			map.put("list", listareservas);
			try{
				List<String> temp=sqlsesion.selectList("Data.servicio.reserva.verificarEliminarReservaCancha", map);
				listareservas.removeAll(new Vector<String>(temp));
			}
			catch(Exception e){
				e.printStackTrace();				
			}
			finally{
				sqlsesion.close();
			}
			if(listareservas.size()>0){
				ReservaBeanFuncion reservaFuncion=ReservaBeanFuncion.getInstance();
				//reservaFuncion.agregarReservaCancha(listareservas,codSocio);
				reservaFuncion.eliminarResevaCancha(listareservas);
				sesion.removeAttribute("reservas");
				sesion.removeAttribute("listareservas");								
			}
		}
	}
		

	}


