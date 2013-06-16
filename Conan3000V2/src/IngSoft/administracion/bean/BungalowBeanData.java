package IngSoft.administracion.bean;

import java.io.Serializable;

public class BungalowBeanData implements Serializable{
	
	private String codigo;
	private String idAmbiente;
	private Integer numero;
	private String estado;
	private Integer numeroDivisiones;
	private Double areaBungalow;
	private String descripcion;
	private String idSede;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getNumeroDivisiones() {
		return numeroDivisiones;
	}
	public void setNumeroDivisiones(Integer numeroDivisiones) {
		this.numeroDivisiones = numeroDivisiones;
	}
	public Double getAreaBungalow() {
		return areaBungalow;
	}
	public void setAreaBungalow(Double areaBungalow) {
		this.areaBungalow = areaBungalow;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
}
