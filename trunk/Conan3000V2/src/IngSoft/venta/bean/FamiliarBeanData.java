package IngSoft.venta.bean;

import java.io.Serializable;

public class FamiliarBeanData implements Serializable{
	
	private String codigoFamiliar;
	private String codigoSocio;
	private String parentesco;
	private long telefonoFijo;
	private long telefonoCelular;
	private String correo;
	private String estado;
	private Integer flag;
	
	public String getCodigoFamiliar() {
		return codigoFamiliar;
	}
	
	public void setCodigoFamiliar(String codigoFamiliar) {
		this.codigoFamiliar = codigoFamiliar;
	}
	
	public String getCodigoSocio() {
		return codigoSocio;
	}
	
	public void setCodigoSocio(String codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	
	public String getParentesco() {
		return parentesco;
	}
	
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	public long getTelefonoFijo() {
		return telefonoFijo;
	}
	
	public void setTelefonoFijo(long telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	public long getTelefonoCelular() {
		return telefonoCelular;
	}
	
	public void setTelefonoCelular(long telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
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
	
	public void setEstado(String estado) {
		this.estado = estado;
	}	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
