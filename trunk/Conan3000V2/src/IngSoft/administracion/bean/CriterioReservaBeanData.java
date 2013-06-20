package IngSoft.administracion.bean;
import java.io.Serializable;
import java.util.Date;

public class CriterioReservaBeanData implements Serializable{
	
	String codigosocio;
	String codigoinvitado;
	Date fechainvitacion;
	double monto;
	String estado;
	
	public String getCodigosocio() {
		return codigosocio;
	}
	public void setCodigosocio(String codigosocio) {
		this.codigosocio = codigosocio;
	}
	public String getCodigoinvitado() {
		return codigoinvitado;
	}
	public void setCodigoinvitado(String codigoinvitado) {
		this.codigoinvitado = codigoinvitado;
	}
	public Date getFechainvitacion() {
		return fechainvitacion;
	}
	public void setFechainvitacion(Date fechainvitacion) {
		this.fechainvitacion = fechainvitacion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}