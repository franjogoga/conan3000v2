package IngSoft.venta.bean;

import java.io.Serializable;

public class UsuarioBeanData implements Serializable{
	
	private String codPerfil;
	private String codUsuario;
	private String descripcion;
	private String estado;
	private String nombUsuario;
	private String contrase�a;
	private String codSocio;
	
	public String getCodPerfil() {
		return codPerfil;
	}
	
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNombUsuario() {
		return nombUsuario;
	}
	
	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public String getCodSocio() {
		return codSocio;
	}
	
	public void setCodSocio(String codSocio) {
		this.codSocio = codSocio;
	}

}
