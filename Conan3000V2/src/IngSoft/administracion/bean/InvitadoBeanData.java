package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class InvitadoBeanData implements Serializable {
	private String codigo;
	private String nombre;
	private String estado;
	private String apellidoP;
	private String apellidoM;
	private String tipoDoc;
	private String numDoc;
	private Date fechaNac;
	private Date fechaReg;
	private String correo;
	private String telFijo;
	private String telCel;

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelFijo() {
		return telFijo;
	}
	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}
	public String getTelCel() {
		return telCel;
	}
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}
	

	
	
	
	

}
