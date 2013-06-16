package IngSoft.administracion.bean;

import java.io.Serializable;

public class CriterioCanchaBeanData implements Serializable{
	private String nombre;
	private String idTipoCancha;
	private String idAmbiente;
	private String idSede;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdTipoCancha() {
		return idTipoCancha;
	}
	public void setIdTipoCancha(String idTipoCancha) {
		this.idTipoCancha = idTipoCancha;
	}
	public String getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
}
