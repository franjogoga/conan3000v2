package IngSoft.administracion.bean;

import java.io.Serializable;

public class CriterioBungalowBeanData implements Serializable{
	private Integer numero;
	private Integer numeroDivisiones;
	private Double areaBungalow;
	private String idAmbiente;
	private String idSede;
	
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
	public String getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(String idSede) {
		this.idAmbiente = idSede;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
}
