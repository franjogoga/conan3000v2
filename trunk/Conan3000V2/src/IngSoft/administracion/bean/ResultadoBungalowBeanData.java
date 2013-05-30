package IngSoft.administracion.bean;

import java.io.Serializable;

public class ResultadoBungalowBeanData implements Serializable{
	private String codigo;
	private Integer numero;
	private Integer numeroDivisiones;
	private Double areaBungalow;
	private String ambiente;
	private String estado;
	private String sede;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
}
