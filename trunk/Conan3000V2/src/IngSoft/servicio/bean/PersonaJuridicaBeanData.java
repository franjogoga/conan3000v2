package IngSoft.servicio.bean;

import java.io.Serializable;

//
public class PersonaJuridicaBeanData implements Serializable{
	private String codigo;
	private String razonSocial;
	private long ruc;
	private String direccion;
	private long telefono;
	
	
	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	private String correo;
	private String estado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String data) {
		this.codigo = data;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public long getRuc() {
		return ruc;
	}

	public void setRuc(long ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String Estado) {
		this.estado = Estado;
	}

}
