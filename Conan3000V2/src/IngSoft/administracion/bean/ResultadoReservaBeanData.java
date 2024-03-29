package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class ResultadoReservaBeanData implements Serializable{
	
	private String codigo;
	private String codigosocio;
	private String nombresocio;
	private String apaternosocio;
	private String amaternosocio;
	private String codigoinvitado;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String dni;	
	private Date fechaingreso;
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
	public String getNombresocio() {
		return nombresocio;
	}
	public void setNombresocio(String nombresocio) {
		this.nombresocio = nombresocio;
	}
	public String getApaternosocio() {
		return apaternosocio;
	}
	public void setApaternosocio(String apaternosocio) {
		this.apaternosocio = apaternosocio;
	}
	public String getAmaternosocio() {
		return amaternosocio;
	}
	public void setAmaternosocio(String amaternosocio) {
		this.amaternosocio = amaternosocio;
	}
	public String getCodigoinvitado() {
		return codigoinvitado;
	}
	public void setCodigoinvitado(String codigoinvitado) {
		this.codigoinvitado = codigoinvitado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
}
