package IngSoft.venta.bean;

import java.io.Serializable;

public class CriterioFamiliarBeanData implements Serializable{

	private String codigo;
	private String socio;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String parentesco;
	private long dni;
	private long telefono;
	private String correo;
	private String tipoDocumento;
	
	
	public String getSocio() {
		return socio;
	}
	
	public void setSocio(String socio) {
		this.socio = socio;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
