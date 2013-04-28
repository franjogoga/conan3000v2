package IngSoft.servicio.bean;

import java.util.Date;

public class EventoBeanData {
	
	private int codigo;
	private String nombre;
	private int idTipo;
	private String idSede;
	private String idAmbientes;
	private Date limiteInicio;
	private Date limiteFin;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdAmbientes() {
		return idAmbientes;
	}
	public void setIdAmbientes(String idAmbientes) {
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
