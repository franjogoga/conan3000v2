package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class ResultadoReservaBeanData implements Serializable{
	
	private String codigo;
	private String codigosocio;
	private String codigoinvitado;
	private Date fechainvitacion;
	private double monto;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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
