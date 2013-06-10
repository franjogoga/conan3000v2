package IngSoft.administracion.bean;

import java.io.Serializable;

public class ResultadoConcesionarioBeanData implements Serializable{
	private String codigo;
	private String razonSocial; 
	private long ruc;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}