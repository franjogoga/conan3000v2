package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioAmbienteBeanData implements Serializable{
	private String nombre;
	private String idTipoAmbiente;
	private String idSede;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdTipoAmbiente() {
		return idTipoAmbiente;
	}
	public void setIdTipoAmbiente(String idTipoAmbiente) {
		this.idTipoAmbiente = idTipoAmbiente;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
}
