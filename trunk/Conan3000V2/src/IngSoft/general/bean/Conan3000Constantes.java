package IngSoft.general.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.EventoBeanFuncion;

public class Conan3000Constantes implements Serializable {
	private double montoInvitado;
	private double costoXm2Bungalow;
	private double costoReservaCancha;
	private double precioMembresia;
	//private Date fecha;
	private double montoMultaFalta;
	private double precioSalonPrincipal;
	private String codigo;
	public static Integer step=60;
	private static Conan3000Constantes constantes=null;
	
	private Conan3000Constantes(){}
	
	public static Conan3000Constantes getInstance(){
	        
	       SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	       constantes=(Conan3000Constantes)sqlsesion.selectOne("Data.general.constantes.getConstantes");
	       sqlsesion.close();	       
	       return constantes;
	   }

	public double getMontoInvitado() {
		return montoInvitado;
	}

	public void setMontoInvitado(double montoInvitado) {
		this.montoInvitado = montoInvitado;
	}

	public double getCostoXm2Bungalow() {
		return costoXm2Bungalow;
	}

	public void setCostoXm2Bungalow(double costoXm2Bungalow) {
		this.costoXm2Bungalow = costoXm2Bungalow;
	}

	public double getCostoReservaCancha() {
		return costoReservaCancha;
	}

	public void setCostoReservaCancha(double costoReservaCancha) {
		this.costoReservaCancha = costoReservaCancha;
	}

	public double getPrecioMembresia() {
		return precioMembresia;
	}

	public void setPrecioMembresia(double precioMembresia) {
		this.precioMembresia = precioMembresia;
	}

//	public double getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(double fecha) {
//		this.fecha = fecha;
//	}

	public double getMontoMultaFalta() {
		return montoMultaFalta;
	}

	public void setMontoMultaFalta(double montoMultaFalta) {
		this.montoMultaFalta = montoMultaFalta;
	}

	public double getPrecioSalonPrincipal() {
		return precioSalonPrincipal;
	}

	public void setPrecioSalonPrincipal(double precioSalonPrincipal) {
		this.precioSalonPrincipal = precioSalonPrincipal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static Conan3000Constantes getConstantes() {
		return constantes;
	}

	public static void setConstantes(Conan3000Constantes constantes) {
		Conan3000Constantes.constantes = constantes;
	}
	
	
	
}
