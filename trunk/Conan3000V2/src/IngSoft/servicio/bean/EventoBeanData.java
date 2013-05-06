package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class EventoBeanData implements Serializable{
	
	private String codigo;
	private String nombre;
	private String idTipo;
	private String[] idSede;
	private String[] idAmbientes;
	private Date limiteInicio;
	private Date limiteFin;
	
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
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public String[] getIdSede() {
		return idSede;
	}
	public void setIdSede(String[] idSede) {
		this.idSede = idSede;
	}
	public String[] getIdAmbientes() {
		return idAmbientes;
	}
	public void setIdAmbientes(String[] idAmbientes) {
		this.idAmbientes = idAmbientes;
	}
	public Date getLimiteInicio() {
		return limiteInicio;
	}
	public void setLimiteInicio(Date limiteInicio) {
		this.limiteInicio = limiteInicio;
	}
	public Date getLimiteFin() {
		return limiteFin;
	}
	public void setLimiteFin(Date limiteFin) {
		this.limiteFin = limiteFin;
	}
	
	
	
}
